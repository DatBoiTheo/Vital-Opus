package net.dbt.vitalopus.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dbt.vitalopus.item.LightningHarvesterItem;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.joml.Matrix4f;

import java.util.Random;

import static net.dbt.vitalopus.VitalOpus.MOD_ID;

@EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
public class LightningHarvesterRenderer {

    @SubscribeEvent
    public static void onRenderLevel(RenderLevelStageEvent event) {
        if (event.getStage() != RenderLevelStageEvent.Stage.AFTER_PARTICLES) return;

        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null) return;

        ItemStack held = player.getMainHandItem();
        if (!(held.getItem() instanceof LightningHarvesterItem)) return;

        if (mc.hitResult == null || mc.hitResult.getType() != HitResult.Type.BLOCK) return;
        if (!mc.options.keyAttack.isDown()) return;

        BlockHitResult blockHit = (BlockHitResult) mc.hitResult;
        Vec3 targetPos = Vec3.atCenterOf(blockHit.getBlockPos());

        Camera camera = event.getCamera();
        Vec3 camPos = camera.getPosition();

        float partialTick = event.getPartialTick().getGameTimeDeltaPartialTick(true);
        Vec3 handPos = player.getEyePosition(partialTick)
                .add(player.getLookAngle().scale(0.5));

        PoseStack poseStack = event.getPoseStack();
        MultiBufferSource.BufferSource bufferSource = mc.renderBuffers().bufferSource();

        poseStack.pushPose();
        poseStack.translate(-camPos.x, -camPos.y, -camPos.z);

        renderLightningBeam(poseStack, bufferSource, handPos, targetPos);

        poseStack.popPose();
        bufferSource.endBatch(RenderType.lightning());
    }

    private static void renderLightningBeam(PoseStack poseStack, MultiBufferSource bufferSource,
                                            Vec3 from, Vec3 to) {
        VertexConsumer vc = bufferSource.getBuffer(RenderType.lightning());
        Matrix4f matrix = poseStack.last().pose();
        Random rand = new Random();

        Vec3 delta = to.subtract(from);
        double length = delta.length();
        int segments = (int)(length * 6);
        double segLen = 1.0 / segments;

        Vec3 prev = from;
        for (int i = 1; i <= segments; i++) {
            double t = i * segLen;
            // Interpolate along the beam with jitter
            Vec3 next = from.add(delta.scale(t));
            if (i < segments) {
                next = next.add(
                        (rand.nextDouble() - 0.5) * 0.2,
                        (rand.nextDouble() - 0.5) * 0.2,
                        (rand.nextDouble() - 0.5) * 0.2
                );
            }

            // Draw a quad along the segment
            float width = 0.03f;
            vc.addVertex(matrix, (float)(prev.x + width), (float)prev.y, (float)prev.z)
                    .setColor(0x66, 0xCC, 0xFF, 200)
                    .setUv(0, 0).setLight(LightTexture.FULL_BRIGHT);
            vc.addVertex(matrix, (float)(prev.x - width), (float)prev.y, (float)prev.z)
                    .setColor(0x66, 0xCC, 0xFF, 200)
                    .setUv(1, 0).setLight(LightTexture.FULL_BRIGHT);
            vc.addVertex(matrix, (float)(next.x - width), (float)next.y, (float)next.z)
                    .setColor(0x66, 0xCC, 0xFF, 200)
                    .setUv(1, 1).setLight(LightTexture.FULL_BRIGHT);
            vc.addVertex(matrix, (float)(next.x + width), (float)next.y, (float)next.z)
                    .setColor(0x66, 0xCC, 0xFF, 200)
                    .setUv(0, 1).setLight(LightTexture.FULL_BRIGHT);

            prev = next;
        }
    }
}

package net.dbt.vitalopus.client;

import com.mojang.blaze3d.vertex.*;
import net.dbt.vitalopus.item.LightningHarvesterItem;
import net.dbt.vitalopus.mining.MiningTier;
import net.dbt.vitalopus.mining.ModAttachments;
import net.dbt.vitalopus.particle.ModParticles;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import com.mojang.blaze3d.systems.RenderSystem;
import org.joml.Matrix4f;

import java.util.Random;

import static net.dbt.vitalopus.VitalOpus.MOD_ID;

@EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
public class LightningHarvesterRenderer {

    @SubscribeEvent
    public static void onArmSwing(InputEvent.InteractionKeyMappingTriggered event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;
        ItemStack held = mc.player.getMainHandItem();
        if (held.getItem() instanceof LightningHarvesterItem) {
            event.setSwingHand(false);
        }
    }

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

        // --- Tier color logic ---
        int r = 0xDA, g = 0xCD, b = 0x69; // default: your original yellow-gold
        SimpleParticleType particleType = ParticleTypes.WAX_ON;

        if (mc.level != null) {
            BlockState targeted = mc.level.getBlockState(blockHit.getBlockPos());
            int playerTier = player.getData(ModAttachments.MINING_TIER);
            int diff = MiningTier.tierDifference(targeted, playerTier);

            if (diff == 1) {
                // One tier above player: red
                r = 0xFF;
                g = 0x30;
                b = 0x30;

                particleType = ModParticles.LIGHTNINGHARVESTERTIER2PARTICLE.get();
            }
        }

        Camera camera = event.getCamera();
        Vec3 camPos = camera.getPosition();

        float partialTick = event.getPartialTick().getGameTimeDeltaPartialTick(true);
        Vec3 handPos = player.getEyePosition(partialTick)
                .add(player.getLookAngle().scale(1));

        PoseStack poseStack = new PoseStack();
        poseStack.translate(-camPos.x, -camPos.y, -camPos.z);

        renderLightningBeam(mc, poseStack, handPos, targetPos, r, g, b, particleType);
    }

    private static void renderLightningBeam(Minecraft mc, PoseStack poseStack,
                                            Vec3 from, Vec3 to,
                                            int r, int g, int b, SimpleParticleType particleType) {
        Random rand = new Random();

        if (rand.nextFloat() < 0.05f) {
            mc.level.addParticle(particleType,
                    from.x, from.y, from.z,
                    0.1f, 0.1f, 0.1f);
        }

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableDepthTest();
        RenderSystem.setShader(GameRenderer::getPositionColorShader);

        BufferBuilder buffer = Tesselator.getInstance().begin(
                VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);

        Matrix4f matrix = poseStack.last().pose();

        Vec3 delta = to.subtract(from);
        double length = delta.length();
        int segments = (int) (length * 6);
        double segLen = 1.0 / segments;
        float width = 0.06f;

        Vec3 prev = from;
        for (int i = 1; i <= segments; i++) {
            double t = i * segLen;
            Vec3 next = from.add(delta.scale(t));
            if (i < segments) {
                next = next.add(
                        (rand.nextDouble() - 0.5) * 0.2,
                        (rand.nextDouble() - 0.5) * 0.2,
                        (rand.nextDouble() - 0.5) * 0.2);
            }

            buffer.addVertex(matrix, (float) (prev.x + width), (float) prev.y, (float) prev.z).setColor(r, g, b, 200);
            buffer.addVertex(matrix, (float) (prev.x - width), (float) prev.y, (float) prev.z).setColor(r, g, b, 200);
            buffer.addVertex(matrix, (float) (next.x - width), (float) next.y, (float) next.z).setColor(r, g, b, 200);
            buffer.addVertex(matrix, (float) (next.x + width), (float) next.y, (float) next.z).setColor(r, g, b, 200);

            prev = next;
        }

        BufferUploader.drawWithShader(buffer.buildOrThrow());

        RenderSystem.enableDepthTest();
    }
}
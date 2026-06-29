package net.dbt.vitalopus.handlers;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.vertex.PoseStack;
import net.dbt.vitalopus.item.BlowerBuilderItem;
import net.dbt.vitalopus.item.LightningHarvesterItem;
import net.dbt.vitalopus.item.VacuumToolItem;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import org.joml.Matrix4f;

import static net.dbt.vitalopus.VitalOpus.MOD_ID;

@EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class ClientEventHandlers {

    @SubscribeEvent
    public static void onRenderLevel(RenderLevelStageEvent event) {
        if (event.getStage() != RenderLevelStageEvent.Stage.AFTER_PARTICLES) return;

        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null || mc.player == null) return;

        Camera camera = event.getCamera();
        Vec3 camPos = camera.getPosition();

        PoseStack poseStack = new PoseStack();
        MultiBufferSource.BufferSource bufferSource = mc.renderBuffers().bufferSource();

        for (ItemEntity itemEntity : mc.level.getEntitiesOfClass(ItemEntity.class,
                mc.player.getBoundingBox().inflate(32))) {

            ItemStack stack = itemEntity.getItem();
            Item item = stack.getItem();

            if (item instanceof DiggerItem || item instanceof SwordItem ||
                item instanceof ArmorItem || item instanceof TridentItem ||
                item instanceof MaceItem || item instanceof ProjectileWeaponItem ||
                item instanceof ShieldItem || item instanceof ElytraItem ||
                item instanceof FishingRodItem || item instanceof ShearsItem ||
                item instanceof FlintAndSteelItem || item instanceof SpyglassItem ||
                item instanceof BrushItem) continue;

            int kg = stack.getCount() * 10;
            Component text = Component.literal(kg + " kg");

            double x = itemEntity.getX() - camPos.x;
            double y = itemEntity.getY() - camPos.y + 1;
            double z = itemEntity.getZ() - camPos.z;

            poseStack.pushPose();
            poseStack.translate(x, y, z);
            poseStack.scale(-0.025f, -0.025f, 0.025f);

            Matrix4f matrix = poseStack.last().pose();

            mc.font.drawInBatch(text,
                    -mc.font.width(text) / 2f, 0f,
                    0xFFFFFF, false,
                    matrix, bufferSource,
                    Font.DisplayMode.SEE_THROUGH, 0x000000, LightTexture.FULL_BRIGHT);

            poseStack.popPose();


            poseStack.pushPose();
            poseStack.translate(x, y, z);
            poseStack.scale(0.025f, -0.025f, 0.025f);

            Matrix4f matrix2 = poseStack.last().pose();

            mc.font.drawInBatch(text,
                    -mc.font.width(text) / 2f, 0f,
                    0xFFFFFF, false,
                    matrix2, bufferSource,
                    Font.DisplayMode.SEE_THROUGH, 0x000000, LightTexture.FULL_BRIGHT);

            poseStack.popPose();
        }
        bufferSource.endBatch();
    }
    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();

        if (item instanceof DiggerItem || item instanceof SwordItem ||
                item instanceof ArmorItem || item instanceof TridentItem ||
                item instanceof MaceItem || item instanceof ProjectileWeaponItem ||
                item instanceof ShieldItem || item instanceof ElytraItem ||
                item instanceof FishingRodItem || item instanceof ShearsItem ||
                item instanceof FlintAndSteelItem || item instanceof SpyglassItem ||
                item instanceof BrushItem) return;

        int kg = stack.getCount() * 10;
        event.getToolTip().add(Component.literal(kg + " kg"));
    }
    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null) return;

        boolean usingTool = player.isUsingItem() &&
                (player.getUseItem().getItem() instanceof VacuumToolItem ||
                        player.getUseItem().getItem() instanceof BlowerBuilderItem);

        boolean miningWithHarvester = player.getMainHandItem().getItem() instanceof LightningHarvesterItem
                && InputConstants.isKeyDown(
                Minecraft.getInstance().getWindow().getWindow(),
                mc.options.keyAttack.getKey().getValue()
        );

        if (!usingTool && !miningWithHarvester) return;

        mc.options.keyUp.setDown(false);
        mc.options.keyDown.setDown(false);
        mc.options.keyLeft.setDown(false);
        mc.options.keyRight.setDown(false);
        mc.options.keyJump.setDown(false);
        mc.options.keySprint.setDown(false);
    }
}
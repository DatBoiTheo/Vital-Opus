package net.dbt.vitalopus.mining;

import net.dbt.vitalopus.data.ModDataComponents;
import net.dbt.vitalopus.item.LightningHarvesterItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import static net.dbt.vitalopus.VitalOpus.MOD_ID;

@EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class MiningEventHandler {

    // 2.75^(1/3) — three upgrade steps from tier 1 to tier 4
    private static final double SPEED_MULTIPLIER_PER_TIER = Math.pow(2.75, 1.0 / 3.0);

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();

        if (!(player.getMainHandItem().getItem() instanceof LightningHarvesterItem)) return;

        BlockState state = event.getState();
        Block block = state.getBlock();

        if (!(block instanceof LightningHarvesterTier tieredBlock)) return;

        int requiredTier = tieredBlock.getRequiredHarvesterTier();
        int playerTier = player.getData(ModAttachments.MINING_TIER); // use attachment, not static constant

        if (playerTier < requiredTier) {
            event.setCanceled(true);
            player.displayClientMessage(
                    Component.literal("§cThis material requires harvester tier " + (requiredTier + 1) + "!"),
                    true
            );
        }
    }

    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        Player player = event.getEntity();

        if (!(player.getMainHandItem().getItem() instanceof LightningHarvesterItem)) return;
    }
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        // PlayerTickEvent extends EntityEvent, so getEntity() returns the player
        if (!(event.getEntity() instanceof Player player)) return;

        // Only run server-side to avoid double-writing
        if (player.level().isClientSide()) return;

        ItemStack held = player.getMainHandItem();
        if (!(held.getItem() instanceof LightningHarvesterItem)) return;

        int playerTier = player.getData(ModAttachments.MINING_TIER);
        Integer currentComponent = held.get(ModDataComponents.HARVESTER_TIER.get());

        if (currentComponent == null || currentComponent != playerTier) {
            held.set(ModDataComponents.HARVESTER_TIER.get(), playerTier);
        }
    }
}
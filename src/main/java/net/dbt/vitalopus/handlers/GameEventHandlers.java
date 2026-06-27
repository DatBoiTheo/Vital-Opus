package net.dbt.vitalopus.handlers;

import net.dbt.vitalopus.item.BlowerBuilderItem;
import net.dbt.vitalopus.item.LightningHarvesterItem;
import net.dbt.vitalopus.item.VacuumToolItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static net.dbt.vitalopus.VitalOpus.MOD_ID;

@EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class GameEventHandlers {

    @SubscribeEvent
    public static void onLevelTick(LevelTickEvent.Post event) {
        if (event.getLevel().isClientSide()) return;
        ServerLevel level = (ServerLevel) event.getLevel();

        for (ServerPlayer player : level.players()) {
            boolean vacuumActive = player.isUsingItem() &&
                    player.getUseItem().getItem() instanceof VacuumToolItem;

            for (ItemEntity itemEntity : level.getEntitiesOfClass(ItemEntity.class,
                    player.getBoundingBox().inflate(16))) {

                if (vacuumActive && VacuumToolItem.isReadyForPickup(itemEntity.getUUID())) {
                    itemEntity.setPickUpDelay(0);
                } else {
                    itemEntity.setPickUpDelay(2);
                }
            }
        }
    }
    public static final Set<UUID> miningPlayers = new HashSet<>();

    @SubscribeEvent
    public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        Player player = event.getEntity();
        if (!(player.getMainHandItem().getItem() instanceof LightningHarvesterItem)) return;
        miningPlayers.add(player.getUUID());
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        if (player.level().isClientSide()) return;

        boolean usingTool = player.isUsingItem() &&
                (player.getUseItem().getItem() instanceof VacuumToolItem ||
                        player.getUseItem().getItem() instanceof BlowerBuilderItem);
        boolean miningWithHarvester = miningPlayers.contains(player.getUUID());

        // Clear mining state each tick — LeftClickBlock re-adds it if still mining
        miningPlayers.remove(player.getUUID());

        AttributeInstance speedAttr = player.getAttribute(Attributes.MOVEMENT_SPEED);
        if (speedAttr == null) return;

        ResourceLocation modifierId = ResourceLocation.fromNamespaceAndPath(MOD_ID, "tool_lock");
        AttributeModifier lockModifier = new AttributeModifier(modifierId, -1.0, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);

        if (usingTool || miningWithHarvester) {
            if (!speedAttr.hasModifier(modifierId)) {
                speedAttr.addTransientModifier(lockModifier);
            }
            player.setJumping(false);
        } else {
            speedAttr.removeModifier(modifierId);
        }
    }

}
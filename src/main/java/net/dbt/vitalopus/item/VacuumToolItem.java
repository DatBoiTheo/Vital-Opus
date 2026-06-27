package net.dbt.vitalopus.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.*;

public class VacuumToolItem extends Item {

    private static final Set<UUID> readyForPickup = new HashSet<>();
    private static final Map<UUID, Integer> pickupProgress = new HashMap<>();
    private static final int PICKUP_TICKS = 100;
    private static UUID lastTarget = null;

    public static boolean isReadyForPickup(UUID id) {
        return readyForPickup.contains(id);
    }

    public VacuumToolItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        Vec3 look = player.getLookAngle();
        Vec3 eyePos = player.getEyePosition(1.0f);

        for (ItemEntity itemEntity : level.getEntitiesOfClass(ItemEntity.class,
                player.getBoundingBox().inflate(9))) {
            Vec3 toItem = itemEntity.position().subtract(eyePos);
            double along = toItem.dot(look);
            if (along < 0 || along > 8.0) continue;

            Vec3 projected = eyePos.add(look.scale(along));
            double perpDist = itemEntity.position().distanceTo(projected);
            if (perpDist > 1.0) continue;

            // Found a valid target — start using
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(player.getItemInHand(hand));
        }

        // No valid target in range — don't start the animation
        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }

    @Override
    public void onUseTick(Level level, LivingEntity entity, ItemStack stack, int remainingUseDuration) {
        if (!(entity instanceof Player player)) return;
        if (level.isClientSide) return;

        Vec3 look = player.getLookAngle();
        Vec3 eyePos = player.getEyePosition(1.0f);

        ItemEntity target = null;
        double closestDist = Double.MAX_VALUE;

        for (ItemEntity itemEntity : level.getEntitiesOfClass(ItemEntity.class,
                player.getBoundingBox().inflate(9))) {
            Vec3 toItem = itemEntity.position().subtract(eyePos);
            double along = toItem.dot(look);
            if (along < 0 || along > 8.0) continue;

            Vec3 projected = eyePos.add(look.scale(along));
            double perpDist = itemEntity.position().distanceTo(projected);
            if (perpDist > 1.0) continue;

            double dist = itemEntity.position().distanceTo(eyePos);
            if (dist < closestDist) {
                closestDist = dist;
                target = itemEntity;
            }
        }

        if (target == null) {
            pickupProgress.clear();
            readyForPickup.clear();
            lastTarget = null;
            player.stopUsingItem();
            return;
        }

        UUID targetId = target.getUUID();

        if (!targetId.equals(lastTarget)) {
            pickupProgress.clear();
            readyForPickup.clear();
            lastTarget = targetId;
            player.stopUsingItem();
            player.startUsingItem(player.getUsedItemHand());
            return;
        }

        target.setDeltaMovement(Vec3.ZERO);
        target.setNoGravity(true);

        int progress = pickupProgress.getOrDefault(targetId, 0) + 1;
        pickupProgress.put(targetId, progress);

        if (progress >= PICKUP_TICKS) {
            target.setNoGravity(false);
            target.setPickUpDelay(0);
            target.playerTouch(player);

            pickupProgress.remove(targetId);
            readyForPickup.remove(targetId);
            lastTarget = null;

            player.stopUsingItem();
        }
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeCharged) {
        if (level.isClientSide) return;
        // Player released early — unfreeze items and reset
        if (entity instanceof Player player) {
            for (ItemEntity itemEntity : level.getEntitiesOfClass(ItemEntity.class,
                    player.getBoundingBox().inflate(9))) {
                itemEntity.setNoGravity(false);
            }
        }
        pickupProgress.clear();
        readyForPickup.clear();
        lastTarget = null;
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 72000; // Large enough that animation runs freely
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }
}
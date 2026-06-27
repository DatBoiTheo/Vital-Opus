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

public class VacuumToolItem extends Item {
    private static final int RANGE = 8;

    public VacuumToolItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(player.getItemInHand(hand));
    }

    @Override
    public void onUseTick(Level level, LivingEntity entity, ItemStack stack, int remainingUseDuration) {
        if (!(entity instanceof Player player)) return;
        if (level.isClientSide) return;

        Vec3 look = player.getLookAngle();
        Vec3 eyePos = player.getEyePosition(1.0f);
        Vec3 handPos = new Vec3(player.getX(), player.getY() + 1.0, player.getZ());

        ItemEntity target = null;
        double closestDist = Double.MAX_VALUE;

        for (ItemEntity itemEntity : level.getEntitiesOfClass(ItemEntity.class,
                player.getBoundingBox().inflate(3))) {
            Vec3 toItem = itemEntity.position().subtract(eyePos);
            double along = toItem.dot(look);
            if (along < 0 || along > 2.0) continue;

            Vec3 projected = eyePos.add(look.scale(along));
            double perpDist = itemEntity.position().distanceTo(projected);
            if (perpDist > 1.0) continue;

            double dist = itemEntity.position().distanceTo(eyePos);
            if (dist < closestDist) {
                closestDist = dist;
                target = itemEntity;
            }
        }

        if (target == null) return;

        // Pull toward hand position not feet
        Vec3 direction = handPos.subtract(target.position()).normalize();
        target.setDeltaMovement(direction.scale(0.4));

        if (target.distanceTo(player) < 1.5) {
            target.playerTouch(player);
        }
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 72000;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }
}

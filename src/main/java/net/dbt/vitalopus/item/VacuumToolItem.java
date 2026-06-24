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
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class VacuumToolItem extends Item {
    private static final int RANGE = 8;

    public VacuumToolItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.startUsingItem(hand); // Enables the "holding use" state
        return InteractionResultHolder.consume(player.getItemInHand(hand));
    }

    @Override
    public void onUseTick(Level level, LivingEntity entity, ItemStack stack, int remainingUseDuration) {
        if (!(entity instanceof Player player)) return;
        if (level.isClientSide) return;

        // Pull nearby item entities toward the player
        AABB searchBox = new AABB(player.blockPosition()).inflate(RANGE);
        List<ItemEntity> items = level.getEntitiesOfClass(ItemEntity.class, searchBox);

        for (ItemEntity itemEntity : items) {
            Vec3 direction = player.position().subtract(itemEntity.position()).normalize();
            double speed = 0.4;
            itemEntity.setDeltaMovement(direction.scale(speed));

            // Pick it up if close enough
            if (itemEntity.distanceTo(player) < 1.5) {
                itemEntity.playerTouch(player);
            }
        }
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 72000; // Effectively infinite
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW; // Keeps the arm raised
    }
}

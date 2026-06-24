package net.dbt.vitalopus.item;

import net.dbt.vitalopus.data.ModDataComponents;
import net.dbt.vitalopus.data.SchematicData;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class BlowerBuilderItem extends Item {
    private static final String PROGRESS_KEY = "PlacementIndex";

    public BlowerBuilderItem(Item.Properties properties) {
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

        SchematicData schematic = stack.get(ModDataComponents.SCHEMATIC.get());
        if (schematic == null || schematic.blocks().isEmpty()) return;

        // Get current placement progress from NBT
        CompoundTag tag = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag();
        int index = tag.getInt(PROGRESS_KEY);

        if (index >= schematic.blocks().size()) return; // Done

        SchematicData.BlockInfo info = schematic.blocks().get(index);
        BlockPos worldPos = player.blockPosition().offset(info.relativePos());

        // Place the block if the space is free
        if (level.getBlockState(worldPos).isAir()) {
            level.setBlock(worldPos, info.state(), 3);

            // Spawn outward particles at the placed block (send to clients)
            Vec3 center = Vec3.atCenterOf(worldPos);
            ((ServerLevel) level).sendParticles(ParticleTypes.CLOUD,
                    center.x, center.y, center.z,
                    10, 0.3, 0.3, 0.3, 0.1);
        }

        // Advance placement index
        tag.putInt(PROGRESS_KEY, index + 1);
        stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
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

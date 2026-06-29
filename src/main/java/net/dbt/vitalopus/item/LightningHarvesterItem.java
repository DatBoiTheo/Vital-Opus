package net.dbt.vitalopus.item;

import net.dbt.vitalopus.data.ModDataComponents;
import net.dbt.vitalopus.mining.LightningHarvesterTier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class LightningHarvesterItem extends PickaxeItem {

    public enum HarvesterTier implements Tier {
        TIER_1(1.0909f),
        TIER_2(1.5306f),
        TIER_3(2.1474f),
        TIER_4(3.0f);

        private final float speed;
        HarvesterTier(float speed) { this.speed = speed; }

        public static HarvesterTier fromIndex(int index) {
            HarvesterTier[] values = values();
            return values[Math.clamp(index, 0, values.length - 1)];
        }

        @Override public int getUses()                { return Integer.MAX_VALUE; }
        @Override public float getSpeed()             { return speed; }
        @Override public float getAttackDamageBonus() { return 0f; }
        @Override public TagKey<Block> getIncorrectBlocksForDrops() { return BlockTags.INCORRECT_FOR_WOODEN_TOOL; }
        @Override public int getEnchantmentValue()    { return 0; }
        @Override public Ingredient getRepairIngredient() { return Ingredient.EMPTY; }
    }

    public LightningHarvesterItem(Tier tier, Item.Properties properties) {
        super(tier, properties);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        // Non-tiered blocks: only apply speed if it's a block we can actually affect
        if (!(state.getBlock() instanceof LightningHarvesterTier)
                && !state.is(BlockTags.MINEABLE_WITH_PICKAXE)) {
            return 1.0f;
        }

        int tierIndex = stack.getOrDefault(ModDataComponents.HARVESTER_TIER.get(), 0);
        return HarvesterTier.fromIndex(tierIndex).getSpeed();
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.NONE;
    }
}
package net.dbt.vitalopus.mining;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

/**
 * A DropExperienceBlock that also declares a required harvester tier.
 * Use this in ModBlocks wherever you want tier-gating.
 */
public class TieredBlock extends DropExperienceBlock implements LightningHarvesterTier {

    private final int requiredTier;

    public TieredBlock(int requiredTier, BlockBehaviour.Properties properties) {
        super(UniformInt.of(0, 0), properties);
        this.requiredTier = requiredTier;
    }

    @Override
    public int getRequiredHarvesterTier() {
        return requiredTier;
    }
}
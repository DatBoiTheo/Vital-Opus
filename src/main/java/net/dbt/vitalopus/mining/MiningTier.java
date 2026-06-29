package net.dbt.vitalopus.mining;

import net.dbt.vitalopus.block.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class MiningTier {

    // Returns the required player tier to mine this block (0 = anyone can mine)
    public static int getRequiredTier(BlockState state) {
        Block block = state.getBlock();

        // Tier 0 — anyone can mine (dirt, wood, stone, etc.)
        // Tier 1 — needs first upgrade
        if (block == ModBlocks.BLOCK_OF_GRANITE.get()) return 1;
        if (block == ModBlocks.BLOCK_OF_ABYSSALITE.get()) return 2;
        if (block == ModBlocks.BLOCK_OF_SLIME.get()) return 0;

        // Tier 2 — needs second upgrade
        // if (block == ModBlocks.SOME_HARDER_BLOCK.get()) return 2;

        return 0; // default: no restriction
    }

    // How far above the player's tier is this block?
    // 0 = within reach, 1+ = one or more tiers above (beam turns red)
    public static int tierDifference(BlockState state, int playerTier) {
        return getRequiredTier(state) - playerTier;
    }
}
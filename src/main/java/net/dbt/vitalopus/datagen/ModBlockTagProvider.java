package net.dbt.vitalopus.datagen;

import net.dbt.vitalopus.VitalOpus;
import net.dbt.vitalopus.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, VitalOpus.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BLOCK_OF_ALGAE.get())
                .add(ModBlocks.BLOCK_OF_FERTILIZER.get())
                .add(ModBlocks.BLOCK_OF_SAND.get())
                .add(ModBlocks.BLOCK_OF_COPPER_ORE.get())
                .add(ModBlocks.BLOCK_OF_SANDSTONE.get())
                .add(ModBlocks.BLOCK_OF_GRANITE.get())
                .add(ModBlocks.BLOCK_OF_DIRT.get())
                .add(ModBlocks.BLOCK_OF_SLIME.get())
                .add(ModBlocks.BLOCK_OF_ABYSSALITE.get())
                .add(ModBlocks.BLOCK_OF_IGNEOUS_ROCK.get())
                .add(ModBlocks.BLOCK_OF_CLAY.get())
                .add(ModBlocks.BLOCK_OF_GOLD_AMALGAM.get());
    }
}

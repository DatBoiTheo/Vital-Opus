package net.dbt.vitalopus.datagen;

import net.dbt.vitalopus.VitalOpus;
import net.dbt.vitalopus.block.ModBlocks;
import net.minecraft.data.PackOutput;

import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;


public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper){
        super(output, VitalOpus.MOD_ID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels(){
        blockWithItem(ModBlocks.BLOCK_OF_ALGAE);
        blockWithItem(ModBlocks.BLOCK_OF_FERTILIZER);
        blockWithItem(ModBlocks.BLOCK_OF_SAND);
        blockWithItem(ModBlocks.BLOCK_OF_SANDSTONE);
        blockWithItem(ModBlocks.BLOCK_OF_COPPER_ORE);
        blockWithItem(ModBlocks.BLOCK_OF_GRANITE);
        blockWithItem(ModBlocks.BLOCK_OF_DIRT);
        blockWithItem(ModBlocks.BLOCK_OF_SLIME);
        blockWithItem(ModBlocks.BLOCK_OF_ABYSSALITE);
        blockWithItem(ModBlocks.BLOCK_OF_CLAY);
        blockWithItem(ModBlocks.BLOCK_OF_IGNEOUS_ROCK);
        blockWithItem(ModBlocks.BLOCK_OF_GOLD_AMALGAM);

        blockWithItem(ModBlocks.STEEL_BLOCK);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}

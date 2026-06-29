package net.dbt.vitalopus.datagen;

import net.dbt.vitalopus.block.ModBlocks;
import net.dbt.vitalopus.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries){
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate(){
        dropSelf(ModBlocks.BLOCK_OF_ALGAE.get());

        add(ModBlocks.BLOCK_OF_ALGAE.get(),
                block -> createMultipleOreDropsBasic(ModBlocks.BLOCK_OF_ALGAE.get(),
                        ModItems.ALGAE_ITEM.get(), 9, 9));
        add(ModBlocks.BLOCK_OF_FERTILIZER.get(),
                block -> createMultipleOreDropsBasic(ModBlocks.BLOCK_OF_FERTILIZER.get(),
                        ModItems.FERTILIZER_ITEM.get(), 2, 3));
        add(ModBlocks.BLOCK_OF_SAND.get(),
                block -> createMultipleOreDropsBasic(ModBlocks.BLOCK_OF_SAND.get(),
                        ModItems.SAND_ITEM.get(), 45, 47));
        add(ModBlocks.BLOCK_OF_SANDSTONE.get(),
                block -> createMultipleOreDropsBasic(ModBlocks.BLOCK_OF_SANDSTONE.get(),
                        ModItems.SANDSTONE_ITEM.get(), 35, 92));
        add(ModBlocks.BLOCK_OF_DIRT.get(),
                block -> createMultipleOreDropsBasic(ModBlocks.BLOCK_OF_DIRT.get(),
                        ModItems.DIRT_ITEM.get(), 82, 92));
        add(ModBlocks.BLOCK_OF_GRANITE.get(),
                block -> createMultipleOreDropsBasic(ModBlocks.BLOCK_OF_GRANITE.get(),
                        ModItems.GRANITE_ITEM.get(), 1, 1));
        add(ModBlocks.BLOCK_OF_COPPER_ORE.get(),
                block -> createMultipleOreDropsBasic(ModBlocks.BLOCK_OF_COPPER_ORE.get(),
                        ModItems.COPPER_ORE_ITEM.get(), 15, 16));
        add(ModBlocks.BLOCK_OF_SLIME.get(),
                block -> createMultipleOreDropsBasic(ModBlocks.BLOCK_OF_SLIME.get(),
                        ModItems.SLIME_ITEM.get(), 10, 10));
    }
    protected LootTable.Builder createMultipleOreDropsFortExplBon(Block pBlock, Item item, float minDrops, float maxDrops){
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }
    protected LootTable.Builder createMultipleOreDropsBasic(Block pBlock, Item item, float minDrops, float maxDrops){
        return LootTable.lootTable().withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}


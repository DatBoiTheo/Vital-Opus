package net.dbt.vitalopus.item;

import net.dbt.vitalopus.VitalOpus;
import net.dbt.vitalopus.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VitalOpus.MOD_ID);

    public static final Supplier<CreativeModeTab> VITAL_OPUS_ITEMS_TAB = CREATIVE_MODE_TAB.register("vital_opus_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.WATERDROP.get()))
                    .title(Component.translatable("creativetab.vitalopus.vital_opus_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                      output.accept(ModItems.ALGAE_ITEM);
                      output.accept(ModItems.WATERDROP);
                      output.accept(ModItems.DRIED_WATERDROP);
                      output.accept(ModItems.CARBON_DIOXIDE_ITEM);
                      output.accept(ModItems.CERAMIC_ITEM);
                      output.accept(ModItems.CHLORINE_ITEM);
                      output.accept(ModItems.DIAMOND_ITEM);
                      output.accept(ModItems.DIRT_ITEM);
                      output.accept(ModItems.GENETIC_OOZE_ITEM);
                      output.accept(ModItems.GRANITE_ITEM);
                      output.accept(ModItems.HYDROGEN_ITEM);
                      output.accept(ModItems.OBSIDIAN_ITEM);
                      output.accept(ModItems.OXYGEN_ITEM);
                      output.accept(ModItems.POLLUTED_DIRT_ITEM);
                      output.accept(ModItems.REGOLITH_ITEM);
                      output.accept(ModItems.SAND_ITEM);
                      output.accept(ModItems.SANDSTONE_ITEM);
                      output.accept(ModItems.SNOW_ITEM);
                      output.accept(ModItems.SULFUR_ITEM);
                      output.accept(ModItems.SUPER_COOLANT_ITEM);
                      output.accept(ModItems.COPPER_ORE_ITEM);
                      output.accept(ModItems.SLIME_ITEM);
                      output.accept(ModItems.OXYLITE_ITEM);
                      output.accept(ModItems.FERTILIZER_ITEM);
                      output.accept(ModItems.GOLD_AMALGAM_ITEM);
                      output.accept(ModItems.ABYSSALITE_ITEM);
                      output.accept(ModItems.CLAY_ITEM);
                      output.accept(ModItems.IGNEOUS_ROCK_ITEM);
                    }).build());

    public static final Supplier<CreativeModeTab> VITAL_OPUS_BLOCKS_TAB = CREATIVE_MODE_TAB.register("vital_opus_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BLOCK_OF_ALGAE)) // choose tab icon
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(VitalOpus.MOD_ID, "vital_opus_items_tab")) // determines what tab comes before this tab, which means the items come before the machines
                    .title(Component.translatable("creativetab.vitalopus.vital_opus_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.BLOCK_OF_OXYLITE);
                        output.accept(ModBlocks.BLOCK_OF_ALGAE);
                        output.accept(ModBlocks.BLOCK_OF_COPPER_ORE);
                        output.accept(ModBlocks.BLOCK_OF_FERTILIZER);
                        output.accept(ModBlocks.BLOCK_OF_SAND);
                        output.accept(ModBlocks.BLOCK_OF_SANDSTONE);
                        output.accept(ModBlocks.BLOCK_OF_DIRT);
                        output.accept(ModBlocks.BLOCK_OF_GRANITE);
                        output.accept(ModBlocks.BLOCK_OF_SLIME);
                        output.accept(ModBlocks.BLOCK_OF_ABYSSALITE);
                        output.accept(ModBlocks.BLOCK_OF_GOLD_AMALGAM);
                        output.accept(ModBlocks.BLOCK_OF_CLAY);
                        output.accept(ModBlocks.BLOCK_OF_IGNEOUS_ROCK);
                        output.accept(ModBlocks.BLOCK_OF_DIAMOND);
                    }).build());

    public static final Supplier<CreativeModeTab> VITAL_OPUS_MACHINES_TAB = CREATIVE_MODE_TAB.register("vital_opus_machines_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.STEEL_BLOCK)) // choose tab icon
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(VitalOpus.MOD_ID, "vital_opus_blocks_tab")) // determines what tab comes before this tab, which means the items come before the machines
                    .title(Component.translatable("creativetab.vitalopus.vital_opus_machines"))
                    .displayItems((itemDisplayParameters, output) -> {
                      output.accept(ModBlocks.STEEL_BLOCK);
                      output.accept(ModItems.VACUUM_TOOL);
                      output.accept(ModItems.BLOWER_BUILDER);
                      output.accept(ModItems.LIGHTNING_HARVESTER);
                      output.accept(ModItems.PLANT_RANCHER);
                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}

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
                      output.accept(ModItems.WATERDROP);
                      output.accept(ModItems.DRIED_WATERDROP);
                      output.accept(ModBlocks.OXYLITE);
                      output.accept(ModItems.ALGAE);
                      output.accept(ModItems.CARBON_DIOXIDE);
                      output.accept(ModItems.CERAMIC);
                      output.accept(ModItems.CHLORINE);
                      output.accept(ModItems.DIAMOND);
                      output.accept(ModItems.DIRT);
                      output.accept(ModItems.GENETIC_OOZE);
                      output.accept(ModItems.GRANITE);
                      output.accept(ModItems.HYDROGEN);
                      output.accept(ModItems.OBSIDIAN);
                      output.accept(ModItems.OXYGEN);
                      output.accept(ModItems.POLLUTED_DIRT);
                      output.accept(ModItems.REGOLITH);
                      output.accept(ModItems.SAND);
                      output.accept(ModItems.SANDSTONE);
                      output.accept(ModItems.SNOW);
                      output.accept(ModItems.SULFUR);
                      output.accept(ModItems.SUPER_COOLANT);
                    }).build());

    public static final Supplier<CreativeModeTab> VITAL_OPUS_MACHINES_TAB = CREATIVE_MODE_TAB.register("vital_opus_machines_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.STEEL_BLOCK)) // choose tab icon
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(VitalOpus.MOD_ID, "vital_opus_items_tab")) // determines what tab comes before this tab, which means the items come before the machines
                    .title(Component.translatable("creativetab.vitalopus.vital_opus_machines"))
                    .displayItems((itemDisplayParameters, output) -> {
                      output.accept(ModBlocks.STEEL_BLOCK);
                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}

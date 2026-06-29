package net.dbt.vitalopus.datagen;

import net.dbt.vitalopus.VitalOpus;
import net.dbt.vitalopus.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, VitalOpus.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels(){
        basicItem(ModItems.WATERDROP.get());
        basicItem(ModItems.DRIED_WATERDROP.get());

        basicItem(ModItems.LIGHTNING_HARVESTER.get());
        basicItem(ModItems.BLOWER_BUILDER.get());
        basicItem(ModItems.VACUUM_TOOL.get());

        basicItem(ModItems.ALGAE_ITEM.get());
        basicItem(ModItems.CARBON_DIOXIDE.get());
        basicItem(ModItems.CERAMIC.get());
        basicItem(ModItems.CHLORINE.get());
        basicItem(ModItems.DIAMOND.get());
        basicItem(ModItems.DIRT_ITEM.get());
        basicItem(ModItems.GENETIC_OOZE.get());
        basicItem(ModItems.GRANITE_ITEM.get());
        basicItem(ModItems.HYDROGEN.get());
        basicItem(ModItems.OBSIDIAN.get());
        basicItem(ModItems.OXYGEN.get());
        basicItem(ModItems.POLLUTED_DIRT.get());
        basicItem(ModItems.REGOLITH.get());
        basicItem(ModItems.SAND_ITEM.get());
        basicItem(ModItems.SANDSTONE_ITEM.get());
        basicItem(ModItems.FERTILIZER_ITEM.get());
        basicItem(ModItems.COPPER_ORE_ITEM.get());
        basicItem(ModItems.SNOW.get());
        basicItem(ModItems.SULFUR.get());
        basicItem(ModItems.SUPER_COOLANT.get());
        basicItem(ModItems.SLIME_ITEM.get());

        basicItem(ModItems.MEAL_LICE.get());
        basicItem(ModItems.BURIED_MUCKROOT_SEED.get());
        basicItem(ModItems.MUSH_BAR.get());
        basicItem(ModItems.MUSH_FRY.get());
        basicItem(ModItems.NUTRIENT_BAR.get());
        basicItem(ModItems.RAW_EGG.get());
        basicItem(ModItems.SLEET_WHEAT_SEED.get());
    }
}

//public static final DeferredItem<Item> SLEET_WHEAT_SEED = ITEMS.register("sleet_wheat_seed",
//        () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                .nutrition(1)
//                .saturationModifier(1f)
//                .build())));

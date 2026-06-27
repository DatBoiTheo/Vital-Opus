package net.dbt.vitalopus.item;

import net.dbt.vitalopus.VitalOpus;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(VitalOpus.MOD_ID);

    public static final DeferredItem<Item> LIGHTNING_HARVESTER = ITEMS.register("lightning_harvester",
            () -> new LightningHarvesterItem(Tiers.NETHERITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(Tiers.NETHERITE, 0f, -2.8f))));
    public static final DeferredItem<Item> VACUUM_TOOL = ITEMS.register("vacuum_tool",
            () -> new VacuumToolItem(new Item.Properties()));
    public static final DeferredItem<Item> BLOWER_BUILDER = ITEMS.register("blower_builder",
            () -> new BlowerBuilderItem(new Item.Properties()));

    public static final DeferredItem<Item> WATERDROP = ITEMS.register("waterdrop",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DRIED_WATERDROP = ITEMS.register("dried_waterdrop",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ALGAE_ITEM = ITEMS.register("algae_item",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CARBON_DIOXIDE = ITEMS.register("carbon_dioxide",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CERAMIC = ITEMS.register("ceramic",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHLORINE = ITEMS.register("chlorine",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND = ITEMS.register("diamond",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DIRT = ITEMS.register("dirt",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GENETIC_OOZE = ITEMS.register("genetic_ooze",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GRANITE = ITEMS.register("granite",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> HYDROGEN = ITEMS.register("hydrogen",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> OBSIDIAN = ITEMS.register("obsidian",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> OXYGEN = ITEMS.register("oxygen",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> POLLUTED_DIRT = ITEMS.register("polluted_dirt",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> REGOLITH = ITEMS.register("regolith",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SAND = ITEMS.register("sand",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SANDSTONE = ITEMS.register("sandstone",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SNOW = ITEMS.register("snow",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SULFUR = ITEMS.register("sulfur",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SUPER_COOLANT = ITEMS.register("super_coolant",
            () -> new Item(new Item.Properties()));

        public static final DeferredItem<Item> MEAL_LICE = ITEMS.register("meal_lice",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationModifier(1f)
                    .build())));
        public static final DeferredItem<Item> BURIED_MUCKROOT_SEED = ITEMS.register("buried_muckroot_seed",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationModifier(1f)
                    .build())));
        public static final DeferredItem<Item> MUSH_BAR = ITEMS.register("mush_bar",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationModifier(1f)
                    .build())));
    public static final DeferredItem<Item> MUSH_FRY = ITEMS.register("mush_fry",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationModifier(1f)
                    .build())));
        public static final DeferredItem<Item> NUTRIENT_BAR = ITEMS.register("nutrient_bar",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationModifier(1f)
                    .build())));
        public static final DeferredItem<Item> RAW_EGG = ITEMS.register("raw_egg",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationModifier(1f)
                    .build())));
        public static final DeferredItem<Item> SLEET_WHEAT_SEED = ITEMS.register("sleet_wheat_seed",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationModifier(1f)
                    .build())));





//    public static final DeferredItem<Item> BARBEQUE = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> BERRY_SLUDGE = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> BOG_JELLY = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> BRISTLE_BERRY = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> COOKED_SEAFOOD = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> CURRIED_BEANS = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> FRIED_MUSHROOM = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> FROST_BUN = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> FROST_BURGER = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> GAMMA_MUSH = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> GRISTLE_BERRY = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> GRUBFRUIT = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> GRUBRFRUIT_PRESERVE = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> HEXALENT_FRUIT = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> LETTUCE = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> LICELOAF = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));

//    public static final DeferredItem<Item> MEAT = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> MIXED_BERRY_PIE = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));


//    public static final DeferredItem<Item> MUSHROOM = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> MUSHROOM_WRAP = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> NOSH_BEAN = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));

//    public static final DeferredItem<Item> OMELETTE = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> PACU_FILLET = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> PEPPER_BREAD = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> PICKLED_MEAL = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> PINCHA_PEPPERNUT = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> PLANT_MEAT = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));

//    public static final DeferredItem<Item> RAW_SHELLFISH = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> ROAST_GRUBFRUIT_NUT = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));

//    public static final DeferredItem<Item> SPICY_TOFU = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> SPINDLY_GRUBFRUIT = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> STUFFED_BERRY = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> SURFNTURF = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> SWAMP_CHARD_HEART = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> SWAMPY_DELIGHTS = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//    public static final DeferredItem<Item> TOFU = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
//                    .nutrition(1)
//                    .saturationModifier(1f)
//                    .build())));
//
//    public static final DeferredItem<Item> LONGHAIR_LARVA_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> DRECKLET_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> GLOSSY_DRECKLET_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> GRUBGRUB_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> SHOVE_VOLE_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> DELECTA_VOLE_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> LARVA_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> MOLTEN_LARVA_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> PIP_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> CUDDLE_PIP_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> SLUG_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> PINCH_ROE = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> SANI_PINCH_ROE = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> STONE_HATCHLING_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> SAGE_HATCHLING_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> SMOOTH_HATCHLING_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> HATCHLING_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> OAK_PINCH_ROE = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> PUFTLET_PRINCE_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> SQUEAKY_PUFTLET_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> PUFTLET_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> DENSE_PUFTLET_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> ABYSS_NYMPH_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> RADIANT_NYMPH_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> SWEETLE_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> ROYAL_NYMPH_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> CORAL_NYMPH_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> AZURE_NYMPH_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> SHINE_NYMPH_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> SUN_NYMPH_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> GULP_FRY_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> FRY_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));
//    public static final DeferredItem<Item> TROPICAL_FRY_EGG = ITEMS.register("dried_waterdrop",
//            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}

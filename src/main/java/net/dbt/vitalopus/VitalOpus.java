package net.dbt.vitalopus;

import com.mojang.logging.LogUtils;
import net.dbt.vitalopus.block.ModBlocks;
import net.dbt.vitalopus.item.ModCreativeModeTabs;
import net.dbt.vitalopus.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(VitalOpus.MOD_ID)
public class VitalOpus {
    public static final String MOD_ID = "vitalopus";
    public static final Logger LOGGER = LogUtils.getLogger();

    public VitalOpus(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS)
        {
            event.accept(ModItems.WATERDROP);
            event.accept(ModItems.DRIED_WATERDROP);
        }
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS)
        {
            event.accept(ModItems.MEAL_LICE);
            event.accept(ModItems.BURIED_MUCKROOT_SEED);
            event.accept(ModItems.MUSH_BAR);
            event.accept(ModItems.MUSH_FRY);
            event.accept(ModItems.NUTRIENT_BAR);
            event.accept(ModItems.RAW_EGG);
            event.accept(ModItems.SLEET_WHEAT_SEED);
        }
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
        {
            event.accept(ModBlocks.STEEL_BLOCK);
            event.accept(ModBlocks.OXYLITE);
        }
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES)
        {
            event.accept(ModItems.LIGHTNING_HARVESTER);
            event.accept(ModItems.BLOWER_BUILDER);
            event.accept(ModItems.VACUUM_TOOL);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}

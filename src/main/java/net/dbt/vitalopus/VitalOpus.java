package net.dbt.vitalopus;

import com.mojang.logging.LogUtils;
import net.dbt.vitalopus.block.ModBlocks;
import net.dbt.vitalopus.data.ModDataComponents;
import net.dbt.vitalopus.item.ModCreativeModeTabs;
import net.dbt.vitalopus.item.ModItems;
import net.dbt.vitalopus.mining.ModAttachments;
import net.dbt.vitalopus.particle.LightningHarvesterParticleTier2;
import net.dbt.vitalopus.particle.ModParticles;
import net.dbt.vitalopus.worldgen.ModFeatures;
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
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
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
        ModFeatures.FEATURES.register(modEventBus);
        ModAttachments.ATTACHMENT_TYPES.register(modEventBus);
        ModDataComponents.register(modEventBus);
        ModParticles.register(modEventBus);

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
            event.accept(ModBlocks.STEEL_BLOCK);
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
        public static void registerParticles(RegisterParticleProvidersEvent event) {
            event.registerSpriteSet(ModParticles.LIGHTNINGHARVESTERTIER2PARTICLE.get(),
                    LightningHarvesterParticleTier2.Provider::new);
        }

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}

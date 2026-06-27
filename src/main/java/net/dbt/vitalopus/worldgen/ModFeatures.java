package net.dbt.vitalopus.worldgen;

import net.dbt.vitalopus.VitalOpus;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registries.FEATURE, VitalOpus.MOD_ID);

    public static final DeferredHolder<Feature<?>, LargeVeinOreFeature> LARGE_VEIN_ORE =
            FEATURES.register("large_vein_ore", LargeVeinOreFeature::new);
}
package net.dbt.vitalopus.worldgen;

import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class LargeVeinOreFeature extends Feature<OreConfiguration> {
    private static final OreFeature ORE_FEATURE = new OreFeature(OreConfiguration.CODEC);

    public LargeVeinOreFeature() {
        super(OreConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<OreConfiguration> context) {
        RandomSource random = context.random();
        OreConfiguration config = context.config();

        int veinSize = 10 + random.nextInt(141);

        return ORE_FEATURE.place(
                new FeaturePlaceContext<>(
                        context.topFeature(),
                        context.level(),
                        context.chunkGenerator(),
                        random,
                        context.origin(),
                        new OreConfiguration(config.targetStates, veinSize)
                )
        );
    }
}
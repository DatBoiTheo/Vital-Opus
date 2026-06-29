package net.dbt.vitalopus.datagen;

import net.dbt.vitalopus.VitalOpus;
import net.dbt.vitalopus.particle.ModParticles;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.ParticleDescriptionProvider;

public class ModParticleDescriptionProvider extends ParticleDescriptionProvider {
    public ModParticleDescriptionProvider(PackOutput output, ExistingFileHelper fileHelper) {
        super(output, fileHelper);
    }

    @Override
    protected void addDescriptions() {
        sprite(ModParticles.LIGHTNINGHARVESTERTIER2PARTICLE.get(),
                net.minecraft.resources.ResourceLocation.fromNamespaceAndPath(
                        VitalOpus.MOD_ID, "lightningharvestertier2"));
    }
}
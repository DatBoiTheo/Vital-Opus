package net.dbt.vitalopus.particle;

import net.dbt.vitalopus.VitalOpus;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(Registries.PARTICLE_TYPE, VitalOpus.MOD_ID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LIGHTNINGHARVESTERTIER2 =
            PARTICLE_TYPES.register("lightningharvestertier2",
                    () -> new SimpleParticleType(false));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}
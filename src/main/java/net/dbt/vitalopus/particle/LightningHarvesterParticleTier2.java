package net.dbt.vitalopus.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

public class LightningHarvesterParticleTier2 extends TextureSheetParticle {

    protected LightningHarvesterParticleTier2(ClientLevel level, double x, double y, double z) {
        super(level, x, y, z);
        this.gravity = 0f;
        this.lifetime = 20;
        this.quadSize = 0.1f;
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level,
                                       double x, double y, double z,
                                       double dx, double dy, double dz) {
            LightningHarvesterParticleTier2 particle = new LightningHarvesterParticleTier2(level, x, y, z);
            particle.pickSprite(sprites);
            return particle;
        }
    }
}
package net.dbt.vitalopus.client;

import net.dbt.vitalopus.item.VacuumToolItem;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;

import java.util.Random;

import static net.dbt.vitalopus.VitalOpus.MOD_ID;

@EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
public class VacuumToolClient {

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null || mc.level == null) return;

        ItemStack activeItem = player.getUseItem();
        if (!(activeItem.getItem() instanceof VacuumToolItem)) return;

        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            double angle = rand.nextDouble() * Math.PI * 2;
            double radius = 4 + rand.nextDouble() * 4;
            double ox = Math.cos(angle) * radius;
            double oz = Math.sin(angle) * radius;
            double oy = (rand.nextDouble() - 0.5) * 4;

            double px = player.getX() + ox;
            double py = player.getY() + 1 + oy;
            double pz = player.getZ() + oz;

            double vx = -ox * 0.2;
            double vy = -oy * 0.2;
            double vz = -oz * 0.2;

            mc.level.addParticle(ParticleTypes.WHITE_ASH, px, py, pz, vx, vy, vz);
        }
    }
}

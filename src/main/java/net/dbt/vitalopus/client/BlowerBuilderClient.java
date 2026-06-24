package net.dbt.vitalopus.client;

import net.dbt.vitalopus.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.dbt.vitalopus.item.BlowerBuilderItem;

import java.util.Random;

import static net.dbt.vitalopus.VitalOpus.MOD_ID;

@EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
public class BlowerBuilderClient {

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null || mc.level == null) return;

        ItemStack activeItem = player.getUseItem();
        if (!(activeItem.getItem() instanceof BlowerBuilderItem)) return;

        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            // Spawn at the player, particles shoot OUTWARD
            double vx = (rand.nextDouble() - 0.5) * 0.5;
            double vy = rand.nextDouble() * 0.3;
            double vz = (rand.nextDouble() - 0.5) * 0.5;

            mc.level.addParticle(ParticleTypes.COMPOSTER,
                    player.getX(), player.getY() + 1, player.getZ(),
                    vx, vy, vz);
        }
    }
}

package net.dbt.vitalopus.client;

import net.dbt.vitalopus.item.VacuumToolItem;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;

import static net.dbt.vitalopus.VitalOpus.MOD_ID;

@EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
public class VacuumToolClient {

    private static double spiralAngle = 0;

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null || mc.level == null) return;

        ItemStack activeItem = player.getUseItem();
        if (!(activeItem.getItem() instanceof VacuumToolItem)) return;

        Vec3 look = player.getLookAngle();
        Vec3 eyePos = player.getEyePosition(1.0f);
        // Hand position — slightly below eye level
        Vec3 handPos = new Vec3(eyePos.x, eyePos.y - 0.3, eyePos.z);

        Vec3 right = look.cross(new Vec3(0, 1, 0)).normalize();
        Vec3 up = right.cross(look).normalize();

        // Find single closest item within 2 blocks in front
        ItemEntity target = null;
        double closestDist = Double.MAX_VALUE;

        for (ItemEntity itemEntity : mc.level.getEntitiesOfClass(ItemEntity.class,
                player.getBoundingBox().inflate(3))) {
            Vec3 itemPos = itemEntity.position();
            Vec3 toItem = itemPos.subtract(eyePos);
            double along = toItem.dot(look);
            if (along < 0 || along > 2.0) continue;

            Vec3 projected = eyePos.add(look.scale(along));
            double perpDist = itemPos.distanceTo(projected);
            if (perpDist > 1.0) continue;

            double dist = itemPos.distanceTo(eyePos);
            if (dist < closestDist) {
                closestDist = dist;
                target = itemEntity;
            }
        }

        if (target == null) return;

        spiralAngle += 0.6;

        // Direction from item toward player hand
        Vec3 itemPos = target.position();
        Vec3 beamDir = handPos.subtract(itemPos).normalize();
        Vec3 beamRight = beamDir.cross(new Vec3(0, 1, 0)).normalize();
        Vec3 beamUp = beamRight.cross(beamDir).normalize();

        for (int i = 0; i < 5; i++) {
            // Spawn from item position toward hand
            double distanceAlong = closestDist * (i / 5.0);
            double radius = 0.6 * (1.0 - (distanceAlong / closestDist)); // shrinks toward player
            double angle = spiralAngle + (i * (Math.PI * 2 / 5));

            double px = itemPos.x + beamDir.x * distanceAlong
                    + beamRight.x * Math.cos(angle) * radius
                    + beamUp.x * Math.sin(angle) * radius;
            double py = itemPos.y + beamDir.y * distanceAlong
                    + beamRight.y * Math.cos(angle) * radius
                    + beamUp.y * Math.sin(angle) * radius;
            double pz = itemPos.z + beamDir.z * distanceAlong
                    + beamRight.z * Math.cos(angle) * radius
                    + beamUp.z * Math.sin(angle) * radius;

            double dx = handPos.x - px;
            double dy = handPos.y - py;
            double dz = handPos.z - pz;
            double len = Math.sqrt(dx * dx + dy * dy + dz * dz);
            double speed = 0.5;

            mc.level.addParticle(ParticleTypes.WHITE_SMOKE,
                    px, py, pz,
                    (dx / len) * speed,
                    (dy / len) * speed,
                    (dz / len) * speed);
        }
    }
}
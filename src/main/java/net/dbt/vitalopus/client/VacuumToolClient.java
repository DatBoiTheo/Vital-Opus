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
        Vec3 handPos = new Vec3(eyePos.x, eyePos.y - 0.3, eyePos.z);

        // Find single closest item within 8 blocks in front
        ItemEntity target = null;
        double closestDist = Double.MAX_VALUE;

        for (ItemEntity itemEntity : mc.level.getEntitiesOfClass(ItemEntity.class,
                player.getBoundingBox().inflate(9))) {
            Vec3 itemPos = itemEntity.position();
            Vec3 toItem = itemPos.subtract(eyePos);
            double along = toItem.dot(look);
            if (along < 0 || along > 8.0) continue;

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

        Vec3 itemPos = target.position();

        // Use look direction as beam axis instead of item-to-hand vector
        // so the spiral always faces correctly regardless of vertical angle
        Vec3 beamDir = eyePos.subtract(itemPos).normalize();
        Vec3 worldUp = new Vec3(0, 1, 0);
        Vec3 beamRight = Math.abs(beamDir.dot(worldUp)) > 0.99
                ? beamDir.cross(new Vec3(1, 0, 0)).normalize()
                : beamDir.cross(worldUp).normalize();
        Vec3 beamUp = beamRight.cross(beamDir).normalize();

        for (int i = 0; i < 5; i++) {
            double distanceAlong = closestDist * (i / 5.0);
            double radius = 0.6 * (1.0 - (distanceAlong / closestDist));
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

            mc.level.addParticle(ParticleTypes.WHITE_SMOKE,
                    px, py, pz,
                    (dx / len) * 0.5,
                    (dy / len) * 0.5,
                    (dz / len) * 0.5);
        }
    }
}
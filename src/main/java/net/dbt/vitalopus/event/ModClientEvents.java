package net.dbt.vitalopus.event;

import net.dbt.vitalopus.VitalOpus;
import net.dbt.vitalopus.item.ModItems;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;

@EventBusSubscriber(modid = VitalOpus.MOD_ID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void onComputeFovModifierEvent(ComputeFovModifierEvent event) {
        Player player = event.getPlayer();
        if (!player.isUsingItem()) return;

        Item useItem = player.getUseItem().getItem();

        if (useItem == ModItems.BLOWER_BUILDER.get() ||
                useItem == ModItems.VACUUM_TOOL.get()) {
            event.setNewFovModifier(1.0f);
        }
    }
}

//public class ModClientEvents {
//    @SubscribeEvent
//    public static void onComputeFovModifierEvent(ComputeFovModifierEvent event){
//        if(event.getPlayer().isUsingItem() &&
//                (event.getPlayer().getUseItem().getItem() == ModItems.BLOWER_BUILDER.get())
//                || ((event.getPlayer().getUseItem().getItem() == ModItems.LIGHTNING_HARVESTER.get()
//                || ((event.getPlayer().getUseItem().getItem() == ModItems.VACUUM_TOOL.get())))))
//        {
//            float fovModifier = 0.5f;
//            int ticksUsingItem = event.getPlayer().getTicksUsingItem();
//            float deltaTicks = (float)ticksUsingItem / 20f;
//            if(deltaTicks > 0.5f){
//                deltaTicks = 0.5f;
//            } else{
//                deltaTicks *= deltaTicks;
//            }
//            fovModifier *= 0.5f - deltaTicks * 0.15f;
//            event.setNewFovModifier(fovModifier);
//        }
//
//    }
//}

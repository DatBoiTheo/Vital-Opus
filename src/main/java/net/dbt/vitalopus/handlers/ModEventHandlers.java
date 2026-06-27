package net.dbt.vitalopus.handlers;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;

import static net.dbt.vitalopus.VitalOpus.MOD_ID;

@EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventHandlers {

    @SubscribeEvent
    public static void modifyComponents(ModifyDefaultComponentsEvent event) {
        for (Item item : BuiltInRegistries.ITEM) {
            if (item.getDefaultInstance().isDamageableItem()) continue;
            if (item instanceof DiggerItem || item instanceof SwordItem ||
                    item instanceof ArmorItem || item instanceof TridentItem ||
                    item instanceof MaceItem || item instanceof ProjectileWeaponItem ||
                    item instanceof ShieldItem || item instanceof ElytraItem ||
                    item instanceof FishingRodItem || item instanceof ShearsItem ||
                    item instanceof FlintAndSteelItem || item instanceof SpyglassItem ||
                    item instanceof BrushItem) continue;

            event.modify(item, builder -> builder
                    .set(DataComponents.MAX_STACK_SIZE, 99));
        }
    }
}
package net.dbt.vitalopus;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import static net.dbt.vitalopus.VitalOpus.MOD_ID;

@EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventHandlers {

    @SubscribeEvent
    public static void modifyComponents(ModifyDefaultComponentsEvent event) {
        for (Item item : BuiltInRegistries.ITEM) {
            if (item instanceof DiggerItem) continue;
            if (item instanceof SwordItem) continue;
            if (item instanceof ArmorItem) continue;
            if (item instanceof BowItem) continue;
            if (item instanceof TridentItem) continue;
            if (item.getDefaultMaxStackSize() == 1) continue;

            event.modify(item, builder -> builder
                    .set(DataComponents.MAX_STACK_SIZE, 100));
        }
    }
    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();

        if (item instanceof DiggerItem) return;
        if (item instanceof SwordItem) return;
        if (item instanceof ArmorItem) return;

        int kg = stack.getCount() * 10;
        event.getToolTip().add(Component.literal(kg + " kg"));
    }
    @SubscribeEvent
    public static void onRenderNameTag(RenderNameTagEvent event) {
        if (!(event.getEntity() instanceof ItemEntity itemEntity)) return;

        ItemStack stack = itemEntity.getItem();
        Item item = stack.getItem();

        if (item instanceof DiggerItem) return;
        if (item instanceof SwordItem) return;
        if (item instanceof ArmorItem) return;

        int kg = stack.getCount() * 10;
        event.setContent(Component.literal(kg + " kg"));
    }
}
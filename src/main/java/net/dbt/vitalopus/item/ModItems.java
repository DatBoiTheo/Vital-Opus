package net.dbt.vitalopus.item;

import net.dbt.vitalopus.VitalOpus;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(VitalOpus.MOD_ID);

    public static final DeferredItem<Item> WATERDROP = ITEMS.register("waterdrop",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DRIED_WATERDROP = ITEMS.register("dried_waterdrop",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}

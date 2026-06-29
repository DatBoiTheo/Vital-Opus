package net.dbt.vitalopus.data;

import com.mojang.serialization.Codec;
import net.dbt.vitalopus.VitalOpus;
import net.minecraft.core.component.DataComponentType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;

public class ModDataComponents {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENTS =
            DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, VitalOpus.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> HARVESTER_TIER =
            DATA_COMPONENTS.register("harvester_tier",
                    () -> DataComponentType.<Integer>builder()
                            .persistent(Codec.INT)
                            .build());

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<SchematicData>>
            SCHEMATIC = DATA_COMPONENTS.register("schematic",
            () -> DataComponentType.<SchematicData>builder()
                    .persistent(SchematicData.CODEC)
                    .build());

    public static void register(IEventBus eventBus) {
        DATA_COMPONENTS.register(eventBus);
    }
}
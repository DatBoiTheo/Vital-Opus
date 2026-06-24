package net.dbt.vitalopus.data;

import net.dbt.vitalopus.VitalOpus;
import net.minecraft.core.component.DataComponentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;

public class ModDataComponents {

    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENTS =
            DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, VitalOpus.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<SchematicData>>
            SCHEMATIC = DATA_COMPONENTS.register("schematic",
            () -> DataComponentType.<SchematicData>builder()
                    .persistent(SchematicData.CODEC)
                    .build());
}
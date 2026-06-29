package net.dbt.vitalopus.mining;

import com.mojang.serialization.Codec;
import net.dbt.vitalopus.VitalOpus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModAttachments {

    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES =
            DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, VitalOpus.MOD_ID);

    // Stores the player's current mining tier (0 = base, 1 = tier 2, 2 = tier 3...)
    // copyOnDeath keeps the skill on respawn, serialize persists it across sessions
    public static final Supplier<AttachmentType<Integer>> MINING_TIER =
            ATTACHMENT_TYPES.register("mining_tier",
                    () -> AttachmentType.builder(() -> 0)
                            .serialize(Codec.INT)
                            .copyOnDeath()
                            .build());
    public static final Supplier<AttachmentType<Boolean>> STARTER_KIT_GIVEN =
            ATTACHMENT_TYPES.register("starter_kit_given",
                    () -> AttachmentType.builder(() -> false)
                            .serialize(Codec.BOOL)
                            .build());
}
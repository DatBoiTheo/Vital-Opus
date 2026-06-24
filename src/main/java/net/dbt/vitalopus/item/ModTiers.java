package net.dbt.vitalopus.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModTiers {
    public static final Tier VITALOPUS_TIER = new SimpleTier(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            500,    // durability
            6.0f,   // mining speed
            2.0f,   // attack damage bonus
            15,     // enchantability
            () -> Ingredient.of(Items.IRON_INGOT)
    );
}
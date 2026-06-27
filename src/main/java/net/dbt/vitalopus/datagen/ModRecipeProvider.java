package net.dbt.vitalopus.datagen;

import net.dbt.vitalopus.block.ModBlocks;
import net.dbt.vitalopus.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> SMELTABLES = List.of(ModItems.WATERDROP);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WATERDROP.get())
                .pattern("DDD")
                .pattern("DWD")
                .pattern("DDD")
                .define('D', ModItems.DRIED_WATERDROP.get())
                .define('W', Items.WATER_BUCKET.asItem())
                .unlockedBy("has_waterdrop", has(ModItems.DRIED_WATERDROP))
                .unlockedBy("has_waterbucket", has(Items.WATER_BUCKET)).save(recipeOutput, "vitalopus:dried_waterdrop_from_waterbucket");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WATERDROP.get(), 9)
                .requires(Items.WATER_BUCKET)
                .unlockedBy("has_waterbucket", has(Items.WATER_BUCKET)).save(recipeOutput, "vitalopus:waterdrop_from_waterbucket");

        oreSmelting(recipeOutput, SMELTABLES, RecipeCategory.MISC, ModItems.DRIED_WATERDROP.get(), 1, 10, "water");
    }
}

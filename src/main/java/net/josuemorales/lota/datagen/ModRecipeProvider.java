package net.josuemorales.lota.datagen;

import net.josuemorales.lota.LegendsOfTheAncientsMod;
import net.josuemorales.lota.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
//    private static final List<ItemLike> SAPPHIRE_SMELTABLES = List.of(ModItems.RAW_SAPPHIRE.get());

    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    protected static void oreSmelting(
            @NotNull RecipeOutput pRecipeOutput,
            List<ItemLike> pIngredients,
            @NotNull RecipeCategory pCategory,
            @NotNull ItemLike pResult,
            float pExperience,
            int pCookingTime,
            @NotNull String pGroup) {
        oreCooking(
                pRecipeOutput,
                RecipeSerializer.SMELTING_RECIPE,
                SmeltingRecipe::new,
                pIngredients,
                pCategory,
                pResult,
                pExperience,
                pCookingTime,
                pGroup,
                "_from_smelting");
    }

    private static <T extends AbstractCookingRecipe> void oreCooking(
            RecipeOutput pRecipeOutput,
            RecipeSerializer<T> pSerializer,
            AbstractCookingRecipe.Factory<T> pRecipeFactory,
            List<ItemLike> pIngredients,
            RecipeCategory pCategory,
            ItemLike pResult,
            float pExperience,
            int pCookingTime,
            String pGroup,
            String pSuffix) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder
                    .generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime,
                            pSerializer, pRecipeFactory)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, LegendsOfTheAncientsMod.MOD_ID + ":" + getItemName(pResult) + pSuffix
                            + "_" + getItemName(itemlike));
        }
    }

    protected static void oreBlasting(
            @NotNull RecipeOutput pRecipeOutput,
            List<ItemLike> pIngredients,
            @NotNull RecipeCategory pCategory,
            @NotNull ItemLike pResult,
            float pExperience,
            int pCookingTime,
            @NotNull String pGroup) {
        oreCooking(pRecipeOutput,
                RecipeSerializer.BLASTING_RECIPE,
                BlastingRecipe::new,
                pIngredients,
                pCategory,
                pResult,
                pExperience,
                pCookingTime,
                pGroup,
                "_from_blasting");
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput pRecipeOutput) {
//        oreBlasting(pRecipeOutput, SAPPHIRE_SMELTABLES, RecipeCategory.MISC,
//                ModItems.SAPPHIRE.get(), 0.25f, 100, "sapphire");
//        oreSmelting(pRecipeOutput, SAPPHIRE_SMELTABLES, RecipeCategory.MISC,
//                ModItems.SAPPHIRE.get(), 0.25f, 200, "sapphire");

        // Sapphire to Sapphire Block
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get())
//                .pattern("SSS")
//                .pattern("SSS")
//                .pattern("SSS")
//                .define('S', ModItems.SAPPHIRE.get())
//                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
//                .save(pRecipeOutput);

        // Raw Sapphire to Raw Sapphire Block
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_SAPPHIRE_BLOCK.get())
//                .pattern("SSS")
//                .pattern("SSS")
//                .pattern("SSS")
//                .define('S', ModItems.RAW_SAPPHIRE.get())
//                .unlockedBy(getHasName(ModItems.RAW_SAPPHIRE.get()), has(ModItems.RAW_SAPPHIRE.get()))
//                .save(pRecipeOutput);

        // Raw Sapphire from Raw Sapphire Block
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_SAPPHIRE.get(), 9)
//                .requires(ModBlocks.RAW_SAPPHIRE_BLOCK.get())
//                .unlockedBy(getHasName(ModBlocks.RAW_SAPPHIRE_BLOCK.get()),
//                        has(ModBlocks.RAW_SAPPHIRE_BLOCK.get()))
//                .save(pRecipeOutput);

        // Creating a Sapphire Rod
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SAPPHIRE_ROD.get(), 1)
//                .pattern("#")
//                .pattern("#")
//                .pattern("#")
//                .define('#', ModItems.SAPPHIRE.get())
//                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
//                .save(pRecipeOutput);

        // Sapphire Sword
//        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SAPPHIRE_SWORD.get(), 1)
//                .pattern("#")
//                .pattern("#")
//                .pattern("S")
//                .define('#', ModItems.SAPPHIRE.get())
//                .define('S', Items.STICK)
//                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
//                .save(pRecipeOutput);

        // Rune stone fragments to Rune Stone
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RUNE_STONE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.RUNE_STONE_FRAGMENT.get())
                .unlockedBy(getHasName(ModItems.RUNE_STONE_FRAGMENT.get()), has(ModItems.RUNE_STONE_FRAGMENT.get()))
                .save(pRecipeOutput);

    }


}

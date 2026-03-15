package net.yxiao233.ifs.datagen;

import com.buuz135.industrial.module.ModuleAgricultureHusbandry;
import com.buuz135.industrial.module.ModuleCore;
import com.buuz135.industrial.module.ModuleResourceProduction;
import com.buuz135.industrial.module.ModuleTool;
import com.buuz135.industrial.recipe.DissolutionChamberRecipe;
import com.buuz135.industrial.utils.IndustrialTags;
import com.hrznstudio.titanium.recipe.generator.TitaniumShapedRecipeBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;
import net.yxiao233.ifs.common.registry.IFSBlocks;
import net.yxiao233.ifs.common.registry.IFSItems;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class RecipeGen extends RecipeProvider {
    public RecipeGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        DissolutionChamberRecipe simulatedMobDuplicatorRecipe = new DissolutionChamberRecipe(List.of(
                Ingredient.of(ModuleAgricultureHusbandry.MOB_DUPLICATOR),
                Ingredient.of(Items.CONDUIT),
                Ingredient.of(IndustrialTags.Items.MACHINE_FRAME_SUPREME),
                Ingredient.of(Items.SCULK),
                Ingredient.of(Items.HEAVY_CORE),
                Ingredient.of(Items.DRAGON_BREATH),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_NETHERITE),
                Ingredient.of(Items.NETHER_STAR)
        ), SizedFluidIngredient.of(ModuleCore.ETHER.getSourceFluid().get(), 1000),400, Optional.of(IFSBlocks.SIMULATED_MOB_DUPLICATOR.asItem().getDefaultInstance()),Optional.empty());
        DissolutionChamberRecipe.createRecipe(recipeOutput,"simulated_mob_duplicator",simulatedMobDuplicatorRecipe);

        DissolutionChamberRecipe simulatedMobCrusherRecipe = new DissolutionChamberRecipe(List.of(
                Ingredient.of(ModuleAgricultureHusbandry.MOB_CRUSHER),
                Ingredient.of(Items.CONDUIT),
                Ingredient.of(IndustrialTags.Items.MACHINE_FRAME_SUPREME),
                Ingredient.of(Items.SCULK),
                Ingredient.of(Items.HEAVY_CORE),
                Ingredient.of(Items.DRAGON_BREATH),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_NETHERITE),
                Ingredient.of(Items.NETHER_STAR)
        ), SizedFluidIngredient.of(ModuleCore.ETHER.getSourceFluid().get(), 1000),400, Optional.of(IFSBlocks.SIMULATED_MOB_CRUSHER.asItem().getDefaultInstance()),Optional.empty());
        DissolutionChamberRecipe.createRecipe(recipeOutput,"simulated_mob_crusher",simulatedMobCrusherRecipe);

        DissolutionChamberRecipe simulatedOreLaserBaseRecipe = new DissolutionChamberRecipe(List.of(
                Ingredient.of(ModuleResourceProduction.ORE_LASER_BASE),
                Ingredient.of(Items.CONDUIT),
                Ingredient.of(IndustrialTags.Items.MACHINE_FRAME_SUPREME),
                Ingredient.of(Items.SCULK),
                Ingredient.of(Items.HEAVY_CORE),
                Ingredient.of(Items.DRAGON_BREATH),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_NETHERITE),
                Ingredient.of(Items.NETHER_STAR)
        ), SizedFluidIngredient.of(ModuleCore.ETHER.getSourceFluid().get(), 1000),400, Optional.of(IFSBlocks.SIMULATED_ORE_LASER_BASE.asItem().getDefaultInstance()),Optional.empty());
        DissolutionChamberRecipe.createRecipe(recipeOutput,"simulated_ore_laser_base",simulatedOreLaserBaseRecipe);

        DissolutionChamberRecipe simulatedFluidLaserBaseRecipe = new DissolutionChamberRecipe(List.of(
                Ingredient.of(ModuleResourceProduction.FLUID_LASER_BASE),
                Ingredient.of(Items.CONDUIT),
                Ingredient.of(IndustrialTags.Items.MACHINE_FRAME_SUPREME),
                Ingredient.of(Items.SCULK),
                Ingredient.of(Items.HEAVY_CORE),
                Ingredient.of(Items.DRAGON_BREATH),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_NETHERITE),
                Ingredient.of(Items.NETHER_STAR)
        ), SizedFluidIngredient.of(ModuleCore.ETHER.getSourceFluid().get(), 1000),400, Optional.of(IFSBlocks.SIMULATED_FLUID_LASER_BASE.asItem().getDefaultInstance()),Optional.empty());
        DissolutionChamberRecipe.createRecipe(recipeOutput,"simulated_fluid_laser_base",simulatedFluidLaserBaseRecipe);

        DissolutionChamberRecipe advancedMobImprisonmentToolRecipe = new DissolutionChamberRecipe(List.of(
                Ingredient.of(ModuleTool.MOB_IMPRISONMENT_TOOL.get()),
                Ingredient.of(Items.CONDUIT),
                Ingredient.of(IndustrialTags.Items.MACHINE_FRAME_SUPREME),
                Ingredient.of(Items.SCULK),
                Ingredient.of(Items.HEAVY_CORE),
                Ingredient.of(Items.DRAGON_BREATH),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_NETHERITE),
                Ingredient.of(Items.NETHER_STAR)
        ), SizedFluidIngredient.of(ModuleCore.ETHER.getSourceFluid().get(), 1000),400, Optional.of(IFSItems.ADVANCED_MOB_IMPRISONMENT.get().getDefaultInstance()),Optional.empty());
        DissolutionChamberRecipe.createRecipe(recipeOutput,"advanced_mob_imprisonment_tool",advancedMobImprisonmentToolRecipe);

        DissolutionChamberRecipe lootingAddonTier1Recipe = new DissolutionChamberRecipe(List.of(
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_EMERALD),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_EMERALD),
                Ingredient.of(IndustrialTags.Items.PLASTIC),
                Ingredient.of(IndustrialTags.Items.PLASTIC),
                Ingredient.of(Items.NETHER_STAR),
                Ingredient.of(Items.DRAGON_BREATH),
                Ingredient.of(IndustrialTags.Items.GEAR_GOLD),
                Ingredient.of(IndustrialTags.Items.GEAR_GOLD)
        ), SizedFluidIngredient.of(ModuleCore.ETHER.getSourceFluid().get(), 1000),400, Optional.of(IFSItems.LOOTING_ADDON_1.get().getDefaultInstance()),Optional.empty());
        DissolutionChamberRecipe.createRecipe(recipeOutput,"looting_addon_tier_1",lootingAddonTier1Recipe);

        DissolutionChamberRecipe lootingAddonTier2Recipe = new DissolutionChamberRecipe(List.of(
                Ingredient.of(IFSItems.LOOTING_ADDON_1.get()),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_EMERALD),
                Ingredient.of(IndustrialTags.Items.PLASTIC),
                Ingredient.of(IndustrialTags.Items.PLASTIC),
                Ingredient.of(Items.NETHER_STAR),
                Ingredient.of(Items.DRAGON_BREATH),
                Ingredient.of(IndustrialTags.Items.GEAR_DIAMOND),
                Ingredient.of(IndustrialTags.Items.GEAR_DIAMOND)
        ), SizedFluidIngredient.of(ModuleCore.ETHER.getSourceFluid().get(), 1000),400, Optional.of(IFSItems.LOOTING_ADDON_2.get().getDefaultInstance()),Optional.empty());
        DissolutionChamberRecipe.createRecipe(recipeOutput,"looting_addon_tier_2",lootingAddonTier2Recipe);

        DissolutionChamberRecipe fortuneAddonTier1Recipe = new DissolutionChamberRecipe(List.of(
                Ingredient.of(Items.QUARTZ_BLOCK),
                Ingredient.of(Items.QUARTZ_BLOCK),
                Ingredient.of(IndustrialTags.Items.PLASTIC),
                Ingredient.of(IndustrialTags.Items.PLASTIC),
                Ingredient.of(Items.NETHER_STAR),
                Ingredient.of(Items.DRAGON_BREATH),
                Ingredient.of(IndustrialTags.Items.GEAR_GOLD),
                Ingredient.of(IndustrialTags.Items.GEAR_GOLD)
        ), SizedFluidIngredient.of(ModuleCore.ETHER.getSourceFluid().get(), 1000),400, Optional.of(IFSItems.FORTUNE_ADDON_1.get().getDefaultInstance()),Optional.empty());
        DissolutionChamberRecipe.createRecipe(recipeOutput,"fortune_addon_tier_1",fortuneAddonTier1Recipe);

        DissolutionChamberRecipe fortuneAddonTier2Recipe = new DissolutionChamberRecipe(List.of(
                Ingredient.of(IFSItems.FORTUNE_ADDON_1.get()),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_EMERALD),
                Ingredient.of(IndustrialTags.Items.PLASTIC),
                Ingredient.of(IndustrialTags.Items.PLASTIC),
                Ingredient.of(Items.NETHER_STAR),
                Ingredient.of(Items.DRAGON_BREATH),
                Ingredient.of(IndustrialTags.Items.GEAR_DIAMOND),
                Ingredient.of(IndustrialTags.Items.GEAR_DIAMOND)
        ), SizedFluidIngredient.of(ModuleCore.ETHER.getSourceFluid().get(), 1000),400, Optional.of(IFSItems.FORTUNE_ADDON_2.get().getDefaultInstance()),Optional.empty());
        DissolutionChamberRecipe.createRecipe(recipeOutput,"fortune_addon_tier_2",fortuneAddonTier2Recipe);


        TitaniumShapedRecipeBuilder.shapedRecipe(IFSItems.SIMULATED_CARD.get())
                .pattern("ABA")
                .pattern("CDC")
                .pattern("AEA")
                .define('A', IndustrialTags.Items.PLASTIC)
                .define('B', Items.NETHER_STAR)
                .define('C', Items.OBSERVER)
                .define('D', Items.REPEATER)
                .define('E', IndustrialTags.Items.GEAR_GOLD)
                .save(recipeOutput);

        DissolutionChamberRecipe advancedSimulatedCardRecipe = new DissolutionChamberRecipe(List.of(
                Ingredient.of(IFSItems.SIMULATED_CARD.get()),
                Ingredient.of(Tags.Items.STORAGE_BLOCKS_DIAMOND),
                Ingredient.of(IndustrialTags.Items.PLASTIC),
                Ingredient.of(IndustrialTags.Items.PLASTIC),
                Ingredient.of(Items.NETHER_STAR),
                Ingredient.of(Items.DRAGON_BREATH),
                Ingredient.of(IndustrialTags.Items.GEAR_DIAMOND),
                Ingredient.of(IndustrialTags.Items.GEAR_DIAMOND)
        ), SizedFluidIngredient.of(ModuleCore.ETHER.getSourceFluid().get(), 1000),400, Optional.of(IFSItems.ADVANCED_SIMULATED_CARD.get().getDefaultInstance()),Optional.empty());
        DissolutionChamberRecipe.createRecipe(recipeOutput,"advanced_simulated_card",advancedSimulatedCardRecipe);
    }
}

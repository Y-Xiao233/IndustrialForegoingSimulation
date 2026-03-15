package net.yxiao233.ifs.api.item;

import com.buuz135.industrial.item.addon.AddonItem;
import com.hrznstudio.titanium.api.ISpecialCreativeTabItem;
import net.minecraft.data.recipes.RecipeOutput;
import net.yxiao233.ifs.IndustrialForegoingSimulation;

public abstract class IFSAddonItem extends AddonItem implements ISpecialCreativeTabItem {
    public IFSAddonItem(String name) {
        super(name, IndustrialForegoingSimulation.TAB);
    }

   public abstract AddonType getType();

    public abstract int getTier();

    @Override
    public void registerRecipe(RecipeOutput recipeOutput) {

    }
}

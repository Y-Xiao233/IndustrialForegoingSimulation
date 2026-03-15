package net.yxiao233.ifs.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.yxiao233.ifs.common.registry.IFSItems;

public class ItemModelGen extends ItemModelProvider {
    public ItemModelGen(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(IFSItems.FORTUNE_ADDON_1.get());
        basicItem(IFSItems.FORTUNE_ADDON_2.get());
        basicItem(IFSItems.LOOTING_ADDON_1.get());
        basicItem(IFSItems.LOOTING_ADDON_2.get());
        basicItem(IFSItems.SIMULATED_CARD.get());
        basicItem(IFSItems.ADVANCED_SIMULATED_CARD.get());
    }
}

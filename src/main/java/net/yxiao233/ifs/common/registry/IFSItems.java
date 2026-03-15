package net.yxiao233.ifs.common.registry;

import com.buuz135.industrial.module.IModule;
import com.google.common.base.Supplier;
import com.hrznstudio.titanium.module.DeferredRegistryHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.yxiao233.ifs.api.data.AdvancedSimulatedCard;
import net.yxiao233.ifs.api.data.SimulatedCard;
import net.yxiao233.ifs.api.item.FortuneAddonItem;
import net.yxiao233.ifs.api.item.LootingAddonItem;
import net.yxiao233.ifs.common.item.AdvancedMobImprisonmentToolItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IFSItems implements IModule {
    private static final List<DeferredHolder<Item,Item>> ITEMS = new ArrayList<>();
    public static DeferredHolder<Item, Item> SIMULATED_CARD;
    public static DeferredHolder<Item, Item> ADVANCED_SIMULATED_CARD;
    public static DeferredHolder<Item, Item> ADVANCED_MOB_IMPRISONMENT;
    public static DeferredHolder<Item, Item> LOOTING_ADDON_1;
    public static DeferredHolder<Item, Item> LOOTING_ADDON_2;
    public static DeferredHolder<Item, Item> FORTUNE_ADDON_1;
    public static DeferredHolder<Item, Item> FORTUNE_ADDON_2;
    @Override
    public void generateFeatures(DeferredRegistryHelper helper) {
        SIMULATED_CARD = item(helper,"simulated_card",SimulatedCard::new);
        ADVANCED_SIMULATED_CARD = item(helper,"advanced_simulated_card", AdvancedSimulatedCard::new);
        ADVANCED_MOB_IMPRISONMENT = item(helper,"advanced_mob_imprisonment_tool", AdvancedMobImprisonmentToolItem::new, false);
        LOOTING_ADDON_1 = item(helper,"looting_addon_tier_1", () -> new LootingAddonItem(1),false);
        LOOTING_ADDON_2 = item(helper,"looting_addon_tier_2", () -> new LootingAddonItem(2),false);
        FORTUNE_ADDON_1 = item(helper,"fortune_addon_tier_1", () -> new FortuneAddonItem(1),false);
        FORTUNE_ADDON_2 = item(helper,"fortune_addon_tier_2", () -> new FortuneAddonItem(2),false);
    }

    private static DeferredHolder<Item, Item> item(DeferredRegistryHelper helper, String name, Supplier<Item> item, boolean addToList){
        var entry = helper.registerGeneric(Registries.ITEM, name, item);
        if(addToList){
            ITEMS.add(entry);
        }
        return entry;
    }
    private static DeferredHolder<Item, Item> item(DeferredRegistryHelper helper, String name, Supplier<Item> item){
        return item(helper,name,item,true);
    }
    public static List<DeferredHolder<Item, Item>> getItems() {
        return Collections.unmodifiableList(ITEMS);
    }
}

package net.yxiao233.ifs.common.event;

import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.yxiao233.ifs.IndustrialForegoingSimulation;
import net.yxiao233.ifs.common.registry.IFSItems;

public class CollectCreativeModTabItems {
    public static void onAdded(BuildCreativeModeTabContentsEvent event){
        if(event.getTab() == IndustrialForegoingSimulation.CREATIVE_MODE_TAB.get()){
            IFSItems.getItems().forEach(item -> event.accept(item.get()));
        }
    }
}

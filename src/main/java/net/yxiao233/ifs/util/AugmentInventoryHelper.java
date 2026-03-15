package net.yxiao233.ifs.util;

import com.hrznstudio.titanium.block.tile.MachineTile;
import com.hrznstudio.titanium.component.inventory.InventoryComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.yxiao233.ifs.api.item.AddonType;
import net.yxiao233.ifs.api.item.IFSAddonItem;

public class AugmentInventoryHelper {

    public static int getAugmentIndex(InventoryComponent<?> augmentInventory, AddonType type){
        for (int i = 0; i < augmentInventory.getSlots(); i++) {
            if(augmentInventory.getStackInSlot(i).getItem() instanceof IFSAddonItem addonItem){
                if(addonItem.getType() == type){
                    return i;
                }
            }
        }
        return -1;
    }

    public static int getAugmentIndex(MachineTile<?> tile, AddonType type){
        return getAugmentIndex(tile.getAugmentInventory(),type);
    }

    public static int getAugmentIndex(InventoryComponent<?> augmentInventory, ItemStack stack){
        if(stack.getItem() instanceof IFSAddonItem addonItem){
            return getAugmentIndex(augmentInventory,addonItem.getType());
        }
        return -1;
    }

    public static int getAugmentIndex(MachineTile<?> tile, ItemStack stack){
        return getAugmentIndex(tile.getAugmentInventory(),stack);
    }

    public static int getAugmentIndex(InventoryComponent<?> augmentInventory, Item item){
        return getAugmentIndex(augmentInventory,item.getDefaultInstance());
    }

    public static int getAugmentIndex(MachineTile<?> tile, Item item){
        return getAugmentIndex(tile.getAugmentInventory(),item);
    }
    public static boolean contains(InventoryComponent<?> augmentInventory, ItemStack stack){
        return getAugmentIndex(augmentInventory,stack) != -1;
    }

    public static boolean contains(MachineTile<?> tile, AddonType type){
        return getAugmentIndex(tile,type) != -1;
    }

    public static boolean contains(InventoryComponent<?> augmentInventory, AddonType type){
        return getAugmentIndex(augmentInventory,type) != -1;
    }

    public static boolean contains(MachineTile<?> tile, ItemStack stack){
        return contains(tile.getAugmentInventory(),stack);
    }

    public static boolean canAccept(InventoryComponent<?> augmentInventory, ItemStack stack){
        return !contains(augmentInventory,stack);
    }

    public static boolean canAccept(MachineTile<?> tile, ItemStack stack){
        return canAccept(tile.getAugmentInventory(),stack);
    }

    public static int getAugmentTier(InventoryComponent<?> augmentInventory, AddonType type){
        int index = getAugmentIndex(augmentInventory,type);
        return index == -1 ? 0 :((IFSAddonItem) augmentInventory.getStackInSlot(index).getItem()).getTier();
    }

    public static int getAugmentTier(MachineTile<?> tile, AddonType type){
        return getAugmentTier(tile.getAugmentInventory(),type);
    }
}

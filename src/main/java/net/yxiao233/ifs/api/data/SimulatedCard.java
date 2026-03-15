package net.yxiao233.ifs.api.data;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.yxiao233.ifs.common.registry.IFSDataComponents;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SimulatedCard extends Item implements ISimulatedCard{
    public SimulatedCard() {
        super(new Properties().stacksTo(1));
    }

    public void setType(ItemStack card, String type){
        if(!card.has(IFSDataComponents.DATA_TYPE)){
            card.set(IFSDataComponents.DATA_TYPE, type);
        }
    }

    public String getType(ItemStack stack) {
        if(stack.has(IFSDataComponents.DATA_TYPE)){
            return stack.get(IFSDataComponents.DATA_TYPE);
        }
        return null;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltips, @NotNull TooltipFlag flag) {
        if(stack.has(IFSDataComponents.MOB_DATA)){
            MobData mobData = stack.get(IFSDataComponents.MOB_DATA);
            if(mobData != null){
                mobData.appendHoverTip(tooltips);
            }
        }else if(stack.has(IFSDataComponents.ORE_DATA)){
            OreData oreData = stack.get(IFSDataComponents.ORE_DATA);
            if(oreData != null){
                oreData.appendHoverTip(Minecraft.getInstance().level.registryAccess(),tooltips);
            }
        }else if(stack.has(IFSDataComponents.FLUID_DATA)){
            FluidData fluidData = stack.get(IFSDataComponents.FLUID_DATA);
            if(fluidData != null){
                fluidData.appendHoverTip(Minecraft.getInstance().level.registryAccess(),tooltips);
            }
        }
    }
}

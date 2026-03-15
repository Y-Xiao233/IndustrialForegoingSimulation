package net.yxiao233.ifs.common.tile;

import com.buuz135.industrial.block.tile.IndustrialWorkingTile;
import com.hrznstudio.titanium.annotation.Save;
import com.hrznstudio.titanium.component.energy.EnergyStorageComponent;
import com.hrznstudio.titanium.component.fluid.FluidTankComponent;
import com.hrznstudio.titanium.component.fluid.SidedFluidTankComponent;
import com.hrznstudio.titanium.component.inventory.SidedInventoryComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.yxiao233.ifs.api.block.ISimulatedMachine;
import net.yxiao233.ifs.api.data.FluidData;
import net.yxiao233.ifs.api.data.ISimulatedCard;
import net.yxiao233.ifs.api.data.SimulatedCard;
import net.yxiao233.ifs.api.item.AddonType;
import net.yxiao233.ifs.api.item.FortuneAddonItem;
import net.yxiao233.ifs.common.config.machine.SimulatedFluidLaserBaseConfig;
import net.yxiao233.ifs.common.registry.IFSBlocks;
import net.yxiao233.ifs.common.registry.IFSDataComponents;
import net.yxiao233.ifs.util.AugmentInventoryHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.atomic.AtomicBoolean;

public class SimulatedFluidLaserBaseTile extends IndustrialWorkingTile<SimulatedFluidLaserBaseTile> implements ISimulatedMachine<SimulatedFluidLaserBaseTile> {
    @Save
    private SidedFluidTankComponent<SimulatedFluidLaserBaseTile> output;

    @Save
    private final SidedInventoryComponent<SimulatedFluidLaserBaseTile> simulated;

    private final WorkAction ignore = new WorkAction(1.0f,0);

    public SimulatedFluidLaserBaseTile(BlockPos blockPos, BlockState blockState) {
        super(IFSBlocks.SIMULATED_FLUID_LASER_BASE, SimulatedFluidLaserBaseConfig.powerPerOperation, blockPos, blockState);

        this.addTank(this.output = (SidedFluidTankComponent<SimulatedFluidLaserBaseTile>)(new SidedFluidTankComponent<SimulatedFluidLaserBaseTile>("output", SimulatedFluidLaserBaseConfig.tankSize, 43, 20, 0)).setColor(DyeColor.ORANGE).setTankAction(FluidTankComponent.Action.DRAIN));;

        this.addInventory(this.simulated = (SidedInventoryComponent<SimulatedFluidLaserBaseTile>) this.simulatedInventory(68,42,1).create().setComponentHarness(this));
    }

    @Override
    public IndustrialWorkingTile<SimulatedFluidLaserBaseTile>.WorkAction work() {
        if(level != null && this.getEnergyStorage().getEnergyStored() < SimulatedFluidLaserBaseConfig.powerPerOperation){
            return ignore;
        }

        AtomicBoolean worked = new AtomicBoolean(false);
        ItemStack card = this.simulated.getStackInSlot(0);
        if(!card.isEmpty() && card.getItem() instanceof ISimulatedCard simulatedCard){
            if(simulatedCard.isDataEmpty(card)){
                return ignore;
            }
            if(card.has(IFSDataComponents.FLUID_DATA)){
                FluidData fluidData = card.get(IFSDataComponents.FLUID_DATA);
                if(fluidData != null){
                    fluidData.getTags().forEach(tag ->{
                        FluidStack fluidStack = FluidStack.parseOptional(level.registryAccess(),tag.getCompound("fluid"));
                        double efficiency = tag.getDouble("efficiency");
                        ((SimulatedCard) card.getItem()).updateFluidData(level,card,fluidStack,1);
                        applyOutput(fluidStack,efficiency);
                        worked.set(true);
                    });
                }
            }
        }
        return worked.get() ? new WorkAction(1.0f,SimulatedFluidLaserBaseConfig.powerPerOperation) : ignore;
    }

    private void applyOutput(FluidStack fluidStack, double efficiency){
        int tier = AugmentInventoryHelper.getAugmentTier(this, AddonType.FORTUNE) + 1;
        int multiple = calculateOres(efficiency) * tier;

        int amount = fluidStack.copy().getAmount();
        this.output.fillForced(fluidStack.copyWithAmount(multiple * amount), IFluidHandler.FluidAction.EXECUTE);
    }

    private int calculateOres(double efficiency){
        if(efficiency <= 100){
            return 1;
        }
        return (int) (Math.log(efficiency + 1) / Math.log(3));
    }

    @Override
    public boolean canAcceptAugment(ItemStack augment) {
        if(augment.getItem() instanceof FortuneAddonItem){
            return AugmentInventoryHelper.canAccept(this,augment);
        }
        return super.canAcceptAugment(augment);
    }

    @Override
    protected @NotNull EnergyStorageComponent<SimulatedFluidLaserBaseTile> createEnergyStorage() {
        return new EnergyStorageComponent<>(SimulatedFluidLaserBaseConfig.maxStoredPower, 10, 20);
    }

    @Override
    public int getMaxProgress() {
        return SimulatedFluidLaserBaseConfig.maxProgress;
    }

    @NotNull
    @Override
    public SimulatedFluidLaserBaseTile getSelf() {
        return this;
    }

    @Override
    public SidedInventoryComponent<SimulatedFluidLaserBaseTile> getSimulatedInventory() {
        return simulated;
    }
}

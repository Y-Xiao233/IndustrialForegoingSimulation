package net.yxiao233.ifs.common.tile;

import com.buuz135.industrial.block.tile.IndustrialWorkingTile;
import com.buuz135.industrial.utils.ItemStackUtils;
import com.hrznstudio.titanium.annotation.Save;
import com.hrznstudio.titanium.component.energy.EnergyStorageComponent;
import com.hrznstudio.titanium.component.inventory.SidedInventoryComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.yxiao233.ifs.api.block.ISimulatedMachine;
import net.yxiao233.ifs.api.component.BigSidedInventoryComponent;
import net.yxiao233.ifs.api.data.ISimulatedCard;
import net.yxiao233.ifs.api.data.OreData;
import net.yxiao233.ifs.api.data.SimulatedCard;
import net.yxiao233.ifs.api.item.AddonType;
import net.yxiao233.ifs.api.item.FortuneAddonItem;
import net.yxiao233.ifs.common.config.machine.SimulatedOreLaserBaseConfig;
import net.yxiao233.ifs.common.registry.IFSBlocks;
import net.yxiao233.ifs.common.registry.IFSDataComponents;
import net.yxiao233.ifs.util.AugmentInventoryHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.atomic.AtomicBoolean;

public class SimulatedOreLaserBaseTile extends IndustrialWorkingTile<SimulatedOreLaserBaseTile> implements ISimulatedMachine<SimulatedOreLaserBaseTile> {
    @Save
    private final BigSidedInventoryComponent<SimulatedOreLaserBaseTile> output;

    @Save
    private final SidedInventoryComponent<SimulatedOreLaserBaseTile> simulated;

    private final WorkAction ignore = new WorkAction(1.0f,0);

    public SimulatedOreLaserBaseTile(BlockPos blockPos, BlockState blockState) {
        super(IFSBlocks.SIMULATED_ORE_LASER_BASE, SimulatedOreLaserBaseConfig.powerPerOperation, blockPos, blockState);

        this.addInventory(this.output = (BigSidedInventoryComponent<SimulatedOreLaserBaseTile>)(new BigSidedInventoryComponent<SimulatedOreLaserBaseTile>("output", 45, 22, 21, 0))
                .setColor(DyeColor.ORANGE)
                .setRange(7, 3)
                .setInputFilter((stack, integer) -> false)
                .setSlotLimit(SimulatedOreLaserBaseConfig.maxOutputSlotLimit)
        );

        this.addInventory(this.simulated = (SidedInventoryComponent<SimulatedOreLaserBaseTile>) this.simulatedInventory(88,80,1).create().setComponentHarness(this));
    }

    @Override
    public IndustrialWorkingTile<SimulatedOreLaserBaseTile>.WorkAction work() {
        if(level != null && this.getEnergyStorage().getEnergyStored() < SimulatedOreLaserBaseConfig.powerPerOperation){
            return ignore;
        }

        if(ItemStackUtils.isInventoryFull(this.output)){
            return ignore;
        }

        AtomicBoolean worked = new AtomicBoolean(false);
        ItemStack card = this.simulated.getStackInSlot(0);
        if(!card.isEmpty() && card.getItem() instanceof ISimulatedCard simulatedCard){
            if(simulatedCard.isDataEmpty(card)){
                return ignore;
            }
            if(card.has(IFSDataComponents.ORE_DATA)){
                OreData oreData = card.get(IFSDataComponents.ORE_DATA);
                if(oreData != null){
                    oreData.getTags().forEach(tag ->{
                        ItemStack ore = ItemStack.parseOptional(level.registryAccess(),tag.getCompound("item"));
                        double efficiency = tag.getDouble("efficiency");
                        ((SimulatedCard) card.getItem()).updateOreData(level,card,ore,1);
                        applyOutput(ore,efficiency);
                        worked.set(true);
                    });
                }
            }
        }
        return worked.get() ? new WorkAction(1.0f,SimulatedOreLaserBaseConfig.powerPerOperation) : ignore;
    }

    private void applyOutput(ItemStack ore, double efficiency){
        int tier = AugmentInventoryHelper.getAugmentTier(this, AddonType.FORTUNE) + 1;
        int multiple = calculateOres(efficiency) * tier;

        int count = ore.copy().getCount();
        ItemHandlerHelper.insertItem(this.output, ore.copyWithCount(multiple * count), false);
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
    protected @NotNull EnergyStorageComponent<SimulatedOreLaserBaseTile> createEnergyStorage() {
        return new EnergyStorageComponent<>(SimulatedOreLaserBaseConfig.maxStoredPower, 10, 20);
    }

    @Override
    public int getMaxProgress() {
        return SimulatedOreLaserBaseConfig.maxProgress;
    }

    @NotNull
    @Override
    public SimulatedOreLaserBaseTile getSelf() {
        return this;
    }

    @Override
    public SidedInventoryComponent<SimulatedOreLaserBaseTile> getSimulatedInventory() {
        return null;
    }
}

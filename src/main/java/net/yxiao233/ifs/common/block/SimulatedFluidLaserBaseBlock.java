package net.yxiao233.ifs.common.block;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.yxiao233.ifs.api.block.SimulatedBlock;
import net.yxiao233.ifs.common.tile.SimulatedFluidLaserBaseTile;

public class SimulatedFluidLaserBaseBlock extends SimulatedBlock<SimulatedFluidLaserBaseTile> {
    public SimulatedFluidLaserBaseBlock() {
        super("simulated_fluid_laser_base", SimulatedFluidLaserBaseTile.class);
    }

    @Override
    public BlockEntityType.BlockEntitySupplier<?> getTileEntityFactory() {
        return SimulatedFluidLaserBaseTile::new;
    }
}

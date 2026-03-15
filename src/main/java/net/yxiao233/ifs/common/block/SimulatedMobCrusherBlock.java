package net.yxiao233.ifs.common.block;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.yxiao233.ifs.api.block.SimulatedBlock;
import net.yxiao233.ifs.common.tile.SimulatedMobCrusherTile;
import org.jetbrains.annotations.NotNull;

public class SimulatedMobCrusherBlock extends SimulatedBlock<SimulatedMobCrusherTile> {
    public SimulatedMobCrusherBlock() {
        super("simulated", SimulatedMobCrusherTile.class);
    }

    @Override
    public BlockEntityType.BlockEntitySupplier<?> getTileEntityFactory() {
        return SimulatedMobCrusherTile::new;
    }

    @NotNull
    @Override
    public RotationType getRotationType() {
        return RotationType.FOUR_WAY;
    }
}

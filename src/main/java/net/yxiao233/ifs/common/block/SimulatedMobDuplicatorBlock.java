package net.yxiao233.ifs.common.block;

import com.buuz135.industrial.block.IndustrialBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.yxiao233.ifs.IndustrialForegoingSimulation;
import net.yxiao233.ifs.common.tile.SimulatedMobDuplicatorTile;

public class SimulatedMobDuplicatorBlock extends IndustrialBlock<SimulatedMobDuplicatorTile> {
    public SimulatedMobDuplicatorBlock() {
        super("simulated_mob_duplicator", Properties.ofFullCopy(Blocks.IRON_BLOCK), SimulatedMobDuplicatorTile.class, IndustrialForegoingSimulation.TAB);
    }



    @Override
    public BlockEntityType.BlockEntitySupplier<?> getTileEntityFactory() {
        return SimulatedMobDuplicatorTile::new;
    }
}

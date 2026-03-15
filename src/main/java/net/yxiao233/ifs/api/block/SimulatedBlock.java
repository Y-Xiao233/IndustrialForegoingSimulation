package net.yxiao233.ifs.api.block;

import com.buuz135.industrial.block.IndustrialBlock;
import com.buuz135.industrial.block.tile.IndustrialWorkingTile;
import net.minecraft.world.level.block.Blocks;
import net.yxiao233.ifs.IndustrialForegoingSimulation;

public abstract class SimulatedBlock<T extends IndustrialWorkingTile<T>> extends IndustrialBlock<T> {
    public SimulatedBlock(String name, Class<T> tileClass) {
        super(name, Properties.ofFullCopy(Blocks.IRON_BLOCK), tileClass, IndustrialForegoingSimulation.TAB);
    }
}

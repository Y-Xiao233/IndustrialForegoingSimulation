package net.yxiao233.ifs.common.registry;

import com.buuz135.industrial.module.IModule;
import com.hrznstudio.titanium.module.BlockWithTile;
import com.hrznstudio.titanium.module.DeferredRegistryHelper;
import net.yxiao233.ifs.IndustrialForegoingSimulation;
import net.yxiao233.ifs.common.block.SimulatedFluidLaserBaseBlock;
import net.yxiao233.ifs.common.block.SimulatedMobCrusherBlock;
import net.yxiao233.ifs.common.block.SimulatedMobDuplicatorBlock;
import net.yxiao233.ifs.common.block.SimulatedOreLaserBaseBlock;

public class IFSBlocks implements IModule {
    public static BlockWithTile SIMULATED_MOB_DUPLICATOR;
    public static BlockWithTile SIMULATED_MOB_CRUSHER;
    public static BlockWithTile SIMULATED_ORE_LASER_BASE;
    public static BlockWithTile SIMULATED_FLUID_LASER_BASE;
    @Override
    public void generateFeatures(DeferredRegistryHelper helper) {
        SIMULATED_MOB_DUPLICATOR = helper.registerBlockWithTile("simulated_mob_duplicator", SimulatedMobDuplicatorBlock::new, IndustrialForegoingSimulation.TAB);
        SIMULATED_MOB_CRUSHER = helper.registerBlockWithTile("simulated_mob_crusher", SimulatedMobCrusherBlock::new, IndustrialForegoingSimulation.TAB);
        SIMULATED_ORE_LASER_BASE = helper.registerBlockWithTile("simulated_ore_laser_base", SimulatedOreLaserBaseBlock::new, IndustrialForegoingSimulation.TAB);
        SIMULATED_FLUID_LASER_BASE = helper.registerBlockWithTile("simulated_fluid_laser_base", SimulatedFluidLaserBaseBlock::new, IndustrialForegoingSimulation.TAB);
    }
}

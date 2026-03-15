package net.yxiao233.ifs.datagen;

import com.hrznstudio.titanium.module.BlockWithTile;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.yxiao233.ifs.IndustrialForegoingSimulation;
import net.yxiao233.ifs.common.registry.IFSBlocks;

public class BlockStateGen extends BlockStateProvider {
    public BlockStateGen(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithTileItem(IFSBlocks.SIMULATED_MOB_CRUSHER);
        blockWithTileItem(IFSBlocks.SIMULATED_MOB_DUPLICATOR);
        blockWithTileItem(IFSBlocks.SIMULATED_ORE_LASER_BASE);
        blockWithTileItem(IFSBlocks.SIMULATED_FLUID_LASER_BASE);
    }

    private void blockWithTileItem(BlockWithTile blockWithTile){
        simpleBlockItem(blockWithTile.getBlock(),new ModelFile.UncheckedModelFile(IndustrialForegoingSimulation.MODID +
                ":block/" + BuiltInRegistries.BLOCK.getKey(blockWithTile.getBlock()).getPath()));
    }
}

package net.yxiao233.ifs.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.yxiao233.ifs.common.registry.IFSBlocks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BlockTagGen extends BlockTagsProvider {
    public BlockTagGen(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(IFSBlocks.SIMULATED_MOB_CRUSHER.getBlock())
                .add(IFSBlocks.SIMULATED_MOB_DUPLICATOR.getBlock())
                .add(IFSBlocks.SIMULATED_ORE_LASER_BASE.getBlock())
                .add(IFSBlocks.SIMULATED_FLUID_LASER_BASE.getBlock());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(IFSBlocks.SIMULATED_MOB_CRUSHER.getBlock())
                .add(IFSBlocks.SIMULATED_MOB_DUPLICATOR.getBlock())
                .add(IFSBlocks.SIMULATED_ORE_LASER_BASE.getBlock())
                .add(IFSBlocks.SIMULATED_FLUID_LASER_BASE.getBlock());
    }
}

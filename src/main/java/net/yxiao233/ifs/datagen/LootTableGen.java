package net.yxiao233.ifs.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.yxiao233.ifs.common.registry.IFSBlocks;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class LootTableGen {
    public static LootTableProvider create(PackOutput output, CompletableFuture<HolderLookup.Provider> provider){
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(BlockLootTable::new, LootContextParamSets.BLOCK)
        ),provider);
    }

    public static class BlockLootTable extends BlockLootSubProvider{

        protected BlockLootTable(HolderLookup.Provider registries) {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
        }

        @Override
        protected void generate() {
            this.dropSelf(IFSBlocks.SIMULATED_MOB_CRUSHER.getBlock());
            this.dropSelf(IFSBlocks.SIMULATED_MOB_DUPLICATOR.getBlock());
            this.dropSelf(IFSBlocks.SIMULATED_ORE_LASER_BASE.getBlock());
            this.dropSelf(IFSBlocks.SIMULATED_FLUID_LASER_BASE.getBlock());
        }

        @Override
        protected @NotNull Iterable<Block> getKnownBlocks() {
            //注册方法时后面加上.noLootTable()就不需要在这里写
            return Arrays.asList(
                    IFSBlocks.SIMULATED_MOB_CRUSHER.getBlock(),
                    IFSBlocks.SIMULATED_MOB_DUPLICATOR.getBlock(),
                    IFSBlocks.SIMULATED_ORE_LASER_BASE.getBlock(),
                    IFSBlocks.SIMULATED_FLUID_LASER_BASE.getBlock()
            );
        }
    }
}

package net.yxiao233.ifs;

import com.hrznstudio.titanium.module.DeferredRegistryHelper;
import com.hrznstudio.titanium.module.ModuleController;
import com.hrznstudio.titanium.tab.TitaniumTab;
import com.mojang.logging.LogUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.yxiao233.ifs.client.IFSClientEvent;
import net.yxiao233.ifs.common.event.CollectCreativeModTabItems;
import net.yxiao233.ifs.common.registry.IFSBlocks;
import net.yxiao233.ifs.common.registry.IFSDataComponents;
import net.yxiao233.ifs.common.registry.IFSItems;
import net.yxiao233.ifs.datagen.BlockStateGen;
import net.yxiao233.ifs.datagen.BlockTagGen;
import net.yxiao233.ifs.datagen.ItemModelGen;
import net.yxiao233.ifs.datagen.LootTableGen;
import org.slf4j.Logger;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
@Mod(IndustrialForegoingSimulation.MODID)
public class IndustrialForegoingSimulation extends ModuleController {
    public static final String MODID = "ifs";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static TitaniumTab TAB = new TitaniumTab(ResourceLocation.fromNamespaceAndPath(MODID, "main"));
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVE_MODE_TAB;

    public IndustrialForegoingSimulation(IEventBus modEventBus, ModContainer modContainer) {
        super(modContainer);
        IFSDataComponents.DATA_COMPONENTS.register(modEventBus);
        modEventBus.addListener(CollectCreativeModTabItems::onAdded);
        modEventBus.addListener(this::gatherData);

        if(FMLEnvironment.dist == Dist.CLIENT){
            modEventBus.addListener(IFSClientEvent::clientSetup);
        }
    }


    private void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new BlockStateGen(packOutput,MODID,existingFileHelper));
        generator.addProvider(event.includeServer(), LootTableGen.create(packOutput,lookupProvider));
        generator.addProvider(event.includeServer(), new ItemModelGen(packOutput,MODID,existingFileHelper));
        generator.addProvider(event.includeServer(), new BlockTagGen(packOutput,lookupProvider,MODID,existingFileHelper));
    }

    @Override
    protected void initModules() {
        DeferredRegistryHelper helper = getRegistries();
        new IFSBlocks().generateFeatures(helper);
        new IFSItems().generateFeatures(helper);

        CREATIVE_MODE_TAB = this.addCreativeTab("main", () -> new ItemStack(IFSBlocks.SIMULATED_MOB_DUPLICATOR),MODID+ ".main", TAB);
    }

    public static ResourceLocation makeId(String path){
        return ResourceLocation.fromNamespaceAndPath(MODID,path);
    }
}

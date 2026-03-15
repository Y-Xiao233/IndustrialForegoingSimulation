package net.yxiao233.ifs.client;

import com.buuz135.industrial.item.MobImprisonmentToolItem;
import com.buuz135.industrial.module.ModuleTool;
import com.buuz135.industrial.utils.IFAttachments;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.yxiao233.ifs.common.registry.IFSItems;

public class IFSClientEvent {
    @SuppressWarnings("deprecation")
    public static void clientSetup(FMLCommonSetupEvent event){
        event.enqueueWork(() ->{
            Minecraft.getInstance().getItemColors().register((stack, tintIndex) -> {
                if (tintIndex != 1 && tintIndex != 2 && tintIndex != 3) {
                    return -1;
                } else {
                    SpawnEggItem info = null;
                    boolean blacklisted = false;
                    if (stack.has(IFAttachments.MOB_IMPRISONMENT_TOOL)) {
                        CompoundTag tag = stack.get(IFAttachments.MOB_IMPRISONMENT_TOOL);
                        if(tag != null){
                            ResourceLocation id = ResourceLocation.parse(tag.getString("entity"));
                            EntityType<?> type = BuiltInRegistries.ENTITY_TYPE.get(id);
                            info = SpawnEggItem.byId(type);
                            blacklisted = ((MobImprisonmentToolItem) ModuleTool.MOB_IMPRISONMENT_TOOL.get()).isBlacklisted(type);
                        }
                    }

                    return info == null ? -10263709 : (tintIndex == 3 ? (blacklisted ? -2416614 : -10263709) : FastColor.ARGB32.opaque(info.getColor(tintIndex - 1)));
                }
            }, IFSItems.ADVANCED_MOB_IMPRISONMENT.get());
        });
    }
}

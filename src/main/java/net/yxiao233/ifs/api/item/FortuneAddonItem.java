package net.yxiao233.ifs.api.item;

import com.hrznstudio.titanium.api.augment.IAugmentType;
import com.hrznstudio.titanium.item.AugmentWrapper;
import com.hrznstudio.titanium.item.BasicItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class FortuneAddonItem extends IFSAddonItem{
    public static final IAugmentType FORTUNE = () -> {
        return "Looting";
    };
    private final int tier;
    public FortuneAddonItem(int tier) {
        super("fortune_addon_tier");
        this.tier = tier;
    }

    @Override
    public AddonType getType() {
        return AddonType.FORTUNE;
    }

    @Override
    public void verifyComponentsAfterLoad(@NotNull ItemStack stack) {
        super.verifyComponentsAfterLoad(stack);
        AugmentWrapper.setType(stack, FORTUNE, (float)(1 + this.tier));
    }

    public int getTier() {
        return tier;
    }

    public @NotNull String getDescriptionId() {
        String var10000 = Component.translatable("item.industrialforegoing.addon").getString();
        return var10000 + Component.translatable("item.ifs.fortune").getString() + Component.translatable("item.industrialforegoing.tier").getString() + this.tier + " ";
    }

    public void addTooltipDetails(@Nullable BasicItem.Key key, @NotNull ItemStack stack, List<Component> tooltip, boolean advanced) {
        String var10001 = String.valueOf(ChatFormatting.GRAY);
        tooltip.add(Component.literal(var10001 + Component.translatable("tooltip.ifs.fortune").getString() + "x" + (this.tier + 1)));
    }

    public boolean hasTooltipDetails(@Nullable BasicItem.Key key) {
        return key == null;
    }

    @Override
    public void addToTab(BuildCreativeModeTabContentsEvent event) {
        ItemStack stack = new ItemStack(this);
        AugmentWrapper.setType(stack, FORTUNE, (float)(1 + this.tier));
        event.accept(stack);
    }
}

package tfar.poolparty.init;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import tfar.poolparty.util.ItemColorFamily;

public class ModCreativeModeTab {
    public static final CreativeModeTab TAB = CreativeModeTab.builder(null,-1).title(Component.translatable("itemGroup.poolparty"))
            .icon(ModItems.WHITE_SWIMMING_TUBE::getDefaultInstance)
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.RUBBER);
                output.accept(ModItems.RUBBER_BLOCK);

                output.accept(ModItems.SWIMMING_TUBE_HOLDER);

                ItemColorFamily.FAMILIES.forEach(itemColorFamily -> itemColorFamily.map.forEach((color, colorable) -> output.accept(colorable)));

            })
            .build();
}

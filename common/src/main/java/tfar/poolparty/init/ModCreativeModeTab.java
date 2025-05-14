package tfar.poolparty.init;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

public class ModCreativeModeTab {
    public static final CreativeModeTab TAB = CreativeModeTab.builder(null,-1).title(Component.translatable("itemGroup.poolparty"))
            .icon(ModItems.WHITE_SWIMMING_TUBE::getDefaultInstance)
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.RUBBER);
                output.accept(ModItems.RUBBER_BLOCK);
                output.accept(ModItems.WHITE_SWIMMING_TUBE);
                output.accept(ModItems.SWIMMING_TUBE_HOLDER);
                output.accept(ModItems.FLOATIES);
                output.accept(ModItems.FLOAT_MAT);
                output.accept(ModItems.POOL_NOODLE);
            })
            .build();
}

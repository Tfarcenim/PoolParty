package tfar.poolparty;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import tfar.poolparty.init.*;

public class PoolPartyFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        Registry.register(BuiltInRegistries.BLOCK,PoolParty.id("rubber_block"),ModBlocks.RUBBER_BLOCK);
        Registry.register(BuiltInRegistries.BLOCK,PoolParty.id("swimming_tube_holder"),ModBlocks.SWIMMING_TUBE_HOLDER);

        ModBlocks.POOL_NOODLES.forEach(floatiesItem -> Registry.register(BuiltInRegistries.BLOCK,PoolParty.id(floatiesItem.color().getName()+"_pool_noodle"),
                floatiesItem));


        Registry.register(BuiltInRegistries.ITEM,PoolParty.id("rubber_block"),ModItems.RUBBER_BLOCK);
        Registry.register(BuiltInRegistries.ITEM,PoolParty.id("rubber"),ModItems.RUBBER);

        Registry.register(BuiltInRegistries.ITEM,PoolParty.id("white_swimming_tube"),ModItems.WHITE_SWIMMING_TUBE);
        Registry.register(BuiltInRegistries.ITEM,PoolParty.id("orange_swimming_tube"),ModItems.ORANGE_SWIMMING_TUBE);
        Registry.register(BuiltInRegistries.ITEM,PoolParty.id("magenta_swimming_tube"),ModItems.MAGENTA_SWIMMING_TUBE);
        Registry.register(BuiltInRegistries.ITEM,PoolParty.id("light_blue_swimming_tube"),ModItems.LIGHT_BLUE_SWIMMING_TUBE);
        Registry.register(BuiltInRegistries.ITEM,PoolParty.id("yellow_swimming_tube"),ModItems.YELLOW_SWIMMING_TUBE);
        Registry.register(BuiltInRegistries.ITEM,PoolParty.id("lime_swimming_tube"),ModItems.LIME_SWIMMING_TUBE);
        Registry.register(BuiltInRegistries.ITEM,PoolParty.id("pink_swimming_tube"),ModItems.PINK_SWIMMING_TUBE);
        Registry.register(BuiltInRegistries.ITEM,PoolParty.id("gray_swimming_tube"),ModItems.GRAY_SWIMMING_TUBE);
        Registry.register(BuiltInRegistries.ITEM,PoolParty.id("light_gray_swimming_tube"),ModItems.LIGHT_GRAY_SWIMMING_TUBE);
        Registry.register(BuiltInRegistries.ITEM,PoolParty.id("cyan_swimming_tube"),ModItems.CYAN_SWIMMING_TUBE);
        Registry.register(BuiltInRegistries.ITEM,PoolParty.id("purple_swimming_tube"),ModItems.PURPLE_SWIMMING_TUBE);
        Registry.register(BuiltInRegistries.ITEM,PoolParty.id("blue_swimming_tube"),ModItems.BLUE_SWIMMING_TUBE);
        Registry.register(BuiltInRegistries.ITEM,PoolParty.id("brown_swimming_tube"),ModItems.BROWN_SWIMMING_TUBE);
        Registry.register(BuiltInRegistries.ITEM,PoolParty.id("green_swimming_tube"),ModItems.GREEN_SWIMMING_TUBE);
        Registry.register(BuiltInRegistries.ITEM,PoolParty.id("red_swimming_tube"),ModItems.RED_SWIMMING_TUBE);
        Registry.register(BuiltInRegistries.ITEM,PoolParty.id("black_swimming_tube"),ModItems.BLACK_SWIMMING_TUBE);

        Registry.register(BuiltInRegistries.ITEM,PoolParty.id("swimming_tube_holder"),ModItems.SWIMMING_TUBE_HOLDER);

        ModItems.FLOATIES.forEach(floatiesItem -> Registry.register(BuiltInRegistries.ITEM,PoolParty.id(floatiesItem.color().getName()+"_floaties"),
                floatiesItem));

        ModItems.FLOAT_MATS.forEach(floatiesItem -> Registry.register(BuiltInRegistries.ITEM,PoolParty.id(floatiesItem.color().getName()+"_float_mat"),
                floatiesItem));

        ModItems.POOL_NOODLES.forEach(floatiesItem -> Registry.register(BuiltInRegistries.ITEM,PoolParty.id(floatiesItem.color.getName()+"_pool_noodle"),
                floatiesItem));




        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,PoolParty.id("tab"),ModCreativeModeTab.TAB);

        Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,PoolParty.id("swimming_tube_holder"),ModBlockEntity.SWIMMING_TUBE_HOLDER);

        Registry.register(BuiltInRegistries.ENTITY_TYPE,PoolParty.id("swimming_tube"),ModEntities.SWIMMING_TUBE);
        Registry.register(BuiltInRegistries.ENTITY_TYPE,PoolParty.id("float_mat"),ModEntities.FLOAT_MAT);
        PoolParty.init();
    }
}

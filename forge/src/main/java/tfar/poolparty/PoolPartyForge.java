package tfar.poolparty;

import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.RegisterEvent;
import tfar.poolparty.init.*;

@Mod(PoolParty.MOD_ID)
public class PoolPartyForge {
    
    public PoolPartyForge() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::register);
        bus.addListener(ModDatagen::gather);
        if (FMLEnvironment.dist.isClient())  {
            PoolPartyClientForge.onInit(bus);
        }
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.
    
        // Use Forge to bootstrap the Common mod.
        PoolParty.init();
    }

    void register(RegisterEvent event) {

        event.register(Registries.BLOCK,PoolParty.id("rubber_block"),() -> ModBlocks.RUBBER_BLOCK);
        event.register(Registries.BLOCK,PoolParty.id("swimming_tube_holder"),() -> ModBlocks.SWIMMING_TUBE_HOLDER);

        event.register(Registries.ITEM,PoolParty.id("rubber_block"),() -> ModItems.RUBBER_BLOCK);
        event.register(Registries.ITEM,PoolParty.id("rubber"),() -> ModItems.RUBBER);

        event.register(Registries.ITEM,PoolParty.id("white_swimming_tube"),() -> ModItems.WHITE_SWIMMING_TUBE);
        event.register(Registries.ITEM,PoolParty.id("orange_swimming_tube"),() -> ModItems.ORANGE_SWIMMING_TUBE);
        event.register(Registries.ITEM,PoolParty.id("magenta_swimming_tube"),() -> ModItems.MAGENTA_SWIMMING_TUBE);
        event.register(Registries.ITEM,PoolParty.id("light_blue_swimming_tube"),() -> ModItems.LIGHT_BLUE_SWIMMING_TUBE);
        event.register(Registries.ITEM,PoolParty.id("yellow_swimming_tube"),() -> ModItems.YELLOW_SWIMMING_TUBE);
        event.register(Registries.ITEM,PoolParty.id("lime_swimming_tube"),() -> ModItems.LIME_SWIMMING_TUBE);
        event.register(Registries.ITEM,PoolParty.id("pink_swimming_tube"),() -> ModItems.PINK_SWIMMING_TUBE);
        event.register(Registries.ITEM,PoolParty.id("gray_swimming_tube"),() -> ModItems.GRAY_SWIMMING_TUBE);
        event.register(Registries.ITEM,PoolParty.id("light_gray_swimming_tube"),() -> ModItems.LIGHT_GRAY_SWIMMING_TUBE);
        event.register(Registries.ITEM,PoolParty.id("cyan_swimming_tube"),() -> ModItems.CYAN_SWIMMING_TUBE);
        event.register(Registries.ITEM,PoolParty.id("purple_swimming_tube"),() -> ModItems.PURPLE_SWIMMING_TUBE);
        event.register(Registries.ITEM,PoolParty.id("blue_swimming_tube"),() -> ModItems.BLUE_SWIMMING_TUBE);
        event.register(Registries.ITEM,PoolParty.id("brown_swimming_tube"),() -> ModItems.BROWN_SWIMMING_TUBE);
        event.register(Registries.ITEM,PoolParty.id("green_swimming_tube"),() -> ModItems.GREEN_SWIMMING_TUBE);
        event.register(Registries.ITEM,PoolParty.id("red_swimming_tube"),() -> ModItems.RED_SWIMMING_TUBE);
        event.register(Registries.ITEM,PoolParty.id("black_swimming_tube"),() -> ModItems.BLACK_SWIMMING_TUBE);

        event.register(Registries.ITEM,PoolParty.id("swimming_tube_holder"),() -> ModItems.SWIMMING_TUBE_HOLDER);
        event.register(Registries.ITEM,PoolParty.id("floaties"),() -> ModItems.FLOATIES);
        event.register(Registries.ITEM,PoolParty.id("float_mat"),() -> ModItems.FLOAT_MAT);
        event.register(Registries.ITEM,PoolParty.id("pool_noodle"),() -> ModItems.POOL_NOODLE);

        event.register(Registries.CREATIVE_MODE_TAB,PoolParty.id("tab"),() -> ModCreativeModeTab.TAB);

        event.register(Registries.BLOCK_ENTITY_TYPE,PoolParty.id("swimming_tube_holder"),() -> ModBlockEntity.SWIMMING_TUBE_HOLDER);

        event.register(Registries.ENTITY_TYPE,PoolParty.id("swimming_tube"),() -> ModEntities.SWIMMING_TUBE);
        event.register(Registries.ENTITY_TYPE,PoolParty.id("float_mat"),() -> ModEntities.FLOAT_MAT);



    }
}
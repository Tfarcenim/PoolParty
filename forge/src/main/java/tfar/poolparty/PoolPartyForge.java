package tfar.poolparty;

import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.RegisterEvent;
import tfar.poolparty.init.ModBlocks;
import tfar.poolparty.init.ModCreativeModeTab;
import tfar.poolparty.init.ModEntities;
import tfar.poolparty.init.ModItems;

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

        event.register(Registries.ITEM,PoolParty.id("rubber_block"),() -> ModItems.RUBBER_BLOCK);
        event.register(Registries.ITEM,PoolParty.id("rubber"),() -> ModItems.RUBBER);
        event.register(Registries.ITEM,PoolParty.id("swimming_tube"),() -> ModItems.SWIMMING_TUBE);

        event.register(Registries.CREATIVE_MODE_TAB,PoolParty.id("tab"),() -> ModCreativeModeTab.TAB);

        event.register(Registries.ENTITY_TYPE,PoolParty.id("swimming_tube"),() -> ModEntities.SWIMMING_TUBE);

    }
}
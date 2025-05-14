package tfar.poolparty;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import tfar.poolparty.init.ModBlocks;
import tfar.poolparty.init.ModItems;

public class PoolPartyFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        Registry.register(BuiltInRegistries.BLOCK,PoolParty.id("rubber_block"), ModBlocks.RUBBER_BLOCK);

        Registry.register(BuiltInRegistries.ITEM,PoolParty.id("rubber"), ModItems.RUBBER);
        Registry.register(BuiltInRegistries.ITEM,PoolParty.id("rubber_block"), ModItems.RUBBER_BLOCK);
        PoolParty.init();
    }
}

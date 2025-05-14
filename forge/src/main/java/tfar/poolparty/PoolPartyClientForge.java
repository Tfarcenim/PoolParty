package tfar.poolparty;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import tfar.poolparty.client.PoolPartyClient;

public class PoolPartyClientForge {
    public static void onInit(IEventBus bus) {
        bus.addListener(PoolPartyClientForge::renderers);
    }

    static void renderers(EntityRenderersEvent.RegisterRenderers event){
        PoolPartyClient.renderers();
    }
}

package tfar.poolparty;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import tfar.poolparty.client.PoolPartyClient;

public class PoolPartyClientForge {
    public static void onInit(IEventBus bus) {
        bus.addListener(PoolPartyClientForge::renderers);
        bus.addListener(PoolPartyClientForge::itemColors);
    }

    static void renderers(EntityRenderersEvent.RegisterRenderers event){
        PoolPartyClient.renderers();
    }

    static void itemColors(RegisterColorHandlersEvent.Item event) {
        PoolPartyClient.itemcolors(event.getItemColors());
    }
}

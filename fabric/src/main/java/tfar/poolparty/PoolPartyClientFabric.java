package tfar.poolparty;

import net.fabricmc.api.ClientModInitializer;
import tfar.poolparty.client.PoolPartyClient;

public class PoolPartyClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PoolPartyClient.renderers();
    }
}

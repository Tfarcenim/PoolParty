package tfar.poolparty;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.world.entity.LivingEntity;
import tfar.poolparty.client.PoolPartyClient;

public class PoolPartyClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PoolPartyClient.renderers();
    }


}

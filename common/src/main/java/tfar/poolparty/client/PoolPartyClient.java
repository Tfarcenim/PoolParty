package tfar.poolparty.client;

import net.minecraft.client.renderer.entity.EntityRenderers;
import tfar.poolparty.init.ModEntities;

public class PoolPartyClient {

    public static void renderers() {
        EntityRenderers.register(ModEntities.SWIMMING_TUBE,SwimmingTubeRenderer::new);
    }
}

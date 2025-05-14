package tfar.poolparty.client;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.player.Player;
import tfar.poolparty.init.ModEntities;

public class PoolPartyClient {

    public static void renderers() {
        EntityRenderers.register(ModEntities.SWIMMING_TUBE,SwimmingTubeRenderer::new);
        EntityRenderers.register(ModEntities.FLOAT_MAT,FloatMatRenderer::new);
    }

    public static void handleFloating(Player player) {
        if (player instanceof LocalPlayer localPlayer) {
            localPlayer.input.jumping = true;
        }
    }
}

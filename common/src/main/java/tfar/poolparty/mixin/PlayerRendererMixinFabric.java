package tfar.poolparty.mixin;

import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tfar.poolparty.client.FloatiesLayer;
import tfar.poolparty.client.SwimmingTubeLayer;

@Mixin(PlayerRenderer.class)
public abstract class PlayerRendererMixinFabric extends LivingEntityRenderer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {

    public PlayerRendererMixinFabric(EntityRendererProvider.Context context, PlayerModel<AbstractClientPlayer> model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Inject(method = "<init>",at = @At("RETURN"))
    void addNewLayers(EntityRendererProvider.Context context, boolean useSlimModel, CallbackInfo ci) {
        this.addLayer(new SwimmingTubeLayer<>(this, context.getItemRenderer()));
        this.addLayer(new FloatiesLayer<>(this, context.getItemRenderer()));
    }
}
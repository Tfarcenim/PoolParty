package tfar.poolparty.mixin;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.poolparty.client.PoolPartyClient;

@Mixin(BlockColors.class)
public class BlockColorsMixinFabric {
    @Inject(method = "createDefault",at = @At("RETURN"))
    private static void addExtras(CallbackInfoReturnable<BlockColors> cir) {
        PoolPartyClient.blockcolors(cir.getReturnValue());
    }
}

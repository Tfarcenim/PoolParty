package tfar.poolparty.mixin;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.poolparty.client.PoolPartyClient;

@Mixin(ItemColors.class)
public class ItemColorsMixinFabric {
    @Inject(method = "createDefault",at = @At("RETURN"))
    private static void addExtras(BlockColors colors, CallbackInfoReturnable<ItemColors> cir) {
        PoolPartyClient.itemcolors(cir.getReturnValue());
    }
}

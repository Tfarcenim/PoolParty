package tfar.poolparty.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import tfar.poolparty.SwimmingTubeBlockEntity;

public class SwimmingTubeHolderBlockEntityRenderer implements BlockEntityRenderer<SwimmingTubeBlockEntity> {
    ItemRenderer itemRenderer;
    public SwimmingTubeHolderBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(SwimmingTubeBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        NonNullList<ItemStack> items = blockEntity.items;
        for (int i = 0; i < items.size(); i++) {
            ItemStack itemStack = items.get(i);
            poseStack.pushPose();
            poseStack.translate(.5,i * .375+.25,.5);
            itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED, packedLight, OverlayTexture.NO_OVERLAY, poseStack, buffer, blockEntity.getLevel(), 0);
            poseStack.popPose();
        }
    }
}

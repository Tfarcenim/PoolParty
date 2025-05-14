package tfar.poolparty.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import tfar.poolparty.entity.FloatMatEntity;
import tfar.poolparty.init.ModItems;

public class FloatMatRenderer extends EntityRenderer<FloatMatEntity> {
    ItemRenderer itemRenderer;
    protected FloatMatRenderer(EntityRendererProvider.Context context) {
        super(context);
        itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(FloatMatEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        ItemStack stack = ModItems.WHITE_SWIMMING_TUBE.getDefaultInstance();
        poseStack.pushPose();
        float scale = 2;
        itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED,packedLight, OverlayTexture.NO_OVERLAY,poseStack,buffer,entity.level(),0);
        poseStack.popPose();
        super.render(entity, entityYaw, partialTick, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(FloatMatEntity FloatMatEntity) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}

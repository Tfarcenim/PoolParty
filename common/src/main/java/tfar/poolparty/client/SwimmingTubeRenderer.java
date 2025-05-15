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
import tfar.poolparty.entity.SwimmingTubeEntity;

public class SwimmingTubeRenderer extends EntityRenderer<SwimmingTubeEntity> {
    ItemRenderer itemRenderer;
    protected SwimmingTubeRenderer(EntityRendererProvider.Context context) {
        super(context);
        itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(SwimmingTubeEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        ItemStack stack = entity.getItem();
        itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED,packedLight, OverlayTexture.NO_OVERLAY,poseStack,buffer,entity.level(),0);
        super.render(entity, entityYaw, partialTick, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(SwimmingTubeEntity swimmingTubeEntity) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}

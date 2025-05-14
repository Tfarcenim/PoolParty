package tfar.poolparty.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.*;
import tfar.poolparty.init.ModItems;

public class SwimmingTubeLayer<T extends LivingEntity, M extends HumanoidModel<T>> extends RenderLayer<T, M> {

    private final float scaleX;
    private final float scaleY;
    private final float scaleZ;
    ItemRenderer itemRenderer;
    public SwimmingTubeLayer(RenderLayerParent<T, M> renderer, EntityModelSet modelSet, ItemRenderer itemInHandRenderer) {
        this(renderer, modelSet, 1.0F, 1.0F, 1.0F, itemInHandRenderer);
    }

    public SwimmingTubeLayer(RenderLayerParent<T, M> renderer, EntityModelSet modelSet, float scaleX, float scaleY, float scaleZ, ItemRenderer itemRenderer) {
        super(renderer);
        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.scaleZ = scaleZ;
        this.itemRenderer = itemRenderer;
    }

    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, T livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ItemStack itemstack = livingEntity.getItemBySlot(EquipmentSlot.LEGS);
        if (itemstack.is(ModItems.WHITE_SWIMMING_TUBE)) {
            Item item = itemstack.getItem();
            poseStack.pushPose();
            poseStack.scale(this.scaleX, this.scaleY, this.scaleZ);
            boolean flag = livingEntity instanceof Villager || livingEntity instanceof ZombieVillager;
            if (livingEntity.isBaby() && !(livingEntity instanceof Villager)) {
                float f = 2.0F;
                float f1 = 1.4F;
                poseStack.translate(0.0F, 0.03125F, 0.0F);
                poseStack.scale(0.7F, 0.7F, 0.7F);
                poseStack.translate(0.0F, 1.0F, 0.0F);
            }

            this.getParentModel().body.translateAndRotate(poseStack);
            translateToHead(poseStack, flag);
            this.itemRenderer.renderStatic(livingEntity, itemstack, ItemDisplayContext.HEAD, false,poseStack, buffer,livingEntity.level(),
                    packedLight, OverlayTexture.NO_OVERLAY,0);

            poseStack.popPose();
        }
    }

    public static void translateToHead(PoseStack poseStack, boolean isVillager) {
        float f = 0.625F;
        poseStack.translate(0.0F, -0.25F, 0.0F);
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
        poseStack.scale(0.625F, -0.625F, -0.625F);
        if (isVillager) {
            poseStack.translate(0.0F, 0.1875F, 0.0F);
        }

    }
}

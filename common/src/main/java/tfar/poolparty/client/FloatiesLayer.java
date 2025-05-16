package tfar.poolparty.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import tfar.poolparty.item.FloatiesItem;
import tfar.poolparty.item.SwimmingTubeItem;

public class FloatiesLayer<T extends LivingEntity, M extends HumanoidModel<T>> extends RenderLayer<T, M> {

    private final float scaleX;
    private final float scaleY;
    private final float scaleZ;
    ItemRenderer itemRenderer;
    public FloatiesLayer(RenderLayerParent<T, M> renderer, ItemRenderer itemInHandRenderer) {
        this(renderer, 1.0F, 1.0F, 1.0F, itemInHandRenderer);
    }

    public FloatiesLayer(RenderLayerParent<T, M> renderer, float scaleX, float scaleY, float scaleZ, ItemRenderer itemRenderer) {
        super(renderer);
        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.scaleZ = scaleZ;
        this.itemRenderer = itemRenderer;
    }

    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, T livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ItemStack itemstack = livingEntity.getItemBySlot(EquipmentSlot.CHEST);
        if (itemstack.getItem() instanceof FloatiesItem) {
            poseStack.pushPose();
            poseStack.scale(this.scaleX, this.scaleY, this.scaleZ);
            boolean isVillager = livingEntity instanceof Villager || livingEntity instanceof ZombieVillager;
            if (livingEntity.isBaby() && !(livingEntity instanceof Villager)) {
                float f = 2.0F;
                float f1 = 1.4F;
                poseStack.translate(0.0F, 0.03125F, 0.0F);
                poseStack.scale(0.7F, 0.7F, 0.7F);
                poseStack.translate(0.0F, 1.0F, 0.0F);
            }

            this.getParentModel().rightArm.translateAndRotate(poseStack);
            poseStack.translate(0, .25, .125);
            this.itemRenderer.renderStatic(livingEntity, itemstack, ItemDisplayContext.FIXED, false,poseStack, buffer,livingEntity.level(),
                    packedLight, OverlayTexture.NO_OVERLAY,0);
            poseStack.popPose();

            poseStack.pushPose();
            poseStack.scale(this.scaleX, this.scaleY, this.scaleZ);
            if (livingEntity.isBaby() && !(livingEntity instanceof Villager)) {
                float f = 2.0F;
                float f1 = 1.4F;
                poseStack.translate(0.0F, 0.03125F, 0.0F);
                poseStack.scale(0.7F, 0.7F, 0.7F);
                poseStack.translate(0.0F, 1.0F, 0.0F);
            }

            this.getParentModel().leftArm.translateAndRotate(poseStack);
            poseStack.translate(0, .25, .125);
            this.itemRenderer.renderStatic(livingEntity, itemstack, ItemDisplayContext.FIXED, false,poseStack, buffer,livingEntity.level(),
                    packedLight, OverlayTexture.NO_OVERLAY,0);
            poseStack.popPose();
        }
    }

    public static void translateToHead(PoseStack poseStack, boolean isVillager) {
        float f = 0.625F;
        poseStack.translate(0, .25, .125);
       // poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
       // poseStack.scale(0.625F, -0.625F, -0.625F);


    }
}

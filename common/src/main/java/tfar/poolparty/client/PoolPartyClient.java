package tfar.poolparty.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import tfar.poolparty.entity.FloatMatEntity;
import tfar.poolparty.init.ModBlockEntity;
import tfar.poolparty.init.ModEntities;
import tfar.poolparty.util.BlockColorFamily;
import tfar.poolparty.util.ItemColorFamily;

public class PoolPartyClient {

    public static void renderers() {
        EntityRenderers.register(ModEntities.SWIMMING_TUBE,SwimmingTubeRenderer::new);
        EntityRenderers.register(ModEntities.FLOAT_MAT,FloatMatRenderer::new);
        BlockEntityRenderers.register(ModBlockEntity.SWIMMING_TUBE_HOLDER, SwimmingTubeHolderBlockEntityRenderer::new);

    }

    public static <T extends LivingEntity> void setupRendering(T entityLiving, PoseStack poseStack, float ageInTicks, float rotationYaw, float partialTicks) {
        if (entityLiving.getVehicle() instanceof FloatMatEntity && entityLiving.hasPose(Pose.SLEEPING)) {
            poseStack.translate(0,-1,0);
        }
    }

    public static void itemcolors(ItemColors colors) {
        ItemColorFamily.FAMILIES.forEach(itemColorFamily -> itemColorFamily.map.values().forEach(colorable -> colors.register((stack, tintIndex) -> colorable.color().getTextColor(),colorable)));
    }

    public static void blockcolors(BlockColors colors) {
        BlockColorFamily.POOL_NOODLES.map.forEach((dyeColor,colorable)-> colors.register((state, level, pos, tintIndex) -> colorable.color().getTextColor(),colorable));
    }

    public static void handleFloating(Player player) {
        if (player instanceof LocalPlayer localPlayer) {
            localPlayer.input.jumping = true;
        }
    }
}

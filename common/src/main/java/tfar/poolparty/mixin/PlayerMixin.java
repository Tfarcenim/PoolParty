package tfar.poolparty.mixin;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tfar.poolparty.entity.FloatMatEntity;
import tfar.poolparty.item.PoolNoodleItem;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity {

    protected PlayerMixin(EntityType<? extends LivingEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "attack",at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z"),
            cancellable = true)
    private void onAttack(Entity target, CallbackInfo ci) {
        if (getMainHandItem().getItem() instanceof PoolNoodleItem) {
            ((LivingEntity)target).knockback(1, Mth.sin(this.getYRot() * ((float)Math.PI / 180F)), -Mth.cos(this.getYRot() * ((float)Math.PI / 180F)));
            ci.cancel();
        }
    }

    @Inject(method = "updatePlayerPose",at = @At("RETURN"))
    private void forcepose(CallbackInfo ci) {
        if (getVehicle() instanceof FloatMatEntity) {
            setPose(Pose.SLEEPING);
        }
    }
}

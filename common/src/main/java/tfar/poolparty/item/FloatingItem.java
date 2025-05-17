package tfar.poolparty.item;

import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import tfar.poolparty.client.PoolPartyClient;

public class FloatingItem extends Item implements Equipable,Colorable {
    private final DyeColor color;
    private final EquipmentSlot slot;

    public FloatingItem(Properties properties, DyeColor color, EquipmentSlot slot) {
        super(properties);
        this.color = color;
        this.slot = slot;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);
        if(entity instanceof LivingEntity livingEntity && livingEntity.getItemBySlot(getEquipmentSlot()).is(this) && shouldFloat(livingEntity) ) {
            if (livingEntity instanceof Player player) {
                if (player.level().isClientSide) {
                    PoolPartyClient.handleFloating(player);
                }
            }
        }
    }

    boolean shouldFloat(LivingEntity entity) {
        return entity.isInWater() && entity.getFluidHeight(FluidTags.WATER) > .875;//entity.getFluidJumpThreshold();
    }

    @Override
    public EquipmentSlot getEquipmentSlot() {
        return slot;
    }

    @Override
    public DyeColor color() {
        return color;
    }
}

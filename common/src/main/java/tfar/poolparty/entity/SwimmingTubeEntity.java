package tfar.poolparty.entity;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import tfar.poolparty.init.ModEntities;

public class SwimmingTubeEntity extends FloatingEntity{



    public SwimmingTubeEntity(EntityType<? extends SwimmingTubeEntity> entityType, Level level) {
        super(entityType, level);
    }

    public SwimmingTubeEntity(Level level, double x, double y, double z,ItemStack stack) {
        super(ModEntities.FLOAT_MAT,level,x,y,z,stack);
    }


    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        if (player.isSecondaryUseActive()) {
            return InteractionResult.PASS;
        } else {
                InteractionResultHolder<ItemStack> holder = swapWithEquipmentSlot(getItem(), level(), player);
                if (holder.getResult().consumesAction() && !level().isClientSide) {
                    discard();
                }

               return holder.getResult();
        }
    }

     InteractionResultHolder<ItemStack> swapWithEquipmentSlot(ItemStack stack, Level level, Player player) {
        EquipmentSlot equipmentslot = Mob.getEquipmentSlotForItem(stack);
        ItemStack itemstack1 = player.getItemBySlot(equipmentslot);
        if (!EnchantmentHelper.hasBindingCurse(itemstack1) && !ItemStack.matches(stack, itemstack1)) {
            if (!level.isClientSide()) {
                player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
            }

            ItemStack itemstack2 = itemstack1.isEmpty() ? stack : itemstack1.copyAndClear();
            ItemStack itemstack3 = stack.copyAndClear();
            player.setItemSlot(equipmentslot, itemstack3);
            return InteractionResultHolder.sidedSuccess(itemstack2, level.isClientSide());
        } else {
            return InteractionResultHolder.fail(stack);
        }
    }
}

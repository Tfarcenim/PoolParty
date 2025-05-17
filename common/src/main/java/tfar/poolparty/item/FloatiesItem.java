package tfar.poolparty.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FloatiesItem extends FloatingItem {

    public FloatiesItem(Properties properties, DyeColor dyeColor) {
        super(properties,dyeColor,EquipmentSlot.CHEST);
    }

    /**
     * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see {@link #use(Level, Player, InteractionHand)}.
     */
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return this.swapWithEquipmentSlot(this, level, player, hand);
    }
}

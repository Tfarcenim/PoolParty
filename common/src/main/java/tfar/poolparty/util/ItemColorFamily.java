package tfar.poolparty.util;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import tfar.poolparty.init.ModItems;
import tfar.poolparty.item.Colorable;
import tfar.poolparty.item.SwimmingTubeItem;

import java.util.EnumMap;
import java.util.Map;

public class ItemColorFamily<T extends Item & Colorable> {

    public static final ItemColorFamily<SwimmingTubeItem> SWIMMING_TUBES = new ItemColorFamily<>(SwimmingTubeItem.class);

    public final Map<DyeColor, T> map;

    public ItemColorFamily(Class<T> targetClass) {
        map = new EnumMap<>(DyeColor.class);
        for(Item item : ModItems.ITEMS) {
            if (targetClass.isInstance(item)) {
                T itemT = (T)item;
                map.put(itemT.color(),itemT);
            }
        }
    }
}

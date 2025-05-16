package tfar.poolparty.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import tfar.poolparty.init.ModItems;
import tfar.poolparty.item.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ItemColorFamily<T extends Item & Colorable> {

    public static final List<ItemColorFamily<? extends Colorable>> FAMILIES = new ArrayList<>();

    public static final ItemColorFamily<SwimmingTubeItem> SWIMMING_TUBES = new ItemColorFamily<>(SwimmingTubeItem.class);
    public static final ItemColorFamily<FloatiesItem> FLOATIES = new ItemColorFamily<>(FloatiesItem.class);
    public static final ItemColorFamily<FloatMatItem> FLOAT_MATS = new ItemColorFamily<>(FloatMatItem.class);
    public static final ItemColorFamily<PoolNoodleItem> POOL_NOODLES = new ItemColorFamily<>(PoolNoodleItem.class);



    public final Map<DyeColor, T> map;

    public ItemColorFamily(Class<T> targetClass) {
        FAMILIES.add(this);
        map = new EnumMap<>(DyeColor.class);
        for(Item item : ModItems.ITEMS) {
            if (targetClass.isInstance(item)) {
                T itemT = (T)item;
                map.put(itemT.color(),itemT);
            }
        }
    }
}

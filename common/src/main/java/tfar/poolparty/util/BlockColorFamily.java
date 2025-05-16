package tfar.poolparty.util;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import tfar.poolparty.PoolNoodleBlock;
import tfar.poolparty.init.ModBlocks;
import tfar.poolparty.init.ModItems;
import tfar.poolparty.item.Colorable;
import tfar.poolparty.item.FloatMatItem;
import tfar.poolparty.item.FloatiesItem;
import tfar.poolparty.item.SwimmingTubeItem;

import java.util.EnumMap;
import java.util.Map;

public class BlockColorFamily<T extends Block & Colorable> {

    public static final BlockColorFamily<PoolNoodleBlock> POOL_NOODLES = new BlockColorFamily<>(PoolNoodleBlock.class);
    public final Map<DyeColor, T> map;

    public BlockColorFamily(Class<T> targetClass) {
        map = new EnumMap<>(DyeColor.class);
        for(Block block : ModBlocks.BLOCKS) {
            if (targetClass.isInstance(block)) {
                T itemT = (T)block;
                map.put(itemT.color(),itemT);
            }
        }
    }
}

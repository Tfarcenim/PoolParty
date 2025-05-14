package tfar.poolparty.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import tfar.poolparty.SwimmingTubeItem;

public class ModItems {
    public static final Item RUBBER = new Item(new Item.Properties());
    public static final BlockItem RUBBER_BLOCK = new BlockItem(ModBlocks.RUBBER_BLOCK,new Item.Properties());
    public static final Item SWIMMING_TUBE = new SwimmingTubeItem(new Item.Properties());
}

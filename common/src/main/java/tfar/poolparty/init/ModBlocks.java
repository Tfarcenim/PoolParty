package tfar.poolparty.init;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import tfar.poolparty.PoolNoodleBlock;
import tfar.poolparty.RubberBlock;
import tfar.poolparty.SwimmingTubeHolderBlock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final Block RUBBER_BLOCK = new RubberBlock(BlockBehaviour.Properties.of().strength(.25f));
    public static final Block SWIMMING_TUBE_HOLDER = new SwimmingTubeHolderBlock(BlockBehaviour.Properties.of().strength(1.5f));

    public static final List<PoolNoodleBlock> POOL_NOODLES = Arrays.stream(DyeColor.values()).map(ModBlocks::poolNoodle).toList();

    static PoolNoodleBlock poolNoodle(DyeColor color) {
        PoolNoodleBlock poolNoodleBlock = new PoolNoodleBlock(BlockBehaviour.Properties.of(), color);
        BLOCKS.add(poolNoodleBlock);
        return poolNoodleBlock;
    }

}

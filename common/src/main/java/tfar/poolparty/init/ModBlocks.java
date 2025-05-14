package tfar.poolparty.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import tfar.poolparty.RubberBlock;
import tfar.poolparty.SwimmingTubeHolderBlock;

public class ModBlocks {
    public static final Block RUBBER_BLOCK = new RubberBlock(BlockBehaviour.Properties.of().strength(.25f));
    public static final Block SWIMMING_TUBE_HOLDER = new SwimmingTubeHolderBlock(BlockBehaviour.Properties.of().strength(1.5f));


}

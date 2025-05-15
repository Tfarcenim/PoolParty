package tfar.poolparty.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import tfar.poolparty.SwimmingTubeBlockEntity;

public class ModBlockEntity {

    public static final BlockEntityType<SwimmingTubeBlockEntity> SWIMMING_TUBE_HOLDER =
            BlockEntityType.Builder.of(SwimmingTubeBlockEntity::new,ModBlocks.SWIMMING_TUBE_HOLDER).build(null);

}

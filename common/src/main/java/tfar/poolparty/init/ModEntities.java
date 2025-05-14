package tfar.poolparty.init;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import tfar.poolparty.SwimmingTubeEntity;

public class ModEntities {
    public static final EntityType<SwimmingTubeEntity> SWIMMING_TUBE = EntityType.Builder.<SwimmingTubeEntity>of(SwimmingTubeEntity::new, MobCategory.MISC)
            .sized(1.125F, 0.3125f).build("");
}

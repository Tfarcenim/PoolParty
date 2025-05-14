package tfar.poolparty.init;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import tfar.poolparty.entity.FloatMatEntity;
import tfar.poolparty.entity.SwimmingTubeEntity;

public class ModEntities {
    public static final EntityType<SwimmingTubeEntity> SWIMMING_TUBE = EntityType.Builder.<SwimmingTubeEntity>of(SwimmingTubeEntity::new, MobCategory.MISC)
            .sized(1.125F, 0.3125f).build("");

    public static final EntityType<FloatMatEntity> FLOAT_MAT = EntityType.Builder.<FloatMatEntity>of(FloatMatEntity::new, MobCategory.MISC)
            .sized(1.5F, 0.5f).build("");
}

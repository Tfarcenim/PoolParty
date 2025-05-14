package tfar.poolparty;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

public class SwimmingTubeHolderBlock extends Block {

    public static final EnumProperty<DyeColor> TOP_COLOR = EnumProperty.create("top_color", DyeColor.class);
    public static final EnumProperty<DyeColor> MIDDLE_COLOR = EnumProperty.create("middle_color", DyeColor.class);
    public static final EnumProperty<DyeColor> BOTTOM_COLOR = EnumProperty.create("bottom_color", DyeColor.class);

    public static final IntegerProperty TUBES = IntegerProperty.create("tubes",0,3);

    public SwimmingTubeHolderBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(TOP_COLOR,MIDDLE_COLOR,BOTTOM_COLOR,TUBES);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        return super.use(state, level, pos, player, hand, hit);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
        List<ItemStack> drops1 = super.getDrops(state, params);

        return drops1;
    }
}

package tfar.poolparty;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.IceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import tfar.poolparty.item.Colorable;

public class PoolNoodleBlock extends DirectionalBlock implements Colorable {
    private final DyeColor color;

    public static final VoxelShape x_shape = box(0,7,7,16,9,9);
    public static final VoxelShape y_shape = box(7,0,7,9,16,9);
    public static final VoxelShape z_shape = box(7,7,0,9,9,16);

    public PoolNoodleBlock(Properties properties, DyeColor color) {
        super(properties);
        this.color = color;
        registerDefaultState(defaultBlockState().setValue(FACING,Direction.UP));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING).getAxis()) {
            case X -> x_shape;
            case Y -> y_shape;
            case Z -> z_shape;
        };
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return this.mayPlaceOn(pos, level,state.getValue(FACING));
    }


    protected boolean mayPlaceOn(BlockPos pos, LevelReader level, Direction direction) {
        BlockPos pos1 = pos.relative(direction.getOpposite());

        BlockState support = level.getBlockState(pos1);

        boolean canSupportCenter = support.isFaceSturdy(level,pos,direction);

        if (canSupportCenter) {
            return true;
        }

        FluidState fluidstate = level.getFluidState(pos1);
        return fluidstate.getType() == Fluids.WATER || support.getBlock() instanceof IceBlock;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getClickedFace();
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos().relative(direction.getOpposite()));
        return blockstate.is(this) && blockstate.getValue(FACING) == direction ? this.defaultBlockState().setValue(FACING, direction.getOpposite()) : this.defaultBlockState().setValue(FACING, direction);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }

    @Override
    public DyeColor color() {
        return color;
    }
}

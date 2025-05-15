package tfar.poolparty;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import tfar.poolparty.item.SwimmingTubeItem;

import java.util.List;

public class SwimmingTubeHolderBlock extends Block implements EntityBlock {


    public SwimmingTubeHolderBlock(Properties properties) {
        super(properties);
    }

    public static final VoxelShape shape = box(1,0,1,15,16,15);

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return shape;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof SwimmingTubeBlockEntity swimmingTubeBlockEntity) {
            ItemStack stack = player.getItemInHand(hand);
            int count = swimmingTubeBlockEntity.getCount();
            if (stack.getItem() instanceof SwimmingTubeItem) {
                if (count < SwimmingTubeBlockEntity.COUNT) {
                    if (!level.isClientSide) {
                        swimmingTubeBlockEntity.add(stack);
                      //  if (!player.getAbilities().instabuild) {
                            stack.shrink(1);
                       // }
                    }
                    return InteractionResult.sidedSuccess(level.isClientSide);
                } else {
                    return InteractionResult.FAIL;
                }
            } else {
                if (count == 0) {
                    return InteractionResult.FAIL;
                } else if (stack.isEmpty()) {
                    if (!level.isClientSide) {
                        swimmingTubeBlockEntity.take(player,hand);
                    }
                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
            }
        }
        return super.use(state, level, pos, player, hand, hit);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
        List<ItemStack> drops1 = super.getDrops(state, params);

        return drops1;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SwimmingTubeBlockEntity(pos,state);
    }
}

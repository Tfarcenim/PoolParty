package tfar.poolparty;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import tfar.poolparty.init.ModBlockEntity;

import javax.annotation.Nonnull;

public class SwimmingTubeBlockEntity extends BlockEntity {

    public static final int COUNT = 3;

    public NonNullList<ItemStack> items = NonNullList.withSize(COUNT,ItemStack.EMPTY);

    public SwimmingTubeBlockEntity(BlockPos pos, BlockState blockState) {
        this(ModBlockEntity.SWIMMING_TUBE_HOLDER, pos, blockState);
    }

    public SwimmingTubeBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    public int getCount() {
        for (int i = 0; i < COUNT;i++) {
            if (items.get(i).isEmpty()) {
                return i;
            }
        }
        return COUNT;
    }


    public void add(ItemStack stack) {
        for (int i = 0; i < COUNT;i++) {
            if (items.get(i).isEmpty()) {
                items.set(i,stack.copy());
                setChanged();
                break;
            }
        }
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.items = NonNullList.withSize(COUNT, ItemStack.EMPTY);
            ContainerHelper.loadAllItems(tag, this.items);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        ContainerHelper.saveAllItems(tag, this.items);
    }

    @Override
    public void setChanged() {
        super.setChanged();
        level.sendBlockUpdated(worldPosition,getBlockState(),getBlockState(),3);
    }

    @Nonnull
    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();    // okay to send entire inventory on chunk load
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public void take(Player player, InteractionHand hand) {
        for (int i = COUNT-1; i >= 0;i--) {
            ItemStack stack = items.get(i);
            if (!stack.isEmpty()) {
                player.setItemInHand(hand,stack);
                items.set(i,ItemStack.EMPTY);
                setChanged();
                break;
            }
        }
    }
}

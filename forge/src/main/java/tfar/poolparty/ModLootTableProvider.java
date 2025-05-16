package tfar.poolparty;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import tfar.poolparty.init.ModBlocks;
import tfar.poolparty.util.BlockColorFamily;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ModLootTableProvider extends LootTableProvider {


    public ModLootTableProvider(PackOutput output, Set<ResourceLocation> requiredTables, List<SubProviderEntry> subProviders) {
        super(output, requiredTables, subProviders);
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationcontext) {

    }

    public static LootTableProvider create(PackOutput output) {
        return new ModLootTableProvider(output, BuiltInLootTables.all(), List.of(
                new SubProviderEntry(ModBlockLoot::new, LootContextParamSets.BLOCK)));
    }



    static class ModBlockLoot extends VanillaBlockLoot {


        @Override
        protected void generate() {
            dropSelf(ModBlocks.RUBBER_BLOCK);
            dropSelf(ModBlocks.SWIMMING_TUBE_HOLDER);

            BlockColorFamily.POOL_NOODLES.map.values().forEach(this::dropSelf);
        }


        @Override
        protected Iterable<Block> getKnownBlocks() {

            return BuiltInRegistries.BLOCK.stream().filter(block -> BuiltInRegistries.BLOCK.getKey(block)
                    .getNamespace().equals(PoolParty.MOD_ID)).toList();
        }
    }
}

package tfar.poolparty;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import org.codehaus.plexus.util.StringUtils;
import tfar.poolparty.init.ModBlocks;
import tfar.poolparty.init.ModItems;
import tfar.poolparty.util.BlockColorFamily;
import tfar.poolparty.util.ItemColorFamily;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ModDatagen {
    static void gather(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();
        var lookup = event.getLookupProvider();

        ModBlockTags blockTags = new ModBlockTags(output, lookup, helper);

        generator.addProvider(event.includeServer(), blockTags);

        generator.addProvider(event.includeServer(), new ModRecipes(output));
        generator.addProvider(event.includeServer(), ModLootTableProvider.create(output));

        generator.addProvider(event.includeClient(), new ModLang(output));
        generator.addProvider(event.includeClient(), new ModBlockstates(output, helper));
        generator.addProvider(event.includeClient(), new ModItemModels(output, helper));
    }

    static class ModBlockTags extends BlockTagsProvider {

        public ModBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, PoolParty.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.RUBBER_BLOCK);
            tag(BlockTags.MINEABLE_WITH_AXE).add(ModBlocks.SWIMMING_TUBE_HOLDER);
        }
    }

    static class ModRecipes extends RecipeProvider {

        public ModRecipes(PackOutput output) {
            super(output);
        }

        @Override
        protected void buildRecipes(Consumer<FinishedRecipe> writer) {
            nineBlockStorageRecipes(writer, RecipeCategory.REDSTONE, ModItems.RUBBER, RecipeCategory.REDSTONE, ModItems.RUBBER_BLOCK);

            ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.SWIMMING_TUBE_HOLDER)
                    .define('s', Items.STICK)
                    .define('c', Items.STONE_SLAB)
                    .pattern("s")
                    .pattern("s")
                    .pattern("c").unlockedBy("has_slab", has(Items.STONE_SLAB)).save(writer);

            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RUBBER)
                    .requires(Items.DRIED_KELP).requires(Items.DRIED_KELP)
                    .unlockedBy(getHasName(Items.DRIED_KELP), has(Items.DRIED_KELP))
                    .save(writer);

            ItemColorFamily.SWIMMING_TUBES.map.forEach((color, swimmingTubeItem) -> {
                ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, swimmingTubeItem)
                        .define('#', ModItems.RUBBER)
                        .define('c', DyeItem.byColor(color))
                        .pattern("###").pattern("#c#").pattern("###").unlockedBy("has_rubber", has(ModItems.RUBBER)).save(writer);
            });

            ItemColorFamily.FLOATIES.map.forEach((color, swimmingTubeItem) -> {
                ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, swimmingTubeItem)
                        .define('#', ModItems.RUBBER)
                        .define('c', DyeItem.byColor(color))
                        .pattern("#c#").unlockedBy("has_rubber", has(ModItems.RUBBER)).save(writer);
            });

            ItemColorFamily.FLOAT_MATS.map.forEach((color, swimmingTubeItem) -> {
                ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, swimmingTubeItem)
                        .define('#', ModItems.RUBBER)
                        .define('c', DyeItem.byColor(color))
                        .pattern("#c#")
                        .pattern("###").unlockedBy("has_rubber", has(ModItems.RUBBER)).save(writer);
            });

            ItemColorFamily.POOL_NOODLES.map.forEach((color, swimmingTubeItem) -> {
                ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, swimmingTubeItem)
                        .define('#', ModItems.RUBBER)
                        .define('c', DyeItem.byColor(color))
                        .pattern("c#")
                        .pattern(" #")
                        .pattern(" #").unlockedBy("has_rubber", has(ModItems.RUBBER)).save(writer);
            });



        }
    }

    static class ModLang extends LanguageProvider {

        public ModLang(PackOutput output) {
            super(output, PoolParty.MOD_ID, "en_us");
        }

        @Override
        protected void addTranslations() {
            BuiltInRegistries.ITEM.stream().filter(item -> BuiltInRegistries.ITEM.getKey(item).getNamespace().equals(PoolParty.MOD_ID)).forEach(item -> {
                addDefaultItem(() -> item);
            });

            add("itemGroup.poolparty", "Pool Party");
        }

        protected void addDefaultItem(Supplier<? extends Item> supplier) {
            addItem(supplier,getNameFromItem(supplier.get()));
        }

        protected void addDefaultBlock(Supplier<? extends Block> supplier) {
            addBlock(supplier,getNameFromBlock(supplier.get()));
        }

        protected void addDefaultEnchantment(Supplier<? extends Enchantment> supplier) {
            addEnchantment(supplier,getNameFromEnchantment(supplier.get()));
        }

        protected void addDefaultEntityType(Supplier<EntityType<?>> supplier) {
            addEntityType(supplier,getNameFromEntity(supplier.get()));
        }

        public static String getNameFromItem(Item item) {
            return StringUtils.capitaliseAllWords(item.getDescriptionId().split("\\.")[2].replace("_", " "));
        }

        public static String getNameFromBlock(Block block) {
            return StringUtils.capitaliseAllWords(block.getDescriptionId().split("\\.")[2].replace("_", " "));
        }

        public static String getNameFromEnchantment(Enchantment enchantment) {
            return StringUtils.capitaliseAllWords(enchantment.getDescriptionId().split("\\.")[2].replace("_", " "));
        }

        public static String getNameFromEntity(EntityType<?> entity) {
            return StringUtils.capitaliseAllWords(entity.getDescriptionId().split("\\.")[2].replace("_", " "));
        }

        protected void addTextComponent(MutableComponent component, String text) {
            ComponentContents contents = component.getContents();
            if (contents instanceof TranslatableContents translatableContents) {
                add(translatableContents.getKey(),text);
            } else {
                throw new UnsupportedOperationException(component +" is not translatable");
            }
        }
    }

    static class ModItemModels extends ItemModelProvider {

        public ModItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
            super(output, PoolParty.MOD_ID, existingFileHelper);
        }

        @Override
        protected void registerModels() {
            generatedItem(ModItems.RUBBER);

            ItemColorFamily.SWIMMING_TUBES.map.forEach((color, swimmingTubeItem) -> {
                withExistingParent(color.getName()+"_swimming_tube",modLoc("item/swimming_tube"));
            });

            ItemColorFamily.FLOATIES.map.forEach((color, swimmingTubeItem) -> {
                withExistingParent(color.getName()+"_floaties",modLoc("item/floaties"));
            });

            ItemColorFamily.FLOAT_MATS.map.forEach((color, swimmingTubeItem) -> {
                withExistingParent(color.getName()+"_float_mat",modLoc("item/float_mat"));
            });
        }

        private void generatedItem(Item item, ResourceLocation texture) {
            String path = name(item);
            singleTexture(path, mcLoc("item/generated"),
                    "layer0", texture);
        }

        private void generatedItem(Item item) {
            generatedItem(item, modLoc("item/" + name(item)));
        }

        protected String name(Item item) {
            return BuiltInRegistries.ITEM.getKey(item).getPath();
        }

    }

    static class ModBlockstates extends BlockStateProvider {

        public ModBlockstates(PackOutput output, ExistingFileHelper exFileHelper) {
            super(output, PoolParty.MOD_ID, exFileHelper);
        }

        @Override
        protected void registerStatesAndModels() {
            simpleBlockWithItem(ModBlocks.RUBBER_BLOCK, models().getExistingFile(modLoc("block/rubber_block")));
            simpleBlockWithItem(ModBlocks.SWIMMING_TUBE_HOLDER, models().getExistingFile(modLoc("block/swimming_tube_holder")));

            BlockColorFamily.POOL_NOODLES.map.forEach((color, poolNoodleBlock) -> {
                ModelFile modelFile = models().withExistingParent("block/"+color.getName()+"_pool_noodle",modLoc("block/pool_noodle"));

                directionalBlock(poolNoodleBlock,modelFile);

                simpleBlockItem(poolNoodleBlock,modelFile);
            });
        }
    }
}

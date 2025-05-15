package tfar.poolparty;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import tfar.poolparty.init.ModBlocks;
import tfar.poolparty.init.ModItems;
import tfar.poolparty.util.ItemColorFamily;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

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
        }
    }

    static class ModLang extends LanguageProvider {

        public ModLang(PackOutput output) {
            super(output, PoolParty.MOD_ID, "en_us");
        }

        @Override
        protected void addTranslations() {
            add(ModBlocks.RUBBER_BLOCK, "Rubber Block");
            add(ModItems.RUBBER, "Rubber");
            add(ModItems.WHITE_SWIMMING_TUBE, "White Swimming Tube");
            add(ModItems.ORANGE_SWIMMING_TUBE, "Orange Swimming Tube");
            add(ModItems.MAGENTA_SWIMMING_TUBE, "Magenta Swimming Tube");
            add(ModItems.LIGHT_BLUE_SWIMMING_TUBE, "Light Blue Swimming Tube");
            add(ModItems.YELLOW_SWIMMING_TUBE, "Yellow Swimming Tube");
            add(ModItems.LIME_SWIMMING_TUBE, "Lime Swimming Tube");
            add(ModItems.PINK_SWIMMING_TUBE, "Pink Swimming Tube");
            add(ModItems.GRAY_SWIMMING_TUBE, "Gray Swimming Tube");
            add(ModItems.LIGHT_GRAY_SWIMMING_TUBE, "Light Gray Swimming Tube");
            add(ModItems.CYAN_SWIMMING_TUBE, "Cyan Swimming Tube");
            add(ModItems.PURPLE_SWIMMING_TUBE, "Purple Swimming Tube");
            add(ModItems.BLUE_SWIMMING_TUBE, "Blue Swimming Tube");
            add(ModItems.BROWN_SWIMMING_TUBE, "Brown Swimming Tube");
            add(ModItems.GREEN_SWIMMING_TUBE, "Green Swimming Tube");
            add(ModItems.RED_SWIMMING_TUBE, "Red Swimming Tube");
            add(ModItems.BLACK_SWIMMING_TUBE,"Black Swimming Tube");
            add("itemGroup.poolparty", "Pool Party");
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
        }
    }
}

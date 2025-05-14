package tfar.poolparty.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import tfar.poolparty.item.FloatiesItem;
import tfar.poolparty.item.SwimmingTubeItem;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static final List<Item> ITEMS = new ArrayList<>();

    public static final Item RUBBER = new Item(new Item.Properties());
    public static final BlockItem RUBBER_BLOCK = new BlockItem(ModBlocks.RUBBER_BLOCK,new Item.Properties());


    public static final SwimmingTubeItem WHITE_SWIMMING_TUBE = swimmingTube(DyeColor.WHITE);
    public static final SwimmingTubeItem ORANGE_SWIMMING_TUBE = swimmingTube(DyeColor.ORANGE);
    public static final SwimmingTubeItem MAGENTA_SWIMMING_TUBE = swimmingTube(DyeColor.MAGENTA);
    public static final SwimmingTubeItem LIGHT_BLUE_SWIMMING_TUBE = swimmingTube(DyeColor.LIGHT_BLUE);
    public static final SwimmingTubeItem YELLOW_SWIMMING_TUBE = swimmingTube(DyeColor.YELLOW);
    public static final SwimmingTubeItem LIME_SWIMMING_TUBE = swimmingTube(DyeColor.LIME);
    public static final SwimmingTubeItem PINK_SWIMMING_TUBE = swimmingTube(DyeColor.PINK);
    public static final SwimmingTubeItem GRAY_SWIMMING_TUBE = swimmingTube(DyeColor.GRAY);
    public static final SwimmingTubeItem LIGHT_GRAY_SWIMMING_TUBE = swimmingTube(DyeColor.LIGHT_GRAY);
    public static final SwimmingTubeItem CYAN_SWIMMING_TUBE = swimmingTube(DyeColor.CYAN);
    public static final SwimmingTubeItem PURPLE_SWIMMING_TUBE = swimmingTube(DyeColor.PURPLE);
    public static final SwimmingTubeItem BLUE_SWIMMING_TUBE = swimmingTube(DyeColor.BLUE);
    public static final SwimmingTubeItem BROWN_SWIMMING_TUBE = swimmingTube(DyeColor.BROWN);
    public static final SwimmingTubeItem GREEN_SWIMMING_TUBE = swimmingTube(DyeColor.GREEN);
    public static final SwimmingTubeItem RED_SWIMMING_TUBE = swimmingTube(DyeColor.RED);
    public static final SwimmingTubeItem BLACK_SWIMMING_TUBE = swimmingTube(DyeColor.BLACK);

    static SwimmingTubeItem swimmingTube(DyeColor color) {
        SwimmingTubeItem swimmingTubeItem = new SwimmingTubeItem(new Item.Properties().durability(128), color);
        ITEMS.add(swimmingTubeItem);
        return swimmingTubeItem;
    }

    public static final BlockItem SWIMMING_TUBE_HOLDER = new BlockItem(ModBlocks.SWIMMING_TUBE_HOLDER,new Item.Properties());
    public static final Item FLOATIES = new FloatiesItem(new Item.Properties().durability(64));
    public static final Item FLOAT_MAT = new FloatiesItem(new Item.Properties().durability(64));
    public static final Item POOL_NOODLE = new Item(new Item.Properties());
}
//Swimming Tube Holder
//Function
//
//Basically an armor stand for tubes. Holds and stores swimming tubes in the world for a fun visual. It holds up to 3 tubes at once. If broken with silk touch, it keeps the tubes in the item, rather than the tubes dropping independently, similar to a beehive. When placed, the tubes will appear on the item if picked up that way. When shift-right clicked with a tube in hand, it’ll be placed from bottom to top, until the limit of 3 is reached. When right clicked with an empty hand, it’ll fetch the topmost tube. Unlike an armor stand, it cannot be knocked around, and is a physically collideable block, and is mined with an axe (but is as weak as planks so it can be quickly collected without a tool).
//
//
//Visuals
//
//A smooth-stone base that covers all but 1 pixel of the block’s below surface. An oak wood pole in the center, tall enough to visually hold 3 tubes with a bit of the pole showing past the top of the third tube. Can be placed in various rotations just as you can with an armor stand.
//
//
//Crafting
//
//A smooth stone slab on the bottom, and two sticks above.
//
//Floaties
//Function
//
//A cheaper and slower version of the tube. It does not allow sprinting, but still keeps the player afloat in the water. It has a durability of 64 and cannot be enchanted. It is worn in the chestplate slot rather than the leggings slot.
//
//
//Visuals
//
//The player’s body is almost entirely in the water, aside from their shoulders where the floaties are worn. Uses the generic walking swimming animation. They look like mini-tubes on shoulders, and can be all 16 colors.
//
//
//Crafting
//
//Two pieces of plastic, opposite of each other in a 3x3 crafting grid. A dye between the two pieces of plastic for the color.
//
//Float Mat
//Function
//
//A float mat is functionally identical to a boat. It is placed in the water and driven by the player at the same speed as all other boats.
//
//
//Visuals
//
//The same shape as a bamboo raft, minus the oars. Rubber in appearance just like the tubes and floaties, and can be all 16 colors. Rather than sitting on it like other boats, the player lays down and has the same perspective as a bed. May need to be slightly longer than a raft to accommodate laying down.
//
//
//Crafting
//
//The shape of all other boat recipes, made of plastic. A dye in the center of the grid for the color.
//
//Pool Noodle
//Function
//
//A knockback stick that deals no damage. The knockback is equivalent to KB2 and the durability of a wooden sword. It can be placed multi directionally like a sign, as well as be placed on the surface of the water. Being placed on the surface of the water allows other blocks to be placed against it. Useful for those times you need to place some blocks on water but don’t want to build over to the starting point. It’s also physically interactable, so you can stand on it.
//
//
//Visuals
//
//As mentioned, it can be placed multi directionally. However, when placed straight, it spans across an entire block. When placed onto the top of a block, it sits on the block. When placed against the side of a block, its placement is centered rather than on the surface. When placed on the bottom side of a block, it sits on that face instead. It can also be placed vertically rather than horizontally if you’re looking directly up or down while placing it. In the hand it has a 3d model, and can be colored just as the other dyeable items. Uses the same plastic visuals.
//
//
//Crafting
//
//3 vertically placed plastic in a crafting grid. Dye placed elsewhere in the grid. Cannot be enchanted whatsoever.
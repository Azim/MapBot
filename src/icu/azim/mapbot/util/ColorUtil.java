package icu.azim.mapbot.util;

import java.awt.Color;
import java.util.HashMap;

import org.bukkit.Material;


public class ColorUtil {
	
	private static final HashMap<Integer, Color> colors = new HashMap<Integer, Color>(){
		private static final long serialVersionUID = -8144445641005012400L;
	{
		put(0, new Color(0,0,0,0));
		put(1, new Color(127,178,56));
		put(2, new Color(247,233,163));
		put(3, new Color(199,199,199));
		put(4, new Color(255,0,0));
		put(5, new Color(160,160,255));
		put(6, new Color(167,167,167));
		put(7, new Color(0,124,0));
		put(8, new Color(255,255,255));
		put(9, new Color(164,168,184));
		put(10, new Color(151,109,77));
		put(11, new Color(112,112,112));
		put(12, new Color(64,64,255));
		put(13, new Color(143,119,72));
		put(14, new Color(255,252,245));
		put(15, new Color(216,127,51));
		put(16, new Color(178, 76, 216));
		put(17, new Color(102, 153, 216));
		put(18, new Color(229, 229, 51));
		put(19, new Color(127, 204, 25));
		put(20, new Color(242, 127, 165));
		put(21, new Color(76, 76, 76));
		put(22, new Color(153, 153, 153));
		put(23, new Color(76, 127, 153));
		put(24, new Color(127, 63, 178));
		put(25, new Color(51, 76, 178));
		put(26, new Color(102, 76, 51));
		put(27, new Color(102, 127, 51));
		put(28, new Color(153, 51, 51));
		put(29, new Color(25, 25, 25));
		put(30, new Color(250, 238, 77));
		put(31, new Color(92, 219, 213));
		put(32, new Color(74, 128, 255));
		put(33, new Color(0, 217, 58));
		put(34, new Color(129, 86, 49));
		put(35, new Color(112, 2, 0));
		put(36, new Color(209, 177, 161));
		put(37, new Color(159, 82, 36));
		put(38, new Color(149, 87, 108));
		put(39, new Color(112, 108, 138));
		put(40, new Color(186, 133, 36));
		put(41, new Color(103, 117, 53));
		put(42, new Color(160, 77, 78));
		put(43, new Color(57, 41, 35));
		put(44, new Color(135, 107, 98));
		put(45, new Color(87, 92, 92));
		put(46, new Color(122, 73, 88));
		put(47, new Color(76, 62, 92));
		put(48, new Color(76, 50, 35));
		put(49, new Color(76, 82, 42));
		put(50, new Color(142, 60, 46));
		put(51, new Color(37, 22, 16));
		put(52, new Color(189, 48, 49));
		put(53, new Color(148, 63, 97));
		put(54, new Color(92, 25, 29));
		put(55, new Color(22, 126, 134));
		put(56, new Color(58, 142, 140));
		put(57, new Color(86, 44, 62));
		put(58, new Color(20, 180, 133));
		
	}};
	
	
	private static final HashMap<Material, Integer> materials = new HashMap<Material, Integer>() {
		private static final long serialVersionUID = -8144445641005012400L;
	{
		put(Material.AIR, 0);
		put(Material.VOID_AIR, 0);
		put(Material.CAVE_AIR, 0);
		put(Material.BARRIER, 0);
		put(Material.REDSTONE_LAMP, 0);
		put(Material.CAKE, 0);
		put(Material.POWERED_RAIL, 0);
		put(Material.DETECTOR_RAIL, 0);
		put(Material.TORCH, 0);
		put(Material.REDSTONE_WIRE, 0);
		put(Material.LADDER, 0);
		put(Material.RAIL, 0);
		put(Material.LEVER, 0);
		put(Material.REDSTONE_TORCH, 0);
		put(Material.STONE_BUTTON, 0);
		put(Material.ACACIA_BUTTON, 0);
		put(Material.BIRCH_BUTTON, 0);
		put(Material.CRIMSON_BUTTON, 0);
		put(Material.DARK_OAK_BUTTON, 0);
		put(Material.JUNGLE_BUTTON, 0);
		put(Material.OAK_BUTTON, 0);
		put(Material.POLISHED_BLACKSTONE_BUTTON, 0);
		put(Material.SPRUCE_BUTTON, 0);
		put(Material.WARPED_BUTTON, 0);
		put(Material.REPEATER, 0);
		put(Material.TRIPWIRE_HOOK, 0);
		put(Material.TRIPWIRE, 0);
		put(Material.FLOWER_POT, 0);
		put(Material.CREEPER_HEAD, 0);
		put(Material.CREEPER_WALL_HEAD, 0);
		put(Material.DRAGON_HEAD, 0);
		put(Material.DRAGON_WALL_HEAD, 0);
		put(Material.PLAYER_HEAD, 0);
		put(Material.PLAYER_WALL_HEAD, 0);
		put(Material.ZOMBIE_HEAD, 0);
		put(Material.ZOMBIE_WALL_HEAD, 0);
		put(Material.COMPARATOR, 0);
		put(Material.ACTIVATOR_RAIL, 0);
		put(Material.END_ROD, 0);
		put(Material.GLASS, 0);
		put(Material.GLASS_PANE, 0);
		put(Material.NETHER_PORTAL, 0);
		put(Material.BLACK_STAINED_GLASS_PANE, 0);
		put(Material.BLUE_STAINED_GLASS_PANE, 0);
		put(Material.BROWN_STAINED_GLASS_PANE, 0);
		put(Material.CYAN_STAINED_GLASS_PANE, 0);
		put(Material.GRAY_STAINED_GLASS_PANE, 0);
		put(Material.GREEN_STAINED_GLASS_PANE, 0);
		put(Material.LIGHT_BLUE_STAINED_GLASS_PANE, 0);
		put(Material.LIGHT_GRAY_STAINED_GLASS_PANE, 0);
		put(Material.LIME_STAINED_GLASS_PANE, 0);
		put(Material.MAGENTA_STAINED_GLASS_PANE, 0);
		put(Material.ORANGE_STAINED_GLASS_PANE, 0);
		put(Material.PINK_STAINED_GLASS_PANE, 0);
		put(Material.PURPLE_STAINED_GLASS_PANE, 0);
		put(Material.RED_STAINED_GLASS_PANE, 0);
		put(Material.WHITE_STAINED_GLASS_PANE, 0);
		put(Material.YELLOW_STAINED_GLASS_PANE, 0);
		put(Material.STRUCTURE_VOID, 0);
		put(Material.IRON_BARS, 0);
		put(Material.SOUL_TORCH, 0);
		put(Material.CHAIN, 0); //i ended up defaulting to 0 for transparent stuff, i shouldntve filled this out =/

		put(Material.GRASS_BLOCK, 1);
		put(Material.SLIME_BLOCK, 1);
		
		put(Material.SAND, 2);
		put(Material.BIRCH_PLANKS, 2);
		put(Material.BIRCH_LOG, 2);
		put(Material.STRIPPED_BIRCH_LOG, 2);
		put(Material.BIRCH_WOOD, 2);
		put(Material.STRIPPED_BIRCH_WOOD, 2);
		put(Material.BIRCH_SIGN, 2);
		put(Material.BIRCH_WALL_SIGN, 2);
		put(Material.BIRCH_PRESSURE_PLATE, 2);
		put(Material.BIRCH_TRAPDOOR, 2);
		put(Material.BIRCH_STAIRS, 2);
		put(Material.BIRCH_SLAB, 2);
		put(Material.BIRCH_FENCE_GATE, 2);
		put(Material.BIRCH_FENCE, 2);
		put(Material.BIRCH_DOOR, 2);
		put(Material.SANDSTONE, 2);
		put(Material.SANDSTONE_SLAB, 2);
		put(Material.SANDSTONE_STAIRS, 2);
		put(Material.SANDSTONE_WALL, 2);
		put(Material.CHISELED_SANDSTONE, 2);
		put(Material.CUT_SANDSTONE, 2);
		put(Material.CUT_SANDSTONE_SLAB, 2);
		put(Material.SMOOTH_SANDSTONE, 2);
		put(Material.SMOOTH_SANDSTONE_SLAB, 2);
		put(Material.SMOOTH_SANDSTONE_STAIRS, 2);
		put(Material.SANDSTONE, 2);
		put(Material.GLOWSTONE, 2);
		put(Material.END_STONE, 2);
		put(Material.END_STONE_BRICKS, 2);
		put(Material.END_STONE_BRICK_SLAB, 2);
		put(Material.END_STONE_BRICK_STAIRS, 2);
		put(Material.END_STONE_BRICK_WALL, 2);
		put(Material.BONE_BLOCK, 2);
		put(Material.TURTLE_EGG, 2);
		put(Material.SCAFFOLDING, 2);

		put(Material.COBWEB, 3);
		put(Material.MUSHROOM_STEM, 3);
		// put(Material.BedHead, 3);  no separate material for it huh
		
		put(Material.LAVA, 4);
		put(Material.TNT, 4);
		put(Material.FIRE, 4);
		put(Material.REDSTONE_BLOCK, 4);
		
		put(Material.ICE, 5);
		put(Material.BLUE_ICE, 5);
		put(Material.FROSTED_ICE, 5);
		put(Material.PACKED_ICE, 5);

		put(Material.IRON_BLOCK, 6);
		put(Material.IRON_DOOR, 6);
		put(Material.BREWING_STAND, 6);
		put(Material.HEAVY_WEIGHTED_PRESSURE_PLATE, 6);
		put(Material.IRON_TRAPDOOR, 6);
		put(Material.LANTERN, 6);
		put(Material.ANVIL, 6);
		put(Material.GRINDSTONE, 6);
		put(Material.SOUL_LANTERN, 6);
		put(Material.LODESTONE, 6);

		put(Material.ACACIA_SAPLING, 7);
		put(Material.BIRCH_SAPLING, 7);
		put(Material.DARK_OAK_SAPLING, 7);
		put(Material.JUNGLE_SAPLING, 7);
		put(Material.OAK_SAPLING, 7);
		put(Material.SPRUCE_SAPLING, 7);
		put(Material.DANDELION, 7);
		put(Material.POPPY, 7);
		put(Material.BLUE_ORCHID, 7);
		put(Material.ALLIUM, 7);
		put(Material.AZURE_BLUET, 7);
		put(Material.RED_TULIP, 7);
		put(Material.ORANGE_TULIP, 7);
		put(Material.WHITE_TULIP, 7);
		put(Material.PINK_TULIP, 7);
		put(Material.OXEYE_DAISY, 7);
		put(Material.CORNFLOWER, 7);
		put(Material.LILY_OF_THE_VALLEY, 7);
		put(Material.WITHER_ROSE, 7);
		put(Material.SUNFLOWER, 7);
		put(Material.LILAC, 7);
		put(Material.ROSE_BUSH, 7);
		put(Material.PEONY, 7);
		put(Material.WHEAT, 7);
		put(Material.SUGAR_CANE, 7);
		put(Material.PUMPKIN_STEM, 7);
		put(Material.ATTACHED_PUMPKIN_STEM, 7);
		put(Material.MELON_STEM, 7);
		put(Material.ATTACHED_MELON_STEM, 7);
		put(Material.LILY_PAD, 7);
		put(Material.COCOA, 7);
		put(Material.CARROTS, 7);
		put(Material.POTATOES, 7);
		put(Material.BEETROOTS, 7);
		put(Material.SWEET_BERRY_BUSH, 7);
		put(Material.GRASS, 7);
		put(Material.FERN, 7);
		put(Material.LARGE_FERN, 7);
		put(Material.FERN, 7);
		put(Material.VINE, 7);
		put(Material.ACACIA_LEAVES, 7);
		put(Material.BIRCH_LEAVES, 7);
		put(Material.DARK_OAK_LEAVES, 7);
		put(Material.JUNGLE_LEAVES, 7);
		put(Material.OAK_LEAVES, 7);
		put(Material.SPRUCE_LEAVES, 7);
		put(Material.CACTUS, 7);
		put(Material.BAMBOO, 7);
		
		put(Material.SNOW, 8);
		put(Material.SNOW_BLOCK, 8);
		put(Material.WHITE_BED, 8);
		put(Material.WHITE_BANNER, 8);
		put(Material.WHITE_CARPET, 8);
		put(Material.WHITE_CONCRETE, 8);
		put(Material.WHITE_CONCRETE_POWDER, 8);
		put(Material.WHITE_GLAZED_TERRACOTTA, 8);
		put(Material.WHITE_SHULKER_BOX, 8);
		put(Material.WHITE_STAINED_GLASS, 8);
		put(Material.WHITE_WALL_BANNER, 8);
		put(Material.WHITE_WOOL, 8);
		
		put(Material.CLAY, 9);
		put(Material.INFESTED_CHISELED_STONE_BRICKS, 9);
		put(Material.INFESTED_COBBLESTONE, 9);
		put(Material.INFESTED_CRACKED_STONE_BRICKS, 9);
		put(Material.INFESTED_MOSSY_STONE_BRICKS, 9);
		put(Material.INFESTED_STONE, 9);
		put(Material.INFESTED_STONE_BRICKS, 9);
		
		put(Material.DIRT, 10);
		put(Material.COARSE_DIRT, 10);
		put(Material.FARMLAND, 10);
		put(Material.GRASS_PATH, 10);
		put(Material.GRANITE, 10);
		put(Material.GRANITE_SLAB, 10);
		put(Material.GRANITE_STAIRS, 10);
		put(Material.GRANITE_WALL, 10);
		put(Material.POLISHED_GRANITE, 10);
		put(Material.POLISHED_GRANITE_SLAB, 10);
		put(Material.POLISHED_GRANITE_STAIRS, 10);
		put(Material.JUNGLE_PLANKS, 10);
		put(Material.JUNGLE_LOG, 10);
		put(Material.STRIPPED_JUNGLE_LOG, 10);
		put(Material.JUNGLE_WOOD, 10);
		put(Material.STRIPPED_JUNGLE_WOOD, 10);
		put(Material.JUNGLE_WOOD, 10);
		put(Material.JUNGLE_SIGN, 10);
		put(Material.JUNGLE_PRESSURE_PLATE, 10);
		put(Material.JUNGLE_TRAPDOOR, 10);
		put(Material.JUNGLE_STAIRS, 10);
		put(Material.JUNGLE_SLAB, 10);
		put(Material.JUNGLE_FENCE, 10);
		put(Material.JUNGLE_FENCE_GATE, 10);
		put(Material.JUNGLE_DOOR, 10);
		put(Material.JUKEBOX, 10);
		put(Material.BROWN_MUSHROOM_BLOCK, 10);

		put(Material.STONE, 11);
		put(Material.STONE_SLAB, 11);
		put(Material.STONE_STAIRS, 11);
		put(Material.ANDESITE, 11);
		put(Material.ANDESITE_SLAB, 11);
		put(Material.ANDESITE_STAIRS, 11);
		put(Material.ANDESITE_WALL, 11);
		put(Material.POLISHED_ANDESITE, 11);
		put(Material.POLISHED_ANDESITE_SLAB, 11);
		put(Material.POLISHED_ANDESITE_STAIRS, 11);
		put(Material.COBBLESTONE, 11);
		put(Material.COBBLESTONE_SLAB, 11);
		put(Material.COBBLESTONE_STAIRS, 11);
		put(Material.COBBLESTONE_WALL, 11);
		put(Material.BEDROCK, 11);
		put(Material.GOLD_ORE, 11);
		put(Material.IRON_ORE, 11);
		put(Material.COAL_ORE, 11);
		put(Material.LAPIS_ORE, 11);
		put(Material.DISPENSER, 11);
		put(Material.MOSSY_COBBLESTONE, 11);
		put(Material.MOSSY_COBBLESTONE_SLAB, 11);
		put(Material.MOSSY_COBBLESTONE_STAIRS, 11);
		put(Material.MOSSY_COBBLESTONE_WALL, 11);
		put(Material.SPAWNER, 11);
		put(Material.DIAMOND_ORE, 11);
		put(Material.FURNACE, 11);
		put(Material.STONE_PRESSURE_PLATE, 11);
		put(Material.REDSTONE_ORE, 11);
		put(Material.STONE_BRICKS, 11);
		put(Material.STONE_BRICK_SLAB, 11);
		put(Material.STONE_BRICK_STAIRS, 11);
		put(Material.STONE_BRICK_WALL, 11);
		put(Material.CHISELED_STONE_BRICKS, 11);
		put(Material.MOSSY_STONE_BRICKS, 11);
		put(Material.MOSSY_STONE_BRICK_SLAB, 11);
		put(Material.MOSSY_STONE_BRICK_STAIRS, 11);
		put(Material.MOSSY_STONE_BRICK_WALL, 11);
		put(Material.CRACKED_STONE_BRICKS, 11);
		put(Material.EMERALD_ORE, 11);
		put(Material.ENDER_CHEST, 11);
		put(Material.DROPPER, 11);
		put(Material.SMOOTH_STONE, 11);
		put(Material.SMOOTH_STONE_SLAB, 11);
		put(Material.OBSERVER, 11);
		put(Material.SMOKER, 11);
		put(Material.BLAST_FURNACE, 11);
		put(Material.STONECUTTER, 11);
		put(Material.STICKY_PISTON, 11);
		put(Material.PISTON, 11);
		put(Material.PISTON_HEAD, 11);
		put(Material.GRAVEL, 11);
		put(Material.ACACIA_LOG, 11);
		put(Material.CAULDRON, 11);
		put(Material.HOPPER, 11);
		
		put(Material.KELP_PLANT, 12);
		put(Material.SEAGRASS, 12);
		put(Material.TALL_SEAGRASS, 12);
		put(Material.WATER, 12);
		put(Material.BUBBLE_COLUMN, 12);

		put(Material.OAK_LOG, 13);
		put(Material.OAK_PLANKS, 13);
		put(Material.STRIPPED_OAK_LOG, 13);
		put(Material.STRIPPED_OAK_WOOD, 13);
		put(Material.OAK_WOOD, 13);
		put(Material.OAK_SIGN, 13);
		put(Material.OAK_WALL_SIGN, 13);
		put(Material.OAK_DOOR, 13);
		put(Material.OAK_PRESSURE_PLATE, 13);
		put(Material.OAK_FENCE, 13);
		put(Material.OAK_TRAPDOOR, 13);
		put(Material.OAK_FENCE_GATE, 13);
		put(Material.OAK_SLAB, 13);
		put(Material.OAK_STAIRS, 13);
		put(Material.NOTE_BLOCK, 13);
		put(Material.BOOKSHELF, 13);
		put(Material.CHEST, 13);
		put(Material.CRAFTING_TABLE, 13);
		put(Material.TRAPPED_CHEST, 13);
		put(Material.DAYLIGHT_DETECTOR, 13);
		put(Material.LOOM, 13);
		put(Material.BARREL, 13);
		put(Material.CARTOGRAPHY_TABLE, 13);
		put(Material.FLETCHING_TABLE, 13);
		put(Material.LECTERN, 13);
		put(Material.SMITHING_TABLE, 13);
		put(Material.COMPOSTER, 13);
		put(Material.BAMBOO_SAPLING, 13);
		put(Material.DEAD_BUSH, 13);
		put(Material.PETRIFIED_OAK_SLAB, 13);
		put(Material.BEEHIVE, 13);
		
		put(Material.DIORITE, 14);
		put(Material.DIORITE_SLAB, 14);
		put(Material.DIORITE_STAIRS, 14);
		put(Material.DIORITE_WALL, 14);
		put(Material.POLISHED_DIORITE, 14);
		put(Material.POLISHED_DIORITE_SLAB, 14);
		put(Material.POLISHED_DIORITE_STAIRS, 14);
		put(Material.BIRCH_LOG, 14);
		put(Material.QUARTZ_BLOCK, 14);
		put(Material.QUARTZ_BRICKS, 14);
		put(Material.QUARTZ_PILLAR, 14);
		put(Material.QUARTZ_SLAB, 14);
		put(Material.QUARTZ_STAIRS, 14);
		put(Material.CHISELED_QUARTZ_BLOCK, 14);
		put(Material.SMOOTH_QUARTZ_SLAB, 14);
		put(Material.SMOOTH_QUARTZ_STAIRS, 14);
		put(Material.SEA_LANTERN, 14);
		put(Material.TARGET, 14);

		put(Material.ACACIA_PLANKS, 15);
		put(Material.STRIPPED_ACACIA_LOG, 15);
		put(Material.STRIPPED_ACACIA_WOOD, 15);
		put(Material.ACACIA_SIGN, 15);
		put(Material.ACACIA_TRAPDOOR, 15);
		put(Material.ACACIA_SLAB, 15);
		put(Material.ACACIA_STAIRS, 15);
		put(Material.RED_SAND, 15);
		put(Material.ORANGE_BANNER, 15);
		put(Material.ORANGE_BED, 15);
		put(Material.ORANGE_CARPET, 15);
		put(Material.ORANGE_CONCRETE, 15);
		put(Material.ORANGE_CONCRETE_POWDER, 15);
		put(Material.ORANGE_GLAZED_TERRACOTTA, 15);
		put(Material.ORANGE_SHULKER_BOX, 15);
		put(Material.ORANGE_STAINED_GLASS, 15);
		put(Material.ORANGE_TERRACOTTA, 15);
		put(Material.ORANGE_WALL_BANNER, 15);
		put(Material.ORANGE_WOOL, 15);
		put(Material.PUMPKIN, 15);
		put(Material.JACK_O_LANTERN, 15);
		put(Material.TERRACOTTA, 15);
		put(Material.RED_SANDSTONE, 15);
		put(Material.RED_SANDSTONE_SLAB, 15);
		put(Material.RED_SANDSTONE_STAIRS, 15);
		put(Material.RED_SANDSTONE_WALL, 15);
		put(Material.CHISELED_RED_SANDSTONE, 15);
		put(Material.CUT_RED_SANDSTONE, 15);
		put(Material.CUT_RED_SANDSTONE_SLAB, 15);
		put(Material.SMOOTH_RED_SANDSTONE, 15);
		put(Material.SMOOTH_RED_SANDSTONE_SLAB, 15);
		put(Material.SMOOTH_RED_SANDSTONE_STAIRS, 15);
		put(Material.HONEY_BLOCK, 15);
		put(Material.HONEYCOMB_BLOCK, 15);

		put(Material.MAGENTA_BANNER, 16);
		put(Material.MAGENTA_BED, 16);
		put(Material.MAGENTA_CARPET, 16);
		put(Material.MAGENTA_CONCRETE, 16);
		put(Material.MAGENTA_CONCRETE_POWDER, 16);
		put(Material.MAGENTA_GLAZED_TERRACOTTA, 16);
		put(Material.MAGENTA_SHULKER_BOX, 16);
		put(Material.MAGENTA_STAINED_GLASS, 16);
		put(Material.MAGENTA_TERRACOTTA, 16);
		put(Material.MAGENTA_WALL_BANNER, 16);
		put(Material.MAGENTA_WOOL, 16);
		put(Material.PURPUR_BLOCK, 16);
		put(Material.PURPUR_PILLAR, 16);
		put(Material.PURPUR_SLAB, 16);
		put(Material.PURPUR_STAIRS, 16);

		put(Material.LIGHT_BLUE_BANNER, 17);
		put(Material.LIGHT_BLUE_BED, 17);
		put(Material.LIGHT_BLUE_CARPET, 17);
		put(Material.LIGHT_BLUE_CONCRETE, 17);
		put(Material.LIGHT_BLUE_CONCRETE_POWDER, 17);
		put(Material.LIGHT_BLUE_GLAZED_TERRACOTTA, 17);
		put(Material.LIGHT_BLUE_SHULKER_BOX, 17);
		put(Material.LIGHT_BLUE_STAINED_GLASS, 17);
		put(Material.LIGHT_BLUE_TERRACOTTA, 17);
		put(Material.LIGHT_BLUE_WALL_BANNER, 17);
		put(Material.LIGHT_BLUE_WOOL, 17);
		put(Material.SOUL_FIRE, 17);
		
		put(Material.SPONGE, 18);
		put(Material.WET_SPONGE, 18);
		put(Material.YELLOW_BANNER, 18);
		put(Material.YELLOW_BED, 18);
		put(Material.YELLOW_CARPET, 18);
		put(Material.YELLOW_CONCRETE, 18);
		put(Material.YELLOW_CONCRETE_POWDER, 18);
		put(Material.YELLOW_GLAZED_TERRACOTTA, 18);
		put(Material.YELLOW_SHULKER_BOX, 18);
		put(Material.YELLOW_STAINED_GLASS, 18);
		put(Material.YELLOW_TERRACOTTA, 18);
		put(Material.YELLOW_WALL_BANNER, 18);
		put(Material.YELLOW_WOOL, 18);
		put(Material.HAY_BLOCK, 18);
		put(Material.HORN_CORAL, 18);
		put(Material.HORN_CORAL_BLOCK, 18);
		put(Material.HORN_CORAL_FAN, 18);
		put(Material.HORN_CORAL_WALL_FAN, 18);
		put(Material.BEE_NEST, 18);

		put(Material.MELON, 19);
		put(Material.LIME_BANNER, 19);
		put(Material.LIME_BED, 19);
		put(Material.LIME_CARPET, 19);
		put(Material.LIME_CONCRETE, 19);
		put(Material.LIME_CONCRETE_POWDER, 19);
		put(Material.LIME_GLAZED_TERRACOTTA, 19);
		put(Material.LIME_SHULKER_BOX, 19);
		put(Material.LIME_STAINED_GLASS, 19);
		put(Material.LIME_TERRACOTTA, 19);
		put(Material.LIME_WALL_BANNER, 19);
		put(Material.LIME_WOOL, 19);
		
		put(Material.PINK_BANNER, 20);
		put(Material.PINK_BED, 20);
		put(Material.PINK_CARPET, 20);
		put(Material.PINK_CONCRETE, 20);
		put(Material.PINK_CONCRETE_POWDER, 20);
		put(Material.PINK_GLAZED_TERRACOTTA, 20);
		put(Material.PINK_SHULKER_BOX, 20);
		put(Material.PINK_STAINED_GLASS, 20);
		put(Material.PINK_TERRACOTTA, 20);
		put(Material.PINK_WALL_BANNER, 20);
		put(Material.PINK_WOOL, 20);
		put(Material.BRAIN_CORAL, 20);
		put(Material.BRAIN_CORAL_BLOCK, 20);
		put(Material.BRAIN_CORAL_FAN, 20);
		put(Material.BRAIN_CORAL_WALL_FAN, 20);

		put(Material.ACACIA_WOOD, 21);
		put(Material.GRAY_BANNER, 21);
		put(Material.GRAY_BED, 21);
		put(Material.GRAY_CARPET, 21);
		put(Material.GRAY_CONCRETE, 21);
		put(Material.GRAY_CONCRETE_POWDER, 21);
		put(Material.GRAY_GLAZED_TERRACOTTA, 21);
		put(Material.GRAY_SHULKER_BOX, 21);
		put(Material.GRAY_STAINED_GLASS, 21);
		put(Material.GRAY_TERRACOTTA, 21);
		put(Material.GRAY_WALL_BANNER, 21);
		put(Material.GRAY_WOOL, 21);
		put(Material.DEAD_BRAIN_CORAL, 21);
		put(Material.DEAD_BRAIN_CORAL_BLOCK, 21);
		put(Material.DEAD_BRAIN_CORAL_FAN, 21);
		put(Material.DEAD_BRAIN_CORAL_WALL_FAN, 21);
		put(Material.DEAD_BUBBLE_CORAL, 21);
		put(Material.DEAD_BUBBLE_CORAL_BLOCK, 21);
		put(Material.DEAD_BUBBLE_CORAL_FAN, 21);
		put(Material.DEAD_BUBBLE_CORAL_WALL_FAN, 21);
		put(Material.DEAD_BUBBLE_CORAL, 21);
		put(Material.DEAD_FIRE_CORAL, 21);
		put(Material.DEAD_FIRE_CORAL_BLOCK, 21);
		put(Material.DEAD_FIRE_CORAL_FAN, 21);
		put(Material.DEAD_FIRE_CORAL_WALL_FAN, 21);
		put(Material.DEAD_HORN_CORAL, 21);
		put(Material.DEAD_HORN_CORAL_BLOCK, 21);
		put(Material.DEAD_HORN_CORAL_FAN, 21);
		put(Material.DEAD_HORN_CORAL_WALL_FAN, 21);
		put(Material.DEAD_TUBE_CORAL, 21);
		put(Material.DEAD_TUBE_CORAL_BLOCK, 21);
		put(Material.DEAD_TUBE_CORAL_FAN, 21);
		put(Material.DEAD_TUBE_CORAL_WALL_FAN, 21);

		put(Material.LIGHT_GRAY_BANNER, 22);
		put(Material.LIGHT_GRAY_BED, 22);
		put(Material.LIGHT_GRAY_CARPET, 22);
		put(Material.LIGHT_GRAY_CONCRETE, 22);
		put(Material.LIGHT_GRAY_CONCRETE_POWDER, 22);
		put(Material.LIGHT_GRAY_GLAZED_TERRACOTTA, 22);
		put(Material.LIGHT_GRAY_SHULKER_BOX, 22);
		put(Material.LIGHT_GRAY_STAINED_GLASS, 22);
		put(Material.LIGHT_GRAY_TERRACOTTA, 22);
		put(Material.LIGHT_GRAY_WALL_BANNER, 22);
		put(Material.LIGHT_GRAY_WOOL, 22);
		put(Material.STRUCTURE_BLOCK, 22);
		put(Material.JIGSAW, 22);

		put(Material.CYAN_BANNER, 23);
		put(Material.CYAN_BED, 23);
		put(Material.CYAN_CARPET, 23);
		put(Material.CYAN_CONCRETE, 23);
		put(Material.CYAN_CONCRETE_POWDER, 23);
		put(Material.CYAN_GLAZED_TERRACOTTA, 23);
		put(Material.CYAN_SHULKER_BOX, 23);
		put(Material.CYAN_STAINED_GLASS, 23);
		put(Material.CYAN_TERRACOTTA, 23);
		put(Material.CYAN_WALL_BANNER, 23);
		put(Material.CYAN_WOOL, 23);
		put(Material.PRISMARINE, 23);
		put(Material.PRISMARINE_BRICK_SLAB, 23);
		put(Material.PRISMARINE_BRICK_STAIRS, 23);
		put(Material.PRISMARINE_BRICKS, 23);
		put(Material.PRISMARINE_SLAB, 23);
		put(Material.PRISMARINE_STAIRS, 23);
		put(Material.PRISMARINE_WALL, 23);
		put(Material.WARPED_ROOTS, 23);
		put(Material.WARPED_PRESSURE_PLATE, 23);
		put(Material.WARPED_FENCE, 23);
		put(Material.WARPED_TRAPDOOR, 23);
		put(Material.WARPED_FENCE_GATE, 23);
		put(Material.WARPED_DOOR, 23);
		put(Material.WARPED_SIGN, 23);
		put(Material.WARPED_WALL_SIGN, 23);
		put(Material.WARPED_FUNGUS, 23);
		put(Material.TWISTING_VINES_PLANT, 23);
		put(Material.NETHER_SPROUTS, 23);

		put(Material.SHULKER_BOX, 24);
		put(Material.PURPLE_BANNER, 24);
		put(Material.PURPLE_BED, 24);
		put(Material.PURPLE_CARPET, 24);
		put(Material.PURPLE_CONCRETE, 24);
		put(Material.PURPLE_CONCRETE_POWDER, 24);
		put(Material.PURPLE_GLAZED_TERRACOTTA, 24);
		put(Material.PURPLE_SHULKER_BOX, 24);
		put(Material.PURPLE_STAINED_GLASS, 24);
		put(Material.PURPLE_TERRACOTTA, 24);
		put(Material.PURPLE_WALL_BANNER, 24);
		put(Material.PURPLE_WOOL, 24);
		put(Material.MYCELIUM, 24);
		put(Material.CHORUS_PLANT, 24);
		put(Material.CHORUS_FLOWER, 24);
		put(Material.REPEATING_COMMAND_BLOCK, 24);
		put(Material.BUBBLE_CORAL, 24);
		put(Material.BUBBLE_CORAL_BLOCK, 24);
		put(Material.BUBBLE_CORAL_FAN, 24);
		put(Material.BUBBLE_CORAL_WALL_FAN, 24);
		
		put(Material.BLUE_WOOL, 25);
		put(Material.BLUE_CARPET, 25);
		put(Material.BLUE_SHULKER_BOX, 25);
		put(Material.BLUE_BED, 25);
		put(Material.BLUE_STAINED_GLASS, 25);
		put(Material.BLUE_BANNER, 25);
		put(Material.BLUE_WALL_BANNER, 25);
		put(Material.BLUE_GLAZED_TERRACOTTA, 25);
		put(Material.BLUE_CONCRETE, 25);
		put(Material.BLUE_CONCRETE_POWDER, 25);
		put(Material.TUBE_CORAL, 25);
		put(Material.TUBE_CORAL_BLOCK, 25);
		put(Material.TUBE_CORAL_FAN, 25);
		put(Material.TUBE_CORAL_WALL_FAN, 25);
		
		put(Material.DARK_OAK_PLANKS, 26);
		put(Material.STRIPPED_DARK_OAK_LOG, 26);
		put(Material.DARK_OAK_WOOD, 26);
		put(Material.STRIPPED_DARK_OAK_WOOD, 26);
		put(Material.DARK_OAK_SIGN, 26);
		put(Material.DARK_OAK_WALL_SIGN, 26);
		put(Material.DARK_OAK_PRESSURE_PLATE, 26);
		put(Material.DARK_OAK_TRAPDOOR, 26);
		put(Material.DARK_OAK_STAIRS, 26);
		put(Material.DARK_OAK_SLAB, 26);
		put(Material.DARK_OAK_FENCE, 26);
		put(Material.DARK_OAK_FENCE_GATE, 26);
		put(Material.DARK_OAK_DOOR, 26);
		put(Material.SPRUCE_LOG, 26);
		put(Material.BROWN_WOOL, 26);
		put(Material.BROWN_CARPET, 26);
		put(Material.BROWN_SHULKER_BOX, 26);
		put(Material.BROWN_BED, 26);
		put(Material.BROWN_STAINED_GLASS, 26);
		put(Material.BROWN_BANNER, 26);
		put(Material.BROWN_WALL_BANNER, 26);
		put(Material.BROWN_GLAZED_TERRACOTTA, 26);
		put(Material.BROWN_CONCRETE, 26);
		put(Material.BROWN_CONCRETE_POWDER, 26);
		put(Material.SOUL_SAND, 26);
		put(Material.COMMAND_BLOCK, 26);
		put(Material.BROWN_MUSHROOM, 26);
		put(Material.SOUL_SOIL, 26);

		put(Material.GREEN_WOOL, 27);
		put(Material.GREEN_CARPET, 27);
		put(Material.GREEN_SHULKER_BOX, 27);
		put(Material.GREEN_BED, 27);
		put(Material.GREEN_STAINED_GLASS, 27);
		put(Material.GREEN_BANNER, 27);
		put(Material.GREEN_WALL_BANNER, 27);
		put(Material.GREEN_GLAZED_TERRACOTTA, 27);
		put(Material.GREEN_CONCRETE, 27);
		put(Material.GREEN_CONCRETE_POWDER, 27);
		put(Material.END_PORTAL_FRAME, 27);
		put(Material.CHAIN_COMMAND_BLOCK, 27);
		put(Material.DRIED_KELP_BLOCK, 27);
		put(Material.SEA_PICKLE, 27);
		
		put(Material.RED_WOOL, 28);
		put(Material.RED_CARPET, 28);
		put(Material.RED_SHULKER_BOX, 28);
		put(Material.RED_BED, 28);
		put(Material.RED_STAINED_GLASS, 28);
		put(Material.RED_BANNER, 28);
		put(Material.RED_WALL_BANNER, 28);
		put(Material.RED_GLAZED_TERRACOTTA, 28);
		put(Material.RED_CONCRETE, 28);
		put(Material.RED_CONCRETE_POWDER, 28);
		put(Material.BRICKS, 28);
		put(Material.BRICK_STAIRS, 28);
		put(Material.BRICK_SLAB, 28);
		put(Material.BRICK_WALL, 28);
		put(Material.RED_MUSHROOM_BLOCK, 28);
		put(Material.NETHER_WART, 28);
		put(Material.NETHER_WART_BLOCK, 28); 
		put(Material.ENCHANTING_TABLE, 28);
		put(Material.FIRE_CORAL, 28);
		put(Material.FIRE_CORAL_BLOCK, 28);
		put(Material.FIRE_CORAL_FAN, 28);
		put(Material.RED_MUSHROOM, 28);
		put(Material.SHROOMLIGHT, 28);

		put(Material.BLACK_WOOL, 29);
		put(Material.BLACK_CARPET, 29);
		put(Material.BLACK_SHULKER_BOX, 29);
		put(Material.BLACK_BED, 29);
		put(Material.BLACK_STAINED_GLASS, 29);
		put(Material.BLACK_BANNER, 29);
		put(Material.BLACK_WALL_BANNER, 29);
		put(Material.BLACK_GLAZED_TERRACOTTA, 29);
		put(Material.BLACK_CONCRETE, 29);
		put(Material.BLACK_CONCRETE_POWDER, 29);
		put(Material.OBSIDIAN, 29);
		put(Material.END_PORTAL, 29);
		put(Material.DRAGON_EGG, 29);
		put(Material.COAL_BLOCK, 29);
		put(Material.END_GATEWAY, 29);
		put(Material.BASALT, 29);
		put(Material.POLISHED_BASALT, 29);
		put(Material.NETHERITE_BLOCK, 29);
		put(Material.ANCIENT_DEBRIS, 29);
		put(Material.CRYING_OBSIDIAN, 29);
		put(Material.RESPAWN_ANCHOR, 29);
		put(Material.BLACKSTONE, 29);
		put(Material.POLISHED_BLACKSTONE, 29);
		put(Material.POLISHED_BLACKSTONE_BRICKS, 29);
		put(Material.GILDED_BLACKSTONE, 29);
		
		put(Material.GOLD_BLOCK, 30);
		put(Material.LIGHT_WEIGHTED_PRESSURE_PLATE, 30);
		put(Material.BELL, 30);

		put(Material.DIAMOND_BLOCK, 31);
		put(Material.BEACON, 31);
		put(Material.PRISMARINE_BRICKS, 31);
		put(Material.PRISMARINE_BRICK_SLAB, 31);
		put(Material.PRISMARINE_BRICK_STAIRS, 31);
		put(Material.DARK_PRISMARINE, 31);
		put(Material.DARK_PRISMARINE_SLAB, 31);
		put(Material.DARK_PRISMARINE_STAIRS, 31);
		put(Material.CONDUIT, 31);

		put(Material.LAPIS_BLOCK, 32);

		put(Material.EMERALD_BLOCK, 33);
		
		put(Material.PODZOL, 34);
		put(Material.SPRUCE_PLANKS, 34);
		put(Material.STRIPPED_SPRUCE_LOG, 34);
		put(Material.SPRUCE_WOOD, 34);
		put(Material.STRIPPED_SPRUCE_WOOD, 34);
		put(Material.SPRUCE_SIGN, 34);
		put(Material.SPRUCE_WALL_SIGN, 34);
		put(Material.SPRUCE_PRESSURE_PLATE, 34);
		put(Material.SPRUCE_TRAPDOOR, 34);
		put(Material.SPRUCE_STAIRS, 34);
		put(Material.SPRUCE_SLAB, 34);
		put(Material.SPRUCE_FENCE, 34);
		put(Material.SPRUCE_FENCE_GATE, 34);
		put(Material.SPRUCE_DOOR, 34);
		put(Material.OAK_LOG, 34);
		put(Material.JUNGLE_LOG, 34);
		put(Material.CAMPFIRE, 34);
		put(Material.SOUL_CAMPFIRE, 34);

		put(Material.NETHERRACK, 35);
		put(Material.NETHER_BRICKS, 35);
		put(Material.NETHER_BRICK_FENCE, 35);
		put(Material.NETHER_BRICK_SLAB, 35);
		put(Material.NETHER_BRICK_STAIRS, 35);
		put(Material.NETHER_BRICK_WALL, 35);
		put(Material.CHISELED_NETHER_BRICKS, 35);
		put(Material.CRACKED_NETHER_BRICKS, 35);
		put(Material.NETHER_GOLD_ORE, 35);
		put(Material.NETHER_QUARTZ_ORE, 35);
		put(Material.MAGMA_BLOCK, 35);
		put(Material.RED_NETHER_BRICKS, 35);
		put(Material.RED_NETHER_BRICK_SLAB, 35);
		put(Material.RED_NETHER_BRICK_STAIRS, 35);
		put(Material.RED_NETHER_BRICK_WALL, 35);
		put(Material.CRIMSON_ROOTS, 35);
		put(Material.CRIMSON_PRESSURE_PLATE, 35);
		put(Material.CRIMSON_FENCE, 35);
		put(Material.CRIMSON_TRAPDOOR, 35);
		put(Material.CRIMSON_FENCE_GATE, 35);
		put(Material.CRIMSON_DOOR, 35);
		put(Material.CRIMSON_SIGN, 35);
		put(Material.CRIMSON_FUNGUS, 35);
		put(Material.WEEPING_VINES, 35);
		
		put(Material.WHITE_TERRACOTTA, 36);

		put(Material.ORANGE_TERRACOTTA, 37);

		put(Material.MAGENTA_TERRACOTTA, 38);

		put(Material.LIGHT_BLUE_TERRACOTTA, 39);

		put(Material.YELLOW_TERRACOTTA, 40);

		put(Material.LIME_TERRACOTTA, 41);

		put(Material.PINK_TERRACOTTA, 42);

		put(Material.GRAY_TERRACOTTA, 43);

		put(Material.LIGHT_GRAY_TERRACOTTA, 44);

		put(Material.CYAN_TERRACOTTA, 45);

		put(Material.PURPLE_TERRACOTTA, 46);
		put(Material.PURPLE_SHULKER_BOX, 46);

		put(Material.BLUE_TERRACOTTA, 47);

		put(Material.BROWN_TERRACOTTA, 48);

		put(Material.GREEN_TERRACOTTA, 49);

		put(Material.RED_TERRACOTTA, 50);

		put(Material.BLACK_TERRACOTTA, 51);

		put(Material.CRIMSON_NYLIUM, 52);

		put(Material.CRIMSON_STEM, 53);
		put(Material.STRIPPED_CRIMSON_STEM, 53);
		put(Material.CRIMSON_PLANKS, 53);
		put(Material.CRIMSON_STAIRS, 53);
		put(Material.CRIMSON_SLAB, 53);

		put(Material.CRIMSON_HYPHAE, 54);
		put(Material.STRIPPED_CRIMSON_HYPHAE, 54);

		put(Material.WARPED_NYLIUM, 55);

		put(Material.WARPED_STEM, 56);
		put(Material.STRIPPED_WARPED_STEM, 56);
		put(Material.WARPED_PLANKS, 56);
		put(Material.WARPED_STAIRS, 56);
		put(Material.WARPED_SLAB, 56);

		put(Material.WARPED_HYPHAE, 57);
		put(Material.STRIPPED_WARPED_HYPHAE, 57);

		put(Material.WARPED_WART_BLOCK, 58);
	}};
	
	
	/**
	 * Gets Color and shades it accordingly.
	 * @see <a href="https://minecraft.gamepedia.com/Map_item_format#Map_colors">Map colors and shades</a> 
	 * @param code base color ID
	 * @param offset color shade
	 * @return resulting color
	 */
	public static Color getColor(int code, int offset) {
		if(colors.containsKey(code)) {
			Color c = colors.get(code);
			switch(offset) {
			case 0:
				return multiply(c,0.71);
			case 1:
				return multiply(c,0.86);
			case 2:
				return c;
			case 3:
				return multiply(c,0.53); //will never be used but sure
			default:
				return c;
			}
		}
		return Color.BLACK;
	}
	/**
	 * Multiplies Red, Green and Blue channels of color by given multiplier 
	 * @param c - initial color
	 * @param d - multiplier
	 * @return altered color 
	 */
	private static Color multiply(Color c, double d) {
		int r = (int) (c.getRed()*d);
		int g = (int) (c.getGreen()*d);
		int b = (int) (c.getBlue()*d);
		return new Color(r,g,b);
	}
	
	/**
	 * gets minecraft base color ID for given material
	 * @see <a href="https://minecraft.gamepedia.com/Map_item_format#Color_table">Map color table</a>
	 * @param material
	 * @return color ID
	 */
	public static int getColorCode(Material material) {
		return materials.getOrDefault(material, 0);
	}
}

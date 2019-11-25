package barryflash.superheroes.client;

import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.init.ModBlocks;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler {
	
	public static void registerCraftingRecipes() {
		/*GameRegistry.addShapedRecipe(new ItemStack(ModItems.red_amazonian_ingot), new Object[] { "AR", 'A', ModItems.amazonian_ingot, 'R', new ItemStack(Items.DYE, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.blue_amazonian_ingot), new Object[] { "AB", 'A', ModItems.amazonian_ingot, 'B', new ItemStack(Items.DYE, 1, 4)});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.amazonian_steel_ingot), new Object[] { "AS", 'A', ModItems.amazonian_ingot, 'S', ModItems.steel_ingot});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.wonderwoman_bracelet, 2), new Object[] { "AL ", "S  ", "AL ", 'A', ModItems.amazonian_ingot, 'L', Items.LEATHER, 'S', ModItems.amazonian_steel_ingot});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.batman_batarang_explosive), new Object[] { " T ", " B ", "   ", 'T', Blocks.TNT, 'B', ModItems.batman_batarang});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.batman_symbol), new Object[] { " B ", "CBC", "   ", 'B', ModBlocks.blackdiamond_block, 'C', Blocks.COAL_BLOCK});
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.blackdiamond_block), new Object[] { "BBB", "BBB", "BBB", 'B', ModItems.black_diamond});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.batman_utilitybelt), new Object[] { "   ", "BCB", "   ", 'B', ModItems.black_leather, 'C', Blocks.CHEST});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.black_diamond), new Object[] { "   ", " DB", "   ", 'B', new ItemStack(Items.DYE, 1, 0), 'D', Items.DIAMOND});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.black_leather), new Object[] { "   ", " LB", "   ", 'B', new ItemStack(Items.DYE, 1, 0), 'L', Items.LEATHER});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.chainmail_plate, 2), new Object[] { "BIB", "I I", "BIB", 'B', Blocks.IRON_BARS, 'I', Items.IRON_INGOT});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.green_chainmail), new Object[] { "CPC", "PGP", "CPC", 'C', ModBlocks.greencoral_block, 'P', ModItems.chainmail_plate, 'G', Items.GOLD_INGOT});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.aquaman_symbol), new Object[] { " G ", "G G", "G G", 'G', Blocks.GOLD_BLOCK});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.scrap_metal, 2), new Object[] { "   ", "IB ", "BS ", 'B', Blocks.IRON_BLOCK, 'I', Items.IRON_INGOT, 'S', ModItems.steel_ingot});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.red_scrapmetal), new Object[] { "BRI", "RSR", "IRB", 'S', ModItems.scrap_metal, 'B', Blocks.IRON_BLOCK, 'I', Items.IRON_INGOT, 'R', new ItemStack(Items.DYE, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.hardened_metal), new Object[] { "   ", "SS ", "SS ", 'S', ModItems.scrap_metal});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.flash_symbol), new Object[] { "SSG", "SGS", "GSS", 'S', ModItems.scrap_metal, 'G', Blocks.GOLD_BLOCK});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.circuit_board), new Object[] { "CDC", "IRI", "CDC", 'C', ModBlocks.copper_block, 'D', Items.DIAMOND, 'I', Items.IRON_INGOT, 'R', Blocks.REDSTONE_BLOCK});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.cyborg_symbol), new Object[] { "CCC", " R ", "CCC", 'C', ModBlocks.copper_block, 'R', Blocks.REDSTONE_BLOCK});
		registerWonderWomanArmorRecipe(ModItems.wonderwoman_symbol, ModItems.amazonian_ingot, ModItems.red_amazonian_ingot, ModItems.blue_amazonian_ingot, ModArmor.WonderWomanTiara, ModArmor.WonderWomanChestplate, ModArmor.WonderWomanSkirt, ModArmor.WonderWomanBoots, ModItems.wonderwoman_bracelet);
		//registerAresArmorRecipe(ModItems.amazonian_steel_ingot, ModArmor.AresHelmet, ModArmor.AresChestplate, ModArmor.AresLeggings, ModArmor.AresBoots);
		registerBatmanArmorRecipe(ModItems.black_leather, new ItemStack(Blocks.WOOL, 1, 8), ModItems.batman_utilitybelt, ModItems.batman_symbol, ModArmor.BatmanCowl, ModArmor.BatmanChest, ModArmor.BatmanLeggings, ModArmor.BatmanBoots);
		registerAquamanArmorRecipe(ModItems.green_chainmail, ModItems.aquaman_symbol, Blocks.GOLD_BLOCK, ModArmor.AquamanChest, ModArmor.AquamanLeggings, ModArmor.AquamanBoots);
		registerFlashArmorRecipe(ModItems.flash_symbol, Blocks.GOLD_BLOCK, ModItems.red_scrapmetal, ModArmor.FlashMask, ModArmor.FlashChest, ModArmor.FlashLeggings, ModArmor.FlashBoots);
		registerCyborgArmorRecipe(ModItems.cyborg_symbol, ModItems.hardened_metal, ModItems.circuit_board, ModArmor.CyborgHelmet, ModArmor.CyborgChest, ModArmor.CyborgLegs, ModArmor.CyborgBoots);
		Utils.getLogger().info("Registered Crafting Recipes!");*/
	}
	
	


	




	/*public static void registerFurnaceRecipes() {
		GameRegistry.addSmelting(ModBlocks.amazonian_ore, new ItemStack(ModItems.amazonian_ingot), 0.5F);
		GameRegistry.addSmelting(Items.IRON_INGOT, new ItemStack(ModItems.steel_ingot), 0.2F);
		GameRegistry.addSmelting(ModBlocks.greencoral_block, new ItemStack(Items.DYE, 2, 2), 0.1F);
		Utils.getLogger().info("Registered Furnace Recipes!");
	}
	//WonderWoman
	private static void registerWonderWomanArmorRecipe(Item symbol, Item amazonian, Item redamazonian, Item blueamazonian, Item Tiara, Item Chestplate, Item Skirt, Item Boots, Item bracelet) {
		GameRegistry.addRecipe(new ItemStack(Tiara), new Object[] { "AAA", " A ", "   ", 'A', amazonian});
		GameRegistry.addRecipe(new ItemStack(Chestplate), new Object[] { " A ", "ARA", "BSB", 'A', amazonian, 'R', redamazonian, 'B', bracelet, 'S', symbol});
		GameRegistry.addRecipe(new ItemStack(Skirt), new Object[] { "AAA", "BBB", "B B", 'A', amazonian, 'B', blueamazonian});
		GameRegistry.addRecipe(new ItemStack(Boots), new Object[] { "   ", "A A", "R R", 'A', amazonian, 'R', redamazonian});
	}
	private static void registerAresArmorRecipe(Item amazoniansteel, Item Helm, Item Chest, Item Leggings, Item Boots) {
		GameRegistry.addRecipe(new ItemStack(Helm), new Object[] { "AAA", "AAA", " A ", 'A', amazoniansteel});
		GameRegistry.addRecipe(new ItemStack(Chest), new Object[] { "A A", "AAA", "AAA", 'A', amazoniansteel});
		GameRegistry.addRecipe(new ItemStack(Leggings), new Object[] { "AAA", "A A", "A A", 'A', amazoniansteel});
		GameRegistry.addRecipe(new ItemStack(Boots), new Object[] { "   ", "A A", "A A", 'A', amazoniansteel});
	}
	//Batman
	private static void registerBatmanArmorRecipe(Item blackleather, ItemStack itemStack, Item utilitybelt, Item batsymbol, Item Cowl, Item Chest, Item Leggings, Item Boots) {
		GameRegistry.addRecipe(new ItemStack(Cowl), new Object[] { "B B", " B ", "BBB", 'B', blackleather});
		GameRegistry.addRecipe(new ItemStack(Chest), new Object[] { "G G", "GSG", "BUB", 'G', itemStack, 'S', batsymbol, 'B', blackleather, 'U', utilitybelt});
		GameRegistry.addRecipe(new ItemStack(Leggings), new Object[] { "GGG", "G G", "G G", 'G', itemStack});
		//GameRegistry.addRecipe(new ItemStack(Boots), new Object[] { "   ", "D D", "B B", 'B', blackleather, 'D', ModItems.black_diamond});
	}
	//Aquaman
	private static void registerAquamanArmorRecipe(Item Chain, Item Symbol, Block Gold, Item Chest, Item Legs, Item Boots) {
		GameRegistry.addRecipe(new ItemStack(Chest), new Object[] { "G G", "CCC", "CSC", 'G', Gold, 'C', Chain, 'S', Symbol});
		GameRegistry.addRecipe(new ItemStack(Legs), new Object[] { "CCC", "G G", "C C", 'G', Gold, 'C', Chain});
		GameRegistry.addRecipe(new ItemStack(Boots), new Object[] { "   ", "C C", "G G", 'G', Gold, 'C', Chain});
		
	}
	//Flash
	private static void registerFlashArmorRecipe(Item symbol, Block gold, Item red, Item Mask, Item Chest, Item Legs, Item Boots) {
		GameRegistry.addRecipe(new ItemStack(Mask), new Object[] { "GRG", " R ", "RRR", 'R', red, 'G', gold});
		GameRegistry.addRecipe(new ItemStack(Chest), new Object[] { "R R", "RSR", "GRG", 'R', red, 'G', gold, 'S', symbol});
		GameRegistry.addRecipe(new ItemStack(Legs), new Object[] { "RRR", "R R", "R R", 'R', red, 'G', gold});
		GameRegistry.addRecipe(new ItemStack(Boots), new Object[] { "   ", "R R", "G G", 'R', red, 'G', gold});
		
	}
	private static void registerCyborgArmorRecipe(Item symbol, Item metal, Item circuit, Item Helm, Item Chest, Item Legs, Item Boots) {
		GameRegistry.addRecipe(new ItemStack(Helm), new Object[] { " MM", " CM", "MMM", 'C', circuit, 'M', metal});
		GameRegistry.addRecipe(new ItemStack(Chest), new Object[] { "M M", "CSC", "MMM", 'C', circuit, 'M', metal, 'S', symbol});
		GameRegistry.addRecipe(new ItemStack(Legs), new Object[] { "MCM", "M M", "M M", 'C', circuit, 'M', metal});
		GameRegistry.addRecipe(new ItemStack(Boots), new Object[] { "   ", "C C", "M M", 'C', circuit, 'M', metal});
		
	}

	*/
}

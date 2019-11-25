package barryflash.superheroes.recipes;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nullable;

import barryflash.superheroes.init.ModBlocks;
import barryflash.superheroes.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class TMURecipes {

	public static List<ItemStack> nanotechIngredients = new ArrayList<ItemStack>();
	public static List nanotech = new ArrayList();
	
	public static List<ItemStack> circuitBoardIngredients = new ArrayList<ItemStack>();
	public static List circuitBoard = new ArrayList();
	
	public static List<ItemStack> titaniumgoldIngredients = new ArrayList<ItemStack>();
	public static List titaniumgold = new ArrayList();
	
	public static List<ItemStack> tgfiberIngredients = new ArrayList<ItemStack>();
	public static List tgfiber = new ArrayList();
	
	public static List<ItemStack> titaniumgoldblockIngredients = new ArrayList<ItemStack>();
	public static List titaniumgoldblock = new ArrayList();
	
	public static List<ItemStack> kryptonianDNAIngredients = new ArrayList<ItemStack>();
	public static List kryptonianDNA = new ArrayList();
	
	public static List<ItemStack> codexIngredients = new ArrayList<ItemStack>();
	public static List codex = new ArrayList();
	
	public static List<ItemStack> vibraniumPlateIngredients = new ArrayList<ItemStack>();
	public static List vibraniumPlate = new ArrayList();
	
	public static List<ItemStack> ironFiberIngredients = new ArrayList<ItemStack>();
	public static List ironFiber = new ArrayList();
	
	public static List<ItemStack> gunBaseIngredients = new ArrayList<ItemStack>();
	public static List gunBase = new ArrayList();
	
	public static List<ItemStack> quiverIngredients = new ArrayList<ItemStack>();
	public static List quiver = new ArrayList();
	
	public static List<ItemStack> tmuIngredients = new ArrayList<ItemStack>();
	public static List tmu = new ArrayList();
	
	public static List<ItemStack> nanoCompacterIngredients = new ArrayList<ItemStack>();
	public static List nanoCompacter = new ArrayList();
	
	public static List<ItemStack> crucibleIngredients = new ArrayList<ItemStack>();
	public static List crucible = new ArrayList();
	
	public static List<ItemStack> fuelGeneratorIngredients = new ArrayList<ItemStack>();
	public static List fuelGenerator = new ArrayList();
	
	public static List<ItemStack> tgBlockIngredients = new ArrayList<ItemStack>();
	public static List tgBlock = new ArrayList();
	
	public static List<ItemStack> dnaExtractorIngredients = new ArrayList<ItemStack>();
	public static List dnaExtractor = new ArrayList();
	
	public static List<ItemStack> metallicShellIngredients = new ArrayList<ItemStack>();
	public static List metallicShell = new ArrayList();
	
	public static List<ItemStack> reinforcedGlassIngredients = new ArrayList<ItemStack>();
	public static List reinforcedGlass = new ArrayList();
	
	public static List<ItemStack> reinforcedDoorIngredients = new ArrayList<ItemStack>();
	public static List reinforcedDoor = new ArrayList();

	public static List<ItemStack> controlPanelIngredients = new ArrayList<ItemStack>();
	public static List controlPanel = new ArrayList();
	
	public static List<ItemStack> fusionCoreIngredients = new ArrayList<ItemStack>();
	public static List fusionCore = new ArrayList();
	
	public static List<ItemStack> uraniumBlockIngredients = new ArrayList<ItemStack>();
	public static List uraniumBlock = new ArrayList();
	
	public static List<ItemStack> vibraniumBlockIngredients = new ArrayList<ItemStack>();
	public static List vibraniumBlock = new ArrayList();
	
	public static List<ItemStack> superSoldierCompositeIngredients = new ArrayList<ItemStack>();
	public static List superSoldierComposite = new ArrayList();
	
	public static List<ItemStack> wwSwordIngredients = new ArrayList<ItemStack>();
	public static List wwSword = new ArrayList();
	
	public static List<ItemStack> capShieldIngredients = new ArrayList<ItemStack>();
	public static List capShield = new ArrayList();
	
	public static List<ItemStack> batonsIngredients = new ArrayList<ItemStack>();
	public static List batons = new ArrayList();
	
	public static List<ItemStack> pistolIngredients = new ArrayList<ItemStack>();
	public static List pistol = new ArrayList();
	
	public static List<ItemStack> bowIngredients = new ArrayList<ItemStack>();
	public static List bow = new ArrayList();
	
	public static List<ItemStack> wwShieldIngredients = new ArrayList<ItemStack>();
	public static List wwShield = new ArrayList();
	
	public static List<ItemStack> lightningExtractorIngredients = new ArrayList<ItemStack>();
	public static List lightningExtractor = new ArrayList();
	
	public static List<ItemStack> supersoldierserumIngredients = new ArrayList<ItemStack>();
	public static List supersoldierserum = new ArrayList();
	
	public static List<ItemStack> radiationIngredients = new ArrayList<ItemStack>();
	public static List radiation = new ArrayList();
	
	public static List<ItemStack> nanoparticlesIngredients = new ArrayList<ItemStack>();
	public static List nanoparticles = new ArrayList();
	
	public static List recipes = new ArrayList();
	public static String CRAFTING = "crafting";
	public static String CRUCIBLE = "crucible";
	public static String COMPACTER = "compacter";
	public static void registerRecipes() {
		addToRecipe(CRAFTING, new ItemStack(ModItems.cap_shield), capShield, capShieldIngredients, 
				new ItemStack(ModItems.VIBRANIUM_PLATE), new ItemStack(Blocks.LAPIS_BLOCK), new ItemStack(ModItems.VIBRANIUM_PLATE), 
				new ItemStack(ModItems.VIBRANIUM_PLATE), new ItemStack(Blocks.IRON_BLOCK), new ItemStack(ModItems.VIBRANIUM_PLATE), 
				new ItemStack(ModItems.VIBRANIUM_PLATE), new ItemStack(Blocks.REDSTONE_BLOCK), new ItemStack(ModItems.VIBRANIUM_PLATE));
		addToRecipe(CRAFTING, new ItemStack(ModItems.ELECTRIC_BATON, 2), batons, batonsIngredients, 
				new ItemStack(Items.IRON_INGOT), ItemStack.EMPTY, new ItemStack(Items.IRON_INGOT), 
				new ItemStack(Items.BLAZE_ROD), ItemStack.EMPTY, new ItemStack(Items.BLAZE_ROD), 
				new ItemStack(Items.IRON_INGOT), ItemStack.EMPTY, new ItemStack(Items.IRON_INGOT));
		
		addToRecipe(CRAFTING, new ItemStack(ModItems.PISTOL), pistol, pistolIngredients, 
				new ItemStack(Items.IRON_INGOT), new ItemStack(Items.IRON_INGOT), new ItemStack(Items.IRON_INGOT), 
				new ItemStack(Blocks.DISPENSER), new ItemStack(ModItems.GUN_BASE), new ItemStack(Items.IRON_INGOT), 
				ItemStack.EMPTY, new ItemStack(Blocks.STONE_BUTTON), new ItemStack(Items.IRON_INGOT));

		addToRecipe(CRAFTING, new ItemStack(ModItems.hawkeye_bow), bow, bowIngredients, 
				new ItemStack(Items.STRING), new ItemStack(Items.IRON_INGOT), ItemStack.EMPTY, 
				new ItemStack(Items.STRING), new ItemStack(ModItems.GUN_BASE), new ItemStack(Blocks.IRON_BLOCK), 
				new ItemStack(Items.STRING), new ItemStack(Items.IRON_INGOT), ItemStack.EMPTY);
		
		addToRecipe(CRAFTING, new ItemStack(ModItems.WonderWomanSword), wwSword, wwSwordIngredients, 
				ItemStack.EMPTY, new ItemStack(ModItems.AMAZONIAN_INGOT), ItemStack.EMPTY, 
				ItemStack.EMPTY, new ItemStack(ModItems.AMAZONIAN_INGOT), ItemStack.EMPTY, 
				ItemStack.EMPTY, new ItemStack(Items.STICK), ItemStack.EMPTY);
		
		addToRecipe(CRAFTING, new ItemStack(ModItems.wonderwoman_shield), wwShield, wwShieldIngredients, 
				new ItemStack(ModItems.AMAZONIAN_INGOT), new ItemStack(Items.IRON_INGOT), new ItemStack(ModItems.AMAZONIAN_INGOT), 
				new ItemStack(ModItems.AMAZONIAN_INGOT), new ItemStack(ModItems.AMAZONIAN_INGOT), new ItemStack(ModItems.AMAZONIAN_INGOT), 
				ItemStack.EMPTY, new ItemStack(ModItems.AMAZONIAN_INGOT), ItemStack.EMPTY);
		
		addToRecipe(CRAFTING, new ItemStack(ModItems.CIRCUIT_BOARD), circuitBoard, circuitBoardIngredients, new ItemStack(Items.IRON_INGOT), new ItemStack(Items.REDSTONE), ItemStack.EMPTY, new ItemStack(Items.REDSTONE), new ItemStack(ModItems.titanium_ingot), ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY);
		
		addToRecipe(CRAFTING, new ItemStack(ModBlocks.CODEX_BLOCK), codex, codexIngredients,
				new ItemStack(ModItems.KRYPTONIAN_DNA), new ItemStack(ModItems.KRYPTONIAN_DNA), new ItemStack(ModItems.KRYPTONIAN_DNA),
				new ItemStack(ModItems.KRYPTONIAN_DNA), new ItemStack(Items.SKULL, 1, 0), new ItemStack(ModItems.KRYPTONIAN_DNA),
				new ItemStack(ModItems.KRYPTONIAN_DNA), new ItemStack(ModItems.KRYPTONIAN_DNA), new ItemStack(ModItems.KRYPTONIAN_DNA));
		
		addToRecipe(CRAFTING, new ItemStack(ModBlocks.FUSION_CHAMBER_CONTROL), controlPanel, controlPanelIngredients,
				new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK), new ItemStack(Blocks.STONE_BUTTON), new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK),
				new ItemStack(Items.IRON_INGOT), new ItemStack(Blocks.UNPOWERED_REPEATER), new ItemStack(Items.IRON_INGOT),
				new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK), new ItemStack(Items.IRON_INGOT), new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK));
		
		addToRecipe(CRAFTING, new ItemStack(ModBlocks.CRUCIBLE_BLOCK), crucible, crucibleIngredients,
				ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY,
				new ItemStack(Blocks.HARDENED_CLAY), ItemStack.EMPTY, new ItemStack(Blocks.HARDENED_CLAY),
				new ItemStack(Blocks.HARDENED_CLAY), new ItemStack(Blocks.HARDENED_CLAY), new ItemStack(Blocks.HARDENED_CLAY));
		
		addToRecipe(CRAFTING, new ItemStack(ModBlocks.DNA_EXTRACTOR_BLOCK), dnaExtractor, dnaExtractorIngredients,
				new ItemStack(Items.IRON_INGOT), new ItemStack(Blocks.IRON_BLOCK), new ItemStack(Items.IRON_INGOT),
				new ItemStack(Blocks.GLASS), new ItemStack(Blocks.IRON_BARS), new ItemStack(Blocks.GLASS),
				new ItemStack(Items.IRON_INGOT), new ItemStack(Blocks.FURNACE), new ItemStack(Items.IRON_INGOT));
		
		addToRecipe(CRAFTING, new ItemStack(ModBlocks.FUEL_GENERATOR), fuelGenerator, fuelGeneratorIngredients,
				new ItemStack(Items.IRON_INGOT), new ItemStack(Blocks.COAL_BLOCK), new ItemStack(Items.IRON_INGOT),
				new ItemStack(Blocks.IRON_BLOCK), new ItemStack(Items.BLAZE_POWDER), new ItemStack(Blocks.IRON_BLOCK),
				new ItemStack(Items.IRON_INGOT), new ItemStack(Blocks.REDSTONE_BLOCK), new ItemStack(Items.IRON_INGOT));
		
		addToRecipe(CRAFTING, new ItemStack(ModBlocks.FUSION_CHAMBER_CORE), fusionCore, fusionCoreIngredients,
				new ItemStack(Items.IRON_INGOT), new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK), new ItemStack(Items.IRON_INGOT),
				new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK), new ItemStack(Items.DIAMOND), new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK),
				new ItemStack(Items.IRON_INGOT), new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK), new ItemStack(Items.IRON_INGOT));
		
		addToRecipe(CRAFTING, new ItemStack(ModItems.GUN_BASE), gunBase, gunBaseIngredients,
				new ItemStack(Items.IRON_INGOT), new ItemStack(Items.IRON_INGOT),new ItemStack(Items.IRON_INGOT),
				new ItemStack(Items.IRON_INGOT), new ItemStack(Blocks.PISTON), new ItemStack(Items.IRON_INGOT),
				ItemStack.EMPTY, new ItemStack(Blocks.STONE_BUTTON), new ItemStack(Items.IRON_INGOT));
		
		addToRecipe(CRAFTING, new ItemStack(ModItems.IRON_FIBER, 8), ironFiber, ironFiberIngredients,
				new ItemStack(Blocks.WOOL, 1, 0), new ItemStack(Items.IRON_INGOT), new ItemStack(Blocks.WOOL, 1, 0),
				new ItemStack(Items.IRON_INGOT), new ItemStack(Blocks.WOOL, 1, 0), new ItemStack(Items.IRON_INGOT),
				new ItemStack(Blocks.WOOL, 1, 0), new ItemStack(Items.IRON_INGOT), new ItemStack(Blocks.WOOL, 1, 0));
		
		addToRecipe(CRAFTING, new ItemStack(ModItems.KRYPTONIAN_DNA), kryptonianDNA, kryptonianDNAIngredients,
				new ItemStack(ModItems.DNA_FRAGMENT), ItemStack.EMPTY, new ItemStack(ModItems.DNA_FRAGMENT),
				new ItemStack(ModItems.DNA_FRAGMENT), new ItemStack(ModItems.DNA_FRAGMENT), new ItemStack(ModItems.DNA_FRAGMENT),
				new ItemStack(ModItems.DNA_FRAGMENT), ItemStack.EMPTY, new ItemStack(ModItems.DNA_FRAGMENT));
		addToRecipe(CRAFTING, new ItemStack(ModBlocks.LIGHTNING_EXTRACTOR), lightningExtractor, lightningExtractorIngredients,
				ItemStack.EMPTY, new ItemStack(Item.getItemFromBlock(Blocks.DIAMOND_BLOCK)), ItemStack.EMPTY,
				new ItemStack(Items.IRON_INGOT), new ItemStack(Item.getItemFromBlock(Blocks.IRON_BARS)), new ItemStack(Items.IRON_INGOT),
				new ItemStack(Item.getItemFromBlock(Blocks.IRON_BLOCK)), new ItemStack(Item.getItemFromBlock(Blocks.IRON_BLOCK)), new ItemStack(Item.getItemFromBlock(Blocks.IRON_BLOCK)));
		
		addToRecipe(CRAFTING, new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK), metallicShell, metallicShellIngredients,
				ItemStack.EMPTY, new ItemStack(Items.IRON_INGOT), ItemStack.EMPTY,
				new ItemStack(Items.IRON_INGOT), new ItemStack(Blocks.STONE), new ItemStack(Items.IRON_INGOT),
				ItemStack.EMPTY, new ItemStack(Items.IRON_INGOT), ItemStack.EMPTY);
		
		addToRecipe(CRAFTING, new ItemStack(ModBlocks.NANO_COMPACTER_BLOCK), nanoCompacter, nanoCompacterIngredients,
				new ItemStack(Items.IRON_INGOT), new ItemStack(Blocks.REDSTONE_LAMP), new ItemStack(Items.IRON_INGOT),
				new ItemStack(Items.IRON_INGOT), new ItemStack(Items.DIAMOND), new ItemStack(Items.IRON_INGOT),
				new ItemStack(Items.IRON_INGOT), new ItemStack(Blocks.PISTON), new ItemStack(Items.IRON_INGOT));
		
		addToRecipe(CRAFTING, new ItemStack(ModItems.QUIVER), quiver, quiverIngredients,
				new ItemStack(Items.STRING), new ItemStack(Blocks.CHEST), ItemStack.EMPTY,
				new ItemStack(Items.IRON_INGOT), new ItemStack(Items.STRING), new ItemStack(Blocks.CHEST),
				new ItemStack(Blocks.IRON_BLOCK), new ItemStack(Items.IRON_INGOT), new ItemStack(Items.STRING));
		addToRecipe(COMPACTER, new ItemStack(ModItems.RADIATION_VIAL), radiation, radiationIngredients, new ItemStack(Item.getItemFromBlock(ModBlocks.URANIUM_BLOCK), 1), ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY);
		addToRecipe(CRAFTING, new ItemStack(ModBlocks.FUSION_CHAMBER_DOOR), reinforcedDoor, reinforcedDoorIngredients,
				new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK), new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK), ItemStack.EMPTY,
				new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK), new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK), ItemStack.EMPTY,
				new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK), new ItemStack(ModBlocks.FUSION_CHAMBER_BLOCK), ItemStack.EMPTY);
		
		addToRecipe(CRAFTING, new ItemStack(ModBlocks.FUSION_CHAMBER_WINDOW), reinforcedGlass, reinforcedGlassIngredients,
				ItemStack.EMPTY, new ItemStack(Items.IRON_INGOT), ItemStack.EMPTY,
				new ItemStack(Items.IRON_INGOT), new ItemStack(Blocks.GLASS), new ItemStack(Items.IRON_INGOT),
				ItemStack.EMPTY, new ItemStack(Items.IRON_INGOT), ItemStack.EMPTY);
		
		
		addToRecipe(CRAFTING, new ItemStack(ModItems.SUPERSOLDIER_COMPOSITE), superSoldierComposite, superSoldierCompositeIngredients,
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM, 1, 0), PotionType.getPotionTypeForName("strong_regeneration")), PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM, 1, 0), PotionType.getPotionTypeForName("strong_strength")), ItemStack.EMPTY,
				new ItemStack(Blocks.DIAMOND_BLOCK), ItemStack.EMPTY, ItemStack.EMPTY,
				ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY);
		addToRecipe(COMPACTER, new ItemStack(ModItems.SUPERSOLDIER_SERUM), supersoldierserum, supersoldierserumIngredients, new ItemStack(ModItems.SUPERSOLDIER_COMPOSITE, 1), ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY);
		addToRecipe(CRAFTING, new ItemStack(ModBlocks.TITANIUMGOLD_BLOCK), titaniumgoldblock, titaniumgoldblockIngredients,
				new ItemStack(ModItems.TITANIUMGOLD_INGOT), new ItemStack(ModItems.TITANIUMGOLD_INGOT), new ItemStack(ModItems.TITANIUMGOLD_INGOT),
				new ItemStack(ModItems.TITANIUMGOLD_INGOT), new ItemStack(ModItems.TITANIUMGOLD_INGOT), new ItemStack(ModItems.TITANIUMGOLD_INGOT),
				new ItemStack(ModItems.TITANIUMGOLD_INGOT), new ItemStack(ModItems.TITANIUMGOLD_INGOT), new ItemStack(ModItems.TITANIUMGOLD_INGOT));
		
		addToRecipe(CRAFTING, new ItemStack(ModItems.TITANIUM_GOLD_CARBONFIBER, 8), tgfiber, tgfiberIngredients,
				new ItemStack(Blocks.WOOL, 1, 0), new ItemStack(ModItems.TITANIUMGOLD_INGOT), new ItemStack(Blocks.WOOL, 1, 0),
				new ItemStack(ModItems.TITANIUMGOLD_INGOT), new ItemStack(Blocks.WOOL, 1, 0), new ItemStack(ModItems.TITANIUMGOLD_INGOT),
				new ItemStack(Blocks.WOOL, 1, 0), new ItemStack(ModItems.TITANIUMGOLD_INGOT), new ItemStack(Blocks.WOOL, 1, 0));
		
		
		
		
		
		addToRecipe(CRUCIBLE, new ItemStack(ModItems.TITANIUMGOLD_INGOT), titaniumgold, titaniumgoldIngredients, new ItemStack(ModItems.titanium_ingot, 3), new ItemStack(Items.GOLD_INGOT, 3), ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY);
		
		addToRecipe(COMPACTER, new ItemStack(ModItems.TITANIUM_GOLD_NANOPARTICLES), nanoparticles, nanoparticlesIngredients, new ItemStack(ModItems.TITANIUMGOLD_INGOT, 1), ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY);
		
		addToRecipe(CRAFTING, new ItemStack(ModItems.TITANIUM_GOLD_NANOTECH), nanotech, nanotechIngredients,
				new ItemStack(ModItems.CIRCUIT_BOARD), new ItemStack(ModItems.TITANIUM_GOLD_NANOPARTICLES), new ItemStack(ModItems.CIRCUIT_BOARD),
				new ItemStack(ModItems.TITANIUM_GOLD_NANOPARTICLES), new ItemStack(Items.DIAMOND), new ItemStack(ModItems.TITANIUM_GOLD_NANOPARTICLES),
				new ItemStack(ModItems.CIRCUIT_BOARD), new ItemStack(ModItems.TITANIUM_GOLD_NANOPARTICLES), new ItemStack(ModItems.CIRCUIT_BOARD));
		
		addToRecipe(CRAFTING, new ItemStack(ModBlocks.SUITMAKER_BLOCK), tmu, tmuIngredients,
				new ItemStack(Blocks.IRON_BLOCK), new ItemStack(Blocks.IRON_BLOCK), ItemStack.EMPTY,
				new ItemStack(Blocks.CRAFTING_TABLE), new ItemStack(Blocks.REDSTONE_BLOCK), ItemStack.EMPTY,
				ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY);
		
		addToRecipe(CRAFTING, new ItemStack(ModBlocks.URANIUM_BLOCK), uraniumBlock, uraniumBlockIngredients,
				new ItemStack(ModItems.URANIUM_INGOT), new ItemStack(ModItems.URANIUM_INGOT), new ItemStack(ModItems.URANIUM_INGOT),
				new ItemStack(ModItems.URANIUM_INGOT), new ItemStack(ModItems.URANIUM_INGOT), new ItemStack(ModItems.URANIUM_INGOT),
				new ItemStack(ModItems.URANIUM_INGOT), new ItemStack(ModItems.URANIUM_INGOT), new ItemStack(ModItems.URANIUM_INGOT));
		
		addToRecipe(CRAFTING, new ItemStack(ModBlocks.VIBRANIUM_BLOCK), vibraniumBlock,vibraniumBlockIngredients,
				new ItemStack(ModItems.VIBRANIUM), new ItemStack(ModItems.VIBRANIUM), new ItemStack(ModItems.VIBRANIUM),
				new ItemStack(ModItems.VIBRANIUM), new ItemStack(ModItems.VIBRANIUM), new ItemStack(ModItems.VIBRANIUM),
				new ItemStack(ModItems.VIBRANIUM), new ItemStack(ModItems.VIBRANIUM), new ItemStack(ModItems.VIBRANIUM));
		
		addToRecipe(CRAFTING, new ItemStack(ModItems.VIBRANIUM_PLATE, 2), vibraniumPlate, vibraniumPlateIngredients,
				ItemStack.EMPTY, ItemStack.EMPTY, ItemStack.EMPTY,
				new ItemStack(ModItems.VIBRANIUM), new ItemStack(ModItems.VIBRANIUM), new ItemStack(ModItems.VIBRANIUM),
				new ItemStack(ModItems.VIBRANIUM), new ItemStack(ModItems.VIBRANIUM), new ItemStack(ModItems.VIBRANIUM));
		
	}
	public static void addToRecipe(String type, ItemStack output, List item, List<ItemStack> ingredients, ItemStack slot1, ItemStack slot2, ItemStack slot3, ItemStack slot4, ItemStack slot5, ItemStack slot6, ItemStack slot7, ItemStack slot8, ItemStack slot9) {
			ingredients.add(slot1);
			ingredients.add(slot2);
			ingredients.add(slot3);
			ingredients.add(slot4);
			ingredients.add(slot5);
			ingredients.add(slot6);
			ingredients.add(slot7);
			ingredients.add(slot8);
			ingredients.add(slot9);
			item.add(output);
			item.add(ingredients);
			item.add(type);
			recipes.add(item);
	}
	public static int matchingCraftingPage(ItemStack ingredient) {
		for(int i = 0; i < recipes.size(); i++) {
			if (((ItemStack)((ArrayList)recipes.get(i)).get(0)).isItemEqual(ingredient)) {
				return i+9;
			}
		}
		return -1;
	}
}

package barryflash.superheroes.init;

import java.util.ArrayList;
import java.util.List;

import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.blocks.BlockBase;
import barryflash.superheroes.blocks.BlockCodex;
import barryflash.superheroes.blocks.BlockDnaExtractor;
import barryflash.superheroes.blocks.BlockFluid;
import barryflash.superheroes.blocks.BlockFuelGenerator;
import barryflash.superheroes.blocks.BlockFusionChamberControl;
import barryflash.superheroes.blocks.BlockFusionChamberCore;
import barryflash.superheroes.blocks.BlockFusionChamberDoor;
import barryflash.superheroes.blocks.BlockFusionChamberRegular;
import barryflash.superheroes.blocks.BlockFusionChamberWindow;
import barryflash.superheroes.blocks.BlockKryptonite;
import barryflash.superheroes.blocks.BlockLightningExtractor;
import barryflash.superheroes.blocks.BlockMotherbox;
import barryflash.superheroes.blocks.BlockNanoCompacter;
import barryflash.superheroes.blocks.BlockOreBase;
import barryflash.superheroes.blocks.BlockSmeltingCrucible;
import barryflash.superheroes.blocks.BlockSuitMaker;
import barryflash.superheroes.blocks.BlockZeusShrine;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	public static final Block SUITMAKER_BLOCK = new BlockSuitMaker("suitmaker_block", Material.IRON, 2);
	public static final Block TITANIUM_ORE_BLOCK = new BlockOreBase("titanium_ore_block", Material.ROCK, 6, 2);
	public static final Block NANO_COMPACTER_BLOCK = new BlockNanoCompacter("compacter_block", Material.IRON, 2);
	public static final Block CRUCIBLE_BLOCK = new BlockSmeltingCrucible("smelting_crucible_block", Material.IRON, 2);
	public static final Block MOLTEN_TITANIUM_BLOCK = new BlockFluid("molten_titanium", ModFluids.MOLTEN_TITANIUM_FLUID, Material.LAVA);
	public static final Block MOLTEN_GOLD_BLOCK = new BlockFluid("molten_gold", ModFluids.MOLTEN_GOLD_FLUID, Material.LAVA);
	public static final Block MOLTEN_TITANIUMGOLD_BLOCK = new BlockFluid("molten_titaniumgold", ModFluids.MOLTEN_TITANIUMGOLD_FLUID, Material.LAVA);
	
	public static final Block FUEL_GENERATOR = new BlockFuelGenerator("fuel_generator", 2);
	public static final Block TITANIUMGOLD_BLOCK = new BlockBase("titaniumgold_block", Material.IRON, SuperheroesMod.blockscreativeTab, 3);
	
	public static final Block ZEUS_SHRINE_BLOCK = new BlockZeusShrine("zeus_shrine", Material.IRON, 4);
	public static final Block KRYPTONITE_BLOCK = new BlockKryptonite("kryptonite_block", Material.ROCK, 3);
	public static final Block DNA_EXTRACTOR_BLOCK = new BlockDnaExtractor("dna_extractor", Material.IRON, 2);
	public static final Block CODEX_BLOCK = new BlockCodex("codex_block", Material.GROUND, 1);
	public static final Block FUSION_CHAMBER_BLOCK = new BlockFusionChamberRegular("metallic_shell", Material.IRON, 2);
	public static final Block FUSION_CHAMBER_WINDOW = new BlockFusionChamberWindow("reinforced_glass", Material.IRON, 2);
	public static final Block FUSION_CHAMBER_DOOR = new BlockFusionChamberDoor("reinforced_door", Material.ANVIL);
	public static final Block FUSION_CHAMBER_CONTROL = new BlockFusionChamberControl("control_panel", Material.IRON, 2);
	public static final Block FUSION_CHAMBER_CORE = new BlockFusionChamberCore("fusion_core", Material.IRON, 2);
	
	public static final Block MOTHER_BOX = new BlockMotherbox("motherbox", Material.IRON, 4);
	public static final Block URANIUM_ORE_BLOCK = new BlockOreBase("uranium_ore", Material.ROCK, 8, 2);
	public static final Block URANIUM_BLOCK = new BlockBase("uranium_block", Material.ROCK, SuperheroesMod.blockscreativeTab, 3);
	public static final Block VIBRANIUM_BLOCK = new BlockBase("vibranium_block", Material.ROCK, SuperheroesMod.blockscreativeTab, 3);
	public static final Block VIBRANIUM_ORE = new BlockOreBase("vibranium_ore", Material.ROCK, 8, 2);
	
	public static final Block LIGHTNING_EXTRACTOR = new BlockLightningExtractor("lightning_extractor", Material.IRON, SuperheroesMod.machinescreativeTab, 2);
	//public static final Block CABLE = new BlockCable("cable", Material.CIRCUITS);
	/*public static Block amazonian_ore;
	public static Block blackdiamond_block;
	public static Block greencoral_block;
	public static Block copper_ore;
	public static Block copper_block;
	public static Block suitmaker_block;
	public static Block printer_casing;
	public static Block printer_interface;
	public static Block printer_powerinput;
	public static Block printer_glass;
	public static Block tesseract_energyextractor;
	public static Block tesseract;
	public static Block batman_computer;
	
	public static void init() {
		amazonian_ore = new BlockAmazonianOre("amazonian_ore", "amazonian_ore");
		blackdiamond_block = new BlockBlackDiamondBlock("blackdiamond_block", "blackdiamond_block");
		greencoral_block = new BlockGreenCoral("greencoral_block", "greencoral_block");
		copper_ore = new BlockCopperOre("copper_ore", "copper_ore");
		copper_block = new BlockCopperBlock("copper_block", "copper_block");
		suitmaker_block = new BlockSuitMaker("suitmaker_block", "suitmaker_block");
		printer_casing = new BlockPrinterCasing("printer_casing_block", "printer_casing_block");
		printer_interface = new BlockPrinterInterface("printer_interface_block", "printer_interface_block");
		printer_powerinput = new BlockPrinterPowerInput("printer_powerinput_block", "printer_powerinput_block");
		printer_glass = new BlockPrinterGlass("printer_glass_block", "printer_glass_block");
		tesseract_energyextractor = new BlockTesseractEnergyExtractor("tesseract_energyextractor_block", "tesseract_energyextractor_block");
		tesseract = new BlockTesseract("tesseract_block", "tesseract_block");
		batman_computer = new BlockBatmanComputer("batman_computer", "batman_computer");
		}
	
	public static void register() {
		registerBlock(amazonian_ore);
		registerBlock(blackdiamond_block);
		registerBlock(greencoral_block);
		registerBlock(copper_ore);
		registerBlock(copper_block);
		registerBlock(suitmaker_block);
		registerBlock(printer_casing);
		registerBlock(printer_interface);
		registerBlock(printer_powerinput);
		registerBlock(printer_glass);
		registerBlock(tesseract_energyextractor);
		registerBlock(tesseract);
		registerBlock(batman_computer);
	}
	
	public static void registerRenders() {
		registerRender(amazonian_ore);
		registerRender(blackdiamond_block);
		registerRender(greencoral_block);
		registerRender(copper_ore);
		registerRender(copper_block);
		registerRender(suitmaker_block);
		registerRender(printer_casing);
		registerRender(printer_interface);
		registerRender(printer_powerinput);
		registerRender(printer_glass);
		registerRender(tesseract_energyextractor);
		registerRender(tesseract);
		registerRender(batman_computer);
	}
	
	public static void registerBlock(Block block) {
		block.setCreativeTab(SuperheroesMod.itemcreativeTab);
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		Utils.getLogger().info("Registered Block: " + block.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, block.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Registered render for " + block.getUnlocalizedName().substring(5));
	}*/
	
}

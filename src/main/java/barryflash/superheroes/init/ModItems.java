package barryflash.superheroes.init;

import java.util.ArrayList;
import java.util.List;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.items.ItemAmazonianIngot;
import barryflash.superheroes.items.ItemAquamanSymbol;
import barryflash.superheroes.items.ItemAquamanTrident;
import barryflash.superheroes.items.ItemBase;
import barryflash.superheroes.items.ItemBatmanBatarang;
import barryflash.superheroes.items.ItemBatmanBatarangExplosive;
import barryflash.superheroes.items.ItemBatmanGrapplingGun;
import barryflash.superheroes.items.ItemBatmanSmokeBomb;
import barryflash.superheroes.items.ItemBatmanSpear;
import barryflash.superheroes.items.ItemBatmanSymbol;
import barryflash.superheroes.items.ItemBatmanUtilityBelt;
import barryflash.superheroes.items.ItemBlackDiamond;
import barryflash.superheroes.items.ItemBlackLeather;
import barryflash.superheroes.items.ItemCaptainAmericaShield;
import barryflash.superheroes.items.ItemChainmail;
import barryflash.superheroes.items.ItemCircuitBoard;
import barryflash.superheroes.items.ItemCopperIngot;
import barryflash.superheroes.items.ItemCyborgSymbol;
import barryflash.superheroes.items.ItemDoctorStrangeEyeMagic;
import barryflash.superheroes.items.ItemDoctorStrangeShields;
import barryflash.superheroes.items.ItemElectricBaton;
import barryflash.superheroes.items.ItemFlashSymbol;
import barryflash.superheroes.items.ItemGreenChainmail;
import barryflash.superheroes.items.ItemGrowDisc;
import barryflash.superheroes.items.ItemGun;
import barryflash.superheroes.items.ItemHardenedMetal;
import barryflash.superheroes.items.ItemHawkeyeBow;
import barryflash.superheroes.items.ItemInfinityStoneMind;
import barryflash.superheroes.items.ItemInfinityStonePower;
import barryflash.superheroes.items.ItemInfinityStoneReality;
import barryflash.superheroes.items.ItemInfinityStoneSoul;
import barryflash.superheroes.items.ItemInfinityStoneSpace;
import barryflash.superheroes.items.ItemInfinityStoneTime;
import barryflash.superheroes.items.ItemLokiScepter;
import barryflash.superheroes.items.ItemRedScrapMetal;
import barryflash.superheroes.items.ItemScrapMetal;
import barryflash.superheroes.items.ItemShrinkDisc;
import barryflash.superheroes.items.ItemSteelIngot;
import barryflash.superheroes.items.ItemThanosGauntlet;
import barryflash.superheroes.items.ItemThorHammer;
import barryflash.superheroes.items.ItemWonderWomanBracelet;
import barryflash.superheroes.items.ItemWonderWomanGodkiller;
import barryflash.superheroes.items.ItemWonderWomanLasso;
import barryflash.superheroes.items.ItemWonderWomanShield;
import barryflash.superheroes.items.ItemWonderWomanSymbol;
import barryflash.superheroes.items.ItemWrench;
import barryflash.superheroes.items.armor.ItemAntmanArmor;
import barryflash.superheroes.items.armor.ItemBatmanArmor;
import barryflash.superheroes.items.armor.ItemBatmanComicsArmor;
import barryflash.superheroes.items.armor.ItemBlackWidowArmor;
import barryflash.superheroes.items.armor.ItemCaptainAmericaArmor;
import barryflash.superheroes.items.armor.ItemCyborgArmor;
import barryflash.superheroes.items.armor.ItemFlashArmor;
import barryflash.superheroes.items.armor.ItemGeneralZodArmor;
import barryflash.superheroes.items.armor.ItemHawkeyeArmor;
import barryflash.superheroes.items.armor.ItemHulkArmor;
import barryflash.superheroes.items.armor.ItemIronmanMark50ArcReactorArmor;
import barryflash.superheroes.items.armor.ItemIronmanMark50Armor;
import barryflash.superheroes.items.armor.ItemLokiArmor;
import barryflash.superheroes.items.armor.ItemShazamArmor;
import barryflash.superheroes.items.armor.ItemSupermanArmor;
import barryflash.superheroes.items.armor.ItemThorArmor;
import barryflash.superheroes.items.armor.ItemWaspArmor;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import barryflash.superheroes.util.Utils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	//TOOLS
	public static final ToolMaterial AmazonianMaterial = EnumHelper.addToolMaterial(Reference.MODID + ":amazonian", 2, 0, 2.0F, 1.0F, 0);
	public static final ToolMaterial AtlantianMaterial = EnumHelper.addToolMaterial(Reference.MODID + ":atlantian", 2, 0, 1.0F, 2.0F, 0);
	public static final ToolMaterial KryptoniteMaterial = EnumHelper.addToolMaterial(Reference.MODID + ":kryptonite", 2, 0, 0.2F, 4.0F, 0);
	public static final ToolMaterial ThorMaterial = EnumHelper.addToolMaterial(Reference.MODID + ":thor", 2, 0, 0.5F, 5.0F, 0);
	public static final ToolMaterial CaptainAmericaMaterial = EnumHelper.addToolMaterial(Reference.MODID + ":captainamerica", 2, 0, 0.5F, 5.0F, 0);
	public static final ToolMaterial ElectricBatonMaterial = EnumHelper.addToolMaterial(Reference.MODID + ":electric_baton", 2, 0, 0.5F, 5.0F, 0);
	public static final ToolMaterial LokiScepterMaterial = EnumHelper.addToolMaterial(Reference.MODID + ":loki_scepter", 2, 0, 0.5F, 9.0F, 0);
	
	public static ItemSword WonderWomanSword = new ItemWonderWomanGodkiller("wonderwoman_sword", AmazonianMaterial);
	public static ItemSword thor_hammer = new ItemThorHammer("thor_mjolnir", ThorMaterial);
	public static ItemSword cap_shield = new ItemCaptainAmericaShield("cap_shield", CaptainAmericaMaterial);
	public static Item ELECTRIC_BATON = new ItemElectricBaton("electric_baton", ElectricBatonMaterial);
	public static ItemSword LOKI_SCEPTER = new ItemLokiScepter("loki_scepter", LokiScepterMaterial);
	//public static Item aquaman_trident = new ItemAquamanTrident(AtlantianMaterial, "aquaman_trident", "aquaman_trident");
	//public static Item batman_kryptonitespear = new ItemBatmanKryptoniteSpear(KryptoniteMaterial, "batman_kryptonitespear", "batman_kryptonitespear");
	//public static Item thor_hammer = new ItemThorHammer(ThorMaterial, "thor_hammer", "thor_hammer");
	
	//ARMOR
	public static ArmorMaterial AmazonianArmorMaterial = EnumHelper.addArmorMaterial("amazonian", Reference.MODID + "WonderWoman", 0, new int[] {0,0,0,0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 6.5F);
	public static ArmorMaterial GodArmorMaterial = EnumHelper.addArmorMaterial("god", Reference.MODID + "ModelAresTexture", 0, new int[] {0,0,0,0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F);
	public static ArmorMaterial UnitedStatesArmy = EnumHelper.addArmorMaterial("USArmy", Reference.MODID + "SteveTrevor", 0, new int[] {0,0,0,0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F);
	public static ArmorMaterial BatmanMaterial = EnumHelper.addArmorMaterial("BatmanMat", Reference.MODID + "BatmanModel", 0, new int[] {0,0,0,0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 5.0F);
	public static ArmorMaterial AquamanMaterial = EnumHelper.addArmorMaterial("AquamanMat", Reference.MODID + "AquamanModel", 0, new int[] {0,0,0,0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 2.5F);
	public static ArmorMaterial CyborgMaterial = EnumHelper.addArmorMaterial("CyborgMat", Reference.MODID + "CyborgModel", 0, new int[] {0,0,0,0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.5F);
	public static ArmorMaterial FlashMaterial = EnumHelper.addArmorMaterial("FlashMat", Reference.MODID + "FlashModel", 0, new int[] {0,0,0,0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2.0F);
	public static ArmorMaterial KryptonianMaterial = EnumHelper.addArmorMaterial("KrypMat", Reference.MODID + "KrypModel", 0, new int[] {0,0,0,0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 7.0F);
	public static ArmorMaterial ShazamMaterial = EnumHelper.addArmorMaterial("ShazamMat", Reference.MODID + "ShazamModel", 0, new int[] {0,0,0,0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 25F);
	public static ArmorMaterial ThanosMaterial = EnumHelper.addArmorMaterial("ThanosMat", Reference.MODID + "ThanosModel", 0, new int[] {0,0,0,0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 3.2F);
	public static ArmorMaterial AsgardianMaterial = EnumHelper.addArmorMaterial("AsgMat", Reference.MODID + "AsgModel", 0, new int[] {0,0,0,0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 3.0F);
	public static ArmorMaterial MagicianSupremeMaterial = EnumHelper.addArmorMaterial("MagSupremeMat", Reference.MODID + "MagSupremeModel", 0, new int[] {0,0,0,0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F);
	public static ArmorMaterial GammaMaterial = EnumHelper.addArmorMaterial("GammaMat", Reference.MODID + "GammaModel", 0, new int[] {0,0,0,0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 20.0F);
	public static ArmorMaterial IronmanMaterial = EnumHelper.addArmorMaterial("IronmanMat", Reference.MODID + "IronmanModel", 0, new int[] {0,0,0,0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 6.0F);
	public static ArmorMaterial IronmanArcReactorMaterial = EnumHelper.addArmorMaterial("IronmanArcReactorMat", Reference.MODID + "IronmanArcReactorModel", 0, new int[] {0,0,0,0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static ArmorMaterial PymMaterial = EnumHelper.addArmorMaterial("PymMat", Reference.MODID + "PymModel", 0, new int[] {0,0,0,0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 5.5F);
	public static ArmorMaterial CapMaterial = EnumHelper.addArmorMaterial("CapMat", Reference.MODID + "CapModel", 0, new int[] {0,0,0,0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 5.5F);
	public static ArmorMaterial BlackWidowMaterial = EnumHelper.addArmorMaterial("BWMat", Reference.MODID + "BWModel", 0, new int[] {0,0,0,0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 5.5F);
	public static ArmorMaterial HawkeyeMaterial = EnumHelper.addArmorMaterial("HawkeyeMat", Reference.MODID + "HawkeyeModel", 0, new int[] {0,0,0,0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 5.5F);
	public static ArmorMaterial LokiMaterial = EnumHelper.addArmorMaterial("LokiMat", Reference.MODID + "LokiModel", 0, new int[] {0,0,0,0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 5.5F);
	/*SteveTrevorHoodie = new ItemSteveTrevorClothes(UnitedStatesArmy, 1, EntityEquipmentSlot.HEAD, "SteveTrevor_Hoodie");
	SteveTrevorJacket = new ItemSteveTrevorClothes(UnitedStatesArmy, 1, EntityEquipmentSlot.CHEST, "SteveTrevor_Jacket");
	SteveTrevorLeggings = new ItemSteveTrevorClothes(UnitedStatesArmy, 2, EntityEquipmentSlot.LEGS, "SteveTrevor_Leggings");
	SteveTrevorBoots = new ItemSteveTrevorClothes(UnitedStatesArmy, 1, EntityEquipmentSlot.FEET, "SteveTrevor_Boots");*/
		
	public static final Item WonderWomanTiara = new ItemWonderWomanArmor(AmazonianArmorMaterial, 1, EntityEquipmentSlot.HEAD, "wonderwoman_tiara", 4);
	public static final Item WonderWomanChestplate = new ItemWonderWomanArmor(AmazonianArmorMaterial, 1, EntityEquipmentSlot.CHEST, "wonderwoman_chestplate", 4);
	public static final Item WonderWomanSkirt = new ItemWonderWomanArmor(AmazonianArmorMaterial, 2, EntityEquipmentSlot.LEGS, "wonderwoman_skirt", 4);
	public static final Item WonderWomanBoots = new ItemWonderWomanArmor(AmazonianArmorMaterial, 1, EntityEquipmentSlot.FEET, "wonderwoman_boots", 4);
		
	/*AresHelmet = new ItemAresArmor(GodArmorMaterial, 1, EntityEquipmentSlot.HEAD, "Ares_Helmet");
	AresChestplate = new ItemAresArmor(GodArmorMaterial, 1, EntityEquipmentSlot.CHEST, "Ares_Chestplate");
	AresLeggings = new ItemAresArmor(GodArmorMaterial, 2, EntityEquipmentSlot.LEGS, "Ares_Leggings");
	AresBoots = new ItemAresArmor(GodArmorMaterial, 1, EntityEquipmentSlot.FEET, "Ares_Boots");*/

		
		
	public static final Item BatmanCowl = new ItemBatmanArmor(BatmanMaterial, 1, EntityEquipmentSlot.HEAD, "batman_cowl", 2);
	public static final Item BatmanChest = new ItemBatmanArmor(BatmanMaterial, 1, EntityEquipmentSlot.CHEST, "batman_chest", 2);
	public static final Item BatmanLeggings = new ItemBatmanArmor(BatmanMaterial, 2, EntityEquipmentSlot.LEGS, "batman_leggings", 2);
	public static final Item BatmanBoots = new ItemBatmanArmor(BatmanMaterial, 1, EntityEquipmentSlot.FEET, "batman_boots", 2);
	
	public static final Item BlackWidowChest = new ItemBlackWidowArmor(BlackWidowMaterial, 1, EntityEquipmentSlot.CHEST, "blackwidow_chestplate", 1);
	public static final Item BlackWidowLegs = new ItemBlackWidowArmor(BlackWidowMaterial, 2, EntityEquipmentSlot.LEGS, "blackwidow_leggings", 1);
	public static final Item BlackWidowBoots = new ItemBlackWidowArmor(BlackWidowMaterial, 1, EntityEquipmentSlot.FEET, "blackwidow_boots", 1);
	
	public static final Item HawkeyeChest = new ItemHawkeyeArmor(HawkeyeMaterial, 1, EntityEquipmentSlot.CHEST, "hawkeye_chestplate", 1);
	public static final Item HawkeyeLegs = new ItemHawkeyeArmor(HawkeyeMaterial, 2, EntityEquipmentSlot.LEGS, "hawkeye_leggings", 1);
	public static final Item HawkeyeBoots = new ItemHawkeyeArmor(HawkeyeMaterial, 1, EntityEquipmentSlot.FEET, "hawkeye_boots", 1);
		
	/*AquamanChest = new ItemAquamanArmor(AquamanMaterial, 1, EntityEquipmentSlot.CHEST, "Aquaman_Chest");
	AquamanLeggings = new ItemAquamanArmor(AquamanMaterial, 2, EntityEquipmentSlot.LEGS, "Aquaman_Leggings");
	AquamanBoots = new ItemAquamanArmor(AquamanMaterial, 1, EntityEquipmentSlot.FEET, "Aquaman_Boots");
		*/
	public static final Item CyborgHelmet = new ItemCyborgArmor(CyborgMaterial, 1, EntityEquipmentSlot.HEAD, "cyborg_helmet", 3);
	public static final Item CyborgChest = new ItemCyborgArmor(CyborgMaterial, 1, EntityEquipmentSlot.CHEST, "cyborg_chest", 3);
	public static final Item CyborgLegs = new ItemCyborgArmor(CyborgMaterial, 2, EntityEquipmentSlot.LEGS, "cyborg_legs", 3);
	public static final Item CyborgBoots = new ItemCyborgArmor(CyborgMaterial, 1, EntityEquipmentSlot.FEET, "cyborg_boots", 3);
		
	public static final Item FlashMask = new ItemFlashArmor(FlashMaterial, 1, EntityEquipmentSlot.HEAD, "flash_mask", 3);
	public static final Item FlashChest = new ItemFlashArmor(FlashMaterial, 1, EntityEquipmentSlot.CHEST, "flash_chest", 3);
	public static final Item FlashLeggings = new ItemFlashArmor(FlashMaterial, 2, EntityEquipmentSlot.LEGS, "flash_leggings", 3);
	public static final Item FlashBoots = new ItemFlashArmor(FlashMaterial, 1, EntityEquipmentSlot.FEET, "flash_boots", 3);
	
	public static final Item CaptainAmericaHelmet = new ItemCaptainAmericaArmor(CapMaterial, 1, EntityEquipmentSlot.HEAD, "cap_helmet", 2);
	public static final Item CaptainAmericaChest = new ItemCaptainAmericaArmor(CapMaterial, 1, EntityEquipmentSlot.CHEST, "cap_chestplate", 2);
	public static final Item CaptainAmericaLeggings = new ItemCaptainAmericaArmor(CapMaterial, 2, EntityEquipmentSlot.LEGS, "cap_leggings", 2);
	public static final Item CaptainAmericaBoots = new ItemCaptainAmericaArmor(CapMaterial, 1, EntityEquipmentSlot.FEET, "cap_boots", 2);
		
	public static final Item SupermanChest = new ItemSupermanArmor(KryptonianMaterial, 1, EntityEquipmentSlot.CHEST, "superman_chest", 4);
	public static final Item SupermanLeggings = new ItemSupermanArmor(KryptonianMaterial, 2, EntityEquipmentSlot.LEGS, "superman_leggings", 4);
	public static final Item SupermanBoots = new ItemSupermanArmor(KryptonianMaterial, 1, EntityEquipmentSlot.FEET, "superman_boots", 4);
	
	public static final Item GeneralZodChest = new ItemGeneralZodArmor(KryptonianMaterial, 1, EntityEquipmentSlot.CHEST, "generalzod_chest", 4);
	public static final Item GeneralZodLeggings = new ItemGeneralZodArmor(KryptonianMaterial, 2, EntityEquipmentSlot.LEGS, "generalzod_leggings", 4);
	public static final Item GeneralZodBoots = new ItemGeneralZodArmor(KryptonianMaterial, 1, EntityEquipmentSlot.FEET, "generalzod_boots", 4);
	
	public static final Item ShazamChest = new ItemShazamArmor(ShazamMaterial, 1, EntityEquipmentSlot.CHEST, "shazam_chest", 4);
	public static final Item ShazamLeggings = new ItemShazamArmor(ShazamMaterial, 2, EntityEquipmentSlot.LEGS, "shazam_leggings", 4);
	public static final Item ShazamBoots = new ItemShazamArmor(ShazamMaterial, 1, EntityEquipmentSlot.FEET, "shazam_boots", 4);
	
	public static final Item HulkHead = new ItemHulkArmor(GammaMaterial, 1, EntityEquipmentSlot.HEAD, "hulk_head", 4);
	public static final Item HulkChest = new ItemHulkArmor(GammaMaterial, 1, EntityEquipmentSlot.CHEST, "hulk_chest", 4);
	public static final Item HulkPants = new ItemHulkArmor(GammaMaterial, 2, EntityEquipmentSlot.LEGS, "hulk_legs", 4);
	public static final Item HulkFeet = new ItemHulkArmor(GammaMaterial, 1, EntityEquipmentSlot.FEET, "hulk_feet", 4);
	
	public static final Item ThorChest = new ItemThorArmor(AsgardianMaterial, 1, EntityEquipmentSlot.CHEST, "thor_chestplate", 4);
	public static final Item ThorLeggings = new ItemThorArmor(AsgardianMaterial, 2, EntityEquipmentSlot.LEGS, "thor_leggings", 4);
	public static final Item ThorBoots = new ItemThorArmor(AsgardianMaterial, 1, EntityEquipmentSlot.FEET, "thor_boots", 4);
	
	/*ThanosHelmet = new ItemThanosArmor(ThanosMaterial, 1, EntityEquipmentSlot.HEAD, "Thanos_Helmet");
	ThanosChest = new ItemThanosArmor(ThanosMaterial, 1, EntityEquipmentSlot.CHEST, "Thanos_Chest");
	ThanosLeggings = new ItemThanosArmor(ThanosMaterial, 2, EntityEquipmentSlot.LEGS, "Thanos_Leggings");
	ThanosBoots = new ItemThanosArmor(ThanosMaterial, 1, EntityEquipmentSlot.FEET, "Thanos_Boots");
		

		

	DoctorStrangeRobe = new ItemDoctorStrangeArmor(MagicianSupremeMaterial, 1, EntityEquipmentSlot.CHEST, "DoctorStrange_Robe");
	DoctorStrangeLeggings = new ItemDoctorStrangeArmor(MagicianSupremeMaterial, 1, EntityEquipmentSlot.LEGS, "DoctorStrange_Leggings");
	DoctorStrangeBoots = new ItemDoctorStrangeArmor(MagicianSupremeMaterial, 1, EntityEquipmentSlot.FEET, "DoctorStrange_Boots");
		
	*/
		
	public static final Item IronManMk50Helmet = new ItemIronmanMark50Armor(IronmanMaterial, 1, EntityEquipmentSlot.HEAD, "ironman_helmet", 3);
	public static final Item IronManMk50Chest = new ItemIronmanMark50Armor(IronmanMaterial, 1, EntityEquipmentSlot.CHEST, "ironman_chest", 3);
	public static final Item IronManMk50Legs = new ItemIronmanMark50Armor(IronmanMaterial, 2, EntityEquipmentSlot.LEGS, "ironman_legs", 3);
	public static final Item IronManMk50Boots = new ItemIronmanMark50Armor(IronmanMaterial, 1, EntityEquipmentSlot.FEET, "ironman_boots", 3);
	
	public static final Item LokiHelmet = new ItemLokiArmor(LokiMaterial, 1, EntityEquipmentSlot.HEAD, "loki_helmet", 3);
	public static final Item LokiChest = new ItemLokiArmor(LokiMaterial, 1, EntityEquipmentSlot.CHEST, "loki_chest", 3);
	public static final Item LokiLegs = new ItemLokiArmor(LokiMaterial, 2, EntityEquipmentSlot.LEGS, "loki_legs", 3);
	public static final Item LokiBoots = new ItemLokiArmor(LokiMaterial, 1, EntityEquipmentSlot.FEET, "loki_boots", 3);
		
	//public static final Item WaspHelmet = new ItemWaspArmor(PymMaterial, 1, EntityEquipmentSlot.HEAD, "wasp_helmet", 1);
	//public static final Item WaspChest = new ItemWaspArmor(PymMaterial, 1, EntityEquipmentSlot.CHEST, "wasp_chest", 1);
	//public static final Item WaspLegs = new ItemWaspArmor(PymMaterial, 2, EntityEquipmentSlot.LEGS, "wasp_legs", 1);
	//public static final Item WaspFeet = new ItemWaspArmor(PymMaterial, 1, EntityEquipmentSlot.FEET, "wasp_feet", 1);
	//public static final Item AntmanHelmet = new ItemAntmanArmor(PymMaterial, 1, EntityEquipmentSlot.HEAD, "antman_helmet", 1);
	//public static final Item AntmanChest = new ItemAntmanArmor(PymMaterial, 1, EntityEquipmentSlot.CHEST, "antman_chest", 1);
	//public static final Item AntmanLegs = new ItemAntmanArmor(PymMaterial, 2, EntityEquipmentSlot.LEGS, "antman_legs", 1);
	//public static final Item AntmanFeet = new ItemAntmanArmor(PymMaterial, 1, EntityEquipmentSlot.FEET, "antman_feet", 1);
		
		
	public static final Item IronManArcReactor = new ItemIronmanMark50ArcReactorArmor(IronmanMaterial, 1, EntityEquipmentSlot.CHEST, "ironman_arcreactor", 3);
		
	//ITEMS
	public static Item titanium_ingot = new ItemBase("titanium_ingot", SuperheroesMod.materialscreativeTab);
	public static Item TITANIUMGOLD_INGOT = new ItemBase("titaniumgold_ingot", SuperheroesMod.materialscreativeTab);
	public static Item CIRCUIT_BOARD = new ItemBase("circuit_board", SuperheroesMod.materialscreativeTab);
	public static Item TITANIUM_GOLD_NANOPARTICLES = new ItemBase("titaniumgold_nanoparticles", SuperheroesMod.materialscreativeTab);
	public static Item TITANIUM_GOLD_NANOTECH = new ItemBase("titaniumgold_nanotech", SuperheroesMod.materialscreativeTab);
	
	public static Item KRYPTONIAN_BONE = new ItemBase("kryptonian_bone", SuperheroesMod.materialscreativeTab);
	public static Item DNA_FRAGMENT = new ItemBase("dna_fragment", SuperheroesMod.materialscreativeTab);
	public static Item KRYPTONIAN_DNA = new ItemBase("kryptonian_dna", SuperheroesMod.materialscreativeTab);
	public static Item TITANIUM_GOLD_CARBONFIBER = new ItemBase("titaniumgold_carbonfiber", SuperheroesMod.materialscreativeTab);
	public static Item AMAZONIAN_INGOT = new ItemBase("amazonian_ingot", SuperheroesMod.materialscreativeTab);
	public static Item GOD_ESSENCE = new ItemBase("god_essence", SuperheroesMod.materialscreativeTab);
	
	//public static Item PYM_PARTICLES = new ItemBase("pym_particles");
	//public static Item PYM_COMPOSITE = new ItemBase("pym_composite");
	
	public static Item PISTOL = new ItemGun("gun");
	
	/*public static Item TRICK_ARROW = new ItemTrickArrow("trick_arrow");
	public static Item TRICK_ARROW_EXPLOSIVE = new ItemTrickArrow("trick_arrow_explosive");
	public static Item TRICK_ARROW_ELECTRIC = new ItemTrickArrow("trick_arrow_electric");
	public static Item TRICK_ARROW_SMOKE = new ItemTrickArrow("trick_arrow_smoke");
	public static Item TRICK_ARROW_KRYPTONITE = new ItemTrickArrow("trick_arrow_kryptonite");
	public static Item TRICK_ARROW_TRANQUILIZER = new ItemTrickArrow("trick_arrow_tranquilizer");
	public static Item TRICK_ARROW_FREEZE = new ItemTrickArrow("trick_arrow_freeze");
	public static Item TRICK_ARROW_GRAPPLE = new ItemTrickArrow("trick_arrow_grapple");*/
	
	public static Item SUPERSOLDIER_SERUM = new ItemBase("supersoldier_serum", SuperheroesMod.materialscreativeTab);
	public static Item RADIATION_VIAL = new ItemBase("radiation_vial", SuperheroesMod.materialscreativeTab);
	public static Item IRON_FIBER = new ItemBase("iron_fiber", SuperheroesMod.materialscreativeTab);
	
	public static Item URANIUM_INGOT = new ItemBase("uranium_ingot", SuperheroesMod.materialscreativeTab);
	public static Item SUPERSOLDIER_COMPOSITE = new ItemBase("supersoldier_composite", SuperheroesMod.materialscreativeTab);
	public static Item VIBRANIUM = new ItemBase("vibranium", SuperheroesMod.materialscreativeTab);
	public static Item VIBRANIUM_PLATE = new ItemBase("vibranium_plate", SuperheroesMod.materialscreativeTab);
	public static Item GUN_BASE = new ItemBase("gun_base", SuperheroesMod.materialscreativeTab);
	public static Item QUIVER = new ItemBase("quiver", SuperheroesMod.weaponscreativeTab);
	public static Item LIGHTNING_ESSENCE = new ItemBase("lightning_essence", SuperheroesMod.materialscreativeTab);
	//public static Item WRENCH = new ItemWrench("wrench");
	/*public static Item amazonian_ingot;
	public static Item red_amazonian_ingot;
	public static Item blue_amazonian_ingot;
	public static Item amazonian_steel_ingot;
	public static Item steel_ingot;
	//public static Item stevetrevor_rifle;
	public static Item wonderwoman_bracelet;
	public static Item batman_batarang;
	public static Item batman_batarang_explosive;
	public static Item black_leather;
	public static Item black_diamond;
	public static Item batman_symbol;
	public static Item batman_utilitybelt;
	public static Item batman_smokebomb;
	public static Item chainmail_plate;
	public static Item green_chainmail;
	public static Item aquaman_symbol;
	public static Item wonderwoman_symbol;
	public static Item scrap_metal;
	public static Item red_scrapmetal;
	public static Item flash_symbol;
	public static Item hardened_metal;
	public static Item circuit_board;
	public static Item copper_ingot;
	public static Item cyborg_symbol;
	public static Item batman_spear;
	
	public static Item wonderwoman_lasso;
	public static Item doctorstrange_shields;
	public static Item doctorstrange_eyemagic;
	
	public static Item thanos_gauntlet;
	public static Item infinitystone_space;
	public static Item infinitystone_power;
	public static Item infinitystone_time;
	public static Item infinitystone_soul;
	public static Item infinitystone_reality;
	public static Item infinitystone_mind;
	public static Item disc_shrink;
	public static Item disc_grow;*/
	public static Item wonderwoman_shield = new ItemWonderWomanShield("wonderwoman_shield");
	//public static Item batman_grapplinggun = new ItemBatmanGrapplingGun("batman_grapplinggun");
	public static Item hawkeye_bow = new ItemHawkeyeBow("hawkeye_bow");
	/*	amazonian_ingot = new ItemAmazonianIngot("amazonian_ingot", "amazonian_ingot");
	red_amazonian_ingot = new ItemAmazonianIngot("red_amazonian_ingot", "red_amazonian_ingot").setCreativeTab(SuperheroesMod.creativeTab);
	blue_amazonian_ingot = new ItemAmazonianIngot("blue_amazonian_ingot", "blue_amazonian_ingot").setCreativeTab(SuperheroesMod.creativeTab);
	amazonian_steel_ingot = new ItemAmazonianIngot("amazonian_steel_ingot", "amazonian_steel_ingot").setCreativeTab(SuperheroesMod.creativeTab);
	steel_ingot = new ItemSteelIngot("steel_ingot", "steel_ingot");
	stevetrevor_rifle = new ItemSteveTrevorRifle("stevetrevor_rifle", "stevetrevor_rifle");
	wonderwoman_bracelet = new ItemWonderWomanBracelet("wonderwoman_bracelet", "wonderwoman_bracelet");
	batman_batarang = new ItemBatmanBatarang("batman_batarang", "batman_batarang");
	batman_batarang_explosive = new ItemBatmanBatarangExplosive("batman_batarang_explosive", "batman_batarang_explosive");
	black_leather = new ItemBlackLeather("black_leather", "black_leather");
	black_diamond = new ItemBlackDiamond("black_diamond", "black_diamond");
	batman_symbol = new ItemBatmanSymbol("batman_symbol", "batman_symbol");
	batman_utilitybelt = new ItemBatmanUtilityBelt("batman_utilitybelt", "batman_utilitybelt");
	batman_smokebomb = new ItemBatmanSmokeBomb("batman_smokebomb", "batman_smokebomb");
	chainmail_plate = new ItemChainmail("chainmail_plate", "chainmail_plate");
	green_chainmail = new ItemGreenChainmail("green_chainmail", "green_chainmail");
	aquaman_symbol = new ItemAquamanSymbol("aquaman_symbol", "aquaman_symbol");
	wonderwoman_symbol = new ItemWonderWomanSymbol("wonderwoman_symbol", "wonderwoman_symbol");
	scrap_metal = new ItemScrapMetal("scrap_metal", "scrap_metal");
	red_scrapmetal = new ItemRedScrapMetal("red_scrapmetal", "red_scrapmetal");
	flash_symbol = new ItemFlashSymbol("flash_symbol", "flash_symbol");
	hardened_metal = new ItemHardenedMetal("hardened_metal", "hardened_metal");
	circuit_board = new ItemCircuitBoard("circuit_board", "circuit_board");
	copper_ingot = new ItemCopperIngot("copper_ingot", "copper_ingot");
	cyborg_symbol = new ItemCyborgSymbol("cyborg_symbol", "cyborg_symbol");
	batman_spear = new ItemBatmanSpear("batman_spear", "batman_spear");
	
	wonderwoman_lasso = new ItemWonderWomanLasso("wonderwoman_lasso", "wonderwoman_lasso");
	doctorstrange_shields = new ItemDoctorStrangeShields("doctorstrange_shields", "doctorstrange_shields");
	doctorstrange_eyemagic = new ItemDoctorStrangeEyeMagic("doctorstrange_eyemagic", "doctorstrange_eyemagic");
	batman_grapplinggun = new ItemBatmanGrapplingGun("batman_grapplinggun", "batman_grapplinggun");
	thanos_gauntlet = new ItemThanosGauntlet("thanos_gauntlet", "thanos_gauntlet");
	infinitystone_space = new ItemInfinityStoneSpace("infinitystone_space", "infinitystone_space");
	infinitystone_mind = new ItemInfinityStoneMind("infinitystone_mind", "infinitystone_mind");
	infinitystone_power = new ItemInfinityStonePower("infinitystone_power", "infinitystone_power");
	infinitystone_time = new ItemInfinityStoneTime("infinitystone_time", "infinitystone_time");
	infinitystone_reality = new ItemInfinityStoneReality("infinitystone_reality", "infinitystone_reality");
	infinitystone_soul = new ItemInfinityStoneSoul("infinitystone_soul", "infinitystone_soul");
	disc_shrink = new ItemShrinkDisc("disc_shrink", "disc_shrink");
	disc_grow = new ItemGrowDisc("disc_grow", "disc_grow");*/
	

}


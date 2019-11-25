package barryflash.superheroes.init;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.items.armor.ItemAntmanArmor;
import barryflash.superheroes.items.armor.ItemAquamanArmor;
//import barryflash.superheroes.items.armor.ItemAresArmor;
import barryflash.superheroes.items.armor.ItemBatmanArmor;
import barryflash.superheroes.items.armor.ItemCyborgArmor;
import barryflash.superheroes.items.armor.ItemDoctorStrangeArmor;
import barryflash.superheroes.items.armor.ItemFlashArmor;
import barryflash.superheroes.items.armor.ItemHulkArmor;
import barryflash.superheroes.items.armor.ItemIronmanMark50ArcReactorArmor;
import barryflash.superheroes.items.armor.ItemIronmanMark50Armor;
//import barryflash.superheroes.items.armor.ItemSteveTrevorClothes;
import barryflash.superheroes.items.armor.ItemSupermanArmor;
import barryflash.superheroes.items.armor.ItemThanosArmor;
import barryflash.superheroes.items.armor.ItemThorArmor;
import barryflash.superheroes.items.armor.ItemWaspArmor;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import barryflash.superheroes.util.Utils;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ITickable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.b3d.B3DModel.Texture;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ModArmor{
	
	/*public static ArmorMaterial AmazonianArmorMaterial = EnumHelper.addArmorMaterial("amazonian", Reference.MODID + "WonderWoman", 0, new int[] {2,6,5,2}, 0, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 2.0F);
	public static ArmorMaterial GodArmorMaterial = EnumHelper.addArmorMaterial("god", Reference.MODID + "ModelAresTexture", 0, new int[] {2,6,5,2}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F);
	public static ArmorMaterial UnitedStatesArmy = EnumHelper.addArmorMaterial("USArmy", Reference.MODID + "SteveTrevor", 0, new int[] {2,6,5,2}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F);
	public static ArmorMaterial BatmanMaterial = EnumHelper.addArmorMaterial("BatmanMat", Reference.MODID + "BatmanModel", 0, new int[] {2,6,5,2}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F);
	public static ArmorMaterial AquamanMaterial = EnumHelper.addArmorMaterial("AquamanMat", Reference.MODID + "AquamanModel", 0, new int[] {2,6,5,2}, 0, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 2.5F);
	public static ArmorMaterial CyborgMaterial = EnumHelper.addArmorMaterial("CyborgMat", Reference.MODID + "CyborgModel", 0, new int[] {2,6,5,2}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.5F);
	public static ArmorMaterial FlashMaterial = EnumHelper.addArmorMaterial("FlashMat", Reference.MODID + "FlashModel", 0, new int[] {2,6,5,2}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2.0F);
	public static ArmorMaterial KryptonianMaterial = EnumHelper.addArmorMaterial("KrypMat", Reference.MODID + "KrypModel", 0, new int[] {2,6,5,2}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 3.0F);
	public static ArmorMaterial ThanosMaterial = EnumHelper.addArmorMaterial("ThanosMat", Reference.MODID + "ThanosModel", 0, new int[] {2,6,5,2}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 3.2F);
	public static ArmorMaterial AsgardianMaterial = EnumHelper.addArmorMaterial("AsgMat", Reference.MODID + "AsgModel", 0, new int[] {2,6,5,2}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 3.0F);
	public static ArmorMaterial MagicianSupremeMaterial = EnumHelper.addArmorMaterial("MagSupremeMat", Reference.MODID + "MagSupremeModel", 0, new int[] {2,6,5,2}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F);
	public static ArmorMaterial GammaMaterial = EnumHelper.addArmorMaterial("GammaMat", Reference.MODID + "GammaModel", 0, new int[] {2,6,5,2}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 3.0F);
	public static ArmorMaterial IronmanMaterial = EnumHelper.addArmorMaterial("IronmanMat", Reference.MODID + "IronmanModel", 0, new int[] {2,6,5,2}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.5F);
	public static ArmorMaterial IronmanArcReactorMaterial = EnumHelper.addArmorMaterial("IronmanArcReactorMat", Reference.MODID + "IronmanArcReactorModel", 0, new int[] {2,6,5,2}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static ArmorMaterial PymMaterial = EnumHelper.addArmorMaterial("PymMat", Reference.MODID + "PymModel", 0, new int[] {2,6,5,2}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.1F);
	public static Item WonderWomanTiara;
	public static Item WonderWomanChestplate;
	public static Item WonderWomanSkirt;
	public static Item WonderWomanBoots;
	
	public static Item AresHelmet;
	public static Item AresChestplate;
	public static Item AresLeggings;
	public static Item AresBoots;
	
	public static Item SteveTrevorHoodie;
	public static Item SteveTrevorJacket;
	public static Item SteveTrevorLeggings;
	public static Item SteveTrevorBoots;
	
	public static Item BatmanCowl;
	public static Item BatmanChest;
	public static Item BatmanLeggings;
	public static Item BatmanBoots;
	
	public static Item CyborgHelmet;
	public static Item CyborgChest;
	public static Item CyborgLegs;
	public static Item CyborgBoots;
	
	public static Item AquamanChest;
	public static Item AquamanLeggings;
	public static Item AquamanBoots;
	
	public static Item FlashMask;
	public static Item FlashChest;
	public static Item FlashLeggings;
	public static Item FlashBoots;
	
	public static Item ThanosHelmet;
	public static Item ThanosChest;
	public static Item ThanosLeggings;
	public static Item ThanosBoots;
		
	public static Item ThorChest;
	public static Item ThorLeggings;
	public static Item ThorBoots;
	
	public static Item DoctorStrangeRobe;
	public static Item DoctorStrangeLeggings;
	public static Item DoctorStrangeBoots;
	
	public static Item HulkHead;
	public static Item HulkChest;
	public static Item HulkPants;
	public static Item HulkFeet;

	public static Item SupermanChest;
	public static Item SupermanLeggings;
	public static Item SupermanBoots;
	
	public static Item IronManMk50Helmet;
	public static Item IronManMk50Chest;
	public static Item IronManMk50Legs;
	public static Item IronManMk50Boots;
	
	public static Item IronManArcReactor;
	
	public static Item WaspHelmet;
	public static Item WaspChest;
	public static Item WaspLegs;
	public static Item WaspFeet;
	
	public static Item AntmanHelmet;
	public static Item AntmanChest;
	public static Item AntmanLegs;
	public static Item AntmanFeet; 
	
	public static void init() {
		SteveTrevorHoodie = new ItemSteveTrevorClothes(UnitedStatesArmy, 1, EntityEquipmentSlot.HEAD, "SteveTrevor_Hoodie");
		SteveTrevorJacket = new ItemSteveTrevorClothes(UnitedStatesArmy, 1, EntityEquipmentSlot.CHEST, "SteveTrevor_Jacket");
		SteveTrevorLeggings = new ItemSteveTrevorClothes(UnitedStatesArmy, 2, EntityEquipmentSlot.LEGS, "SteveTrevor_Leggings");
		SteveTrevorBoots = new ItemSteveTrevorClothes(UnitedStatesArmy, 1, EntityEquipmentSlot.FEET, "SteveTrevor_Boots");
		
		WonderWomanTiara = new ItemWonderWomanArmor(AmazonianArmorMaterial, 1, EntityEquipmentSlot.HEAD, "WonderWoman_Tiara");
		WonderWomanChestplate = new ItemWonderWomanArmor(AmazonianArmorMaterial, 1, EntityEquipmentSlot.CHEST, "WonderWoman_Chestplate");
		WonderWomanSkirt = new ItemWonderWomanArmor(AmazonianArmorMaterial, 2, EntityEquipmentSlot.LEGS, "WonderWoman_Skirt");
		WonderWomanBoots = new ItemWonderWomanArmor(AmazonianArmorMaterial, 1, EntityEquipmentSlot.FEET, "WonderWoman_Boots");
		
		AresHelmet = new ItemAresArmor(GodArmorMaterial, 1, EntityEquipmentSlot.HEAD, "Ares_Helmet");
		AresChestplate = new ItemAresArmor(GodArmorMaterial, 1, EntityEquipmentSlot.CHEST, "Ares_Chestplate");
		AresLeggings = new ItemAresArmor(GodArmorMaterial, 2, EntityEquipmentSlot.LEGS, "Ares_Leggings");
		AresBoots = new ItemAresArmor(GodArmorMaterial, 1, EntityEquipmentSlot.FEET, "Ares_Boots");

		
		
		BatmanCowl = new ItemBatmanArmor(BatmanMaterial, 1, EntityEquipmentSlot.HEAD, "Batman_Cowl");
		BatmanChest = new ItemBatmanArmor(BatmanMaterial, 1, EntityEquipmentSlot.CHEST, "Batman_Chest");
		BatmanLeggings = new ItemBatmanArmor(BatmanMaterial, 2, EntityEquipmentSlot.LEGS, "Batman_Leggings");
		BatmanBoots = new ItemBatmanArmor(BatmanMaterial, 1, EntityEquipmentSlot.FEET, "Batman_Boots");
		
		AquamanChest = new ItemAquamanArmor(AquamanMaterial, 1, EntityEquipmentSlot.CHEST, "Aquaman_Chest");
		AquamanLeggings = new ItemAquamanArmor(AquamanMaterial, 2, EntityEquipmentSlot.LEGS, "Aquaman_Leggings");
		AquamanBoots = new ItemAquamanArmor(AquamanMaterial, 1, EntityEquipmentSlot.FEET, "Aquaman_Boots");
		
		CyborgHelmet = new ItemCyborgArmor(CyborgMaterial, 1, EntityEquipmentSlot.HEAD, "Cyborg_Helmet");
		CyborgChest = new ItemCyborgArmor(CyborgMaterial, 1, EntityEquipmentSlot.CHEST, "Cyborg_Chest");
		CyborgLegs = new ItemCyborgArmor(CyborgMaterial, 2, EntityEquipmentSlot.LEGS, "Cyborg_Legs");
		CyborgBoots = new ItemCyborgArmor(CyborgMaterial, 1, EntityEquipmentSlot.FEET, "Cyborg_Boots");
		
		FlashMask = new ItemFlashArmor(FlashMaterial, 1, EntityEquipmentSlot.HEAD, "Flash_Mask");
		FlashChest = new ItemFlashArmor(FlashMaterial, 1, EntityEquipmentSlot.CHEST, "Flash_Chest");
		FlashLeggings = new ItemFlashArmor(FlashMaterial, 2, EntityEquipmentSlot.LEGS, "Flash_Leggings");
		FlashBoots = new ItemFlashArmor(FlashMaterial, 1, EntityEquipmentSlot.FEET, "Flash_Boots");
		
		SupermanChest = new ItemSupermanArmor(KryptonianMaterial, 1, EntityEquipmentSlot.CHEST, "Superman_Chest");
		SupermanLeggings = new ItemSupermanArmor(KryptonianMaterial, 2, EntityEquipmentSlot.LEGS, "Superman_Leggings");
		SupermanBoots = new ItemSupermanArmor(KryptonianMaterial, 1, EntityEquipmentSlot.FEET, "Superman_Boots");
	

		ThanosHelmet = new ItemThanosArmor(ThanosMaterial, 1, EntityEquipmentSlot.HEAD, "Thanos_Helmet");
		ThanosChest = new ItemThanosArmor(ThanosMaterial, 1, EntityEquipmentSlot.CHEST, "Thanos_Chest");
		ThanosLeggings = new ItemThanosArmor(ThanosMaterial, 2, EntityEquipmentSlot.LEGS, "Thanos_Leggings");
		ThanosBoots = new ItemThanosArmor(ThanosMaterial, 1, EntityEquipmentSlot.FEET, "Thanos_Boots");
		
		ThorChest = new ItemThorArmor(AsgardianMaterial, 1, EntityEquipmentSlot.CHEST, "Thor_Chest");
		ThorLeggings = new ItemThorArmor(AsgardianMaterial, 1, EntityEquipmentSlot.LEGS, "Thor_Leggings");
		ThorBoots = new ItemThorArmor(AsgardianMaterial, 1, EntityEquipmentSlot.FEET, "Thor_Boots");
		

		DoctorStrangeRobe = new ItemDoctorStrangeArmor(MagicianSupremeMaterial, 1, EntityEquipmentSlot.CHEST, "DoctorStrange_Robe");
		DoctorStrangeLeggings = new ItemDoctorStrangeArmor(MagicianSupremeMaterial, 1, EntityEquipmentSlot.LEGS, "DoctorStrange_Leggings");
		DoctorStrangeBoots = new ItemDoctorStrangeArmor(MagicianSupremeMaterial, 1, EntityEquipmentSlot.FEET, "DoctorStrange_Boots");
		
		HulkHead = new ItemHulkArmor(GammaMaterial, 1, EntityEquipmentSlot.HEAD, "Hulk_Head");
		HulkChest = new ItemHulkArmor(GammaMaterial, 1, EntityEquipmentSlot.CHEST, "Hulk_Chest");
		HulkPants = new ItemHulkArmor(GammaMaterial, 2, EntityEquipmentSlot.LEGS, "Hulk_Pants");
		HulkFeet = new ItemHulkArmor(GammaMaterial, 1, EntityEquipmentSlot.FEET, "Hulk_Feet");
		
		IronManMk50Helmet = new ItemIronmanMark50Armor(IronmanMaterial, 1, EntityEquipmentSlot.HEAD, "ironman_helmet");
		IronManMk50Chest = new ItemIronmanMark50Armor(IronmanMaterial, 1, EntityEquipmentSlot.CHEST, "ironman_chest");
		IronManMk50Legs = new ItemIronmanMark50Armor(IronmanMaterial, 2, EntityEquipmentSlot.LEGS, "ironman_legs");
		IronManMk50Boots = new ItemIronmanMark50Armor(IronmanMaterial, 1, EntityEquipmentSlot.FEET, "ironman_boots");
		
		WaspHelmet = new ItemWaspArmor(PymMaterial, 1, EntityEquipmentSlot.HEAD, "wasp_helmet");
		WaspChest = new ItemWaspArmor(PymMaterial, 1, EntityEquipmentSlot.CHEST, "wasp_chest");
		WaspLegs = new ItemWaspArmor(PymMaterial, 2, EntityEquipmentSlot.LEGS, "wasp_legs");
		WaspFeet = new ItemWaspArmor(PymMaterial, 1, EntityEquipmentSlot.FEET, "wasp_feet");
		AntmanHelmet = new ItemAntmanArmor(PymMaterial, 1, EntityEquipmentSlot.HEAD, "antman_helmet");
		AntmanChest = new ItemAntmanArmor(PymMaterial, 1, EntityEquipmentSlot.CHEST, "antman_chest");
		AntmanLegs = new ItemAntmanArmor(PymMaterial, 2, EntityEquipmentSlot.LEGS, "antman_legs");
		AntmanFeet = new ItemAntmanArmor(PymMaterial, 1, EntityEquipmentSlot.FEET, "antman_feet");
		
		
		IronManArcReactor = new ItemIronmanMark50ArcReactorArmor(IronmanMaterial, 1, EntityEquipmentSlot.CHEST, "ironman_arcreactor");
	}
	
	public static void register() {
		registerItem(WonderWomanTiara);
		registerItem(WonderWomanChestplate);
		registerItem(WonderWomanSkirt);
		registerItem(WonderWomanBoots);
		
		registerItem(SteveTrevorHoodie);
		registerItem(SteveTrevorJacket);
		registerItem(SteveTrevorLeggings);
		registerItem(SteveTrevorBoots);
		
		registerItem(AresHelmet);
		registerItem(AresChestplate);
		registerItem(AresLeggings);
		registerItem(AresBoots);
		
		
		registerItem(BatmanCowl);
		registerItem(BatmanChest);
		registerItem(BatmanLeggings);
		registerItem(BatmanBoots);
		
		registerItem(AquamanChest);
		registerItem(AquamanLeggings);
		registerItem(AquamanBoots);
		
		registerItem(CyborgHelmet);
		registerItem(CyborgChest);
		registerItem(CyborgLegs);
		registerItem(CyborgBoots);
		
		registerItem(FlashMask);
		registerItem(FlashChest);
		registerItem(FlashLeggings);
		registerItem(FlashBoots);
		
	
		
		registerItem(ThanosHelmet);
		registerItem(ThanosChest);
		registerItem(ThanosLeggings);
		registerItem(ThanosBoots);
		
		registerItem(ThorChest);
		registerItem(ThorLeggings);
		registerItem(ThorBoots);
		
		registerItem(DoctorStrangeRobe);
		registerItem(DoctorStrangeLeggings);
		registerItem(DoctorStrangeBoots);
		
		registerItem(HulkHead);
		registerItem(HulkChest);
		registerItem(HulkPants);
		registerItem(HulkFeet);
		registerItem(SupermanChest);
		registerItem(SupermanLeggings);
		registerItem(SupermanBoots);
		
		registerItem(IronManMk50Helmet);
		registerItem(IronManMk50Chest);
		registerItem(IronManMk50Legs);
		registerItem(IronManMk50Boots);
		registerItem(IronManArcReactor);
		
		registerItem(WaspHelmet);
		registerItem(WaspChest);
		registerItem(WaspLegs);
		registerItem(WaspFeet);
		
		registerItem(AntmanHelmet);
		registerItem(AntmanChest);
		registerItem(AntmanLegs);
		registerItem(AntmanFeet);
	}
	
	public static void registerRenders() {
		registerRender(WonderWomanTiara);
		registerRender(WonderWomanChestplate);
		registerRender(WonderWomanSkirt);
		registerRender(WonderWomanBoots);
		
		registerRender(SteveTrevorHoodie);
		registerRender(SteveTrevorJacket);
		registerRender(SteveTrevorLeggings);
		registerRender(SteveTrevorBoots);
		
		registerRender(AresHelmet);
		registerRender(AresChestplate);
		registerRender(AresLeggings);
		registerRender(AresBoots);
		
		registerRender(BatmanCowl);
		registerRender(BatmanChest);
		registerRender(BatmanLeggings);
		registerRender(BatmanBoots);
		
		registerRender(AquamanChest);
		registerRender(AquamanLeggings);
		registerRender(AquamanBoots);
		
		registerRender(CyborgHelmet);
		registerRender(CyborgChest);
		registerRender(CyborgLegs);
		registerRender(CyborgBoots);
		
		registerRender(FlashMask);
		registerRender(FlashChest);
		registerRender(FlashLeggings);
		registerRender(FlashBoots);
		
	
		
		registerRender(ThanosHelmet);
		registerRender(ThanosChest);
		registerRender(ThanosLeggings);
		registerRender(ThanosBoots);
		
		registerRender(ThorChest);
		registerRender(ThorLeggings);
		registerRender(ThorBoots);
		
		registerRender(DoctorStrangeRobe);
		registerRender(DoctorStrangeLeggings);
		registerRender(DoctorStrangeBoots);
		
		registerRender(HulkHead);
		registerRender(HulkChest);
		registerRender(HulkPants);
		registerRender(HulkFeet);
		
		registerRender(SupermanChest);
		registerRender(SupermanLeggings);
		registerRender(SupermanBoots);
		
		registerRender(IronManMk50Helmet);
		registerRender(IronManMk50Chest);
		registerRender(IronManMk50Legs);
		registerRender(IronManMk50Boots);
		
		registerRender(IronManArcReactor);
		
		registerRender(WaspHelmet);
		registerRender(WaspChest);
		registerRender(WaspLegs);
		registerRender(WaspFeet);
		
		registerRender(AntmanHelmet);
		registerRender(AntmanChest);
		registerRender(AntmanLegs);
		registerRender(AntmanFeet);
	}
	
	public static void registerItem(Item item) {
		item.setCreativeTab(SuperheroesMod.creativeTab);
		GameRegistry.findRegistry(Items.class).register(item);
		Utils.getLogger().info("Registered item: " + item.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Register render for " + item.getUnlocalizedName().substring(5));
	}
		*/
}	
	

	
	
	



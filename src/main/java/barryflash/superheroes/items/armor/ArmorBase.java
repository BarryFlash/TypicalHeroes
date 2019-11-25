package barryflash.superheroes.items.armor;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.client.Keybinding;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.util.ColorHelper;
import barryflash.superheroes.util.IHasModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ArmorBase extends ItemArmor implements IHasModel {
	public static final String uuidT1 = "5686744c-937d-4258-b5f5-0e0cfefe342c";
	public static final String uuid2T1 = "f061dfd6-2416-4d7e-a45a-006097b0218f";
	public static final String uuid3T1 = "bed3688f-b283-405f-b38d-77184f924a18";
	public static final String uuid4T1 = "190d3ed5-c9d3-484c-b683-2ff3ed45c9b3";
	
	public static final String uuidT2 = "e787585e-a168-4cc6-aae5-2a672cc818e3";
	public static final String uuid2T2 = "e03a11e0-cae5-4b5f-bf24-d90338a14094";
	public static final String uuid3T2 = "70de9ddf-a7f4-4737-9d7c-31141d602259";
	public static final String uuid4T2 = "b83ce2bd-f269-4087-b97a-32fe493c04f8";
	
	public static final String uuidT3 = "69f3053b-a41b-49c8-9ca1-8dcd49cea22a";
	public static final String uuid2T3 = "a5a3b48d-e6e7-4780-8dd8-55ed77990884";
	public static final String uuid3T3 = "b9b89a16-7366-4e74-a45f-8908d63a0659";
	public static final String uuid4T3 = "9a92abc4-9cb6-4e0a-9b32-13663cc3f109";
	
	public static final String uuidT4 = "4e4bccff-9d1a-453a-a1b6-a6cb39e07a8d";
	public static final String uuid2T4 = "de149412-c947-4622-8721-b0fbdd242ea7";
	public static final String uuid3T4 = "bcbcbc39-7822-4f36-a96c-1939ec3bd777";
	public static final String uuid4T4 = "09d4e148-f8c3-4a26-ae40-04954a2d2bad";
	
	public static final AttributeModifier healthAttributeModifierTier1 = new AttributeModifier(UUID.fromString(uuidT1), "th:tier1_health", 14, 0).setSaved(true);
	public static final AttributeModifier armorAttributeModifierTier1 = new AttributeModifier(UUID.fromString(uuid2T1), "th:tier1_armor", 35, 0).setSaved(true);
	public static final AttributeModifier damageAttributeModifierTier1 = new AttributeModifier(UUID.fromString(uuid3T1), "th:tier1_damage", 10, 0).setSaved(true);
	public static final AttributeModifier toughnessAttributeModifierTier1 = new AttributeModifier(UUID.fromString(uuid4T1), "th:tier1_toughness", 20, 0).setSaved(true);
	
	public static final AttributeModifier healthAttributeModifierTier2 = new AttributeModifier(UUID.fromString(uuidT2), "th:tier2_health", 16, 0).setSaved(true);
	public static final AttributeModifier armorAttributeModifierTier2 = new AttributeModifier(UUID.fromString(uuid2T2), "th:tier2_armor", 50, 0).setSaved(true);
	public static final AttributeModifier damageAttributeModifierTier2 = new AttributeModifier(UUID.fromString(uuid3T2), "th:tier2_damage", 20, 0).setSaved(true);
	public static final AttributeModifier toughnessAttributeModifierTier2 = new AttributeModifier(UUID.fromString(uuid4T2), "th:tier2_toughness", 30, 0).setSaved(true);
	
	public static final AttributeModifier healthAttributeModifierTier3 = new AttributeModifier(UUID.fromString(uuidT3), "th:tier3_health", 18, 0).setSaved(true);
	public static final AttributeModifier armorAttributeModifierTier3 = new AttributeModifier(UUID.fromString(uuid2T3), "th:tier3_armor", 65, 0).setSaved(true);
	public static final AttributeModifier damageAttributeModifierTier3 = new AttributeModifier(UUID.fromString(uuid3T3), "th:tier3_damage", 30, 0).setSaved(true);
	public static final AttributeModifier toughnessAttributeModifierTier3 = new AttributeModifier(UUID.fromString(uuid4T3), "th:tier3_toughness", 40, 0);
	
	public static final AttributeModifier healthAttributeModifierTier4 = new AttributeModifier(UUID.fromString(uuidT4), "th:tier4_health", 20, 0).setSaved(true);
	public static final AttributeModifier armorAttributeModifierTier4 = new AttributeModifier(UUID.fromString(uuid2T4), "th:tier4_armor", 80, 0).setSaved(true);
	public static final AttributeModifier damageAttributeModifierTier4 = new AttributeModifier(UUID.fromString(uuid3T4), "th:tier4_damage", 40, 0).setSaved(true);
	public static final AttributeModifier toughnessAttributeModifierTier4 = new AttributeModifier(UUID.fromString(uuid4T4), "th:tier4_toughness", 50, 0).setSaved(true);
	private int tier;
	public ArmorBase(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String name, int tier) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(SuperheroesMod.creativeTab);
		ModItems.ITEMS.add(this);
		this.tier = tier;
	}
	public static boolean hasSpeed(EntityPlayer player) {
		if (ItemGeneralZodArmor.isWearingFullSet(player) || ItemFlashArmor.isWearingFlash(player) || ItemShazamArmor.isWearingShazam(player) || ItemSupermanArmor.isWearingFullSet(player, ModItems.SupermanChest, ModItems.SupermanLeggings, ModItems.SupermanBoots) || ItemWonderWomanArmor.isWearingFullSet(player, ModItems.WonderWomanTiara, ModItems.WonderWomanChestplate, ModItems.WonderWomanSkirt, ModItems.WonderWomanBoots)) {
			return true;
		} else {
			return false;
		}
	}
	public static double getRealSpeed(EntityPlayer player) {
		if (ItemGeneralZodArmor.isWearingFullSet(player) || ItemFlashArmor.isWearingFlash(player) || ItemShazamArmor.isWearingShazam(player) || ItemSupermanArmor.isWearingFullSet(player, ModItems.SupermanChest, ModItems.SupermanLeggings, ModItems.SupermanBoots) || ItemWonderWomanArmor.isWearingFullSet(player, ModItems.WonderWomanTiara, ModItems.WonderWomanChestplate, ModItems.WonderWomanSkirt, ModItems.WonderWomanBoots)) {
			return 0.05D;
		} else if (ItemBatmanArmor.isWearingFullSet(player, ModItems.BatmanCowl, ModItems.BatmanChest, ModItems.BatmanLeggings, ModItems.BatmanBoots)) {
			return 0.01D;
		} else {
			return 0D;
		}
		
	}
	public static boolean isWearingTier(EntityPlayer player, int tier) {
			if (tier == 1) {
				if (ItemBlackWidowArmor.isWearingFullSet(player) || ItemHawkeyeArmor.isWearingFullSet(player)) {
					return true;
				} else {
					return false;
				}
			} else if (tier == 2) {
				if (ItemBatmanArmor.isWearingFullSet(player, ModItems.BatmanCowl, ModItems.BatmanChest, ModItems.BatmanLeggings, ModItems.BatmanBoots) || ItemCaptainAmericaArmor.isWearingFullSet(player)) {
					return true;
				} else {
					return false;
				}
			} else if (tier == 3) {
				if (ItemLokiArmor.isWearingFullSet(player) || ItemCyborgArmor.isWearingFullSet(player) || ItemFlashArmor.isWearingFlash(player) || ItemIronmanMark50Armor.isWearingFullSet(player, ModItems.IronManMk50Helmet, ModItems.IronManMk50Chest, ModItems.IronManMk50Legs, ModItems.IronManMk50Boots)) {
					return true;
				} else {
					return false;
				}
			} else if (tier == 4) {
				if (ItemGeneralZodArmor.isWearingFullSet(player) || ItemShazamArmor.isWearingShazam(player) || ItemHulkArmor.isWearingHulk(player) || ItemThorArmor.isWearingFullSet(player) || ItemSupermanArmor.isWearingFullSet(player, ModItems.SupermanChest, ModItems.SupermanLeggings, ModItems.SupermanBoots) || ItemWonderWomanArmor.isWearingFullSet(player, ModItems.WonderWomanTiara, ModItems.WonderWomanChestplate, ModItems.WonderWomanSkirt, ModItems.WonderWomanBoots)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
	}
	public static int getSpeed(Item item) {
		if (item == ModItems.BatmanChest) {
			return 1;
		} else if (item == ModItems.WonderWomanChestplate) {
			return 3;
		} else if (item == ModItems.SupermanChest) {
			return 3;
		} else if (item == ModItems.GeneralZodChest) {
			return 3;
		} else if (item == ModItems.FlashChest) {
			return 4;
		} else if (item == ModItems.CyborgChest) {
			return 1;
		} else if (item == ModItems.ShazamChest) {
			return 3;
		} else if (item == ModItems.IronManMk50Chest) {
			return 1;
		} else if (item == ModItems.CaptainAmericaChest) {
			return 1;
		} else if (item == ModItems.ThorChest) {
			return 1;
		} else if (item == ModItems.LokiChest) {
			return 1;
		} else if (item == ModItems.BlackWidowChest) {
			return 1;
		} else if (item == ModItems.HawkeyeChest) {
			return 1;
		} else if (item == ModItems.HulkChest) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static String getName(Item item) {
		if (item == ModItems.BatmanChest) {
			return "Batman";
		} else if (item == ModItems.WonderWomanChestplate) {
			return "Wonder Woman";
		} else if (item == ModItems.SupermanChest) {
			return "Superman";
		} else if (item == ModItems.FlashChest) {
			return "Flash";
		} else if (item == ModItems.CyborgChest) {
			return "Cyborg";
		} else if (item == ModItems.ShazamChest) {
			return "Shazam";
		} else if (item == ModItems.IronManMk50Chest) {
			return "Iron Man";
		} else if (item == ModItems.IronManArcReactor) {
			return "Iron Man Arc Reactor";
		} else if (item == ModItems.CaptainAmericaChest) {
			return "Captain America";
		} else if (item == ModItems.ThorChest) {
			return "Thor";
		} else if (item == ModItems.BlackWidowChest) {
			return "Black Widow";
		} else if (item == ModItems.HawkeyeChest) {
			return "Hawkeye";
		} else if (item == ModItems.LokiChest) {
			return "Loki";
		} else if (item == ModItems.GeneralZodChest) {
			return "General Zod";
		} else if (item == ModItems.HulkChest) {
			return "Hulk";
		} else {
			return "None";
		}
	}
	public static ArrayList getAbilities(Item item) {
		
		if (item == ModItems.BatmanChest) {
			ArrayList list = new ArrayList();
			ArrayList<String> keyList = new ArrayList<String>();
			ArrayList<String> nameList = new ArrayList<String>();
			ArrayList<String> descList = new ArrayList<String>();
			ArrayList<int[]> posList = new ArrayList<int[]>();
			nameList.add("Scroll Gadgets");
			descList.add("Scroll through Batman's -gadgets. These include a -regular batarang, explosive -batarang, electric batarang, -freeze batarang, and -smoke bomb.");
			keyList.add(Keybinding.Ability5.getDisplayName());
			posList.add(new int[]{1,1});
			list.add(keyList);
			list.add(nameList);
			list.add(descList);
			list.add(posList);
			return list;
		} else if (item == ModItems.WonderWomanChestplate) {
			ArrayList list = new ArrayList();
			ArrayList<String> keyList = new ArrayList<String>();
			ArrayList<String> nameList = new ArrayList<String>();
			ArrayList<String> descList = new ArrayList<String>();
			ArrayList<int[]> posList = new ArrayList<int[]>();
			nameList.add("Leap");
			descList.add("A controlled large leap.");
			keyList.add(Keybinding.Ability5.getDisplayName() + " Space");
			posList.add(new int[]{1,5});
			
			nameList.add("Bracelets");
			descList.add("Block some damage and -reflect projectiles.");
			keyList.add(Keybinding.Ability4.getDisplayName());
			posList.add(new int[]{1,3});
			
			nameList.add("Bracelet Blast");
			descList.add("A large blast from -bracelets that damages -entities nearby.");
			keyList.add(Keybinding.Ability4.getDisplayName() + " Crouch");
			posList.add(new int[]{1,4});
			
			nameList.add("Throw Tiara");
			descList.add("Throw your tiara as -a projectile that damages -entities it touches.");
			keyList.add(Keybinding.Ability3.getDisplayName());
			posList.add(new int[]{1,2});
			
			list.add(keyList);
			list.add(nameList);
			list.add(descList);
			list.add(posList);
			return list;
		} else if (item == ModItems.SupermanChest) {
			ArrayList list = new ArrayList();
			ArrayList<String> keyList = new ArrayList<String>();
			ArrayList<String> nameList = new ArrayList<String>();
			ArrayList<String> descList = new ArrayList<String>();
			ArrayList<int[]> posList = new ArrayList<int[]>();
			nameList.add("Heat Vision");
			descList.add("Fire heat vision from -eyes. Causes fire damage -to entities it touches.");
			keyList.add(Keybinding.Ability5.getDisplayName());
			posList.add(new int[]{2,1});
			
			nameList.add("X-Ray");
			descList.add("Detect and see entities -nearby through blocks.");
			keyList.add(Keybinding.Ability4.getDisplayName());
			posList.add(new int[]{2,2});
			
			nameList.add("Flight");
			descList.add("Enable/Disable flight.");
			keyList.add(Keybinding.flightTakeOff.getDisplayName());
			posList.add(new int[]{4,3});
			
			list.add(keyList);
			list.add(nameList);
			list.add(descList);
			list.add(posList);
			return list;
		} else if (item == ModItems.GeneralZodChest) {
			ArrayList list = new ArrayList();
			ArrayList<String> keyList = new ArrayList<String>();
			ArrayList<String> nameList = new ArrayList<String>();
			ArrayList<String> descList = new ArrayList<String>();
			ArrayList<int[]> posList = new ArrayList<int[]>();
			nameList.add("Heat Vision");
			descList.add("Fire heat vision from -eyes. Causes fire damage -to entities it touches.");
			keyList.add(Keybinding.Ability5.getDisplayName());
			posList.add(new int[]{2,1});
			
			nameList.add("X-Ray");
			descList.add("Detect and see entities -nearby through blocks.");
			keyList.add(Keybinding.Ability4.getDisplayName());
			posList.add(new int[]{2,2});
			
			nameList.add("Flight");
			descList.add("Enable/Disable flight.");
			keyList.add(Keybinding.flightTakeOff.getDisplayName());
			posList.add(new int[]{4,3});
			
			list.add(keyList);
			list.add(nameList);
			list.add(descList);
			list.add(posList);
			return list;
		} else if (item == ModItems.FlashChest) {
			ArrayList list = new ArrayList();
			ArrayList<String> keyList = new ArrayList<String>();
			ArrayList<String> nameList = new ArrayList<String>();
			ArrayList<String> descList = new ArrayList<String>();
			ArrayList<int[]> posList = new ArrayList<int[]>();
			nameList.add("Increase Speed");
			descList.add("Increase your speed. -Speed is from 1 to 6. Speed 4 -and above allows you -to run on water.");
			keyList.add(Keybinding.Ability5.getDisplayName());
			posList.add(new int[]{4,5});
			
			nameList.add("Decrease Speed");
			descList.add("Decrease your speed. -Speed is from 1 to 6.");
			keyList.add(Keybinding.Ability4.getDisplayName());
			posList.add(new int[]{5,1});
			
			nameList.add("Phase");
			descList.add("Enable/Disable phasing. -Allows you to go through blocks -horizontally, not -vertically.");
			keyList.add(Keybinding.Ability3.getDisplayName());
			posList.add(new int[]{4,4});
			
			list.add(keyList);
			list.add(nameList);
			list.add(descList);
			list.add(posList);
			return list;
		} else if (item == ModItems.CyborgChest) {
			ArrayList list = new ArrayList();
			ArrayList<String> keyList = new ArrayList<String>();
			ArrayList<String> nameList = new ArrayList<String>();
			ArrayList<String> descList = new ArrayList<String>();
			ArrayList<int[]> posList = new ArrayList<int[]>();
			nameList.add("Sonar Cannon");
			descList.add("Hold to use Sonar Cannon which does damage and -slows down the target.");
			keyList.add(Keybinding.Ability5.getDisplayName());
			posList.add(new int[]{5,4});
			
			nameList.add("Laser");
			descList.add("Hold to use a laser that deals damage to the target.");
			keyList.add(Keybinding.Ability4.getDisplayName());
			posList.add(new int[]{2,1});
			
			list.add(keyList);
			list.add(nameList);
			list.add(descList);
			list.add(posList);
			return list;
		} else if (item == ModItems.ShazamChest) {
			ArrayList list = new ArrayList();
			ArrayList<String> keyList = new ArrayList<String>();
			ArrayList<String> nameList = new ArrayList<String>();
			ArrayList<String> descList = new ArrayList<String>();
			ArrayList<int[]> posList = new ArrayList<int[]>();
			
			nameList.add("Lighting Beams");
			descList.add("Shoot lightning beams -from arms that does -electric damage to -entities they touch");
			keyList.add(Keybinding.Ability5.getDisplayName());
			posList.add(new int[]{2,4});
			
			
			nameList.add("Transform");
			descList.add("Transform to Shazam -or back to human.");
			keyList.add(Keybinding.Ability2.getDisplayName());
			posList.add(new int[]{2,3});
			
			nameList.add("Flight");
			descList.add("Enable/Disable flight.");
			keyList.add(Keybinding.flightTakeOff.getDisplayName());
			posList.add(new int[]{4,3});
			
			list.add(keyList);
			list.add(nameList);
			list.add(descList);
			list.add(posList);
			return list;
		} else if (item == ModItems.IronManMk50Chest) {
			ArrayList list = new ArrayList();
			ArrayList<String> keyList = new ArrayList<String>();
			ArrayList<String> nameList = new ArrayList<String>();
			ArrayList<String> descList = new ArrayList<String>();
			ArrayList<int[]> posList = new ArrayList<int[]>();
			
			nameList.add("Activate Repulsors");
			descList.add("Activate/Deactivate -repulsors. Shoot -Unibeam with left and -right click while -crouching.");
			keyList.add(Keybinding.Ability5.getDisplayName());
			posList.add(new int[]{3,3});
			
			nameList.add("Scroll Weapons");
			descList.add("Scroll through -weapons. These include -laser cannons, -knockback fists, a -dagger, and missiles.");
			keyList.add(Keybinding.Ability4.getDisplayName());
			posList.add(new int[]{3,4});
			
			/*nameList.add("Shield");
			descList.add("Block some damage -and projectiles.");
			keyList.add(Keybinding.Ability3.getDisplayName());
			posList.add(new int[]{3,5});*/
			
			nameList.add("Scroll Flight Modes");
			descList.add("Scroll through flight -modes. These include -regular, wings, and jet. -They go from slowest -to fastest in that order.");
			keyList.add(Keybinding.Ability7.getDisplayName());
			posList.add(new int[]{4,1});
			
			nameList.add("Transform");
			descList.add("Toggle the suit on or off.");
			keyList.add(Keybinding.Ability2.getDisplayName());
			posList.add(new int[]{4,2});
			
			nameList.add("Flight");
			descList.add("Enable/Disable flight.");
			keyList.add(Keybinding.flightTakeOff.getDisplayName());
			posList.add(new int[]{4,3});
			
			list.add(keyList);
			list.add(nameList);
			list.add(descList);
			list.add(posList);
			return list;
		} else if (item == ModItems.IronManArcReactor) {
			ArrayList list = new ArrayList();
			ArrayList<String> keyList = new ArrayList<String>();
			ArrayList<String> nameList = new ArrayList<String>();
			ArrayList<String> descList = new ArrayList<String>();
			ArrayList<int[]> posList = new ArrayList<int[]>();
			nameList.add("Transform");
			descList.add("Toggle the suit on or off");
			keyList.add(Keybinding.Ability2.getDisplayName());
			posList.add(new int[]{4,2});
			list.add(keyList);
			list.add(nameList);
			list.add(descList);
			list.add(posList);
			return list;
		} else if (item == ModItems.LokiChest) {
			ArrayList list = new ArrayList();
			ArrayList<String> keyList = new ArrayList<String>();
			ArrayList<String> nameList = new ArrayList<String>();
			ArrayList<String> descList = new ArrayList<String>();
			ArrayList<int[]> posList = new ArrayList<int[]>();
			nameList.add("Teleport");
			descList.add("Teleport to position at mouse cursor.");
			keyList.add(Keybinding.Ability5.getDisplayName());
			posList.add(new int[]{6,1});
			
			nameList.add("Invisibility");
			descList.add("Become completely invisible.");
			keyList.add(Keybinding.Ability4.getDisplayName());
			posList.add(new int[]{6,2});
			
			nameList.add("Get Scepter");
			descList.add("Summon the Loki Scepter in your inventory.");
			keyList.add(Keybinding.Ability3.getDisplayName());
			posList.add(new int[]{6,3});
			list.add(keyList);
			list.add(nameList);
			list.add(descList);
			list.add(posList);
			return list;
		} else if (item == ModItems.CaptainAmericaChest) {
			ArrayList list = new ArrayList();
			ArrayList<String> keyList = new ArrayList<String>();
			ArrayList<String> nameList = new ArrayList<String>();
			ArrayList<String> descList = new ArrayList<String>();
			ArrayList<int[]> posList = new ArrayList<int[]>();
			nameList.add("Throw Shield");
			descList.add("Throw the shield as a -projectile that hurts -entities it touches and -returns to you. Requires -Captain America Shield to -be held.");
			keyList.add("Rightclick + Crouching");
			posList.add(new int[]{2,5});
			list.add(keyList);
			list.add(nameList);
			list.add(descList);
			list.add(posList);
			return list;
		} else if (item == ModItems.ThorChest) {
			ArrayList list = new ArrayList();
			ArrayList<String> keyList = new ArrayList<String>();
			ArrayList<String> nameList = new ArrayList<String>();
			ArrayList<String> descList = new ArrayList<String>();
			ArrayList<int[]> posList = new ArrayList<int[]>();
			
			nameList.add("Throw Hammer");
			descList.add("Throw mjolnir as a -projectile that hurts -entities it touches and -returns to you. Requires -Mjolnir to be held.");
			keyList.add("Rightclick + Crouching");
			posList.add(new int[]{3,1});
			
			nameList.add("Lightning Beam");
			descList.add("Shoot lightning beam -from mjolnir. Requires -Mjolnir to be held.");
			keyList.add(Keybinding.Ability5.getDisplayName());
			posList.add(new int[]{3,2});
			
			nameList.add("Get Mjolnir");
			descList.add("Summon the Mjolnir in your inventory.");
			keyList.add(Keybinding.Ability4.getDisplayName());
			posList.add(new int[]{6,4});
			
			nameList.add("Flight");
			descList.add("Enable/Disable flight.");
			keyList.add(Keybinding.flightTakeOff.getDisplayName());
			posList.add(new int[]{4,3});
			list.add(keyList);
			list.add(nameList);
			list.add(descList);
			list.add(posList);
			return list;
		} else if (item == ModItems.BlackWidowChest) {
			ArrayList list = new ArrayList();
			ArrayList<String> keyList = new ArrayList<String>();
			ArrayList<String> nameList = new ArrayList<String>();
			ArrayList<String> descList = new ArrayList<String>();
			ArrayList<int[]> posList = new ArrayList<int[]>();
			nameList.add("Widow's Bite");
			descList.add("Shoot a small blast -that shocks and damages -the entity it touches.");
			keyList.add(Keybinding.Ability5.getDisplayName());
			posList.add(new int[]{5,2});
			
			nameList.add("Sharpshooter (Guns)");
			descList.add("Perfect aim for guns.");
			keyList.add("Passive (None)");
			posList.add(new int[]{5,3});
			list.add(keyList);
			list.add(nameList);
			list.add(descList);
			list.add(posList);
			return list;
		} else if (item == ModItems.HawkeyeChest) {
			ArrayList list = new ArrayList();
			ArrayList<String> keyList = new ArrayList<String>();
			ArrayList<String> nameList = new ArrayList<String>();
			ArrayList<String> descList = new ArrayList<String>();
			ArrayList<int[]> posList = new ArrayList<int[]>();
			nameList.add("Sharpshooter (All)");
			descList.add("Perfect aim for all ranged weapons.");
			keyList.add("Passive (None)");
			posList.add(new int[]{5,3});
			
			list.add(keyList);
			list.add(nameList);
			list.add(descList);
			list.add(posList);
			return list;
		} else if (item == ModItems.HulkChest) {
			ArrayList list = new ArrayList();
			ArrayList<String> keyList = new ArrayList<String>();
			ArrayList<String> nameList = new ArrayList<String>();
			ArrayList<String> descList = new ArrayList<String>();
			ArrayList<int[]> posList = new ArrayList<int[]>();
			
			nameList.add("Leap");
			descList.add("A controlled large leap.");
			keyList.add(Keybinding.Ability5.getDisplayName() + " + Space");
			posList.add(new int[]{1,5});
			
			nameList.add("Hulk Smash");
			descList.add("Large blast that -damages entities nearby.");
			keyList.add(Keybinding.Ability4.getDisplayName());
			posList.add(new int[]{5,5});
			
			list.add(keyList);
			list.add(nameList);
			list.add(descList);
			list.add(posList);
			return list;
		} else {
			ArrayList list = new ArrayList();
			ArrayList<String> keyList = new ArrayList<String>();
			ArrayList<String> nameList = new ArrayList<String>();
			ArrayList<String> descList = new ArrayList<String>();
			ArrayList<int[]> posList = new ArrayList<int[]>();
			nameList.add("None");
			descList.add("None");
			keyList.add("None");
			posList.add(new int[]{0,0});
			list.add(keyList);
			list.add(nameList);
			list.add(descList);
			list.add(posList);
			return list;
		}
	}
	public int getTier() {
		return tier;
	}
	public int getDamage() {
		if (tier == 1) {
			return 10;
		} else if (tier == 2) {
			return 20;
		} else if (tier == 3) {
			return 30;
		} else if (tier == 4) {
			return 40;
		} else {
			return 0;
		}
	}
	public int getArmor() {
		if (tier == 1) {
			return 35;
		} else if (tier == 2) {
			return 50;
		} else if (tier == 3) {
			return 65;
		} else if (tier == 4) {
			return 80;
		} else {
			return 0;
		}
	}
	public int getHP() {
		if (tier == 1) {
			return 14;
		} else if (tier == 2) {
			return 16;
		} else if (tier == 3) {
			return 18;
		} else if (tier == 4) {
			return 20;
		} else {
			return 0;
		}
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		// TODO Auto-generated method stub
		return TextFormatting.GOLD.toString() + TextFormatting.BOLD.toString() + super.getItemStackDisplayName(stack);
	}
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		// TODO Auto-generated method stub
		tooltip.add(ColorHelper.DARK_RED() + ColorHelper.BOLD() + "Tier " + tier);
		if (tier != 0) {
			tooltip.add(ColorHelper.YELLOW() + "Armor: +" + getArmor());
			tooltip.add(ColorHelper.YELLOW() + "HP: +" + getHP());
			tooltip.add(ColorHelper.YELLOW() + "Damage: +" + getDamage());
		}
	}
	@Override
	public void registerModels() {
		// TODO Auto-generated method stub
		SuperheroesMod.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if (this.isWearingTier(player, 2)) {
			PotionEffect potion = new PotionEffect(MobEffects.REGENERATION, 100, 0, false, false);
			if (player.getActivePotionEffect(potion.getPotion()) == null || potion.getDuration() < 100) {
				player.addPotionEffect(potion);
			}
		}
		 else if (this.isWearingTier(player, 3)) {
				PotionEffect potion = new PotionEffect(MobEffects.REGENERATION, 25, 1, false, false);
				if (player.getActivePotionEffect(potion.getPotion()) == null || potion.getDuration() < 25) {
					player.addPotionEffect(potion);
				}
			}
		 else if (this.isWearingTier(player, 4)) {
				PotionEffect potion = new PotionEffect(MobEffects.REGENERATION, 25, 2, false, false);
				if (player.getActivePotionEffect(potion.getPotion()) == null || potion.getDuration() < 25) {
					player.addPotionEffect(potion);
				}
			}
	}

}

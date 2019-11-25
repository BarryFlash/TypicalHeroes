package barryflash.superheroes.items.armor;

import java.util.List;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.capabilities.AntmanProvider;
import barryflash.superheroes.capabilities.IAntman;
import barryflash.superheroes.capabilities.IWasp;
import barryflash.superheroes.capabilities.WaspProvider;
import barryflash.superheroes.client.Keybinding;
import barryflash.superheroes.models.ModelAntman;
import barryflash.superheroes.models.ModelAntman1;
import barryflash.superheroes.models.ModelAntman10;
import barryflash.superheroes.models.ModelAntman11;
import barryflash.superheroes.models.ModelAntman12;
import barryflash.superheroes.models.ModelAntman13;
import barryflash.superheroes.models.ModelAntman14;
import barryflash.superheroes.models.ModelAntman15;
import barryflash.superheroes.models.ModelAntman2;
import barryflash.superheroes.models.ModelAntman3;
import barryflash.superheroes.models.ModelAntman4;
import barryflash.superheroes.models.ModelAntman5;
import barryflash.superheroes.models.ModelAntman6;
import barryflash.superheroes.models.ModelAntman7;
import barryflash.superheroes.models.ModelAntman8;
import barryflash.superheroes.models.ModelAntman9;
import barryflash.superheroes.models.ModelBatman;
import barryflash.superheroes.models.ModelIronManMark50;
import barryflash.superheroes.models.ModelIronManMark50_10;
import barryflash.superheroes.models.ModelIronManMark50_11;
import barryflash.superheroes.models.ModelIronManMark50_12;
import barryflash.superheroes.models.ModelIronManMark50_13;
import barryflash.superheroes.models.ModelIronManMark50_14;
import barryflash.superheroes.models.ModelIronManMark50_15;
import barryflash.superheroes.models.ModelIronManMark50_2;
import barryflash.superheroes.models.ModelIronManMark50_3;
import barryflash.superheroes.models.ModelIronManMark50_4;
import barryflash.superheroes.models.ModelIronManMark50_5;
import barryflash.superheroes.models.ModelIronManMark50_6;
import barryflash.superheroes.models.ModelIronManMark50_7;
import barryflash.superheroes.models.ModelIronManMark50_8;
import barryflash.superheroes.models.ModelIronManMark50_9;
import barryflash.superheroes.models.ModelWonderWoman;
import barryflash.superheroes.util.Helper;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ItemAntmanArmor extends ArmorBase

{
	private static ModelAntman model;
	private static ModelAntman1 model1;
	private static ModelAntman2 model2;
	private static ModelAntman3 model3;
	private static ModelAntman4 model4;
	private static ModelAntman5 model5;
	private static ModelAntman6 model6;
	private static ModelAntman7 model7;
	private static ModelAntman8 model8;
	private static ModelAntman9 model9;
	private static ModelAntman10 model10;
	private static ModelAntman11 model11;
	private static ModelAntman12 model12;
	private static ModelAntman13 model13;
	private static ModelAntman14 model14;
	private static ModelAntman15 model15;

	private boolean once = false;
	
	public ItemAntmanArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn,
			String name, int tier) {
		super(materialIn, renderIndexIn, equipmentSlotIn, name, tier);
		// TODO Auto-generated constructor stub
	}


	
	
	private void effectPlayer(EntityPlayer player, Potion potion, int amplifier)

	{

		if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)

			player.addPotionEffect(new PotionEffect(potion, 19, amplifier, true, false));

	}
	

	

	public static boolean isWearingFullSet(EntityPlayer player, Item AntmanHelmet, Item AntmanChest, Item AntmanLegs, Item AntmanFeet)

	{
		
		return !player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == AntmanHelmet
				
				&& !player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == AntmanChest

				&& !player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == AntmanLegs

				&& !player.getItemStackFromSlot(EntityEquipmentSlot.FEET).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == AntmanFeet;
				

	}
	public static void effectPlayerWithPotion(EntityPlayer player, Potion potion, int amplifier) {
		if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)

			player.addPotionEffect(new PotionEffect(potion, 19, amplifier, true, false));
	}
	

	
	public String getAntmanArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{

		return Reference.MODID + ":textures/models/armor/antman_layer_" + (slot == slot.LEGS ? "2" : "1") + ".png";

	}

	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)

	{

		return getAntmanArmorTexture(stack, entity, slot);

	}
	public void setModel(EntityEquipmentSlot equipmentSlotIn) {
		if (once == false) {
			once = true;
			
		}
	}
	

	@SideOnly(Side.CLIENT)

	public ModelBiped getAntmanArmor(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{
		if (model == null) {
			model = new ModelAntman(Helper.getArmorModelScale(slot));
			model1 = new ModelAntman1(Helper.getArmorModelScale(slot));
			model2 = new ModelAntman2(Helper.getArmorModelScale(slot));
			model3 = new ModelAntman3(Helper.getArmorModelScale(slot));
			model4 = new ModelAntman4(Helper.getArmorModelScale(slot));
			model5 = new ModelAntman5(Helper.getArmorModelScale(slot));
			model6 = new ModelAntman6(Helper.getArmorModelScale(slot));
			model7 = new ModelAntman7(Helper.getArmorModelScale(slot));
			model8 = new ModelAntman8(Helper.getArmorModelScale(slot));
			model9 = new ModelAntman9(Helper.getArmorModelScale(slot));
			model10 = new ModelAntman10(Helper.getArmorModelScale(slot));
			model11 = new ModelAntman11(Helper.getArmorModelScale(slot));
			model12 = new ModelAntman12(Helper.getArmorModelScale(slot));
			model13 = new ModelAntman13(Helper.getArmorModelScale(slot));
			model14 = new ModelAntman14(Helper.getArmorModelScale(slot));
			model15 = new ModelAntman15(Helper.getArmorModelScale(slot));
		}
		IAntman antmancap = entity.getCapability(AntmanProvider.ANTMAN_CAP, null);
		if (antmancap.isHelmetOffAnimationInProgress()) {
		if (antmancap.atcurrentHelmetOffStep(1)) {
			return model1;
		}
		if (antmancap.atcurrentHelmetOffStep(2)) {
			return model2;
		}
		if (antmancap.atcurrentHelmetOffStep(3)) {
			return model3;
		}
		if (antmancap.atcurrentHelmetOffStep(4)) {
			return model4;
		}
		if (antmancap.atcurrentHelmetOffStep(5)) {
			return model5;
		}
		if (antmancap.atcurrentHelmetOffStep(6)) {
			return model6;
		}
		if (antmancap.atcurrentHelmetOffStep(7)) {
			return model7;
		}
		if (antmancap.atcurrentHelmetOffStep(8)) {
			return model8;
		}
		if (antmancap.atcurrentHelmetOffStep(9)) {
			return model9;
		}
		if (antmancap.atcurrentHelmetOffStep(10)) {
			return model10;
		}
		if (antmancap.atcurrentHelmetOffStep(11)) {
			return model11;
		}
		if (antmancap.atcurrentHelmetOffStep(12)) {
			return model12;
		}
		if (antmancap.atcurrentHelmetOffStep(13)) {
			return model13;
		}
		if (antmancap.atcurrentHelmetOffStep(14)) {
			return model14;
		}
		if (antmancap.atcurrentHelmetOffStep(15)) {
			return model15;
		} 
		
		} else {
			if (antmancap.isHelmetAnimationInProgress()) {
				if (antmancap.atcurrentHelmetOnStep(1)) {
					return model15;
				}
				if (antmancap.atcurrentHelmetOnStep(2)) {
					return model14;
				}
				if (antmancap.atcurrentHelmetOnStep(3)) {
					return model13;
				}
				if (antmancap.atcurrentHelmetOnStep(4)) {
					return model12;
				}
				if (antmancap.atcurrentHelmetOnStep(5)) {
					return model11;
				}
				if (antmancap.atcurrentHelmetOnStep(6)) {
					return model10;
				}
				if (antmancap.atcurrentHelmetOnStep(7)) {
					return model9;
				}
				if (antmancap.atcurrentHelmetOnStep(8)) {
					return model8;
				}
				if (antmancap.atcurrentHelmetOnStep(9)) {
					return model7;
				}
				if (antmancap.atcurrentHelmetOnStep(10)) {
					return model6;
				}
				if (antmancap.atcurrentHelmetOnStep(11)) {
					return model5;
				}
				if (antmancap.atcurrentHelmetOnStep(12)) {
					return model4;
				}
				if (antmancap.atcurrentHelmetOnStep(13)) {
					return model3;
				}
				if (antmancap.atcurrentHelmetOnStep(14)) {
					return model2;
				}
				if (antmancap.atcurrentHelmetOnStep(15)) {
					return model1;
				} 
				
				}
			
		}
		if (antmancap.isHelmetOn()) {
			return model;
		} else {
			return model15;
		}
		
		
		

	}

	
	@Override
	@SideOnly(Side.CLIENT)

	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, EntityEquipmentSlot slot, ModelBiped _default)

	{

		ModelBiped armorModel = null;

		if (stack != null )

		{

			armorModel = getAntmanArmor(stack, entityLiving, slot);
			
			if (slot == EntityEquipmentSlot.LEGS && slot != EntityEquipmentSlot.CHEST) {
				armorModel.bipedBody.isHidden = true;

			} else {
				armorModel.bipedBody.isHidden = false;
			}

				armorModel.setModelAttributes(_default);

				

				return armorModel;

			

		}

		return getArmorModel(entityLiving, stack, slot, _default);

	}
	
		
	}


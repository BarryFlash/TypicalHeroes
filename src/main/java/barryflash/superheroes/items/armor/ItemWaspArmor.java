package barryflash.superheroes.items.armor;

import java.util.List;
import java.util.Random;

import org.lwjgl.input.Keyboard;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.abstractarmors.AbstractThor;
import barryflash.superheroes.abstractarmors.AbstractWonderWoman;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IWasp;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.capabilities.WaspProvider;
import barryflash.superheroes.client.Keybinding;
import barryflash.superheroes.init.ModArmor;
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
import barryflash.superheroes.models.ModelSuperman;
import barryflash.superheroes.models.ModelWasp10;
import barryflash.superheroes.models.ModelWasp11;
import barryflash.superheroes.models.ModelWasp12;
import barryflash.superheroes.models.ModelWasp13;
import barryflash.superheroes.models.ModelWasp14;
import barryflash.superheroes.models.ModelWasp15;
import barryflash.superheroes.models.ModelWasp2;
import barryflash.superheroes.models.ModelWasp3;
import barryflash.superheroes.models.ModelWasp4;
import barryflash.superheroes.models.ModelWasp5;
import barryflash.superheroes.models.ModelWasp6;
import barryflash.superheroes.models.ModelWasp7;
import barryflash.superheroes.models.ModelWasp8;
import barryflash.superheroes.models.ModelWasp9;
import barryflash.superheroes.models.ModelThor;
import barryflash.superheroes.models.ModelWasp;
import barryflash.superheroes.models.ModelWasp1;
import barryflash.superheroes.models.ModelWonderWoman;
import barryflash.superheroes.util.Helper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;
import net.minecraft.world.World;


public class ItemWaspArmor extends ArmorBase

{


	private static ModelWasp model;
	private static ModelWasp1 model1;
	private static ModelWasp2 model2;
	private static ModelWasp3 model3;
	private static ModelWasp4 model4;
	private static ModelWasp5 model5;
	private static ModelWasp6 model6;
	private static ModelWasp7 model7;
	private static ModelWasp8 model8;
	private static ModelWasp9 model9;
	private static ModelWasp10 model10;
	private static ModelWasp11 model11;
	private static ModelWasp12 model12;
	private static ModelWasp13 model13;
	private static ModelWasp14 model14;
	private static ModelWasp15 model15;

	private boolean once = false;
	
	public ItemWaspArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String name,
			int tier) {
		super(materialIn, renderIndexIn, equipmentSlotIn, name, tier);
		// TODO Auto-generated constructor stub
	}


	


	public void setModel(EntityEquipmentSlot equipmentSlotIn) {
		if (once == false) {
			once = true;
			
		}
	}
	private void effectPlayer(EntityPlayer player, Potion potion, int amplifier)

	{

		if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)

			player.addPotionEffect(new PotionEffect(potion, 19, amplifier, true, false));

	}

	

	

	public static boolean isWearingFullSet(EntityPlayer player, Item WaspHelmet, Item WaspChest, Item WaspLegs, Item WaspFeet)

	{
		
		return !player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == WaspHelmet
				
				&& !player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == WaspChest

				&& !player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == WaspLegs

				&& !player.getItemStackFromSlot(EntityEquipmentSlot.FEET).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == WaspFeet;
				

	}
	public static void effectPlayerWithPotion(EntityPlayer player, Potion potion, int amplifier) {
		if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)

			player.addPotionEffect(new PotionEffect(potion, 19, amplifier, true, false));
	}
	

	
	public String getWaspArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{

		return Reference.MODID + ":textures/models/armor/wasp_layer_" + (slot == slot.LEGS ? "2" : "1") + ".png";

	}

	

	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)

	{

		return getWaspArmorTexture(stack, entity, slot);

	}

	

	@SideOnly(Side.CLIENT)

	public ModelBiped getWaspArmor(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{
		if (model == null) {
			model = new ModelWasp(Helper.getArmorModelScale(slot));
			model1 = new ModelWasp1(Helper.getArmorModelScale(slot));
			model2 = new ModelWasp2(Helper.getArmorModelScale(slot));
			model3 = new ModelWasp3(Helper.getArmorModelScale(slot));
			model4 = new ModelWasp4(Helper.getArmorModelScale(slot));
			model5 = new ModelWasp5(Helper.getArmorModelScale(slot));
			model6 = new ModelWasp6(Helper.getArmorModelScale(slot));
			model7 = new ModelWasp7(Helper.getArmorModelScale(slot));
			model8 = new ModelWasp8(Helper.getArmorModelScale(slot));
			model9 = new ModelWasp9(Helper.getArmorModelScale(slot));
			model10 = new ModelWasp10(Helper.getArmorModelScale(slot));
			model11 = new ModelWasp11(Helper.getArmorModelScale(slot));
			model12 = new ModelWasp12(Helper.getArmorModelScale(slot));
			model13 = new ModelWasp13(Helper.getArmorModelScale(slot));
			model14 = new ModelWasp14(Helper.getArmorModelScale(slot));
			model15 = new ModelWasp15(Helper.getArmorModelScale(slot));
		}
		IWasp waspcap = entity.getCapability(WaspProvider.WASP_CAP, null);
		if (waspcap.isHelmetOffAnimationInProgress()) {
			if (waspcap.atcurrentHelmetOffStep(1)) {
				return model1;
			}
			if (waspcap.atcurrentHelmetOffStep(2)) {
				return model2;
			}
			if (waspcap.atcurrentHelmetOffStep(3)) {
				return model3;
			}
			if (waspcap.atcurrentHelmetOffStep(4)) {
				return model4;
			}
			if (waspcap.atcurrentHelmetOffStep(5)) {
				return model5;
			}
			if (waspcap.atcurrentHelmetOffStep(6)) {
				return model6;
			}
			if (waspcap.atcurrentHelmetOffStep(7)) {
				return model7;
			}
			if (waspcap.atcurrentHelmetOffStep(8)) {
				return model8;
			}
			if (waspcap.atcurrentHelmetOffStep(9)) {
				return model9;
			}
			if (waspcap.atcurrentHelmetOffStep(10)) {
				return model10;
			}
			if (waspcap.atcurrentHelmetOffStep(11)) {
				return model11;
			}
			if (waspcap.atcurrentHelmetOffStep(12)) {
				return model12;
			}
			if (waspcap.atcurrentHelmetOffStep(13)) {
				return model13;
			}
			if (waspcap.atcurrentHelmetOffStep(14)) {
				return model14;
			}
			if (waspcap.atcurrentHelmetOffStep(15)) {
				return model15;
			} 
			
			} else {
				if (waspcap.isHelmetAnimationInProgress()) {
					if (waspcap.atcurrentHelmetOnStep(1)) {
						return model15;
					}
					if (waspcap.atcurrentHelmetOnStep(2)) {
						return model14;
					}
					if (waspcap.atcurrentHelmetOnStep(3)) {
						return model13;
					}
					if (waspcap.atcurrentHelmetOnStep(4)) {
						return model12;
					}
					if (waspcap.atcurrentHelmetOnStep(5)) {
						return model11;
					}
					if (waspcap.atcurrentHelmetOnStep(6)) {
						return model10;
					}
					if (waspcap.atcurrentHelmetOnStep(7)) {
						return model9;
					}
					if (waspcap.atcurrentHelmetOnStep(8)) {
						return model8;
					}
					if (waspcap.atcurrentHelmetOnStep(9)) {
						return model7;
					}
					if (waspcap.atcurrentHelmetOnStep(10)) {
						return model6;
					}
					if (waspcap.atcurrentHelmetOnStep(11)) {
						return model5;
					}
					if (waspcap.atcurrentHelmetOnStep(12)) {
						return model4;
					}
					if (waspcap.atcurrentHelmetOnStep(13)) {
						return model3;
					}
					if (waspcap.atcurrentHelmetOnStep(14)) {
						return model2;
					}
					if (waspcap.atcurrentHelmetOnStep(15)) {
						return model1;
					} 
					
					}
				
			}
			if (waspcap.isHelmetOn()) {
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

			armorModel = getWaspArmor(stack, entityLiving, slot);
			
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


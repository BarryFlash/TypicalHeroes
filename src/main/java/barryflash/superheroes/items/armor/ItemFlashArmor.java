package barryflash.superheroes.items.armor;

import java.util.List;
import java.util.Random;

import org.lwjgl.input.Keyboard;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.abstractarmors.AbstractBatman;
import barryflash.superheroes.client.Keybinding;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.models.ModelBatman;
import barryflash.superheroes.models.ModelBatmanCape;
import barryflash.superheroes.models.ModelFlash;
import barryflash.superheroes.models.ModelWonderWoman;
import barryflash.superheroes.util.Helper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFlashArmor extends ArmorBase {

	private static ModelFlash model;

	public ItemFlashArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String name,
			int tier) {
		super(materialIn, renderIndexIn, equipmentSlotIn, name, tier);
		// TODO Auto-generated constructor stub
	}


	
			
			
	

	private void effectPlayer(EntityPlayer player, Potion potion, int amplifier)

	{

		if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)

			player.addPotionEffect(new PotionEffect(potion, 19, amplifier, true, false));

	}
	
	 

	

	public static boolean isWearingFlash(EntityPlayer player) {
		return !player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == ModItems.FlashMask
				&& !player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == ModItems.FlashChest
				&& !player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == ModItems.FlashLeggings
				&& !player.getItemStackFromSlot(EntityEquipmentSlot.FEET).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == ModItems.FlashBoots;	
	}



	
	public String getModelFlashTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{

		return Reference.MODID + ":textures/models/armor/flash_layer_" + (slot == slot.LEGS ? "2" : "1") + ".png";

	}

	
	
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)

	{

		return getModelFlashTexture(stack, entity, slot);

	}

	@SideOnly(Side.CLIENT)

	public ModelBiped getModelFlash(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{
		if (model == null) {
			model = new ModelFlash(Helper.getArmorModelScale(slot));
		}
		return model;

	}

	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, EntityEquipmentSlot slot, ModelBiped _default) {
		ModelBiped armorModel = null;
		if (stack != null) {
			armorModel = getModelFlash(stack, entityLiving, slot);
			if (armorModel != null) {
				armorModel.setModelAttributes(_default);
				return armorModel;
			}
		}
		return getArmorModel(entityLiving, stack, slot, _default);
	}
	
	}



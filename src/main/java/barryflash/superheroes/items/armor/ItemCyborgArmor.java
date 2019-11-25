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
import barryflash.superheroes.models.ModelCyborg;
import barryflash.superheroes.models.ModelFlash;
import barryflash.superheroes.models.ModelHero;
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

public class ItemCyborgArmor extends ArmorBase {

	private static ModelCyborg model;

	
	public ItemCyborgArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn,
			String name, int tier) {
		super(materialIn, renderIndexIn, equipmentSlotIn, name, tier);
		// TODO Auto-generated constructor stub
	}
	




			
			
	

	
	

	public static boolean isWearingFullSet(EntityPlayer player)

	{
		
		return !player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == ModItems.CyborgHelmet

				&& !player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == ModItems.CyborgChest

				&& !player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == ModItems.CyborgLegs

				&& !player.getItemStackFromSlot(EntityEquipmentSlot.FEET).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == ModItems.CyborgBoots;
				

	}
	/*public static boolean isWearingAlt(EntityPlayer player)

	{
		
		return !player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == ModItems.BatmanComicsCowl 

				&& !player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == ModItems.BatmanComicsChest

				&& !player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == ModItems.BatmanComicsLeggings

				&& !player.getItemStackFromSlot(EntityEquipmentSlot.FEET).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == ModItems.BatmanComicsBoots;
				

	}*/
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		// TODO Auto-generated method stub
		return Reference.MODID + ":textures/models/armor/cyborg_layer_" + (slot == slot.LEGS ? "2" : "1") + ".png";
	}
	
	@SideOnly(Side.CLIENT)
	public ModelBiped getModelCyborg(ItemStack stack, Entity entity, EntityEquipmentSlot slot) {
		if (model == null) {
			model = new ModelCyborg(Helper.getArmorModelScale(slot));
		}
		return model;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, EntityEquipmentSlot slot, ModelBiped _default) {
		ModelBiped armorModel = null;
		if (stack != null) {
			armorModel = getModelCyborg(stack, entityLiving, slot);
			if (armorModel != null) {
				armorModel.setModelAttributes(_default);
				if (slot == EntityEquipmentSlot.LEGS && slot != EntityEquipmentSlot.CHEST) {
					armorModel.bipedBody.isHidden = true;

				} else {
					armorModel.bipedBody.isHidden = false;
				}
				return armorModel;
			}
		}
		return getArmorModel(entityLiving, stack, slot, _default);
	}
	}



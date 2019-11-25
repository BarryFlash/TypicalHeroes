package barryflash.superheroes.items.armor;

import java.util.Random;

import org.lwjgl.input.Keyboard;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.abstractarmors.AbstractAquaman;
import barryflash.superheroes.abstractarmors.AbstractBatman;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.models.ModelAquaman;
import barryflash.superheroes.models.ModelBatman;
import barryflash.superheroes.models.ModelTest;

import barryflash.superheroes.util.Helper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
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

public class ItemAquamanArmor extends AbstractAquaman{
	public ItemAquamanArmor(ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType, String unlocalizedName)
	{
		super(material, renderIndex, armorType);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
		this.setCreativeTab(SuperheroesMod.creativeTab);
	}
	

			
					
			
			
	

	private void effectPlayer(EntityPlayer player, Potion potion, int amplifier)

	{

		if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)

			player.addPotionEffect(new PotionEffect(potion, 19, amplifier, true, false));

	}
	
	 

	

	public static boolean isWearingFullSet(EntityPlayer player, Item AquamanChest, Item AquamanLeggings, Item AquamanBoots)

	{
		
		return player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == AquamanChest

				&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == AquamanLeggings

				&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == AquamanBoots;
		
				

	}
	public static boolean isNotWearingArmor(EntityPlayer player)

	{
		
		return player.inventory.armorItemInSlot(2) == null

				&& player.inventory.armorItemInSlot(1) == null

				&& player.inventory.armorItemInSlot(0) == null;
				

	}
	
	public static void effectPlayerWithPotion(EntityPlayer player, Potion potion, int amplifier) {
		if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)

			player.addPotionEffect(new PotionEffect(potion, 19, amplifier, true, false));
	}
	
	public String getModelAquamanTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{

		return Reference.MODID + ":textures/models/armor/Aquaman_layer_" + (slot == slot.LEGS ? "2" : "1") + ".png";

	}

	

	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)

	{

		return getModelAquamanTexture(stack, entity, slot);

	}

	

	@SideOnly(Side.CLIENT)

	public ModelBiped getModelAquaman(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{

		return new ModelAquaman(Helper.getArmorModelScale(slot));

	}

	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, EntityEquipmentSlot slot, ModelBiped _default) {
		ModelBiped armorModel = null;
		if (stack != null) {	

			armorModel = new ModelAquaman(Helper.getArmorModelScale(slot));
			if (armorModel != null) {
				armorModel.setModelAttributes(_default);		

				return armorModel;

			}
		}
		return getArmorModel(entityLiving, stack, slot, _default);
	}
		
	}




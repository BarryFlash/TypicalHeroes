package barryflash.superheroes.items.armor;

import java.util.Random;

import org.lwjgl.input.Keyboard;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.abstractarmors.AbstractThor;
import barryflash.superheroes.abstractarmors.AbstractWonderWoman;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.models.ModelCaptainAmerica;
import barryflash.superheroes.models.ModelSuperman;
import barryflash.superheroes.models.ModelThor;
import barryflash.superheroes.models.ModelWonderWoman;
import barryflash.superheroes.util.Helper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
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


public class ItemCaptainAmericaArmor extends ArmorBase

{

	private static ModelCaptainAmerica model;
	
	public ItemCaptainAmericaArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn,
			String name, int tier) {
		super(materialIn, renderIndexIn, equipmentSlotIn, name, tier);
		// TODO Auto-generated constructor stub
	}


	


	private void effectPlayer(EntityPlayer player, Potion potion, int amplifier)

	{

		if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)

			player.addPotionEffect(new PotionEffect(potion, 19, amplifier, true, false));

	}

	public static boolean isWearingFullSet(EntityPlayer player) {
		
		return !player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == ModItems.CaptainAmericaHelmet

				&& !player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == ModItems.CaptainAmericaChest

				&& !player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == ModItems.CaptainAmericaLeggings

				&& !player.getItemStackFromSlot(EntityEquipmentSlot.FEET).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == ModItems.CaptainAmericaBoots;
	}

	

	
	public String getCapArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{

		return Reference.MODID + ":textures/models/armor/cap.png";

	}

	

	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)

	{

		return getCapArmorTexture(stack, entity, slot);

	}

	

	@SideOnly(Side.CLIENT)

	public ModelBiped getCapArmor(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{
		if (model == null) {
			model = new ModelCaptainAmerica(Helper.getArmorModelScale(slot));
		}
		return model;

	}

	
	@Override
	@SideOnly(Side.CLIENT)

	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, EntityEquipmentSlot slot, ModelBiped _default)

	{

		ModelBiped armorModel = null;

		if (stack != null )

		{

			armorModel = getCapArmor(stack, entityLiving, slot);
			
			

				armorModel.setModelAttributes(_default);
				if (slot == EntityEquipmentSlot.LEGS && slot != EntityEquipmentSlot.CHEST) {
					armorModel.bipedBody.isHidden = true;

				} else {
					armorModel.bipedBody.isHidden = false;
				}
				

				return armorModel;

			

		}

		return getArmorModel(entityLiving, stack, slot, _default);

	}
	
		
	}


package barryflash.superheroes.items.armor;

import java.util.Random;

import org.lwjgl.input.Keyboard;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.abstractarmors.AbstractDoctorStrange;
import barryflash.superheroes.abstractarmors.AbstractWonderWoman;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.models.ModelDoctorStrange;
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


public class ItemDoctorStrangeArmor extends AbstractDoctorStrange

{


	public ItemDoctorStrangeArmor(ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType, String unlocalizedName)
		

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

	
	 

	

	public static boolean isWearingFullSet(EntityPlayer player, Item DocRobe, Item DocLeggings, Item DocBoots)

	{
		
		return player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == DocRobe

				&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == DocLeggings

				&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == DocBoots
				;
				

	}
	public static void effectPlayerWithPotion(EntityPlayer player, Potion potion, int amplifier) {
		if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)

			player.addPotionEffect(new PotionEffect(potion, 19, amplifier, true, false));
	}
	

	
	public String getDoctorStrangeArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{

		return Reference.MODID + ":textures/models/armor/DoctorStrange_layer_" + (slot == slot.LEGS ? "2" : "1") + ".png";

	}

	

	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)

	{

		return getDoctorStrangeArmorTexture(stack, entity, slot);

	}

	

	@SideOnly(Side.CLIENT)

	public ModelBiped getDoctorStrangeArmor(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{

		return new ModelDoctorStrange(Helper.getArmorModelScale(slot));

	}

	
	@Override
	@SideOnly(Side.CLIENT)

	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, EntityEquipmentSlot slot, ModelBiped _default)

	{

		ModelBiped armorModel = null;

		if (stack != null)

		{

			armorModel = getDoctorStrangeArmor(stack, entityLiving, slot);

			if (armorModel != null)

			{
				
				armorModel.setModelAttributes(_default);
				
				

				return armorModel;

			}

		}

		return getArmorModel(entityLiving, stack, slot, _default);

	}
	
		
	}


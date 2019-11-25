package barryflash.superheroes.items.armor;

import java.util.List;
import java.util.Random;

import org.lwjgl.input.Keyboard;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.abstractarmors.AbstractWonderWoman;
import barryflash.superheroes.client.Keybinding;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.init.ModItems;
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


public class ItemWonderWomanArmor extends ArmorBase

{
	private static ModelWonderWoman model;
	private boolean once = false;
	public ItemWonderWomanArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn,
			String name, int tier) {
		super(materialIn, renderIndexIn, equipmentSlotIn, name, tier);
		// TODO Auto-generated constructor stub
	}


	
	
	public void setModel(EntityEquipmentSlot equipmentSlotIn) {
		if (once == false) {
			once = true;
			
		}
	}

	@SubscribeEvent
	  public void onLivingUpdateEvent(LivingEvent.LivingUpdateEvent event)
	  {
	    Random rand = new Random();
	    if ((event.getEntity() instanceof EntityPlayer))
	    {
	      EntityPlayer player = (EntityPlayer)event.getEntity();

		if (this.isWearingFullSet(player, ModItems.WonderWomanTiara, ModItems.WonderWomanChestplate, ModItems.WonderWomanSkirt, ModItems.WonderWomanBoots)) {
	          if ((Keyboard.isKeyDown(57)) && (!Minecraft.getMinecraft().ingameGUI.getChatGUI().getChatOpen()) && (Minecraft.getMinecraft().currentScreen == null)) {
	              if (player.motionY > 0.0D) {
	                player.motionY += 0.08499999910593033D;
	              } else {
	                player.motionY += 0.1169999991059303D;
	              }
	            }
	            if ((player.motionY < 0.0D) && (!player.isSneaking()))
	            {
	              player.motionY /= 1.149999976158142D;
	              player.motionY /= 1.149999976158142D;
	              player.motionY /= 1.149999976158142D;
	            }
	            if ((player.moveForward >= 0.01F) && (!player.onGround)) {
	              if ((player.motionX <= 4.0D) || (player.motionZ <= 4.0D))
	              {
	                player.motionX *= 1.059999961853027D;
	                player.motionZ *= 1.059999961853027D;
	              }
	            }
	          }
	        }
	  }
			
			
	
	
	

	private void effectPlayer(EntityPlayer player, Potion potion, int amplifier)

	{

		if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)

			player.addPotionEffect(new PotionEffect(potion, 19, amplifier, true, false));

	}
	
	 

	

	public static boolean isWearingFullSet(EntityPlayer player, Item WonderWomanTiara, Item WonderWomanChestplate, Item WonderWomanSkirt, Item WonderWomanBoots)

	{
		
		return !player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == WonderWomanTiara

				&& !player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == WonderWomanChestplate

				&& !player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == WonderWomanSkirt

				&& !player.getItemStackFromSlot(EntityEquipmentSlot.FEET).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == WonderWomanBoots;
				

	}
	public static void effectPlayerWithPotion(EntityPlayer player, Potion potion, int amplifier) {
		if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)

			player.addPotionEffect(new PotionEffect(potion, 19, amplifier, true, false));
	}
	

	
	public String getWonderWomanArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{

		return Reference.MODID + ":textures/models/armor/wonderwoman_layer_" + (slot == slot.LEGS ? "2" : "1") + ".png";

	}

	

	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)

	{

		return getWonderWomanArmorTexture(stack, entity, slot);

	}

	

	@SideOnly(Side.CLIENT)

	public ModelBiped getWonderWomanArmor(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{
		if (model == null) {
			model = new ModelWonderWoman(Helper.getArmorModelScale(slot));
		}
		return model;

	}

	
	@Override
	@SideOnly(Side.CLIENT)

	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, EntityEquipmentSlot slot, ModelBiped _default)

	{

		ModelBiped armorModel = null;

		if (stack != null)

		{

			armorModel = getWonderWomanArmor(stack, entityLiving, slot);

			if (armorModel != null)

			{

				armorModel.setModelAttributes(_default);

				

				return armorModel;

			}

		}

		return getArmorModel(entityLiving, stack, slot, _default);

	}




	}


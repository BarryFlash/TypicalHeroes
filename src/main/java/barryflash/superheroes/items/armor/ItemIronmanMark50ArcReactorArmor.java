package barryflash.superheroes.items.armor;

import java.util.List;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.abstractarmors.AbstractCyborg;
import barryflash.superheroes.client.Keybinding;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.models.ModelBatman;
import barryflash.superheroes.models.ModelCyborg;
import barryflash.superheroes.models.ModelIronManArcReactor;
import barryflash.superheroes.models.ModelIronManMark50;
import barryflash.superheroes.util.Helper;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemIronmanMark50ArcReactorArmor extends ArmorBase {

	private static ModelIronManArcReactor model;
	
	private boolean once = false;
	

	public ItemIronmanMark50ArcReactorArmor(ArmorMaterial materialIn, int renderIndexIn,
			EntityEquipmentSlot equipmentSlotIn, String name, int tier) {
		super(materialIn, renderIndexIn, equipmentSlotIn, name, tier);
		// TODO Auto-generated constructor stub
	}



	public void setModel(EntityEquipmentSlot equipmentSlotIn) {
		if (once == false) {
			once = true;
			
		}
	}


			
					
			
			
	

	private static void effectPlayer(EntityPlayer player, Potion potion, int amplifier)

	{

		if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)

			player.addPotionEffect(new PotionEffect(potion, 19, amplifier, true, false));

	}
	
	 

	

	public static boolean isWearingReactor(EntityPlayer player, Item ArcReactor)

	{
		
		return  !player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == ArcReactor;
	}

	
	public static void effectPlayerWithPotion(EntityPlayer player, Potion potion, int amplifier) {
		if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)

			player.addPotionEffect(new PotionEffect(potion, 19, amplifier, true, false));
	}
	
	public String getModelArcReactorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{

		return Reference.MODID + ":textures/models/armor/ironman_layer_1.png";

	}

	

	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)

	{

		return getModelArcReactorTexture(stack, entity, slot);

	}

	

	@SideOnly(Side.CLIENT)

	public ModelBiped getModelArcReactor(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{
		if (model == null) {
			model = new ModelIronManArcReactor(Helper.getArmorModelScale(slot));
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

			armorModel = getModelArcReactor(stack, entityLiving, slot);

			if (armorModel != null)

			{

				armorModel.setModelAttributes(_default);

				

				return armorModel;

			}

		}

		return getArmorModel(entityLiving, stack, slot, _default);
		

	}
	
		
	}

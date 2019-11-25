package barryflash.superheroes.items.armor;

import java.util.List;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.capabilities.AntmanProvider;
import barryflash.superheroes.capabilities.IAntman;
import barryflash.superheroes.capabilities.IShazam;
import barryflash.superheroes.capabilities.IWasp;
import barryflash.superheroes.capabilities.ShazamProvider;
import barryflash.superheroes.capabilities.WaspProvider;
import barryflash.superheroes.client.Keybinding;
import barryflash.superheroes.init.ModItems;
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
import barryflash.superheroes.models.ModelShazam;
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


public class ItemShazamArmor extends ArmorBase

{
	private static ModelShazam model;

	
	public ItemShazamArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn,
			String name, int tier) {
		super(materialIn, renderIndexIn, equipmentSlotIn, name, tier);
		// TODO Auto-generated constructor stub
	}


	
	

	private void effectPlayer(EntityPlayer player, Potion potion, int amplifier)

	{

		if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)

			player.addPotionEffect(new PotionEffect(potion, 19, amplifier, true, false));

	}


	

	public static boolean isWearingShazam(EntityPlayer player)

	{
		
		return !player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == ModItems.ShazamChest

				&& !player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == ModItems.ShazamLeggings

				&& !player.getItemStackFromSlot(EntityEquipmentSlot.FEET).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == ModItems.ShazamBoots;
				

	}
	
	

	
	public String getShazamArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{

		return Reference.MODID + ":textures/models/armor/shazam.png";

	}

	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)

	{

		return getShazamArmorTexture(stack, entity, slot);

	}

	

	@SideOnly(Side.CLIENT)

	public ModelBiped getAntmanArmor(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{
		if (model == null) {
			model = new ModelShazam(Helper.getArmorModelScale(slot));
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
			
			armorModel = getAntmanArmor(stack, entityLiving, slot);
			IShazam shazamcap = entityLiving.getCapability(ShazamProvider.SHAZAM_CAP, null);
			
			if (slot == EntityEquipmentSlot.LEGS && slot != EntityEquipmentSlot.CHEST) {
				armorModel.bipedBody.isHidden = true;

			} else {
				armorModel.bipedBody.isHidden = false;
			}
			if (entityLiving instanceof EntityPlayer && !shazamcap.isShazam()) {
				armorModel.bipedBody.isHidden = true;
				armorModel.bipedRightArm.isHidden = true;
				armorModel.bipedRightLeg.isHidden = true;
				armorModel.bipedLeftArm.isHidden = true;
				armorModel.bipedLeftLeg.isHidden = true;
			} else {
				
				armorModel.bipedBody.isHidden = false;
				armorModel.bipedRightArm.isHidden = false;
				armorModel.bipedRightLeg.isHidden = false;
				armorModel.bipedLeftArm.isHidden = false;
				armorModel.bipedLeftLeg.isHidden = false;
			}
				armorModel.setModelAttributes(_default);

				

				return armorModel;

			

		}

		return getArmorModel(entityLiving, stack, slot, _default);

	}
	
		
	}


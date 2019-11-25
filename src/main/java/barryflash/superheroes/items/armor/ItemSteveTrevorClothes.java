package barryflash.superheroes.items.armor;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.models.SteveTrevorModel;

import barryflash.superheroes.util.Helper;
import net.minecraft.client.model.ModelBiped;
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

/*public class ItemSteveTrevorClothes extends ItemArmor

{

	public ItemSteveTrevorClothes(ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType, String unlocalizedName)
		

	{
		super(material, renderIndex, armorType);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
		this.setCreativeTab(SuperheroesMod.creativeTab);
	}
	@Override
	public void onArmorTick(World World, EntityPlayer player, ItemStack itemStack)

	{

		if (this.isWearingFullSet(player, ModArmor.SteveTrevorHoodie, ModArmor.SteveTrevorJacket, ModArmor.SteveTrevorLeggings, ModArmor.SteveTrevorBoots)) {

			    				
			
			
			this.effectPlayer(player, MobEffects.SPEED, 0);
			this.effectPlayer(player, MobEffects.RESISTANCE, 0);
			this.effectPlayer(player, MobEffects.STRENGTH, 0);
			this.effectPlayer(player, MobEffects.SATURATION, 0);
			

			

		
			}
			
	}	
			
						
						
	
	
	

	

	private void effectPlayer(EntityPlayer player, Potion potion, int amplifier)

	{

		if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)

			player.addPotionEffect(new PotionEffect(potion, 19, amplifier, true, false));

	}

	

	public static boolean isWearingFullSet(EntityPlayer player, Item SteveTrevorHoodie, Item SteveTrevorJacket, Item SteveTrevorLeggings, Item SteveTrevorBoots)

	{
		
		return player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == SteveTrevorHoodie
				
				&& player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == SteveTrevorJacket

				&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == SteveTrevorLeggings

				&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == SteveTrevorBoots;

	}

	
	public String getSteveTrevorClothesTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{

		return Reference.MODID + ":textures/models/armor/SteveTrevor_layer_" + (slot == slot.LEGS ? "2" : "1") + ".png";

	}

	

	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)

	{

		return getSteveTrevorClothesTexture(stack, entity, slot);

	}

	

	@SideOnly(Side.CLIENT)

	public ModelBiped getSteveTrevorClothes(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{

		return new SteveTrevorModel(Helper.getArmorModelScale(slot));

	}

	
	@Override
	@SideOnly(Side.CLIENT)

	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, EntityEquipmentSlot slot, ModelBiped _default)

	{

		ModelBiped armorModel = null;

		if (stack != null)

		{

			armorModel = getSteveTrevorClothes(stack, entityLiving, slot);

			if (armorModel != null)

			{

				armorModel.setModelAttributes(_default);

				

				return armorModel;

			}

		}

		return getArmorModel(entityLiving, stack, slot, _default);

	}
	
		
		
	}*/



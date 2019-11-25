package barryflash.superheroes.items.armor;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.models.ModelAres;

import barryflash.superheroes.util.Helper;
import ibxm.Player;
import net.minecraft.block.Block;
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
import net.minecraft.util.Timer;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.entity.player.PlayerEvent;
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


/*public class ItemAresArmor extends ItemArmor

{

	public ItemAresArmor(ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType, String unlocalizedName)
		

	{
		super(material, renderIndex, armorType);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, unlocalizedName));
		this.setCreativeTab(SuperheroesMod.creativeTab);
	}
	@Override
	public void onArmorTick(World World, EntityPlayer player, ItemStack itemStack)

	{

		if (this.isWearingFullSet(player, ModArmor.AresHelmet, ModArmor.AresChestplate, ModArmor.AresLeggings, ModArmor.AresBoots)) {

			    				
			
			
			this.effectPlayer(player, MobEffects.SPEED, 1);
			this.effectPlayer(player, MobEffects.JUMP_BOOST, 1);
			this.effectPlayer(player, MobEffects.REGENERATION, 1);
			this.effectPlayer(player, MobEffects.RESISTANCE, 2);
			this.effectPlayer(player, MobEffects.STRENGTH, 1);
			this.effectPlayer(player, MobEffects.SATURATION, 2);
		}
			if (player.onGround) {
				player.getPosition();
			
				

			}

		
			}
			
		
			
						
						
	
	
	

	

	private void effectPlayer(EntityPlayer player, Potion potion, int amplifier)

	{

		if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)

			player.addPotionEffect(new PotionEffect(potion, 19, amplifier, true, false));

	}

	

	public static boolean isWearingFullSet(EntityPlayer player, Item AresHelmet, Item AresChesplate, Item AresLeggings, Item AresBoots)

	{

		return player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == AresHelmet

				&& player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == AresChesplate

				&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == AresLeggings

				&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == AresBoots;

	}

	
	public String getAresArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{

		return Reference.MODID + ":textures/models/armor/ModelAresTexture_layer_" + (slot == slot.LEGS ? "2" : "1") + ".png";

	}

	

	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)

	{

		return getAresArmorTexture(stack, entity, slot);

	}

	

	@SideOnly(Side.CLIENT)

	public ModelBiped getAresArmor(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{

		return new ModelAres(Helper.getArmorModelScale(slot));

	}

	
	@Override
	@SideOnly(Side.CLIENT)

	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, EntityEquipmentSlot slot, ModelBiped _default)

	{

		ModelBiped armorModel = null;

		if (stack != null)

		{

			armorModel = getAresArmor(stack, entityLiving, slot);

			if (armorModel != null)

			{

				armorModel.setModelAttributes(_default);

				

				return armorModel;

			}

		}

		return getArmorModel(entityLiving, stack, slot, _default);

	}
	
			
		
		
		
		
	
		
		
	}*/


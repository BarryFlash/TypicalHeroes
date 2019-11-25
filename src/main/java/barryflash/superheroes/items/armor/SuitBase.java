package barryflash.superheroes.items.armor;

import barryflash.superheroes.Reference;
import barryflash.superheroes.capabilities.AttributesProvider;
import barryflash.superheroes.capabilities.BatmanEventHandler;
import barryflash.superheroes.capabilities.IAttributes;
import barryflash.superheroes.capabilities.IThor;
import barryflash.superheroes.capabilities.SupermanEventHandler;
import barryflash.superheroes.capabilities.ThorProvider;
import barryflash.superheroes.models.ModelBatman;
import barryflash.superheroes.models.ModelHero;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SuitBase extends ArmorBase {

	private static ModelHero model;
	private String texturePath;
	private int tier;
	private float[] attributes;
	public SuitBase(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String name, ModelHero model, int tier, float[] attributes) {
		super(materialIn, renderIndexIn, equipmentSlotIn, name, tier);
		// TODO Auto-generated constructor stub
		this.model = model;
		this.texturePath = Reference.MODID + ":textures/models/armor/" + name + ".png";
		this.tier = tier;
		this.attributes = attributes;
	}
	
	public int getTier() {
		return this.tier;
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		// TODO Auto-generated method stub
		super.onArmorTick(world, player, itemStack);
		if (player != null) {
			IAttributes attributescap = player.getCapability(AttributesProvider.ATTRIBUTES_CAP, null);
			if (attributescap != null) {
				if (attributes != null) {
					if (attributescap.getHealth() == null || attributescap.getHealth().getAmount() != attributes[0]) {
						attributescap.setHealth(attributes[0]);
					}
					if (attributescap.getDamage() == null || attributescap.getDamage().getAmount() != attributes[1]) {
						attributescap.setDamage(attributes[1]);
					}
					if (attributescap.getSpeed() == null || attributescap.getSpeed().getAmount() != attributes[2]) {
						attributescap.setSpeed(attributes[2]);
					}
					if (attributescap.getArmor() == null || attributescap.getArmor().getAmount() != attributes[3]) {
						attributescap.setArmor(attributes[3]);
					}
				}
				if (!player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).hasModifier(attributescap.getHealth())) {
					player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(attributescap.getHealth());
				}
				if (!player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).hasModifier(attributescap.getDamage())) {
					player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).applyModifier(attributescap.getDamage());
				}
				if (!player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(attributescap.getSpeed())) {
					player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).applyModifier(attributescap.getSpeed());
				}
				if (!player.getEntityAttribute(SharedMonsterAttributes.ARMOR).hasModifier(attributescap.getArmor())) {
					player.getEntityAttribute(SharedMonsterAttributes.ARMOR).applyModifier(attributescap.getArmor());
				}
			}
		}
		
	}
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		// TODO Auto-generated method stub
		return this.texturePath;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, EntityEquipmentSlot slot, ModelBiped _default) {
		ModelBiped armorModel = null;
		if (stack != null) {
			armorModel = this.model;
			if (armorModel != null) {
				armorModel.setModelAttributes(_default);
				return armorModel;
			}
		}
		return getArmorModel(entityLiving, stack, slot, _default);
	}
	
}

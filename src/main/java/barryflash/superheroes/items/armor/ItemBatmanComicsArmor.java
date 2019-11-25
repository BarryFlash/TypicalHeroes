package barryflash.superheroes.items.armor;

import barryflash.superheroes.Reference;
import barryflash.superheroes.models.ModelBatman;
import barryflash.superheroes.models.ModelBatmanComics;
import barryflash.superheroes.util.Helper;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBatmanComicsArmor extends ItemBatmanArmor {

	private static ModelBatmanComics model;
	public ItemBatmanComicsArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn,
			String name) {
		super(materialIn, renderIndexIn, equipmentSlotIn, name, 2);
		// TODO Auto-generated constructor stub
	}
	
	public String getModelBatmanTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{

		return Reference.MODID + ":textures/models/armor/batmancomics_layer_" + (slot == slot.LEGS ? "2" : "1") + ".png";

	}

	

	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)

	{

		return getModelBatmanTexture(stack, entity, slot);

	}
	@SideOnly(Side.CLIENT)

	public ModelBiped getModelBatman(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{
		if (model == null) {
			model = new ModelBatmanComics(Helper.getArmorModelScale(slot));
		}
		return model;

	}

	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, EntityEquipmentSlot slot, ModelBiped _default) {
		ModelBiped armorModel = null;
		if (stack != null)
		{
			armorModel = getModelBatman(stack, entityLiving, slot);
			if (armorModel != null)
			{
				armorModel.setModelAttributes(_default);
				
				return armorModel;
			}
		}
		return getArmorModel(entityLiving, stack, slot, _default);
	}

}

package barryflash.superheroes.items.armor;

import java.util.List;

import org.lwjgl.opengl.GL11;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.client.Keybinding;
import barryflash.superheroes.models.ModelBatman;
import barryflash.superheroes.models.ModelIronManMark50;
import barryflash.superheroes.models.ModelIronManMark50Simpler;
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
import barryflash.superheroes.models.ModelWonderWoman;
import barryflash.superheroes.util.Helper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
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

public class ItemIronmanMark50Armor extends ArmorBase {
	
	private static ModelIronManMark50 model1;
	private static ModelIronManMark50_2 model2;
	private static ModelIronManMark50_3 model3;
	private static ModelIronManMark50_4 model4;
	private static ModelIronManMark50_5 model5;
	private static ModelIronManMark50_6 model6;
	private static ModelIronManMark50_7 model7;
	private static ModelIronManMark50_8 model8;
	private static ModelIronManMark50_9 model9;
	private static ModelIronManMark50_10 model10;
	private static ModelIronManMark50_11 model11;
	private static ModelIronManMark50_12 model12;
	private static ModelIronManMark50_13 model13;
	private static ModelIronManMark50_14 model14;
	private static ModelIronManMark50_15 model15;
	private boolean once = false;
	
	public ItemIronmanMark50Armor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn,
			String name, int tier) {
		super(materialIn, renderIndexIn, equipmentSlotIn, name, tier);
		// TODO Auto-generated constructor stub
	}


	


	public void setModel(EntityEquipmentSlot equipmentSlotIn) {
		if (once == false) {
			once = true;
			
		}
	}


	@Override
	public void renderHelmetOverlay(ItemStack stack, EntityPlayer player, ScaledResolution scaledRes, float partialTicks) {
		
		IIronman ironmancap = player.getCapability(IronmanProvider.IRONMAN_CAP, null);
		if (!ironmancap.isAnimationInProgress()) {
		GlStateManager.disableDepth();
        GlStateManager.depthMask(false);
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.disableAlpha();
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/ironman_hud.png"));
       
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder vertexbuffer = tessellator.getBuffer();
      
      
        vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
       
        vertexbuffer.pos(0.0D, (double)scaledRes.getScaledHeight(), -90.0D).tex(0.0D, 1.0D).endVertex();
        vertexbuffer.pos((double)scaledRes.getScaledWidth(), (double)scaledRes.getScaledHeight(), -90.0D).tex(1.0D, 1.0D).endVertex();
        vertexbuffer.pos((double)scaledRes.getScaledWidth(), 0.0D, -90.0D).tex(1.0D, 0.0D).endVertex();
        vertexbuffer.pos(0.0D, 0.0D, -90.0D).tex(0.0D, 0.0D).endVertex();
        tessellator.draw();
      
        GlStateManager.depthMask(true);
        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}
					
			
			
	

	private static void effectPlayer(EntityPlayer player, Potion potion, int amplifier)

	{

		if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)

			player.addPotionEffect(new PotionEffect(potion, 19, amplifier, true, false));

	}



	

	public static boolean isWearingFullSet(EntityPlayer player, Item IronManHelmet, Item IronManChestplate, Item IronManLegs, Item IronManBoots)

	{
		
		return !player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == IronManHelmet

				&& !player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == IronManChestplate

				&& !player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == IronManLegs

				&& !player.getItemStackFromSlot(EntityEquipmentSlot.FEET).isEmpty() && player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == IronManBoots;
	}
              
	public static boolean isNotWearingArmor(EntityPlayer player)

	{
		
		return player.inventory.armorItemInSlot(3) == null

				&& player.inventory.armorItemInSlot(2) == null

				&& player.inventory.armorItemInSlot(1) == null

				&& player.inventory.armorItemInSlot(0) == null;
				

	}
	
	public static void effectPlayerWithPotion(EntityPlayer player, Potion potion, int amplifier) {
		if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)

			player.addPotionEffect(new PotionEffect(potion, 19, amplifier, true, false));
	}
	public String getModelIronmanTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{
	
		return Reference.MODID + ":textures/models/armor/ironman_layer_" + (slot == slot.LEGS ? "2" : "1") + ".png";

	}

	

	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)

	{

		return getModelIronmanTexture(stack, entity, slot);

	}

	

	@SideOnly(Side.CLIENT)

	public ModelBiped getModelIronman(ItemStack stack, Entity entity, EntityEquipmentSlot slot)

	{
		if (model1 == null) {
			model1 = new ModelIronManMark50(Helper.getArmorModelScale(slot));
			model2 = new ModelIronManMark50_2(Helper.getArmorModelScale(slot));
			model3 = new ModelIronManMark50_3(Helper.getArmorModelScale(slot));
			model4 = new ModelIronManMark50_4(Helper.getArmorModelScale(slot));
			model5 = new ModelIronManMark50_5(Helper.getArmorModelScale(slot));
			model6 = new ModelIronManMark50_6(Helper.getArmorModelScale(slot));
			model7 = new ModelIronManMark50_7(Helper.getArmorModelScale(slot));
			model8 = new ModelIronManMark50_8(Helper.getArmorModelScale(slot));
			model9 = new ModelIronManMark50_9(Helper.getArmorModelScale(slot));
			model10 = new ModelIronManMark50_10(Helper.getArmorModelScale(slot));
			model11 = new ModelIronManMark50_11(Helper.getArmorModelScale(slot));
			model12 = new ModelIronManMark50_12(Helper.getArmorModelScale(slot));
			model13 = new ModelIronManMark50_13(Helper.getArmorModelScale(slot));
			model14 = new ModelIronManMark50_14(Helper.getArmorModelScale(slot));
			model15 = new ModelIronManMark50_15(Helper.getArmorModelScale(slot));
		}
		if (entity instanceof EntityPlayer) {
		IIronman ironmancap = entity.getCapability(IronmanProvider.IRONMAN_CAP, null);
		if (ironmancap.isAnimationInProgress()) {
		if (ironmancap.atcurrentStep(1)) {
			return model2;
		}
		if (ironmancap.atcurrentStep(2)) {
			return model3;
		}
		if (ironmancap.atcurrentStep(3)) {
			return model4;
		}
		if (ironmancap.atcurrentStep(4)) {
			return model5;
		}
		if (ironmancap.atcurrentStep(5)) {
			return model6;
		}
		if (ironmancap.atcurrentStep(6)) {
			return model7;
		}
		if (ironmancap.atcurrentStep(7)) {
			return model8;
		}
		if (ironmancap.atcurrentStep(8)) {
			return model9;
		}
		if (ironmancap.atcurrentStep(9)) {
			return model10;
		}
		if (ironmancap.atcurrentStep(10)) {
			return model11;
		}
		if (ironmancap.atcurrentStep(11)) {
			return model12;
		}
		if (ironmancap.atcurrentStep(12)) {
			return model13;
		}
		if (ironmancap.atcurrentStep(13)) {
			return model14;
		}
		if (ironmancap.atcurrentStep(14)) {
			return model15;
		}
		if (ironmancap.atcurrentStep(15)) {
			return model1;
		} 
		} else if (!ironmancap.isAnimationOff()){
			return model1;
		}
		if (ironmancap.isAnimationOff()) {
			if (ironmancap.atcurrentStep(1)) {
				return model15;
			}
			if (ironmancap.atcurrentStep(2)) {
				return model14;
			}
			if (ironmancap.atcurrentStep(3)) {
				return model13;
			}
			if (ironmancap.atcurrentStep(4)) {
				return model12;
			}
			if (ironmancap.atcurrentStep(5)) {
				return model11;
			}
			if (ironmancap.atcurrentStep(6)) {
				return model10;
			}
			if (ironmancap.atcurrentStep(7)) {
				return model9;
			}
			if (ironmancap.atcurrentStep(8)) {
				return model8;
			}
			if (ironmancap.atcurrentStep(9)) {
				return model7;
			}
			if (ironmancap.atcurrentStep(10)) {
				return model6;
			}
			if (ironmancap.atcurrentStep(11)) {
				return model5;
			}
			if (ironmancap.atcurrentStep(12)) {
				return model4;
			}
			if (ironmancap.atcurrentStep(13)) {
				return model3;
			}
			if (ironmancap.atcurrentStep(14)) {
				return model2;
			}
			
			}
		if (!ironmancap.isAnimationOff()) {
		return model2;
		} else {
			return model2;
		}
		} else if (entity instanceof EntityArmorStand) {
	
			return model1;
		} else {
			return model1;
		}
		}


	@Override
	@SideOnly(Side.CLIENT)

	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, EntityEquipmentSlot slot, ModelBiped _default)

	{

		ModelBiped armorModel = null;

		if (stack != null)

		{

			armorModel = getModelIronman(stack, entityLiving, slot);

			if (armorModel != null)

			{
				if (slot == EntityEquipmentSlot.LEGS && slot != EntityEquipmentSlot.CHEST) {
					armorModel.bipedBody.isHidden = true;

				} else {
					armorModel.bipedBody.isHidden = false;
				}
				armorModel.setModelAttributes(_default);
				
				

				return armorModel;

			}

		}

		return getArmorModel(entityLiving, stack, slot, _default);
		

	}
	
		
	}

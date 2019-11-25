package barryflash.superheroes.client.render.layers;

import com.google.common.collect.Maps;

import barryflash.superheroes.Reference;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IThanos;
import barryflash.superheroes.capabilities.IThor;
import barryflash.superheroes.capabilities.IWasp;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.capabilities.ThanosProvider;
import barryflash.superheroes.capabilities.ThorProvider;
import barryflash.superheroes.capabilities.WaspProvider;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemIronmanMark50Armor;
import barryflash.superheroes.items.armor.ItemThanosArmor;
import barryflash.superheroes.items.armor.ItemThorArmor;
import barryflash.superheroes.items.armor.ItemWaspArmor;
import barryflash.superheroes.models.ModelDoctorStrangeEyeOn;
import barryflash.superheroes.models.ModelHero;
import barryflash.superheroes.models.ModelIronManMark50Cannons;
import barryflash.superheroes.models.ModelIronManMark50GlowParts;
import barryflash.superheroes.models.ModelIronManMark50JetThruster;
import barryflash.superheroes.models.ModelIronManMark50KnockbackFists;
import barryflash.superheroes.models.ModelIronManMark50MissileLauncher;
import barryflash.superheroes.models.ModelIronManMark50Shield;
import barryflash.superheroes.models.ModelIronManMark50Sword;
import barryflash.superheroes.models.ModelIronManMark50Wings;
import barryflash.superheroes.models.ModelThanosGauntlet;
import barryflash.superheroes.models.ModelThanosGauntletStones;
import barryflash.superheroes.models.ModelThorLightning;
import barryflash.superheroes.models.ModelWaspLights;
import barryflash.superheroes.models.ModelWaspTranslucent;
import barryflash.superheroes.models.ModelWaspWings;
import barryflash.superheroes.util.Utils;

import java.util.Map;
import javax.annotation.Nullable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/*
public class RenderWaspLayer implements LayerRenderer<AbstractClientPlayer>
{
  
 
    private final RenderLivingBase<?> renderer;
    
    public RenderWaspLayer(RenderLivingBase<?> rendererIn)
    {
        this.renderer = rendererIn;
       
    }

    public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
    	scale = 0.0625F;
    	
    		if (ItemWaspArmor.isWearingFullSet(entitylivingbaseIn, ModItems.WaspHelmet, ModItems.WaspChest, ModItems.WaspLegs, ModItems.WaspFeet)) {
    			IWasp waspcap = entitylivingbaseIn.getCapability(WaspProvider.WASP_CAP, null);
    				ModelWaspLights modelL = new ModelWaspLights(scale);
    				ModelWaspTranslucent modelT = new ModelWaspTranslucent(scale);
    				ModelWaspWings modelW = new ModelWaspWings(scale);
    				
    				modelL.bipedLeftArmwear.showModel = false;
    				modelL.bipedRightArmwear.showModel = false;
    			
    				modelL.bipedRightLeg.showModel = false;
    				modelL.bipedLeftLeg.showModel = false;
    				modelL.bipedHeadwear.showModel = false;
    				modelL.bipedLeftLegwear.showModel = false;
    				modelL.bipedRightLegwear.showModel = false;
    				modelL.bipedBodyWear.showModel = false;
    				if (waspcap.isHelmetOffAnimationInProgress() || !waspcap.isHelmetOn()) {
    					modelL.head.showModel = false;
    				}
      
        GlStateManager.pushMatrix();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID + ":textures/models/armor/wasp_lights.png"));
		modelL.setModelAttributes(this.renderer.getMainModel());
		modelL.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
		modelL.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);

		GlStateManager.popMatrix();
	
		
		modelT.bipedLeftArmwear.showModel = false;
		modelT.bipedRightArmwear.showModel = false;
		modelT.bipedLeftArm.showModel = false;
		modelT.bipedRightArm.showModel = false;
		modelT.bipedRightLeg.showModel = false;
		modelT.bipedLeftLeg.showModel = false;
		modelT.bipedHeadwear.showModel = false;
		modelT.bipedLeftLegwear.showModel = false;
		modelT.bipedRightLegwear.showModel = false;
		modelT.bipedBodyWear.showModel = false;
		if (waspcap.isSmall()) {
			modelT.bipedBody.showModel = false;
		}
		if (waspcap.isHelmetOffAnimationInProgress() || !waspcap.isHelmetOn()) {
			modelT.head.showModel = false;
		}
	GlStateManager.pushMatrix();
	GlStateManager.enableAlpha();
	GlStateManager.enableBlend();
	GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 20.0F, 220.0F);
	
	Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID + ":textures/models/armor/wasp_trans.png"));
	modelT.setModelAttributes(this.renderer.getMainModel());
	modelT.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
	modelT.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		GlStateManager.disableBlend();
		GlStateManager.disableAlpha();

		GlStateManager.popMatrix();
		if (waspcap.isSmall()) {
		modelW.bipedLeftArmwear.showModel = false;
		modelW.bipedRightArmwear.showModel = false;
		modelW.bipedLeftArm.showModel = false;
		modelW.bipedRightArm.showModel = false;
		modelW.bipedRightLeg.showModel = false;
		modelW.bipedLeftLeg.showModel = false;
		modelW.bipedHeadwear.showModel = false;
		modelW.bipedLeftLegwear.showModel = false;
		modelW.bipedRightLegwear.showModel = false;
		modelW.bipedBodyWear.showModel = false;
	
	GlStateManager.pushMatrix();
	GlStateManager.enableAlpha();
	GlStateManager.enableBlend();
	GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
	
	Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID + ":textures/models/armor/wasp_wings.png"));
	modelW.setModelAttributes(this.renderer.getMainModel());
	modelW.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
	modelW.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	GlStateManager.disableBlend();
	GlStateManager.disableAlpha();

	GlStateManager.popMatrix();
		}
    		}
    		
    	
    }
    public boolean shouldCombineTextures()
    {
        return false;
    }

   


    }
*/
  

  
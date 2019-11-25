package barryflash.superheroes.client.render.layers;

import com.google.common.collect.Maps;

import barryflash.superheroes.Reference;
import barryflash.superheroes.capabilities.AntmanProvider;
import barryflash.superheroes.capabilities.IAntman;
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
import barryflash.superheroes.items.armor.ItemAntmanArmor;
import barryflash.superheroes.items.armor.ItemIronmanMark50Armor;
import barryflash.superheroes.items.armor.ItemThanosArmor;
import barryflash.superheroes.items.armor.ItemThorArmor;
import barryflash.superheroes.items.armor.ItemWaspArmor;
import barryflash.superheroes.models.ModelAntmanLights;
import barryflash.superheroes.models.ModelAntmanTrans;
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
public class RenderAntmanLayer implements LayerRenderer<AbstractClientPlayer>
{
  
 
    private final RenderLivingBase<?> renderer;
    
    public RenderAntmanLayer(RenderLivingBase<?> rendererIn)
    {
        this.renderer = rendererIn;
       
    }

    public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
    	scale = 0.0625F;
    	
    	if (ItemAntmanArmor.isWearingFullSet(entitylivingbaseIn, ModItems.AntmanHelmet, ModItems.AntmanChest, ModItems.AntmanLegs, ModItems.AntmanFeet)) {
    		IAntman antmancap = entitylivingbaseIn.getCapability(AntmanProvider.ANTMAN_CAP, null);
    				ModelAntmanLights modelL = new ModelAntmanLights(scale);
    				ModelAntmanTrans modelT = new ModelAntmanTrans(scale);
    				float brightnessX = OpenGlHelper.lastBrightnessX;
    				float brightnessY = OpenGlHelper.lastBrightnessY;
    				
    				modelL.bipedLeftArmwear.showModel = false;
    				modelL.bipedRightArmwear.showModel = false;
    			
    				modelL.bipedRightLeg.showModel = false;
    				modelL.bipedLeftLeg.showModel = false;
    				modelL.bipedHeadwear.showModel = false;
    				modelL.bipedLeftLegwear.showModel = false;
    				modelL.bipedRightLegwear.showModel = false;
    				modelL.bipedBodyWear.showModel = false;
    				if (antmancap.isHelmetOffAnimationInProgress() || !antmancap.isHelmetOn()) {
    					modelL.head.showModel = false;
    				}
      
        GlStateManager.pushMatrix();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID + ":textures/models/armor/antman_lights.png"));
		modelL.setModelAttributes(this.renderer.getMainModel());
		modelL.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
		modelL.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, brightnessX, brightnessY);
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
		
		if (antmancap.isHelmetOffAnimationInProgress() || !antmancap.isHelmetOn()) {
			modelT.head.showModel = false;
		}
	GlStateManager.pushMatrix();
	GlStateManager.enableAlpha();
	GlStateManager.enableBlend();
	GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 180.0F, 180.0F);
	
	Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID + ":textures/models/armor/antman_trans.png"));
	modelT.setModelAttributes(this.renderer.getMainModel());
	modelT.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
	modelT.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		GlStateManager.disableBlend();
		GlStateManager.disableAlpha();
		
		GlStateManager.popMatrix();
		
    		}
    		
    	
    }
    public boolean shouldCombineTextures()
    {
        return false;
    }

   


    }
*/
  

  
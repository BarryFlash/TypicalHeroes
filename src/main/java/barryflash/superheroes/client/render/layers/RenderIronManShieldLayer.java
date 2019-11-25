package barryflash.superheroes.client.render.layers;

import com.google.common.collect.Maps;

import barryflash.superheroes.Reference;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemIronmanMark50Armor;
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
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class RenderIronManShieldLayer implements LayerRenderer<AbstractClientPlayer>
{
  
 
    private final RenderLivingBase<?> renderer;
    
    public RenderIronManShieldLayer(RenderLivingBase<?> rendererIn)
    {
        this.renderer = rendererIn;
       
    }

    public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
    	scale = 0.0625F;
    	if (ItemIronmanMark50Armor.isWearingFullSet(entitylivingbaseIn, ModItems.IronManMk50Helmet, ModItems.IronManMk50Chest, ModItems.IronManMk50Legs, ModItems.IronManMk50Boots)) {
    		IIronman ironmancap = entitylivingbaseIn.getCapability(IronmanProvider.IRONMAN_CAP, null);
    		if (!ironmancap.isAnimationInProgress()) {
    			if (ironmancap.isShieldActivated()) {
    				ModelIronManMark50Shield model = new ModelIronManMark50Shield(scale);
        
        model.bipedLeftArmwear.showModel = false;
        model.bipedRightArmwear.showModel = false;
        model.bipedBody.showModel = false;
        model.bipedHead.showModel = false;
        model.bipedRightLeg.showModel = false;
        model.bipedLeftLeg.showModel = false;
        model.bipedHeadwear.showModel = false;
        model.bipedLeftLegwear.showModel = false;
        model.bipedRightLegwear.showModel = false;
        model.bipedBodyWear.showModel = false;
        
        GlStateManager.pushMatrix();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID + ":textures/models/armor/ironman_layer_1.png"));
		model.setModelAttributes(this.renderer.getMainModel());
        model.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
		model.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);

		GlStateManager.popMatrix();
    			}
    	if (ironmancap.areCannonsActivated()) {
			ModelIronManMark50Cannons model = new ModelIronManMark50Cannons(scale);
	        
	        model.bipedLeftArmwear.showModel = false;
	        model.bipedRightArmwear.showModel = false;
	        model.bipedHead.showModel = false;
	        model.bipedRightLeg.showModel = false;
	        model.bipedLeftLeg.showModel = false;
	        model.bipedHeadwear.showModel = false;
	        model.bipedLeftLegwear.showModel = false;
	        model.bipedRightLegwear.showModel = false;
	        model.bipedBodyWear.showModel = false;
	        
	        GlStateManager.pushMatrix();
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID + ":textures/models/armor/IronMan_layer_1.png"));
			model.setModelAttributes(this.renderer.getMainModel());
	        model.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
			model.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
			
			GlStateManager.popMatrix();
    	}
    
    	if (ironmancap.isJetThrusterActivated()) {
    		ModelIronManMark50JetThruster model = new ModelIronManMark50JetThruster(scale);
	        
	        model.bipedLeftArmwear.showModel = false;
	        model.bipedRightArmwear.showModel = false;
	        model.bipedHead.showModel = false;
	        model.bipedRightLeg.showModel = false;
	        model.bipedLeftLeg.showModel = false;
	        model.bipedHeadwear.showModel = false;
	        model.bipedLeftLegwear.showModel = false;
	        model.bipedRightLegwear.showModel = false;
	        model.bipedBodyWear.showModel = false;
	        if (entitylivingbaseIn.isSneaking()) {
	        	model.bipedBody.showModel = false;
	        } else {
	        	model.bipedBody.showModel = true;
	        }
	        GlStateManager.pushMatrix();
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID + ":textures/models/armor/IronMan_layer_1.png"));
			model.setModelAttributes(this.renderer.getMainModel());
	        model.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
			model.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
			GlStateManager.popMatrix();
    	}
    	if (ironmancap.areWingsActivated()) {
    		ModelIronManMark50Wings model = new ModelIronManMark50Wings(scale);
	        
	        model.bipedLeftArmwear.showModel = false;
	        model.bipedRightArmwear.showModel = false;
	        model.bipedHead.showModel = false;
	        model.bipedRightLeg.showModel = false;
	        model.bipedLeftLeg.showModel = false;
	        model.bipedHeadwear.showModel = false;
	        model.bipedLeftLegwear.showModel = false;
	        model.bipedRightLegwear.showModel = false;
	        model.bipedBodyWear.showModel = false;
	        
	        GlStateManager.pushMatrix();
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID + ":textures/models/armor/IronMan_layer_1.png"));
			model.setModelAttributes(this.renderer.getMainModel());
	        model.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
			model.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
			GlStateManager.popMatrix();
    	}
    	if (ironmancap.areKnockbackFistsActivated()) {
    		ModelIronManMark50KnockbackFists model = new ModelIronManMark50KnockbackFists(scale);
	        
	        model.bipedLeftArmwear.showModel = false;
	        model.bipedRightArmwear.showModel = false;
	        model.bipedHead.showModel = false;
	        model.bipedRightLeg.showModel = false;
	        model.bipedLeftLeg.showModel = false;
	        model.bipedHeadwear.showModel = false;
	        model.bipedLeftLegwear.showModel = false;
	        model.bipedRightLegwear.showModel = false;
	        model.bipedBodyWear.showModel = false;
	        model.bipedBody.showModel = false;
	        GlStateManager.pushMatrix();
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID + ":textures/models/armor/IronMan_layer_1.png"));
			model.setModelAttributes(this.renderer.getMainModel());
	        model.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
			model.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
			GlStateManager.popMatrix();
    	}
    	if (ironmancap.isSwordActivated() && !ironmancap.swordCooldown()) {
    		ModelIronManMark50Sword model = new ModelIronManMark50Sword(scale);
	        
	        model.bipedLeftArmwear.showModel = false;
	        model.bipedRightArmwear.showModel = false;
	        model.bipedHead.showModel = false;
	        model.bipedRightLeg.showModel = false;
	        model.bipedLeftLeg.showModel = false;
	        model.bipedHeadwear.showModel = false;
	        model.bipedLeftLegwear.showModel = false;
	        model.bipedRightLegwear.showModel = false;
	        model.bipedBodyWear.showModel = false;
	        model.bipedBody.showModel = false;
	        
	        GlStateManager.pushMatrix();
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID + ":textures/models/armor/IronMan_layer_1.png"));
			model.setModelAttributes(this.renderer.getMainModel());
	        model.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
			model.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
			GlStateManager.popMatrix();
    	}
    	if (ironmancap.areMissilesActivated()) {
    		ModelIronManMark50MissileLauncher model = new ModelIronManMark50MissileLauncher(scale);
	        
	        model.bipedLeftArmwear.showModel = false;
	        model.bipedRightArmwear.showModel = false;
	        model.bipedHead.showModel = false;
	        model.bipedRightLeg.showModel = false;
	        model.bipedLeftLeg.showModel = false;
	        model.bipedHeadwear.showModel = false;
	        model.bipedLeftLegwear.showModel = false;
	        model.bipedRightLegwear.showModel = false;
	        model.bipedBodyWear.showModel = false;
	        model.bipedBody.showModel = false;
	        
	        GlStateManager.pushMatrix();
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID + ":textures/models/armor/IronMan_layer_1.png"));
			model.setModelAttributes(this.renderer.getMainModel());
	        model.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
			model.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
			GlStateManager.popMatrix();
    	}
    	
    		}
    }
    }
    public boolean shouldCombineTextures()
    {
        return false;
    }

   


    }

  

  
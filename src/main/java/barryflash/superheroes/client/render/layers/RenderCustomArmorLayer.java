package barryflash.superheroes.client.render.layers;

import com.google.common.collect.Maps;

import barryflash.superheroes.Reference;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemIronmanMark50Armor;
import barryflash.superheroes.models.ModelDoctorStrangeEyeOn;
import barryflash.superheroes.models.ModelHero;
import barryflash.superheroes.models.ModelIronManMark50GlowParts;
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


public class RenderCustomArmorLayer implements LayerRenderer<AbstractClientPlayer>
{
  
 
    private final RenderLivingBase<?> renderer;
    
    public RenderCustomArmorLayer(RenderLivingBase<?> rendererIn)
    {
        this.renderer = rendererIn;
       
    }

    public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
    	scale = 0.0625F;
    	if (ItemIronmanMark50Armor.isWearingFullSet(entitylivingbaseIn, ModItems.IronManMk50Helmet, ModItems.IronManMk50Chest, ModItems.IronManMk50Legs, ModItems.IronManMk50Boots)) {
    		IIronman ironmancap = entitylivingbaseIn.getCapability(IronmanProvider.IRONMAN_CAP, null);
    		if (!ironmancap.isAnimationInProgress() && !ironmancap.isAnimationOff()) {
    			
    			ModelIronManMark50GlowParts model = new ModelIronManMark50GlowParts(scale);
    		
        model.bipedLeftArmwear.showModel = false;
        model.bipedRightArmwear.showModel = false;
        model.shield_39.showModel = false;
        model.shield_40.showModel = false;
        if (ironmancap.isShieldActivated()) {
        	model.shield_39.showModel = true;
            model.shield_40.showModel = true;
        }
        
        GlStateManager.pushMatrix();
		GlStateManager.color(1.0F, 1.0F, 1.3F, 1.0F);
		if (ironmancap.isIronmanDisabled()) {
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 0.0F, 0.0F);
		} else {
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
		}
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID + ":textures/models/armor/ironman_glow.png"));
		model.setModelAttributes(this.renderer.getMainModel());
        model.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
		model.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		
		GlStateManager.popMatrix();
    		}
    }
    }
    public boolean shouldCombineTextures()
    {
        return false;
    }

   


    }

  

  
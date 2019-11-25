package barryflash.superheroes.client.render.layers;

import com.google.common.collect.Maps;

import barryflash.superheroes.Reference;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IThanos;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.capabilities.ThanosProvider;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemIronmanMark50Armor;
import barryflash.superheroes.items.armor.ItemThanosArmor;
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


public class RenderThanosGauntletLayer implements LayerRenderer<AbstractClientPlayer>
{
  
 
    private final RenderLivingBase<?> renderer;
    
    public RenderThanosGauntletLayer(RenderLivingBase<?> rendererIn)
    {
        this.renderer = rendererIn;
       
    }

    public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
    	/*scale = 0.0625F;
    	if (ItemThanosArmor.isWearingFullSet(entitylivingbaseIn, ModArmor.ThanosHelmet, ModArmor.ThanosChest, ModArmor.ThanosLeggings, ModArmor.ThanosBoots)) {
    		IThanos thanoscap = entitylivingbaseIn.getCapability(ThanosProvider.THANOS_CAP, null);
    			if (entitylivingbaseIn.inventory.getCurrentItem() != null) {
    			if (entitylivingbaseIn.inventory.getCurrentItem().getItem() == ModItems.thanos_gauntlet) {
    				ModelThanosGauntlet model = new ModelThanosGauntlet(scale);
        
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

		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID + ":textures/models/armor/Thanos_layer_1.png"));
		model.setModelAttributes(this.renderer.getMainModel());
        model.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
		model.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		GlStateManager.popMatrix();
			ModelThanosGauntletStones modelStones = new ModelThanosGauntletStones(scale);
        
			modelStones.bipedLeftArmwear.showModel = false;
			modelStones.bipedRightArmwear.showModel = false;
			modelStones.bipedBody.showModel = false;
			modelStones.bipedHead.showModel = false;
			modelStones.bipedRightLeg.showModel = false;
			modelStones.bipedLeftLeg.showModel = false;
			modelStones.bipedHeadwear.showModel = false;
			modelStones.bipedLeftLegwear.showModel = false;
			modelStones.bipedRightLegwear.showModel = false;
			modelStones.bipedBodyWear.showModel = false;
			modelStones.rightarm_mind.showModel = false;
			modelStones.rightarm_soul.showModel = false;
			modelStones.rightarm_time.showModel = false;
			modelStones.rightarm_space.showModel = false;
			modelStones.rightarm_reality.showModel = false;
			modelStones.rightarm_power.showModel = false;
			if (thanoscap.isUsingMindStone()) {
				modelStones.rightarm_mind.showModel = true;
			}
			if (thanoscap.isUsingSoulStone()) {
				modelStones.rightarm_soul.showModel = true;
			}
			if (thanoscap.isUsingTimeStone()) {
				modelStones.rightarm_time.showModel = true;
			}
			if (thanoscap.isUsingSpaceStone()) {
				modelStones.rightarm_space.showModel = true;
			}
			if (thanoscap.isUsingRealityStone()) {
				modelStones.rightarm_reality.showModel = true;
			}
			if (thanoscap.isUsingPowerStone()) {
				modelStones.rightarm_power.showModel = true;
			}
			
        
        GlStateManager.pushMatrix();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID + ":textures/models/armor/Thanos_layer_1.png"));
		modelStones.setModelAttributes(this.renderer.getMainModel());
		modelStones.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
		modelStones.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		GlStateManager.popMatrix();
    		}	
    			}
    	
    	}*/
    }
    public boolean shouldCombineTextures()
    {
        return false;
    }

   


    }

  

  
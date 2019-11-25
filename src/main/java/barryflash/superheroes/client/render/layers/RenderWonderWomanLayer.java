package barryflash.superheroes.client.render.layers;

import com.google.common.collect.Maps;

import barryflash.superheroes.Reference;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IThanos;
import barryflash.superheroes.capabilities.IThor;
import barryflash.superheroes.capabilities.IWonderWoman;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.capabilities.ThanosProvider;
import barryflash.superheroes.capabilities.ThorProvider;
import barryflash.superheroes.capabilities.WonderWomanProvider;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemIronmanMark50Armor;
import barryflash.superheroes.items.armor.ItemThanosArmor;
import barryflash.superheroes.items.armor.ItemThorArmor;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
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
import barryflash.superheroes.models.ModelWonderWomanTiara;

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


public class RenderWonderWomanLayer implements LayerRenderer<AbstractClientPlayer>
{
  
 
    private final RenderLivingBase<?> renderer;
    
    public RenderWonderWomanLayer(RenderLivingBase<?> rendererIn)
    {
        this.renderer = rendererIn;
       
    }

    public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
    	scale = 0.0625F;
    	if (ItemWonderWomanArmor.isWearingFullSet(entitylivingbaseIn, ModItems.WonderWomanTiara, ModItems.WonderWomanChestplate, ModItems.WonderWomanSkirt, ModItems.WonderWomanBoots)) {
    		IWonderWoman wwcap = entitylivingbaseIn.getCapability(WonderWomanProvider.WONDERWOMAN_CAP, null);
    		if (!wwcap.isTiara()) {
    				ModelWonderWomanTiara model = new ModelWonderWomanTiara(scale);
        
        model.bipedLeftArmwear.showModel = false;
        model.bipedRightArmwear.showModel = false;
        model.bipedLeftArm.showModel = false;
        model.bipedRightArm.showModel = false;
        model.bipedRightLeg.showModel = false;
        model.bipedLeftLeg.showModel = false;
        model.bipedHeadwear.showModel = false;
        model.bipedLeftLegwear.showModel = false;
        model.bipedRightLegwear.showModel = false;
        model.bipedBodyWear.showModel = false;
      
        GlStateManager.pushMatrix();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID + ":textures/models/armor/wonderwoman_tiara.png"));
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

  

  
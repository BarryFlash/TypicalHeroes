package barryflash.superheroes.client.render.layers;

import com.google.common.collect.Maps;

import barryflash.superheroes.Reference;
import barryflash.superheroes.capabilities.CaptainAmericaProvider;
import barryflash.superheroes.capabilities.ICaptainAmerica;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemCaptainAmericaArmor;
import barryflash.superheroes.items.armor.ItemIronmanMark50Armor;
import barryflash.superheroes.models.ModelCaptainAmericaShieldBack;
import barryflash.superheroes.models.ModelCaptainAmericaShieldSide;
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


public class RenderCaptainAmericaLayer implements LayerRenderer<AbstractClientPlayer>
{
  
	private static ModelCaptainAmericaShieldBack model2;
    private final RenderLivingBase<?> renderer;
    
    public RenderCaptainAmericaLayer(RenderLivingBase<?> rendererIn)
    {
        this.renderer = rendererIn;
       model2 = new ModelCaptainAmericaShieldBack(0.0625F);
    }

    public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
    	scale = 0.0625F;
    	if (ItemCaptainAmericaArmor.isWearingFullSet(entitylivingbaseIn)) {
    		ICaptainAmerica captaincap = entitylivingbaseIn.getCapability(CaptainAmericaProvider.CAPTAINAMERICA_CAP, null);
    		if (!captaincap.isHoldingShield()) {
    			if (entitylivingbaseIn.inventory.hasItemStack(new ItemStack(ModItems.cap_shield))){
	 
	    			
	    			GlStateManager.pushMatrix();
	    			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	    			
	    			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID + ":textures/models/armor/cap_shield.png"));
	    			((ModelHero) renderer.getMainModel()).bipedBody.postRender(0.0625F);
	    			GlStateManager.rotate(90, 0, 1, 0);
	    			GlStateManager.translate(-0.2, 0, 0);
	    			 if (entitylivingbaseIn.isSneaking()) {
	    	             GlStateManager.translate(0.1F, 0.2F, 0F);
	    	         }
	    			
	    		    model2.right_arm.render(scale);
	    		    model2.right_arm_1.render(scale);
	    	        model2.right_arm_2.render(scale);
	    	        model2.right_arm_3.render(scale);
	    	        model2.right_arm_4.render(scale);
	    	        model2.right_arm_5.render(scale);
	    	        model2.right_arm_6.render(scale);
	    	        model2.right_arm_7.render(scale);
	    	        model2.right_arm_8.render(scale);
	    	        model2.right_arm_9.render(scale);
	    	        model2.right_arm_10.render(scale);
	    	        model2.right_arm_11.render(scale);
	    	        model2.right_arm_12.render(scale);
	    	        model2.right_arm_13.render(scale);
	    	        model2.right_arm_14.render(scale);
	    	        model2.right_arm_15.render(scale);
	    	        model2.right_arm_16.render(scale);
	    	        model2.right_arm_17.render(scale);
	    	        model2.right_arm_18.render(scale);
	    	        model2.right_arm_19.render(scale);
	    	        model2.right_arm_20.render(scale);
	    	        model2.right_arm_21.render(scale);
	    	        model2.right_arm_22.render(scale);
	    	        model2.right_arm_23.render(scale);
	    	        model2.right_arm_24.render(scale);
	    	        model2.right_arm_25.render(scale);
	    	        model2.right_arm_26.render(scale);
	    	        model2.right_arm_27.render(scale);
	    	        model2.right_arm_28.render(scale);
	    	        model2.right_arm_29.render(scale);
	    	        model2.right_arm_30.render(scale);
	    	        model2.right_arm_31.render(scale);
	    	        model2.right_arm_32.render(scale);
	    	        model2.right_arm_33.render(scale);
	    	        model2.right_arm_34.render(scale);
	    	        model2.right_arm_35.render(scale);
	    	        model2.right_arm_36.render(scale);
	    	        model2.right_arm_37.render(scale);
	    	        model2.right_arm_38.render(scale);
	    	        model2.right_arm_39.render(scale);
	    	        model2.right_arm_40.render(scale);
	    	        model2.right_arm_41.render(scale);
	    	        model2.right_arm_42.render(scale);
	    	        model2.right_arm_43.render(scale);
	    	        model2.right_arm_44.render(scale);
	    	        model2.right_arm_45.render(scale);
	    	        model2.right_arm_46.render(scale);
	    	        model2.right_arm_47.render(scale);
	    	        model2.right_arm_48.render(scale);
	    	        model2.right_arm_49.render(scale);
	    	        model2.right_arm_50.render(scale);
	    	        model2.right_arm_51.render(scale);
	    	        model2.right_arm_52.render(scale);
	    	        model2.right_arm_53.render(scale);
	    	        model2.right_arm_54.render(scale);
	    	        model2.right_arm_55.render(scale);
	    	        model2.right_arm_56.render(scale);
	    	        model2.right_arm_57.render(scale);
	    	        model2.right_arm_58.render(scale);
	    	        model2.right_arm_59.render(scale);
	    	        model2.right_arm_60.render(scale);
	    	        model2.right_arm_61.render(scale);
	    	        model2.right_arm_62.render(scale);
	    	        model2.right_arm_63.render(scale);
	    	        model2.right_arm_64.render(scale);
	    	        model2.right_arm_65.render(scale);
	    	        model2.right_arm_66.render(scale);
	    	        model2.right_arm_67.render(scale);
	    	        model2.right_arm_68.render(scale);
	    	        model2.right_arm_69.render(scale);
	    	        model2.right_arm_70.render(scale);
	    	        model2.right_arm_71.render(scale);
	    	        model2.right_arm_72.render(scale);
	    	        model2.right_arm_73.render(scale);
	    	        model2.right_arm_74.render(scale);
	    	        model2.right_arm_75.render(scale);
	    	        model2.right_arm_76.render(scale);
	    	        model2.right_arm_77.render(scale);
	    	        model2.right_arm_78.render(scale);
	    	        model2.right_arm_79.render(scale);
	    	        model2.right_arm_80.render(scale);
	    	        model2.right_arm_81.render(scale);
	    	        model2.right_arm_82.render(scale);
	    	        model2.right_arm_83.render(scale);
	    	        model2.right_arm_84.render(scale);
	    	        model2.right_arm_85.render(scale);
	    	        model2.right_arm_86.render(scale);
	    	        model2.right_arm_87.render(scale);
	    	        model2.right_arm_88.render(scale);
	    	        model2.right_arm_89.render(scale);
	    	        model2.right_arm_90.render(scale);
	    	        model2.right_arm_91.render(scale);
	    	        model2.right_arm_92.render(scale);
	    	        model2.right_arm_93.render(scale);
	    	        model2.right_arm_94.render(scale);
	    	        model2.right_arm_95.render(scale);
	    	        model2.right_arm_96.render(scale);
	    	        model2.right_arm_97.render(scale);
	    	        model2.right_arm_98.render(scale);
	    	        model2.right_arm_99.render(scale);
	    	        model2.right_arm_100.render(scale);
	    	        model2.right_arm_101.render(scale);
	    	        model2.right_arm_102.render(scale);
	    	        model2.right_arm_103.render(scale);
	    	        model2.right_arm_104.render(scale);
	    	        model2.right_arm_105.render(scale);
	    	        model2.right_arm_106.render(scale);
	    	        model2.right_arm_107.render(scale);
	    	        model2.right_arm_108.render(scale);
	    	        model2.right_arm_109.render(scale);
	    	        model2.right_arm_110.render(scale);
	    	        model2.right_arm_111.render(scale);
	    	        model2.right_arm_112.render(scale);
	    	        model2.right_arm_113.render(scale);
	    	        model2.right_arm_114.render(scale);
	    	        model2.right_arm_115.render(scale);
	    	        model2.right_arm_116.render(scale);
	    	        model2.right_arm_117.render(scale);
	    	        model2.right_arm_118.render(scale);
	    	        model2.right_arm_119.render(scale);
	    	        model2.right_arm_120.render(scale);
	    	        model2.right_arm_121.render(scale);
	    	        model2.right_arm_122.render(scale);
	    	        model2.right_arm_123.render(scale);
	    	        model2.right_arm_124.render(scale);
	    	        model2.right_arm_125.render(scale);
	    	        model2.right_arm_126.render(scale);
	    	        model2.right_arm_127.render(scale);
	    	        model2.right_arm_128.render(scale);
	    	        model2.right_arm_129.render(scale);
	    	        model2.right_arm_130.render(scale);
	    	        model2.right_arm_131.render(scale);
	    	        model2.right_arm_132.render(scale);
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

  

  
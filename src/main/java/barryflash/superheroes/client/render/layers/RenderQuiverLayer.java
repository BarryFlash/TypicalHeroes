package barryflash.superheroes.client.render.layers;

import com.google.common.collect.Maps;

import barryflash.superheroes.Reference;
import barryflash.superheroes.capabilities.AntmanProvider;
import barryflash.superheroes.capabilities.IAntman;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IQuiver;
import barryflash.superheroes.capabilities.IThanos;
import barryflash.superheroes.capabilities.IThor;
import barryflash.superheroes.capabilities.IWasp;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.capabilities.QuiverProvider;
import barryflash.superheroes.capabilities.ThanosProvider;
import barryflash.superheroes.capabilities.ThorProvider;
import barryflash.superheroes.capabilities.WaspProvider;
import barryflash.superheroes.client.render.RenderHero;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemAntmanArmor;
import barryflash.superheroes.items.armor.ItemBlackWidowArmor;
import barryflash.superheroes.items.armor.ItemHawkeyeArmor;
import barryflash.superheroes.items.armor.ItemIronmanMark50Armor;
import barryflash.superheroes.items.armor.ItemThanosArmor;
import barryflash.superheroes.items.armor.ItemThorArmor;
import barryflash.superheroes.items.armor.ItemWaspArmor;
import barryflash.superheroes.models.ModelAntmanLights;
import barryflash.superheroes.models.ModelAntmanTrans;
import barryflash.superheroes.models.ModelBlackWidowGlow;
import barryflash.superheroes.models.ModelBlackWidowHair;
import barryflash.superheroes.models.ModelBlackWidowTranslucent;
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
import barryflash.superheroes.models.ModelQuiver;
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
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class RenderQuiverLayer implements LayerRenderer<AbstractClientPlayer>
{
  
	private static ModelQuiver modelH;

	
    private final RenderLivingBase<?> renderer;
    
    public RenderQuiverLayer(RenderLivingBase<?> rendererIn)
    {
        this.renderer = rendererIn;
        this.modelH = new ModelQuiver(0.0625F);

    }

    public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
    	IQuiver qcap = entitylivingbaseIn.getCapability(QuiverProvider.QUIVER_CAP, null);
		if (qcap.isWearingQuiver()) {
    	GlStateManager.pushMatrix();
    	 if (entitylivingbaseIn.isSneaking()) {
             GlStateManager.translate(0, 0.2F, 0);
         }

    	Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/models/armor/quiver.png"));
    	((ModelHero) renderer.getMainModel()).bipedBody.postRender(0.0625F);
    
		modelH.body1.render(scale);
		modelH.body1_1.render(scale);
		modelH.body1_2.render(scale);
		modelH.body1_3.render(scale);
		modelH.body1_4.render(scale);
		modelH.body1_5.render(scale);
		modelH.body1_6.render(scale);
		modelH.body1_7.render(scale);
		modelH.body1_8.render(scale);
		modelH.body1_9.render(scale);
		modelH.body1_10.render(scale);
		modelH.body1_11.render(scale);
		modelH.body1_12.render(scale);
		modelH.body1_13.render(scale);
		modelH.body1_14.render(scale);
		modelH.body1_15.render(scale);
		modelH.body1_16.render(scale);

		GlStateManager.popMatrix();
		}
		
    }
    public boolean shouldCombineTextures()
    {
        return false;
    }

   


    }

  

  
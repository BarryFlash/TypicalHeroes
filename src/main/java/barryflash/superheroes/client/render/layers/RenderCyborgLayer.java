package barryflash.superheroes.client.render.layers;

import org.lwjgl.opengl.GL11;

import barryflash.superheroes.Reference;
import barryflash.superheroes.capabilities.BatmanProvider;
import barryflash.superheroes.capabilities.CyborgProvider;
import barryflash.superheroes.capabilities.DoctorStrangeProvider;
import barryflash.superheroes.capabilities.IBatman;
import barryflash.superheroes.capabilities.ICyborg;
import barryflash.superheroes.capabilities.IDoctorStrange;
import barryflash.superheroes.capabilities.IShazam;
import barryflash.superheroes.capabilities.ISuperman;
import barryflash.superheroes.capabilities.ShazamProvider;
import barryflash.superheroes.capabilities.SupermanProvider;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemBatmanArmor;
import barryflash.superheroes.items.armor.ItemCyborgArmor;
import barryflash.superheroes.items.armor.ItemDoctorStrangeArmor;
import barryflash.superheroes.items.armor.ItemShazamArmor;
import barryflash.superheroes.items.armor.ItemSupermanArmor;
import barryflash.superheroes.models.ModelAntmanLights;
import barryflash.superheroes.models.ModelAntmanTrans;
import barryflash.superheroes.models.ModelBatmanCape;
import barryflash.superheroes.models.ModelBlackWidowGlow;
import barryflash.superheroes.models.ModelBlackWidowHair;
import barryflash.superheroes.models.ModelCyborgLights;
import barryflash.superheroes.models.ModelCyborgSonarCannon;
import barryflash.superheroes.models.ModelCyborgSonarCannonGlow;
import barryflash.superheroes.models.ModelDoctorStrangeCape;
import barryflash.superheroes.models.ModelHero;
import barryflash.superheroes.models.ModelShazamCape;
import barryflash.superheroes.models.ModelShazamGlow;
import barryflash.superheroes.models.ModelSupermanCape;
import barryflash.superheroes.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class RenderCyborgLayer implements LayerRenderer<AbstractClientPlayer> {

	  private final RenderLivingBase<?> renderer;
	  private static ModelCyborgSonarCannon model;
	  private static ModelCyborgSonarCannonGlow modelG;
	    public RenderCyborgLayer(RenderLivingBase<?> rendererIn)
	    {
	        this.renderer = rendererIn;
	        this.model = new ModelCyborgSonarCannon(0.0625F);
	        this.modelG = new ModelCyborgSonarCannonGlow(0.0625F);
	    }
	
	public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount,
			float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		
		if (ItemCyborgArmor.isWearingFullSet(entitylivingbaseIn)) {
			ICyborg cyborgcap = entitylivingbaseIn.getCapability(CyborgProvider.CYBORG_CAP, null);
			//ISuperman supercap = entitylivingbaseIn.getCapability(SupermanProvider.SUPERMAN_CAP, null);
			ModelCyborgLights modelL = new ModelCyborgLights(scale);
		
		
			float brightnessX = OpenGlHelper.lastBrightnessX;
			float brightnessY = OpenGlHelper.lastBrightnessY;
			modelL.bipedLeftArmwear.showModel = false;
			modelL.bipedRightArmwear.showModel = false;
			modelL.bipedHeadwear.showModel = false;
			modelL.bipedLeftLegwear.showModel = false;
			modelL.bipedRightLegwear.showModel = false;
			modelL.bipedBodyWear.showModel = false;

			GlStateManager.pushMatrix();
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID + ":textures/models/armor/cyborg_glow.png"));
			modelL.setModelAttributes(this.renderer.getMainModel());
			modelL.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
			modelL.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, brightnessX, brightnessY);
			GlStateManager.popMatrix();
			if (cyborgcap.isSonarCannon()) {
			model.bipedLeftArmwear.showModel = false;
			model.bipedBody.showModel = false;
			model.bipedHead.showModel = false;
			model.bipedRightArmwear.showModel = false;
			model.bipedHeadwear.showModel = false;
			model.bipedLeftLegwear.showModel = false;
			model.bipedRightLegwear.showModel = false;
			model.bipedBodyWear.showModel = false;

			GlStateManager.pushMatrix();
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID + ":textures/models/armor/cyborg_sonar.png"));
			model.setModelAttributes(this.renderer.getMainModel());
			model.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
			model.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		
		
			GlStateManager.popMatrix();

			
			modelG.bipedLeftArmwear.showModel = false;
			modelG.bipedBody.showModel = false;
			modelG.bipedHead.showModel = false;
			modelG.bipedRightArmwear.showModel = false;
			modelG.bipedHeadwear.showModel = false;
			modelG.bipedLeftLegwear.showModel = false;
			modelG.bipedRightLegwear.showModel = false;
			modelG.bipedBodyWear.showModel = false;

			GlStateManager.pushMatrix();
			GlStateManager.enableBlend();
			GlStateManager.color(1.0F, 1.0F, 1.0F, 0.8F);
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID + ":textures/models/armor/cyborg_glow.png"));
			modelG.setModelAttributes(this.renderer.getMainModel());
			modelG.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
			modelG.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, brightnessX, brightnessY);
			GlStateManager.disableBlend();
			GlStateManager.popMatrix();
			}
		}
	}

	@Override
	public boolean shouldCombineTextures() {
		// TODO Auto-generated method stub
		return false;
	}
	
}

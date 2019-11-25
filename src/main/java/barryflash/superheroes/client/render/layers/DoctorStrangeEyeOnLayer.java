package barryflash.superheroes.client.render.layers;

import org.lwjgl.opengl.GL11;

import barryflash.superheroes.Reference;
import barryflash.superheroes.capabilities.DoctorStrangeProvider;
import barryflash.superheroes.capabilities.IDoctorStrange;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.items.armor.ItemDoctorStrangeArmor;
import barryflash.superheroes.models.ModelDoctorStrangeCape;
import barryflash.superheroes.models.ModelDoctorStrangeCapeHead;
import barryflash.superheroes.models.ModelDoctorStrangeEyeOn;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class DoctorStrangeEyeOnLayer implements LayerRenderer<AbstractClientPlayer> {

	
	@Override
	public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount,
			float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		/*if (ItemDoctorStrangeArmor.isWearingFullSet(Minecraft.getMinecraft().thePlayer, ModArmor.DoctorStrangeRobe, ModArmor.DoctorStrangeLeggings, ModArmor.DoctorStrangeBoots)) {
			IDoctorStrange docstrangecap = Minecraft.getMinecraft().thePlayer.getCapability(DoctorStrangeProvider.DOCTORSTRANGE_CAP, null);
			if (docstrangecap.isUsingEyeOfAgamotto() || docstrangecap.EyeofAgamottoInProgress()) {
				ModelDoctorStrangeEyeOn model = new ModelDoctorStrangeEyeOn();
		
		GlStateManager.pushMatrix();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 180.0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID + ":textures/models/armor/DoctorStrangeEyeOn.png"));
		model.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		GlStateManager.popMatrix();
			}
	}*/
	}

	@Override
	public boolean shouldCombineTextures() {
		// TODO Auto-generated method stub
		return false;
	}
	
}

package barryflash.superheroes.client.render.layers;

import org.lwjgl.opengl.GL11;

import barryflash.superheroes.Reference;
import barryflash.superheroes.capabilities.DoctorStrangeProvider;
import barryflash.superheroes.capabilities.IDoctorStrange;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.items.armor.ItemDoctorStrangeArmor;
import barryflash.superheroes.models.ModelDoctorStrangeCape;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class DoctorStrangeCapeLayer implements LayerRenderer<AbstractClientPlayer> {

	
	@Override
	public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount,
			float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		/*if (ItemDoctorStrangeArmor.isWearingFullSet(Minecraft.getMinecraft().thePlayer, ModArmor.DoctorStrangeRobe, ModArmor.DoctorStrangeLeggings, ModArmor.DoctorStrangeBoots)) {
			IDoctorStrange docstrangecap = Minecraft.getMinecraft().thePlayer.getCapability(DoctorStrangeProvider.DOCTORSTRANGE_CAP, null);
			if (!docstrangecap.isCapeAlive()) {
			ModelBiped model = new ModelDoctorStrangeCape();
		GlStateManager.pushMatrix();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		
		 GlStateManager.translate(0.0F, -0.05F, 0.275F);
		  double d0 = entitylivingbaseIn.prevChasingPosX + (entitylivingbaseIn.chasingPosX - entitylivingbaseIn.prevChasingPosX) * (double)partialTicks - (entitylivingbaseIn.prevPosX + (entitylivingbaseIn.posX - entitylivingbaseIn.prevPosX) * (double)partialTicks);
          double d1 = entitylivingbaseIn.prevChasingPosY + (entitylivingbaseIn.chasingPosY - entitylivingbaseIn.prevChasingPosY) * (double)partialTicks - (entitylivingbaseIn.prevPosY + (entitylivingbaseIn.posY - entitylivingbaseIn.prevPosY) * (double)partialTicks);
          double d2 = entitylivingbaseIn.prevChasingPosZ + (entitylivingbaseIn.chasingPosZ - entitylivingbaseIn.prevChasingPosZ) * (double)partialTicks - (entitylivingbaseIn.prevPosZ + (entitylivingbaseIn.posZ - entitylivingbaseIn.prevPosZ) * (double)partialTicks);
          float f = entitylivingbaseIn.prevRenderYawOffset + (entitylivingbaseIn.renderYawOffset - entitylivingbaseIn.prevRenderYawOffset) * partialTicks;
          double d3 = (double)MathHelper.sin(f * 0.017453292F);
          double d4 = (double)(-MathHelper.cos(f * 0.017453292F));
          float f1 = (float)d1 * 10.0F;
          f1 = MathHelper.clamp_float(f1, -6.0F, 32.0F);
          float f2 = (float)(d0 * d3 + d2 * d4) * 100.0F;
          float f3 = (float)(d0 * d4 - d2 * d3) * 100.0F;

          if (f2 < 0.0F)
          {
              f2 = 0.0F;
          }

          float f4 = entitylivingbaseIn.prevCameraYaw + (entitylivingbaseIn.cameraYaw - entitylivingbaseIn.prevCameraYaw) * partialTicks;
          f1 = f1 + MathHelper.sin((entitylivingbaseIn.prevDistanceWalkedModified + (entitylivingbaseIn.distanceWalkedModified - entitylivingbaseIn.prevDistanceWalkedModified) * partialTicks) * 6.0F) * 32.0F * f4;

          if (entitylivingbaseIn.isSneaking())
          {
              f1 += 25.0F;
              GlStateManager.translate(0.0F, -0.4F, -0.125F);
          }
          
          GlStateManager.rotate(6.0F + f2 / 2.0F + f1, 8.0F, 0.0F, 0.0F);
         GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID + ":textures/models/armor/DoctorStrange_layer_1.png"));
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

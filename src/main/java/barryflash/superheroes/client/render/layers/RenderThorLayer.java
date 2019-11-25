package barryflash.superheroes.client.render.layers;

import barryflash.superheroes.Reference;
import barryflash.superheroes.capabilities.IThor;
import barryflash.superheroes.capabilities.ThorProvider;
import barryflash.superheroes.items.armor.ItemThorArmor;
import barryflash.superheroes.models.ModelSupermanCape;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class RenderThorLayer implements LayerRenderer<AbstractClientPlayer> {

	
	@Override
	public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount,
			float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if (ItemThorArmor.isWearingFullSet(entitylivingbaseIn)) {
			IThor supercap = entitylivingbaseIn.getCapability(ThorProvider.THOR_CAP, null);
		
			ModelBiped model = new ModelSupermanCape();
		GlStateManager.pushMatrix();
		GlStateManager.color(1F, 0.8F, 0.8F, 1.0F);
			
		 GlStateManager.translate(0.0F, -0.05F, 0.3F);
		  double d0 = entitylivingbaseIn.prevChasingPosX + (entitylivingbaseIn.chasingPosX - entitylivingbaseIn.prevChasingPosX) * (double)partialTicks - (entitylivingbaseIn.prevPosX + (entitylivingbaseIn.posX - entitylivingbaseIn.prevPosX) * (double)partialTicks);
          double d1 = entitylivingbaseIn.prevChasingPosY + (entitylivingbaseIn.chasingPosY - entitylivingbaseIn.prevChasingPosY) * (double)partialTicks - (entitylivingbaseIn.prevPosY + (entitylivingbaseIn.posY - entitylivingbaseIn.prevPosY) * (double)partialTicks);
          double d2 = entitylivingbaseIn.prevChasingPosZ + (entitylivingbaseIn.chasingPosZ - entitylivingbaseIn.prevChasingPosZ) * (double)partialTicks - (entitylivingbaseIn.prevPosZ + (entitylivingbaseIn.posZ - entitylivingbaseIn.prevPosZ) * (double)partialTicks);
          float f = entitylivingbaseIn.prevRenderYawOffset + (entitylivingbaseIn.renderYawOffset - entitylivingbaseIn.prevRenderYawOffset) * partialTicks;
          double d3 = (double)MathHelper.sin(f * 0.017453292F);
          double d4 = (double)(-MathHelper.cos(f * 0.017453292F));
          float f1 = (float)d1 * 10.0F;
          f1 = MathHelper.clamp(f1, -6.0F, 32.0F);
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
              GlStateManager.translate(0.0F, 0.1F, -0.025F);
          }
     
         if (supercap.isFlying() && supercap.getFlyTicks() != 0) {
        	 GlStateManager.rotate(15, 8.0F, 0.0F, 0.0F);
         
         } else {
        	 GlStateManager.rotate(7.0F + f2 / 3.5F + f1, 8.0F, 0.0F, 0.0F);
         }
         GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID + ":textures/models/armor/thor_cape.png"));
		model.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		GlStateManager.popMatrix();
		
	}
	}

	@Override
	public boolean shouldCombineTextures() {
		// TODO Auto-generated method stub
		return false;
	}
	
}

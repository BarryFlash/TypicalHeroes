package barryflash.superheroes.client.render;

import org.lwjgl.opengl.GL11;


import barryflash.superheroes.models.SteveTrevorRifleModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class ItemRenderSteveTrevorRifle extends ItemRenderer {
	public ItemRenderSteveTrevorRifle() {
		super(new SteveTrevorRifleModel(), SteveTrevorRifleModel.TEXTURE);

	}


	@Override
	public void renderFirstPersonLeft(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType) {
		;
	}



	@Override
	public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType) {

		float scale = .04000067f;



		GlStateManager.pushMatrix();

		GL11.glScalef(scale, scale, scale);

		GlStateManager.rotate(-20, 0, 1, 0);

		GlStateManager.rotate(180, .13f, .04f, .8200002f);

		GlStateManager.translate(1.9199999794363976, -9.480000011622906, 0);

		GlStateManager.pushMatrix();

		GlStateManager.popMatrix();

		Minecraft.getMinecraft().renderEngine.bindTexture(getResourceLocation());

		getModel().render(null, 0, 0, 0, 0, 0, 1);

		GlStateManager.popMatrix();
	}


	@Override
	public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType) {

		float scale = .019f;

		

		GlStateManager.pushMatrix();

		GL11.glScalef(scale, scale, scale);

		GlStateManager.rotate(100, 0, 1, 0);

		GlStateManager.rotate(190, 1.1799998f, -0.69999963f, 3.1599975f);

		GlStateManager.translate(1, -6.090000042691827, -16.57999962940812);

		GlStateManager.disableLighting();

		Minecraft.getMinecraft().renderEngine.bindTexture(getResourceLocation());

		getModel().render(null, 0, 0, 0, 0, 0, 1);

		GlStateManager.enableLighting();

		GlStateManager.popMatrix();

	}



	@Override

	public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType) {
		float scale = .01700059f;

		

		GlStateManager.pushMatrix();

		GL11.glScalef(scale, scale, scale);

		GL11.glRotated(-90, 1, 0, 0);

		GL11.glRotated(-90, 0, 0, 1);

		GL11.glRotated(-90, 1, 0, 0);

		GL11.glTranslated(.7300000462681062, -11.259999882429838, -19.649999560788274);

		GlStateManager.color(1, 1, 1);

		Minecraft.getMinecraft().renderEngine.bindTexture(getResourceLocation());

		getModel().render(null, 0, 0, 0, 0, 0, 1);

		GlStateManager.popMatrix();

	}



	@Override

	public void renderThirdPersonLeft(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType) {

		;

	}



	@Override

	public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType) {

		float scale = .02100059f;

		

		GlStateManager.pushMatrix();

		GL11.glScalef(scale, scale, scale);

		GL11.glRotated(-190, -40, 120, -150);//

		GL11.glRotated(-93, 0, 0, 1);

		GL11.glRotated(-90, .1999999999999993, -.19000000000000006, -2.209999999999997);

		GL11.glTranslated(1.0, -15, -30.379999999999875);

		GlStateManager.color(1, 1, 1);

		Minecraft.getMinecraft().renderEngine.bindTexture(getResourceLocation());

		getModel().render(null, 0, 0, 0, 0, 0, 1);

		GlStateManager.popMatrix();

	}

}

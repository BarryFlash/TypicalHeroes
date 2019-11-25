package barryflash.superheroes.client.render.layers;

import org.lwjgl.opengl.GL11;

import barryflash.superheroes.Reference;
import barryflash.superheroes.capabilities.DoctorStrangeProvider;
import barryflash.superheroes.capabilities.IDoctorStrange;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.items.armor.ItemDoctorStrangeArmor;
import barryflash.superheroes.models.ModelDoctorStrangeCape;
import barryflash.superheroes.models.ModelDoctorStrangeCapeCover;
import barryflash.superheroes.models.ModelDoctorStrangeCapeHead;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class DoctorStrangeCapeCoverLayer implements LayerRenderer {

	
	@Override
	public void doRenderLayer(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount,
			float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
	
			IDoctorStrange docstrangecap = Minecraft.getMinecraft().player.getCapability(DoctorStrangeProvider.DOCTORSTRANGE_CAP, null);
			if (docstrangecap.isCapeCoveringEnemy()) {
			ModelBiped model = new ModelDoctorStrangeCapeCover();
		
		GlStateManager.pushMatrix();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		 
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID + ":textures/models/armor/DoctorStrange_layer_1.png"));
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

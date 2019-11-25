package barryflash.superheroes.client.render.layers;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import barryflash.superheroes.Reference;
import barryflash.superheroes.capabilities.DoctorStrangeProvider;
import barryflash.superheroes.capabilities.IDoctorStrange;
import barryflash.superheroes.client.render.RenderHero;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemDoctorStrangeArmor;
import barryflash.superheroes.models.ModelDoctorStrangeCape;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class DoctorStrangeEyeMagicLayer implements LayerRenderer<AbstractClientPlayer> {

	 protected final RenderHero playerrenderer;

	    public DoctorStrangeEyeMagicLayer(RenderHero playerrendererIn)
	    {
	       this.playerrenderer = playerrendererIn;
	    }
	
	@Override
	public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float limbSwing, float limbSwingAmount,
			float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		/*if (ItemDoctorStrangeArmor.isWearingFullSet(Minecraft.getMinecraft().thePlayer, ModArmor.DoctorStrangeRobe, ModArmor.DoctorStrangeLeggings, ModArmor.DoctorStrangeBoots)) {
			IDoctorStrange docstrangecap = Minecraft.getMinecraft().thePlayer.getCapability(DoctorStrangeProvider.DOCTORSTRANGE_CAP, null);
			if (docstrangecap.isUsingEyeOfAgamotto() || docstrangecap.EyeofAgamottoInProgress()) {
			GlStateManager.pushMatrix();
		
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 180.0F);
		GlStateManager.color(0F, 0.6F, 0F, 1F);
		this.renderHeldItem(entitylivingbaseIn, new ItemStack(ModItems.doctorstrange_eyemagic), ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, EnumHandSide.RIGHT);
		
	
		GlStateManager.popMatrix();
			}
	}*/
	}
	 private void renderHeldItem(EntityLivingBase p_188358_1_, ItemStack p_188358_2_, ItemCameraTransforms.TransformType p_188358_3_, EnumHandSide handSide)
	    {
	        if (p_188358_2_ != null)
	        {
	            GlStateManager.pushMatrix();

	            if (p_188358_1_.isSneaking())
	            {
	                GlStateManager.translate(0.0F, 0.2F, 0.0F);
	            }
	            // Forge: moved this call down, fixes incorrect offset while sneaking.
	            ((ModelBiped)this.playerrenderer.getMainModel()).postRenderArm(0.0625F, handSide);
	            GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
	            GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
	            boolean flag = handSide == EnumHandSide.LEFT;
	            GlStateManager.translate((float)(flag ? -1 : 1) / 16.0F, 0.125F, -0.575F);
	            Minecraft.getMinecraft().getItemRenderer().renderItemSide(p_188358_1_, p_188358_2_, p_188358_3_, flag);
	            GlStateManager.popMatrix();
	        }
	    }

	@Override
	public boolean shouldCombineTextures() {
		// TODO Auto-generated method stub
		return false;
	}
	
}

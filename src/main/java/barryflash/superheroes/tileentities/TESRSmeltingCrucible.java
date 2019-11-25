package barryflash.superheroes.tileentities;

import org.lwjgl.opengl.GL11;

import barryflash.superheroes.Reference;
import barryflash.superheroes.init.ModFluids;
import barryflash.superheroes.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.fluids.FluidStack;

public class TESRSmeltingCrucible extends TileEntitySpecialRenderer<TileEntitySmeltingCrucible> {

	@Override
	public void render(TileEntitySmeltingCrucible te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		ItemStack stack = ItemStack.EMPTY;
		if (te.getCurrentItemSmelted().equals("titanium")) {
		stack = new ItemStack(ModItems.titanium_ingot, te.getCount());
		} else if (te.getCurrentItemSmelted().equals("gold")) {
			stack = new ItemStack(Items.GOLD_INGOT, te.getCount());
		}
		if (!stack.isEmpty()) {
			if (te.isSmelting()) {
			GlStateManager.enableRescaleNormal();
			GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1f);
			GlStateManager.enableBlend();
			RenderHelper.enableStandardItemLighting();
			GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
			GlStateManager.pushMatrix();
			double offset = Math.sin((te.getWorld().getTotalWorldTime() - te.lastChangeTime + partialTicks) / 8) / 4.0;
			GlStateManager.translate(x + 0.55, y + 0.5, z + 0.45);
			GlStateManager.rotate(60, 3, 2, 3);
			GlStateManager.scale(0.8F, 0.8F, 0.8F);
			IBakedModel model = Minecraft.getMinecraft().getRenderItem().getItemModelWithOverrides(stack, te.getWorld(), null);
			model = ForgeHooksClient.handleCameraTransforms(model, ItemCameraTransforms.TransformType.GROUND, false);
	
			Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
			Minecraft.getMinecraft().getRenderItem().renderItem(stack, model);
	
			GlStateManager.popMatrix();
			GlStateManager.disableRescaleNormal();
			GlStateManager.disableBlend();
			}
		}
			  GlStateManager.pushMatrix();
			  
		        int capacity = (int) (te.getCookTime() + te.getOffset());
		        FluidStack fluid = null;
		        if (te.getCurrentItemSmelted().equals("titanium")) {
		        	fluid = new FluidStack(ModFluids.MOLTEN_TITANIUM_FLUID, capacity);
		    		} else if (te.getCurrentItemSmelted().equals("gold")) {
		    		fluid = new FluidStack(ModFluids.MOLTEN_GOLD_FLUID, capacity);
		    		}else if (te.getCurrentItemSmelted().equals("titaniumgold")) {
			    		fluid = new FluidStack(ModFluids.MOLTEN_TITANIUMGOLD_FLUID, capacity);
			    	}
		        if (fluid != null)
		        {
		            Tessellator tess = Tessellator.getInstance();
		            BufferBuilder buffer = tess.getBuffer();

		            buffer.setTranslation(x, y, z);
		            
		            bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
		            TextureAtlasSprite still = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(fluid.getFluid().getStill().toString());
		            TextureAtlasSprite flow =  Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(fluid.getFluid().getFlowing().toString());

		            double posY = .05 + (.02 * (float) capacity/80);
		            int fcolor = fluid.getFluid().getColor(fluid);
		            float[] color = new float[4];

		            color[0] = (fcolor >> 16 & 255) / 255.0F;

		            color[1] = (fcolor >> 8 & 255) / 255.0F;

		            color[2] = (fcolor & 255) / 255.0F;

		            color[3] = (fcolor >> 24 & 255) / 255.0F;
		            
		            buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_COLOR);
		            buffer.pos( 4F/16F, posY,  4F/16F).tex(still.getInterpolatedU( 4), still.getInterpolatedV( 4)).color(color[0], color[1], color[2], color[3]).endVertex();
		            buffer.pos(4F/16F, posY,  12F/16F).tex(still.getInterpolatedU(12), still.getInterpolatedV( 4)).color(color[0], color[1], color[2], color[3]).endVertex();
		            buffer.pos(12F/16F, posY, 12F/16F).tex(still.getInterpolatedU(12), still.getInterpolatedV(12)).color(color[0], color[1], color[2], color[3]).endVertex();
		            buffer.pos( 12F/16F, posY, 4F/16F).tex(still.getInterpolatedU( 4), still.getInterpolatedV(12)).color(color[0], color[1], color[2], color[3]).endVertex();
		            tess.draw();

		           
		            
		            buffer.setTranslation(0, 0, 0);
		        }
		        GlStateManager.popMatrix();

		
	}

}

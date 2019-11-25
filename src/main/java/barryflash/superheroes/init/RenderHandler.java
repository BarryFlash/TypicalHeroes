package barryflash.superheroes.init;

import javax.annotation.Nonnull;

import barryflash.superheroes.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.IFluidBlock;

public class RenderHandler {

	public static void registerFluidMeshesAndStates(Fluid fluid ) {
		  IFluidBlock fluidBlock = (IFluidBlock) fluid.getBlock();
	        Item item = Item.getItemFromBlock((Block) fluidBlock);
	        ModelBakery.registerItemVariants(item);
	        final ModelResourceLocation modelLoc = new ModelResourceLocation(Reference.MODID + ":fluids", fluidBlock.getFluid().getName());
	        ModelLoader.setCustomMeshDefinition(item, stack -> modelLoc);
	        ModelLoader.setCustomStateMapper((Block) fluidBlock, new StateMapperBase()
	        {
	            @Override
	            protected ModelResourceLocation getModelResourceLocation(IBlockState state)
	            {
	                return modelLoc;
	            }
	        });
	}
}

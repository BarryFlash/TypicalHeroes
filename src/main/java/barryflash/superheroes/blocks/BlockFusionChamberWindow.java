package barryflash.superheroes.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;

public class BlockFusionChamberWindow extends BlockFusionChamberRegular {

	public BlockFusionChamberWindow(String name, Material materialIn, int hardness) {
		super(name, materialIn, hardness);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public BlockRenderLayer getBlockLayer() {
		// TODO Auto-generated method stub
		return BlockRenderLayer.TRANSLUCENT;
	}
}

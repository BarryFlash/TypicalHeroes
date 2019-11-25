package barryflash.superheroes.blocks;

import barryflash.superheroes.SuperheroesMod;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockCodex extends BlockFacingBase {

	public BlockCodex(String name, Material materialIn, int hardness) {
		super(name, materialIn, SuperheroesMod.materialscreativeTab, hardness);
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		// TODO Auto-generated method stub
		return new AxisAlignedBB(0.0625 * 6, 0, 0.0625 * 6, 0.0625 * 11, 0.0625 * 5, 0.0625 * 11);
	}
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		// TODO Auto-generated method stub
		return new AxisAlignedBB(0.0625 * 6, 0, 0.0625 * 6, 0.0625 * 11, 0.0625 * 5, 0.0625 * 11);
	}
	
}

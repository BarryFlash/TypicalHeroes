package barryflash.superheroes.tileentities;

import javax.annotation.Nullable;

import barryflash.superheroes.blocks.BlockTesseractEnergyExtractor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class TileEntityTesseractEnergyExtractorGUI<TE extends TileEntity> extends BlockTesseractEnergyExtractor {

	public TileEntityTesseractEnergyExtractorGUI(String unlocalizedName, String registryName) {
		super(unlocalizedName, registryName);
	}
	
	public abstract Class<TE> getTileEntityClass();
	
	public TE getTileEntity(IBlockAccess world, BlockPos pos) {
		return (TE)world.getTileEntity(pos);
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
	
	@Nullable
	@Override
	public abstract TE createTileEntity(World world, IBlockState state);

}

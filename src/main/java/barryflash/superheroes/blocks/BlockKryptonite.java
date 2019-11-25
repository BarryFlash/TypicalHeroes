package barryflash.superheroes.blocks;

import javax.annotation.Nullable;

import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.capabilities.ISuperman;
import barryflash.superheroes.capabilities.SupermanProvider;
import barryflash.superheroes.network.MessageCapToClient;
import barryflash.superheroes.network.MessageCapToServer;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.tileentities.TileEntityDnaExtractor;
import barryflash.superheroes.tileentities.TileEntityFuelGenerator;
import barryflash.superheroes.tileentities.TileEntityKryptonite;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockKryptonite extends BlockFacingTileEntity<TileEntityKryptonite> {

	public BlockKryptonite(String name, Material materialIn, int hardness) {
		super(name, materialIn, SuperheroesMod.materialscreativeTab, hardness);
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		// TODO Auto-generated method stub
		return new AxisAlignedBB(0.0625 * 5.5, 0, 0.0625 * 5.5, 0.0625 * 9.5, 0.0625 * 6, 0.0625 * 9.5);
	}
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		// TODO Auto-generated method stub
		return new AxisAlignedBB(0.0625 * 5.5, 0, 0.0625 * 5.5, 0.0625 * 9.5, 0.0625 * 6, 0.0625 * 9.5);
	}
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntityKryptonite te = (TileEntityKryptonite) world.getTileEntity(pos);
		if (!te.getList().isEmpty()) {
			for (int i = 0; i < te.getList().size(); i++) {
				ISuperman supercap = te.getList().get(i).getCapability(SupermanProvider.SUPERMAN_CAP, null);
				if (supercap.isAffectedByKryptonite()) {
				supercap.setKrpyonite(false);
				NetworkHandler.sendTo(new MessageCapToClient(supercap.isAffectedByKryptonite(), "kryptonite", te.getList().get(i).getEntityId()), (EntityPlayerMP) te.getList().get(i));
				}
			}
		}
		super.breakBlock(world, pos, state);
	}
	@Override
	public Class<TileEntityKryptonite> getTileEntityClass() {
		return TileEntityKryptonite.class;
	}
	
	@Nullable
	@Override
	public TileEntityKryptonite createTileEntity(World world, IBlockState state) {
		return new TileEntityKryptonite();
	}
}

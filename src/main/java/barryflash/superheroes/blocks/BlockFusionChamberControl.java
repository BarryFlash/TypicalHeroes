package barryflash.superheroes.blocks;

import javax.annotation.Nullable;

import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.client.gui.GuiHandler;
import barryflash.superheroes.tileentities.BlockTileEntity;
import barryflash.superheroes.tileentities.MachineTileEntity;
import barryflash.superheroes.tileentities.TileEntityFusionChamber;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;

public class BlockFusionChamberControl extends BlockTileEntity<TileEntityFusionChamber>  {

	public BlockFusionChamberControl(String name, Material materialIn, int hardness) {
		super(name, materialIn, SuperheroesMod.machinescreativeTab, hardness);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		//IFusionChamber fccap = player.getCapability(FusionChamberProvider.FUSION_CHAMBER_CAP, null);
		
		//if (!fccap.isInside()) {
			//fccap.setInside(true);
			//player.setPosition(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
			TileEntityFusionChamber te = (TileEntityFusionChamber) world.getTileEntity(pos);
			if (te != null && te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)) {
				player.openGui(SuperheroesMod.instance, GuiHandler.FUSION_CHAMBER, world, pos.getX(), pos.getY(), pos.getZ());
			}
			
		//} 
		return true;
	}
	
	@Override
	public Class<TileEntityFusionChamber> getTileEntityClass() {
		return TileEntityFusionChamber.class;
	}
	
	@Nullable
	@Override
	public TileEntityFusionChamber createTileEntity(World world, IBlockState state) {
		return new TileEntityFusionChamber();
	}
}

package barryflash.superheroes.blocks;

import java.util.List;

import javax.annotation.Nullable;

import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.tileentities.BlockTileEntity;
import barryflash.superheroes.tileentities.TileEntityCable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.energy.CapabilityEnergy;

public class BlockCable extends BlockTileEntity {

	public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool WEST = PropertyBool.create("west");
    public static final PropertyBool UP = PropertyBool.create("up");
    public static final PropertyBool DOWN = PropertyBool.create("down");
    
	public BlockCable(String name, Material materialIn, int hardness) {
		super(name, materialIn, SuperheroesMod.machinescreativeTab, hardness);
		// TODO Auto-generated constructor stub
	}
	
	  public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	    {
	        state = state.getActualState(source, pos);
	        float f = 0.3875F;
	        float f1 = ((Boolean)state.getValue(WEST)).booleanValue() ? 0.0F : 0.405F;
	        float f2 = ((Boolean)state.getValue(DOWN)).booleanValue() ? 0.0F : 0.405F;
	        float f3 = ((Boolean)state.getValue(NORTH)).booleanValue() ? 0.0F : 0.405F;
	        float f4 = ((Boolean)state.getValue(EAST)).booleanValue() ? 1.0F : 0.595F;
	        float f5 = ((Boolean)state.getValue(UP)).booleanValue() ? 1.0F : 0.595F;
	        float f6 = ((Boolean)state.getValue(SOUTH)).booleanValue() ? 1.0F : 0.595F;
	        return new AxisAlignedBB((double)f1, (double)f2, (double)f3, (double)f4, (double)f5, (double)f6);
	    }

	    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState)
	    {
	        if (!isActualState)
	        {
	            state = state.getActualState(worldIn, pos);
	        }

	        float f = 0.1875F;
	        float f1 = 0.8125F;
	        addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.3875D, 0.3875D, 0.3875D, 0.6125D, 0.6125D, 0.6125D));

	        if (((Boolean)state.getValue(WEST)).booleanValue())
	        {
	            addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.0D, 0.3875D, 0.3875D, 0.3875D, 0.6125D, 0.6125D));
	        }

	        if (((Boolean)state.getValue(EAST)).booleanValue())
	        {
	            addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.6125D, 0.3875D, 0.3875D, 1.0D, 0.6125D, 0.6125D));
	        }

	        if (((Boolean)state.getValue(UP)).booleanValue())
	        {
	            addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.3875D, 0.6125D, 0.3875D, 0.6125D, 1.0D, 0.6125D));
	        }

	        if (((Boolean)state.getValue(DOWN)).booleanValue())
	        {
	            addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.3875D, 0.0D, 0.3875D, 0.6125D, 0.3875D, 0.6125D));
	        }

	        if (((Boolean)state.getValue(NORTH)).booleanValue())
	        {
	            addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.3875D, 0.3875D, 0.0D, 0.6125D, 0.6125D, 0.3875D));
	        }

	        if (((Boolean)state.getValue(SOUTH)).booleanValue())
	        {
	            addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.3875D, 0.3875D, 0.6125D, 0.6125D, 0.6125D, 1.0D));
	        }
	    }
	    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
	    {
	        return BlockFaceShape.UNDEFINED;
	    }
	public boolean isFullCube(IBlockState state)
    {
        return false;
    }


    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
	public int getMetaFromState(IBlockState state)
    {
        return 0;
    }
	@Override
	protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {NORTH, EAST, SOUTH, WEST, UP, DOWN});
    }
	 public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	    {
		 Block block = worldIn.getBlockState(pos.down()).getBlock();
	        Block block1 = worldIn.getBlockState(pos.up()).getBlock();
	        Block block2 = worldIn.getBlockState(pos.north()).getBlock();
	        Block block3 = worldIn.getBlockState(pos.east()).getBlock();
	        Block block4 = worldIn.getBlockState(pos.south()).getBlock();
	        Block block5 = worldIn.getBlockState(pos.west()).getBlock();
	        TileEntity tile = worldIn.getTileEntity(pos.down());
	        TileEntity tile1 = worldIn.getTileEntity(pos.up());
	        TileEntity tile2 = worldIn.getTileEntity(pos.north());
	        TileEntity tile3 = worldIn.getTileEntity(pos.east());
	        TileEntity tile4 = worldIn.getTileEntity(pos.south());
	        TileEntity tile5 = worldIn.getTileEntity(pos.west());
	        
	        return state.withProperty(DOWN, Boolean.valueOf(block == this || (tile != null && tile.hasCapability(CapabilityEnergy.ENERGY, EnumFacing.UP)))).withProperty(UP, Boolean.valueOf(block1 == this || (tile1 != null && tile1.hasCapability(CapabilityEnergy.ENERGY, EnumFacing.DOWN)))).withProperty(NORTH, Boolean.valueOf(block2 == this || (tile2 != null && tile2.hasCapability(CapabilityEnergy.ENERGY, EnumFacing.SOUTH)))).withProperty(EAST, Boolean.valueOf(block3 == this || (tile3 != null && tile3.hasCapability(CapabilityEnergy.ENERGY, EnumFacing.WEST)))).withProperty(SOUTH, Boolean.valueOf(block4 == this || (tile4 != null && tile4.hasCapability(CapabilityEnergy.ENERGY, EnumFacing.NORTH)))).withProperty(WEST, Boolean.valueOf(block5 == this || (tile5 != null && tile5.hasCapability(CapabilityEnergy.ENERGY, EnumFacing.EAST))));
	    }
	@Override
	public Class getTileEntityClass() {
		// TODO Auto-generated method stub
		return TileEntityCable.class;
	}
	@Override
	public TileEntityCable createTileEntity(World world, IBlockState state) {
		// TODO Auto-generated method stub
		return new TileEntityCable();
	}
	
}

package barryflash.superheroes.blocks;

import java.util.List;
import java.util.Random;

import barryflash.superheroes.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBatmanComputer extends Block{
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing");
	
	public BlockBatmanComputer(String unlocalizedName, String registryName) {
		super(Material.ROCK);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, registryName));
		this.setHardness(2);
		this.setResistance(2);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));

	}
	
	@Override

	public int getMetaFromState(IBlockState state) {

		

		EnumFacing facing = (EnumFacing) state.getValue(FACING);

		int meta = EnumFacing.values().length + facing.ordinal(); // Stores the type the EnumFacing in the meta

		return meta;

	}
	@Override

	public IBlockState getStateFromMeta(int meta) {




		EnumFacing facing = EnumFacing.values()[meta % EnumFacing.values().length]; //Gets the EnumFacing from the meta

		return this.getDefaultState().withProperty(FACING, facing); //Returns the correct state

	}
	@Override

	public int damageDropped(IBlockState state) {

		return (int) (getMetaFromState(state) / EnumFacing.values().length);

	}
	@Override
	protected BlockStateContainer createBlockState() {
		// TODO Auto-generated method stub
		return new BlockStateContainer(this, new IProperty[] {FACING});
	}
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	
	
	
}

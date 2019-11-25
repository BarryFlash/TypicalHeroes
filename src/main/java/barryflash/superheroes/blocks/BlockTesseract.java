package barryflash.superheroes.blocks;

import java.util.List;
import java.util.Random;

import barryflash.superheroes.Reference;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IThanos;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.capabilities.ThanosProvider;
import barryflash.superheroes.entities.particles.ParticleSpawnerDoctorStrangeShields;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.tileentities.TileEntityTesseract;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTesseract extends Block implements ITileEntityProvider {
	public BlockTesseract(String unlocalizedName, String registryName) {
		super(Material.IRON);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, registryName));
		this.setHardness(4);
		this.setResistance(20);
		this.setTickRandomly(true);
		this.setLightLevel(5F);
	}

	@Override
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		
		/*if (!playerIn.worldObj.isRemote) {
			if (playerIn.inventory.getCurrentItem().getItem() == ModItems.thanos_gauntlet) {
		EntityItem item = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.infinitystone_space));
		worldIn.spawnEntityInWorld(item);
		worldIn.destroyBlock(pos, false);
		ParticleSpawnerDoctorStrangeShields.spawnParticle("tesseract", pos.getX() + 0.1, pos.getY() + 0.1, pos.getZ() + 0.5, 0, 0.0, 0);
		ParticleSpawnerDoctorStrangeShields.spawnParticle("tesseract", pos.getX() + 0.9, pos.getY() + 0.1, pos.getZ() + 0.5, 0.0, 0, 0);
		ParticleSpawnerDoctorStrangeShields.spawnParticle("tesseract", pos.getX() + 0.5, pos.getY() + 0.1, pos.getZ() + 0.1, 0, 0.0, 0);
		ParticleSpawnerDoctorStrangeShields.spawnParticle("tesseract", pos.getX() + 0.5, pos.getY() + 0.1, pos.getZ() + 0.9, 0.0, 0, 0);
		ParticleSpawnerDoctorStrangeShields.spawnParticle("tesseract", pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 0, 0.0, 0);
		ParticleSpawnerDoctorStrangeShields.spawnParticle("tesseract", item.posX, item.posY, item.posZ, 0, 0.0, 0);
			}
	}*/
		
		
	}
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		// TODO Auto-generated method stub
		
		worldIn.spawnParticle(EnumParticleTypes.CLOUD, pos.getX(), pos.getY(), pos.getZ(), 0, 0.003, 0);
	}
	@Override
	public int tickRate(World worldIn) {
		// TODO Auto-generated method stub
		return 10;
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
	 public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	    {
	        list.add("\u00A7l" + "\u00A7b" + "Extremely powerful block that can be used for energy.");
	    }
	 @Override
	public BlockRenderLayer getBlockLayer() {
		// TODO Auto-generated method stub
		return BlockRenderLayer.TRANSLUCENT;
	}
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntityTesseract();
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		// TODO Auto-generated method stub
		super.randomDisplayTick(stateIn, worldIn, pos, rand);
		ParticleSpawnerDoctorStrangeShields.spawnParticle("tesseract", pos.getX() + 0.5, pos.getY() + 0.1, pos.getZ() + 0.5, 0, 0.03, 0, null);
		
	}

	
	
}

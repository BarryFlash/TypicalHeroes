package barryflash.superheroes.blocks;

import javax.annotation.Nullable;

import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.tileentities.BlockTileEntity;
import barryflash.superheroes.tileentities.TileEntitySmeltingCrucible;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSmeltingCrucible extends BlockTileEntity<TileEntitySmeltingCrucible> {

	public BlockSmeltingCrucible(String name, Material materialIn, int hardness) {
		super(name, materialIn, SuperheroesMod.machinescreativeTab, hardness);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean isFullCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			TileEntitySmeltingCrucible tile = getTileEntity(world, pos);
			if (world.getBlockState(pos.down()).getBlock() == Blocks.FIRE) {
	
				if (player.inventory.getCurrentItem().getItem() == ModItems.titanium_ingot) {
					player.inventory.decrStackSize(player.inventory.getSlotFor(new ItemStack(ModItems.titanium_ingot)),1);
					tile.setCurrentItemSmelted("titanium");
					tile.incrementCount();
					tile.addTitanium();
					//player.sendMessage(new TextComponentString("Titanium: " + tile.getTitanium()));
					//player.sendMessage(new TextComponentString("Gold: " + tile.getGold()));
					//player.sendMessage(new TextComponentString("TitaniumGold: " + tile.getTitaniumGold()));
				}
				if (player.inventory.getCurrentItem().getItem() == Items.GOLD_INGOT) {
					player.inventory.decrStackSize(player.inventory.getSlotFor(new ItemStack(Items.GOLD_INGOT)),1);
					tile.setCurrentItemSmelted("gold");
					tile.incrementCount();
					tile.addGold();
					//player.sendMessage(new TextComponentString("Titanium: " + tile.getTitanium()));
					//player.sendMessage(new TextComponentString("Gold: " + tile.getGold()));
					//player.sendMessage(new TextComponentString("TitaniumGold: " + tile.getTitaniumGold()));
				}
				if (player.inventory.getCurrentItem().getItem() == Items.WATER_BUCKET) {
					if (tile.getCount() > 0) {
					world.playSound(player, pos, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.AMBIENT, 1F, 1F);
					int slot = player.inventory.getSlotFor(player.inventory.getCurrentItem());
					player.inventory.removeStackFromSlot(slot);
					player.inventory.setInventorySlotContents(slot, new ItemStack(Items.BUCKET));
					if (tile.getTitaniumGold() == 6) {
						EntityItem item = new EntityItem(world, pos.getX(), pos.getY()+1, pos.getZ(), new ItemStack(ModItems.TITANIUMGOLD_INGOT));
						world.spawnEntity(item);
						tile.removeTitaniumGold();
					}
					if (tile.getTitanium() > 0) {
						EntityItem item = new EntityItem(world, pos.getX(), pos.getY()+1, pos.getZ(), new ItemStack(ModItems.titanium_ingot, tile.getTitanium()));
						world.spawnEntity(item);
						tile.removeTitanium(tile.getTitanium());
					}
					if (tile.getGold() > 0) {
						EntityItem item = new EntityItem(world, pos.getX(), pos.getY()+1, pos.getZ(), new ItemStack(Items.GOLD_INGOT, tile.getGold()));
						world.spawnEntity(item);
						tile.removeGold(tile.getGold());
					}
					}
				}
			}
		}
		return true;
	}
	@Override
	public Class<TileEntitySmeltingCrucible> getTileEntityClass() {
		return TileEntitySmeltingCrucible.class;
	}
	
	@Nullable
	@Override
	public TileEntitySmeltingCrucible createTileEntity(World world, IBlockState state) {
		return new TileEntitySmeltingCrucible();
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		// TODO Auto-generated method stub
		return new AxisAlignedBB(0.0625 * 3.5, 0, 0.0625 * 3.5, 0.0625 * 12.5, 0.0625 * 11, 0.0625 * 12.5);
	}
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		// TODO Auto-generated method stub
		return new AxisAlignedBB(0.0625 * 3.5, 0, 0.0625 * 3.5, 0.0625 * 12.5, 0.0625 * 11, 0.0625 * 12.5);
	}
}

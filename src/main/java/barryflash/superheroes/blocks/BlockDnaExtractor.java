package barryflash.superheroes.blocks;

import javax.annotation.Nullable;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.client.gui.GuiHandler;
import barryflash.superheroes.client.gui.GuiSuitMaker;
import barryflash.superheroes.tileentities.BlockTileEntity;
import barryflash.superheroes.tileentities.TileEntityDnaExtractor;
import barryflash.superheroes.tileentities.TileEntityFuelGenerator;
import barryflash.superheroes.tileentities.TileEntityNanoCompacter;
import barryflash.superheroes.tileentities.TileEntitySmeltingCrucible;
import barryflash.superheroes.tileentities.TileSuitMaker;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class BlockDnaExtractor extends BlockTileEntity<TileEntityDnaExtractor> {

	public BlockDnaExtractor(String name, Material materialIn, int hardness) {
		super(name, materialIn, SuperheroesMod.machinescreativeTab, hardness);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean isFullCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) {
		// TODO Auto-generated method stub
		return layer == BlockRenderLayer.SOLID || layer == BlockRenderLayer.TRANSLUCENT;
	}


	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		TileEntityDnaExtractor te = (TileEntityDnaExtractor) world.getTileEntity(pos);
		//player.openGui(SuperheroesMod.instance, GUIHandler.SUIT_MAKER, world, (int)player.posX, (int)player.posY, (int)player.posZ);
		if (te != null && te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)) {
			player.openGui(SuperheroesMod.instance, GuiHandler.DNA_EXTRACTOR, world, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntityDnaExtractor te = (TileEntityDnaExtractor) world.getTileEntity(pos);
		if (te != null && te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)) {
			IItemHandler inventory = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
			if (inventory != null) {
				for (int i = 0; i < inventory.getSlots(); i++) {
					if (inventory.getStackInSlot(i) != ItemStack.EMPTY) {
						EntityItem item = new EntityItem(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, inventory.getStackInSlot(i));
						
						float multiplier = 0.1f;
						float motionX = world.rand.nextFloat() - 0.5f;
						float motionY = world.rand.nextFloat() - 0.5F;
						float motionZ = world.rand.nextFloat() - 0.5f;
						item.motionX = motionX * multiplier;
						item.motionY = motionY * multiplier;
						item.motionZ = motionZ * multiplier;
						world.spawnEntity(item);
					}
				}
			}
		}
		super.breakBlock(world, pos, state);
	}
	@Override
	public Class<TileEntityDnaExtractor> getTileEntityClass() {
		return TileEntityDnaExtractor.class;
	}
	
	@Nullable
	@Override
	public TileEntityDnaExtractor createTileEntity(World world, IBlockState state) {
		return new TileEntityDnaExtractor();
	}

}

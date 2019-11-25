package barryflash.superheroes.blocks;

import javax.annotation.Nullable;

import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.client.gui.GuiHandler;
import barryflash.superheroes.tileentities.BlockTileEntity;
import barryflash.superheroes.tileentities.TileEntityDnaExtractor;
import barryflash.superheroes.tileentities.TileEntityLightningExtractor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class BlockLightningExtractor extends BlockTileEntity<TileEntityLightningExtractor> {

	public BlockLightningExtractor(String name, Material materialIn, CreativeTabs tab, int hardness) {
		super(name, materialIn, tab, hardness);
		// TODO Auto-generated constructor stub
		
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		TileEntityLightningExtractor te = (TileEntityLightningExtractor) world.getTileEntity(pos);
		//player.openGui(SuperheroesMod.instance, GUIHandler.SUIT_MAKER, world, (int)player.posX, (int)player.posY, (int)player.posZ);
		if (te != null && te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)) {
			if (!player.isSneaking()) {
				player.openGui(SuperheroesMod.instance, GuiHandler.LIGHTNING_EXTRACTOR, world, pos.getX(), pos.getY(), pos.getZ());
			} else if (!world.isRemote) {
				String string = null;
				boolean error = false;
				if (te.getPos().getY() < 100) {
					string = "Lightning Extractor needs to be at a y-level of 100 or higher.";
					error = true;
				} else if (!world.getWorldInfo().isThundering()) {
					string = "It needs to be a thunder storm to collect lightning.";
					error = true;
				} else if (te.lightning >= 1000) {
					string = "Lightning storage is full.";
					error = true;
				} else if (te.getEnergy() == 0) {
					string = "The Lightning Extractor requires energy.";
					error = true;
				} else {
					string = null;
					error = false;
				}
						
				if (error) {
				player.sendMessage(new TextComponentString(string));
				}
			}
		}
		return true;
	}
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntityLightningExtractor te = (TileEntityLightningExtractor) world.getTileEntity(pos);
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
	public boolean isOpaqueCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isFullCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Class<TileEntityLightningExtractor> getTileEntityClass() {
		return TileEntityLightningExtractor.class;
	}
	
	@Nullable
	@Override
	public TileEntityLightningExtractor createTileEntity(World world, IBlockState state) {
		return new TileEntityLightningExtractor();
	}
}

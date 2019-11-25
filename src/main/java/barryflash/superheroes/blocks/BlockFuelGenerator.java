package barryflash.superheroes.blocks;

import javax.annotation.Nullable;

import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.client.gui.GuiHandler;
import barryflash.superheroes.tileentities.TileEntityFuelGenerator;
import barryflash.superheroes.tileentities.TileEntityNanoCompacter;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class BlockFuelGenerator extends BlockFacingTileEntity<TileEntityFuelGenerator> {

	public BlockFuelGenerator(String name, int hardness) {
		super(name, Material.IRON, SuperheroesMod.machinescreativeTab, hardness);
	}
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		TileEntityFuelGenerator te = (TileEntityFuelGenerator) world.getTileEntity(pos);
		//player.openGui(SuperheroesMod.instance, GUIHandler.SUIT_MAKER, world, (int)player.posX, (int)player.posY, (int)player.posZ);
		if (te != null && te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)) {
			te.setPlayer(player);
			player.openGui(SuperheroesMod.instance, GuiHandler.FUEL_GENERATOR, world, pos.getX(), pos.getY(), pos.getZ());
			
		}
		return true;
	}

	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntityFuelGenerator te = (TileEntityFuelGenerator) world.getTileEntity(pos);
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
	public Class<TileEntityFuelGenerator> getTileEntityClass() {
		return TileEntityFuelGenerator.class;
	}
	
	@Nullable
	@Override
	public TileEntityFuelGenerator createTileEntity(World world, IBlockState state) {
		return new TileEntityFuelGenerator();
	}
}

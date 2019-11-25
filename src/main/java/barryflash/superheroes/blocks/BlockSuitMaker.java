package barryflash.superheroes.blocks;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.client.gui.GuiHandler;
import barryflash.superheroes.client.gui.GuiSuitMaker;
import barryflash.superheroes.tileentities.TileSuitMaker;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class BlockSuitMaker extends BlockFacingBase {

	public BlockSuitMaker(String name, Material materialIn, int hardness) {
		super(name, materialIn, SuperheroesMod.machinescreativeTab, hardness);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		// TODO Auto-generated method stub
		//player.openGui(SuperheroesMod.instance, GUIHandler.SUIT_MAKER, world, (int)player.posX, (int)player.posY, (int)player.posZ);
		if (world.isRemote) {
			player.openGui(SuperheroesMod.instance, GuiHandler.SUIT_MAKER, world, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
}

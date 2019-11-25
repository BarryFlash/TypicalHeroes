package barryflash.superheroes.blocks;

import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.capabilities.AntmanProvider;
import barryflash.superheroes.capabilities.IAntman;
import barryflash.superheroes.capabilities.IZeusAltar;
import barryflash.superheroes.capabilities.ZeusAltarProvider;
import barryflash.superheroes.client.gui.GuiHandler;
import barryflash.superheroes.client.gui.GuiZeusAltar;
import barryflash.superheroes.network.MessageUpdateZeusAltarCap;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.recipes.SuitRecipes;
import barryflash.superheroes.recipes.ZeusAltarOfferings;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockZeusShrine extends BlockFacingBase {

	public BlockZeusShrine(String name, Material materialIn, int hardness) {
		super(name, materialIn, SuperheroesMod.blockscreativeTab, hardness);
	}
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		// TODO Auto-generated method stub
		return new AxisAlignedBB(0, 0, 0, 0.0625 * 16, 0.0625 * 32, 0.0625 * 16);
	}
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		// TODO Auto-generated method stub
		return new AxisAlignedBB(0, 0, 0, 0.0625 * 16, 0.0625 * 32, 0.0625 * 16);
	}
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		// TODO Auto-generated method stub


			IZeusAltar zeusaltarCap = player.getCapability(ZeusAltarProvider.ZEUS_ALTAR_CAP, null);
				ItemStack stack = player.inventory.getCurrentItem();
				
					if (ZeusAltarOfferings.hasOffering(stack.getItem()) != -1) {
						if (zeusaltarCap.getProgress() < 100) {
						zeusaltarCap.addProgress(ZeusAltarOfferings.hasOffering(stack.getItem()));
						player.inventory.decrStackSize(SuitRecipes.getSlotFor(player.inventory, stack), 1);
						}
						if (zeusaltarCap.getProgress() > 100) {
							zeusaltarCap.setProgress(100);
						}
					} else {
						if (world.isRemote) {
							player.openGui(SuperheroesMod.instance, GuiHandler.ZEUS_SHRINE, world, pos.getX(), pos.getY(), pos.getZ());
						}
					}
				
				
		
		
		
		return true;
	}
	
}

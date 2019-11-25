package barryflash.superheroes.blocks;

import java.util.Random;

import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.blocks.itemblocks.ItemBlockDoor;
import barryflash.superheroes.init.ModBlocks;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.util.IHasModel;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockFusionChamberDoor extends BlockDoor implements IHasModel {

	public BlockFusionChamberDoor(String name, Material materialIn) {
		super(materialIn);
		// TODO Auto-generated constructor stub
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(SuperheroesMod.machinescreativeTab);
		setHardness(2);
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlockDoor(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		// TODO Auto-generated method stub
		return Item.getItemFromBlock(this);
	}
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
		// TODO Auto-generated method stub
		return new ItemStack(this);
	}
	@Override
	public void registerModels() {
		SuperheroesMod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}

package barryflash.superheroes.blocks;

import java.util.Random;

import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.init.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockOreBase extends BlockBase {

	public BlockOreBase(String name, Material materialIn, int hardness, int level) {
		super(name, materialIn, SuperheroesMod.blockscreativeTab, hardness);
		this.setResistance(20);
		this.setHarvestLevel("pickaxe", level);
	}
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		// TODO Auto-generated method stub
		return Item.getItemFromBlock(this);
	}
}

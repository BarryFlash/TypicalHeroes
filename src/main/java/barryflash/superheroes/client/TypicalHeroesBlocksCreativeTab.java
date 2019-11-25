package barryflash.superheroes.client;

import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.init.ModBlocks;
import barryflash.superheroes.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TypicalHeroesBlocksCreativeTab extends CreativeTabs{
	public TypicalHeroesBlocksCreativeTab() {
		super("thblocks");
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Item.getItemFromBlock(ModBlocks.URANIUM_BLOCK));
	}

	@Override
	public boolean hasSearchBar() {
		return false;
	}

}
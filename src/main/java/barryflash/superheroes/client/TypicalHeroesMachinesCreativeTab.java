package barryflash.superheroes.client;

import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.init.ModBlocks;
import barryflash.superheroes.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TypicalHeroesMachinesCreativeTab extends CreativeTabs{
	public TypicalHeroesMachinesCreativeTab() {
		super("thmachines");
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Item.getItemFromBlock(ModBlocks.SUITMAKER_BLOCK));
	}

	@Override
	public boolean hasSearchBar() {
		return false;
	}

}
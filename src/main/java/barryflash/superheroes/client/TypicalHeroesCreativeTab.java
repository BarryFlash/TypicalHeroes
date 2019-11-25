package barryflash.superheroes.client;

import barryflash.superheroes.Reference;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TypicalHeroesCreativeTab extends CreativeTabs {

		
	public TypicalHeroesCreativeTab() {
		super("thsuits");
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.IronManArcReactor);
	}
	
	@Override
	public boolean hasSearchBar() {
		return false;
	}

}

package barryflash.superheroes.client;

import barryflash.superheroes.Reference;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TypicalHeroesWeaponsCreativeTab extends CreativeTabs {

		
	public TypicalHeroesWeaponsCreativeTab() {
		super("thweapons");
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.cap_shield);
	}
	
	@Override
	public boolean hasSearchBar() {
		return false;
	}

}

package barryflash.superheroes.client;

import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TypicalHeroesMaterialsCreativeTab extends CreativeTabs{
	public TypicalHeroesMaterialsCreativeTab() {
		super("thmaterials");
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.VIBRANIUM);
	}

	@Override
	public boolean hasSearchBar() {
		return false;
	}

}
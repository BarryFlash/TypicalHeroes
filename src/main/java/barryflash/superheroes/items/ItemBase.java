package barryflash.superheroes.items;

import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {
	public ItemBase(String name, CreativeTabs tab) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		ModItems.ITEMS.add(this);
		
	}
	@Override
	public void registerModels() {
		SuperheroesMod.proxy.registerItemRenderer(this,0,"inventory");	
	}

}

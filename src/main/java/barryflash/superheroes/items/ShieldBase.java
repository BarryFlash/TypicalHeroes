package barryflash.superheroes.items;

import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.util.IHasModel;
import net.minecraft.item.ItemShield;

public class ShieldBase extends ItemShield implements IHasModel{
	public ShieldBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		
		ModItems.ITEMS.add(this);
	}
	@Override
	public void registerModels() {
		SuperheroesMod.proxy.registerItemRenderer(this,0,"inventory");	
	}
}

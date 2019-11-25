package barryflash.superheroes.items;

import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.util.IHasModel;
import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword implements IHasModel {
	public ToolSword(String name, ToolMaterial material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(SuperheroesMod.weaponscreativeTab);
		
		ModItems.ITEMS.add(this);
	}
	@Override
	public void registerModels() {
		SuperheroesMod.proxy.registerItemRenderer(this,0,"inventory");	
	}
}

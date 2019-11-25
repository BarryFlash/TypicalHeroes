package barryflash.superheroes.items;

import barryflash.superheroes.SuperheroesMod;
import net.minecraft.item.Item;

public class ItemScrapMetal extends Item {
	public ItemScrapMetal(String unlocalizedName, String registryName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(registryName);
		this.setCreativeTab(SuperheroesMod.creativeTab);
	}
}

package barryflash.superheroes.items;

import barryflash.superheroes.SuperheroesMod;
import net.minecraft.item.Item;

public class ItemBlackDiamond extends Item{
	public ItemBlackDiamond(String unlocalizedName, String registryName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(registryName);
		this.setCreativeTab(SuperheroesMod.creativeTab);
	}
}


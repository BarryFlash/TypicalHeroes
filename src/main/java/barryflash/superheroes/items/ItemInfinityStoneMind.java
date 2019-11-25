package barryflash.superheroes.items;

import barryflash.superheroes.SuperheroesMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemInfinityStoneMind extends Item {
	
	public ItemInfinityStoneMind(String unlocalizedName, String registryName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(registryName);
		this.setCreativeTab(SuperheroesMod.creativeTab);
		this.maxStackSize = 1;
	}
	
}

package barryflash.superheroes.items;

import java.util.List;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemWonderWomanGodkiller extends ToolSword {
	
	public ItemWonderWomanGodkiller(String name, ToolMaterial material) {
		super(name, material);
		// TODO Auto-generated constructor stub
	}
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
	{
	return itemstack;
	}


}

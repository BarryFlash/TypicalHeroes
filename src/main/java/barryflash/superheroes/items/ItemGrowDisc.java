package barryflash.superheroes.items;

import java.util.List;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.entities.projectiles.EntityGrowDisc;
import barryflash.superheroes.entities.projectiles.EntityMissile;
import barryflash.superheroes.entities.projectiles.EntityShrinkDisc;
import barryflash.superheroes.entities.projectiles.EntityStormbreaker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemGrowDisc extends Item {
	public ItemGrowDisc(String unlocalizedName, String registryName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(registryName);
		this.setCreativeTab(SuperheroesMod.creativeTab);
		
	
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player,
			EnumHand hand) {
		EntityGrowDisc projectile = new EntityGrowDisc(world, player);
	    if (!world.isRemote) {
			projectile.setHeadingFromThrower(player, player.rotationPitch, player.rotationYawHead, 0.0F, 0.0F);


			world.spawnEntity(projectile);
	    }
		return super.onItemRightClick(world, player, hand);
	}
	

}

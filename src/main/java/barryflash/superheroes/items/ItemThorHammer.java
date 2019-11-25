package barryflash.superheroes.items;

import java.util.List;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.entities.projectiles.EntityMissile;
import barryflash.superheroes.entities.projectiles.EntityMjolnir;
import barryflash.superheroes.entities.projectiles.EntityStormbreaker;
import barryflash.superheroes.items.armor.ItemCaptainAmericaArmor;
import barryflash.superheroes.items.armor.ItemThorArmor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemThorHammer extends ToolSword {
	public ItemThorHammer(String name, ToolMaterial material) {
		super(name, material);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player,
			EnumHand hand) {
		if (ItemThorArmor.isWearingFullSet(player) && player.isSneaking()) {
		EntityMjolnir projectile = new EntityMjolnir(world, player);
	    if (!world.isRemote) {
			projectile.setHeadingFromThrower(player, player.rotationPitch, player.rotationYawHead, 0, 0.0F);
			world.spawnEntity(projectile);
	    }
	    if (player.getHeldItemOffhand().getItem() == this && player.getHeldItemMainhand().getItem() != this) {
	    	player.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, ItemStack.EMPTY);
	    }
	    else if (player.getHeldItemMainhand().getItem() == this) {
	    player.inventory.removeStackFromSlot(player.inventory.currentItem);
	    }
		}
		return super.onItemRightClick(world, player, hand);
	}


}

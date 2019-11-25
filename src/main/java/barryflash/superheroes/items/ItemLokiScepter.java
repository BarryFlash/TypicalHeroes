package barryflash.superheroes.items;

import java.util.List;

import barryflash.superheroes.entities.projectiles.EntityMjolnir;
import barryflash.superheroes.entities.projectiles.EntityScepterBlast;
import barryflash.superheroes.items.armor.ItemThorArmor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemLokiScepter extends ToolSword {

	public ItemLokiScepter(String name, ToolMaterial material) {
		super(name, material);
		// TODO Auto-generated constructor stub
	}


	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player,
			EnumHand hand) {
		EntityScepterBlast projectile = new EntityScepterBlast(world, player);
	    if (!world.isRemote) {
			projectile.setHeadingFromThrower(player, player.rotationPitch, player.rotationYawHead, 0, 0.0F);
			world.spawnEntity(projectile);
	    }
		
		return super.onItemRightClick(world, player, hand);
	}
	

}

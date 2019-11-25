package barryflash.superheroes.items;

import org.lwjgl.input.Keyboard;

import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.capabilities.BatmanProvider;
import barryflash.superheroes.capabilities.IBatman;
import barryflash.superheroes.entities.projectiles.EntityBatmanGrappleHook;
import barryflash.superheroes.util.Utils;
import net.java.games.input.Mouse;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemBatmanGrapplingGun extends ItemBase {
	
	
	public ItemBatmanGrapplingGun(String name) {
		super(name, SuperheroesMod.weaponscreativeTab);
		// TODO Auto-generated constructor stub
	}
	private int function;
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player,
			EnumHand hand) {
		IBatman batcap = player.getCapability(BatmanProvider.BATMAN_CAP, null);
		batcap.shootGrapple();
		RayTraceResult result = Utils.getMouseOverExtended(50);
			if (result.typeOfHit == result.typeOfHit.ENTITY) {
				Entity ent = result.entityHit;
				batcap.setGrappleEntity(ent);
				batcap.setGrappleType("entity");
				batcap.setGrappleEndVec(ent.getPositionVector());
				

			} else if (result.typeOfHit == result.typeOfHit.BLOCK) {
				batcap.setGrappleType("block");
				Vec3d block = result.hitVec;
				batcap.setGrappleEndVec(block);
				
			} else if (result.typeOfHit == result.typeOfHit.MISS) {
				batcap.setGrappleType("miss");
				float distance = 50;
				Vec3d vec3 = Vec3d.fromPitchYaw(player.rotationPitch, player.rotationYaw);
				double x = player.posX + (distance *vec3.x);
				double y = player.posY + player.getEyeHeight() + (distance *vec3.y);
				double z = player.posZ + (distance *vec3.z);
				Vec3d vector = new Vec3d(x, y, z);
				batcap.setGrappleEndVec(vector);
			}
		
		return super.onItemRightClick(worldIn, player, hand);
	}
}

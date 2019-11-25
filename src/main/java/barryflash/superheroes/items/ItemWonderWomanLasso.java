package barryflash.superheroes.items;

import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.entities.projectiles.EntityLassoWhip;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemWonderWomanLasso extends Item {



	public ItemWonderWomanLasso(String unlocalizedName, String registryName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(registryName);
		this.setCreativeTab(SuperheroesMod.creativeTab);
		this.setMaxStackSize(1);

	}



	@Override

	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {

	

			if (!world.isRemote) {

				EntityLassoWhip projectile = new EntityLassoWhip(world, player);

				projectile.shoot(projectile.motionX, projectile.motionY, projectile.motionZ, 5F, 0F);

			

				world.spawnEntity(projectile);

			
			}
		

		return super.onItemRightClick(world, player, hand);
			

	}



	@Override

	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {

		return true;

	}



	@Override

	public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player) {

		return false;

	}


}

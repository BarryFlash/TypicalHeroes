package barryflash.superheroes.items;

import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.client.InventoryHandler;
import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarang;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarangExplosive;
import barryflash.superheroes.entities.projectiles.EntitySteveTrevorRifleBullet;
import barryflash.superheroes.init.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemBatmanBatarangExplosive extends Item{
	public ItemBatmanBatarangExplosive(String unlocalizedName, String registryName) {
		this.setFull3D();
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(registryName);
		this.setCreativeTab(SuperheroesMod.creativeTab);
		this.maxStackSize = 16;

	}/*
	@Override

	public ActionResult<ItemStack> onItemRightClick(ItemStack itemstack, World world, EntityPlayer player, EnumHand hand) {

		if(this.hasAmmo(world, player)) {
			if(!world.isRemote) {

				EntityBatmanBatarangExplosive projectile = new EntityBatmanBatarangExplosive(world, player);
				  
				projectile.setAim(player, player.rotationPitch, player.rotationYaw, 0.0F, 2F, 0.0F);

				world.spawnEntityInWorld(projectile);
				
				world.tick();
				

			}
		}
		
		return super.onItemRightClick(itemstack, world, player, hand);

	}
	


	@Override

	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {

		return true;

	}



	@Override

	public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player) {

		return false;

	}
	public boolean hasAmmo(World world, EntityPlayer player) {

		if(player.capabilities.isCreativeMode) {

			return true;

		}



		if(InventoryHandler.playerHas(getAmmo(), player)) {

			ItemStack ammoStack = player.inventory.getStackInSlot(InventoryHandler.getSlotForItemIn(getAmmo(), player.inventory));



			if(ammoStack != null && ammoStack.getItem() != null) {

				if(ammoStack.getItemDamage() < ammoStack.getMaxDamage()) {

					ammoStack.damageItem(1, player);

				} else {

					InventoryHandler.consumeItem(player, ammoStack.getItem());

				}



				return true;

			}

		}

		return false;

	}



	public Item getAmmo() {

		return ModItems.batman_batarang_explosive;

	}*/

}



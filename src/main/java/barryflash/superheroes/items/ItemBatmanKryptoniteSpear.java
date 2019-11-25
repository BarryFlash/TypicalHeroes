package barryflash.superheroes.items;

import java.util.List;

import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.client.InventoryHandler;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarang;
import barryflash.superheroes.entities.projectiles.EntityBatmanKryptoniteSpear;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.init.ModTools;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemBatmanKryptoniteSpear extends ItemSword {
	public ItemBatmanKryptoniteSpear(ToolMaterial material, String unlocalizedName, String registryName) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(registryName);
		this.setCreativeTab(SuperheroesMod.creativeTab);
		
		
	
	}/*
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
	{
	return itemstack;
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World world, EntityPlayer player,
			EnumHand hand) {
		if (this.hasAmmo(world, player)) {
		EntityArrow projectile = new EntityBatmanKryptoniteSpear(world, player);
		projectile.setAim(player, player.rotationPitch, player.rotationYaw, 0.0F, 1F, 0.0F);

		

		world.spawnEntityInWorld(projectile);

		world.tick();	
		}
		return super.onItemRightClick(itemStackIn, world, player, hand);
	}
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par2List, boolean par4)
	{
	par2List.add("\u00A78" + "Used ONLY by Batman");
	par2List.add("\u00A7a" + "Weak to kryptonians");
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

		return ModTools.batman_kryptonitespear;

	}*/
}

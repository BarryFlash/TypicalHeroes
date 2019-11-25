package barryflash.superheroes.items;

import java.util.List;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.capabilities.AquamanProvider;
import barryflash.superheroes.capabilities.IAquaman;
import barryflash.superheroes.client.InventoryHandler;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarang;
import barryflash.superheroes.entities.projectiles.EntityTrident;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.init.ModTools;
import barryflash.superheroes.items.armor.ItemAquamanArmor;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.item.Item.ToolMaterial;

public class ItemAquamanTrident extends ItemSword {
	
	public ItemAquamanTrident(ToolMaterial material, String unlocalizedName, String registryName) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(registryName);
		this.setCreativeTab(SuperheroesMod.creativeTab);
		
	
	}
	/*
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
{
		
		if(this.hasAmmo(world, player)) {

	if (!world.isRemote)
	{
		EntityTrident projectile = new EntityTrident(world, player);

		projectile.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0.0F, 0.0F);
	}
	}
	return itemStack;
	}
	private boolean selected = false;
	private int check = 0;
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (ItemAquamanArmor.isWearingFullSet(player, ModArmor.AquamanChest, ModArmor.AquamanLeggings, ModArmor.AquamanBoots)) {
			IAquaman aquamancap = player.getCapability(AquamanProvider.AQUAMAN_CAP, null);	
			if (player.isSneaking()) {
				System.out.println("selected source: " + world.getBlockState(pos));
				if (world.getBlockState(pos) == Blocks.SAND.getDefaultState()) {
					
					aquamancap.setsourcePos(pos);
				}
			}
		}
			
		return super.onItemUse(stack, player, world, pos, hand, facing, hitX, hitY, hitZ);
	}
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par2List, boolean par4)
	{
	par2List.add("\u00A72" + "Used ONLY by Aquaman");
	par2List.add("\u00A76" + "Needed for most abilities");
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

		return ModTools.aquaman_trident;

	}*/

}



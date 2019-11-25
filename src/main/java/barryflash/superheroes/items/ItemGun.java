package barryflash.superheroes.items;

import java.util.List;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.entities.projectiles.EntityBullet;
import barryflash.superheroes.entities.projectiles.EntityMissile;
import barryflash.superheroes.entities.projectiles.EntityMjolnir;
import barryflash.superheroes.entities.projectiles.EntityStormbreaker;
import barryflash.superheroes.items.armor.ItemBlackWidowArmor;
import barryflash.superheroes.items.armor.ItemCaptainAmericaArmor;
import barryflash.superheroes.items.armor.ItemHawkeyeArmor;
import barryflash.superheroes.items.armor.ItemThorArmor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemGun extends ItemBase {
	

	
	public ItemGun(String name) {
		super(name, SuperheroesMod.weaponscreativeTab);
	}
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		super.onCreated(stack, worldIn, playerIn);
		
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player,
			EnumHand hand) {
		ItemStack stack = player.getHeldItem(hand);
		if (stack.hasTagCompound() && stack.getTagCompound().hasKey("Bullets") && stack.getTagCompound().hasKey("Reload")) {
			if (player.isSneaking()) {
				stack.getTagCompound().setBoolean("Reload", true);
			} else {
	    
	    	
	    	if (stack.getTagCompound().getBoolean("Reload") == false) {
	    		if (stack.getTagCompound().getInteger("Bullets") > 0) {
	    			EntityBullet projectile = new EntityBullet(world, player);
			    	if (!world.isRemote) {
			    	
			    	if (hand == hand.OFF_HAND) {
			    		projectile.setLeft(true);
				    	if (ItemBlackWidowArmor.isWearingFullSet(player) || ItemHawkeyeArmor.isWearingFullSet(player)) {
						projectile.setHeadingFromThrower(player, player.rotationPitch, player.rotationYawHead, 0, 0.0F);
				    	} else {
				    		projectile.setHeadingFromThrower(player, player.rotationPitch, player.rotationYawHead, 0, 7.0F);
				    	}
			    	} else {
			    		projectile.setLeft(false);
			    		if (ItemBlackWidowArmor.isWearingFullSet(player) || ItemHawkeyeArmor.isWearingFullSet(player)) {
							projectile.setHeadingFromThrower(player, player.rotationPitch, player.rotationYawHead, 0, 0.0F);
					    } else {
					    	projectile.setHeadingFromThrower(player, player.rotationPitch, player.rotationYawHead, 0, 7.0F);
					    }
			    	}
					world.spawnEntity(projectile);
					
					stack.getTagCompound().setInteger("Bullets", stack.getTagCompound().getInteger("Bullets") - 1);
					
					}
			    	world.playSound(player.posX, player.posY, player.posZ, THSoundHandler.PISTOL_SHOT, SoundCategory.PLAYERS, 1, 1, true);
			    }
	    	}
		}
		}
		return super.onItemRightClick(world, player, hand);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
		// TODO Auto-generated method stub
		super.onUpdate(stack, world, entity, itemSlot, isSelected);
		NBTTagCompound nbt;
	    if (stack.hasTagCompound())
	    {
	        nbt = stack.getTagCompound();
	    }
	    else
	    {
	        nbt = new NBTTagCompound();
	    }
	    if (!nbt.hasKey("Bullets"))
	    {
	        nbt.setInteger("Bullets", 8);
	    }
	    if (!nbt.hasKey("Reload"))
	    {
	        nbt.setBoolean("Reload", false);
	    }
	    if (!nbt.hasKey("ReloadTicks"))
	    {
	        nbt.setInteger("ReloadTicks", 0);
	    }
	    stack.setTagCompound(nbt);
		if (stack.hasTagCompound() && stack.getTagCompound().hasKey("Bullets") && stack.getTagCompound().hasKey("ReloadTicks") && stack.getTagCompound().hasKey("Reload")) {
    		if (stack.getTagCompound().getBoolean("Reload")) {
    			if (stack.getTagCompound().getInteger("ReloadTicks") < 50) {
    				stack.getTagCompound().setInteger("ReloadTicks", stack.getTagCompound().getInteger("ReloadTicks") + 1);
    				if (stack.getTagCompound().getInteger("ReloadTicks") == 10) {
    					world.playSound(entity.posX, entity.posY, entity.posZ, THSoundHandler.PISTOL_RELOAD, SoundCategory.PLAYERS, 1, 1, true);
    				}
    			} else {
    				stack.getTagCompound().setBoolean("Reload", false);
    				stack.getTagCompound().setInteger("ReloadTicks", 0);
    				stack.getTagCompound().setInteger("Bullets", 8);
    				
    			}
    		}
    		if (stack.getTagCompound().getInteger("Bullets") == 0) {
    			stack.getTagCompound().setBoolean("Reload", true);
    		}
		  
		}
	}
	

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par2List, boolean par4)
	{
	par2List.add("\u00A76" + "Better accuracy with Sharpshooter suit");
	}

}

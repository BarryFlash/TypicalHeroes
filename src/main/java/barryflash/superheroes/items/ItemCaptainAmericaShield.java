package barryflash.superheroes.items;

import java.util.List;

import javax.annotation.Nullable;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.entities.projectiles.EntityCaptainAmericaShield;
import barryflash.superheroes.entities.projectiles.EntityMissile;
import barryflash.superheroes.entities.projectiles.EntityMjolnir;
import barryflash.superheroes.entities.projectiles.EntityStormbreaker;
import barryflash.superheroes.items.armor.ItemCaptainAmericaArmor;
import net.minecraft.block.BlockDispenser;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCaptainAmericaShield extends ToolSword {
	public ItemCaptainAmericaShield(String name, ToolMaterial material) {
		super(name, material);
		// TODO Auto-generated constructor stub
		this.addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, ItemArmor.DISPENSER_BEHAVIOR);
	}
	@Override
	public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BLOCK;
    }
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
    {
        return 72000;
    }
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player,
			EnumHand hand) {
		 
		if (ItemCaptainAmericaArmor.isWearingFullSet(player)) {
			if (player.isSneaking()) {
			EntityCaptainAmericaShield projectile = new EntityCaptainAmericaShield(world, player);
		    if (!world.isRemote) {
				projectile.setHeadingFromThrower(player, player.rotationPitch, player.rotationYawHead, 0, 0.0F);
				world.spawnEntity(projectile);
		    }
		    player.world.playSound(player, player.getPosition(), THSoundHandler.SHIELD_THROW, SoundCategory.PLAYERS, 0.4F, 1.0F);
		    if (player.getHeldItemOffhand().getItem() == this && player.getHeldItemMainhand().getItem() != this) {
		    	player.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, ItemStack.EMPTY);
		    }
		    else if (player.getHeldItemMainhand().getItem() == this) {
		    player.inventory.removeStackFromSlot(player.inventory.currentItem);
		    }
			} else {
				 ItemStack itemstack = player.getHeldItem(hand);
			        player.setActiveHand(hand);
			        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
			}
		}
		return super.onItemRightClick(world, player, hand);
	}
	

}

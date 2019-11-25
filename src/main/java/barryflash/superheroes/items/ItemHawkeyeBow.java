package barryflash.superheroes.items;

import javax.annotation.Nullable;

import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.capabilities.IQuiver;
import barryflash.superheroes.capabilities.ISpecialEffects;
import barryflash.superheroes.capabilities.QuiverProvider;
import barryflash.superheroes.capabilities.SpecialEffectsProvider;
import barryflash.superheroes.entities.projectiles.EntityTrickArrow;
import barryflash.superheroes.entities.projectiles.EntityTrickArrowElectric;
import barryflash.superheroes.entities.projectiles.EntityTrickArrowExplosive;
import barryflash.superheroes.entities.projectiles.EntityTrickArrowFreeze;
import barryflash.superheroes.entities.projectiles.EntityTrickArrowGrapple;
import barryflash.superheroes.entities.projectiles.EntityTrickArrowKryptonite;
import barryflash.superheroes.entities.projectiles.EntityTrickArrowSmoke;
import barryflash.superheroes.entities.projectiles.EntityTrickArrowTranquilizer;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemHawkeyeArmor;
import barryflash.superheroes.network.MessageQuiverSendToClient;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.util.IHasModel;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemHawkeyeBow extends ItemBow implements IHasModel {

	
	public ItemHawkeyeBow(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		
		ModItems.ITEMS.add(this);
		setCreativeTab(SuperheroesMod.weaponscreativeTab);
		this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter()
		{
		@SideOnly(Side.CLIENT)
		public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
		{
		if (entityIn == null)
		{
		return 0.0F;
		}
		else
		{
			ItemStack itemstack = entityIn.getActiveItemStack();


			 
            return itemstack != null && itemstack.getItem() == ModItems.hawkeye_bow ? (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F : 0.0F;
		}
		}
		});
		this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter()
		{
		@SideOnly(Side.CLIENT)
		public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
		{
		return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
		}
		});
		this.addPropertyOverride(new ResourceLocation("type"), new IItemPropertyGetter()
		{
		@SideOnly(Side.CLIENT)
		public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
		{
		if (entityIn == null)
		{
		return 0.0F;
		}
		else
		{
			ItemStack itemstack = entityIn.getActiveItemStack();


			 
            if (itemstack != null && itemstack.getItem() == ModItems.hawkeye_bow  && (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F > 0) {
            	if (entityIn instanceof EntityPlayer) {
            		IQuiver qcap = entityIn.getCapability(QuiverProvider.QUIVER_CAP, null);
            	if (qcap.getArrowSelected() == 0) {
            		return 0.0F;
            	} else if (qcap.getArrowSelected() == 1) {
            		return 0.1F;
            	} else if (qcap.getArrowSelected() == 2) {
            		return 0.2F;
            	} else if (qcap.getArrowSelected() == 3) {
            		return 0.3F;
            	} else if (qcap.getArrowSelected() == 4) {
            		return 0.4F;
            	} else if (qcap.getArrowSelected() == 5) {
            		return 0.5F;
            	} else if (qcap.getArrowSelected() == 6) {
                	return 0.6F;
            	} else if (qcap.getArrowSelected() == 7) {
                 	return 0.7F;
            	} else {
            		return 0.0F;
            	}
            	} else {
            		return 0.0F;
            	}
            } else {
        		return 0.0F;
        	}
		}
		}
		});
	}
	@Override
	public void registerModels() {
		SuperheroesMod.proxy.registerItemRenderer(this,0,"inventory");	
	}
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		IQuiver qcap = playerIn.getCapability(QuiverProvider.QUIVER_CAP, null);

        
        boolean flag = !this.findAmmo(playerIn).isEmpty() || (qcap.isWearingQuiver() && !qcap.isArrowInCooldown(qcap.getArrowSelected()));

        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn, playerIn, handIn, flag);
        if (ret != null) return ret;

        if (!playerIn.capabilities.isCreativeMode && !flag)
        {
            return flag ? new ActionResult(EnumActionResult.PASS, itemstack) : new ActionResult(EnumActionResult.FAIL, itemstack);
        }
        else
        {
            playerIn.setActiveHand(handIn);
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
        }
		
    }

	@Override
	protected boolean isArrow(ItemStack stack) {
		// TODO Auto-generated method stub
		if (stack.getItem() instanceof ItemArrow) {
		return true;
		} else {
			return false;
		}
	}
	private ItemStack findAmmo(EntityPlayer player)
	{
	if (this.isArrow(player.getHeldItem(EnumHand.OFF_HAND)))
	{
	return player.getHeldItem(EnumHand.OFF_HAND);
	}
	else if (this.isArrow(player.getHeldItem(EnumHand.MAIN_HAND)))
	{
	return player.getHeldItem(EnumHand.MAIN_HAND);
	}
	else
	{
	for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
	{
	ItemStack itemstack = player.inventory.getStackInSlot(i);
	if (this.isArrow(itemstack))
	{
	return itemstack;
	}
	}
	return ItemStack.EMPTY;
	}
	}
	
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft)
	{
	if (entityLiving instanceof EntityPlayer)
	{
	EntityPlayer entityplayer = (EntityPlayer)entityLiving;
	IQuiver qcap = entityplayer.getCapability(QuiverProvider.QUIVER_CAP, null);
	boolean flag = entityplayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;//flag is true if no arrows are to be consumed
	ItemStack itemstack = this.findAmmo(entityplayer);//looks for ammo (see above)
	int i = this.getMaxItemUseDuration(stack) - timeLeft;//the time that it has been used for
	i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, entityplayer, i, !itemstack.isEmpty() || flag || qcap.isWearingQuiver());
	if (i < 0) return;
	if (!itemstack.isEmpty() || flag || qcap.isWearingQuiver())
	{
		
	if (itemstack.isEmpty() && !qcap.isWearingQuiver())
	{
	itemstack = new ItemStack(Items.ARROW);
	}
	float f = getArrowVelocity(i);
	if ((double)f >= 0.1D)//if the velocity is lower than this, it does not fire
	{
	boolean flag1 = entityplayer.capabilities.isCreativeMode || (itemstack.getItem() instanceof ItemArrow && ((ItemArrow) itemstack.getItem()).isInfinite(itemstack, stack, entityplayer) || qcap.isWearingQuiver());
	if (!worldIn.isRemote)
	{
		EntityArrow entityarrow = null;
		if (qcap.isWearingQuiver()) {
			if (qcap.getArrowSelected() == 0) {
			entityarrow = new EntityTrickArrow(worldIn, entityplayer);
			} else if (qcap.getArrowSelected() == 1) {
				entityarrow = new EntityTrickArrowExplosive(worldIn, entityplayer);
			} else if (qcap.getArrowSelected() == 2) {
				entityarrow = new EntityTrickArrowElectric(worldIn, entityplayer);
			} else if (qcap.getArrowSelected() == 3) {
				entityarrow = new EntityTrickArrowSmoke(worldIn, entityplayer);
			} else if (qcap.getArrowSelected() == 4) {
				entityarrow = new EntityTrickArrowGrapple(worldIn, entityplayer);
			} else if (qcap.getArrowSelected() == 5) {
				entityarrow = new EntityTrickArrowKryptonite(worldIn, entityplayer);
			} else if (qcap.getArrowSelected() == 6) {
				entityarrow = new EntityTrickArrowFreeze(worldIn, entityplayer);
			} else if (qcap.getArrowSelected() == 7) {
				entityarrow = new EntityTrickArrowTranquilizer(worldIn, entityplayer);
			}
		} else {
			ItemArrow itemarrow = (ItemArrow)(itemstack.getItem() instanceof ItemArrow ? itemstack.getItem() : Items.ARROW);
			entityarrow = itemarrow.createArrow(worldIn, itemstack, entityplayer);//creates the arrow entity
		}
		if (ItemHawkeyeArmor.isWearingFullSet(entityplayer)) {
			entityarrow.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 5.0F/*velocity*/, 0.0F/*inaccuracy*/);
		} else {
			entityarrow.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 3.0F/*velocity*/, 2.0F/*inaccuracy*/);
		}
		if (qcap.isWearingQuiver()) {
			qcap.setCooldownBoolForArrow(qcap.getArrowSelected(), true);
			NetworkHandler.sendTo(new MessageQuiverSendToClient(entityplayer.getEntityId(), qcap.getArrowSelected(), true), (EntityPlayerMP) entityplayer);
		}
	if (f == 1.0F)
	{
	entityarrow.setIsCritical(true);//arrow entity does more damage
	}
	int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
	if (j > 0)
	{
	entityarrow.setDamage(entityarrow.getDamage() + (double)j * 0.5D + 0.5D);//adds damage to arrow entity
	}
	int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
	if (k > 0)
	{
	entityarrow.setKnockbackStrength(k);//adds knockback
	}
	if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0)
	{
	entityarrow.setFire(100);//adds fire
	}
	stack.damageItem(1, entityplayer);//damages bow
	if (flag1 || entityplayer.capabilities.isCreativeMode && (itemstack.getItem() == Items.SPECTRAL_ARROW || itemstack.getItem() == Items.TIPPED_ARROW))
	{
	entityarrow.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;//prevents survival players from picking up the arrow
	}
	
	worldIn.spawnEntity(entityarrow);
	}
	worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);//plays the shooting sound
	if (!flag1 && !entityplayer.capabilities.isCreativeMode)
	{
	itemstack.shrink(1);//removes the arrow
	if (itemstack.isEmpty())
	{
	entityplayer.inventory.deleteStack(itemstack);
	}
	}
	entityplayer.addStat(StatList.getObjectUseStats(this));//adds stat
	}
	}
	}
	}

}

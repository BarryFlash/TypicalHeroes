package barryflash.superheroes.items;

import javax.annotation.Nullable;

import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.capabilities.IThanos;
import barryflash.superheroes.capabilities.ThanosProvider;
import barryflash.superheroes.client.gui.GuiHandler;
import barryflash.superheroes.client.gui.container.InventoryInfinityGauntlet;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.IItemHandler;

public class ItemThanosGauntlet extends Item {
	
	@CapabilityInject(IItemHandler.class)
    public static Capability<IItemHandler> ITEM_HANDLER;
	
	public ItemThanosGauntlet(String unlocalizedName, String registryName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(registryName);
		this.setCreativeTab(SuperheroesMod.creativeTab);
		this.maxStackSize = 1;
	}
	  @Override

	    public ICapabilityProvider initCapabilities(final ItemStack stack, NBTTagCompound nbt)

	    {

	        return new ICapabilityProvider()

	        {

	            final InventoryInfinityGauntlet itemHandler = new InventoryInfinityGauntlet(6, stack);



	            @Override

	            public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing)

	            {

	                if (capability == ITEM_HANDLER)

	                    return true;

	               

	                return false;

	            }



	            @SuppressWarnings("unchecked")

	            @Nullable

	            @Override

	            public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing)

	            {

	                if (capability == ITEM_HANDLER)

	                    return (T) itemHandler;

	               
	                return null;

	            }

	        };

	    }
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 1;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		
			
			
				//player.openGui(SuperheroesMod.instance, GUIHandler.INFINITY_GAUNTLET, world, 0, 0, 0);
			
			
		return new ActionResult(EnumActionResult.SUCCESS, player.getHeldItem(hand));
	}

}

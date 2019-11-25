package barryflash.superheroes.container;

import barryflash.superheroes.tileentities.TileSuitMaker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerSuitMakerMenu extends Container {
	private TileSuitMaker te;
	public ContainerSuitMakerMenu(IInventory playerInv, TileSuitMaker te) {
		this.te = te;


		
		
		
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return !player.isSpectator();
	}
	

}

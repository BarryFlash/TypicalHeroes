package barryflash.superheroes.client.render;

import barryflash.superheroes.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class IronmanEvent {

	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) {
	 if (event.getEntity() instanceof EntityPlayer) {
		 EntityPlayer player = (EntityPlayer) event.getEntity();
		 if (player.inventory.armorItemInSlot(2) == new ItemStack(ModItems.IronManArcReactor)) {
			 player.inventory.armorInventory.add(1, new ItemStack(ModItems.IronManMk50Helmet));
			 player.inventory.armorInventory.add(2, new ItemStack(ModItems.IronManMk50Chest));
			 player.inventory.armorInventory.add(3, new ItemStack(ModItems.IronManMk50Legs));
			 player.inventory.armorInventory.add(4, new ItemStack(ModItems.IronManMk50Boots));
		 }
	 }
	}
}

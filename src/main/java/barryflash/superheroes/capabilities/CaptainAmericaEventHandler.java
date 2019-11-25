package barryflash.superheroes.capabilities;

import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemCaptainAmericaArmor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CaptainAmericaEventHandler {

	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			if (player.world.isRemote) {
			if (ItemCaptainAmericaArmor.isWearingFullSet(player)) {
				ICaptainAmerica captaincap = player.getCapability(CaptainAmericaProvider.CAPTAINAMERICA_CAP, null);
				if (player.inventory.getCurrentItem().getItem() == ModItems.cap_shield) {
					if (!captaincap.isHoldingShield()) {
						captaincap.setShield(true);
					}
				} else {
					if (captaincap.isHoldingShield()) {
						captaincap.setShield(false);
					}
				}
				}
			}
		}
	}
}

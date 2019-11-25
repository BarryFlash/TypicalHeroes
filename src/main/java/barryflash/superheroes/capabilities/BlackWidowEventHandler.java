package barryflash.superheroes.capabilities;

import barryflash.superheroes.network.MessageCapToServer;
import barryflash.superheroes.network.NetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class BlackWidowEventHandler {

	@SubscribeEvent
	public void onLiving(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			IBlackWidow widowcap = player.getCapability(BlackWidowProvider.BLACKWIDOW_CAP, null);
			if (widowcap.getBlasterCooldown()) {
				if (widowcap.getBlasterCooldownInt() < 40) {
					widowcap.increaseBlasterCooldownInt();
				} else {
					widowcap.setBlasterCooldownInt(0);
					widowcap.setBlasterCooldown(false);
				}
			}
		}
		

	}
	@SubscribeEvent
	public void onTick(PlayerTickEvent event) {
		IBlackWidow widowcap = event.player.getCapability(BlackWidowProvider.BLACKWIDOW_CAP, null);
		if (widowcap.isShootingBlaster()) {
			if (widowcap.getArmTicks() < 20) {
			widowcap.increaseArmTick();
			} else {
				widowcap.setArmTick(0);
				widowcap.setShootBlaster(false);
				NetworkHandler.sendToServer(new MessageCapToServer(widowcap.isShootingBlaster(), "widowBite"));
			}
		}
	}
}

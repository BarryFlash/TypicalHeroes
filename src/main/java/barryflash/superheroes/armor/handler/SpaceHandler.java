package barryflash.superheroes.armor.handler;

import barryflash.superheroes.world.commands.DimensionTeleporter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SpaceHandler {

	@SubscribeEvent
	public void onFlyToSpace(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			if (player.dimension == 0) {
		
			if (player.posY > 3000) {
				DimensionTeleporter.teleportToDimension(player, 100, 0, 100, 0);
			
			}
			}
		}
	}
}

package barryflash.superheroes.capabilities;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class FusionChamberEventHandler {

	@SubscribeEvent
	public void onLivingUpdate(PlayerTickEvent event) {
			EntityPlayer player = event.player;
			IFusionChamber fccap = player.getCapability(FusionChamberProvider.FUSION_CHAMBER_CAP, null);
			if (player.world.isRemote) {
			if (fccap.isInside()) {
				player.motionX = 0;
				player.motionY = 0;
				player.motionZ = 0;
				KeyBinding.unPressAllKeys();
			}
		}
	}
}

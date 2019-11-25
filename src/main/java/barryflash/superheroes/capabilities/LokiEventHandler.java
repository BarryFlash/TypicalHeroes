package barryflash.superheroes.capabilities;

import barryflash.superheroes.armor.handler.PlayerModelSwitchEvent;
import barryflash.superheroes.items.armor.ItemLokiArmor;
import barryflash.superheroes.models.ModelHero;
import barryflash.superheroes.network.MessageSetPosition;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LokiEventHandler {
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void renderPlayer(RenderWorldLastEvent event) {
		for (int i = 0; i < Minecraft.getMinecraft().world.playerEntities.size(); i++) {
			EntityPlayer player = Minecraft.getMinecraft().world.playerEntities.get(i);
			ILoki lokicap = player.getCapability(LokiProvider.LOKI_CAP, null);
			
			if (lokicap.isTeleporting()) {
				
			
				if (lokicap.getTeleportingVec() != null) {
				Utils.renderLaser2(lokicap.getTeleportingVec(), lokicap.getTeleportingVec().addVector(0, 5, 0), 0.2F, 0.4F, new float[]{0.2F, 1, 0.2F});
				}
			}
		}
	}
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			ILoki lokicap = player.getCapability(LokiProvider.LOKI_CAP, null);
			if (ItemLokiArmor.isWearingFullSet(player)) {
			if (lokicap.isTeleporting()) {
				RayTraceResult result = Utils.getMouseOverExtended(80);
				if (result.typeOfHit != result.typeOfHit.MISS) {
				lokicap.setTeleportingVec(result.hitVec);
				} else {
					lokicap.setTeleportingVec(null);
				}
				
			}
			if (lokicap.isInvisible()) {
				if (!player.isInvisible()) {
					player.setInvisible(true);
				}
				
			} else {
				if (player.isInvisible()) {
					player.setInvisible(false);
				}
			}
			} else {
				if (lokicap.isInvisible()) {
					player.setInvisible(false);
					lokicap.setInvisible(false);
				}
				if (lokicap.isTeleporting()) {
					lokicap.setTeleport(false);
					lokicap.setTeleportingVec(null);
				}
			} 
		}
	}
}

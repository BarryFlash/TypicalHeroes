package barryflash.superheroes.capabilities;

import barryflash.superheroes.init.ModBlocks;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.network.MessageUpdateZeusAltarCap;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.recipes.SuitRecipes;
import barryflash.superheroes.recipes.ZeusAltarOfferings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

public class ZeusAltarEventHandler {
	@SubscribeEvent
	public void onPlayerClone(PlayerEvent.Clone event) {
		
	 EntityPlayer player = event.getEntityPlayer();

	 IZeusAltar zeusAltar = player.getCapability(ZeusAltarProvider.ZEUS_ALTAR_CAP, null);

	 IZeusAltar oldzeusAltar = event.getOriginal().getCapability(ZeusAltarProvider.ZEUS_ALTAR_CAP, null);
	 zeusAltar.setProgress(oldzeusAltar.getProgress());
	 
	}
	@SubscribeEvent
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		 EntityPlayer player = event.player;
		IZeusAltar zeusAltar = player.getCapability(ZeusAltarProvider.ZEUS_ALTAR_CAP, null);
		if (zeusAltar != null && player != null) {
		NetworkHandler.sendTo(new MessageUpdateZeusAltarCap(zeusAltar.getProgress()), (EntityPlayerMP) player);
		}
	}
	@SubscribeEvent
	public void onPlayerDeath(PlayerLoggedInEvent event) {
		 EntityPlayer player = event.player;
		IZeusAltar zeusAltar = player.getCapability(ZeusAltarProvider.ZEUS_ALTAR_CAP, null);
		NetworkHandler.sendTo(new MessageUpdateZeusAltarCap(zeusAltar.getProgress()), (EntityPlayerMP) player);
	}
	
}

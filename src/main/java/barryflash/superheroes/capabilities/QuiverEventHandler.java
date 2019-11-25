package barryflash.superheroes.capabilities;

import barryflash.superheroes.Reference;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemBatmanArmor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class QuiverEventHandler {

	//private static int[] cooldownAmounts = new int[]{10, 40, 80, 120, 160, 40, 160, 20};
	private static int[] cooldownAmounts = new int[]{10, 40, 80, 120, 160, 40};
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
			IQuiver qcap = player.getCapability(QuiverProvider.QUIVER_CAP, null);
			if (player.inventory.hasItemStack(new ItemStack(ModItems.QUIVER))) {
				if (!qcap.isWearingQuiver()) {
					qcap.setWearingQuiver(true);
				}
			} else {
				if (qcap.isWearingQuiver()) {
					qcap.setWearingQuiver(false);
				}
			}
			if (qcap.isWearingQuiver()) {
				for (int i = 0; i <= qcap.getMaxAmount(); i++) {
					if (qcap.isArrowInCooldown(i)) {
						if (qcap.getCooldownForArrow(i) < cooldownAmounts[i]) {			
							qcap.increaseCooldownForArrow(i);
						} else {
							qcap.setCooldownForArrow(i, 0);
							qcap.setCooldownBoolForArrow(i, false);
						}
					}
				}
			}
		}
	}
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onOverlay(RenderGameOverlayEvent event) {
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			EntityPlayer player = Minecraft.getMinecraft().player;
			IQuiver qcap = player.getCapability(QuiverProvider.QUIVER_CAP, null);
			if (qcap.isWearingQuiver()) {
				int scaledWidth = event.getResolution().getScaledWidth();
				int scaledHeight = event.getResolution().getScaledHeight();
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/quiver_gui.png"));
				Gui.drawModalRectWithCustomSizedTexture(scaledWidth - 48, 2, 0, 0, 46, 38, 256, 256);
				int arrowSelected = qcap.getArrowSelected();
				switch(arrowSelected) {
				case 0:
					Gui.drawModalRectWithCustomSizedTexture(scaledWidth - 34, 9, 3, 41, 24, 24, 256, 256);
					if (qcap.isArrowInCooldown(arrowSelected)) {
					Gui.drawModalRectWithCustomSizedTexture(scaledWidth - 45, 6, 47, 22, 5, 30 - qcap.getCooldownForArrow(arrowSelected)*30/cooldownAmounts[arrowSelected], 256, 256);
					}
					break;
				case 1:
					Gui.drawModalRectWithCustomSizedTexture(scaledWidth - 34, 9, 3, 71, 24, 24, 256, 256);
					if (qcap.isArrowInCooldown(arrowSelected)) {
						Gui.drawModalRectWithCustomSizedTexture(scaledWidth - 45, 6, 47, 22, 5, 30 - qcap.getCooldownForArrow(arrowSelected)*30/cooldownAmounts[arrowSelected], 256, 256);
						}
					break;
				case 2:
					Gui.drawModalRectWithCustomSizedTexture(scaledWidth - 34, 9, 3, 100, 24, 24, 256, 256);
					if (qcap.isArrowInCooldown(arrowSelected)) {
						Gui.drawModalRectWithCustomSizedTexture(scaledWidth - 45, 6, 47, 22, 5, 30 - qcap.getCooldownForArrow(arrowSelected)*30/cooldownAmounts[arrowSelected], 256, 256);
						}
					break;
				case 3:
					Gui.drawModalRectWithCustomSizedTexture(scaledWidth - 34, 9, 4, 190, 24, 24, 256, 256);
					if (qcap.isArrowInCooldown(arrowSelected)) {
						Gui.drawModalRectWithCustomSizedTexture(scaledWidth - 45, 6, 47, 22, 5, 30 - qcap.getCooldownForArrow(arrowSelected)*30/cooldownAmounts[arrowSelected], 256, 256);
						}
					break;
				case 4:
					Gui.drawModalRectWithCustomSizedTexture(scaledWidth - 34, 10, 37, 101, 24, 24, 256, 256);
					if (qcap.isArrowInCooldown(arrowSelected)) {
						Gui.drawModalRectWithCustomSizedTexture(scaledWidth - 45, 6, 47, 22, 5, 30 - qcap.getCooldownForArrow(arrowSelected)*30/cooldownAmounts[arrowSelected], 256, 256);
						}
					break;
				/*case 5:
					Gui.drawModalRectWithCustomSizedTexture(scaledWidth - 34, 9, 3, 159, 24, 24, 256, 256);
					if (qcap.isArrowInCooldown(arrowSelected)) {
						Gui.drawModalRectWithCustomSizedTexture(scaledWidth - 45, 6, 47, 22, 5, 30 - qcap.getCooldownForArrow(arrowSelected)*30/cooldownAmounts[arrowSelected], 256, 256);
						}
					break;
				case 6:
					Gui.drawModalRectWithCustomSizedTexture(scaledWidth - 34, 9, 3, 130, 24, 24, 256, 256);
					if (qcap.isArrowInCooldown(arrowSelected)) {
						Gui.drawModalRectWithCustomSizedTexture(scaledWidth - 45, 6, 47, 22, 5, 30 - qcap.getCooldownForArrow(arrowSelected)*30/cooldownAmounts[arrowSelected], 256, 256);
						}
					break;
				case 7:
					Gui.drawModalRectWithCustomSizedTexture(scaledWidth - 34, 9, 4, 218, 24, 24, 256, 256);
					if (qcap.isArrowInCooldown(arrowSelected)) {
						Gui.drawModalRectWithCustomSizedTexture(scaledWidth - 45, 6, 47, 22, 5, 30 - qcap.getCooldownForArrow(arrowSelected)*30/cooldownAmounts[arrowSelected], 256, 256);
						}
					break;*/
				}
				
			}
		}
	}
	
}

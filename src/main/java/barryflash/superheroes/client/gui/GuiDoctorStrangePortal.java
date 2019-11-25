package barryflash.superheroes.client.gui;

import barryflash.superheroes.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GuiDoctorStrangePortal extends Gui {
	private final ResourceLocation invis = new ResourceLocation(Reference.MODID, "textures/gui/doctorstrange_portal.png");
	private final int tex_width = 256, tex_height = 256, gui_width = 100, gui_height = 100;
	@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent event) {
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			Minecraft mc = Minecraft.getMinecraft();
			mc.renderEngine.bindTexture(invis);
			drawTexturedModalRect(0, 0, 0, 0, tex_width, tex_height);
		}
	}
}

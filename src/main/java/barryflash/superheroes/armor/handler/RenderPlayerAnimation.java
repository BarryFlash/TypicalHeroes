package barryflash.superheroes.armor.handler;

import org.lwjgl.input.Keyboard;

//import barryflash.superheroes.client.render.RenderEntityPlayer;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RenderPlayerAnimation {
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onEvent(RenderPlayerEvent.Pre event) {
		
		if (ItemWonderWomanArmor.isWearingFullSet(event.getEntityPlayer(), ModItems.WonderWomanTiara, ModItems.WonderWomanChestplate, ModItems.WonderWomanSkirt, ModItems.WonderWomanBoots)) {
	       if (Keyboard.isKeyDown(Keyboard.KEY_F)) {
	    	   RenderManager manager = Minecraft.getMinecraft().getRenderManager();
	    	
	       }
		}
	}
}

package barryflash.superheroes.armor.handler;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBiped.ArmPose;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import barryflash.superheroes.models.ModelWonderWoman;
import barryflash.superheroes.util.Helper;

public class WonderWomanTiaraRender {
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onEvent(RenderPlayerEvent.Pre event) {
		
		if (ItemWonderWomanArmor.isWearingFullSet(event.getEntityPlayer(), ModItems.WonderWomanTiara, ModItems.WonderWomanChestplate, ModItems.WonderWomanSkirt, ModItems.WonderWomanBoots)) {
	       if (Keyboard.isKeyDown(Keyboard.KEY_R)) {
	    	   EntityPlayer player = event.getEntityPlayer();
	    	 
	  
			
	       }
		}
	}
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onEvent(RenderPlayerEvent.Post event) {
		if (ItemWonderWomanArmor.isWearingFullSet(event.getEntityPlayer(), ModItems.WonderWomanTiara, ModItems.WonderWomanChestplate, ModItems.WonderWomanSkirt, ModItems.WonderWomanBoots)) {
		       if (Keyboard.isKeyDown(Keyboard.KEY_R)) {
		    	  
		       }
		}
	}
}
	  
	
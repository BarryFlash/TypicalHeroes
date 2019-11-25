package barryflash.superheroes.armor.handler;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import net.minecraft.client.model.ModelBiped.ArmPose;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WonderWomanBraceletsAnimation {
	/*private float Y = 2.0F;
	private float X;
	private float Z;
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onEvent(RenderPlayerEvent.Pre event) {
		
		if (ItemWonderWomanArmor.isWearingFullSet(event.getEntityPlayer(), ModArmor.WonderWomanTiara, ModArmor.WonderWomanChestplate, ModArmor.WonderWomanSkirt, ModArmor.WonderWomanBoots)) {
	       if (Keyboard.isKeyDown(Keyboard.KEY_F)) {
	    	   EntityPlayer player = event.getEntityPlayer();

				event.getRenderer().getMainModel().bipedRightArm.isHidden=false;
				event.getRenderer().getMainModel().bipedRightArm.rotateAngleX = X;
				event.getRenderer().getMainModel().bipedRightArm.rotateAngleY = Y;
				event.getRenderer().getMainModel().bipedRightArm.rotateAngleZ = Z;
				event.getRenderer().getMainModel().bipedRightArm.renderWithRotation(0.0625F);

	  
			
	       }
		}
	}
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onEvent(RenderPlayerEvent.Post event) {
		if (ItemWonderWomanArmor.isWearingFullSet(event.getEntityPlayer(), ModArmor.WonderWomanTiara, ModArmor.WonderWomanChestplate, ModArmor.WonderWomanSkirt, ModArmor.WonderWomanBoots)) {
		       if (Keyboard.isKeyDown(Keyboard.KEY_F)) {
		    	   event.getRenderer().getMainModel().bipedRightArm.isHidden=false;
		       }
		}
	}*/
}
	  
	
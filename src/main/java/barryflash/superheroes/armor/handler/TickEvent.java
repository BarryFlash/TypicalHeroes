package barryflash.superheroes.armor.handler;

import org.lwjgl.opengl.GL11;

import barryflash.superheroes.entities.projectiles.EntityLassoWhip;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TickEvent {
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void renderWorldLastEvent(RenderWorldLastEvent e) {
		 Minecraft mc = Minecraft.getMinecraft();
		 EntityLassoWhip projectile = new EntityLassoWhip(mc.world, mc.player);
		  if (ItemWonderWomanArmor.isWearingFullSet(mc.player, ModItems.WonderWomanTiara, ModItems.WonderWomanChestplate, ModItems.WonderWomanSkirt, ModItems.WonderWomanBoots)) {
		 if (projectile.isDead = false) {
		  double d0 = mc.player.prevPosX + (mc.player.posX - mc.player.prevPosX) * (double)e.getPartialTicks();
		  double d1 = mc.player.prevPosY + (mc.player.posY - mc.player.prevPosY) * (double)e.getPartialTicks();
		  double d2 = mc.player.prevPosZ + (mc.player.posZ - mc.player.prevPosZ) * (double)e.getPartialTicks();
		  
		  
		  System.out.println("Lasso Render start");
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glColor4f(0f,1f,1f,1f);
		GL11.glLineWidth(4.0F);
		GL11.glTranslated(-d0, -d1, -d2);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glHint( GL11.GL_LINE_SMOOTH_HINT, GL11.GL_NICEST );
		GL11.glBegin(GL11.GL_LINE_STRIP);
		GL11.glVertex3d(projectile.getThrower().getPosition().getX(), projectile.getThrower().getPosition().getY(), projectile.getThrower().getPosition().getZ());
		GL11.glVertex3d(projectile.getPosition().getX(), projectile.getPosition().getY(), projectile.getPosition().getZ());
		GL11.glEnd();
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glPopMatrix();
		System.out.println("Lasso Render End");
		 }
		  }
		  
	}
}

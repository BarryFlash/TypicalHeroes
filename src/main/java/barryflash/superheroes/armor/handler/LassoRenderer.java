package barryflash.superheroes.armor.handler;

import org.lwjgl.opengl.GL11;

import barryflash.superheroes.entities.projectiles.EntityLassoWhip;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LassoRenderer {
/*

private Minecraft mc;

public LassoRenderer(Minecraft mc)
{
	super();
	this.mc = mc;
}

@SubscribeEvent
public void render(RenderWorldLastEvent event)
{
	EntityLassoWhip projectile = new EntityLassoWhip(mc.thePlayer.getEntityWorld(), mc.thePlayer);
	if (ItemWonderWomanArmor.isWearingFullSet(mc.thePlayer, ModArmor.WonderWomanTiara, ModArmor.WonderWomanChestplate, ModArmor.WonderWomanSkirt, ModArmor.WonderWomanBoots)) {
		
		double doubleX = mc.thePlayer.prevPosX + (mc.thePlayer.posX - mc.thePlayer.prevPosX) * event.getPartialTicks(); 
		double doubleY = mc.thePlayer.prevPosY + (mc.thePlayer.posY - mc.thePlayer.prevPosY) * event.getPartialTicks();
		double doubleZ = mc.thePlayer.prevPosZ + (mc.thePlayer.posZ - mc.thePlayer.prevPosZ) * event.getPartialTicks();
		Vec3d vec = projectile.getPositionVector();
		Vec3d pvec = mc.thePlayer.getPositionVector();
		double vx = vec.xCoord;
		double vy = vec.yCoord;
		double vz = vec.zCoord;
		double px = pvec.xCoord;
		double py = pvec.yCoord;
		double pz = pvec.zCoord;
		
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		
		
		GL11.glLineWidth(2);
		GL11.glTranslated(-doubleX, -doubleY, -doubleZ);
		GL11.glColor3f(2f, 1f, 0f);
		float mx = 9;
		float my = 9;
		float mz = 9;
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glHint( GL11.GL_LINE_SMOOTH_HINT, GL11.GL_NICEST );
		GL11.glBegin(GL11.GL_LINE_STRIP);
		
		GL11.glVertex3d(px, py, pz);
		
		GL11.glVertex3d(vx, vy, vz);
		GL11.glEnd();
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glPopMatrix();
		}
	}*/
}

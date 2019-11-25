package barryflash.superheroes.network;

import java.util.List;

import org.lwjgl.opengl.GL11;

import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.entities.projectiles.EntityLasso;
import barryflash.superheroes.entities.projectiles.EntityLassoWhip;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageRenderLasso extends MessageBase<MessageRenderLasso> {

	@Override
	public void fromBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void handleClientSide(MessageRenderLasso message, EntityPlayer player) {
		World world = Minecraft.getMinecraft().world;
		  EntityLassoWhip projectile = new EntityLassoWhip(world, player);
		  System.out.println("Lasso Render start");
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glColor4f(0f,1f,1f,1f);
		GL11.glLineWidth(4.0F);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glHint( GL11.GL_LINE_SMOOTH_HINT, GL11.GL_NICEST );
		GL11.glBegin(GL11.GL_LINE_STRIP);
		GL11.glVertex3d(projectile.getThrower().getPosition().getX(), projectile.getThrower().getPosition().getY(), projectile.getThrower().getPosition().getZ());
		GL11.glVertex3d(projectile.posX, projectile.posY, projectile.posZ);
		GL11.glEnd();
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glPopMatrix();
		System.out.println("Lasso Render End");
		
	}

	@Override
	public void handleServerSide(MessageRenderLasso message, EntityPlayer player, MessageContext ctx) {
  
	}
}


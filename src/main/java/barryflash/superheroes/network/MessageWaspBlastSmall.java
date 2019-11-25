package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.entities.projectiles.EntityRepulsor;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import barryflash.superheroes.entities.projectiles.EntityWaspBlast;
import barryflash.superheroes.entities.projectiles.EntityWaspBlastSmall;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageWaspBlastSmall extends MessageBase<MessageWaspBlastSmall> {

	@Override
	public void fromBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void handleClientSide(MessageWaspBlastSmall message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageWaspBlastSmall message, EntityPlayer playerd, MessageContext ctx) {
		
		final EntityPlayerMP player = ctx.getServerHandler().player;
		final WorldServer world = player.getServerWorld();

		world.addScheduledTask(new Runnable() {

	      public void run() {

	     EntityWaspBlastSmall projectile = new EntityWaspBlastSmall(world, player);
	  
			projectile.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0.0F, 0.0F);

			

			world.spawnEntity(projectile);
			
	      }
		});
	    
		}
}


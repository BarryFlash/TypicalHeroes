package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.util.Utils;
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
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageExplode extends MessageBase<MessageExplode> {

	@Override
	public void fromBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void handleClientSide(MessageExplode message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageExplode message, EntityPlayer playerd, MessageContext ctx) {
		final EntityPlayerMP player = ctx.getServerHandler().player;
		final WorldServer world = player.getServerWorld();

		world.addScheduledTask(new Runnable() {

	      public void run() {

		int k1 = player.getPosition().getX() + 10;
		 int l1 = player.getPosition().getX() - 10;
	     int i2 = player.getPosition().getY() + 10;
	     int i1 = player.getPosition().getY() - 10;
	     int j2 = player.getPosition().getZ() + 10;
	     int j1 = player.getPosition().getZ() - 10;
		
		  List<Entity> list = player.world.getEntitiesWithinAABBExcludingEntity(player, new AxisAlignedBB((double)k1, (double)i2, (double)j2, (double)l1, (double)i1, (double)j1));
		  for (int k2 = 0; k2 < list.size(); ++k2)
		  {
		  Entity entity = (Entity)list.get(k2);
		if (entity instanceof EntityLiving || entity instanceof EntityPlayer) {

         
        
      
        
		 entity.attackEntityFrom(DamageSource.causePlayerDamage(player), 40);
		 
		}
		 
		  
		}
	      }
	      });
}
}

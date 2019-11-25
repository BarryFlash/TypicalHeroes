package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.entities.projectiles.EntityRepulsor;
import barryflash.superheroes.entities.projectiles.EntityTiara;
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
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageKnockBackFists extends MessageBase<MessageKnockBackFists> {

	@Override
	public void fromBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void handleClientSide(MessageKnockBackFists message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageKnockBackFists message, EntityPlayer playerd, MessageContext ctx) {
		final EntityPlayerMP player = ctx.getServerHandler().player;
		final WorldServer world = player.getServerWorld();

		world.addScheduledTask(new Runnable() {

	      public void run() {
		 int k2 = player.getPosition().getX() + 8;
		 int l2 = player.getPosition().getX() - 8;
	     int i3 = player.getPosition().getY() + 8;
	     int i2 = player.getPosition().getY() - 8;
	     int j3 = player.getPosition().getZ() + 8;
	     int j2 = player.getPosition().getZ() - 8;
		
		  List<Entity> list2 = player.world.getEntitiesWithinAABBExcludingEntity(player, new AxisAlignedBB((double)k2, (double)i3, (double)j3, (double)l2, (double)i2, (double)j2));
		  for (int k3 = 0; k3 < list2.size(); ++k3)
		  {
		  Entity entity = (Entity)list2.get(k3);
		
		  Vec3d vector = new Vec3d(entity.posX - player.posX, entity.posY - player.posY, entity.posZ - player.posZ);
		  entity.addVelocity(vector.x * 1.5F, 1.5F, vector.z * 1.5F);

			
		  }
	      }
		});
		}
}


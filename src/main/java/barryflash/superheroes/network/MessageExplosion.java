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

public class MessageExplosion extends MessageBase<MessageExplosion> {
	private float strength;
	public MessageExplosion() {
		// TODO Auto-generated constructor stub
	}
	public MessageExplosion(float explosionStrength) {
		// TODO Auto-generated constructor stub
		strength = explosionStrength;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		
		strength = buf.readFloat();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeFloat(strength);
		
	}

	@Override
	public void handleClientSide(MessageExplosion message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageExplosion message, EntityPlayer playerd, MessageContext ctx) {
		final EntityPlayerMP player = ctx.getServerHandler().player;
		final WorldServer world = player.getServerWorld();

		world.addScheduledTask(new Runnable() {

	      public void run() {
	    	  player.world.createExplosion(player, player.posX, player.posY, player.posZ, message.strength, false);
	      }
	      });
}
}

package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.util.Utils;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageGroundPound extends MessageBase<MessageGroundPound> {

	@Override
	public void fromBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void handleClientSide(MessageGroundPound message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageGroundPound message, EntityPlayer playerd, MessageContext ctx) {
		
		final EntityPlayerMP player = ctx.getServerHandler().player;
		final WorldServer world = player.getServerWorld();

		world.addScheduledTask(new Runnable() {

	      public void run() {

		  player.world.createExplosion(player, player.getPosition().getX(), player.getPosition().getY() + 1, player.getPosition().getZ(), 6.0F, true);
	      }
		});
		 
		  
	}
}

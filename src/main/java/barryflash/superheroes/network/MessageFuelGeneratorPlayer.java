package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.tileentities.TileEntityFuelGenerator;
import barryflash.superheroes.util.Utils;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageFuelGeneratorPlayer extends MessageBase<MessageFuelGeneratorPlayer> {
	private int player;
	private BlockPos from;
	public MessageFuelGeneratorPlayer(BlockPos from, EntityPlayer player) {
		// TODO Auto-generated constructor stub
		this.player = player.getEntityId();
		this.from = from;
	}
	public MessageFuelGeneratorPlayer() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		player = ByteBufUtils.readVarInt(buf, 4);
		from = BlockPos.fromLong(buf.readLong());
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeVarInt(buf, player, 4);
		buf.writeLong(from.toLong());
	}

	@Override
	public void handleClientSide(MessageFuelGeneratorPlayer message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageFuelGeneratorPlayer message, EntityPlayer playerd, MessageContext ctx) {
		final EntityPlayerMP player = ctx.getServerHandler().player;
		final WorldServer world = player.getServerWorld();

		world.addScheduledTask(new Runnable() {

	      public void run() {

	    	  TileEntityFuelGenerator from = (TileEntityFuelGenerator) world.getTileEntity(message.from);
	    	  
	    	  from.setPlayer((EntityPlayer) world.getEntityByID(message.player));
	    	

	      }
	      });
}
}

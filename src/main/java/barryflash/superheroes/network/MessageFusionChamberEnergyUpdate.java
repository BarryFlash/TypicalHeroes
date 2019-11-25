package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.tileentities.TileEntityFuelGenerator;
import barryflash.superheroes.tileentities.TileEntityFusionChamber;
import barryflash.superheroes.util.Utils;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
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

public class MessageFusionChamberEnergyUpdate extends MessageBase<MessageFusionChamberEnergyUpdate> {
	private BlockPos from;
	public MessageFusionChamberEnergyUpdate(BlockPos from) {
		// TODO Auto-generated constructor stub
		this.from = from;
	}
	public MessageFusionChamberEnergyUpdate() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		from = BlockPos.fromLong(buf.readLong());
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeLong(from.toLong());
	}

	@Override
	public void handleClientSide(MessageFusionChamberEnergyUpdate message, EntityPlayer player) {
		 
		
	}

	@Override
	public void handleServerSide(MessageFusionChamberEnergyUpdate message, EntityPlayer playerd, MessageContext ctx) {
		final EntityPlayerMP player = ctx.getServerHandler().player;
		final WorldServer world = player.getServerWorld();

		world.addScheduledTask(new Runnable() {

	      public void run() {
		 TileEntityFusionChamber from = (TileEntityFusionChamber) player.world.getTileEntity(message.from);
	   	  if (from != null) {
	   		  
	   	  from.storage.setEnergyStored(0);
	   	  from.energy = 0;
	  
	   	  }
	     }
	  });
	    	
}
}

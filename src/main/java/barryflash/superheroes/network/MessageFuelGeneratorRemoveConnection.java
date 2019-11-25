package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.tileentities.TileEntityFuelGenerator;
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
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageFuelGeneratorRemoveConnection extends MessageBase<MessageFuelGeneratorRemoveConnection> {
	private int index;
	private BlockPos from;
	public MessageFuelGeneratorRemoveConnection(BlockPos from, int index) {
		// TODO Auto-generated constructor stub
		this.index = index;
		this.from = from;
	}
	public MessageFuelGeneratorRemoveConnection() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		index = buf.readInt();
		from = BlockPos.fromLong(buf.readLong());
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(index);
		buf.writeLong(from.toLong());
	}

	@Override
	public void handleClientSide(MessageFuelGeneratorRemoveConnection message, EntityPlayer player) {
		  TileEntityFuelGenerator from = (TileEntityFuelGenerator) Minecraft.getMinecraft().world.getTileEntity(message.from);
    	  if (from != null) {
    	  from.removeFromList(message.index);
    	  }
		
	}

	@Override
	public void handleServerSide(MessageFuelGeneratorRemoveConnection message, EntityPlayer playerd, MessageContext ctx) {


	    	
}
}

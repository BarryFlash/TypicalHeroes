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

public class MessageFuelGeneratorAddConnectionClient extends MessageBase<MessageFuelGeneratorAddConnectionClient> {
	private BlockPos pos;
	private BlockPos from;
	public MessageFuelGeneratorAddConnectionClient(BlockPos from, BlockPos pos) {
		// TODO Auto-generated constructor stub
		this.pos = pos;
		this.from = from;
	}
	public MessageFuelGeneratorAddConnectionClient() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		pos = BlockPos.fromLong(buf.readLong());
		from = BlockPos.fromLong(buf.readLong());
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeLong(pos.toLong());
		buf.writeLong(from.toLong());
	}

	@Override
	public void handleClientSide(MessageFuelGeneratorAddConnectionClient message, EntityPlayer player) {
		  TileEntityFuelGenerator from = (TileEntityFuelGenerator) Minecraft.getMinecraft().world.getTileEntity(message.from);
    	  TileEntity to = Minecraft.getMinecraft().world.getTileEntity(message.pos);
    	  if (from != null && to != null) {
    	  from.addToList(to);
    	  }
		
	}

	@Override
	public void handleServerSide(MessageFuelGeneratorAddConnectionClient message, EntityPlayer playerd, MessageContext ctx) {


	    	
}
}

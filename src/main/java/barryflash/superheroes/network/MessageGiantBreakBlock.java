package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.capabilities.DoctorStrangeProvider;
import barryflash.superheroes.capabilities.IDoctorStrange;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageGiantBreakBlock extends MessageBase<MessageGiantBreakBlock> {
	
	private BlockPos pos;
	private int x;
	private int y;
	private int z;
	public MessageGiantBreakBlock() {
		// TODO Auto-generated constructor stub
	}
	public MessageGiantBreakBlock(BlockPos entityID) {
		this.pos = entityID;
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		x = ByteBufUtils.readVarInt(buf, 4);
		y = ByteBufUtils.readVarInt(buf, 4);
		z = ByteBufUtils.readVarInt(buf, 4);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeVarInt(buf, pos.getX(), 4);
		ByteBufUtils.writeVarInt(buf, pos.getY(), 4);
		ByteBufUtils.writeVarInt(buf, pos.getZ(), 4);
	}

	@Override
	public void handleClientSide(MessageGiantBreakBlock message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageGiantBreakBlock message, EntityPlayer player, MessageContext ctx) {
		
		BlockPos bpos = new BlockPos(message.x, message.y, message.z);
		System.out.println(bpos);
		if (bpos != null) {
			
		player.world.destroyBlock(bpos, true);
		}
		
		  
		}
}


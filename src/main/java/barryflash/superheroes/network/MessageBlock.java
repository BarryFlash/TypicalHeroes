package barryflash.superheroes.network;

import java.util.List;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageBlock extends MessageBase<MessageBlock> {

	@Override
	public void fromBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void handleClientSide(MessageBlock message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageBlock message, EntityPlayer player, MessageContext ctx) {
		
		player.capabilities.disableDamage = false;
		
		
		
		  
		}
}


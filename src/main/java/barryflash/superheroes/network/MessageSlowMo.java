package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.entities.projectiles.EntityRepulsor;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageSlowMo extends MessageBase<MessageSlowMo> {
	
	private float tick;
	
	public MessageSlowMo() {
		// TODO Auto-generated constructor stub
	}
	public MessageSlowMo(float tick) {
		// TODO Auto-generated constructor stub
		this.tick = tick;
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		
		tick = buf.readFloat();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeFloat(tick);
		
	}

	@Override
	public void handleClientSide(MessageSlowMo message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageSlowMo message, EntityPlayer player, MessageContext ctx) {
		
		System.out.println(FMLInterModComms.sendMessage("tickratechanger", "tickrate", Float.toString(10)));
	    
		
		
		}
}


package barryflash.superheroes.network;

import java.util.List;

import org.lwjgl.opengl.GL11;

import barryflash.superheroes.capabilities.IThor;
import barryflash.superheroes.capabilities.ThorProvider;
import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.entities.projectiles.EntityRepulsor;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageLightning extends MessageBase<MessageLightning> {

	@Override
	public void fromBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void handleClientSide(MessageLightning message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageLightning message, EntityPlayer playerd, MessageContext ctx) {
		final EntityPlayerMP player = ctx.getServerHandler().player;
		final WorldServer world = player.getServerWorld();
		world.addScheduledTask(new Runnable() {

		      public void run() {
		EntityLightningBolt entity = new EntityLightningBolt(player.world, player.posX, player.posY, player.posZ, false);
		
	
	    player.world.addWeatherEffect(entity);
	    player.world.tick();
	    player.world.addWeatherEffect(entity);
	    player.world.tick();
	    player.world.addWeatherEffect(entity);
		}
		});
	}
}


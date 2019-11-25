package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.capabilities.IPortal;
import barryflash.superheroes.capabilities.IThor;
import barryflash.superheroes.capabilities.PortalProvider;
import barryflash.superheroes.capabilities.ThorProvider;
import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.entities.EntityThanosPortal;
import barryflash.superheroes.entities.projectiles.EntityCannonBlast;
import barryflash.superheroes.entities.projectiles.EntityRepulsor;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageSpacePortal extends MessageBase<MessageSpacePortal> {

	@Override
	public void fromBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void handleClientSide(MessageSpacePortal message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageSpacePortal message, EntityPlayer player, MessageContext ctx) {
		
		
	    
	    
		EntityThanosPortal portal1 = new EntityThanosPortal(player.getEntityWorld());
		
		portal1.setPositionAndRotation(player.posX, player.posY, player.posZ, player.rotationYawHead, player.rotationPitch);
		

			player.getEntityWorld().spawnEntity(portal1);
		
			
	    
		}
}


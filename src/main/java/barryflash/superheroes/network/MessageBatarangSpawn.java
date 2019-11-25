package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarang;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarangElectric;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarangExplosive;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarangPoison;
import barryflash.superheroes.entities.projectiles.EntityBatmanSmokeBomb;
import barryflash.superheroes.entities.projectiles.EntityRepulsor;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageBatarangSpawn extends MessageBase<MessageBatarangSpawn> {
	private int batarangType;
	
	public MessageBatarangSpawn() {
		// TODO Auto-generated constructor stub
	}
	public MessageBatarangSpawn(int batarangType) {
		this.batarangType = batarangType;
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		batarangType = ByteBufUtils.readVarInt(buf, 4);
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeVarInt(buf, batarangType, 4);
		
	}

	@Override
	public void handleClientSide(MessageBatarangSpawn message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageBatarangSpawn message, EntityPlayer playerd, MessageContext ctx) {
		final EntityPlayerMP player = ctx.getServerHandler().player;
		final WorldServer world = player.getServerWorld();

		world.addScheduledTask(new Runnable() {

	      public void run() {

	      
		EntityArrow projectile;
		

		message.batarangType -= 1;
		switch (message.batarangType) {
		case 0: 
			
		projectile = new EntityBatmanBatarang(world, player);
		projectile.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 2F, 0.0F);
	
		

		world.spawnEntity(projectile);

		
		break;
		case 1: 
	    
		projectile = new EntityBatmanBatarangExplosive(world, player);
		projectile.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 2F, 0.0F);

		

		world.spawnEntity(projectile);

		world.tick();	
		break;
		case 2:
		
		projectile = new EntityBatmanBatarangPoison(world, player);
		projectile.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 2F, 0.0F);
		
		
		
		world.spawnEntity(projectile);
	
		break;
		case 3: 
		
		projectile = new EntityBatmanBatarangElectric(world, player);
		projectile.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 2F, 0.0F);

		
		world.spawnEntity(projectile);
		//NetworkHandler.sendTo(new MessageShootingPlayerToClient(projectile.getEntityId(), playerd.getEntityId()), (EntityPlayerMP) playerd);

		break;
		case 4: 
			
			EntityBatmanSmokeBomb projectile2 = new EntityBatmanSmokeBomb(world, player);
			projectile2.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0.0F, 0.0F);
			
			
			
			world.spawnEntity(projectile2);
			

			break;
		}
	      }

	    });
		}
}


package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarangElectric;
import barryflash.superheroes.entities.projectiles.EntityRepulsor;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageShootingPlayerToClient extends MessageBase<MessageShootingPlayerToClient> {

	private int entityID;
	private int playerID;
	public MessageShootingPlayerToClient() {
		// TODO Auto-generated constructor stub
	}
	public MessageShootingPlayerToClient(int id, int pid) {
		// TODO Auto-generated constructor stub
		entityID = id;
		playerID = pid;
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		entityID = buf.readInt();
		playerID = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(entityID);
		buf.writeInt(playerID);
	}

	@Override
	public void handleClientSide(MessageShootingPlayerToClient message, EntityPlayer playerd) {
		if (message.entityID != 0) {
			EntityPlayer player = (EntityPlayer) Minecraft.getMinecraft().world.getEntityByID(message.playerID);
			if (player.world.getEntityByID(message.entityID) != null) {
			EntityArrow batarang = (EntityArrow) player.world.getEntityByID(message.entityID);
			batarang.shootingEntity = player;
			
			}
		}
	}

	@Override
	public void handleServerSide(MessageShootingPlayerToClient message, EntityPlayer player, MessageContext ctx) {
		

		
		
		}
}


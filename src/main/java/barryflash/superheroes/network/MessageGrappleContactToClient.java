package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarangElectric;
import barryflash.superheroes.entities.projectiles.EntityRepulsor;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import barryflash.superheroes.entities.projectiles.EntityTrickArrowGrapple;
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

public class MessageGrappleContactToClient extends MessageBase<MessageGrappleContactToClient> {

	private int entityID;
	private boolean contact;
	public MessageGrappleContactToClient() {
		// TODO Auto-generated constructor stub
	}
	public MessageGrappleContactToClient(int id, boolean bool) {
		// TODO Auto-generated constructor stub
		entityID = id;
		contact = bool;
		
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		entityID = buf.readInt();
		contact = buf.readBoolean();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(entityID);
		buf.writeBoolean(contact);
	}

	@Override
	public void handleClientSide(MessageGrappleContactToClient message, EntityPlayer playerd) {
		if (message.entityID != 0) {
			if (Minecraft.getMinecraft().world.getEntityByID(message.entityID) != null) {
			EntityTrickArrowGrapple arrow = (EntityTrickArrowGrapple) Minecraft.getMinecraft().world.getEntityByID(message.entityID);
			arrow.contact = message.contact;
			
			}
		}
	}

	@Override
	public void handleServerSide(MessageGrappleContactToClient message, EntityPlayer player, MessageContext ctx) {
		

		
		
		}
}


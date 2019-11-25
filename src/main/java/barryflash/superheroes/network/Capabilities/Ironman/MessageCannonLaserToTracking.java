package barryflash.superheroes.network.Capabilities.Ironman;

import barryflash.superheroes.capabilities.DoctorStrangeProvider;
import barryflash.superheroes.capabilities.IDoctorStrange;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.entities.EntityDoctorStrangeCape;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemDoctorStrangeArmor;
import barryflash.superheroes.network.MessageBase;
import barryflash.superheroes.util.Utils;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageCannonLaserToTracking extends MessageBase<MessageCannonLaserToTracking> {

	double svecx;
	double svecy;
	double svecz;
	double evecx;
	double evecy;
	double evecz;
	float width;
	public MessageCannonLaserToTracking() {
		// TODO Auto-generated constructor stub
	}
	public MessageCannonLaserToTracking(Vec3d svec, Vec3d evec, float width) {
		this.svecx = svec.x;
		this.svecy = svec.y;
		this.svecz = svec.z;
		this.evecx = evec.x;
		this.evecy = evec.y;
		this.evecz = evec.z;
		this.width = width;
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		svecx = buf.readDouble();
		svecy = buf.readDouble();
		svecz = buf.readDouble();
		evecx = buf.readDouble();
		evecy = buf.readDouble();
		evecz = buf.readDouble();
		width = buf.readFloat();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeDouble(svecx);
		buf.writeDouble(svecy);
		buf.writeDouble(svecz);
		buf.writeDouble(evecx);
		buf.writeDouble(evecy);
		buf.writeDouble(evecz);
		buf.writeFloat(width);	
	}

	@Override
	public void handleClientSide(MessageCannonLaserToTracking message, EntityPlayer player) {
		Vec3d S = new Vec3d(message.svecx, message.svecy, message.svecz);
		Vec3d vector = new Vec3d(message.evecx, message.evecy, message.evecz);
		Utils.renderLaser(player, S, vector, 2.5F, message.width, new float[] {0.8F, 0.5F, 0.3F});
	}

	@Override
	public void handleServerSide(MessageCannonLaserToTracking message, EntityPlayer player, MessageContext ctx) {
		
	    
	}  
}

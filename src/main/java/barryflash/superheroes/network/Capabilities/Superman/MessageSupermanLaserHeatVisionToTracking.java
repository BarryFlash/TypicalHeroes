package barryflash.superheroes.network.Capabilities.Superman;

import barryflash.superheroes.capabilities.DoctorStrangeProvider;
import barryflash.superheroes.capabilities.IDoctorStrange;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.ISuperman;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.capabilities.SupermanProvider;
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

public class MessageSupermanLaserHeatVisionToTracking extends MessageBase<MessageSupermanLaserHeatVisionToTracking> {
	private int playerID;
	public MessageSupermanLaserHeatVisionToTracking() {
		// TODO Auto-generated constructor stub
	}
	public MessageSupermanLaserHeatVisionToTracking(int ID) {
		this.playerID = ID;
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		playerID = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(playerID);
	}

	@Override
	public void handleClientSide(MessageSupermanLaserHeatVisionToTracking message, EntityPlayer player) {
		Minecraft.getMinecraft().addScheduledTask(new Runnable() {
			 public void run() {
				EntityPlayer playerd = (EntityPlayer) Minecraft.getMinecraft().world.getEntityByID(message.playerID);
				if (playerd == null) {
					System.out.println("wtf");
				} else {
					System.out.println(playerd.toString());
					float distance = 60;
					float distance2 = -0.2F;
					Vec3d vec3 = Vec3d.fromPitchYaw(playerd.rotationPitch, playerd.rotationYaw);
					
					double x = playerd.posX + (distance *vec3.x);
					double y = playerd.posY + playerd.getEyeHeight() + (distance *vec3.y);
					double z = playerd.posZ + (distance *vec3.z);
					double x2 = playerd.posX + (distance2 *vec3.x);
					double y2 = playerd.posY + playerd.getEyeHeight() + 0.1F + (distance2 *vec3.y);
					double z2 = playerd.posZ + (distance2 *vec3.z);
				
					Vec3d fina = new Vec3d(0,0,0.15F).rotateYaw(-playerd.rotationYaw * 0.017453292F - (float)Math.PI/2).add(new Vec3d(x2, y2, z2));
					Vec3d fina2 = new Vec3d(0,0,0.15F).rotateYaw(playerd.rotationYaw * -0.017453292F + (float)Math.PI/2).add(new Vec3d(x2, y2, z2));
					Vec3d vector = new Vec3d(x, y, z);
					
			
					Utils.renderHeatVision(fina, vector, 1.0F, 0.03F, new float[] {1.5F, 0.4F, 0.4F});
					Utils.renderHeatVision(fina2, vector, 1.0F, 0.03F, new float[] {1.5F, 0.4F, 0.4F});
				}
			}
		});
	}

	@Override
	public void handleServerSide(MessageSupermanLaserHeatVisionToTracking message, EntityPlayer player, MessageContext ctx) {
		
	    
	}  
}

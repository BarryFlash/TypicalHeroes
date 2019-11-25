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
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageGrow extends MessageBase<MessageGrow> {

	@Override
	public void fromBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void handleClientSide(MessageGrow message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageGrow message, EntityPlayer player, MessageContext ctx) {
		
		player.width = 1.8F;
		player.height = 5.5F;
		player.eyeHeight = player.getDefaultEyeHeight() + 3.5F;
		
		System.out.println(player.width);
		System.out.println(player.height);
		
		
		}
}


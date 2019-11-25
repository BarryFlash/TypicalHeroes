package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.entities.projectiles.EntityCannonBlast;
import barryflash.superheroes.entities.projectiles.EntityMissile;
import barryflash.superheroes.entities.projectiles.EntityRepulsor;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import barryflash.superheroes.recipes.SuitRecipes;
import barryflash.superheroes.recipes.ZeusAltarOfferings;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageZeusAltar extends MessageBase<MessageZeusAltar> {

	@Override
	public void fromBytes(ByteBuf buf) {		
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
	}

	@Override
	public void handleClientSide(MessageZeusAltar message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageZeusAltar message, EntityPlayer playerd, MessageContext ctx) {
		final EntityPlayerMP player = ctx.getServerHandler().player;
		final WorldServer world = player.getServerWorld();

		world.addScheduledTask(new Runnable() {

	      public void run() {
			ZeusAltarOfferings.addOutput(player);
	      }
	    });
	}
}


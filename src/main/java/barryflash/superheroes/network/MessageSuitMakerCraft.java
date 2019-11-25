package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.entities.projectiles.EntityCannonBlast;
import barryflash.superheroes.entities.projectiles.EntityMissile;
import barryflash.superheroes.entities.projectiles.EntityRepulsor;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import barryflash.superheroes.recipes.SuitRecipes;
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

public class MessageSuitMakerCraft extends MessageBase<MessageSuitMakerCraft> {
	private String type;
	
	public MessageSuitMakerCraft(String type) {
		this.type = type;
	}
	public MessageSuitMakerCraft() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		type = ByteBufUtils.readUTF8String(buf);		
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, type);
		
	}

	@Override
	public void handleClientSide(MessageSuitMakerCraft message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageSuitMakerCraft message, EntityPlayer playerd, MessageContext ctx) {
		final EntityPlayerMP player = ctx.getServerHandler().player;
		final WorldServer world = player.getServerWorld();

		world.addScheduledTask(new Runnable() {

	      public void run() {
			if (message.type.equals("blackwidow")) {
			SuitRecipes.removeIngredientsFromInventory(player, player.inventory, SuitRecipes.blackwidow);
			}
			else if (message.type.equals("hawkeye")) {
				SuitRecipes.removeIngredientsFromInventory(player, player.inventory, SuitRecipes.hawkeye);
			}
			else if (message.type.equals("batman")) {
				SuitRecipes.removeIngredientsFromInventory(player, player.inventory, SuitRecipes.batman);
			}
			else if (message.type.equals("ironman")) {
				SuitRecipes.removeIngredientsFromInventory(player, player.inventory, SuitRecipes.ironman);
			}
			else if (message.type.equals("loki")) {
				SuitRecipes.removeIngredientsFromInventory(player, player.inventory, SuitRecipes.loki);
			}
			else if (message.type.equals("shazam")) {
				SuitRecipes.removeIngredientsFromInventory(player, player.inventory, SuitRecipes.shazam);
			}
			else if (message.type.equals("superman")) {
				SuitRecipes.removeIngredientsFromInventory(player, player.inventory, SuitRecipes.superman);
			}
			else if (message.type.equals("thor")) {
				SuitRecipes.removeIngredientsFromInventory(player, player.inventory, SuitRecipes.thor);
			}
			else if (message.type.equals("wonderwoman")) {
				SuitRecipes.removeIngredientsFromInventory(player, player.inventory, SuitRecipes.wonderwoman);
			}
			else if (message.type.equals("zod")) {
				SuitRecipes.removeIngredientsFromInventory(player, player.inventory, SuitRecipes.zod);
			}
	      }
	    });
	}
}


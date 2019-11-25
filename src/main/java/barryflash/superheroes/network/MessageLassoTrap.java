package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.entities.projectiles.EntityLasso;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import barryflash.superheroes.init.ModItems;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageLassoTrap extends MessageBase<MessageLassoTrap> {

	@Override
	public void fromBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void handleClientSide(MessageLassoTrap message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageLassoTrap message, EntityPlayer player, MessageContext ctx) {
		
	//player.inventory.deleteStack(new ItemStack(ModItems.wonderwoman_lasso));
	   
	    
		}
}


package barryflash.superheroes.network;

import barryflash.superheroes.capabilities.DoctorStrangeProvider;
import barryflash.superheroes.capabilities.IDoctorStrange;
import barryflash.superheroes.entities.EntityDoctorStrangeCape;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemDoctorStrangeArmor;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageCapeSpawn extends MessageBase<MessageCapeSpawn> {

	@Override
	public void fromBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void handleClientSide(MessageCapeSpawn message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageCapeSpawn message, EntityPlayer player, MessageContext ctx) {
		
		
		EntityDoctorStrangeCape cape = new EntityDoctorStrangeCape(player.world);
		cape.setPosition(player.posX, player.posY, player.posZ);
		player.world.spawnEntity(cape);
			
		
		
		
	    
	}  
}

package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.entities.projectiles.EntityRepulsor;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemIronmanMark50Armor;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageIronmanSuitOff extends MessageBase<MessageIronmanSuitOff> {

	@Override
	public void fromBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void handleClientSide(MessageIronmanSuitOff message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageIronmanSuitOff message, EntityPlayer player, MessageContext ctx) {
		
		
				
		
				 player.setItemStackToSlot(EntityEquipmentSlot.HEAD, ItemStack.EMPTY);
				 player.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(ModItems.IronManArcReactor));
				 player.setItemStackToSlot(EntityEquipmentSlot.LEGS, ItemStack.EMPTY);
				 player.setItemStackToSlot(EntityEquipmentSlot.FEET, ItemStack.EMPTY);
				
			
		
		}
}


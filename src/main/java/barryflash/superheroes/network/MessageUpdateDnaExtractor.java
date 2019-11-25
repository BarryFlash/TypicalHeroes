package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.tileentities.TileEntityDnaExtractor;
import barryflash.superheroes.tileentities.TileEntitySmeltingCrucible;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageUpdateDnaExtractor extends MessageBase<MessageUpdateDnaExtractor> {
	private BlockPos pos;
	private long lastChangeTime;
	private ItemStack stack;
	
	public MessageUpdateDnaExtractor(BlockPos pos, ItemStack stack, long lastChangeTime) {
		this.pos = pos;
		this.stack = stack;
		this.lastChangeTime = lastChangeTime;

	}
	
	public MessageUpdateDnaExtractor(TileEntityDnaExtractor te) {
		this(te.getPos(), te.inventory.getStackInSlot(0), te.lastChangeTime);
	}
	
	public MessageUpdateDnaExtractor() {
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeLong(pos.toLong());
		ByteBufUtils.writeItemStack(buf, stack);
		buf.writeLong(lastChangeTime);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		pos = BlockPos.fromLong(buf.readLong());
		stack = ByteBufUtils.readItemStack(buf);
		lastChangeTime = buf.readLong();
	}

	@Override
	public void handleClientSide(MessageUpdateDnaExtractor message, EntityPlayer player) {
		Minecraft.getMinecraft().addScheduledTask(() -> {
			TileEntityDnaExtractor te = (TileEntityDnaExtractor)Minecraft.getMinecraft().world.getTileEntity(message.pos);
			te.inventory.setStackInSlot(0, message.stack);
			te.lastChangeTime = message.lastChangeTime;
		});

		
	}

	@Override
	public void handleServerSide(MessageUpdateDnaExtractor message, EntityPlayer player, MessageContext ctx) {

		
		  
		}
}


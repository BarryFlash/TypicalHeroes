package barryflash.superheroes.network;

import java.util.List;

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

public class MessageUpdateSmeltingCrucible extends MessageBase<MessageUpdateSmeltingCrucible> {
	private BlockPos pos;
	private int count;
	private long lastChangeTime;
	private int cookTime;
	private float offset;
	private int titanium;
	private int gold;
	private int tg;
	private int smeltTime;
	private String currentItem;
	public MessageUpdateSmeltingCrucible(BlockPos pos, int count, long lastChangeTime, int cookTime, float offset, int titanium, int gold, int tg, int smeltTime, String currentItem) {
		this.pos = pos;
		this.count = count;
		this.lastChangeTime = lastChangeTime;
		this.cookTime = cookTime;
		this.offset = offset;
		this.titanium = titanium;
		this.gold = gold;
		this.tg = tg;
		this.smeltTime = smeltTime;
		this.currentItem = currentItem;
	}
	
	public MessageUpdateSmeltingCrucible(TileEntitySmeltingCrucible te) {
		this(te.getPos(), te.getCount(), te.lastChangeTime, te.getCookTime(), te.getOffset(), te.getTitanium(), te.getGold(), te.getTitaniumGold(), te.getSmeltTime(), te.getCurrentItemSmelted());
	}
	
	public MessageUpdateSmeltingCrucible() {
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeLong(pos.toLong());
		buf.writeInt(count);
		buf.writeLong(lastChangeTime);
		buf.writeInt(cookTime);
		buf.writeInt(titanium);
		buf.writeInt(gold);
		buf.writeInt(tg);
		buf.writeFloat(offset);
		buf.writeInt(smeltTime);
		ByteBufUtils.writeUTF8String(buf, currentItem);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		pos = BlockPos.fromLong(buf.readLong());
		count = buf.readInt();
		lastChangeTime = buf.readLong();
		cookTime = buf.readInt();
		titanium = buf.readInt();
		gold = buf.readInt();
		tg = buf.readInt();
		offset = buf.readFloat();
		smeltTime = buf.readInt();
		currentItem = ByteBufUtils.readUTF8String(buf);		
	}

	@Override
	public void handleClientSide(MessageUpdateSmeltingCrucible message, EntityPlayer player) {
		Minecraft.getMinecraft().addScheduledTask(() -> {
			TileEntitySmeltingCrucible te = (TileEntitySmeltingCrucible)Minecraft.getMinecraft().world.getTileEntity(message.pos);
			te.setCount(message.count);
			te.setCookTime(message.cookTime);
			te.setSmeltTime(message.smeltTime);
			te.setTitanium(message.titanium);
			te.setGold(message.gold);
			te.setTitaniumGold(message.tg);
			te.setOffset(message.offset);
			te.lastChangeTime = message.lastChangeTime;
			te.setCurrentItemSmelted(message.currentItem);
		});

		
	}

	@Override
	public void handleServerSide(MessageUpdateSmeltingCrucible message, EntityPlayer player, MessageContext ctx) {

		
		  
		}
}


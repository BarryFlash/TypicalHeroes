package barryflash.superheroes.network;

import barryflash.superheroes.tileentities.TileEntityDnaExtractor;
import barryflash.superheroes.tileentities.TileEntityLightningExtractor;
import barryflash.superheroes.tileentities.TileEntitySmeltingCrucible;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageRequestUpdateLightningExtractor extends MessageBase<MessageRequestUpdateLightningExtractor> {
	private BlockPos pos;
	private int dimension;
	
	public MessageRequestUpdateLightningExtractor(BlockPos pos, int dimension) {
		this.pos = pos;
		this.dimension = dimension;
	}
	
	public MessageRequestUpdateLightningExtractor(TileEntityLightningExtractor te) {
		this(te.getPos(), te.getWorld().provider.getDimension());
	}
	
	public MessageRequestUpdateLightningExtractor() {
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeLong(pos.toLong());
		buf.writeInt(dimension);
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		pos = BlockPos.fromLong(buf.readLong());
		dimension = buf.readInt();
	}

	@Override
	public void handleClientSide(MessageRequestUpdateLightningExtractor message, EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleServerSide(MessageRequestUpdateLightningExtractor message, EntityPlayer player,
			MessageContext ctx) {
		World world = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(message.dimension);
		TileEntityLightningExtractor te = (TileEntityLightningExtractor)world.getTileEntity(message.pos);
		if (te != null) {
			NetworkHandler.sendTo(new MessageUpdateLightningExtractor(te), (EntityPlayerMP) player);
		}

		
	}

}

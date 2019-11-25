package barryflash.superheroes.network;

import barryflash.superheroes.tileentities.TileEntitySmeltingCrucible;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageRequestUpdateSmeltingCrucible extends MessageBase<MessageRequestUpdateSmeltingCrucible> {
	private BlockPos pos;
	private int dimension;
	
	public MessageRequestUpdateSmeltingCrucible(BlockPos pos, int dimension) {
		this.pos = pos;
		this.dimension = dimension;
	}
	
	public MessageRequestUpdateSmeltingCrucible(TileEntitySmeltingCrucible te) {
		this(te.getPos(), te.getWorld().provider.getDimension());
	}
	
	public MessageRequestUpdateSmeltingCrucible() {
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
	public void handleClientSide(MessageRequestUpdateSmeltingCrucible message, EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleServerSide(MessageRequestUpdateSmeltingCrucible message, EntityPlayer player,
			MessageContext ctx) {
		World world = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(message.dimension);
		TileEntitySmeltingCrucible te = (TileEntitySmeltingCrucible)world.getTileEntity(message.pos);
		if (te != null) {
			NetworkHandler.sendTo(new MessageUpdateSmeltingCrucible(), (EntityPlayerMP) player);
		}

		
	}

}

package barryflash.superheroes.network;

import barryflash.superheroes.tileentities.TileEntityDnaExtractor;
import barryflash.superheroes.tileentities.TileEntityFusionChamber;
import barryflash.superheroes.tileentities.TileEntitySmeltingCrucible;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageRequestUpdateFusionChamber extends MessageBase<MessageRequestUpdateFusionChamber> {
	private BlockPos pos;
	private int dimension;
	
	public MessageRequestUpdateFusionChamber(BlockPos pos, int dimension) {
		this.pos = pos;
		this.dimension = dimension;
	}
	
	public MessageRequestUpdateFusionChamber(TileEntityFusionChamber te) {
		this(te.getPos(), te.getWorld().provider.getDimension());
	}
	
	public MessageRequestUpdateFusionChamber() {
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
	public void handleClientSide(MessageRequestUpdateFusionChamber message, EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleServerSide(MessageRequestUpdateFusionChamber message, EntityPlayer player,
			MessageContext ctx) {
		World world = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(message.dimension);
		TileEntityFusionChamber te = (TileEntityFusionChamber)world.getTileEntity(message.pos);
		if (te != null) {
			NetworkHandler.sendTo(new MessageUpdateFusionChamber(te), (EntityPlayerMP) player);
		}

		
	}

}

package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.capabilities.IZeusAltar;
import barryflash.superheroes.capabilities.ZeusAltarProvider;
import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.entities.projectiles.EntityCannonBlast;
import barryflash.superheroes.entities.projectiles.EntityMissile;
import barryflash.superheroes.entities.projectiles.EntityRepulsor;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import barryflash.superheroes.recipes.SuitRecipes;
import barryflash.superheroes.recipes.ZeusAltarOfferings;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
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

public class MessageUpdateZeusAltarCap extends MessageBase<MessageUpdateZeusAltarCap> {
	
	private int progress;
	public MessageUpdateZeusAltarCap() {
		// TODO Auto-generated constructor stub
	}
	public MessageUpdateZeusAltarCap(int progress) {
		this.progress = progress;
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		progress = ByteBufUtils.readVarInt(buf, 4);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeVarInt(buf, progress, 4);
	}

	@Override
	public void handleClientSide(MessageUpdateZeusAltarCap message, EntityPlayer player) {
		if (Minecraft.getMinecraft().player != null) {
		IZeusAltar zeusaltarCap = Minecraft.getMinecraft().player.getCapability(ZeusAltarProvider.ZEUS_ALTAR_CAP, null);
		if (zeusaltarCap != null) {
		zeusaltarCap.setProgress(message.progress);
		}
		}
	}

	@Override
	public void handleServerSide(MessageUpdateZeusAltarCap message, EntityPlayer playerd, MessageContext ctx) {

		
	}
}


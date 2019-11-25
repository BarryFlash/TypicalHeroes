package barryflash.superheroes.network;

import java.util.List;

import barryflash.superheroes.capabilities.ISpecialEffects;
import barryflash.superheroes.capabilities.SpecialEffectsProvider;
import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarangElectric;
import barryflash.superheroes.entities.projectiles.EntityRepulsor;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import barryflash.superheroes.entities.projectiles.EntityTrickArrowGrapple;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageCutGrappleArrows extends MessageBase<MessageCutGrappleArrows> {

	

	@Override
	public void fromBytes(ByteBuf buf) {
	
	}

	@Override
	public void toBytes(ByteBuf buf) {

	}

	@Override
	public void handleClientSide(MessageCutGrappleArrows message, EntityPlayer playerd) {
		
	}

	@Override
	public void handleServerSide(MessageCutGrappleArrows message, EntityPlayer player, MessageContext ctx) {
		
		ISpecialEffects specialcap = player.getCapability(SpecialEffectsProvider.SPECIALEFFECTS_CAP, null);
		
		if (specialcap != null) {
			if (specialcap.getGrappleEntityList().size() > 0) {
				for (int i = 0; i < specialcap.getGrappleEntityList().size(); i++) {
					((EntityTrickArrowGrapple) specialcap.getGrappleEntityList().get(i)).contact = false;
				}
				specialcap.clearGrappleEntityList();
			}
		}
		}
}


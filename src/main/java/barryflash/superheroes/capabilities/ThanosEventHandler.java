package barryflash.superheroes.capabilities;

import org.lwjgl.opengl.GL11;

import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemThanosArmor;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ThanosEventHandler {
	/*@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onThanosSizeUpdate(PlayerTickEvent event) {
		
		if (ItemThanosArmor.isWearingFullSet(event.player, ModArmor.ThanosHelmet, ModArmor.ThanosChest, ModArmor.ThanosLeggings, ModArmor.ThanosBoots)) {
			
			EntityPlayer player = event.player;
			player.height = 3.0F;
			player.eyeHeight = player.getDefaultEyeHeight() + 1.1F;
			player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX, player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ, player.getEntityBoundingBox().minX + player.width, player.getEntityBoundingBox().minY + player.height, player.getEntityBoundingBox().minZ + player.width));
			
		}
	}
	*/
}

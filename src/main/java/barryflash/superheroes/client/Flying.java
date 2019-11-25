package barryflash.superheroes.client;

import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class Flying {
	public static boolean flies;
	
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		flies = Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown();
		
	}

	@SubscribeEvent
	public void onPlayerTickEvent(LivingUpdateEvent event) {
		if (event.getEntityLiving() != null && event.getEntityLiving() instanceof EntityPlayer)


			{

				EntityLivingBase player1 = event.getEntityLiving();
				EntityPlayer player = (EntityPlayer) event.getEntity();

				if (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown() && ItemWonderWomanArmor.isWearingFullSet(player, ModItems.WonderWomanTiara, ModItems.WonderWomanChestplate, ModItems.WonderWomanSkirt, ModItems.WonderWomanBoots))

				{

					if (player1.motionY > 0.0D)

					{

						player1.motionY += 0.08499999910593033D;

					}

					else

					{

						player1.motionY += 0.11699999910593033D;

					}

				}

				if (player1.motionY < 0.0D && !player1.isSneaking())

				{

					player1.fallDistance = 0;

					player1.motionY /= 1.149999976158142D;

					player1.motionY /= 1.149999976158142D;

				}
				if (this.flies && !Minecraft.getMinecraft().ingameGUI.getChatGUI().getChatOpen() && Minecraft.getMinecraft().currentScreen == null)

				{

					Vec3d vec = player.getLookVec();

					player.motionX = vec.x / 2;

					player.motionY = vec.y / 2;

					player.motionZ = vec.z / 2;

				}
				

				else if (!this.flies )

				{

					player1.motionY /= 1.149999976158142D;

					player1.motionY /= 1.149999976158142D;

					player1.motionY /= 1.149999976158142D;

				}

				player1.fallDistance = 0.0F;
}
}
}

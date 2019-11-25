package barryflash.superheroes.abilities.wonderwoman;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import barryflash.superheroes.client.InventoryHandler;
import barryflash.superheroes.client.Keybinding;
import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarang;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import barryflash.superheroes.entities.projectiles.EntityWonderWomanTiara;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemBatmanArmor;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import barryflash.superheroes.network.MessageExplode;
import barryflash.superheroes.network.MessageLassoTrap;
import barryflash.superheroes.network.MessageLassoWhip;
import barryflash.superheroes.network.MessageThrowTiara;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.util.Key;
import barryflash.superheroes.util.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Lasso {
/*
	private int time;
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		{
			if(ItemWonderWomanArmor.isWearingFullSet(player, ModArmor.WonderWomanTiara, ModArmor.WonderWomanChestplate, ModArmor.WonderWomanSkirt, ModArmor.WonderWomanBoots)) {
		if (Keyboard.isKeyDown(34)) {	
			
			System.out.println("Lasso Given");
			
			
			if(player.inventory.hasItemStack(new ItemStack(ModItems.wonderwoman_lasso))) {
				System.out.println("Lasso Taken");
				NetworkHandler.sendToServer(new MessageLassoTrap());
			}
				else NetworkHandler.sendToServer(new MessageLassoWhip());
			
			}
		}
		}
	}*/
	
}
package barryflash.superheroes.recipes;

import java.util.ArrayList;
import java.util.List;

import barryflash.superheroes.capabilities.IZeusAltar;
import barryflash.superheroes.capabilities.ZeusAltarProvider;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.network.MessageZeusAltar;
import barryflash.superheroes.network.NetworkHandler;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ZeusAltarOfferings {

	public static ArrayList<ItemStack> offerings = new ArrayList<ItemStack>();
	
	public static void registerOfferings() {
		offerings.add(new ItemStack(Items.BREAD, 1));
		offerings.add(new ItemStack(Items.FEATHER, 1));
		offerings.add(new ItemStack(Items.GOLDEN_APPLE, 18));
		offerings.add(new ItemStack(Items.NETHER_STAR, 100));
		offerings.add(new ItemStack(Items.EMERALD, 15));
		offerings.add(new ItemStack(Items.GOLD_INGOT, 2));
		offerings.add(new ItemStack(Items.COOKED_BEEF, 2));
		offerings.add(new ItemStack(Items.COOKED_CHICKEN, 2));
		offerings.add(new ItemStack(Items.COOKED_FISH, 2));
		offerings.add(new ItemStack(Items.COOKED_MUTTON, 2));
		offerings.add(new ItemStack(Items.COOKED_PORKCHOP, 2));
		offerings.add(new ItemStack(Items.COOKED_RABBIT, 2));
	}
	public static void addLightningBolt() {
		NetworkHandler.sendToServer(new MessageZeusAltar());
	}
	public static void addOutput(EntityPlayer player) {
		IZeusAltar zeusaltarCap = player.getCapability(ZeusAltarProvider.ZEUS_ALTAR_CAP, null);
		zeusaltarCap.setProgress(0);
		EntityLightningBolt lightning = new EntityLightningBolt(player.world, player.posX, player.posY, player.posZ, false);
		player.world.addWeatherEffect(lightning);
			if (player.inventory.getFirstEmptyStack() != -1) {
				player.inventory.addItemStackToInventory(new ItemStack(ModItems.GOD_ESSENCE));
			} else {
				EntityItem suitpiece = new EntityItem(player.world, player.posX, player.posY+1, player.posZ, new ItemStack(ModItems.GOD_ESSENCE));
				player.world.spawnEntity(suitpiece);
			}
	}
	public static int hasOffering(Item item) {
		for(int i = 0; i < offerings.size(); i++) {
			if (offerings.get(i).getItem() == item) {
				
				return offerings.get(i).getCount();
			}
		}
		return -1;
	}
}

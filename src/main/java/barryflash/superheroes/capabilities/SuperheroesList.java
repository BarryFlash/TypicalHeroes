package barryflash.superheroes.capabilities;

import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemAntmanArmor;
import barryflash.superheroes.items.armor.ItemBatmanArmor;
import barryflash.superheroes.items.armor.ItemHulkArmor;
import barryflash.superheroes.items.armor.ItemIronmanMark50ArcReactorArmor;
import barryflash.superheroes.items.armor.ItemIronmanMark50Armor;
import barryflash.superheroes.items.armor.ItemSupermanArmor;
import barryflash.superheroes.items.armor.ItemWaspArmor;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import net.minecraft.entity.player.EntityPlayer;

public class SuperheroesList implements ISuperheroes {

	@Override
	public boolean isSuperman(EntityPlayer player) {
		if (ItemSupermanArmor.isWearingFullSet(player, ModItems.SupermanChest,  ModItems.SupermanLeggings,  ModItems.SupermanBoots)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIronman(EntityPlayer player) {
		if (ItemIronmanMark50Armor.isWearingFullSet(player, ModItems.IronManMk50Helmet, ModItems.IronManMk50Chest, ModItems.IronManMk50Legs, ModItems.IronManMk50Boots)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isBatman(EntityPlayer player) {
		if (ItemBatmanArmor.isWearingFullSet(player, ModItems.BatmanCowl, ModItems.BatmanChest, ModItems.BatmanLeggings, ModItems.BatmanBoots)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isWonderWoman(EntityPlayer player) {
		if (ItemWonderWomanArmor.isWearingFullSet(player, ModItems.WonderWomanTiara, ModItems.WonderWomanChestplate, ModItems.WonderWomanSkirt, ModItems.WonderWomanBoots)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isAntman(EntityPlayer player) {
		//if (ItemAntmanArmor.isWearingFullSet(player, ModItems.AntmanHelmet, ModItems.AntmanChest, ModItems.AntmanLegs, ModItems.AntmanFeet)) {
			//return true;
		//}
		//else {
			return false;
		//}
	}

	@Override
	public boolean isWasp(EntityPlayer player) {
		//if (ItemWaspArmor.isWearingFullSet(player, ModItems.WaspHelmet, ModItems.WaspChest, ModItems.WaspLegs, ModItems.WaspFeet)) {
			//return true;
		//}
		//else {
			return false;
		//}
	}

	@Override
	public boolean isIronmanReactor(EntityPlayer player) {
		if (ItemIronmanMark50ArcReactorArmor.isWearingReactor(player, ModItems.IronManArcReactor)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isHulk(EntityPlayer player) {
		// TODO Auto-generated method stub
		if (ItemHulkArmor.isWearingHulk(player)) {
			return true;
		} else {
			return false;
		}
	}

}

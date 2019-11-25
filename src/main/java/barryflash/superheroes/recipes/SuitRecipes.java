package barryflash.superheroes.recipes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import barryflash.superheroes.init.ModBlocks;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.util.ColorHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SuitRecipes {
	public static final List<ItemStack> ironmanIngredients = new ArrayList<ItemStack>();
	public static final List<Item> ironmanSuit = new ArrayList<Item>();
	public static final List ironman = new ArrayList();
	
	public static final List<ItemStack> supermanIngredients = new ArrayList<ItemStack>();
	public static final List<Item> supermanSuit = new ArrayList<Item>();
	public static final List superman = new ArrayList();
	
	public static final List<ItemStack> batmanIngredients = new ArrayList<ItemStack>();
	public static final List<Item> batmanSuit = new ArrayList<Item>();
	public static final List batman = new ArrayList();
	
	public static final List<ItemStack> wonderwomanIngredients = new ArrayList<ItemStack>();
	public static final List<Item> wonderwomanSuit = new ArrayList<Item>();
	public static final List wonderwoman = new ArrayList();
	
	public static final List<ItemStack> antmanIngredients = new ArrayList<ItemStack>();
	public static final List<Item> antmanSuit = new ArrayList<Item>();
	public static final List antman = new ArrayList();
	
	public static final List<ItemStack> hawkeyeIngredients = new ArrayList<ItemStack>();
	public static final List<Item> hawkeyeSuit = new ArrayList<Item>();
	public static final List hawkeye = new ArrayList();
	
	public static final List<ItemStack> blackwidowIngredients = new ArrayList<ItemStack>();
	public static final List<Item> blackwidowSuit = new ArrayList<Item>();
	public static final List blackwidow = new ArrayList();
	
	public static final List<ItemStack> lokiIngredients = new ArrayList<ItemStack>();
	public static final List<Item> lokiSuit = new ArrayList<Item>();
	public static final List loki = new ArrayList();
	
	public static final List<ItemStack> thorIngredients = new ArrayList<ItemStack>();
	public static final List<Item> thorSuit = new ArrayList<Item>();
	public static final List thor = new ArrayList();
	
	public static final List<ItemStack> zodIngredients = new ArrayList<ItemStack>();
	public static final List<Item> zodSuit = new ArrayList<Item>();
	public static final List zod = new ArrayList();
	
	public static final List<ItemStack> shazamIngredients = new ArrayList<ItemStack>();
	public static final List<Item> shazamSuit = new ArrayList<Item>();
	public static final List shazam = new ArrayList();
	
	public static void registerSuitRecipes() {
		//IronMan
		ironmanIngredients.add(new ItemStack(ModItems.TITANIUM_GOLD_NANOTECH,16));
		ironmanIngredients.add(new ItemStack(ModItems.titanium_ingot,32));
		ironmanIngredients.add(new ItemStack(ModItems.CIRCUIT_BOARD, 32));
		ironmanSuit.add(ModItems.IronManArcReactor);
		ironman.add(ironmanIngredients);
		ironman.add(ironmanSuit);
		
		//Superman
		supermanIngredients.add(new ItemStack(ModBlocks.CODEX_BLOCK,1));
		supermanIngredients.add(new ItemStack(ModItems.TITANIUM_GOLD_CARBONFIBER,32));
		supermanIngredients.add(new ItemStack(ModBlocks.KRYPTONITE_BLOCK, 15));
		supermanIngredients.add(new ItemStack(Items.DIAMOND,32));
		supermanSuit.add(ModItems.SupermanChest);
		supermanSuit.add(ModItems.SupermanLeggings);
		supermanSuit.add(ModItems.SupermanBoots);
		superman.add(supermanIngredients);
		superman.add(supermanSuit);
		
		//Batman
		batmanIngredients.add(new ItemStack(ModBlocks.TITANIUMGOLD_BLOCK,2));
		batmanIngredients.add(new ItemStack(ModItems.TITANIUM_GOLD_CARBONFIBER,64));
		batmanIngredients.add(new ItemStack(ModItems.CIRCUIT_BOARD, 10));
		batmanSuit.add(ModItems.BatmanCowl);
		batmanSuit.add(ModItems.BatmanChest);
		batmanSuit.add(ModItems.BatmanLeggings);
		batmanSuit.add(ModItems.BatmanBoots);
		batman.add(batmanIngredients);
		batman.add(batmanSuit);
		
		//WonderWoman
		wonderwomanIngredients.add(new ItemStack(ModItems.GOD_ESSENCE,2));
		wonderwomanIngredients.add(new ItemStack(ModItems.TITANIUM_GOLD_CARBONFIBER,40));
		wonderwomanIngredients.add(new ItemStack(Items.GOLD_INGOT,10));
		wonderwomanIngredients.add(new ItemStack(Items.IRON_INGOT, 32));
		wonderwomanIngredients.add(new ItemStack(Items.LEATHER, 32));
		wonderwomanSuit.add(ModItems.WonderWomanTiara);
		wonderwomanSuit.add(ModItems.WonderWomanChestplate);
		wonderwomanSuit.add(ModItems.WonderWomanSkirt);
		wonderwomanSuit.add(ModItems.WonderWomanBoots);
		wonderwoman.add(wonderwomanIngredients);
		wonderwoman.add(wonderwomanSuit);
		
		//Black Widow
		blackwidowIngredients.add(new ItemStack(ModItems.IRON_FIBER, 16));
		blackwidowIngredients.add(new ItemStack(Items.LEATHER, 16));
		blackwidowIngredients.add(new ItemStack(ModItems.CIRCUIT_BOARD, 2));
		blackwidowSuit.add(ModItems.BlackWidowChest);
		blackwidowSuit.add(ModItems.BlackWidowLegs);
		blackwidowSuit.add(ModItems.BlackWidowBoots);
		blackwidow.add(blackwidowIngredients);
		blackwidow.add(blackwidowSuit);
		
		//Hawkeye
		hawkeyeIngredients.add(new ItemStack(ModItems.IRON_FIBER, 16));
		hawkeyeIngredients.add(new ItemStack(Items.LEATHER, 16));
		hawkeyeIngredients.add(new ItemStack(Items.BOW, 1));
		hawkeyeIngredients.add(new ItemStack(ModItems.CIRCUIT_BOARD, 1));
		hawkeyeSuit.add(ModItems.HawkeyeChest);
		hawkeyeSuit.add(ModItems.HawkeyeLegs);
		hawkeyeSuit.add(ModItems.HawkeyeBoots);
		hawkeye.add(hawkeyeIngredients);
		hawkeye.add(hawkeyeSuit);
		
		//Loki
		lokiIngredients.add(new ItemStack(Items.GOLD_INGOT, 32));
		lokiIngredients.add(new ItemStack(Items.EMERALD, 16));
		lokiIngredients.add(new ItemStack(ModItems.TITANIUM_GOLD_CARBONFIBER, 20));
		lokiIngredients.add(new ItemStack(ModItems.GOD_ESSENCE,2));
		lokiIngredients.add(new ItemStack(Items.TOTEM_OF_UNDYING, 1));
		lokiSuit.add(ModItems.LokiHelmet);
		lokiSuit.add(ModItems.LokiChest);
		lokiSuit.add(ModItems.LokiLegs);
		lokiSuit.add(ModItems.LokiBoots);
		loki.add(lokiIngredients);
		loki.add(lokiSuit);
		
		//Thor
		thorIngredients.add(new ItemStack(Item.getItemFromBlock(Blocks.IRON_BLOCK), 16));
		thorIngredients.add(new ItemStack(ModItems.TITANIUM_GOLD_CARBONFIBER, 40));
		thorIngredients.add(new ItemStack(ModItems.GOD_ESSENCE,2));
		thorSuit.add(ModItems.ThorChest);
		thorSuit.add(ModItems.ThorLeggings);
		thorSuit.add(ModItems.ThorBoots);
		thor.add(thorIngredients);
		thor.add(thorSuit);
		
		//Zod
		zodIngredients.add(new ItemStack(ModBlocks.CODEX_BLOCK,1));
		zodIngredients.add(new ItemStack(ModItems.TITANIUM_GOLD_CARBONFIBER,32));
		zodIngredients.add(new ItemStack(Items.DIAMOND,32));
		zodIngredients.add(new ItemStack(Item.getItemFromBlock(Blocks.IRON_BLOCK), 16));
		zodSuit.add(ModItems.GeneralZodChest);
		zodSuit.add(ModItems.GeneralZodLeggings);
		zodSuit.add(ModItems.GeneralZodBoots);
		zod.add(zodIngredients);
		zod.add(zodSuit);

		//Shazam
		shazamIngredients.add(new ItemStack(ModItems.TITANIUM_GOLD_CARBONFIBER,40));
		shazamIngredients.add(new ItemStack(Items.GOLD_INGOT,32));
		shazamIngredients.add(new ItemStack(ModItems.GOD_ESSENCE,2));
		shazamSuit.add(ModItems.ShazamChest);
		shazamSuit.add(ModItems.ShazamLeggings);
		shazamSuit.add(ModItems.ShazamBoots);
		shazam.add(shazamIngredients);
		shazam.add(shazamSuit);
		/*
		//Ant-man
		antmanIngredients.add(new ItemStack(ModItems.PYM_PARTICLES,16));
		antmanIngredients.add(new ItemStack(ModItems.CIRCUIT_BOARD,32));
		antmanIngredients.add(new ItemStack(ModItems.RED_TITANIUM_GOLD_CARBONFIBER,24));
		antmanIngredients.add(new ItemStack(ModItems.BLACK_TITANIUM_GOLD_CARBONFIBER,10));
		antmanIngredients.add(new ItemStack(Blocks.IRON_BLOCK, 8));
		antmanSuit.add(ModItems.AntmanHelmet);
		antmanSuit.add(ModItems.AntmanChest);
		antmanSuit.add(ModItems.AntmanLegs);
		antmanSuit.add(ModItems.AntmanFeet);
		antman.add(antmanIngredients);
		antman.add(antmanSuit);
		
		//Wasp
		waspIngredients.add(new ItemStack(ModItems.PYM_PARTICLES,16));
		waspIngredients.add(new ItemStack(ModItems.CIRCUIT_BOARD,32));
		waspIngredients.add(new ItemStack(ModItems.RED_TITANIUM_GOLD_CARBONFIBER,24));
		waspIngredients.add(new ItemStack(ModItems.BLACK_TITANIUM_GOLD_CARBONFIBER,10));
		waspIngredients.add(new ItemStack(Blocks.IRON_BLOCK, 8));
		waspSuit.add(ModItems.WaspHelmet);
		waspSuit.add(ModItems.WaspChest);
		waspSuit.add(ModItems.WaspLegs);
		waspSuit.add(ModItems.WaspFeet);
		wasp.add(waspIngredients);
		wasp.add(waspSuit);
		*/
		
	}
	public static boolean checkInventoryForIngredients(InventoryPlayer inv, List<ItemStack> ingredients) {
		for (int i = 0; i < ingredients.size(); i++) {
			if (!inv.hasItemStack(ingredients.get(i))) {
				return false;
			} else {
				if (inv.getStackInSlot(getSlotFor(inv, ingredients.get(i))).getCount() < ingredients.get(i).getCount()) {
					return false;
				}
			}
		}
		return true;
	}
	public static void removeIngredientsFromInventory(EntityPlayer player, InventoryPlayer inv, List suit) {
		List<ItemStack> ingredients = (List<ItemStack>) suit.get(0);
		for (int i = 0; i < ingredients.size(); i++) {
			if (inv.hasItemStack(ingredients.get(i))) {
				if (inv.getStackInSlot(getSlotFor(inv, ingredients.get(i))).getCount() >= ingredients.get(i).getCount()) {
					inv.decrStackSize(getSlotFor(inv, ingredients.get(i)), ingredients.get(i).getCount());
					
				}
			}
		}
		addOutput(player, (List<Item>) suit.get(1));
	}
	public static void addOutput(EntityPlayer player, List<Item> suit) {
		for (int i = 0; i < suit.size(); i++) {
			if (player.inventory.getFirstEmptyStack() != -1) {
				player.inventory.addItemStackToInventory(new ItemStack(suit.get(i)));
			} else {
				EntityItem suitpiece = new EntityItem(player.world, player.posX, player.posY+1, player.posZ, new ItemStack(suit.get(i)));
				player.world.spawnEntity(suitpiece);
			}
		}
	}
	public static List<String> neededIngredients(InventoryPlayer inv, List suit) {
		List<ItemStack> ingredients = (List<ItemStack>) suit.get(0);
		List<String> tooltip = new ArrayList<String>();
		tooltip.add(ColorHelper.RED() + ColorHelper.BOLD() + ColorHelper.UNDERLINE() + "You are missing materials!");
		for (int i = 0; i < ingredients.size(); i++) {
			if (inv.hasItemStack(ingredients.get(i))) {
				if (inv.getStackInSlot(getSlotFor(inv, ingredients.get(i))).getCount() < ingredients.get(i).getCount()) {
					int missing = ingredients.get(i).getCount()-inv.getStackInSlot(getSlotFor(inv, ingredients.get(i))).getCount();
					tooltip.add(ColorHelper.GOLD() + ColorHelper.ITALIC() + "You need " + missing +" more " + ingredients.get(i).getDisplayName());
				}
			} else {
				tooltip.add(ColorHelper.GOLD() + ColorHelper.ITALIC() + "You need " + ingredients.get(i).getCount() + " more " + ingredients.get(i).getDisplayName());
			}
		}
		return tooltip;
		
	}
	private static boolean stackEqualExact(ItemStack stack1, ItemStack stack2)
    {
        return stack1.getItem() == stack2.getItem() && (!stack1.getHasSubtypes() || stack1.getMetadata() == stack2.getMetadata()) && ItemStack.areItemStackTagsEqual(stack1, stack2);
    }
	public static int getSlotFor(InventoryPlayer inv, ItemStack stack)
    {
        for (int i = 0; i < inv.getSizeInventory(); ++i)
        {
            if (!((ItemStack)inv.getStackInSlot(i)).isEmpty() && stackEqualExact(stack, inv.getStackInSlot(i)))
            {
                return i;
            }
        }

        return -1;
    }
}

package barryflash.superheroes.init;

import java.util.Random;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager.ITradeList;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

public class ModVillagerTrades implements ITradeList {

	@Override
	public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random) {
		// TODO Auto-generated method stub
		recipeList.add(new MerchantRecipe(new ItemStack(Items.EMERALD,18),new ItemStack(Item.getItemFromBlock(ModBlocks.MOTHER_BOX),1)));
	}

	
}

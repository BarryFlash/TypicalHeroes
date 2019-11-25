package barryflash.superheroes.recipes;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;

import barryflash.superheroes.init.ModBlocks;
import barryflash.superheroes.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class NanoCompacterRecipes {
	private static final NanoCompacterRecipes INSTANCE = new NanoCompacterRecipes();
	private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
	private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
	
	public static NanoCompacterRecipes getInstance()

	{

		return INSTANCE;

	}
	private NanoCompacterRecipes()

	{
		
		addNanoCompacterRecipe(new ItemStack(ModItems.TITANIUMGOLD_INGOT), new ItemStack(ModItems.TITANIUM_GOLD_NANOPARTICLES), 10.0F);
		//addNanoCompacterRecipe(new ItemStack(ModItems.PYM_COMPOSITE), new ItemStack(ModItems.PYM_PARTICLES), 5.0F);
		addNanoCompacterRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.URANIUM_BLOCK)), new ItemStack(ModItems.RADIATION_VIAL), 25.0F);
		addNanoCompacterRecipe(new ItemStack(ModItems.SUPERSOLDIER_COMPOSITE), new ItemStack(ModItems.SUPERSOLDIER_SERUM), 25.0F);

	}

	public void addNanoCompacterRecipe(ItemStack input1, ItemStack result, float experience) {
		ItemStack bottle = new ItemStack(Items.GLASS_BOTTLE);
		
		if(getResult(input1, bottle) != ItemStack.EMPTY) return;
		
		smeltingList.put(input1, bottle, result);
		
		experienceList.put(result, Float.valueOf(experience));
	}
	
	public ItemStack getResult(ItemStack input1, ItemStack input2) {

		for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : smeltingList.columnMap().entrySet()) 
		{
			
			if(compareItemStacks(input2, (ItemStack)entry.getKey())) 
			{
				for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) 
				{
					
					if(compareItemStacks(input1, (ItemStack)ent.getKey())) 
					{
						
						return (ItemStack)ent.getValue().copy();
					}
				}
			}
			
		}
		
		return ItemStack.EMPTY;
	}
	
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
	{
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}
	
	public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList() 
	{
		return this.smeltingList;
	}
	
	public float getExperience(ItemStack stack)
	{
		for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()) 
		{
			if(this.compareItemStacks(stack, (ItemStack)entry.getKey())) 
			{
				return ((Float)entry.getValue()).floatValue();
			}
		}
		return 0.0F;
	}
}

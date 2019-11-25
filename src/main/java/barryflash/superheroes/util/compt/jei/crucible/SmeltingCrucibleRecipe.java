package barryflash.superheroes.util.compt.jei.crucible;

import java.util.List;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

public class SmeltingCrucibleRecipe implements IRecipeWrapper {
	private final List<ItemStack> inputs;
	private final ItemStack output;
	public SmeltingCrucibleRecipe(List<ItemStack> inputs, ItemStack output) {
		this.inputs = inputs;
		this.output = output;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void getIngredients(IIngredients ingredients) {
		// TODO Auto-generated method stub
		ingredients.setInputs(ItemStack.class, inputs);
		ingredients.setOutput(ItemStack.class, output);
	}
	@Override
	public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		
	}
}

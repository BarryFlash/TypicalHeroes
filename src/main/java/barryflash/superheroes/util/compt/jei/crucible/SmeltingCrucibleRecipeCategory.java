package barryflash.superheroes.util.compt.jei.crucible;

import barryflash.superheroes.Reference;
import barryflash.superheroes.util.compt.jei.RecipeCategories;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import net.minecraft.client.Minecraft;

public class SmeltingCrucibleRecipeCategory extends AbstractSmeltingCrucibleRecipeCategory<SmeltingCrucibleRecipe> {

	private final IDrawable background;
	private final String name;
	public SmeltingCrucibleRecipeCategory(IGuiHelper helper) {
		super(helper);
		background = helper.createDrawable(TEXTURES, 4, 12, 150, 60);
		name = "Smelting Crucible";
	}
	@Override
	public IDrawable getBackground() {
		// TODO Auto-generated method stub
		return background;
	}
	@Override
	public void drawExtras(Minecraft minecraft) {
		// TODO Auto-generated method stub
		animatedFlame.draw(minecraft, 4, 42);
		animatedArrow.draw(minecraft, 40, 23);
	}
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public String getModName() {
		// TODO Auto-generated method stub
		return Reference.NAME;
	}
	@Override
	public String getUid() {
		// TODO Auto-generated method stub
		return RecipeCategories.SMELTING_CRUCIBLE;
	}
	public void setRecipe(mezz.jei.api.gui.IRecipeLayout recipeLayout, SmeltingCrucibleRecipe recipeWrapper, mezz.jei.api.ingredients.IIngredients ingredients) {
		IGuiItemStackGroup stacks = recipeLayout.getItemStacks();
		stacks.init(input1, true, 21, 2);
		stacks.init(input2, true, 21, 42);
		stacks.init(output, false, 76, 23);
		stacks.set(ingredients);
	};
}

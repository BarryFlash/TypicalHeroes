package barryflash.superheroes.util.compt.jei;

import java.util.IllegalFormatException;

import barryflash.superheroes.util.compt.jei.crucible.SmeltingCrucibleRecipeCategory;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.util.text.translation.I18n;

public class JEICompat implements IModPlugin {

	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		// TODO Auto-generated method stub
		final IJeiHelpers helpers = registry.getJeiHelpers();
		final IGuiHelper gui = helpers.getGuiHelper();
		
		registry.addRecipeCategories(new SmeltingCrucibleRecipeCategory(gui));
	}
	@Override
	public void register(IModRegistry registry) {
		// TODO Auto-generated method stub
		IModPlugin.super.register(registry);
	}
	public static String translateToLocal(String key) {
		if (I18n.canTranslate(key)) return I18n.translateToLocal(key);
		else return I18n.translateToFallback(key);
	}
	public static String translateToLocalFormatted(String key, Object... format) {
		String s = translateToLocal(key);
		try {
			return String.format(s, format);
		} catch(IllegalFormatException e) {
			return "Format error: " + s;
		}
	}
}

package barryflash.superheroes.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

	public static void init() {
		GameRegistry.addSmelting(ModBlocks.TITANIUM_ORE_BLOCK, new ItemStack(ModItems.titanium_ingot, 1), 1.5F);
		GameRegistry.addSmelting(ModBlocks.URANIUM_ORE_BLOCK, new ItemStack(ModItems.URANIUM_INGOT, 1), 5.5F);
		GameRegistry.addSmelting(ModBlocks.VIBRANIUM_ORE, new ItemStack(ModItems.VIBRANIUM, 1), 5.5F);
	}
}

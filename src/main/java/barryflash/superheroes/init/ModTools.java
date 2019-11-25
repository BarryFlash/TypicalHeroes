package barryflash.superheroes.init;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.items.ItemAquamanTrident;
import barryflash.superheroes.items.ItemBatmanKryptoniteSpear;
import barryflash.superheroes.items.ItemThorHammer;
import barryflash.superheroes.items.ItemWonderWomanGodkiller;
import barryflash.superheroes.util.Utils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTools {
	
	/*public static final ToolMaterial AmazonianMaterial = EnumHelper.addToolMaterial(Reference.MODID + ":amazonian", 2, 0, 2.0F, 3.0F, 0);
	public static final ToolMaterial AtlantianMaterial = EnumHelper.addToolMaterial(Reference.MODID + ":atlantian", 2, 0, 1.0F, 2.0F, 0);
	public static final ToolMaterial KryptoniteMaterial = EnumHelper.addToolMaterial(Reference.MODID + ":kryptonite", 2, 0, 0.2F, 4.0F, 0);
	public static final ToolMaterial ThorMaterial = EnumHelper.addToolMaterial(Reference.MODID + ":thor", 2, 0, 0.5F, 5.0F, 0);
	
	public static Item WonderWomanSword;
	
	//public static Item aquaman_trident;
	//public static Item batman_kryptonitespear;
	//public static Item thor_hammer;
			
	public static void init() {
		WonderWomanSword = new ItemWonderWomanGodkiller(AmazonianMaterial, "WonderWoman_Sword", "WonderWoman_Sword");
		//aquaman_trident = new ItemAquamanTrident(AtlantianMaterial, "aquaman_trident", "aquaman_trident");
		//batman_kryptonitespear = new ItemBatmanKryptoniteSpear(KryptoniteMaterial, "batman_kryptonitespear", "batman_kryptonitespear");
		//thor_hammer = new ItemThorHammer(ThorMaterial, "thor_hammer", "thor_hammer");
	}
	
	public static void register() {
		registerItem(WonderWomanSword);
		//registerItem(aquaman_trident);
		//registerItem(batman_kryptonitespear);
		//registerItem(thor_hammer);
	}
	
	public static void registerRenders() {
		registerRender(WonderWomanSword);
		//registerRender(aquaman_trident);
		//registerRender(batman_kryptonitespear);
		//registerRender(thor_hammer);
	}
	
	public static void registerItem(Item item) {
		item.setCreativeTab(SuperheroesMod.creativeTab);
		GameRegistry.register(item);
		Utils.getLogger().info("Registered item: " + item.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(Reference.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
		Utils.getLogger().info("Register render for " + item.getUnlocalizedName().substring(5));

	}
*/
}

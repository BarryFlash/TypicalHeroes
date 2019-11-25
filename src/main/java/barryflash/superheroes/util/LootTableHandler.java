package barryflash.superheroes.util;

import barryflash.superheroes.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler {

	public static final ResourceLocation KRYPTONITE_SHIP = LootTableList.register(new ResourceLocation(Reference.MODID, "kryptonite_ship"));
	public static final ResourceLocation THEMYSCIRA_VILLAGE = LootTableList.register(new ResourceLocation(Reference.MODID, "themyscira_village"));
	
}

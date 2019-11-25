package barryflash.superheroes.client;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	
	public static Configuration config;
	
	//Settings
	public static int ThemysciraBiomeId;
	public static boolean spawnBiomeInOverworld;
	
	public static int ThemysciraDimensionId;
	
	public static void init (File file) {
		config = new Configuration(file);
		syncConfig();
	}
	
	public static void syncConfig() {
		String category;
		
		category = "Biome";
		config.addCustomCategoryComment(category, "Biome Settings");
		ThemysciraBiomeId = config.getInt("ThemysciraBiomeId", category, 40, 40, 126, "The biome id of Themyscira biome");
		spawnBiomeInOverworld = config.getBoolean("spawnBiomeInOverworld", category, true, "Whether or not the Superhero Mod biomes spawn in overworld.");
		
		category = "Dimension";
		config.addCustomCategoryComment(category, "Dimension Settings");
		ThemysciraDimensionId = config.getInt("ThemysciraDimensionId", category, 2, 2, 100, "The dimension id of Themyscira");
		
		config.save();
	}
	

}

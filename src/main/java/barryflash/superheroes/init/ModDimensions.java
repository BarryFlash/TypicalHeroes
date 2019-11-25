package barryflash.superheroes.init;

import com.typesafe.config.Config;

import barryflash.superheroes.Reference;
import barryflash.superheroes.world.dimensions.DimensionSpace;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class ModDimensions {

	public static DimensionType spaceDimensionType;
	 public static int dimensionId = 100;
	public static void init() {
		registerDimensionTypes();
		registerDimensions();
	}
	 private static void registerDimensionTypes() {
		 spaceDimensionType = DimensionType.register(Reference.MODID, "_test", dimensionId, DimensionSpace.class, false);
	    }

	    private static void registerDimensions() {
	    	DimensionManager.registerDimension(dimensionId, spaceDimensionType);
	    }

}

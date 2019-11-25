package barryflash.superheroes.init;

import barryflash.superheroes.tileentities.TileSuitMaker;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntities {
	 public static void init() {
	        GameRegistry.registerTileEntity(TileSuitMaker.class, "suitmaker_tile_entity");
	       
	    }

}

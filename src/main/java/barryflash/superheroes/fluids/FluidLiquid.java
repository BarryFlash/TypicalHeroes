package barryflash.superheroes.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.EntityViewRenderEvent.FogColors;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Mod.EventHandler;

public class FluidLiquid extends Fluid {

	public FluidLiquid(String name, ResourceLocation still, ResourceLocation flowing) {
		super(name, still, flowing);
		setUnlocalizedName(name);
	}
	
}

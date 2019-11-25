package barryflash.superheroes.init;

import barryflash.superheroes.Reference;
import barryflash.superheroes.fluids.FluidLiquid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluids {

	public static final Fluid MOLTEN_TITANIUM_FLUID = new Fluid("molten_titanium", new ResourceLocation("sm:blocks/molten_titanium_still"), new ResourceLocation("sm:blocks/molten_titanium_flow"));
	public static final Fluid MOLTEN_GOLD_FLUID = new Fluid("molten_gold", new ResourceLocation("sm:blocks/molten_gold_still"), new ResourceLocation("sm:blocks/molten_gold_flow"));
	public static final Fluid MOLTEN_TITANIUMGOLD_FLUID = new Fluid("molten_titaniumgold", new ResourceLocation("sm:blocks/molten_titaniumgold_still"), new ResourceLocation("sm:blocks/molten_titaniumgold_flow"));
	public static void registerFluids() {
		registerFluid(MOLTEN_TITANIUM_FLUID);
		registerFluid(MOLTEN_GOLD_FLUID);
		registerFluid(MOLTEN_TITANIUMGOLD_FLUID);
	}
	public static void registerFluid(Fluid fluid) {
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
		
	}
}

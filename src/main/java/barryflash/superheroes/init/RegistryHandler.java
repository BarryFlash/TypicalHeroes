package barryflash.superheroes.init;

import barryflash.superheroes.Reference;
import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.tileentities.TileEntityCable;
import barryflash.superheroes.tileentities.TileEntityDnaExtractor;
import barryflash.superheroes.tileentities.TileEntityFuelGenerator;
import barryflash.superheroes.tileentities.TileEntityFusionChamber;
import barryflash.superheroes.tileentities.TileEntityKryptonite;
import barryflash.superheroes.tileentities.TileEntityLightningExtractor;
import barryflash.superheroes.tileentities.TileEntityNanoCompacter;
import barryflash.superheroes.tileentities.TileEntitySmeltingCrucible;
import barryflash.superheroes.tileentities.TileEntitySuitMaker;
import barryflash.superheroes.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler {

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
		GameRegistry.registerTileEntity(TileEntitySmeltingCrucible.class, new ResourceLocation(Reference.MODID + ":smelting_crucible"));
		 GameRegistry.registerTileEntity(TileEntityFuelGenerator.class, new ResourceLocation(Reference.MODID + ":fuel_generator"));
		 GameRegistry.registerTileEntity(TileEntityNanoCompacter.class, new ResourceLocation(Reference.MODID + ":nano_compacter"));
		 GameRegistry.registerTileEntity(TileEntitySuitMaker.class, new ResourceLocation(Reference.MODID + ":suit_maker"));
		 GameRegistry.registerTileEntity(TileEntityDnaExtractor.class, new ResourceLocation(Reference.MODID + ":dna_extractor"));
		 GameRegistry.registerTileEntity(TileEntityKryptonite.class, new ResourceLocation(Reference.MODID + ":kryptonite"));
		 GameRegistry.registerTileEntity(TileEntityFusionChamber.class, new ResourceLocation(Reference.MODID + ":fusion_chamber"));
		 GameRegistry.registerTileEntity(TileEntityLightningExtractor.class, new ResourceLocation(Reference.MODID + ":lightning_extractor"));
		 //GameRegistry.registerTileEntity(TileEntityCable.class, new ResourceLocation(Reference.MODID + ":cable"));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for(Item item : ModItems.ITEMS) {
			if (item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
		}
		for(Block block : ModBlocks.BLOCKS) {
			if (block instanceof IHasModel) {
				((IHasModel)block).registerModels();
			}
		}
		RenderHandler.registerFluidMeshesAndStates(ModFluids.MOLTEN_TITANIUM_FLUID);
		RenderHandler.registerFluidMeshesAndStates(ModFluids.MOLTEN_GOLD_FLUID);
		RenderHandler.registerFluidMeshesAndStates(ModFluids.MOLTEN_TITANIUMGOLD_FLUID);
	}
	@SubscribeEvent
	public void registerSounds(RegistryEvent.Register<SoundEvent> event) {
		event.getRegistry().registerAll(THSoundHandler.SOUNDS.toArray(new SoundEvent[0]));
	}
}

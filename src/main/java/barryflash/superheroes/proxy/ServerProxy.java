package barryflash.superheroes.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		// TODO Auto-generated method stub
		super.preInit(e);
	}

	@Override
	public void init(FMLInitializationEvent e) {
		// TODO Auto-generated method stub
		super.init(e);
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub
		super.postInit(e);
	}

	@Override
	public void registerRenders() {
		// TODO Auto-generated method stub
		super.registerRenders();
	}

	@Override
	public void registerKeyBindings() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		// TODO Auto-generated method stub
		super.registerItemRenderer(item, meta, id);
	}
}

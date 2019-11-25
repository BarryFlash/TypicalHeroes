package barryflash.superheroes.proxy;

import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.capabilities.Antman;
import barryflash.superheroes.capabilities.AntmanStorage;
import barryflash.superheroes.capabilities.Attributes;
import barryflash.superheroes.capabilities.AttributesStorage;
import barryflash.superheroes.capabilities.Batman;
import barryflash.superheroes.capabilities.BatmanEventHandler;
import barryflash.superheroes.capabilities.BatmanStorage;
import barryflash.superheroes.capabilities.BlackWidow;
import barryflash.superheroes.capabilities.BlackWidowEventHandler;
import barryflash.superheroes.capabilities.BlackWidowStorage;
import barryflash.superheroes.capabilities.CapabilityHandler;
import barryflash.superheroes.capabilities.CaptainAmerica;
import barryflash.superheroes.capabilities.CaptainAmericaEventHandler;
import barryflash.superheroes.capabilities.CaptainAmericaStorage;
import barryflash.superheroes.capabilities.Cyborg;
import barryflash.superheroes.capabilities.CyborgEventHandler;
import barryflash.superheroes.capabilities.CyborgStorage;
import barryflash.superheroes.capabilities.Flash;
import barryflash.superheroes.capabilities.FlashEventHandler;
import barryflash.superheroes.capabilities.FlashStorage;
import barryflash.superheroes.capabilities.FusionChamber;
import barryflash.superheroes.capabilities.FusionChamberEventHandler;
import barryflash.superheroes.capabilities.FusionChamberStorage;
import barryflash.superheroes.capabilities.Hulk;
import barryflash.superheroes.capabilities.HulkEventHandler;
import barryflash.superheroes.capabilities.HulkStorage;
import barryflash.superheroes.capabilities.IAntman;
import barryflash.superheroes.capabilities.IAttributes;
import barryflash.superheroes.capabilities.IBatman;
import barryflash.superheroes.capabilities.IBlackWidow;
import barryflash.superheroes.capabilities.ICaptainAmerica;
import barryflash.superheroes.capabilities.ICyborg;
import barryflash.superheroes.capabilities.IFlash;
import barryflash.superheroes.capabilities.IFusionChamber;
import barryflash.superheroes.capabilities.IHulk;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IKeys;
import barryflash.superheroes.capabilities.ILoki;
import barryflash.superheroes.capabilities.IQuiver;
import barryflash.superheroes.capabilities.IShazam;
import barryflash.superheroes.capabilities.ISize;
import barryflash.superheroes.capabilities.ISpecialEffects;
import barryflash.superheroes.capabilities.ISuperheroes;
import barryflash.superheroes.capabilities.ISuperman;
import barryflash.superheroes.capabilities.IThor;
import barryflash.superheroes.capabilities.IWasp;
import barryflash.superheroes.capabilities.IWonderWoman;
import barryflash.superheroes.capabilities.IZeusAltar;
import barryflash.superheroes.capabilities.IZod;
import barryflash.superheroes.capabilities.Ironman;
import barryflash.superheroes.capabilities.IronmanEventHandler;
import barryflash.superheroes.capabilities.IronmanStorage;
import barryflash.superheroes.capabilities.Keys;
import barryflash.superheroes.capabilities.KeysStorage;
import barryflash.superheroes.capabilities.Loki;
import barryflash.superheroes.capabilities.LokiEventHandler;
import barryflash.superheroes.capabilities.LokiStorage;
import barryflash.superheroes.capabilities.Quiver;
import barryflash.superheroes.capabilities.QuiverEventHandler;
import barryflash.superheroes.capabilities.QuiverStorage;
import barryflash.superheroes.capabilities.Shazam;
import barryflash.superheroes.capabilities.ShazamEventHandler;
import barryflash.superheroes.capabilities.ShazamStorage;
import barryflash.superheroes.capabilities.Size;
import barryflash.superheroes.capabilities.SizeStorage;
import barryflash.superheroes.capabilities.SpecialEffects;
import barryflash.superheroes.capabilities.SpecialEffectsEventHandler;
import barryflash.superheroes.capabilities.SpecialEffectsStorage;
import barryflash.superheroes.capabilities.SuperheroesList;
import barryflash.superheroes.capabilities.SuperheroesStorage;
import barryflash.superheroes.capabilities.Superman;
import barryflash.superheroes.capabilities.SupermanEventHandler;
import barryflash.superheroes.capabilities.SupermanStorage;
import barryflash.superheroes.capabilities.Thor;
import barryflash.superheroes.capabilities.ThorEventHandler;
import barryflash.superheroes.capabilities.ThorStorage;
import barryflash.superheroes.capabilities.Wasp;
import barryflash.superheroes.capabilities.WaspEventHandler;
import barryflash.superheroes.capabilities.WaspStorage;
import barryflash.superheroes.capabilities.WonderWoman;
import barryflash.superheroes.capabilities.WonderWomanEventHandler;
import barryflash.superheroes.capabilities.WonderWomanStorage;
import barryflash.superheroes.capabilities.ZeusAltar;
import barryflash.superheroes.capabilities.ZeusAltarEventHandler;
import barryflash.superheroes.capabilities.ZeusAltarStorage;
import barryflash.superheroes.capabilities.Zod;
import barryflash.superheroes.capabilities.ZodEventHandler;
import barryflash.superheroes.capabilities.ZodStorage;
import barryflash.superheroes.client.gui.GuiHandler;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public abstract class CommonProxy {
	
	public void registerItemRenderer(Item item, int meta, String id) {
		
	}

	
	public void preInit(FMLPreInitializationEvent e) {
		//CapabilityManager.INSTANCE.register(IDoctorStrange.class, new DoctorStrangeStorage(), DoctorStrange.class);
		CapabilityManager.INSTANCE.register(IIronman.class, new IronmanStorage(), Ironman.class);
		//CapabilityManager.INSTANCE.register(IThanos.class, new ThanosStorage(), Thanos.class);
		CapabilityManager.INSTANCE.register(IThor.class, new ThorStorage(), Thor.class);
		//CapabilityManager.INSTANCE.register(IPortal.class, new PortalStorage(), Portal.class);
		//CapabilityManager.INSTANCE.register(IAquaman.class, new AquamanStorage(), Aquaman.class);
		//CapabilityManager.INSTANCE.register(IWasp.class, new WaspStorage(), Wasp.class);
		//CapabilityManager.INSTANCE.register(IAntman.class, new AntmanStorage(), Antman.class);
		CapabilityManager.INSTANCE.register(IFlash.class, new FlashStorage(), Flash.class);
		//CapabilityManager.INSTANCE.register(ISize.class, new SizeStorage(), Size.class);
		CapabilityManager.INSTANCE.register(IBatman.class, new BatmanStorage(), Batman.class);
		CapabilityManager.INSTANCE.register(IWonderWoman.class, new WonderWomanStorage(), WonderWoman.class);
		CapabilityManager.INSTANCE.register(ISuperman.class, new SupermanStorage(), Superman.class);
		CapabilityManager.INSTANCE.register(ISuperheroes.class, new SuperheroesStorage(), SuperheroesList.class);
		CapabilityManager.INSTANCE.register(IZeusAltar.class, new ZeusAltarStorage(), ZeusAltar.class);
		CapabilityManager.INSTANCE.register(IShazam.class, new ShazamStorage(), Shazam.class);
		CapabilityManager.INSTANCE.register(IHulk.class, new HulkStorage(), Hulk.class);
		CapabilityManager.INSTANCE.register(IKeys.class, new KeysStorage(), Keys.class);
		CapabilityManager.INSTANCE.register(ICaptainAmerica.class, new CaptainAmericaStorage(), CaptainAmerica.class);
		CapabilityManager.INSTANCE.register(IAttributes.class, new AttributesStorage(), Attributes.class);
		CapabilityManager.INSTANCE.register(IBlackWidow.class, new BlackWidowStorage(), BlackWidow.class);
		CapabilityManager.INSTANCE.register(IFusionChamber.class, new FusionChamberStorage(), FusionChamber.class);
		CapabilityManager.INSTANCE.register(ISpecialEffects.class, new SpecialEffectsStorage(), SpecialEffects.class);
		CapabilityManager.INSTANCE.register(ILoki.class, new LokiStorage(), Loki.class);
		CapabilityManager.INSTANCE.register(IZod.class, new ZodStorage(), Zod.class);
		CapabilityManager.INSTANCE.register(ICyborg.class, new CyborgStorage(), Cyborg.class);
		CapabilityManager.INSTANCE.register(IQuiver.class, new QuiverStorage(), Quiver.class);
		MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
		//MinecraftForge.EVENT_BUS.register(new DoctorStrangeEventHandler());
		MinecraftForge.EVENT_BUS.register(new QuiverEventHandler());
		MinecraftForge.EVENT_BUS.register(new CyborgEventHandler());
		MinecraftForge.EVENT_BUS.register(new ZodEventHandler());
		MinecraftForge.EVENT_BUS.register(new LokiEventHandler());
		MinecraftForge.EVENT_BUS.register(new SpecialEffectsEventHandler());
		MinecraftForge.EVENT_BUS.register(new FusionChamberEventHandler());
		MinecraftForge.EVENT_BUS.register(new WonderWomanEventHandler());

		MinecraftForge.EVENT_BUS.register(new CaptainAmericaEventHandler());
		MinecraftForge.EVENT_BUS.register(new ShazamEventHandler());
		MinecraftForge.EVENT_BUS.register(new HulkEventHandler());
		//MinecraftForge.EVENT_BUS.register(new SizeEventHandler());
		MinecraftForge.EVENT_BUS.register(new FlashEventHandler());
		MinecraftForge.EVENT_BUS.register(new SupermanEventHandler());
		//MinecraftForge.EVENT_BUS.register(new WaspEventHandler());
		MinecraftForge.EVENT_BUS.register(new BatmanEventHandler());
		MinecraftForge.EVENT_BUS.register(new IronmanEventHandler());
		MinecraftForge.EVENT_BUS.register(new BlackWidowEventHandler());
		//MinecraftForge.EVENT_BUS.register(new ThanosEventHandler());
		//MinecraftForge.EVENT_BUS.register(new AquamanEventHandler());
		//MinecraftForge.EVENT_BUS.register(new AntmanEventHandler());
		MinecraftForge.EVENT_BUS.register(new ZeusAltarEventHandler());
		MinecraftForge.EVENT_BUS.register(new ThorEventHandler());
		//MinecraftForge.EVENT_BUS.register(new DoctorStrangeShields());
		//MinecraftForge.EVENT_BUS.register(new SpaceHandler());
		//ModDimensions.init();
		
		
    }

	public void init(FMLInitializationEvent e) {
		//GameRegistry.registerWorldGenerator(new OreGen(), 0);
		//GameRegistry.registerWorldGenerator(new Gen(), 0);
		//GameRegistry.registerWorldGenerator(new AtlantisGen(), 0);
//		MinecraftForge.EVENT_BUS.register(new BraceletEventHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(SuperheroesMod.instance, new GuiHandler());

		
		
	}

	public void openMyGui(GuiScreen gui)
	{
	}
	public void registerTileEntities() {
		//GameRegistry.registerTileEntity(TileSuitMaker.class, Reference.MODID + ":suitmaker_tile_entity");
	}

    public void postInit(FMLPostInitializationEvent e) {
		
    }

	public void registerRenders() {
		
	}

	public void registerKeyBindings() {
		// TODO Auto-generated method stub
		
	}
	

		
		

	

}



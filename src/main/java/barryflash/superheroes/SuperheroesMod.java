package barryflash.superheroes;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Logger;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraftforge.common.config.Config.Type;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import barryflash.superheroes.client.ConfigHandler;
import barryflash.superheroes.client.KeyHandler;
import barryflash.superheroes.client.Keybinding;
import barryflash.superheroes.client.OreDictionaryHandler;
import barryflash.superheroes.client.RecipeHandler;
import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.client.TypicalHeroesBlocksCreativeTab;
import barryflash.superheroes.client.TypicalHeroesCreativeTab;
import barryflash.superheroes.client.TypicalHeroesMachinesCreativeTab;
import barryflash.superheroes.client.TypicalHeroesMaterialsCreativeTab;
import barryflash.superheroes.client.TypicalHeroesWeaponsCreativeTab;
import barryflash.superheroes.client.gui.GuiDoctorStrangePortal;
import barryflash.superheroes.client.render.ProjectileRenderCannonBlast;
import barryflash.superheroes.client.render.ProjectileRenderLasso;
import barryflash.superheroes.client.render.ProjectileRenderMissile;
import barryflash.superheroes.client.render.ProjectileRenderRepulsor;
import barryflash.superheroes.client.render.ProjectileRenderTiara;
import barryflash.superheroes.client.render.ProjectileRenderUnibeam;
import barryflash.superheroes.client.render.layers.DoctorStrangeCapeLayer;
import barryflash.superheroes.client.render.layers.DoctorStrangeShieldsLayer;
import barryflash.superheroes.entities.EntityAnt;
import barryflash.superheroes.entities.EntityDoctorStrangeCape;
import barryflash.superheroes.entities.EntityThanosPortal;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarang;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarangElectric;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarangExplosive;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarangPoison;
import barryflash.superheroes.entities.projectiles.EntityBatmanGrappleHook;
import barryflash.superheroes.entities.projectiles.EntityBatmanKryptoniteSpear;
import barryflash.superheroes.entities.projectiles.EntityBatmanSmokeBomb;
import barryflash.superheroes.entities.projectiles.EntityBlackWidowBite;
import barryflash.superheroes.entities.projectiles.EntityBullet;
import barryflash.superheroes.entities.projectiles.EntityCannonBlast;
import barryflash.superheroes.entities.projectiles.EntityCaptainAmericaShield;
import barryflash.superheroes.entities.projectiles.EntityGrowDisc;
import barryflash.superheroes.entities.projectiles.EntityLassoWhip;
import barryflash.superheroes.entities.projectiles.EntityMissile;
import barryflash.superheroes.entities.projectiles.EntityMjolnir;
import barryflash.superheroes.entities.projectiles.EntityRepulsor;
import barryflash.superheroes.entities.projectiles.EntityScepterBlast;
import barryflash.superheroes.entities.projectiles.EntityShrinkDisc;
import barryflash.superheroes.entities.projectiles.EntitySonarCannonBlast;
import barryflash.superheroes.entities.projectiles.EntityStormbreaker;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import barryflash.superheroes.entities.projectiles.EntityTrickArrow;
import barryflash.superheroes.entities.projectiles.EntityTrickArrowElectric;
import barryflash.superheroes.entities.projectiles.EntityTrickArrowExplosive;
import barryflash.superheroes.entities.projectiles.EntityTrickArrowFreeze;
import barryflash.superheroes.entities.projectiles.EntityTrickArrowGrapple;
import barryflash.superheroes.entities.projectiles.EntityTrickArrowKryptonite;
import barryflash.superheroes.entities.projectiles.EntityTrickArrowSmoke;
import barryflash.superheroes.entities.projectiles.EntityTrickArrowTranquilizer;
import barryflash.superheroes.entities.projectiles.EntityTrident;
import barryflash.superheroes.entities.projectiles.EntityUnibeam;
import barryflash.superheroes.entities.projectiles.EntityWaspBlast;
import barryflash.superheroes.entities.projectiles.EntityWaspBlastSmall;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.init.ModBlocks;
import barryflash.superheroes.init.ModFluids;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.init.ModRecipes;
import barryflash.superheroes.init.ModTools;
import barryflash.superheroes.init.ModVillagerTrades;
import barryflash.superheroes.init.RenderHandler;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.proxy.CommonProxy;
import barryflash.superheroes.recipes.NanoCompacterRecipes;
import barryflash.superheroes.recipes.SuitRecipes;
import barryflash.superheroes.recipes.TMURecipes;
import barryflash.superheroes.recipes.ZeusAltarOfferings;
import barryflash.superheroes.tileentities.TileEntityTesseract;
import barryflash.superheroes.util.Utils;
import barryflash.superheroes.world.commands.DimensionTeleportCommand;
import barryflash.superheroes.world.structures.THWorldGenerator;
import barryflash.superheroes.worldgen.AtlantisGen;


@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class SuperheroesMod {
	public static final CreativeTabs creativeTab = new TypicalHeroesCreativeTab();
	public static final CreativeTabs weaponscreativeTab = new TypicalHeroesWeaponsCreativeTab();
	public static final CreativeTabs materialscreativeTab = new TypicalHeroesMaterialsCreativeTab();
	public static final CreativeTabs machinescreativeTab = new TypicalHeroesMachinesCreativeTab();
	public static final CreativeTabs blockscreativeTab = new TypicalHeroesBlocksCreativeTab();
	public static final IAttribute[] ATTRIBUTES = new IAttribute[] { SharedMonsterAttributes.MAX_HEALTH, SharedMonsterAttributes.MOVEMENT_SPEED, SharedMonsterAttributes.ATTACK_DAMAGE, SharedMonsterAttributes.ARMOR, SharedMonsterAttributes.ARMOR_TOUGHNESS};
	
	@Mod.Instance(Reference.MODID)
	public static SuperheroesMod instance;
	
	//public static File config;
	
	static { FluidRegistry.enableUniversalBucket(); }
	
	@SidedProxy(clientSide="barryflash.superheroes.proxy.ClientProxy", serverSide="barryflash.superheroes.proxy.ServerProxy")
	public static CommonProxy proxy;
	
	private static int modGuiIndex = 0;

	public static final int GUI_ITEM_INV = modGuiIndex++;
	

	//public static PacketHandler packetHandler;
	 /*@Mod.EventHandler
	    public void serverLoad(FMLServerStartingEvent event) {
	        event.registerServerCommand(new DimensionTeleportCommand());
	    }*/

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ModFluids.registerFluids();
		proxy.preInit(event);
		
		//configDir = new File(event.getModConfigurationDirectory() + "/" + Reference.MODID);
		//configDir.mkdirs();
		//ConfigHandler.init(new File(configDir.getPath(), Reference.MODID + ".cfd"));

		
	
		proxy.registerTileEntities();
		proxy.registerRenders();
		GameRegistry.registerWorldGenerator(new THWorldGenerator(), 0);
		//ModBlocks.init();
		

		//ModBlocks.register();
		//GameRegistry.registerTileEntity(TileEntityTesseract.class, Reference.MODID + "TileEntityTesseract");
		//EntityRegistry.registerModEntity(EntityDoctorStrangeCape.class, "entity_cape", 1, SuperheroesMod.instance, 64, 1, true);
		//EntityRegistry.registerModEntity(EntityTrident.class, "aquaman_trident", 2, this, 64, 10, true);
		//EntityRegistry.registerModEntity(EntityLassoWhip.class, "wonderwoman_lasso", 3, this, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":ironman_repulsor"),EntityRepulsor.class, "ironman_repulsor", 4, this, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":ironman_cannonblast"),EntityCannonBlast.class, "ironman_cannonblast", 5, this, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":wonderwoman_tiara"),EntityTiara.class, "wonderwoman_tiara", 6, this, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":ironman_missile"),EntityMissile.class, "ironman_missile", 7, this, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":ironman_unibeam"),EntityUnibeam.class, "ironman_unibeam", 8, this, 64, 10, true);
		//EntityRegistry.registerModEntity(EntityStormbreaker.class, "thor_stormbreaker", 9, this, 64, 10, true);
		//EntityRegistry.registerModEntity(EntityThanosPortal.class, "thanos_portal", 10, this, 64, 10, true);
		//EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":wasp_blast"),EntityWaspBlast.class, "wasp_blast", 11, this, 64, 10, true);
		//EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":wasp_blastsmall"),EntityWaspBlastSmall.class, "wasp_blastsmall", 12, this, 64, 10, true);
		//EntityRegistry.registerModEntity(EntityAnt.class, "antman_ant", 13, this, 64, 10, true);
		//EntityRegistry.registerModEntity(EntityShrinkDisc.class, "disc_shrink", 14, this, 64, 10, true);
		//EntityRegistry.registerModEntity(EntityGrowDisc.class, "disc_grow", 15, this, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":batman_batarang"),EntityBatmanBatarang.class, "batman_batarang", 9, this, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":batman_batarang_explosive"),EntityBatmanBatarangExplosive.class, "batman_batarang_explosive", 10, this, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":batman_batarang_poison"),EntityBatmanBatarangPoison.class, "batman_batarang_poison", 11, this, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":batman_batarang_electric"),EntityBatmanBatarangElectric.class, "batman_batarang_electric", 12, this, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":batman_smokebomb"),EntityBatmanSmokeBomb.class, "batman_smokebomb", 13, this, 64, 20, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":thor_mjolnir"),EntityMjolnir.class, "thor_mjolnir", 14, this, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":cap_shield"),EntityCaptainAmericaShield.class, "cap_shield", 15, this, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":bullet"),EntityBullet.class, "bullet", 16, this, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":widow_bite"),EntityBlackWidowBite.class, "widow_bite", 17, this, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":trick_arrow"),EntityTrickArrow.class, "trick_arrow", 18, this, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":trick_arrow_explosive"),EntityTrickArrowExplosive.class, "trick_arrow_explosive", 19, this, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":trick_arrow_electric"),EntityTrickArrowElectric.class, "trick_arrow_electric", 20, this, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":trick_arrow_smoke"),EntityTrickArrowSmoke.class, "trick_arrow_smoke", 21, this, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":trick_arrow_grapple"),EntityTrickArrowGrapple.class, "trick_arrow_grapple", 22, this, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":trick_arrow_kryptonite"),EntityTrickArrowKryptonite.class, "trick_arrow_kryptonite", 23, this, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":trick_arrow_tranquilizer"),EntityTrickArrowTranquilizer.class, "trick_arrow_tranquilizer", 24, this, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":trick_arrow_freeze"),EntityTrickArrowFreeze.class, "trick_arrow_freeze", 25, this, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":scepter_blast"),EntityScepterBlast.class, "scepter_blast", 26, this, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":sonarcannon_blast"),EntitySonarCannonBlast.class, "sonarcannon_blast", 27, this, 64, 10, true);
		//EntityRegistry.registerModEntity(EntityBatmanGrappleHook.class, "batman_hook", 21, this, 900, 1, true);
		//EntityRegistry.registerModEntity(EntityBatmanKryptoniteSpear.class, "batman_spear", 22, this, 64, 20, true);
		//EntityRegistry.registerEgg(EntityAnt.class, 0x3B1E00, 0x723B00);
		NetworkHandler.init();
		
		for (final IAttribute attribute : ATTRIBUTES) {
			if (attribute instanceof RangedAttribute) {
				((RangedAttribute) attribute).maximumValue = 100.0F;
			}
			
		}

	}

	 
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		proxy.init(event);
		ModRecipes.init();
		SuitRecipes.registerSuitRecipes();
		TMURecipes.registerRecipes();
		ZeusAltarOfferings.registerOfferings();
		VillagerRegistry.VillagerProfession priest=ForgeRegistries.VILLAGER_PROFESSIONS.getValue(new ResourceLocation("minecraft:priest"));
		priest.getCareer(0).addTrade(1,new ModVillagerTrades());
		ConfigManager.sync(Reference.MODID, Type.INSTANCE);
		//OreDictionaryHandler.registerOreDictionary();
		//RecipeHandler.registerCraftingRecipes();
		//RecipeHandler.registerFurnaceRecipes();
		
		/*FMLCommonHandler.instance().bus().register(new SpinAttack());*/
		//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(ModItems.stevetrevor_rifle, 0, new ModelResourceLocation(ModItems.stevetrevor_rifle.getRegistryName(), "inventory"));
		
		
	
	}

	
	
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
		boolean whitelist = false;
		if (whitelist) {
		try {
			URL url = new URL("https://pastebin.com/raw/EcDBrZKu");
			Scanner s = new Scanner(url.openStream());
			boolean canPlay = false;
			while (s.hasNext()) {
				if (event.getSide().isClient()) {
					if (Minecraft.getMinecraft().getSession().getPlayerID().equals(s.next())) {
						canPlay = true;
					}
				}
			}
			s.close();
			if (canPlay == false) {
				Utils.getLogger().error("You are not in the whitelist!");
		        Minecraft.getMinecraft().shutdown();
			} else {
				Utils.getLogger().info("Hello " + Minecraft.getMinecraft().getSession().getUsername() + ", enjoy the early access!");
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		}
		
		//MinecraftForge.EVENT_BUS.register(new GuiDoctorStrangePortal());
	}
	
}
 
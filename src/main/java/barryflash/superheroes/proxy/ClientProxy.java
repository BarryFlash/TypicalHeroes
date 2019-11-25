package barryflash.superheroes.proxy;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;

import barryflash.superheroes.Reference;
import barryflash.superheroes.abilities.wonderwoman.Lasso;
import barryflash.superheroes.armor.handler.PlayerModelSwitchEvent;
import barryflash.superheroes.armor.handler.RenderPlayerAnimation;
import barryflash.superheroes.capabilities.BatmanEventHandler;
import barryflash.superheroes.client.KeyHandler;
import barryflash.superheroes.client.Keybinding;
import barryflash.superheroes.client.gui.GuiGunAmmoIndicatorOverlay;
import barryflash.superheroes.client.gui.GuiIronmanOverlay;
import barryflash.superheroes.client.render.ProjectileRenderBatarangElectric;
import barryflash.superheroes.client.render.ProjectileRenderBatarangExplosive;
import barryflash.superheroes.client.render.ProjectileRenderBatarangPoison;
import barryflash.superheroes.client.render.ProjectileRenderBatmanBatarang;
import barryflash.superheroes.client.render.ProjectileRenderBatmanSmokeBomb;
import barryflash.superheroes.client.render.ProjectileRenderBlackWidowBite;
import barryflash.superheroes.client.render.ProjectileRenderBullet;
import barryflash.superheroes.client.render.ProjectileRenderCannonBlast;
import barryflash.superheroes.client.render.ProjectileRenderCaptainAmericaShield;
import barryflash.superheroes.client.render.ProjectileRenderMissile;
import barryflash.superheroes.client.render.ProjectileRenderMjolnir;
import barryflash.superheroes.client.render.ProjectileRenderRepulsor;
import barryflash.superheroes.client.render.ProjectileRenderScepterBlast;
import barryflash.superheroes.client.render.ProjectileRenderSonarCannonBlast;
import barryflash.superheroes.client.render.ProjectileRenderTiara;
import barryflash.superheroes.client.render.ProjectileRenderTrickArrow;
import barryflash.superheroes.client.render.ProjectileRenderTrickArrowElectric;
import barryflash.superheroes.client.render.ProjectileRenderTrickArrowExplosive;
import barryflash.superheroes.client.render.ProjectileRenderTrickArrowFreeze;
import barryflash.superheroes.client.render.ProjectileRenderTrickArrowGrapple;
import barryflash.superheroes.client.render.ProjectileRenderTrickArrowKryptonite;
import barryflash.superheroes.client.render.ProjectileRenderTrickArrowSmoke;
import barryflash.superheroes.client.render.ProjectileRenderTrickArrowTranquilizer;
import barryflash.superheroes.client.render.ProjectileRenderUnibeam;
import barryflash.superheroes.client.render.ProjectileRenderWaspBlast;
import barryflash.superheroes.client.render.ProjectileRenderWaspBlastSmall;
import barryflash.superheroes.client.render.entities.RenderEntityAnt;
import barryflash.superheroes.client.render.entities.RenderEntityDoctorStrangeCape;
import barryflash.superheroes.entities.EntityAnt;
import barryflash.superheroes.entities.EntityDoctorStrangeCape;
import barryflash.superheroes.entities.particles.TextureStitcherCustom;
import barryflash.superheroes.entities.particles.TextureStitcherLightning;
import barryflash.superheroes.entities.particles.TextureStitcherWaspBlast2;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarang;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarangElectric;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarangExplosive;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarangPoison;
import barryflash.superheroes.entities.projectiles.EntityBatmanSmokeBomb;
import barryflash.superheroes.entities.projectiles.EntityBlackWidowBite;
import barryflash.superheroes.entities.projectiles.EntityBullet;
import barryflash.superheroes.entities.projectiles.EntityCannonBlast;
import barryflash.superheroes.entities.projectiles.EntityCaptainAmericaShield;
import barryflash.superheroes.entities.projectiles.EntityMissile;
import barryflash.superheroes.entities.projectiles.EntityMjolnir;
import barryflash.superheroes.entities.projectiles.EntityRepulsor;
import barryflash.superheroes.entities.projectiles.EntityScepterBlast;
import barryflash.superheroes.entities.projectiles.EntitySonarCannonBlast;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import barryflash.superheroes.entities.projectiles.EntityTrickArrow;
import barryflash.superheroes.entities.projectiles.EntityTrickArrowElectric;
import barryflash.superheroes.entities.projectiles.EntityTrickArrowExplosive;
import barryflash.superheroes.entities.projectiles.EntityTrickArrowFreeze;
import barryflash.superheroes.entities.projectiles.EntityTrickArrowGrapple;
import barryflash.superheroes.entities.projectiles.EntityTrickArrowKryptonite;
import barryflash.superheroes.entities.projectiles.EntityTrickArrowSmoke;
import barryflash.superheroes.entities.projectiles.EntityTrickArrowTranquilizer;
import barryflash.superheroes.entities.projectiles.EntityUnibeam;
import barryflash.superheroes.entities.projectiles.EntityWaspBlast;
import barryflash.superheroes.entities.projectiles.EntityWaspBlastSmall;
import barryflash.superheroes.tileentities.TESRDnaExtractor;
import barryflash.superheroes.tileentities.TESRSmeltingCrucible;
import barryflash.superheroes.tileentities.TileEntityDnaExtractor;
import barryflash.superheroes.tileentities.TileEntitySmeltingCrucible;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		// TODO Auto-generated method stub
		super.preInit(e);

		Keybinding.register();
		RenderingRegistry.registerEntityRenderingHandler(EntityDoctorStrangeCape.class, RenderEntityDoctorStrangeCape.FACTORY);
		//RenderingRegistry.registerEntityRenderingHandler(EntityAnt.class, RenderEntityAnt.FACTORY);
		MinecraftForge.EVENT_BUS.register(new KeyHandler());
		MinecraftForge.EVENT_BUS.register(new BatmanEventHandler());
		MinecraftForge.EVENT_BUS.register(new Lasso());
		//MinecraftForge.EVENT_BUS.register(new LassoRenderer(Minecraft.getMinecraft()));
		//MinecraftForge.EVENT_BUS.register(new WonderWomanBraceletsAnimation());
		MinecraftForge.EVENT_BUS.register(new RenderPlayerAnimation());

		MinecraftForge.EVENT_BUS.register(new TextureStitcherLightning());
		MinecraftForge.EVENT_BUS.register(new TextureStitcherWaspBlast2());
		MinecraftForge.EVENT_BUS.register(new TextureStitcherCustom());
		//MinecraftForge.EVENT_BUS.register(new TickEvent());
		MinecraftForge.EVENT_BUS.register(new GuiGunAmmoIndicatorOverlay());
		
	}

	@Override
	public void init(FMLInitializationEvent e) {
		// TODO Auto-generated method stub
		super.init(e);
		MinecraftForge.EVENT_BUS.register(new PlayerModelSwitchEvent());
	
		
		//RenderingRegistry.registerEntityRenderingHandler(EntityLassoWhip.class, new ProjectileRenderLasso(Minecraft.getMinecraft().getRenderManager(), null));
		RenderingRegistry.registerEntityRenderingHandler(EntityRepulsor.class, new ProjectileRenderRepulsor(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityCannonBlast.class, new ProjectileRenderCannonBlast(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTiara.class, new ProjectileRenderTiara(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityMissile.class, new ProjectileRenderMissile(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityUnibeam.class, new ProjectileRenderUnibeam(Minecraft.getMinecraft().getRenderManager()));
		//RenderingRegistry.registerEntityRenderingHandler(EntityStormbreaker.class, new ProjectileRenderStormbreaker(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityCaptainAmericaShield.class, new ProjectileRenderCaptainAmericaShield(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityMjolnir.class, new ProjectileRenderMjolnir(Minecraft.getMinecraft().getRenderManager()));
		//RenderingRegistry.registerEntityRenderingHandler(EntityWaspBlast.class, new ProjectileRenderWaspBlast(Minecraft.getMinecraft().getRenderManager()));
		//RenderingRegistry.registerEntityRenderingHandler(EntityWaspBlastSmall.class, new ProjectileRenderWaspBlastSmall(Minecraft.getMinecraft().getRenderManager()));
		//RenderingRegistry.registerEntityRenderingHandler(EntityShrinkDisc.class, new ProjectileRenderShrinkDisc(Minecraft.getMinecraft().getRenderManager()));
		//RenderingRegistry.registerEntityRenderingHandler(EntityGrowDisc.class, new ProjectileRenderGrowDisc(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityBatmanBatarang.class, new ProjectileRenderBatmanBatarang(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityBatmanBatarangExplosive.class, new ProjectileRenderBatarangExplosive(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityBatmanBatarangPoison.class, new ProjectileRenderBatarangPoison(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityBatmanBatarangElectric.class, new ProjectileRenderBatarangElectric(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityBatmanSmokeBomb.class, new ProjectileRenderBatmanSmokeBomb(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new ProjectileRenderBullet(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackWidowBite.class, new ProjectileRenderBlackWidowBite(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTrickArrow.class, new ProjectileRenderTrickArrow(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTrickArrowExplosive.class, new ProjectileRenderTrickArrowExplosive(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTrickArrowElectric.class, new ProjectileRenderTrickArrowElectric(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTrickArrowSmoke.class, new ProjectileRenderTrickArrowSmoke(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTrickArrowGrapple.class, new ProjectileRenderTrickArrowGrapple(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTrickArrowTranquilizer.class, new ProjectileRenderTrickArrowTranquilizer(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTrickArrowKryptonite.class, new ProjectileRenderTrickArrowKryptonite(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTrickArrowFreeze.class, new ProjectileRenderTrickArrowFreeze(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityScepterBlast.class, new ProjectileRenderScepterBlast(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntitySonarCannonBlast.class, new ProjectileRenderSonarCannonBlast(Minecraft.getMinecraft().getRenderManager()));
		//RenderingRegistry.registerEntityRenderingHandler(EntityBatmanKryptoniteSpear.class, new ProjectileRenderBatmanSpear(Minecraft.getMinecraft().getRenderManager(), ModTools.batman_kryptonitespear, Minecraft.getMinecraft().getRenderItem()));
		
	
		
		Sphere sphere = new Sphere();
		//Set up paramters that are common to both outside and inside.

		//GLU_FILL as a solid.
		sphere.setDrawStyle(GLU.GLU_FILL);
		//GLU_SMOOTH will try to smoothly apply lighting
		sphere.setNormals(GLU.GLU_SMOOTH);

		//First make the call list for the outside of the sphere


		sphere.setOrientation(GLU.GLU_OUTSIDE);

		sphereIdOutside = GL11.glGenLists(1);
		//Create a new list to hold our sphere data.
		GL11.glNewList(sphereIdOutside, GL11.GL_COMPILE);
		//binds the texture 
		ResourceLocation rL = new ResourceLocation(Reference.MODID + ":textures/items/bracelet_blast.png");
		Minecraft.getMinecraft().getTextureManager().bindTexture(rL);
		//The drawing the sphere is automatically doing is getting added to our list. Careful, the last 2 variables
		//control the detail, but have a massive impact on performance. 32x32 is a good balance on my machine.s
		sphere.draw(0.5F, 32, 32);
		GL11.glEndList();

		//Now make the call list for the inside of the sphere
		sphere.setOrientation(GLU.GLU_INSIDE);
		sphereIdInside = GL11.glGenLists(1);
		//Create a new list to hold our sphere data.
		GL11.glNewList(sphereIdInside, GL11.GL_COMPILE);
		Minecraft.getMinecraft().getTextureManager().bindTexture(rL);
		sphere.draw(0.5F, 32, 32);
		GL11.glEndList();
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
	
		super.postInit(e);
		MinecraftForge.EVENT_BUS.register(new GuiIronmanOverlay());
	}

	@Override
	public void openMyGui(GuiScreen gui)
	{
	     Minecraft.getMinecraft().displayGuiScreen(gui);
	}
	@Override
	public void registerRenders() {
		//ModBlocks.registerRenders();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySmeltingCrucible.class, new TESRSmeltingCrucible());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDnaExtractor.class, new TESRDnaExtractor());
		
	}

	

	
	public static int sphereIdOutside;
	public static int sphereIdInside;


}


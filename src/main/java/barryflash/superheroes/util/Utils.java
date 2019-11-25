package barryflash.superheroes.util;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;

import barryflash.superheroes.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Timer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Utils {


	public static final int MAX_LIGHT_X = 0xF000F0;
    public static final int MAX_LIGHT_Y = 0xF000FF;
    
    public static final float LIGHTMAPX = OpenGlHelper.lastBrightnessX;
    public static final float LIGHTMAPY = OpenGlHelper.lastBrightnessY;
	private static Logger logger;
	
	public static Logger getLogger() {
		if(logger == null) {
			logger = LogManager.getFormatterLogger(Reference.MODID);
		}
		return logger;
	}
	 
	private static Field clientTimer = null;
	  public static float CLIENT_TICKRATE = 20.0F;
	  public static long MILISECONDS_PER_TICK = 50L;
	
	  public static void updateTickrate(Side side, float tickrate)
	  {
	    if (side.isClient()) {
	      updateClientTickrate(tickrate);
	    } else {
	    	
	      updateServerTickrate(tickrate);
	    }
	  }
	  
	  public static void updateClientTickrate(float tickrate)
	  {
	    Minecraft mc = Minecraft.getMinecraft();
	    try
	    {
	      if (tickrate != CLIENT_TICKRATE)
	      {
	        if (clientTimer == null) {
	          for (Field f : mc.getClass().getDeclaredFields()) {
	            if (f.getType() == Timer.class)
	            {
	              clientTimer = f;
	              clientTimer.setAccessible(true);
	              break;
	            }
	          }
	        }
	        Timer timer = (Timer) clientTimer.get(mc);
	        timer.elapsedTicks = (int) (tickrate / 20.0F);
	       
	        CLIENT_TICKRATE = tickrate;
	        System.out.println(tickrate);
	      }
	    }
	    catch (Exception ex)
	    {
	      ex.printStackTrace();
	    }
	  }
	  
	  public static void updateServerTickrate(float tickrate)
	  {
		  
	    MILISECONDS_PER_TICK = (long) (1000.0F / tickrate);
	    
	  }
    public static boolean isInventoryFull(EntityPlayer player) {
    	for (int i = 0; i < player.inventory.mainInventory.size(); i++) {
    		if (player.inventory.getStackInSlot(i).isEmpty()) {
    			return false;
    			
    		}
    	}
    	return true;
    }
    public static void renderTrail(Entity player, LinkedList list, Random rand, float[] color) {
    	if (list.size() >= 10) {
    		Vec3d vec3 = Vec3d.fromPitchYaw(player.rotationPitch, player.rotationYaw);
			float distance2 = -0.2F;
			double x2 = player.posX + (distance2 *vec3.x);
			double z2 = player.posZ + (distance2 *vec3.z);
			Vec3d fina = new Vec3d(0,-0.2,-0.3).rotateYaw(-player.rotationYaw * 0.017453292F - (float)Math.PI/2);
			Vec3d fina2 = new Vec3d(0,-0.2,0.3).rotateYaw(-player.rotationYaw * 0.017453292F - (float)Math.PI/2);
			Vec3d fina3 = new Vec3d(0,0.2,-0.1).rotateYaw(-player.rotationYaw * 0.017453292F - (float)Math.PI/2);
			Vec3d fina4 = new Vec3d(0,-0.4,0.1).rotateYaw(-player.rotationYaw * 0.017453292F - (float)Math.PI/2);
	
			
			Utils.renderLaser2(player.getPositionVector().addVector(0, player.height - player.height/3, 0).add(fina3), ((Vec3d) list.get(9)).add(fina3), 0.6F, 0.02F, color);
    		Utils.renderLaser2(((Vec3d) list.get(9)).add(fina3), ((Vec3d) list.get(8)).add(fina3), 0.55F, 0.02F, color);
    		Utils.renderLaser2(((Vec3d) list.get(8)).add(fina3), ((Vec3d) list.get(7)).add(fina3), 0.5F, 0.02F, color);
    		Utils.renderLaser2(((Vec3d) list.get(7)).add(fina3), ((Vec3d) list.get(6)).add(fina3), 0.45F, 0.02F, color);
    		Utils.renderLaser2(((Vec3d) list.get(6)).add(fina3), ((Vec3d) list.get(5)).add(fina3), 0.4F, 0.02F, color);
    		Utils.renderLaser2(((Vec3d) list.get(5)).add(fina3), ((Vec3d) list.get(4)).add(fina3), 0.35F, 0.02F, color);
	    	Utils.renderLaser2(((Vec3d) list.get(4)).add(fina3), ((Vec3d) list.get(3)).add(fina3), 0.3F, 0.02F, color);
	    	Utils.renderLaser2(((Vec3d) list.get(3)).add(fina3), ((Vec3d) list.get(2)).add(fina3), 0.25F, 0.02F, color);
			Utils.renderLaser2(((Vec3d) list.get(2)).add(fina3), ((Vec3d) list.get(1)).add(fina3), 0.2F, 0.02F, color);
			Utils.renderLaser2(((Vec3d) list.get(1)).add(fina3), ((Vec3d) list.get(0)).add(fina3), 0.15F, 0.02F, color);
			
			Utils.renderLaser2(player.getPositionVector().addVector(0, player.height - player.height/3, 0).add(fina), ((Vec3d) list.get(9)).add(fina), 0.6F, 0.02F, color);
    		Utils.renderLaser2(((Vec3d) list.get(9)).add(fina), ((Vec3d) list.get(8)).add(fina), 0.55F, 0.02F, color);
    		Utils.renderLaser2(((Vec3d) list.get(8)).add(fina), ((Vec3d) list.get(7)).add(fina), 0.5F, 0.02F, color);
    		Utils.renderLaser2(((Vec3d) list.get(7)).add(fina), ((Vec3d) list.get(6)).add(fina), 0.45F, 0.02F, color);
    		Utils.renderLaser2(((Vec3d) list.get(6)).add(fina), ((Vec3d) list.get(5)).add(fina), 0.4F, 0.02F, color);
    		Utils.renderLaser2(((Vec3d) list.get(5)).add(fina), ((Vec3d) list.get(4)).add(fina), 0.35F, 0.02F, color);
	    	Utils.renderLaser2(((Vec3d) list.get(4)).add(fina), ((Vec3d) list.get(3)).add(fina), 0.3F, 0.02F, color);
	    	Utils.renderLaser2(((Vec3d) list.get(3)).add(fina), ((Vec3d) list.get(2)).add(fina), 0.25F, 0.02F, color);
			Utils.renderLaser2(((Vec3d) list.get(2)).add(fina), ((Vec3d) list.get(1)).add(fina), 0.2F, 0.02F, color);
			Utils.renderLaser2(((Vec3d) list.get(1)).add(fina), ((Vec3d) list.get(0)).add(fina), 0.15F, 0.02F, color);
			
			Utils.renderLaser2(player.getPositionVector().addVector(0, player.height - player.height/3, 0).add(fina2), ((Vec3d) list.get(9)).add(fina2), 0.6F, 0.02F, color);
    		Utils.renderLaser2(((Vec3d) list.get(9)).add(fina2), ((Vec3d) list.get(8)).add(fina2), 0.55F, 0.02F, color);
    		Utils.renderLaser2(((Vec3d) list.get(8)).add(fina2), ((Vec3d) list.get(7)).add(fina2), 0.5F, 0.02F, color);
    		Utils.renderLaser2(((Vec3d) list.get(7)).add(fina2), ((Vec3d) list.get(6)).add(fina2), 0.45F, 0.02F, color);
    		Utils.renderLaser2(((Vec3d) list.get(6)).add(fina2), ((Vec3d) list.get(5)).add(fina2), 0.4F, 0.02F, color);
    		Utils.renderLaser2(((Vec3d) list.get(5)).add(fina2), ((Vec3d) list.get(4)).add(fina2), 0.35F, 0.02F, color);
	    	Utils.renderLaser2(((Vec3d) list.get(4)).add(fina2), ((Vec3d) list.get(3)).add(fina2), 0.3F, 0.02F, color);
	    	Utils.renderLaser2(((Vec3d) list.get(3)).add(fina2), ((Vec3d) list.get(2)).add(fina2), 0.25F, 0.02F, color);
			Utils.renderLaser2(((Vec3d) list.get(2)).add(fina2), ((Vec3d) list.get(1)).add(fina2), 0.2F, 0.02F, color);
			Utils.renderLaser2(((Vec3d) list.get(1)).add(fina2), ((Vec3d) list.get(0)).add(fina2), 0.15F, 0.02F, color);
			
			Utils.renderLaser2(player.getPositionVector().addVector(0, player.height - player.height/3, 0).add(fina4), ((Vec3d) list.get(9)).add(fina4), 0.6F, 0.02F, color);
    		Utils.renderLaser2(((Vec3d) list.get(9)).add(fina4), ((Vec3d) list.get(8)).add(fina4), 0.55F, 0.02F, color);
    		Utils.renderLaser2(((Vec3d) list.get(8)).add(fina4), ((Vec3d) list.get(7)).add(fina4), 0.5F, 0.02F, color);
    		Utils.renderLaser2(((Vec3d) list.get(7)).add(fina4), ((Vec3d) list.get(6)).add(fina4), 0.45F, 0.02F, color);
    		Utils.renderLaser2(((Vec3d) list.get(6)).add(fina4), ((Vec3d) list.get(5)).add(fina4), 0.4F, 0.02F, color);
    		Utils.renderLaser2(((Vec3d) list.get(5)).add(fina4), ((Vec3d) list.get(4)).add(fina4), 0.35F, 0.02F, color);
	    	Utils.renderLaser2(((Vec3d) list.get(4)).add(fina4), ((Vec3d) list.get(3)).add(fina4), 0.3F, 0.02F, color);
	    	Utils.renderLaser2(((Vec3d) list.get(3)).add(fina4), ((Vec3d) list.get(2)).add(fina4), 0.25F, 0.02F, color);
			Utils.renderLaser2(((Vec3d) list.get(2)).add(fina4), ((Vec3d) list.get(1)).add(fina4), 0.2F, 0.02F, color);
			Utils.renderLaser2(((Vec3d) list.get(1)).add(fina4), ((Vec3d) list.get(0)).add(fina4), 0.15F, 0.02F, color);

    	}
    }
	public static void renderLightningBeam(Entity entityIn, Random rand, Vec3d start, Vec3d end, float area, float beamWidth, float alpha, float[] color) {
		Vec3d fina = start;
		Vec3d vector = end;
		Vec3d middleAdd = fina.add(vector);
		Vec3d middle = new Vec3d(middleAdd.x/2, middleAdd.y/2, middleAdd.z/2);
		Vec3d fqAdd = fina.add(middle);
		Vec3d firstQuarter = new Vec3d(fqAdd.x/2, fqAdd.y/2, fqAdd.z/2);
		Vec3d lqAdd = middle.add(vector);
		Vec3d lastQuarter = new Vec3d(lqAdd.x/2, lqAdd.y/2, lqAdd.z/2);
		Random r = rand;
		float width = area;
		float randS = r.nextFloat()*width;
		float randH = r.nextFloat()*width;
		float randS1 = r.nextFloat()*width;
		float randH1 = r.nextFloat()*width;
		float randS2 = r.nextFloat()*width;
		float randH2 = r.nextFloat()*width;
		float randS3 = r.nextFloat()*width;
		float randH3 = r.nextFloat()*width;
		double fqX = firstQuarter.x + randS - width/2;
		double fqY = firstQuarter.y + randH;
		double fqZ = firstQuarter.z + randS - width/2;
		double mX = middle.x + randS1 - width/2;
		double mY = middle.y + randH1;
		double mZ = middle.z + randS1 - width/2;
		double lqX = lastQuarter.x + randS2 - width/2;
		double lqY = lastQuarter.y + randH2;
		double lqZ = lastQuarter.z + randS2 - width/2;
		Vec3d randFQ = new Vec3d(fqX, fqY, fqZ);
		Vec3d randM = new Vec3d(mX, mY, mZ);
		Vec3d randLQ = new Vec3d(lqX, lqY, lqZ);
		Vec3d randE = new Vec3d(fqX, fqY, fqZ);
		Utils.renderLaser(entityIn, fina, randFQ, alpha, beamWidth, color);
		Utils.renderLaser(entityIn, randFQ, randM, alpha, beamWidth, color);
		Utils.renderLaser(entityIn, randM, randLQ, alpha, beamWidth, color);
		Utils.renderLaser(entityIn, randLQ, vector, alpha, beamWidth, color);
	}
	    public static void renderLaser(Entity entity, Vec3d start, Vec3d end, float alpha, double beamWidth, float[] color){

	    	Tessellator tessy = Tessellator.getInstance();
	        BufferBuilder render = tessy.getBuffer();
	        World world = Minecraft.getMinecraft().world;
	        Entity player = entity;
	       
	        float r = color[0];
	        float g = color[1];
	        float b = color[2];
	       
	        Vec3d combinedVec = end.subtract(start);

	        double pitch = Math.atan2(combinedVec.y, Math.sqrt(combinedVec.x*combinedVec.x+combinedVec.z*combinedVec.z));
	        double yaw = Math.atan2(-combinedVec.z, combinedVec.x);
	        double length = combinedVec.lengthVector();
	       
	        GlStateManager.pushMatrix();
	        GlStateManager.disableLighting();
	        GlStateManager.enableBlend();
	        GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE);
	       
	        GlStateManager.translate(start.x-player.posX, start.y-player.posY, start.z-player.posZ);
	        GlStateManager.rotate((float)(180*yaw/Math.PI), 0, 1, 0);
	        GlStateManager.rotate((float)(180*pitch/Math.PI), 0, 0, 1);
	        GlStateManager.disableTexture2D();

	        render.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_LMAP_COLOR);
	        for(double i = 0; i < 4; i++){
	            double width = beamWidth*(i/4.0);
	            render.pos(length, width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(0, width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(0, -width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(length, -width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();

	            render.pos(length, -width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(0, -width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(0, width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(length, width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();

	            render.pos(length, width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(0, width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(0, width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(length, width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();

	            render.pos(length, -width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(0, -width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(0, -width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(length, -width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	        }
	        tessy.draw();

	        GlStateManager.enableTexture2D();
	        GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
	        GlStateManager.disableBlend();
	        GlStateManager.enableLighting();
	        GlStateManager.popMatrix();

	    }
	    public static void renderThickLine(Vec3d start, Vec3d end, float alpha, double beamWidth, float[] color){

	    	Tessellator tessy = Tessellator.getInstance();
	        BufferBuilder render = tessy.getBuffer();
	        World world = Minecraft.getMinecraft().world;
	        Entity player = Minecraft.getMinecraft().player;

	        float r = color[0];
	        float g = color[1];
	        float b = color[2];
	       
	        Vec3d combinedVec = end.subtract(start);

	        double pitch = Math.atan2(combinedVec.y, Math.sqrt(combinedVec.x*combinedVec.x+combinedVec.z*combinedVec.z));
	        double yaw = Math.atan2(-combinedVec.z, combinedVec.x);
	        double length = combinedVec.lengthVector();

	        GlStateManager.pushMatrix();
	        GlStateManager.disableLighting();
	        GlStateManager.enableBlend();
	        
	       
	        GlStateManager.translate(start.x-player.posX, start.y-player.posY, start.z-player.posZ);
	        GlStateManager.rotate((float)(180*yaw/Math.PI), 0, 1, 0);
	        GlStateManager.rotate((float)(180*pitch/Math.PI), 0, 0, 1);
	        GlStateManager.disableTexture2D();

	        render.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_COLOR);
	        for(double i = 0; i < 4; i++){
	            double width = beamWidth*(i/4.0);
	            render.pos(length, width, width).tex(0, 0).color(r, g, b, alpha).endVertex();
	            render.pos(0, width, width).tex(0, 0).color(r, g, b, alpha).endVertex();
	            render.pos(0, -width, width).tex(0, 0).color(r, g, b, alpha).endVertex();
	            render.pos(length, -width, width).tex(0, 0).color(r, g, b, alpha).endVertex();

	            render.pos(length, -width, -width).tex(0, 0).color(r, g, b, alpha).endVertex();
	            render.pos(0, -width, -width).tex(0, 0).color(r, g, b, alpha).endVertex();
	            render.pos(0, width, -width).tex(0, 0).color(r, g, b, alpha).endVertex();
	            render.pos(length, width, -width).tex(0, 0).color(r, g, b, alpha).endVertex();

	            render.pos(length, width, -width).tex(0, 0).color(r, g, b, alpha).endVertex();
	            render.pos(0, width, -width).tex(0, 0).color(r, g, b, alpha).endVertex();
	            render.pos(0, width, width).tex(0, 0).color(r, g, b, alpha).endVertex();
	            render.pos(length, width, width).tex(0, 0).color(r, g, b, alpha).endVertex();

	            render.pos(length, -width, width).tex(0, 0).color(r, g, b, alpha).endVertex();
	            render.pos(0, -width, width).tex(0, 0).color(r, g, b, alpha).endVertex();
	            render.pos(0, -width, -width).tex(0, 0).color(r, g, b, alpha).endVertex();
	            render.pos(length, -width, -width).tex(0, 0).color(r, g, b, alpha).endVertex();
	        }
	        tessy.draw();

	        GlStateManager.enableTexture2D();
	        
	        GlStateManager.disableBlend();
	        GlStateManager.enableLighting();
	        GlStateManager.popMatrix();

	    }
	    public static void renderLaser2(Vec3d start, Vec3d end, float alpha, double beamWidth, float[] color){

	    	Tessellator tessy = Tessellator.getInstance();
	        BufferBuilder render = tessy.getBuffer();
	        World world = Minecraft.getMinecraft().world;
	        Entity player = Minecraft.getMinecraft().player;

	        float r = color[0];
	        float g = color[1];
	        float b = color[2];
	       
	        Vec3d combinedVec = end.subtract(start);

	        double pitch = Math.atan2(combinedVec.y, Math.sqrt(combinedVec.x*combinedVec.x+combinedVec.z*combinedVec.z));
	        double yaw = Math.atan2(-combinedVec.z, combinedVec.x);
	        double length = combinedVec.lengthVector();

	        GlStateManager.pushMatrix();
	        GlStateManager.disableLighting();
	        GlStateManager.enableBlend();
	        GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE);
	       
	        GlStateManager.translate(start.x-player.posX, start.y-player.posY, start.z-player.posZ);
	        GlStateManager.rotate((float)(180*yaw/Math.PI), 0, 1, 0);
	        GlStateManager.rotate((float)(180*pitch/Math.PI), 0, 0, 1);
	        GlStateManager.disableTexture2D();

	        render.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_LMAP_COLOR);
	        for(double i = 0; i < 4; i++){
	            double width = beamWidth*(i/4.0);
	            render.pos(length, width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(0, width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(0, -width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(length, -width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();

	            render.pos(length, -width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(0, -width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(0, width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(length, width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();

	            render.pos(length, width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(0, width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(0, width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(length, width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();

	            render.pos(length, -width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(0, -width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(0, -width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(length, -width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	        }
	        tessy.draw();

	        GlStateManager.enableTexture2D();
	        GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
	        GlStateManager.disableBlend();
	        GlStateManager.enableLighting();
	        GlStateManager.popMatrix();

	    }
	 public static void knockbackEntity(Entity fromEntity, Entity entity, float amount) {
		 float yaw = fromEntity.rotationYaw;
			float pitch = fromEntity.rotationPitch;
			float f = amount;
			double motionX = (double)(-MathHelper.sin(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * f);
			double motionZ = (double)(MathHelper.cos(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * f);
			double motionY = (double)(-MathHelper.sin((pitch) / 180.0F * (float)Math.PI) * f);
			entity.motionX = motionX;
			entity.motionY = motionY *2;
			entity.motionZ = motionZ;
	 }
	 @SideOnly(Side.CLIENT)
	 public static RayTraceResult getMouseOverExtended(double distance)
		{
		    Minecraft mc = FMLClientHandler.instance().getClient();
		    Entity theRenderViewEntity = mc.getRenderViewEntity();
		    AxisAlignedBB theViewBoundingBox = new AxisAlignedBB(
		            theRenderViewEntity.posX-0.5D,
		            theRenderViewEntity.posY-0.0D,
		            theRenderViewEntity.posZ-0.5D,
		            theRenderViewEntity.posX+0.5D,
		            theRenderViewEntity.posY+1.5D,
		            theRenderViewEntity.posZ+0.5D
		            );
		    RayTraceResult returnMOP = null;
		    if (mc.world != null)
		    {
		        double var2 = distance;
		        returnMOP = theRenderViewEntity.rayTrace(var2, 0);
		        double calcdist = var2;
		        Vec3d pos = theRenderViewEntity.getPositionEyes(0);
		        var2 = calcdist;
		        if (returnMOP != null)
		        {
		            calcdist = returnMOP.hitVec.distanceTo(pos);
		        }
		         
		        Vec3d lookvec = theRenderViewEntity.getLook(0);
		        Vec3d var8 = pos.addVector(lookvec.x * var2, 
		              lookvec.y * var2, 
		              lookvec.z * var2);
		        Entity pointedEntity = null;
		        float var9 = 3.0F;
		        @SuppressWarnings("unchecked")
		        List<Entity> list = mc.world.getEntitiesWithinAABBExcludingEntity(
		              theRenderViewEntity, 
		              theViewBoundingBox.grow(
		                    lookvec.x * var2, 
		                    lookvec.y * var2, 
		                    lookvec.z * var2).expand(var9, var9, var9));
		        double d = calcdist;
		            
		        for (Entity entity : list)
		        {
		            if (entity.canBeCollidedWith())
		            {
		                float bordersize = entity.getCollisionBorderSize();
		                AxisAlignedBB aabb = new AxisAlignedBB(
		                      entity.posX-entity.width/2, 
		                      entity.posY, 
		                      entity.posZ-entity.width/2, 
		                      entity.posX+entity.width/2, 
		                      entity.posY+entity.height, 
		                      entity.posZ+entity.width/2);
		                aabb.expand(bordersize, bordersize, bordersize);
		                RayTraceResult mop0 = aabb.calculateIntercept(pos, var8);
		                    
		                if (aabb.contains(pos))
		                {
		                    if (0.0D < d || d == 0.0D)
		                    {
		                        pointedEntity = entity;
		                        d = 0.0D;
		                    }
		                } else if (mop0 != null)
		                {
		                    double d1 = pos.distanceTo(mop0.hitVec);
		                        
		                    if (d1 < d || d == 0.0D)
		                    {
		                        pointedEntity = entity;
		                        d = d1;
		                    }
		                }
		            }
		        }
		           
		        if (pointedEntity != null && (d < calcdist || returnMOP == null))
		        {
		             returnMOP = new RayTraceResult(pointedEntity);
		        }
		    }
		    return returnMOP;
		}	
	 @SideOnly(Side.CLIENT)
	    public static void renderHeatVision(Vec3d start, Vec3d end, float alpha, double beamWidth, float[] color){
	    	Tessellator tessy = Tessellator.getInstance();
	        BufferBuilder render = tessy.getBuffer();
	        World world = Minecraft.getMinecraft().world;
	        EntityPlayer player = Minecraft.getMinecraft().player;
	        float r = color[0];
	        float g = color[1];
	        float b = color[2];
	        Vec3d combinedVec = end.subtract(start);
	        double pitch = Math.atan2(combinedVec.y, Math.sqrt(combinedVec.x*combinedVec.x+combinedVec.z*combinedVec.z));
	        double yaw = Math.atan2(-combinedVec.z, combinedVec.x);
	        double length = combinedVec.lengthVector();
	        GlStateManager.pushMatrix();
	        GlStateManager.disableLighting();
	    
	        GlStateManager.translate(start.x-player.posX, start.y-player.posY, start.z-player.posZ);
	        GlStateManager.rotate((float)(180*yaw/Math.PI), 0, 1, 0);
	        GlStateManager.rotate((float)(180*pitch/Math.PI), 0, 0, 1);
	        GlStateManager.disableTexture2D();
	        render.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_LMAP_COLOR);
	        for(double i = 0; i < 4; i++){
	            double width = beamWidth*(i/4.0);
	            render.pos(length, width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(0, width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(0, -width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(length, -width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(length, -width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(0, -width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(0, width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(length, width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(length, width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(0, width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(0, width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(length, width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(length, -width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(0, -width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(0, -width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	            render.pos(length, -width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();
	        }
	        tessy.draw();
	        GlStateManager.enableTexture2D();
		       
	        GlStateManager.enableLighting();
	        GlStateManager.popMatrix();
	        
	        GlStateManager.pushMatrix();
	        GlStateManager.disableLighting();
	        GlStateManager.translate(start.x-player.posX, start.y-player.posY, start.z-player.posZ);
	        GlStateManager.rotate((float)(180*yaw/Math.PI), 0, 1, 0);
	        GlStateManager.rotate((float)(180*pitch/Math.PI), 0, 0, 1);
	        GlStateManager.disableTexture2D();
	        GlStateManager.enableBlend();
	        GlStateManager.blendFunc(SourceFactor.SRC_COLOR, DestFactor.DST_COLOR);
	        render.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_LMAP_COLOR);
	        for(double i = 0; i < 4; i++){
	            double width = 0.05*(i/4.0);
	            render.pos(length, width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(0.7F, 0.3F, 0.25F, 0.5F).endVertex();
	            render.pos(0, width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(0.7F, 0.3F, 0.25F, 0.5F).endVertex();
	            render.pos(0, -width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(0.7F, 0.3F, 0.25F, 0.5F).endVertex();
	            render.pos(length, -width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(0.7F, 0.3F, 0.25F, 0.5F).endVertex();
	            render.pos(length, -width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(0.7F, 0.3F, 0.25F, 0.5F).endVertex();
	            render.pos(0, -width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(0.7F, 0.3F, 0.25F, 0.5F).endVertex();
	            render.pos(0, width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(0.7F, 0.3F, 0.25F, 0.5F).endVertex();
	            render.pos(length, width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(0.7F, 0.3F, 0.25F, 0.5F).endVertex();
	            render.pos(length, width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(0.7F, 0.3F, 0.25F, 0.5F).endVertex();
	            render.pos(0, width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(0.7F, 0.3F, 0.25F, 0.5F).endVertex();
	            render.pos(0, width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(0.7F, 0.3F, 0.25F, 0.5F).endVertex();
	            render.pos(length, width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(0.7F, 0.3F, 0.25F, 0.5F).endVertex();
	            render.pos(length, -width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(0.7F, 0.3F, 0.25F, 0.5F).endVertex();
	            render.pos(0, -width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(0.7F, 0.3F, 0.25F, 0.5F).endVertex();
	            render.pos(0, -width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(0.7F, 0.3F, 0.25F, 0.5F).endVertex();
	            render.pos(length, -width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(0.7F, 0.3F, 0.25F, 0.5F).endVertex();
	        }
	        tessy.draw();
	        GlStateManager.enableTexture2D();
	        GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
	        GlStateManager.disableBlend();
	        GlStateManager.enableLighting();
	        GlStateManager.popMatrix();
	    }
	 	@SideOnly(Side.CLIENT)
	    public static void renderLightning(Entity entityIn, Vec3d start, Vec3d end, float alpha, float lightningWidth, float innerLightningWidth, float r, float g, float b, Random rand, int iterations){
	    	Tessellator t = Tessellator.getInstance();
	        BufferBuilder v = t.getBuffer();
	       
	        double doubleX = entityIn.prevPosX + (entityIn.posX - entityIn.prevPosX) *  Minecraft.getMinecraft().getRenderPartialTicks();
			double doubleY = entityIn.prevPosY + (entityIn.posY - entityIn.prevPosY) *  Minecraft.getMinecraft().getRenderPartialTicks();
			double doubleZ = entityIn.prevPosZ + (entityIn.posZ - entityIn.prevPosZ) *  Minecraft.getMinecraft().getRenderPartialTicks();
			double x = -doubleX -(doubleX - doubleX);
			double y = -doubleY -(doubleY - doubleY);
			double z = -doubleZ -(doubleZ - doubleZ);
			 Vec3d middleAdd = start.add(end);
			  Vec3d combinedVec = end.subtract(start);
			  Vec3d middle = new Vec3d(middleAdd.x/2, middleAdd.y/2, middleAdd.z/2);
			  Vec3d fqAdd = start.add(middle);
			  Vec3d firstQuarter = new Vec3d(fqAdd.x/2, fqAdd.y/2, fqAdd.z/2);
			  Vec3d lqAdd = middle.add(end);
			  Vec3d lastQuarter = new Vec3d(lqAdd.x/2, lqAdd.y/2, lqAdd.z/2);
			   double length = combinedVec.lengthVector();
	        float maxHeight = (rand.nextFloat()/4);
	        float fqRand = rand.nextFloat()/4;
	        float mRand = rand.nextFloat()/4;
	        float lqRand = rand.nextFloat()/4;
	        float eRand = rand.nextFloat()/4;
	        GlStateManager.pushMatrix();
	        GlStateManager.disableLighting();
	        GlStateManager.enableBlend();
	        GlStateManager.disableTexture2D();
	    
	        	GlStateManager.color(0.5F, 0.8F, 0.8F, 0.7F);
	        	GL11.glLineWidth(lightningWidth);
	        	GL11.glTranslated(x, y, z);
	        	
	        	 v.begin(GL11.GL_LINE_STRIP, DefaultVertexFormats.POSITION);
	        	 if (iterations == 4) {
	            v.pos(start.x, start.y, start.z).endVertex();
	            v.pos(firstQuarter.x - fqRand, firstQuarter.y  , firstQuarter.z).endVertex();
	            v.pos(middle.x + mRand - 0.5F, middle.y + mRand, middle.z).endVertex();
	            v.pos(lastQuarter.x - lqRand, lastQuarter.y - lqRand, lastQuarter.z).endVertex();
	            v.pos(end.x + eRand - 0.5F, end.y + eRand, end.z).endVertex();
	        	 }
	        	 if (iterations == 2) {
	 	            v.pos(start.x, start.y, start.z).endVertex();
	 	           
	 	            v.pos(middle.x + mRand - 0.5F, middle.y + mRand, middle.z).endVertex();
	 	           
	 	            v.pos(end.x + eRand - 0.5F, end.y + eRand, end.z).endVertex();
	 	        	 }
	        	
	        	 
	        t.draw();
	        
	        GlStateManager.enableTexture2D();
	        GlStateManager.disableBlend();
	        GlStateManager.enableLighting();
	        GlStateManager.popMatrix();
	        GlStateManager.pushMatrix();
	        GlStateManager.disableLighting();
	        GlStateManager.enableBlend();
	        GlStateManager.disableTexture2D();
	    
	        	GlStateManager.color(0.7F, 1F, 1F, 1);
	        	GL11.glLineWidth(innerLightningWidth);
	        	GL11.glTranslated(x, y, z);
	        	
	        	 v.begin(GL11.GL_LINE_STRIP, DefaultVertexFormats.POSITION);
	        	 if (iterations == 4) {
	            v.pos(start.x, start.y, start.z).endVertex();
	            v.pos(firstQuarter.x - fqRand, firstQuarter.y , firstQuarter.z).endVertex();
	            v.pos(middle.x + mRand - 0.5F, middle.y + mRand, middle.z).endVertex();
	            v.pos(lastQuarter.x - lqRand, lastQuarter.y - lqRand, lastQuarter.z).endVertex();
	            v.pos(end.x + eRand - 0.5F, end.y + eRand, end.z).endVertex();
	        	 }
	        	 if (iterations == 2) {
	 	            v.pos(start.x, start.y, start.z).endVertex();
	 	           
	 	            v.pos(middle.x + mRand - 0.5F, middle.y + mRand, middle.z).endVertex();
	 	          
	 	            v.pos(end.x + eRand - 0.5F, end.y + eRand, end.z).endVertex();
	 	        	 }
	        	
	        t.draw();
	        
	        GlStateManager.enableTexture2D();
	        GlStateManager.disableBlend();
	        GlStateManager.enableLighting();
	        GlStateManager.popMatrix();
	       
	    }
	 	@SideOnly(Side.CLIENT)
	    public static void renderLine(Entity entityIn, Vec3d start, Vec3d end, float alpha, float lineWidth, float r, float g, float b){
	    	Tessellator t = Tessellator.getInstance();
	        BufferBuilder v = t.getBuffer();
	       
	        double doubleX = entityIn.prevPosX + (entityIn.posX - entityIn.prevPosX) *  Minecraft.getMinecraft().getRenderPartialTicks();
			double doubleY = entityIn.prevPosY + (entityIn.posY - entityIn.prevPosY) *  Minecraft.getMinecraft().getRenderPartialTicks();
			double doubleZ = entityIn.prevPosZ + (entityIn.posZ - entityIn.prevPosZ) *  Minecraft.getMinecraft().getRenderPartialTicks();
			double x = -doubleX -(doubleX - doubleX);
			double y = -doubleY -(doubleY - doubleY);
			double z = -doubleZ -(doubleZ - doubleZ);
			  Vec3d combinedVec = end.subtract(start);
			 
	        GlStateManager.pushMatrix();
	        GlStateManager.disableLighting();
	        GlStateManager.enableBlend();
	        GlStateManager.disableTexture2D();
	        	GlStateManager.color(r, g, b, alpha);
	        	GL11.glLineWidth(lineWidth);
	        	GL11.glTranslated(x, y, z);
	        	
	        	 v.begin(GL11.GL_LINE_STRIP, DefaultVertexFormats.POSITION);
	        	 
	            v.pos(start.x, start.y, start.z).endVertex();
	  
	            v.pos(end.x, end.y, end.z).endVertex();    	 
	        t.draw();
	        
	        GlStateManager.enableTexture2D();
	        GlStateManager.disableBlend();
	        GlStateManager.enableLighting();
	        GlStateManager.popMatrix();
	       
	       
	    }
	 @SideOnly(Side.CLIENT)

	    public static void renderTexturedBeam(Vec3d start, Vec3d end, float alpha, double beamWidth, float[] color){

		 Tessellator tessy = Tessellator.getInstance();

	        BufferBuilder render = tessy.getBuffer();

	        World world = Minecraft.getMinecraft().world;
	        EntityPlayer player = Minecraft.getMinecraft().player;


	        float r = color[0];

	        float g = color[1];

	        float b = color[2];



	       

	       

	        Vec3d combinedVec = end.subtract(start);



	        double pitch = Math.atan2(combinedVec.y, Math.sqrt(combinedVec.x*combinedVec.x+combinedVec.z*combinedVec.z));

	        double yaw = Math.atan2(-combinedVec.z, combinedVec.x);



	        double length = combinedVec.lengthVector();



	        GlStateManager.pushMatrix();



	        GlStateManager.disableLighting();

	        GlStateManager.enableBlend();


	        

	   

	        GlStateManager.translate(start.x-player.posX, start.y-player.posY, start.z-player.posZ);

	        GlStateManager.rotate((float)(180*yaw/Math.PI), 0, 1, 0);

	        GlStateManager.rotate((float)(180*pitch/Math.PI), 0, 0, 1);

	        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Reference.MODID, "textures/blocks/water.png"));

	        

	        render.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_LMAP_COLOR);

	        for(double i = 0; i < 4; i++){

	            double width = beamWidth;

	            render.pos(length, width, width).tex(16, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();

	            render.pos(0, width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();

	            render.pos(0, -width, width).tex(0, 0.3).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();

	            render.pos(length, -width, width).tex(16, 0.3).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();



	            render.pos(length, -width, -width).tex(16, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();

	            render.pos(0, -width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();

	            render.pos(0, width, -width).tex(0, 0.3).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();

	            render.pos(length, width, -width).tex(16, 0.3).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();



	            render.pos(length, width, -width).tex(16, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();

	            render.pos(0, width, -width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();

	            render.pos(0, width, width).tex(0, 0.3).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();

	            render.pos(length, width, width).tex(16, 0.3).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();



	            render.pos(length, -width, width).tex(16, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();

	            render.pos(0, -width, width).tex(0, 0).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();

	            render.pos(0, -width, -width).tex(0, 0.3).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();

	            render.pos(length, -width, -width).tex(16, 0.3).lightmap(MAX_LIGHT_X, MAX_LIGHT_Y).color(r, g, b, alpha).endVertex();

	        }

	        tessy.draw();



	        



	      


	        GlStateManager.disableBlend();

	        GlStateManager.enableLighting();

	        GlStateManager.popMatrix();


	    }
	 private static float lastBrightnessX = OpenGlHelper.lastBrightnessX;
	    private static float lastBrightnessY = OpenGlHelper.lastBrightnessY;

	    public static void setLightmapTextureCoords(float x, float y) {
	        lastBrightnessX = OpenGlHelper.lastBrightnessX;
	        lastBrightnessY = OpenGlHelper.lastBrightnessY;
	        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, x, y);
	    }

	    public static void restoreLightmapTextureCoords() {
	        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lastBrightnessX, lastBrightnessY);
	    }

}

package barryflash.superheroes.capabilities;

import java.util.List;
import java.util.Vector;

import org.apache.commons.lang3.Validate;

import barryflash.superheroes.Reference;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.items.armor.ItemAquamanArmor;
import barryflash.superheroes.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.event.EntityViewRenderEvent.FogColors;
import net.minecraftforge.client.event.EntityViewRenderEvent.FogDensity;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AquamanEventHandler {
	/*private float gamma;
	@SubscribeEvent
	public void onSwimming(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntity();
		
			
			if (player.isInWater()) {
				
				  if (player.moveForward >= 0.001F) {
				 Vec3d vec = player.getLookVec();

					player.motionX = vec.xCoord / 2;

					player.motionY = vec.yCoord / 2;

					player.motionZ = vec.zCoord / 2;
         	 
         	
            player.motionX *= 1.4D;
            player.motionZ *= 1.4D;
				  }
				  }
			
			} 
		
	}
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onSwimmingFog(FogDensity event) {
		if (event.getEntity() instanceof EntityPlayer) {
			if (ItemAquamanArmor.isWearingFullSet((EntityPlayer) event.getEntity(), ModArmor.AquamanChest, ModArmor.AquamanLeggings, ModArmor.AquamanBoots)) {
			if (event.getEntity().isInWater()) {
		event.setDensity(0.00002F);
		
		
			}
			}
		}
	}
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onSwimmingFog(FogColors event) {
		if (event.getEntity() instanceof EntityPlayer) {
			if (ItemAquamanArmor.isWearingFullSet((EntityPlayer) event.getEntity(), ModArmor.AquamanChest, ModArmor.AquamanLeggings, ModArmor.AquamanBoots)) {
			if (event.getEntity().isInWater()) {
		
		event.setRed(0.05F);
		event.setGreen(0.05F);
		event.setBlue(0.2F);
			} 
			}
		}
	}
	private int tickLength = 0;
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onWaterBeam(RenderWorldLastEvent event) {

			EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			IAquaman aquamancap = player.getCapability(AquamanProvider.AQUAMAN_CAP, null);	
			if (ItemAquamanArmor.isWearingFullSet(player, ModArmor.AquamanChest, ModArmor.AquamanLeggings, ModArmor.AquamanBoots)) {
				if (aquamancap.getSourcePos() != null) {
				
			int sdistance = 1;
			int edistance = 30;
			double playerPitch = Math.toRadians(player.rotationPitch);
			double shorzDistance = sdistance * Math.cos(playerPitch);
			double ehorzDistance = edistance * Math.cos(playerPitch);
			double playerYaw = Math.toRadians(player.rotationYaw + 90);


			
	        double sposX = player.posX  +(shorzDistance * Math.cos(playerYaw));
	        double sposY = player.posY + player.getEyeHeight() + (sdistance * -Math.sin(playerPitch));
	        double sposZ = player.posZ + (shorzDistance * Math.sin(playerYaw));
	        double eposX = player.posX  +(ehorzDistance * Math.cos(playerYaw));
	        double eposY = player.posY + player.getEyeHeight() + (edistance * -Math.sin(playerPitch));
	        double eposZ = player.posZ + (ehorzDistance * Math.sin(playerYaw));

			BlockPos start = aquamancap.getSourcePos();
			BlockPos end = new BlockPos(eposX, eposY, eposZ);
			RayTraceResult result = this.getMouseOverExtended();
		     if (result.getBlockPos() != null) {
		    	 Vec3d pvec = new Vec3d(player.posX, player.posY + 1, player.posZ);
		    	 Vec3d svec = new Vec3d(start.getX(), start.getY(), start.getZ());
		    	 Vec3d evec = new Vec3d(end.getX(), end.getY(), end.getZ());
		    	 float r = 1.6F;
		    	 float g = 1.6F;
		    	 float b = 1.6F;
		    	drawLine(svec, pvec, 2, player.worldObj);
		     
		      Utils.renderTexturedBeam(pvec, evec, 1.0F, 0.2F, new float[] {r, g, b});
		     }
		     }
			}
		
	}
	public void drawLine(Vec3d point1, Vec3d point2, double space, World world) {
	   
	    double distance = point1.distanceTo(point2);
	    Vec3d p1 = point1;
	    Vec3d p2 = point2;
	    Vec3d vector = p2.subtract(p1).normalize();
	    Vec3d vec = new Vec3d(vector.xCoord * space, vector.yCoord * space, vector.zCoord*space);
	    double length = 0;
	    for (; length < distance; p1.add(vec)) {
	        world.spawnParticle(EnumParticleTypes.FLAME, p1.xCoord, p1.yCoord, p1.zCoord, 0, 0, 0);
	        length += space;
	    }
	}
	public static RayTraceResult getMouseOverExtended()
	{
	    Minecraft mc = FMLClientHandler.instance().getClient();
	    Entity theRenderViewEntity = mc.getRenderViewEntity();
	    AxisAlignedBB theViewBoundingBox = new AxisAlignedBB(
	            theRenderViewEntity.posX-0.8D,
	            theRenderViewEntity.posY-0.0D,
	            theRenderViewEntity.posZ-0.8D,
	            theRenderViewEntity.posX+0.8D,
	            theRenderViewEntity.posY+1.8D,
	            theRenderViewEntity.posZ+0.8D
	            );
	    RayTraceResult returnMOP = null;
	    if (mc.theWorld != null)
	    {
	        double var2 = 30;
	        returnMOP = theRenderViewEntity.rayTrace(var2, 0);
	        double calcdist = var2;
	        Vec3d pos = theRenderViewEntity.getPositionEyes(0);
	        var2 = calcdist;
	        if (returnMOP != null)
	        {
	            calcdist = returnMOP.hitVec.distanceTo(pos);
	        }
	         
	        Vec3d lookvec = theRenderViewEntity.getLook(0);
	        Vec3d var8 = pos.addVector(lookvec.xCoord * var2, 
	              lookvec.yCoord * var2, 
	              lookvec.zCoord * var2);
	        Entity pointedEntity = null;
	        float var9 = 3.0F;
	        @SuppressWarnings("unchecked")
	        List<Entity> list = mc.theWorld.getEntitiesWithinAABBExcludingEntity(
	              theRenderViewEntity, 
	              theViewBoundingBox.addCoord(
	                    lookvec.xCoord * var2, 
	                    lookvec.yCoord * var2, 
	                    lookvec.zCoord * var2).expand(var9, var9, var9));
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
	                    
	                if (aabb.isVecInside(pos))
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
	}	*/
}

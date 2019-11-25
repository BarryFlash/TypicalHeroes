package barryflash.superheroes.client.render;


import java.util.Random;

import org.lwjgl.opengl.GL11;
import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarang;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarangElectric;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarangExplosive;
import barryflash.superheroes.entities.projectiles.EntityMissile;
import barryflash.superheroes.entities.projectiles.EntitySteveTrevorRifleBullet;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import barryflash.superheroes.models.ModelBatarang;
import barryflash.superheroes.models.ModelBatarangExplosive;
import barryflash.superheroes.models.ModelIronManMark50Missile;
import barryflash.superheroes.models.WonderWomanTiara;
import barryflash.superheroes.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ProjectileRenderBatarangElectric extends Render<EntityBatmanBatarangElectric> {

	
	private ModelBase model = new ModelBatarangExplosive();



	public ProjectileRenderBatarangElectric(RenderManager renderManager) {

		super(renderManager);

	}



	public ProjectileRenderBatarangElectric(RenderManager renderManager, ModelBase model) {

		this(renderManager);

		this.model = model;

	}



	/**

	 * Renders the desired {@code T} type Entity.

	 */

	@Override

	public void doRender(EntityBatmanBatarangElectric entity, double x, double y, double z, float entityYaw, float partialTicks) {
	
	
		GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        if (entity.lightning) {
        float beamWidth = 0.05F;
        Random rand = new Random();
      
        if (!entity.entityList.isEmpty()) {
            for (int i = 0; i < entity.entityList.size(); i++) {
            	Entity ent = entity.entityList.get(i);
            Utils.renderLightningBeam(entity, rand, new Vec3d(entity.posX, entity.posY, entity.posZ), new Vec3d(ent.posX - ent.width/2, ent.posY + ent.height/2, ent.posZ - ent.width/2), 1, beamWidth, 1F, new float[] { 0.4F, 0.7F, 0.8F});
            }
            }
        int randLength = rand.nextInt(4);
		 int randLengthEx = rand.nextInt(5);
		 int randRound = rand.nextInt(1);
		float sdistanceR = 0;
		float edistanceR = -1;
		float area = 0.4F;
		
	
		double entityPitch = Math.toRadians(entity.rotationPitch);
		double shorzDistanceR = sdistanceR;
		double ehorzDistanceR = edistanceR;
		
		
		double entityYawR = Math.toRadians(entity.rotationYaw + (60 *randRound));
		double entityYawR1 = Math.toRadians(entity.rotationYaw + (60 *randRound));
		double entityYawR2 = Math.toRadians(entity.rotationYaw + (60 *randRound));
		double entityYawR3 = Math.toRadians(entity.rotationYaw + (60 *randRound));
		double entityYawR4 = Math.toRadians(entity.rotationYaw + (60 *randRound));
		double entityYawR5 = Math.toRadians(entity.rotationYaw + (60 *randRound));

       double sposXR = entity.posX  +(shorzDistanceR * Math.cos(entityYawR));
     
       double sposZR = entity.posZ + (shorzDistanceR * Math.sin(entityYawR));
       double eposXR = entity.posX  +(ehorzDistanceR * Math.cos(entityYawR + 119.8));
       double eposZR = entity.posZ + (ehorzDistanceR * Math.sin(entityYawR + 119.8));
       
       double sposXR1 = entity.posX  +(shorzDistanceR * Math.cos(entityYawR1));
       
       double sposZR1 = entity.posZ + (shorzDistanceR * Math.sin(entityYawR1));
       double eposXR1 = entity.posX  +(ehorzDistanceR * Math.cos(entityYawR1 + 20));
       double eposZR1 = entity.posZ + (ehorzDistanceR * Math.sin(entityYawR1 + 20));
    
       double sposXR2 = entity.posX  +(shorzDistanceR * Math.cos(entityYawR2));
       
       double sposZR2 = entity.posZ + (shorzDistanceR * Math.sin(entityYawR2));
       double eposXR2 = entity.posX  +(ehorzDistanceR * Math.cos(entityYawR2 + 40));
       double eposZR2 = entity.posZ + (ehorzDistanceR * Math.sin(entityYawR2 + 40));
      
       double sposXR3 = entity.posX  +(shorzDistanceR * Math.cos(entityYawR3));
       
       double sposZR3 = entity.posZ + (shorzDistanceR * Math.sin(entityYawR3));
       double eposXR3 = entity.posX  +(ehorzDistanceR * Math.cos(entityYawR3 + 60));
       double eposZR3 = entity.posZ + (ehorzDistanceR * Math.sin(entityYawR3 + 60));
       
       double sposXR4 = entity.posX  +(shorzDistanceR * Math.cos(entityYawR4));
       
       double sposZR4 = entity.posZ + (shorzDistanceR * Math.sin(entityYawR4));
       double eposXR4 = entity.posX  +(ehorzDistanceR * Math.cos(entityYawR4 + 80));
       double eposZR4 = entity.posZ + (ehorzDistanceR * Math.sin(entityYawR4 + 80));
       
       double sposXR5 = entity.posX  +(shorzDistanceR * Math.cos(entityYawR5));
       
       double sposZR5 = entity.posZ + (shorzDistanceR * Math.sin(entityYawR5));
       double eposXR5 = entity.posX  +(ehorzDistanceR * Math.cos(entityYawR5 + 100));
       double eposZR5 = entity.posZ + (ehorzDistanceR * Math.sin(entityYawR5 + 100));
       float lower = 0F;
       Vec3d svecR = new Vec3d(sposXR, entity.posY - lower, sposZR);
       Vec3d evecR = new Vec3d(eposXR, entity.posY - lower, eposZR);
     
       Vec3d svecR1 = new Vec3d(sposXR1, entity.posY - lower, sposZR1);
       Vec3d evecR1 = new Vec3d(eposXR1, entity.posY - lower, eposZR1);
     
       Vec3d svecR2 = new Vec3d(sposXR2, entity.posY - lower, sposZR2);
       Vec3d evecR2 = new Vec3d(eposXR2, entity.posY - lower, eposZR2);
     
       Vec3d svecR3 = new Vec3d(sposXR3, entity.posY - lower, sposZR3);
       Vec3d evecR3 = new Vec3d(eposXR3, entity.posY - lower, eposZR3);
     
       Vec3d svecR4 = new Vec3d(sposXR4, entity.posY - lower, sposZR4);
       Vec3d evecR4 = new Vec3d(eposXR4, entity.posY - lower, eposZR4);
     
       Vec3d svecR5 = new Vec3d(sposXR5, entity.posY - lower, sposZR5);
       Vec3d evecR5 = new Vec3d(eposXR5, entity.posY - lower, eposZR5);
     
       if (entity.tick > 5) {
       		Utils.renderLightningBeam(entity, rand, svecR, evecR, area, beamWidth, 1F, new float[] { 0.4F, 0.7F, 0.8F});
	       	if (entity.tick > 10) {
		       	Utils.renderLightningBeam(entity, rand, svecR1, evecR1, area, beamWidth, 1F, new float[] { 0.4F, 0.7F, 0.8F});
			    if (entity.tick > 15) {
			    	Utils.renderLightningBeam(entity, rand, svecR2, evecR2, area, beamWidth, 1F, new float[] { 0.4F, 0.7F, 0.8F});
					if (entity.tick > 20) {
						Utils.renderLightningBeam(entity, rand, svecR3, evecR3, area, beamWidth, 1F, new float[] { 0.4F, 0.7F, 0.8F});
					    if (entity.tick > 25) {
					    	Utils.renderLightningBeam(entity, rand, svecR4, evecR4, area, beamWidth, 1F, new float[] { 0.4F, 0.7F, 0.8F});
					        if (entity.tick > 30) {
					       		Utils.renderLightningBeam(entity, rand, svecR5, evecR5, area, beamWidth, 1F, new float[] { 0.4F, 0.7F, 0.8F});
					       	}
				       	}
			       	}
		       	}
	       	}
		 }
           
        }
        GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
        
        GlStateManager.rotate((entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch)) + 180, 0.0F, 0.0F, 1.0F);
        
		this.bindEntityTexture(entity);
		
		
		this.model.render(entity, 0.0F, 0.0F, 0.0F, entityYaw, 0.0F, 0.03125F);

		GlStateManager.popMatrix();

	}

	

	/**

	 * Returns the location of an entity's texture. Doesn't seem to be called unless

	 * you call Render.bindEntityTexture.

	 */

	@Override

	protected ResourceLocation getEntityTexture(EntityBatmanBatarangElectric entity) {

		return new ResourceLocation(Reference.MODID, "textures/models/batarang_electric.png");

	}

}	
package barryflash.superheroes.client.render;


import java.awt.Color;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.entities.particles.ParticleSpawnerDoctorStrangeShields;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarang;
import barryflash.superheroes.entities.projectiles.EntityBullet;
import barryflash.superheroes.entities.projectiles.EntityMissile;
import barryflash.superheroes.entities.projectiles.EntityMjolnir;
import barryflash.superheroes.entities.projectiles.EntityScepterBlast;
import barryflash.superheroes.entities.projectiles.EntitySteveTrevorRifleBullet;
import barryflash.superheroes.entities.projectiles.EntityStormbreaker;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import barryflash.superheroes.models.ModelBatarang;
import barryflash.superheroes.models.ModelBullet;
import barryflash.superheroes.models.ModelIronManMark50Missile;
import barryflash.superheroes.models.ModelMjolnir;
import barryflash.superheroes.models.ModelStormbreakerProjectile;
import barryflash.superheroes.models.WonderWomanTiara;
import barryflash.superheroes.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ProjectileRenderScepterBlast extends Render<EntityScepterBlast> {



	public ProjectileRenderScepterBlast(RenderManager renderManager) {
		super(renderManager);
	}

	@Override
	public void doRender(EntityScepterBlast entity, double x, double y, double z, float entityYaw, float partialTicks) {

		EntityPlayer player = Minecraft.getMinecraft().player;
		Random rand = entity.world.rand;
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) x, (float) y, (float) z);
		GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
	    GlStateManager.rotate((entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch)) + 180, 0.0F, 0.0F, 1.0F);
	    GlStateManager.translate(0F, 0, 0.2);
     
        for (int i = 0; i < 30; i++) {
        
        Utils.renderLaser(entity, entity.getPositionVector().addVector(-entity.width/2 + rand.nextFloat()/6,-entity.height/2 + rand.nextFloat()/6, -entity.width/2 + rand.nextFloat()/6), entity.getPositionVector().addVector(-entity.width/2 + rand.nextFloat()/6,-entity.height/2 + rand.nextFloat()/6, -entity.width/2 + rand.nextFloat()/6), 1F, 0.2F, new float[]{0.2F, 0.8F, 1});
        Utils.renderLaser(entity, entity.getPositionVector().addVector(-entity.width/2 + rand.nextFloat()/4,-entity.height/2 + rand.nextFloat()/4, -entity.width/2 + rand.nextFloat()/4), entity.getPositionVector().addVector(-entity.width/2 + 0.5F + rand.nextFloat()/9,-entity.height/2 + 0.05F + rand.nextFloat()/9, -entity.width/2 + rand.nextFloat()/9), 1F, 0.1F, new float[]{0.2F, 0.8F, 1});
        }
        GlStateManager.popMatrix();


	}

	@Override
	protected ResourceLocation getEntityTexture(EntityScepterBlast entity) {
		return new ResourceLocation(Reference.MODID, "textures/entity/bullet.png");
	}
}	
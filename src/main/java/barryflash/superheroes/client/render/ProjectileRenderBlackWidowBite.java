package barryflash.superheroes.client.render;


import org.lwjgl.opengl.GL11;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarang;
import barryflash.superheroes.entities.projectiles.EntityBlackWidowBite;
import barryflash.superheroes.entities.projectiles.EntityBullet;
import barryflash.superheroes.entities.projectiles.EntityMissile;
import barryflash.superheroes.entities.projectiles.EntityMjolnir;
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
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ProjectileRenderBlackWidowBite extends Render<EntityBlackWidowBite> {

	
	public ProjectileRenderBlackWidowBite(RenderManager renderManager) {
		super(renderManager);
	}



	@Override
	public void doRender(EntityBlackWidowBite entity, double x, double y, double z, float entityYaw, float partialTicks) {
		
		EntityPlayer player = Minecraft.getMinecraft().player;
		GlStateManager.pushMatrix();
		
		GlStateManager.translate((float) x, (float) y, (float) z);
		GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
	    GlStateManager.rotate((entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch)) + 180, 0.0F, 0.0F, 1.0F);
	    Utils.renderLightningBeam(entity, entity.world.rand, entity.getPositionVector().addVector(0, 0, 0.2F), entity.getPositionVector().addVector(2F, 0, 0.2F), 0.2F, 0.03F, 0.8F, new float[]{0.4F, 0.7F, 0.9F});
		GlStateManager.popMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityBlackWidowBite entity) {
		return new ResourceLocation(Reference.MODID, "textures/entity/bullet.png");
	}
}	
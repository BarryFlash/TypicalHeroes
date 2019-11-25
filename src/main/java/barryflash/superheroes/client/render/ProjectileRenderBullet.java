package barryflash.superheroes.client.render;


import org.lwjgl.opengl.GL11;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarang;
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

public class ProjectileRenderBullet extends Render<EntityBullet> {

	private ModelBase model = new ModelBullet();

	public ProjectileRenderBullet(RenderManager renderManager) {
		super(renderManager);
	}

	public ProjectileRenderBullet(RenderManager renderManager, ModelBase model) {
		this(renderManager);
		this.model = model;
	}

	@Override
	public void doRender(EntityBullet entity, double x, double y, double z, float entityYaw, float partialTicks) {

		EntityPlayer player = Minecraft.getMinecraft().player;
		GlStateManager.pushMatrix();
		
		GlStateManager.translate((float) x, (float) y, (float) z);
		GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
	    GlStateManager.rotate((entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch)) + 180, 0.0F, 0.0F, 1.0F);
	    if (entity.isLeft) {
	    GlStateManager.translate(0, 0, -0.2F);
	    } else {
	    	GlStateManager.translate(0, 0, 0.2F);
	    }
		this.bindEntityTexture(entity);
		this.model.render(entity, 0.0F, 0.0F, 0.0F, entityYaw, 0.0F, 0.08125F);
		GlStateManager.popMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityBullet entity) {
		return new ResourceLocation(Reference.MODID, "textures/entity/bullet.png");
	}
}	
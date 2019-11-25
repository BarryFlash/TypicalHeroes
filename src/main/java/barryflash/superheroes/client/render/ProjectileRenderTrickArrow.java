package barryflash.superheroes.client.render;


import org.lwjgl.opengl.GL11;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarang;
import barryflash.superheroes.entities.projectiles.EntityMissile;
import barryflash.superheroes.entities.projectiles.EntitySteveTrevorRifleBullet;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import barryflash.superheroes.entities.projectiles.EntityTrickArrow;
import barryflash.superheroes.models.ModelBatarang;
import barryflash.superheroes.models.ModelIronManMark50Missile;
import barryflash.superheroes.models.ModelTrickArrow;
import barryflash.superheroes.models.WonderWomanTiara;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
public class ProjectileRenderTrickArrow extends Render<EntityTrickArrow> {


	private ModelBase model = new ModelTrickArrow();

	public ProjectileRenderTrickArrow(RenderManager renderManager) {
		super(renderManager);
	}


	public ProjectileRenderTrickArrow(RenderManager renderManager, ModelBase model) {
		this(renderManager);
		this.model = model;
	}



	/**

	 * Renders the desired {@code T} type Entity.

	 */

	@Override
	public void doRender(EntityTrickArrow entity, double x, double y, double z, float entityYaw, float partialTicks) {
		EntityPlayer player = Minecraft.getMinecraft().player;
		GlStateManager.pushMatrix();

        GlStateManager.translate((float)x, (float)y, (float)z);
   
        GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, 0.0F, 0.0F, 1.0F);
        GlStateManager.rotate(-90, 0, 1, 0);
        GlStateManager.enableRescaleNormal();
        float f9 = (float)entity.arrowShake - partialTicks;

        if (f9 > 0.0F)
        {
            float f10 = -MathHelper.sin(f9 * 3.0F) * f9;
            GlStateManager.rotate(f10, 0.0F, 0.0F, 1.0F);
        }
		this.bindEntityTexture(entity);
	
	        GlStateManager.scale(3.5F, 3.5F, 3.5F);
	        GlStateManager.translate(0, 0.0F, 0.02F);
		this.model.render(entity, 0.0F, 0.0F, 0.0F, entityYaw, 0.0F, 0.03125F);
		 GlStateManager.disableRescaleNormal();
		GlStateManager.popMatrix();

	}



	/**

	 * Returns the location of an entity's texture. Doesn't seem to be called unless

	 * you call Render.bindEntityTexture.

	 */

	@Override
	protected ResourceLocation getEntityTexture(EntityTrickArrow entity) {
		return new ResourceLocation(Reference.MODID, "textures/models/trick_arrow.png");
	}

}	
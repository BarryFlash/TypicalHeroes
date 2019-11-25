package barryflash.superheroes.client.render;

import barryflash.superheroes.Reference;
import barryflash.superheroes.entities.projectiles.EntityGrowDisc;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import barryflash.superheroes.models.ModelDisc;
import barryflash.superheroes.models.WonderWomanTiara;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class ProjectileRenderGrowDisc extends Render<EntityGrowDisc> {



	private ModelBase model = new ModelDisc();



	public ProjectileRenderGrowDisc(RenderManager renderManager) {

		super(renderManager);

	}



	public ProjectileRenderGrowDisc(RenderManager renderManager, ModelBase model) {

		this(renderManager);

		this.model = model;

	}



	/**

	 * Renders the desired {@code T} type Entity.

	 */

	@Override

	public void doRender(EntityGrowDisc entity, double x, double y, double z, float entityYaw, float partialTicks) {
		EntityPlayer player = Minecraft.getMinecraft().player;
		
		GlStateManager.pushMatrix();

		GlStateManager.translate((float) x, (float) y, (float) z);

		GlStateManager.enableRescaleNormal();

		

		GlStateManager.rotate(-(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw)) + 180F, 0.0F, 1.0F, 0.0F);

		GlStateManager.rotate(-(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch)), 1.0F, 0.0F, 0.0F);

		this.bindEntityTexture(entity);

		this.model.render(entity, 0.0F, 0.0F, 0.0F, entityYaw, 0.0F, 0.03125F);

		GlStateManager.popMatrix();

	}



	/**

	 * Returns the location of an entity's texture. Doesn't seem to be called unless

	 * you call Render.bindEntityTexture.

	 */

	@Override

	protected ResourceLocation getEntityTexture(EntityGrowDisc entity) {

		return new ResourceLocation(Reference.MODID, "textures/models/disc_grow.png");

	}

}	
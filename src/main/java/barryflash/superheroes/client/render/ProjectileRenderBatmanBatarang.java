package barryflash.superheroes.client.render;


import org.lwjgl.opengl.GL11;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarang;
import barryflash.superheroes.entities.projectiles.EntityMissile;
import barryflash.superheroes.entities.projectiles.EntitySteveTrevorRifleBullet;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import barryflash.superheroes.models.ModelBatarang;
import barryflash.superheroes.models.ModelIronManMark50Missile;
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
public class ProjectileRenderBatmanBatarang extends Render<EntityBatmanBatarang> {



	private ModelBase model = new ModelBatarang();



	public ProjectileRenderBatmanBatarang(RenderManager renderManager) {

		super(renderManager);

	}



	public ProjectileRenderBatmanBatarang(RenderManager renderManager, ModelBase model) {

		this(renderManager);

		this.model = model;

	}



	/**

	 * Renders the desired {@code T} type Entity.

	 */

	@Override

	public void doRender(EntityBatmanBatarang entity, double x, double y, double z, float entityYaw, float partialTicks) {
		EntityPlayer player = Minecraft.getMinecraft().player;
	
		GlStateManager.pushMatrix();

        GlStateManager.translate((float)x, (float)y, (float)z);
   
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

	protected ResourceLocation getEntityTexture(EntityBatmanBatarang entity) {

		return new ResourceLocation(Reference.MODID, "textures/models/batarang.png");

	}

}	
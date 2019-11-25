package barryflash.superheroes.client.render;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarang;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ProjectileRenderBatmanBatarangExplosive extends Render{
	protected ProjectileRenderBatmanBatarangExplosive(RenderManager renderManager) {

		super(renderManager);

	}



	@Override

	public void doRender(Entity par1EntityArrow, double par2, double par4, double par6, float par8, float par9) {

		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":batmanbatarang"),EntityBatmanBatarang.class, "Batman Batarang", 4160, SuperheroesMod.instance, 50, 3, true);

	}



	@Override

	protected ResourceLocation getEntityTexture(Entity entity) {

		return null;

	}
}

package barryflash.superheroes.client.render;

import org.lwjgl.opengl.GL11;

import barryflash.superheroes.Reference;
import barryflash.superheroes.models.ModelTrident;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ProjectileRenderTrident extends Render {
	private static final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/entity/emp.png");
	private ModelBase model;
	
	public ProjectileRenderTrident(RenderManager rendermanager)
{
	super(rendermanager);
	model = new ModelTrident();
	}
	
	@Override
	public ResourceLocation getEntityTexture(Entity entity)
	{
	return texture;
	}
	
@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTick)
	{
	GL11.glPushMatrix();
	bindTexture(texture);
	GL11.glTranslated(x, y - 1.25D, z);
	model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
	GL11.glPopMatrix();
	}
	}

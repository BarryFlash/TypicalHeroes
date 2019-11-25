package barryflash.superheroes.client.render;

import org.lwjgl.opengl.GL11;

import barryflash.superheroes.Reference;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.entities.projectiles.EntityLassoWhip;
import barryflash.superheroes.entities.projectiles.EntityRepulsor;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import barryflash.superheroes.entities.projectiles.EntityWaspBlast;
import barryflash.superheroes.entities.projectiles.EntityWaspBlastSmall;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.items.armor.ItemIronmanMark50Armor;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import barryflash.superheroes.models.ModelRepulsor;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ProjectileRenderWaspBlastSmall extends Render<EntityWaspBlastSmall> {

	//private ModelBase model = new ModelRepulsor();



	public ProjectileRenderWaspBlastSmall(RenderManager renderManager) {

		super(renderManager);

	}



	public ProjectileRenderWaspBlastSmall(RenderManager renderManager, ModelBase model) {

		this(renderManager);

		//this.model = model;

	}



	/**

	 * Renders the desired {@code T} type Entity.

	 */
	
	@Override
	public void doRender(EntityWaspBlastSmall entity, double x, double y, double z, float entityYaw, float partialTicks) {
		 
			  
				 
			
	}
	



	/**

	 * Returns the location of an entity's texture. Doesn't seem to be called unless

	 * you call Render.bindEntityTexture.

	 */

	@Override

	protected ResourceLocation getEntityTexture(EntityWaspBlastSmall entity) {

		return null;

	}

}
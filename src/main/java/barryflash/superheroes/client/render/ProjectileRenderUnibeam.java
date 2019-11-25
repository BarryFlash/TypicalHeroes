package barryflash.superheroes.client.render;

import org.lwjgl.opengl.GL11;

import barryflash.superheroes.Reference;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.entities.projectiles.EntityLassoWhip;
import barryflash.superheroes.entities.projectiles.EntityRepulsor;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import barryflash.superheroes.entities.projectiles.EntityUnibeam;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemIronmanMark50Armor;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import barryflash.superheroes.models.ModelRepulsor;
import barryflash.superheroes.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.BufferBuilder;
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
public class ProjectileRenderUnibeam extends Render<EntityUnibeam> {

	//private ModelBase model = new ModelRepulsor();



	public ProjectileRenderUnibeam(RenderManager renderManager) {

		super(renderManager);

	}



	public ProjectileRenderUnibeam(RenderManager renderManager, ModelBase model) {

		this(renderManager);

		//this.model = model;

	}



	/**

	 * Renders the desired {@code T} type Entity.

	 */
	private float r = 0.8F, g = 0.5F, b = 0.3F;
	Minecraft mc = Minecraft.getMinecraft();
	@Override
	public void doRender(EntityUnibeam entity, double x, double y, double z, float entityYaw, float partialTicks) {
		 if (ItemIronmanMark50Armor.isWearingFullSet((EntityPlayer) mc.player, ModItems.IronManMk50Helmet, ModItems.IronManMk50Chest, ModItems.IronManMk50Legs, ModItems.IronManMk50Boots)) {
			 
			  
			  if (!entity.isDead) {
			  Tessellator t = Tessellator.getInstance();
			  BufferBuilder render = Tessellator.getInstance().getBuffer();
		
				
					  Vec3d vec;
				  if (mc.gameSettings.thirdPersonView == 1) {
				  vec = new Vec3d(0.0F, 0.6, 0);
				  } else if (mc.gameSettings.thirdPersonView == 0) {
					  vec = new Vec3d(0.0F, 0.6, 0.2F);
				  } else {
					  vec = new Vec3d(0.0F, 0.6, 0);
				  }
					Vec3d xvec = vec.rotateYaw(-mc.player.rotationYaw * (float) Math.PI / 180F);
					Vec3d yvec = vec.rotatePitch(mc.player.rotationPitch * (float) Math.PI / 180F);
					
				 double sx = mc.player.posX + xvec.x;
				 double sy = mc.player.posY + (mc.player.height - yvec.y);
				 double sz = mc.player.posZ + xvec.z;
				 double sx2 = entity.getPosition().getX();
				 double sy2 = entity.getPosition().getY();
				 double sz2 = entity.getPosition().getZ();
				

				 
				 Vec3d S = new Vec3d(sx, sy, sz);	
				 Vec3d E = new Vec3d(sx2, sy2, sz2);	
				 
					 Utils.renderLaser(mc.player, S, E, 8.5F, 0.3F, new float[] {r, g, b});
					
				 
				  
				 
				 
			  }
		        
	  


	  }
	}
	



	/**

	 * Returns the location of an entity's texture. Doesn't seem to be called unless

	 * you call Render.bindEntityTexture.

	 */

	@Override

	protected ResourceLocation getEntityTexture(EntityUnibeam entity) {

		return new ResourceLocation(Reference.MODID, "textures/models/ModelRepulsor.png");

	}

}
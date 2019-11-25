package barryflash.superheroes.client.render;

import org.lwjgl.opengl.GL11;

import barryflash.superheroes.Reference;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.entities.projectiles.EntityCannonBlast;
import barryflash.superheroes.entities.projectiles.EntityLassoWhip;
import barryflash.superheroes.entities.projectiles.EntityRepulsor;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemIronmanMark50Armor;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import barryflash.superheroes.models.ModelRepulsor;
import barryflash.superheroes.util.Utils;
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
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ProjectileRenderCannonBlast extends Render<EntityCannonBlast> {

	//private ModelBase model = new ModelRepulsor();



	public ProjectileRenderCannonBlast(RenderManager renderManager) {

		super(renderManager);

	}



	public ProjectileRenderCannonBlast(RenderManager renderManager, ModelBase model) {

		this(renderManager);

		//this.model = model;

	}



	/**

	 * Renders the desired {@code T} type Entity.

	 */
	private float r = 0.0F, g = 0.7F, b = 0.9F;
	Minecraft mc = Minecraft.getMinecraft();
	@Override
	public void doRender(EntityCannonBlast entity, double x, double y, double z, float entityYaw, float partialTicks) {
		 if (ItemIronmanMark50Armor.isWearingFullSet((EntityPlayer) mc.player, ModItems.IronManMk50Helmet, ModItems.IronManMk50Chest, ModItems.IronManMk50Legs, ModItems.IronManMk50Boots)) {
			 
			  
			  if (!entity.isDead) {
			  Tessellator t = Tessellator.getInstance();
			  BufferBuilder render = Tessellator.getInstance().getBuffer();
			  
			
					  Vec3d vec;
					  Vec3d vec2;
					  Vec3d vec3;
					  Vec3d vec4;
					  Vec3d vec5;
					  Vec3d vec6;
				  if (mc.gameSettings.thirdPersonView == 1) {
				  vec = new Vec3d(-0.2F, 0.2, 2);
				  vec2 = new Vec3d(0.2F, 0.2, 2);
				  vec3 = new Vec3d(1.2F, 0.4, 2);
				  vec4 = new Vec3d(-1.2F, 0.4, 2);
				  vec5 = new Vec3d(1.8F, 0.4, 2);
				  vec6 = new Vec3d(-1.8F, 0.4, 2);
				  } else if (mc.gameSettings.thirdPersonView == 0) {
					  vec = new Vec3d(-0.2F, 0.2, 0.2F);
					  vec2 = new Vec3d(0.2F, 0.2, 0.2F);
					  vec3 = new Vec3d(1.2F, 0.2, 0.2F);
					  vec4 = new Vec3d(-1.2F, 0.2, 0.2F);
					  vec5 = new Vec3d(1.8F, 0.4, 0.2F);
					  vec6 = new Vec3d(-1.8F, 0.4, 0.2F);
				  } else {
					  vec = new Vec3d(-0.2F, 0.2, 2);
					  vec2 = new Vec3d(0.2F, 0.2, 2);
					  vec3 = new Vec3d(1.2F, 0.2, 2);
					  vec4 = new Vec3d(-1.2F, 0.2, 2);
					  vec5 = new Vec3d(1.8F, 0.4, 2);
					  vec6 = new Vec3d(-1.8F, 0.4, 2);
				  }
					Vec3d xvec = vec.rotateYaw(-mc.player.rotationYaw * (float) Math.PI / 180F);
					Vec3d yvec = vec.rotatePitch(mc.player.rotationPitch * (float) Math.PI / 180F);
					Vec3d xvec2 = vec2.rotateYaw(-mc.player.rotationYaw * (float) Math.PI / 180F);
					Vec3d yvec2 = vec2.rotatePitch(mc.player.rotationPitch * (float) Math.PI / 180F);
					Vec3d xvec3 = vec3.rotateYaw(-mc.player.rotationYaw * (float) Math.PI / 180F);
					Vec3d yvec3 = vec3.rotatePitch(mc.player.rotationPitch * (float) Math.PI / 180F);
					Vec3d xvec4 = vec4.rotateYaw(-mc.player.rotationYaw * (float) Math.PI / 180F);
					Vec3d yvec4 = vec4.rotatePitch(mc.player.rotationPitch * (float) Math.PI / 180F);
					Vec3d xvec5 = vec5.rotateYaw(-mc.player.rotationYaw * (float) Math.PI / 180F);
					Vec3d yvec5 = vec5.rotatePitch(mc.player.rotationPitch * (float) Math.PI / 180F);
					Vec3d xvec6 = vec6.rotateYaw(-mc.player.rotationYaw * (float) Math.PI / 180F);
					Vec3d yvec6 = vec6.rotatePitch(mc.player.rotationPitch * (float) Math.PI / 180F);
					
				 double sx = mc.player.posX + xvec.x;
				 double sy = mc.player.posY + (mc.player.height - yvec.y);
				 double sz = mc.player.posZ + xvec.z;
				 double sx2 = mc.player.posX + xvec2.x;
				 double sy2 = mc.player.posY + (mc.player.height - yvec2.y);
				 double sz2 = mc.player.posZ + xvec2.z;
				 double sx3 = mc.player.posX + xvec3.x;
				 double sy3 = mc.player.posY + (mc.player.height - yvec3.y);
				 double sz3 = mc.player.posZ + xvec3.z;
				 double sx4 = mc.player.posX + xvec4.x;
				 double sy4 = mc.player.posY + (mc.player.height - yvec4.y);
				 double sz4 = mc.player.posZ + xvec4.z;
				 double sx5 = mc.player.posX + xvec5.x;
				 double sy5 = mc.player.posY + (mc.player.height - yvec5.y);
				 double sz5 = mc.player.posZ + xvec5.z;
				 double sx6 = mc.player.posX + xvec6.x;
				 double sy6 = mc.player.posY + (mc.player.height - yvec6.y);
				 double sz6 = mc.player.posZ + xvec6.z;
				 double ex = entity.getPosition().getX();
				 double ey = entity.getPosition().getY();
				 double ez = entity.getPosition().getZ();
				

				 
				 Vec3d S = new Vec3d(sx, sy, sz);
				 Vec3d S2 = new Vec3d(sx2, sy2, sz2);
				 Vec3d S3 = new Vec3d(sx3, sy3, sz3);
				 Vec3d S4 = new Vec3d(sx4, sy4, sz4);
				 Vec3d S5 = new Vec3d(sx5, sy5, sz5);
				 Vec3d S6 = new Vec3d(sx6, sy6, sz6);
				 Vec3d E = new Vec3d(ex, ey, ez);	
				 
					 Utils.renderLaser(mc.player, S, E, 2.5F, 0.1F, new float[] {r, g, b});
					 Utils.renderLaser(mc.player, S2, E, 2.5F, 0.1F, new float[] {r, g, b});
					 Utils.renderLaser(mc.player, S3, E, 2.5F, 0.4F, new float[] {r, g, b});
					 Utils.renderLaser(mc.player, S4, E, 2.5F, 0.4F, new float[] {r, g, b});
					 Utils.renderLaser(mc.player, S5, E, 2.5F, 0.3F, new float[] {r, g, b});
					 Utils.renderLaser(mc.player, S6, E, 2.5F, 0.3F, new float[] {r, g, b});
					
				 
				  }
				 
			  
				 
			  }
		        
	  


	  
	}
	



	/**

	 * Returns the location of an entity's texture. Doesn't seem to be called unless

	 * you call Render.bindEntityTexture.

	 */

	@Override

	protected ResourceLocation getEntityTexture(EntityCannonBlast entity) {

		return null;

	}

}
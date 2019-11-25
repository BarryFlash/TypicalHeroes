package barryflash.superheroes.client.render;

import org.lwjgl.opengl.GL11;

import barryflash.superheroes.entities.projectiles.EntityLassoWhip;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import barryflash.superheroes.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ProjectileRenderLasso extends Render<EntityLassoWhip> {

	private ModelBase model = null;



	public ProjectileRenderLasso(RenderManager renderManager) {

		super(renderManager);

	}



	public ProjectileRenderLasso(RenderManager renderManager, ModelBase model) {

		this(renderManager);

		this.model = model;

	}



	/**

	 * Renders the desired {@code T} type Entity.

	 */
	Minecraft mc = Minecraft.getMinecraft();
	@Override
	public void doRender(EntityLassoWhip entity, double x, double y, double z, float entityYaw, float partialTicks) {
		if (ItemWonderWomanArmor.isWearingFullSet(mc.player, ModItems.WonderWomanTiara, ModItems.WonderWomanChestplate, ModItems.WonderWomanSkirt, ModItems.WonderWomanBoots)) {
			
			
			}
		}
	



	/**

	 * Returns the location of an entity's texture. Doesn't seem to be called unless

	 * you call Render.bindEntityTexture.

	 */

	@Override

	protected ResourceLocation getEntityTexture(EntityLassoWhip entity) {

		return null;

	}

}
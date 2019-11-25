package barryflash.superheroes.client.render;


import org.lwjgl.opengl.GL11;

import barryflash.superheroes.Reference;
import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.entities.projectiles.EntityBatmanBatarang;
import barryflash.superheroes.entities.projectiles.EntityBatmanKryptoniteSpear;
import barryflash.superheroes.entities.projectiles.EntityMissile;
import barryflash.superheroes.entities.projectiles.EntitySteveTrevorRifleBullet;
import barryflash.superheroes.entities.projectiles.EntityTiara;
import barryflash.superheroes.models.ModelBatarang;
import barryflash.superheroes.models.ModelIronManMark50Missile;
import barryflash.superheroes.models.WonderWomanTiara;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
public class ProjectileRenderBatmanSpear extends Render<EntityBatmanKryptoniteSpear> {



	protected final Item item;
    private final RenderItem itemRenderer;



	public ProjectileRenderBatmanSpear(RenderManager renderManager, Item itemIn, RenderItem itemRendererIn) {

		super(renderManager);
		 this.item = itemIn;
	       this.itemRenderer = itemRendererIn;

	}



	/**

	 * Renders the desired {@code T} type Entity.

	 */

	@Override

	public void doRender(EntityBatmanKryptoniteSpear entity, double x, double y, double z, float entityYaw, float partialTicks) {
		EntityPlayer player = Minecraft.getMinecraft().player;

		GlStateManager.pushMatrix();

		GlStateManager.disableLighting();
        GlStateManager.translate((float)x, (float)y, (float)z);
   
        GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
        
        GlStateManager.rotate((entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch)) + 180, 0.0F, 0.0F, 1.0F);
        GlStateManager.rotate(90F, 0.0F, 0.0F, 1.0F);
		this.bindEntityTexture(entity);

		 this.itemRenderer.renderItem(this.getStackToRender(entity), ItemCameraTransforms.TransformType.GROUND);

		GlStateManager.popMatrix();

	}


	 public ItemStack getStackToRender(EntityBatmanKryptoniteSpear entityIn)
	    {
	        return new ItemStack(this.item);
	    }

	@Override

	protected ResourceLocation getEntityTexture(EntityBatmanKryptoniteSpear entity) {

		return new ResourceLocation(Reference.MODID, "textures/models/batman_spear.png");

	}

}	
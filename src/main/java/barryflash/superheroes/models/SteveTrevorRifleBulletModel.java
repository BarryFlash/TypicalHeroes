package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

/**
 * SteveTrevor_RifleBullet - BarryFlash
 * Created using Tabula 6.0.0
 */
public class SteveTrevorRifleBulletModel extends ModelBase {
	public static final ResourceLocation TEXTURE = new ResourceLocation("sm", "textures/models/SteveTrevor_RifleBullet.png");
    public ModelRenderer shape1;
    public ModelRenderer shape1_1;

    public SteveTrevorRifleBulletModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.shape1 = new ModelRenderer(this, 0, 5);
        this.shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
        this.shape1_1 = new ModelRenderer(this, 0, 0);
        this.shape1_1.setRotationPoint(-1.7F, 0.0F, 0.0F);
        this.shape1_1.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, -0.1F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape1.render(f5);
        this.shape1_1.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

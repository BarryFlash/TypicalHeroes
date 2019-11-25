package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

import barryflash.superheroes.Reference;

/**
 * SteveTrevorShotgunModel - BarryFlash
 * Created using Tabula 6.0.0
 */
public class SteveTrevorRifleModel extends ModelBase {
	public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID, "textures/models/stevetrevor_rifle.png");
	
    public ModelRenderer shape1;
    public ModelRenderer shape1_1;
    public ModelRenderer shape1_2;
    public ModelRenderer shape5;
    public ModelRenderer shape5_1;
    public ModelRenderer shape5_2;
    public ModelRenderer shape5_3;
    public ModelRenderer shape5_4;
    public ModelRenderer shape5_5;
    public ModelRenderer shape5_6;
    public ModelRenderer shape5_7;
    public ModelRenderer shape5_8;
    public ModelRenderer shape5_9;
    public ModelRenderer shape5_10;
    public ModelRenderer shape5_11;
    public ModelRenderer shape5_12;
    public ModelRenderer shape1_3;
    public ModelRenderer shape1_4;
    public ModelRenderer shape1_5;
    public ModelRenderer shape5_13;

    public SteveTrevorRifleModel() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.shape1_2 = new ModelRenderer(this, 0, 0);
        this.shape1_2.setRotationPoint(-5.6F, 3.9F, 0.0F);
        this.shape1_2.addBox(0.0F, 0.0F, 0.0F, 6, 1, 1, 0.0F);
        this.setRotateAngle(shape1_2, 0.0F, 0.0F, -0.27314402793711257F);
        this.shape5_2 = new ModelRenderer(this, 0, 0);
        this.shape5_2.setRotationPoint(1.3F, -0.5F, 0.0F);
        this.shape5_2.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
        this.setRotateAngle(shape5_2, 0.0F, 0.0F, 0.5918411493512771F);
        this.shape5_10 = new ModelRenderer(this, 3, 20);
        this.shape5_10.setRotationPoint(12.1F, 0.25F, 0.0F);
        this.shape5_10.addBox(0.0F, 0.0F, 0.0F, 11, 1, 1, 0.1F);
        this.shape1_4 = new ModelRenderer(this, 0, 0);
        this.shape1_4.setRotationPoint(-5.86F, 2.0F, 0.0F);
        this.shape1_4.addBox(0.0F, 0.0F, 0.0F, 3, 2, 1, -0.03F);
        this.shape1_1 = new ModelRenderer(this, 0, 0);
        this.shape1_1.setRotationPoint(-5.7F, 0.8F, 0.0F);
        this.shape1_1.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
        this.setRotateAngle(shape1_1, 0.0F, 0.0F, 0.136659280431156F);
        this.shape5_13 = new ModelRenderer(this, 50, 11);
        this.shape5_13.setRotationPoint(6.1F, -1.5F, 0.0F);
        this.shape5_13.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, -0.2F);
        this.setRotateAngle(shape5_13, 0.0F, 0.0F, -0.27314402793711257F);
        this.shape5_1 = new ModelRenderer(this, 0, 0);
        this.shape5_1.setRotationPoint(1.3F, 2.8F, 0.0F);
        this.shape5_1.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
        this.setRotateAngle(shape5_1, 0.0F, 0.0F, -0.4553564018453205F);
        this.shape1_5 = new ModelRenderer(this, 0, 0);
        this.shape1_5.setRotationPoint(-5.3F, 1.12F, 0.0F);
        this.shape1_5.addBox(0.0F, 0.0F, 0.0F, 4, 2, 1, -0.02F);
        this.shape5_7 = new ModelRenderer(this, 50, 20);
        this.shape5_7.setRotationPoint(7.8F, -0.9F, 0.0F);
        this.shape5_7.addBox(0.0F, 0.0F, 0.0F, 4, 2, 1, 0.2F);
        this.shape5_4 = new ModelRenderer(this, 70, 0);
        this.shape5_4.setRotationPoint(6.2F, 1.3F, 0.0F);
        this.shape5_4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.2F);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(-5.7F, 0.5F, 0.0F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
        this.setRotateAngle(shape1, 0.0F, 0.0F, -0.136659280431156F);
        this.shape5_8 = new ModelRenderer(this, 3, 20);
        this.shape5_8.setRotationPoint(12.1F, -1.1F, 0.0F);
        this.shape5_8.addBox(0.0F, 0.0F, 0.0F, 11, 1, 1, 0.1F);
        this.shape5_12 = new ModelRenderer(this, 0, 0);
        this.shape5_12.setRotationPoint(2.5F, 1.2F, 0.0F);
        this.shape5_12.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
        this.setRotateAngle(shape5_12, 0.0F, 0.0F, -0.31869712141416456F);
        this.shape1_3 = new ModelRenderer(this, 0, 0);
        this.shape1_3.setRotationPoint(-4.2F, 0.5F, 0.0F);
        this.shape1_3.addBox(0.0F, 0.0F, 0.0F, 7, 2, 1, -0.01F);
        this.shape5_9 = new ModelRenderer(this, 3, 40);
        this.shape5_9.setRotationPoint(13.9F, 0.25F, 0.0F);
        this.shape5_9.addBox(0.0F, 0.0F, 0.0F, 6, 1, 1, 0.2F);
        this.shape5_3 = new ModelRenderer(this, 0, 0);
        this.shape5_3.setRotationPoint(2.2F, 0.6F, 0.0F);
        this.shape5_3.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
        this.setRotateAngle(shape5_3, 0.0F, 0.0F, -0.31869712141416456F);
        this.shape5_11 = new ModelRenderer(this, 3, 30);
        this.shape5_11.setRotationPoint(22.5F, -1.1F, 0.0F);
        this.shape5_11.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.2F);
        this.shape5 = new ModelRenderer(this, 0, 0);
        this.shape5.setRotationPoint(0.0F, 2.3F, 0.0F);
        this.shape5.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
        this.setRotateAngle(shape5, 0.0F, 0.0F, 0.22759093446006054F);
        this.shape5_6 = new ModelRenderer(this, 0, 0);
        this.shape5_6.setRotationPoint(2.8F, 2.0F, 0.0F);
        this.shape5_6.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
        this.setRotateAngle(shape5_6, 0.0F, 0.0F, -0.31869712141416456F);
        this.shape5_5 = new ModelRenderer(this, 50, 0);
        this.shape5_5.setRotationPoint(5.7F, -0.4F, 0.0F);
        this.shape5_5.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.2F);
        this.setRotateAngle(shape5_5, 0.0F, 0.0F, -0.22759093446006054F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape1_2.render(f5);
        this.shape5_2.render(f5);
        this.shape5_10.render(f5);
        this.shape1_4.render(f5);
        this.shape1_1.render(f5);
        this.shape5_13.render(f5);
        this.shape5_1.render(f5);
        this.shape1_5.render(f5);
        this.shape5_7.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.shape5_4.offsetX, this.shape5_4.offsetY, this.shape5_4.offsetZ);
        GlStateManager.translate(this.shape5_4.rotationPointX * f5, this.shape5_4.rotationPointY * f5, this.shape5_4.rotationPointZ * f5);
        GlStateManager.scale(1.0D, 1.0D, 0.8D);
        GlStateManager.translate(-this.shape5_4.offsetX, -this.shape5_4.offsetY, -this.shape5_4.offsetZ);
        GlStateManager.translate(-this.shape5_4.rotationPointX * f5, -this.shape5_4.rotationPointY * f5, -this.shape5_4.rotationPointZ * f5);
        this.shape5_4.render(f5);
        GlStateManager.popMatrix();
        this.shape1.render(f5);
        this.shape5_8.render(f5);
        this.shape5_12.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.shape1_3.offsetX, this.shape1_3.offsetY, this.shape1_3.offsetZ);
        GlStateManager.translate(this.shape1_3.rotationPointX * f5, this.shape1_3.rotationPointY * f5, this.shape1_3.rotationPointZ * f5);
        GlStateManager.scale(1.0D, 1.2D, 1.0D);
        GlStateManager.translate(-this.shape1_3.offsetX, -this.shape1_3.offsetY, -this.shape1_3.offsetZ);
        GlStateManager.translate(-this.shape1_3.rotationPointX * f5, -this.shape1_3.rotationPointY * f5, -this.shape1_3.rotationPointZ * f5);
        this.shape1_3.render(f5);
        GlStateManager.popMatrix();
        this.shape5_9.render(f5);
        this.shape5_3.render(f5);
        this.shape5_11.render(f5);
        this.shape5.render(f5);
        this.shape5_6.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.shape5_5.offsetX, this.shape5_5.offsetY, this.shape5_5.offsetZ);
        GlStateManager.translate(this.shape5_5.rotationPointX * f5, this.shape5_5.rotationPointY * f5, this.shape5_5.rotationPointZ * f5);
        GlStateManager.scale(1.0D, 1.1D, 1.0D);
        GlStateManager.translate(-this.shape5_5.offsetX, -this.shape5_5.offsetY, -this.shape5_5.offsetZ);
        GlStateManager.translate(-this.shape5_5.rotationPointX * f5, -this.shape5_5.rotationPointY * f5, -this.shape5_5.rotationPointZ * f5);
        this.shape5_5.render(f5);
        GlStateManager.popMatrix();
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

package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

/**
 * aquaman_trident by Unknown
 */
@SideOnly(Side.CLIENT)
public class ModelTrident extends ModelBase {
    public ModelRenderer cube;
    public ModelRenderer cube1;
    public ModelRenderer cube2;
    public ModelRenderer cube3;
    public ModelRenderer cube4;
    public ModelRenderer cube5;
    public ModelRenderer cube6;
    public ModelRenderer cube7;
    public ModelRenderer cube8;
    public ModelRenderer cube9;
    public ModelRenderer cube10;
    public ModelRenderer cube11;
    public ModelRenderer cube12;
    public ModelRenderer cube13;
    public ModelRenderer cube14;
    public ModelRenderer cube15;

    public ModelTrident() {
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.cube = new ModelRenderer(this, 0, 0);
        this.cube.setRotationPoint(-0.5F, 1.0F, -0.5F);
        this.cube.addBox(0.0F, 0.0F, 0.0F, 1, 26, 1);
        this.cube1 = new ModelRenderer(this, 0, 0);
        this.cube1.setRotationPoint(-0.75F, 5.0F, -0.75F);
        this.cube1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.cube2 = new ModelRenderer(this, 0, 0);
        this.cube2.setRotationPoint(-1.0F, 4.0F, -1.0F);
        this.cube2.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
        this.cube3 = new ModelRenderer(this, 0, 0);
        this.cube3.setRotationPoint(-1.5F, 3.0F, -1.5F);
        this.cube3.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3);
        this.cube4 = new ModelRenderer(this, 0, 0);
        this.cube4.setRotationPoint(11.8F, 11.0F, 0.5F);
        this.cube4.addBox(-2.3F, -13.3F, -1.5F, 3, 1, 2);
        this.setRotationAngles(this.cube4, -0.0F, -0.0F, -0.7853981633974483F);
        this.cube5 = new ModelRenderer(this, 0, 0);
        this.cube5.setRotationPoint(-11.8F, 11.0F, 0.5F);
        this.cube5.addBox(-0.7F, -13.3F, -1.5F, 3, 1, 2);
        this.setRotationAngles(this.cube5, -0.0F, -0.0F, 0.7853981633974483F);
        this.cube6 = new ModelRenderer(this, 0, 0);
        this.cube6.setRotationPoint(7.0F, 12.4F, 0.5F);
        this.cube6.addBox(-2.5F, -13.1F, -1.5F, 6, 1, 2);
        this.setRotationAngles(this.cube6, -0.0F, -0.0F, -0.39269908169872414F);
        this.cube7 = new ModelRenderer(this, 0, 0);
        this.cube7.setRotationPoint(2.6F, 0.3F, -1.0F);
        this.cube7.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2);
        this.cube8 = new ModelRenderer(this, 0, 0);
        this.cube8.setRotationPoint(-3.6F, 0.3F, -1.0F);
        this.cube8.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2);
        this.cube9 = new ModelRenderer(this, 0, 0);
        this.cube9.setRotationPoint(-9.1F, 11.5F, 0.5F);
        this.cube9.addBox(-1.3F, -13.0F, -1.5F, 6, 1, 2);
        this.setRotationAngles(this.cube9, -0.0F, -0.0F, 0.39269908169872414F);
        this.cube10 = new ModelRenderer(this, 0, 0);
        this.cube10.setRotationPoint(4.6000004F, -4.200001F, -0.5F);
        this.cube10.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1);
        this.cube11 = new ModelRenderer(this, 0, 0);
        this.cube11.setRotationPoint(-5.6F, -4.200001F, -0.5F);
        this.cube11.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1);
        this.cube12 = new ModelRenderer(this, 0, 0);
        this.cube12.setRotationPoint(2.0F, -6.200001F, -0.5F);
        this.cube12.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1);
        this.cube13 = new ModelRenderer(this, 0, 0);
        this.cube13.setRotationPoint(-3.0F, -6.200001F, -0.5F);
        this.cube13.addBox(0.0F, 0.0F, 0.0F, 1, 7, 1);
        this.cube14 = new ModelRenderer(this, 0, 0);
        this.cube14.setRotationPoint(-0.5F, -7.200001F, -0.5F);
        this.cube14.addBox(0.0F, 0.0F, 0.0F, 1, 9, 1);
        this.cube15 = new ModelRenderer(this, 0, 0);
        this.cube15.setRotationPoint(-0.75F, 25.0F, -0.75F);
        this.cube15.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
     	super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

    public void setRotationAngles(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

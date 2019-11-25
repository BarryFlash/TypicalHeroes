package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDisc extends ModelBase
{
    public ModelRenderer shape1;
    public ModelRenderer shape1_1;
    public ModelRenderer shape1_2;
    public ModelRenderer shape1_3;
    public ModelRenderer shape1_4;
    public ModelRenderer shape1_5;
    public ModelRenderer shape1_6;
    public ModelRenderer shape1_7;
    public ModelRenderer shape1_8;
    public ModelRenderer shape1_9;
    public ModelRenderer shape1_10;

    public ModelDisc()
    {
        textureWidth = 32;
        textureHeight = 32;
        shape1_8 = new ModelRenderer(this, 0, 2);
        shape1_8.setRotationPoint(0.0F, 0.0F, 0.0F);
        shape1_8.addBox(0.1F, 0.0F, 1.1F, 2, 1, 1, -0.2F);
        setRotateAngle(shape1_8, 0.0F, 0.8758062186507546F, 0.0F);
        shape1_10 = new ModelRenderer(this, 6, 2);
        shape1_10.mirror = true;
        shape1_10.setRotationPoint(0.0F, 0.0F, 0.0F);
        shape1_10.addBox(-1.1F, 0.0F, -1.5F, 1, 1, 2, -0.19F);
        setRotateAngle(shape1_10, 0.0F, -0.32759830059933565F, 0.0F);
        shape1_3 = new ModelRenderer(this, 6, 2);
        shape1_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        shape1_3.addBox(-0.4F, 0.0F, 2.3F, 2, 1, 1, -0.19F);
        shape1_2 = new ModelRenderer(this, 0, 2);
        shape1_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        shape1_2.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, -0.2F);
        shape1_7 = new ModelRenderer(this, 6, 2);
        shape1_7.setRotationPoint(0.0F, 0.0F, 0.0F);
        shape1_7.addBox(1.1F, 0.0F, 1.7F, 1, 1, 2, -0.19F);
        setRotateAngle(shape1_7, 0.0F, 0.8758062186507546F, 0.0F);
        shape1_9 = new ModelRenderer(this, 0, 2);
        shape1_9.mirror = true;
        shape1_9.setRotationPoint(0.0F, 0.0F, 0.0F);
        shape1_9.addBox(-1.1F, 0.0F, 0.0F, 2, 1, 1, -0.2F);
        setRotateAngle(shape1_9, 0.0F, -0.32759830059933565F, 0.0F);
        shape1_6 = new ModelRenderer(this, 6, 6);
        shape1_6.mirror = true;
        shape1_6.setRotationPoint(0.0F, 0.0F, 0.0F);
        shape1_6.addBox(-0.7F, 0.0F, -1.6F, 2, 1, 1, -0.2F);
        setRotateAngle(shape1_6, 0.0F, -0.13857914260834978F, 0.0F);
        shape1 = new ModelRenderer(this, 22, 2);
        shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
        shape1.addBox(0.0F, -0.3F, 0.0F, 2, 1, 2, -0.4F);
        shape1_1 = new ModelRenderer(this, 3, 5);
        shape1_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        shape1_1.addBox(-2.2F, 0.0F, 0.6F, 1, 1, 2, -0.2F);
        setRotateAngle(shape1_1, 0.0F, 0.613134166225608F, 0.0F);
        shape1_5 = new ModelRenderer(this, 0, 2);
        shape1_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        shape1_5.addBox(0.6F, 0.0F, 0.7F, 1, 1, 2, -0.2F);
        shape1_4 = new ModelRenderer(this, 3, 4);
        shape1_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        shape1_4.addBox(2.9F, 0.0F, -1.4F, 1, 1, 2, -0.2F);
        setRotateAngle(shape1_4, 0.0F, -0.5544911033585984F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        shape1_8.render(f5);
        shape1_10.render(f5);
        shape1_3.render(f5);
        shape1_2.render(f5);
        shape1_7.render(f5);
        shape1_9.render(f5);
        shape1_6.render(f5);
        shape1.render(f5);
        shape1_1.render(f5);
        shape1_5.render(f5);
        shape1_4.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBatmanSmokebomb extends ModelBase
{
    public ModelRenderer shape1;
    public ModelRenderer shape1_1;
    public ModelRenderer shape1_2;
    public ModelRenderer shape1_3;
    public ModelRenderer shape1_4;

    public ModelBatmanSmokebomb()
    {
        textureWidth = 64;
        textureHeight = 64;
        shape1_4 = new ModelRenderer(this, 0, 0);
        shape1_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        shape1_4.addBox(0.0F, -1.7F, 0.0F, 3, 1, 3, -0.2F);
        shape1_3 = new ModelRenderer(this, 30, 0);
        shape1_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        shape1_3.addBox(0.0F, -0.7F, 0.0F, 3, 1, 3, -0.1F);
        shape1_2 = new ModelRenderer(this, 0, 0);
        shape1_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        shape1_2.addBox(0.0F, -1.2F, 0.0F, 3, 1, 3, 0.0F);
        shape1_1 = new ModelRenderer(this, 0, 0);
        shape1_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        shape1_1.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F);
        shape1 = new ModelRenderer(this, 0, 0);
        shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
        shape1.addBox(0.0F, 0.5F, 0.0F, 3, 1, 3, -0.2F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        shape1_4.render(f5);
        shape1_3.render(f5);
        shape1_2.render(f5);
        shape1_1.render(f5);
        shape1.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

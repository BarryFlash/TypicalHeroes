package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBullet extends ModelBase
{
    public ModelRenderer shape1;

    public ModelBullet()
    {
        textureWidth = 64;
        textureHeight = 32;
        shape1 = new ModelRenderer(this, 0, 1);
        shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
        shape1.addBox(-1.0F, 0.0F, -0.5F, 2, 1, 1, -0.2F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        shape1.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

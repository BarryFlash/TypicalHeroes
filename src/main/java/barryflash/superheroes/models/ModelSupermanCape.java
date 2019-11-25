package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSupermanCape extends ModelBiped
{
    public ModelRenderer capeb;

    public ModelSupermanCape()
    {
        textureWidth = 64;
        textureHeight = 64;
        capeb = new ModelRenderer(this, 11, 7);
        capeb.setRotationPoint(0.0F, 0.0F, 2.2F);
        capeb.addBox(-7.0F, -0.3F, -0.3F, 14, 22, 1, -0.3F);
        
        bipedBody.addChild(capeb);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        capeb.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGeneralZodCape extends ModelBiped
{
    public ModelRenderer shape529;

    public ModelGeneralZodCape()
    {
        textureWidth = 128;
        textureHeight = 128;
        shape529 = new ModelRenderer(this, 23, 56);
        shape529.setRotationPoint(0.0F, -0.2F, 2.0F);
        shape529.addBox(-6.1F, -0.1F, 0.0F, 12, 21, 1, -0.3F);
   
        
        bipedBody.addChild(shape529);
    }
    
    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        shape529.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

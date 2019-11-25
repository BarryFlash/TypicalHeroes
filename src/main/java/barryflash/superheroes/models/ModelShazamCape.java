package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelShazamCape extends ModelBiped
{
    public ModelRenderer cape;
    public ModelRenderer cape1;

    public ModelShazamCape()
    {
        textureWidth = 64;
        textureHeight = 64;
        cape = new ModelRenderer(this, 30, 22);
        cape.setRotationPoint(0.0F, 0.0F, 2.1F);
        cape.addBox(-5.5F, 0.0F, 0.0F, 11, 8, 1, -0.3F);
        setRotateAngle(cape, 0.08988445647770797F, 0.0F, 0.0F);
        cape1 = new ModelRenderer(this, 1, 21);
        cape1.setRotationPoint(0.0F, 0.0F, 2.1F);
        cape1.addBox(-5.0F, -0.3F, 0.0F, 10, 15, 1, -0.3F);
        
        bipedBody.addChild(cape);
        bipedBody.addChild(cape1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        cape.render(f5);
        cape1.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

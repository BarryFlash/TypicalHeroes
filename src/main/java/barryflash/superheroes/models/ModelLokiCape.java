package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLokiCape extends ModelBiped
{
    public ModelRenderer cape;
    public ModelRenderer cape_1;
    public ModelRenderer cape_2;
    public ModelRenderer cape_3;
    public ModelRenderer cape_4;
    public ModelRenderer cape_5;
    public ModelRenderer cape_6;

    public ModelLokiCape()
    {
        textureWidth = 128;
        textureHeight = 128;
        cape_4 = new ModelRenderer(this, 41, 104);
        cape_4.mirror = true;
        cape_4.setRotationPoint(0.0F, -0.3F, 2.1F);
        cape_4.addBox(5.9F, 0.8F, -0.2F, 2, 5, 1, -0.3F);
        setRotateAngle(cape_4, 0.0F, 0.0F, 0.1609193570338772F);
        cape_6 = new ModelRenderer(this, 34, 104);
        cape_6.setRotationPoint(0.0F, -0.3F, 2.1F);
        cape_6.addBox(-7.9F, 0.8F, -0.2F, 2, 5, 1, -0.3F);
        setRotateAngle(cape_6, 0.0F, 0.0F, -0.1609193570338772F);
        cape = new ModelRenderer(this, 41, 104);
        cape.mirror = true;
        cape.setRotationPoint(0.0F, -0.3F, 2.1F);
        cape.addBox(6.0F, -0.2F, -0.2F, 2, 2, 1, -0.3F);
        cape_2 = new ModelRenderer(this, 41, 104);
        cape_2.mirror = true;
        cape_2.setRotationPoint(0.0F, -0.3F, 2.1F);
        cape_2.addBox(6.1F, -0.9F, -0.2F, 2, 5, 1, -0.3F);
        setRotateAngle(cape_2, 0.0F, 0.0F, 0.26005405854715513F);
        cape_1 = new ModelRenderer(this, 34, 104);
        cape_1.setRotationPoint(0.0F, -0.3F, 2.1F);
        cape_1.addBox(-7.0F, -0.2F, -0.2F, 14, 23, 1, -0.3F);
        cape_3 = new ModelRenderer(this, 34, 104);
        cape_3.setRotationPoint(0.0F, -0.3F, 2.1F);
        cape_3.addBox(-8.0F, -0.2F, -0.2F, 2, 2, 1, -0.3F);
        cape_5 = new ModelRenderer(this, 34, 104);
        cape_5.setRotationPoint(0.0F, -0.3F, 2.1F);
        cape_5.addBox(-8.1F, -0.9F, -0.2F, 2, 5, 1, -0.3F);
        setRotateAngle(cape_5, 0.0F, 0.0F, -0.26005405854715513F);
        
        bipedBody.addChild(cape);
        bipedBody.addChild(cape_1);
        bipedBody.addChild(cape_2);
        bipedBody.addChild(cape_3);
        bipedBody.addChild(cape_4);
        bipedBody.addChild(cape_5);
        bipedBody.addChild(cape_6);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        cape_4.render(f5);
        cape_6.render(f5);
        cape.render(f5);
        cape_2.render(f5);
        cape_1.render(f5);
        cape_3.render(f5);
        cape_5.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

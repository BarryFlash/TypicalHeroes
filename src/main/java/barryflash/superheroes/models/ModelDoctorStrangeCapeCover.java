package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDoctorStrangeCapeCover extends ModelBiped
{
    public ModelRenderer cape;
    public ModelRenderer cape_1;
    public ModelRenderer cape_2;
    public ModelRenderer cape_3;
    public ModelRenderer cape_4;
    public ModelRenderer cape_5;

    public ModelDoctorStrangeCapeCover()
    {
        textureWidth = 128;
        textureHeight = 128;
        cape_3 = new ModelRenderer(this, 0, 0);
        cape_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        cape_3.addBox(-5.4F, -9.6F, -1.1F, 1, 10, 14, 0.0F);
        setRotateAngle(cape_3, 0.45378560551852565F, 0.0F, 0.0F);
        cape = new ModelRenderer(this, 0, 0);
        cape.setRotationPoint(0.0F, 0.0F, 0.0F);
        cape.addBox(-5.0F, -9.0F, -5.0F, 10, 3, 10, 0.0F);
        cape_1 = new ModelRenderer(this, 0, 0);
        cape_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        cape_1.addBox(-5.0F, -4.3F, -5.0F, 10, 4, 10, 0.3F);
        cape_5 = new ModelRenderer(this, 0, 0);
        cape_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        cape_5.addBox(-4.9F, -7.5F, -2.9F, 10, 4, 8, 0.3F);
        cape_4 = new ModelRenderer(this, 0, 0);
        cape_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        cape_4.addBox(-5.0F, -2.0F, -5.0F, 10, 3, 10, 0.0F);
        cape_2 = new ModelRenderer(this, 0, 0);
        cape_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        cape_2.addBox(-5.0F, -8.4F, -5.0F, 10, 3, 10, 0.2F);
        
        bipedHead.addChild(cape);
        bipedHead.addChild(cape_1);
        bipedHead.addChild(cape_2);
        bipedHead.addChild(cape_3);
        bipedHead.addChild(cape_4);
        bipedHead.addChild(cape_5);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        cape_3.render(f5);
        cape.render(f5);
        cape_1.render(f5);
        cape_5.render(f5);
        cape_4.render(f5);
        cape_2.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

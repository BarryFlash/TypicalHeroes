package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDoctorStrangeCapeHead extends ModelBiped
{
    public ModelRenderer capeh;
    public ModelRenderer capeh_1;
    public ModelRenderer capeh_2;
    public ModelRenderer capeh_3;
    public ModelRenderer capeh_4;
    public ModelRenderer capeh_5;
    public ModelRenderer capeh_6;
    public ModelRenderer capeh_7;

    public ModelDoctorStrangeCapeHead()
    {
        textureWidth = 128;
        textureHeight = 128;
        capeh_7 = new ModelRenderer(this, 0, 0);
        capeh_7.setRotationPoint(0.0F, 0.0F, 0.0F);
        capeh_7.addBox(-4.8F, -4.05F, 3.45F, 5, 2, 1, -0.15F);
        setRotateAngle(capeh_7, -0.1514945790731078F, 0.0F, 0.0F);
        capeh = new ModelRenderer(this, 0, 0);
        capeh.mirror = true;
        capeh.setRotationPoint(0.0F, 0.0F, 0.0F);
        capeh.addBox(1.55F, -6.1F, -3.1F, 2, 4, 8, -0.7F);
        setRotateAngle(capeh, 0.0F, 0.0F, 0.568802803224952F);
        capeh_4 = new ModelRenderer(this, 0, 0);
        capeh_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        capeh_4.addBox(-4.6F, -2.0F, -2.4F, 2, 2, 7, 0.0F);
        capeh_1 = new ModelRenderer(this, 0, 0);
        capeh_1.mirror = true;
        capeh_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        capeh_1.addBox(2.6F, -2.0F, -2.4F, 2, 2, 7, 0.0F);
        capeh_6 = new ModelRenderer(this, 0, 0);
        capeh_6.mirror = true;
        capeh_6.setRotationPoint(0.0F, 0.0F, 0.0F);
        capeh_6.addBox(-0.2F, -4.05F, 3.45F, 5, 2, 1, -0.15F);
        setRotateAngle(capeh_6, -0.1514945790731078F, 0.0F, 0.0F);
        capeh_2 = new ModelRenderer(this, 0, 4);
        capeh_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        capeh_2.addBox(-4.0F, -2.15F, 3.75F, 8, 2, 1, -0.15F);
        capeh_3 = new ModelRenderer(this, 0, 0);
        capeh_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        capeh_3.addBox(-4.05F, -0.95F, 1.55F, 8, 1, 3, 0.05F);
        capeh_5 = new ModelRenderer(this, 0, 0);
        capeh_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        capeh_5.addBox(-3.55F, -6.1F, -3.1F, 2, 3, 8, -0.7F);
        setRotateAngle(capeh_5, 0.0F, 0.0F, -0.568802803224952F);
        
        bipedHead.addChild(capeh);
        bipedHead.addChild(capeh_1);
        bipedHead.addChild(capeh_2);
        bipedHead.addChild(capeh_3);
        bipedHead.addChild(capeh_4);
        bipedHead.addChild(capeh_5);
        bipedHead.addChild(capeh_6);
        bipedHead.addChild(capeh_7);
       
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        capeh_7.render(f5);
        capeh.render(f5);
        capeh_4.render(f5);
        capeh_1.render(f5);
        capeh_6.render(f5);
        capeh_2.render(f5);
        capeh_3.render(f5);
        capeh_5.render(f5);
        
       
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
        
    }
}

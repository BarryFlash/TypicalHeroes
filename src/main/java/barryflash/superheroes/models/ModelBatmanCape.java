package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBatmanCape extends ModelBiped
{
    public ModelRenderer capeb;
    public ModelRenderer capeb_1;
    public ModelRenderer capeb_2;
    public ModelRenderer capeb_3;
    public ModelRenderer capeb_4;
    public ModelRenderer capeb_5;
    public ModelRenderer capeb_6;
    public ModelRenderer capeb_7;
    public ModelRenderer capeb_8;
    public ModelRenderer capeb_9;
    public ModelRenderer capeb_10;
    public ModelRenderer capeb_11;
    public ModelRenderer capeb_12;

    public ModelBatmanCape()
    {
        textureWidth = 64;
        textureHeight = 64;
        capeb_4 = new ModelRenderer(this, 0, 0);
        capeb_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        capeb_4.addBox(8.65F, 15.82F, 1.9F, 3, 2, 1, -0.35F);
        setRotateAngle(capeb_4, 0.0F, 0.0F, 0.47525315531805595F);
        capeb_11 = new ModelRenderer(this, 0, 0);
        capeb_11.mirror = true;
        capeb_11.setRotationPoint(0.0F, 0.0F, 0.0F);
        capeb_11.addBox(-11.5F, 16.5F, 1.9F, 3, 2, 1, -0.35F);
        setRotateAngle(capeb_11, 0.0F, 0.0F, -0.7632324818971202F);
        capeb_5 = new ModelRenderer(this, 0, 0);
        capeb_5.mirror = true;
        capeb_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        capeb_5.addBox(-11.65F, 15.82F, 1.9F, 3, 2, 1, -0.35F);
        setRotateAngle(capeb_5, 0.0F, 0.0F, -0.47525315531805595F);
        capeb_6 = new ModelRenderer(this, 0, 0);
        capeb_6.mirror = true;
        capeb_6.setRotationPoint(0.0F, 0.0F, 0.0F);
        capeb_6.addBox(-13.85F, 14.32F, 1.9F, 3, 2, 1, -0.35F);
        setRotateAngle(capeb_6, 0.0F, 0.0F, -0.7009242276009227F);
        capeb_2 = new ModelRenderer(this, 0, 0);
        capeb_2.mirror = true;
        capeb_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        capeb_2.addBox(-8.0F, 17.7F, 1.9F, 3, 2, 1, -0.35F);
        setRotateAngle(capeb_2, 0.0F, 0.0F, -0.47525315531805595F);
        capeb = new ModelRenderer(this, 11, 7);
        capeb.setRotationPoint(0.0F, 0.0F, 2.2F);
        capeb.addBox(-7.0F, -0.3F, -0.3F, 14, 20, 1, -0.3F);
        capeb_8 = new ModelRenderer(this, 0, 0);
        capeb_8.setRotationPoint(0.0F, 0.0F, 0.0F);
        capeb_8.addBox(8.5F, 16.5F, 1.9F, 3, 2, 1, -0.35F);
        setRotateAngle(capeb_8, 0.0F, 0.0F, 0.7632324818971202F);
        capeb_7 = new ModelRenderer(this, 0, 0);
        capeb_7.mirror = true;
        capeb_7.setRotationPoint(0.0F, 0.0F, 0.0F);
        capeb_7.addBox(-14.6F, 14.25F, 1.9F, 2, 2, 1, -0.35F);
        setRotateAngle(capeb_7, 0.0F, 0.0F, -0.4413937678293659F);
        capeb_3 = new ModelRenderer(this, 0, 0);
        capeb_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        capeb_3.addBox(5.0F, 17.7F, 1.9F, 3, 2, 1, -0.35F);
        setRotateAngle(capeb_3, 0.0F, 0.0F, 0.47525315531805595F);
        capeb_12 = new ModelRenderer(this, 0, 0);
        capeb_12.setRotationPoint(0.0F, 0.0F, 0.0F);
        capeb_12.addBox(11.5F, 14.15F, 1.9F, 3, 2, 1, -0.35F);
        setRotateAngle(capeb_12, 0.0F, 0.0F, 0.5216789134211052F);
        capeb_1 = new ModelRenderer(this, 0, 0);
        capeb_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        capeb_1.addBox(10.85F, 14.32F, 1.9F, 3, 2, 1, -0.35F);
        setRotateAngle(capeb_1, 0.0F, 0.0F, 0.7009242276009227F);
        capeb_9 = new ModelRenderer(this, 0, 0);
        capeb_9.mirror = true;
        capeb_9.setRotationPoint(0.0F, 0.0F, 0.0F);
        capeb_9.addBox(-14.5F, 14.15F, 1.9F, 3, 2, 1, -0.35F);
        setRotateAngle(capeb_9, 0.0F, 0.0F, -0.5216789134211052F);
        capeb_10 = new ModelRenderer(this, 0, 0);
        capeb_10.setRotationPoint(0.0F, 0.0F, 0.0F);
        capeb_10.addBox(12.6F, 14.25F, 1.9F, 2, 2, 1, -0.35F);
        setRotateAngle(capeb_10, 0.0F, 0.0F, 0.4413937678293659F);
        
        bipedBody.addChild(capeb);
        bipedBody.addChild(capeb_1);
        bipedBody.addChild(capeb_2);
        bipedBody.addChild(capeb_3);
        bipedBody.addChild(capeb_4);
        bipedBody.addChild(capeb_5);
        bipedBody.addChild(capeb_6);
        bipedBody.addChild(capeb_7);
        bipedBody.addChild(capeb_8);
        bipedBody.addChild(capeb_9);
        bipedBody.addChild(capeb_10);
        bipedBody.addChild(capeb_11);
        bipedBody.addChild(capeb_12);

    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        capeb_4.render(f5);
        capeb_11.render(f5);
        capeb_5.render(f5);
        capeb_6.render(f5);
        capeb_2.render(f5);
        capeb.render(f5);
        capeb_8.render(f5);
        capeb_7.render(f5);
        capeb_3.render(f5);
        capeb_12.render(f5);
        capeb_1.render(f5);
        capeb_9.render(f5);
        capeb_10.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

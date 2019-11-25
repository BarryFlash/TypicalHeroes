package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelQuiver extends ModelHero
{
    public ModelRenderer body1;
    public ModelRenderer body1_1;
    public ModelRenderer body1_2;
    public ModelRenderer body1_3;
    public ModelRenderer body1_4;
    public ModelRenderer body1_5;
    public ModelRenderer body1_6;
    public ModelRenderer body1_7;
    public ModelRenderer body1_8;
    public ModelRenderer body1_9;
    public ModelRenderer body1_10;
    public ModelRenderer body1_11;
    public ModelRenderer body1_12;
    public ModelRenderer body1_13;
    public ModelRenderer body1_14;
    public ModelRenderer body1_15;
    public ModelRenderer body1_16;

    public ModelQuiver(float scale) {
     	 super(scale);
        textureWidth = 64;
        textureHeight = 64;
        body1_14 = new ModelRenderer(this, 0, 44);
        body1_14.setRotationPoint(0.0F, 0.0F, 0.0F);
        body1_14.addBox(-2.1F, -4.4F, 5.3F, 1, 2, 1, -0.2F);
        setRotateAngle(body1_14, 0.0F, 0.7740535232594852F, 0.4553564018453205F);
        body1_16 = new ModelRenderer(this, 0, 44);
        body1_16.setRotationPoint(0.0F, 0.0F, 0.0F);
        body1_16.addBox(-1.4F, -4.5F, 5.4F, 1, 2, 1, -0.2F);
        setRotateAngle(body1_16, 0.0F, 0.7740535232594852F, 0.4553564018453205F);
        body1_6 = new ModelRenderer(this, 0, 44);
        body1_6.setRotationPoint(0.0F, 0.0F, 0.0F);
        body1_6.addBox(-1.3F, -4.5F, 4.6F, 1, 2, 1, -0.2F);
        setRotateAngle(body1_6, 0.0F, 0.7740535232594852F, 0.4553564018453205F);
        body1 = new ModelRenderer(this, 7, 41);
        body1.setRotationPoint(0.0F, 0.0F, 0.0F);
        body1.addBox(0.8F, 0.0F, 2.5F, 4, 8, 4, 0.0F);
        setRotateAngle(body1, 0.0F, 0.0F, 0.4553564018453205F);
        body1_5 = new ModelRenderer(this, 7, 37);
        body1_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        body1_5.addBox(0.8F, -1.0F, 5.5F, 4, 1, 1, 0.0F);
        setRotateAngle(body1_5, 0.0F, 0.0F, 0.4553564018453205F);
        body1_4 = new ModelRenderer(this, 7, 34);
        body1_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        body1_4.addBox(0.8F, -1.0F, 2.5F, 1, 1, 4, 0.0F);
        setRotateAngle(body1_4, 0.0F, 0.0F, 0.4553564018453205F);
        body1_9 = new ModelRenderer(this, 0, 23);
        body1_9.setRotationPoint(0.0F, 0.0F, 0.0F);
        body1_9.addBox(2.5F, -4.8F, 3.7F, 1, 6, 1, -0.2F);
        setRotateAngle(body1_9, 0.0F, 0.0F, 0.4553564018453205F);
        body1_11 = new ModelRenderer(this, 0, 23);
        body1_11.setRotationPoint(0.0F, 0.0F, 0.0F);
        body1_11.addBox(1.7F, -4.5F, 3.3F, 1, 5, 1, -0.2F);
        setRotateAngle(body1_11, 0.0F, 0.0F, 0.4553564018453205F);
        body1_2 = new ModelRenderer(this, 7, 38);
        body1_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        body1_2.addBox(0.8F, -1.0F, 2.5F, 4, 1, 1, 0.0F);
        setRotateAngle(body1_2, 0.0F, 0.0F, 0.4553564018453205F);
        body1_8 = new ModelRenderer(this, 0, 23);
        body1_8.setRotationPoint(0.0F, 0.0F, 0.0F);
        body1_8.addBox(1.7F, -4.5F, 4.3F, 1, 5, 1, -0.2F);
        setRotateAngle(body1_8, 0.0F, 0.0F, 0.4553564018453205F);
        body1_12 = new ModelRenderer(this, 0, 45);
        body1_12.setRotationPoint(0.0F, 0.0F, 0.0F);
        body1_12.addBox(-1.6F, -4.4F, 3.8F, 1, 2, 1, -0.2F);
        setRotateAngle(body1_12, 0.0F, 0.7740535232594852F, 0.4553564018453205F);
        body1_15 = new ModelRenderer(this, 0, 44);
        body1_15.setRotationPoint(0.0F, 0.0F, 0.0F);
        body1_15.addBox(-0.5F, -4.5F, 4.6F, 1, 2, 1, -0.2F);
        setRotateAngle(body1_15, 0.0F, 0.7740535232594852F, 0.4553564018453205F);
        body1_10 = new ModelRenderer(this, 0, 23);
        body1_10.setRotationPoint(0.0F, 0.0F, 0.0F);
        body1_10.addBox(3.0F, -4.8F, 3.2F, 1, 6, 1, -0.2F);
        setRotateAngle(body1_10, 0.0F, 0.0F, 0.4553564018453205F);
        body1_13 = new ModelRenderer(this, 0, 44);
        body1_13.setRotationPoint(0.0F, 0.0F, 0.0F);
        body1_13.addBox(-2.3F, -4.4F, 4.5F, 1, 2, 1, -0.2F);
        setRotateAngle(body1_13, 0.0F, 0.7740535232594852F, 0.4553564018453205F);
        body1_3 = new ModelRenderer(this, 7, 34);
        body1_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        body1_3.addBox(3.8F, -1.0F, 2.5F, 1, 1, 4, 0.0F);
        setRotateAngle(body1_3, 0.0F, 0.0F, 0.4553564018453205F);
        body1_7 = new ModelRenderer(this, 0, 23);
        body1_7.setRotationPoint(0.0F, 0.0F, 0.0F);
        body1_7.addBox(3.0F, -4.8F, 4.3F, 1, 6, 1, -0.2F);
        setRotateAngle(body1_7, 0.0F, 0.0F, 0.4553564018453205F);
        body1_1 = new ModelRenderer(this, 0, 23);
        body1_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        body1_1.addBox(2.4F, -4.5F, 4.7F, 1, 5, 1, -0.2F);
        setRotateAngle(body1_1, 0.0F, 0.0F, 0.4553564018453205F);
        
        bipedBody.addChild(body1);
        bipedBody.addChild(body1_1);
        bipedBody.addChild(body1_2);
        bipedBody.addChild(body1_3);
        bipedBody.addChild(body1_4);
        bipedBody.addChild(body1_5);
        bipedBody.addChild(body1_6);
        bipedBody.addChild(body1_7);
        bipedBody.addChild(body1_8);
        bipedBody.addChild(body1_9);
        bipedBody.addChild(body1_10);
        bipedBody.addChild(body1_11);
        bipedBody.addChild(body1_12);
        bipedBody.addChild(body1_13);
        bipedBody.addChild(body1_14);
        bipedBody.addChild(body1_15);
        bipedBody.addChild(body1_16);

        
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
    	super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

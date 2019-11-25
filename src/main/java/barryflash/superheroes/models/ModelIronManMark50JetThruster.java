package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelIronManMark50JetThruster extends ModelHero
{
    public ModelRenderer body;
    public ModelRenderer body_1;
    public ModelRenderer body_2;
    public ModelRenderer body_3;
    public ModelRenderer body_4;
    public ModelRenderer body_5;
    public ModelRenderer body_6;
    public ModelRenderer body_7;
    public ModelRenderer body_8;
    public ModelRenderer body_9;
    public ModelRenderer body_10;
    public ModelRenderer body_11;
    public ModelRenderer body_12;
    public ModelRenderer body_13;
    public ModelRenderer body_14;
    public ModelRenderer body_15;
    public ModelRenderer body_16;
    public ModelRenderer body_17;
    public ModelRenderer body_18;
    public ModelRenderer body_19;
    public ModelRenderer body_20;
    public ModelRenderer body_21;
    public ModelRenderer body_22;

    public ModelIronManMark50JetThruster(float scale) {
      	 super(scale);
        textureWidth = 128;
        textureHeight = 128;
        body_5 = new ModelRenderer(this, 90, 90);
        body_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_5.addBox(-4.0F, 22.6F, -4.0F, 8, 2, 8, 0.25F);
        body_7 = new ModelRenderer(this, 0, 0);
        body_7.mirror = true;
        body_7.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_7.addBox(4.1F, 22.0F, 4.2F, 0, 2, 0, 0.75F);
        body_11 = new ModelRenderer(this, 0, 0);
        body_11.mirror = true;
        body_11.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_11.addBox(4.1F, 22.0F, -4.2F, 0, 2, 0, 0.75F);
        body_15 = new ModelRenderer(this, 110, 110);
        body_15.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_15.addBox(-3.5F, 23.7F, 4.5F, 7, 0, 0, 0.25F);
        body = new ModelRenderer(this, 0, 0);
        body.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addBox(-4.0F, 16.0F, -2.0F, 8, 3, 4, 0.35F);
        body_10 = new ModelRenderer(this, 0, 0);
        body_10.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_10.addBox(-0.5F, 22.0F, 3.2F, 1, 2, 1, 0.75F);
        body_20 = new ModelRenderer(this, 110, 110);
        body_20.mirror = true;
        body_20.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_20.addBox(4.5F, 22.3F, -3.4F, 0, 0, 7, 0.25F);
        body_6 = new ModelRenderer(this, 104, 110);
        body_6.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_6.addBox(-3.0F, 23.3F, -3.0F, 6, 2, 6, -0.35F);
        body_21 = new ModelRenderer(this, 110, 110);
        body_21.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_21.addBox(-4.5F, 23.7F, -3.4F, 0, 0, 7, 0.25F);
        body_13 = new ModelRenderer(this, 0, 0);
        body_13.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_13.addBox(-4.1F, 22.0F, -0.5F, 0, 2, 1, 0.75F);
        body_2 = new ModelRenderer(this, 0, 0);
        body_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_2.addBox(-4.0F, 14.8F, 6.5F, 8, 3, 1, 0.35F);
        setRotateAngle(body_2, -0.555887366760194F, 0.0F, 0.0F);
        body_4 = new ModelRenderer(this, 0, 0);
        body_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_4.addBox(-4.0F, 22.0F, -4.0F, 8, 2, 8, 0.65F);
        body_9 = new ModelRenderer(this, 0, 0);
        body_9.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_9.addBox(-4.1F, 22.0F, 4.2F, 0, 2, 0, 0.75F);
        body_22 = new ModelRenderer(this, 110, 110);
        body_22.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_22.addBox(-4.5F, 22.3F, -3.4F, 0, 0, 7, 0.25F);
        body_3 = new ModelRenderer(this, 0, 0);
        body_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_3.addBox(-4.0F, 14.8F, -7.5F, 8, 3, 1, 0.35F);
        setRotateAngle(body_3, 0.555887366760194F, 0.0F, 0.0F);
        body_12 = new ModelRenderer(this, 0, 0);
        body_12.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_12.addBox(-4.1F, 22.0F, -4.2F, 0, 2, 0, 0.75F);
        body_19 = new ModelRenderer(this, 110, 110);
        body_19.mirror = true;
        body_19.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_19.addBox(4.5F, 23.7F, -3.4F, 0, 0, 7, 0.25F);
        body_16 = new ModelRenderer(this, 110, 110);
        body_16.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_16.addBox(-3.4F, 22.3F, 4.5F, 7, 0, 0, 0.25F);
        body_17 = new ModelRenderer(this, 110, 110);
        body_17.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_17.addBox(-3.4F, 22.3F, -4.5F, 7, 0, 0, 0.25F);
        body_18 = new ModelRenderer(this, 110, 110);
        body_18.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_18.addBox(-3.5F, 23.7F, -4.5F, 7, 0, 0, 0.25F);
        body_8 = new ModelRenderer(this, 0, 0);
        body_8.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_8.addBox(-0.5F, 22.0F, -4.2F, 1, 2, 1, 0.75F);
        body_14 = new ModelRenderer(this, 0, 0);
        body_14.mirror = true;
        body_14.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_14.addBox(4.1F, 22.0F, -0.5F, 0, 2, 1, 0.75F);
        body_1 = new ModelRenderer(this, 0, 0);
        body_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_1.addBox(-4.0F, 18.9F, -4.0F, 8, 3, 8, 0.35F);
        
        bipedBody.addChild(body);
        bipedBody.addChild(body_1);
        bipedBody.addChild(body_2);
        bipedBody.addChild(body_3);
        bipedBody.addChild(body_4);
        bipedBody.addChild(body_5);
        bipedBody.addChild(body_6);
        bipedBody.addChild(body_7);
        bipedBody.addChild(body_8);
        bipedBody.addChild(body_9);
        bipedBody.addChild(body_10);
        bipedBody.addChild(body_11);
        bipedBody.addChild(body_12);
        bipedBody.addChild(body_13);
        bipedBody.addChild(body_14);
        bipedBody.addChild(body_15);
        bipedBody.addChild(body_16);
        bipedBody.addChild(body_17);
        bipedBody.addChild(body_18);
        bipedBody.addChild(body_19);
        bipedBody.addChild(body_20);
        bipedBody.addChild(body_21);
        bipedBody.addChild(body_22);

       
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

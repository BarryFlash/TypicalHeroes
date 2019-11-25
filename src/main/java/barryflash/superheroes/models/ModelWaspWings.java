package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelWaspWings extends ModelHero
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

    public ModelWaspWings(float scale) {
      	 super(scale);
         textureWidth = 128;
         textureHeight = 128;
        body_18 = new ModelRenderer(this, 0, 100);
        body_18.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_18.addBox(2.6F, 1.4F, 2.62F, 2, 13, 0, 0.1F);
        setRotateAngle(body_18, 0.0F, 0.0F, 1.278279144160647F);
        body_13 = new ModelRenderer(this, 0, 100);
        body_13.mirror = true;
        body_13.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_13.addBox(-4.5F, 6.0F, 2.62F, 2, 6, 0, 0.1F);
        setRotateAngle(body_13, 0.0F, 0.0F, -1.8825121312010837F);
        body_7 = new ModelRenderer(this, 0, 100);
        body_7.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_7.addBox(2.7F, 1.1F, 2.62F, 2, 4, 0, 0.1F);
        setRotateAngle(body_7, 0.0F, 0.0F, 1.949881840328065F);
        body_9 = new ModelRenderer(this, 0, 100);
        body_9.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_9.addBox(7.4F, 6.7F, 2.62F, 1, 10, 0, 0.1F);
        setRotateAngle(body_9, 0.0F, 0.0F, 2.2228513353399784F);
        body_10 = new ModelRenderer(this, 0, 100);
        body_10.mirror = true;
        body_10.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_10.addBox(-2.7F, 0.4F, 2.62F, 2, 9, 0, 0.1F);
        setRotateAngle(body_10, 0.0F, 0.0F, -1.949881840328065F);
        body_12 = new ModelRenderer(this, 0, 100);
        body_12.mirror = true;
        body_12.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_12.addBox(-3.5F, 5.2F, 2.62F, 2, 10, 0, 0.1F);
        setRotateAngle(body_12, 0.0F, 0.0F, -1.8825121312010837F);
        body_8 = new ModelRenderer(this, 0, 100);
        body_8.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_8.addBox(1.5F, 6.4F, 2.62F, 1, 4, 0, 0.1F);
        setRotateAngle(body_8, 0.0F, 0.0F, 1.5535175672001529F);
        body_4 = new ModelRenderer(this, 0, 100);
        body_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_4.addBox(-0.19999999999999996F, 9.5F, 2.62F, 2, 9, 0, 0.1F);
        setRotateAngle(body_4, 0.0F, 0.0F, 1.8498744741887898F);
        body_11 = new ModelRenderer(this, 0, 100);
        body_11.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_11.addBox(1.5F, 5.2F, 2.62F, 2, 10, 0, 0.1F);
        setRotateAngle(body_11, 0.0F, 0.0F, 1.8825121312010837F);
        body_5 = new ModelRenderer(this, 0, 100);
        body_5.mirror = true;
        body_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_5.addBox(-4.7F, 1.1F, 2.62F, 2, 4, 0, 0.1F);
        setRotateAngle(body_5, 0.0F, 0.0F, -1.949881840328065F);
        body_21 = new ModelRenderer(this, 0, 100);
        body_21.mirror = true;
        body_21.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_21.addBox(-5.2F, 6.7F, 2.62F, 1, 2, 0, 0.1F);
        setRotateAngle(body_21, 0.0F, 0.0F, -1.278279144160647F);
        body_15 = new ModelRenderer(this, 0, 100);
        body_15.mirror = true;
        body_15.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_15.addBox(-3.1F, 3.1F, 2.62F, 2, 7, 0, 0.1F);
        setRotateAngle(body_15, 0.0F, 0.0F, -0.80337505469299F);
        body_1 = new ModelRenderer(this, 0, 100);
        body_1.mirror = true;
        body_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_1.addBox(-2.5F, 6.4F, 2.62F, 1, 4, 0, 0.1F);
        setRotateAngle(body_1, 0.0F, 0.0F, -1.5535175672001529F);
        body_16 = new ModelRenderer(this, 0, 100);
        body_16.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_16.addBox(4.2F, 6.7F, 2.62F, 1, 2, 0, 0.1F);
        setRotateAngle(body_16, 0.0F, 0.0F, 1.278279144160647F);
        body_20 = new ModelRenderer(this, 0, 100);
        body_20.mirror = true;
        body_20.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_20.addBox(-4.6F, 1.4F, 2.62F, 2, 13, 0, 0.1F);
        setRotateAngle(body_20, 0.0F, 0.0F, -1.278279144160647F);
        body_2 = new ModelRenderer(this, 0, 100);
        body_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_2.addBox(2.5F, 6.0F, 2.62F, 2, 6, 0, 0.1F);
        setRotateAngle(body_2, 0.0F, 0.0F, 1.8825121312010837F);
        body_17 = new ModelRenderer(this, 0, 100);
        body_17.mirror = true;
        body_17.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_17.addBox(-9.6F, 4.5F, 2.62F, 2, 8, 0, 0.1F);
        setRotateAngle(body_17, 0.0F, 0.0F, -1.64357655660306F);
        body_3 = new ModelRenderer(this, 0, 100);
        body_3.mirror = true;
        body_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_3.addBox(-1.8F, 9.5F, 2.62F, 2, 9, 0, 0.1F);
        setRotateAngle(body_3, 0.0F, 0.0F, -1.8498744741887898F);
        body_14 = new ModelRenderer(this, 0, 100);
        body_14.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_14.addBox(0.7000000000000002F, 0.4F, 2.62F, 2, 9, 0, 0.1F);
        setRotateAngle(body_14, 0.0F, 0.0F, 1.949881840328065F);
        body = new ModelRenderer(this, 0, 100);
        body.mirror = true;
        body.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addBox(-8.4F, 6.7F, 2.62F, 1, 10, 0, 0.1F);
        setRotateAngle(body, 0.0F, 0.0F, -2.2228513353399784F);
        body_6 = new ModelRenderer(this, 0, 100);
        body_6.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_6.addBox(7.6F, 4.5F, 2.62F, 2, 8, 0, 0.1F);
        setRotateAngle(body_6, 0.0F, 0.0F, 1.64357655660306F);
        body_19 = new ModelRenderer(this, 0, 100);
        body_19.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_19.addBox(1.1F, 3.1F, 2.62F, 2, 7, 0, 0.1F);
        setRotateAngle(body_19, 0.0F, 0.0F, 0.80337505469299F);
        
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

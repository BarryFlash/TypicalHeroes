package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelShazamGlow extends ModelHero
{
    public ModelRenderer body1;
    public ModelRenderer body1_1;
    public ModelRenderer body1_2;
    public ModelRenderer left_arm1;
    public ModelRenderer right_arm1;
    public ModelRenderer body1_3;

    public ModelShazamGlow(float scale) {
      	 super(scale);
        textureWidth = 64;
        textureHeight = 64;
        body1 = new ModelRenderer(this, 57, 36);
        body1.setRotationPoint(0.0F, 0.0F, 0.0F);
        body1.addBox(-1.0F, 3.7F, -2.3F, 2, 2, 1, -0.1F);
        body1_1 = new ModelRenderer(this, 54, 32);
        body1_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        body1_1.addBox(-2.0F, 0.1F, -2.3F, 4, 2, 1, -0.1F);
        left_arm1 = new ModelRenderer(this, 55, 32);
        left_arm1.mirror = true;
        left_arm1.setRotationPoint(0.0F, 0.0F, 0.0F);
        left_arm1.addBox(2.1F, 4.8F, -2.0F, 1, 3, 4, 0.2F);
        right_arm1 = new ModelRenderer(this, 55, 32);
        right_arm1.setRotationPoint(0.0F, 0.0F, 0.0F);
        right_arm1.addBox(-3.1F, 4.8F, -2.0F, 1, 3, 4, 0.2F);
        body1_3 = new ModelRenderer(this, 54, 34);
        body1_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        body1_3.addBox(7.05F, 7.25F, -2.5F, 1, 1, 4, -0.15F);
        setRotateAngle(body1_3, 0.0F, 0.0F, 0.7740535232594852F);
        body1_2 = new ModelRenderer(this, 57, 33);
        body1_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        body1_2.addBox(-1.4F, 1.9F, -2.3F, 3, 2, 1, -0.1F);
        
        bipedBody.addChild(body1);
        bipedBody.addChild(body1_1);
        bipedBody.addChild(body1_2);
        bipedBody.addChild(body1_3);
        bipedRightArm.addChild(right_arm1);
        bipedLeftArm.addChild(left_arm1);
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

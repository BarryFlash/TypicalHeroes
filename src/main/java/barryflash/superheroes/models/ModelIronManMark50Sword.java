package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelIronManMark50Sword extends ModelHero
{
    public ModelRenderer rightarm;
    public ModelRenderer rightarm_1;
    public ModelRenderer rightarm_2;
    public ModelRenderer rightarm_3;
    public ModelRenderer rightarm_4;
    public ModelRenderer rightarm_5;
    public ModelRenderer rightarm_6;
    public ModelRenderer rightarm_7;
    public ModelRenderer rightarm_8;
    public ModelRenderer rightarm_9;
    public ModelRenderer rightarm_10;
    public ModelRenderer rightarm_11;
    public ModelRenderer rightarm_12;

    public ModelIronManMark50Sword(float scale) {
     	 super(scale);
       textureWidth = 128;
       textureHeight = 128;
        rightarm_8 = new ModelRenderer(this, 0, 0);
        rightarm_8.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_8.addBox(-3.8F, 12.2F, -0.5F, 1, 2, 1, -0.3F);
        rightarm_12 = new ModelRenderer(this, 110, 110);
        rightarm_12.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_12.addBox(-3.8F, 11.8F, -6.0F, 1, 1, 1, -0.25F);
        setRotateAngle(rightarm_12, 0.40072759625789806F, 0.0F, 0.0F);
        rightarm_10 = new ModelRenderer(this, 110, 110);
        rightarm_10.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_10.addBox(-3.8F, 8.6F, -0.85F, 1, 5, 1, -0.25F);
        rightarm = new ModelRenderer(this, 0, 0);
        rightarm.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm.addBox(-3.8F, 8.6F, -1.0F, 1, 5, 2, -0.3F);
        rightarm_3 = new ModelRenderer(this, 90, 0);
        rightarm_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_3.addBox(-3.8F, 12.4F, 5.18F, 1, 1, 1, -0.2F);
        setRotateAngle(rightarm_3, -0.40072759625789806F, 0.0F, 0.0F);
        rightarm_5 = new ModelRenderer(this, 90, 0);
        rightarm_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_5.addBox(-3.8F, 11.8F, 5.18F, 1, 1, 1, -0.2F);
        setRotateAngle(rightarm_5, -0.40072759625789806F, 0.0F, 0.0F);
        rightarm_2 = new ModelRenderer(this, 90, 0);
        rightarm_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_2.addBox(-3.8F, 8.6F, -1.0F, 1, 5, 1, -0.2F);
        rightarm_6 = new ModelRenderer(this, 90, 0);
        rightarm_6.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_6.addBox(-3.8F, 11.8F, -6.15F, 1, 1, 1, -0.2F);
        setRotateAngle(rightarm_6, 0.40072759625789806F, 0.0F, 0.0F);
        rightarm_9 = new ModelRenderer(this, 110, 110);
        rightarm_9.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_9.addBox(-3.8F, 8.6F, -0.15F, 1, 5, 1, -0.25F);
        rightarm_4 = new ModelRenderer(this, 90, 0);
        rightarm_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_4.addBox(-3.8F, 12.4F, -6.15F, 1, 1, 1, -0.2F);
        setRotateAngle(rightarm_4, 0.40072759625789806F, 0.0F, 0.0F);
        rightarm_7 = new ModelRenderer(this, 90, 0);
        rightarm_7.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_7.addBox(-3.8F, 9.7F, 9.75F, 1, 1, 1, -0.25F);
        setRotateAngle(rightarm_7, -0.7853981633974483F, 0.0F, 0.0F);
        rightarm_1 = new ModelRenderer(this, 90, 0);
        rightarm_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_1.addBox(-3.8F, 8.6F, 0.0F, 1, 5, 1, -0.2F);
        rightarm_11 = new ModelRenderer(this, 110, 110);
        rightarm_11.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_11.addBox(-3.8F, 11.9F, 5.03F, 1, 1, 1, -0.25F);
        setRotateAngle(rightarm_11, -0.40072759625789806F, 0.0F, 0.0F);
        
        bipedRightArm.addChild(rightarm);
        bipedRightArm.addChild(rightarm_1);
        bipedRightArm.addChild(rightarm_2);
        bipedRightArm.addChild(rightarm_3);
        bipedRightArm.addChild(rightarm_4);
        bipedRightArm.addChild(rightarm_5);
        bipedRightArm.addChild(rightarm_6);
        bipedRightArm.addChild(rightarm_7);
        bipedRightArm.addChild(rightarm_8);
        bipedRightArm.addChild(rightarm_9);
        bipedRightArm.addChild(rightarm_10);
        bipedRightArm.addChild(rightarm_11);
        bipedRightArm.addChild(rightarm_12);
     
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

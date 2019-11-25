package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelIronManMark50KnockbackFists extends ModelHero
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
    public ModelRenderer rightarm_13;
    public ModelRenderer leftarm;
    public ModelRenderer leftarm_1;
    public ModelRenderer leftarm_2;
    public ModelRenderer leftarm_3;
    public ModelRenderer leftarm_4;
    public ModelRenderer leftarm_5;
    public ModelRenderer leftarm_6;
    public ModelRenderer leftarm_7;
    public ModelRenderer leftarm_8;
    public ModelRenderer leftarm_9;
    public ModelRenderer leftarm_10;
    public ModelRenderer leftarm_11;
    public ModelRenderer leftarm_12;
    public ModelRenderer leftarm_13;

    public ModelIronManMark50KnockbackFists(float scale) {
      	 super(scale);
        textureWidth = 128;
        textureHeight = 128;
        rightarm_4 = new ModelRenderer(this, 90, 90);
        rightarm_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_4.addBox(-3.0F, 7.3F, 0.0F, 4, 1, 0, 0.85F);
        leftarm_11 = new ModelRenderer(this, 110, 110);
        leftarm_11.mirror = true;
        leftarm_11.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftarm_11.addBox(1.7F, 9.9F, -0.5F, 2, 1, 1, 0.05F);
        leftarm_3 = new ModelRenderer(this, 110, 110);
        leftarm_3.mirror = true;
        leftarm_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftarm_3.addBox(-1.0F, 8.0F, -2.0F, 4, 0, 4, 0.55F);
        leftarm_10 = new ModelRenderer(this, 110, 110);
        leftarm_10.mirror = true;
        leftarm_10.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftarm_10.addBox(0.5F, 9.9F, 0.7F, 1, 1, 2, 0.05F);
        rightarm_9 = new ModelRenderer(this, 110, 110);
        rightarm_9.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_9.addBox(-3.0F, 8.0F, -2.0F, 4, 0, 4, 0.55F);
        leftarm = new ModelRenderer(this, 90, 90);
        leftarm.mirror = true;
        leftarm.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftarm.addBox(-1.0F, 3.0F, -2.0F, 4, 7, 4, 0.25F);
        rightarm_1 = new ModelRenderer(this, 90, 90);
        rightarm_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_1.addBox(-3.0F, 5.0F, -2.0F, 4, 5, 4, 0.45F);
        rightarm_12 = new ModelRenderer(this, 110, 110);
        rightarm_12.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_12.addBox(-3.7F, 9.9F, -0.5F, 2, 1, 1, 0.05F);
        rightarm_13 = new ModelRenderer(this, 110, 110);
        rightarm_13.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_13.addBox(-0.3F, 9.9F, -0.5F, 2, 1, 1, 0.05F);
        rightarm_3 = new ModelRenderer(this, 90, 90);
        rightarm_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_3.addBox(-1.0F, 7.3F, -2.0F, 0, 1, 4, 0.85F);
        rightarm_8 = new ModelRenderer(this, 110, 110);
        rightarm_8.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_8.addBox(0.5F, 7.3F, 0.0F, 0, 0, 0, 1.05F);
        rightarm_2 = new ModelRenderer(this, 90, 90);
        rightarm_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_2.addBox(-3.0F, 10.0F, -2.0F, 4, 0, 4, 0.85F);
        leftarm_6 = new ModelRenderer(this, 110, 110);
        leftarm_6.mirror = true;
        leftarm_6.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftarm_6.addBox(-0.5F, 7.3F, 0.0F, 0, 0, 0, 1.05F);
        leftarm_8 = new ModelRenderer(this, 90, 90);
        leftarm_8.mirror = true;
        leftarm_8.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftarm_8.addBox(1.0F, 7.3F, -2.0F, 0, 1, 4, 0.85F);
        leftarm_12 = new ModelRenderer(this, 110, 110);
        leftarm_12.mirror = true;
        leftarm_12.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftarm_12.addBox(-1.7F, 9.9F, -0.5F, 2, 1, 1, 0.05F);
        leftarm_1 = new ModelRenderer(this, 90, 90);
        leftarm_1.mirror = true;
        leftarm_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftarm_1.addBox(-1.0F, 5.0F, -2.0F, 4, 5, 4, 0.45F);
        leftarm_7 = new ModelRenderer(this, 90, 90);
        leftarm_7.mirror = true;
        leftarm_7.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftarm_7.addBox(-1.0F, 10.0F, -2.0F, 4, 0, 4, 0.85F);
        rightarm_7 = new ModelRenderer(this, 110, 110);
        rightarm_7.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_7.addBox(-2.5F, 7.3F, 0.0F, 0, 0, 0, 1.05F);
        leftarm_5 = new ModelRenderer(this, 110, 110);
        leftarm_5.mirror = true;
        leftarm_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftarm_5.addBox(1.0F, 7.3F, 1.4F, 0, 0, 0, 1.15F);
        leftarm_4 = new ModelRenderer(this, 110, 110);
        leftarm_4.mirror = true;
        leftarm_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftarm_4.addBox(2.5F, 7.3F, 0.0F, 0, 0, 0, 1.05F);
        leftarm_13 = new ModelRenderer(this, 110, 110);
        leftarm_13.mirror = true;
        leftarm_13.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftarm_13.addBox(0.5F, 9.9F, -2.7F, 1, 1, 2, 0.05F);
        rightarm_11 = new ModelRenderer(this, 110, 110);
        rightarm_11.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_11.addBox(-1.5F, 9.9F, -2.7F, 1, 1, 2, 0.05F);
        leftarm_9 = new ModelRenderer(this, 90, 90);
        leftarm_9.mirror = true;
        leftarm_9.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftarm_9.addBox(-1.0F, 7.3F, 0.0F, 4, 1, 0, 0.85F);
        rightarm = new ModelRenderer(this, 90, 90);
        rightarm.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm.addBox(-3.0F, 3.0F, -2.0F, 4, 7, 4, 0.25F);
        rightarm_10 = new ModelRenderer(this, 110, 110);
        rightarm_10.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_10.addBox(-1.5F, 9.9F, 0.7F, 1, 1, 2, 0.05F);
        leftarm_2 = new ModelRenderer(this, 110, 110);
        leftarm_2.mirror = true;
        leftarm_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftarm_2.addBox(1.0F, 7.3F, -1.4F, 0, 0, 0, 1.15F);
        rightarm_5 = new ModelRenderer(this, 110, 110);
        rightarm_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_5.addBox(-1.0F, 7.3F, -1.4F, 0, 0, 0, 1.15F);
        rightarm_6 = new ModelRenderer(this, 110, 110);
        rightarm_6.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_6.addBox(-1.0F, 7.3F, 1.4F, 0, 0, 0, 1.15F);
        
        bipedLeftArm.addChild(leftarm);
        bipedLeftArm.addChild(leftarm_1);
        bipedLeftArm.addChild(leftarm_2);
        bipedLeftArm.addChild(leftarm_3);
        bipedLeftArm.addChild(leftarm_4);
        bipedLeftArm.addChild(leftarm_5);
        bipedLeftArm.addChild(leftarm_6);
        bipedLeftArm.addChild(leftarm_7);
        bipedLeftArm.addChild(leftarm_8);
        bipedLeftArm.addChild(leftarm_9);
        bipedLeftArm.addChild(leftarm_10);
        bipedLeftArm.addChild(leftarm_11);
        bipedLeftArm.addChild(leftarm_12);
        bipedLeftArm.addChild(leftarm_13);
 
       
     
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
        bipedRightArm.addChild(rightarm_13);
  
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

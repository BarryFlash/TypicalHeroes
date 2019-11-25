package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelThanosGauntlet extends ModelHero
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
    public ModelRenderer rightarm_14;
    public ModelRenderer rightarm_15;
    public ModelRenderer rightarm_16;

    public ModelThanosGauntlet(float scale) {
   	 super(scale);
     textureWidth = 128;
     textureHeight = 128;
        rightarm_4 = new ModelRenderer(this, 100, 0);
        rightarm_4.mirror = true;
        rightarm_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_4.addBox(-3.0F, 2.3F, -3.0F, 4, 3, 1, 0.3F);
        setRotateAngle(rightarm_4, 0.1759291886010284F, 0.0F, 0.0F);
        rightarm_10 = new ModelRenderer(this, 80, 30);
        rightarm_10.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_10.addBox(-3.5F, 9.1F, 0.1F, 1, 1, 1, 0.0F);
        rightarm_14 = new ModelRenderer(this, 100, 0);
        rightarm_14.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_14.addBox(-2.8F, 9.3F, -2.4F, 4, 1, 1, 0.2F);
        rightarm_13 = new ModelRenderer(this, 100, 0);
        rightarm_13.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_13.addBox(-2.8F, 9.3F, 1.4F, 4, 1, 1, 0.2F);
        rightarm_2 = new ModelRenderer(this, 100, 0);
        rightarm_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_2.addBox(-4.0F, 2.1F, -2.0F, 1, 3, 4, 0.3F);
        setRotateAngle(rightarm_2, 0.0F, 0.0F, -0.1759291886010284F);
        rightarm_9 = new ModelRenderer(this, 80, 30);
        rightarm_9.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_9.addBox(-3.5F, 9.1F, -1.1F, 1, 1, 1, 0.0F);
        rightarm_8 = new ModelRenderer(this, 80, 30);
        rightarm_8.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_8.addBox(-3.5F, 9.1F, -2.3F, 1, 1, 1, 0.0F);
        rightarm_5 = new ModelRenderer(this, 75, 23);
        rightarm_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_5.addBox(-3.5F, 2.15F, -2.5F, 5, 0, 5, 0.4F);
        rightarm_15 = new ModelRenderer(this, 100, 0);
        rightarm_15.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_15.addBox(-2.8F, 9.3F, -1.1F, 4, 1, 1, 0.2F);
        rightarm_6 = new ModelRenderer(this, 80, 30);
        rightarm_6.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_6.addBox(-3.1F, 6.7F, -0.6F, 1, 1, 1, 0.4F);
        rightarm_12 = new ModelRenderer(this, 80, 30);
        rightarm_12.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_12.addBox(-1.2F, 6.4F, -3.3F, 1, 1, 1, 0.0F);
        setRotateAngle(rightarm_12, 0.0F, 0.3672172746196069F, 0.0F);
        rightarm = new ModelRenderer(this, 100, 0);
        rightarm.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm.addBox(-3.0F, 6.0F, -2.0F, 4, 4, 4, 0.4F);
        rightarm_7 = new ModelRenderer(this, 80, 30);
        rightarm_7.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_7.addBox(-3.5F, 9.1F, 1.3F, 1, 1, 1, 0.0F);
        rightarm_11 = new ModelRenderer(this, 100, 8);
        rightarm_11.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_11.addBox(-1.2F, 6.1F, -2.8F, 1, 2, 1, 0.4F);
        setRotateAngle(rightarm_11, 0.0F, 0.3672172746196069F, 0.0F);
        rightarm_1 = new ModelRenderer(this, 100, 0);
        rightarm_1.mirror = true;
        rightarm_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_1.addBox(1.0F, 2.4F, -2.0F, 1, 3, 4, 0.3F);
        setRotateAngle(rightarm_1, 0.0F, 0.0F, 0.1759291886010284F);
        rightarm_3 = new ModelRenderer(this, 100, 0);
        rightarm_3.mirror = true;
        rightarm_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_3.addBox(-3.0F, 2.3F, 2.0F, 4, 3, 1, 0.3F);
        setRotateAngle(rightarm_3, -0.1759291886010284F, 0.0F, 0.0F);
        rightarm_16 = new ModelRenderer(this, 100, 0);
        rightarm_16.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_16.addBox(-2.8F, 9.3F, 0.2F, 4, 1, 1, 0.2F);
        
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
        bipedRightArm.addChild(rightarm_14);
        bipedRightArm.addChild(rightarm_15);
        bipedRightArm.addChild(rightarm_16);
   
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

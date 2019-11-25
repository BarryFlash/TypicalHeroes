package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCyborgSonarCannonGlow extends ModelHero
{
    public ModelRenderer rightarm;
    public ModelRenderer rightarm_1;
    public ModelRenderer rightarm_2;
    public ModelRenderer rightarm_3;
    public ModelRenderer rightarm_4;
    public ModelRenderer rightarm_5;
    public ModelRenderer rightarm_6;
    public ModelRenderer rightarm_7;

    public ModelCyborgSonarCannonGlow(float scale) {
    	 super(scale);
        textureWidth = 128;
        textureHeight = 128;
        rightarm_7 = new ModelRenderer(this, 49, 52);
        rightarm_7.mirror = true;
        rightarm_7.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_7.addBox(-2.5F, 15.2F, -1.5F, 3, 1, 3, -0.3F);
        rightarm_1 = new ModelRenderer(this, 49, 52);
        rightarm_1.mirror = true;
        rightarm_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_1.addBox(-2.5F, 14.0F, -1.5F, 3, 1, 3, -0.3F);
        rightarm_3 = new ModelRenderer(this, 49, 52);
        rightarm_3.mirror = true;
        rightarm_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_3.addBox(-2.5F, 12.8F, -1.5F, 3, 1, 3, -0.3F);
        rightarm_4 = new ModelRenderer(this, 49, 52);
        rightarm_4.mirror = true;
        rightarm_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_4.addBox(-2.5F, 12.2F, -1.5F, 3, 1, 3, -0.3F);
        rightarm_6 = new ModelRenderer(this, 49, 52);
        rightarm_6.mirror = true;
        rightarm_6.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_6.addBox(-2.5F, 14.6F, -1.5F, 3, 1, 3, -0.3F);
        rightarm_2 = new ModelRenderer(this, 49, 52);
        rightarm_2.mirror = true;
        rightarm_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_2.addBox(-2.5F, 13.4F, -1.5F, 3, 1, 3, -0.3F);
        rightarm = new ModelRenderer(this, 49, 52);
        rightarm.mirror = true;
        rightarm.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm.addBox(-2.5F, 11.0F, -1.5F, 3, 1, 3, -0.3F);
        rightarm_5 = new ModelRenderer(this, 49, 52);
        rightarm_5.mirror = true;
        rightarm_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_5.addBox(-2.5F, 11.6F, -1.5F, 3, 1, 3, -0.3F);
        
        bipedRightArm.addChild(rightarm);
        bipedRightArm.addChild(rightarm_1);
        bipedRightArm.addChild(rightarm_2);
        bipedRightArm.addChild(rightarm_3);
        bipedRightArm.addChild(rightarm_4);
        bipedRightArm.addChild(rightarm_5);
        bipedRightArm.addChild(rightarm_6);
        bipedRightArm.addChild(rightarm_7);
   
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

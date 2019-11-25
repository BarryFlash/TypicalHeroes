package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelIronManMark50MissileLauncher extends ModelHero
{
    public ModelRenderer rightarm;
    public ModelRenderer leftarm;
    public ModelRenderer rightarm_1;
    public ModelRenderer rightarm_2;
    public ModelRenderer leftarm_1;
    public ModelRenderer rightarm_3;
    public ModelRenderer leftarm_2;
    public ModelRenderer leftarm_3;
    public ModelRenderer rightarm_4;
    public ModelRenderer rightarm_5;
    public ModelRenderer leftarm_4;
    public ModelRenderer leftarm_5;

    public ModelIronManMark50MissileLauncher(float scale) {
     	 super(scale);
       textureWidth = 128;
       textureHeight = 128;
        leftarm = new ModelRenderer(this, 0, 100);
        leftarm.mirror = true;
        leftarm.setRotationPoint(0.0F,0.0F, 0.0F);
        leftarm.addBox(-0.9F, -4.0F, -1.7F, 3, 3, 1, -0.3F);
        rightarm = new ModelRenderer(this, 0, 0);
        rightarm.setRotationPoint(0.0F,0.0F, 0.0F);
        rightarm.addBox(-2.1F, -2.8F, -3.8F, 3, 1, 4, -0.1F);
        setRotateAngle(rightarm, -0.6972590361717347F, 0.0F, 0.0F);
        leftarm_2 = new ModelRenderer(this, 0, 100);
        leftarm_2.mirror = true;
        leftarm_2.setRotationPoint(0.0F,0.0F, 0.0F);
        leftarm_2.addBox(-0.9F, -3.3F, -1.2F, 3, 2, 2, -0.3F);
        leftarm_1 = new ModelRenderer(this, 0, 0);
        leftarm_1.mirror = true;
        leftarm_1.setRotationPoint(0.0F,0.0F, 0.0F);
        leftarm_1.addBox(-0.9F, -2.8F, -3.8F, 3, 1, 4, -0.1F);
        setRotateAngle(leftarm_1, -0.6972590361717347F, 0.0F, 0.0F);
        rightarm_2 = new ModelRenderer(this, 0, 100);
        rightarm_2.setRotationPoint(0.0F,0.0F, 0.0F);
        rightarm_2.addBox(-2.1F, -3.3F, -1.2F, 3, 2, 2, -0.3F);
        rightarm_3 = new ModelRenderer(this, 0, 100);
        rightarm_3.setRotationPoint(0.0F,0.0F, 0.0F);
        rightarm_3.addBox(-2.1F, -4.0F, -1.7F, 3, 3, 1, -0.3F);
        rightarm_4 = new ModelRenderer(this, 90, 90);
        rightarm_4.setRotationPoint(0.0F,0.0F, 0.0F);
        rightarm_4.addBox(-1.7F, -3.5F, -1.6F, 1, 1, 1, -0.1F);
        rightarm_1 = new ModelRenderer(this, 0, 100);
        rightarm_1.setRotationPoint(0.0F,0.0F, 0.0F);
        rightarm_1.addBox(-2.1F, -3.6F, -1.3F, 3, 2, 1, -0.3F);
        leftarm_4 = new ModelRenderer(this, 90, 90);
        leftarm_4.mirror = true;
        leftarm_4.setRotationPoint(0.0F,0.0F, 0.0F);
        leftarm_4.addBox(-0.4F, -3.5F, -1.6F, 1, 1, 1, -0.1F);
        leftarm_3 = new ModelRenderer(this, 0, 100);
        leftarm_3.mirror = true;
        leftarm_3.setRotationPoint(0.0F,0.0F, 0.0F);
        leftarm_3.addBox(-0.9F, -3.6F, -1.3F, 3, 2, 1, -0.3F);
        leftarm_5 = new ModelRenderer(this, 90, 90);
        leftarm_5.mirror = true;
        leftarm_5.setRotationPoint(0.0F,0.0F, 0.0F);
        leftarm_5.addBox(0.7F, -3.5F, -1.6F, 1, 1, 1, -0.1F);
        rightarm_5 = new ModelRenderer(this, 90, 90);
        rightarm_5.setRotationPoint(0.0F,0.0F, 0.0F);
        rightarm_5.addBox(-0.6F, -3.5F, -1.6F, 1, 1, 1, -0.1F);
        
        bipedLeftArm.addChild(leftarm);
        bipedLeftArm.addChild(leftarm_1);
        bipedLeftArm.addChild(leftarm_2);
        bipedLeftArm.addChild(leftarm_3);
        bipedLeftArm.addChild(leftarm_4);
        bipedLeftArm.addChild(leftarm_5);
    
 
       
     
        bipedRightArm.addChild(rightarm);
        bipedRightArm.addChild(rightarm_1);
        bipedRightArm.addChild(rightarm_2);
        bipedRightArm.addChild(rightarm_3);
        bipedRightArm.addChild(rightarm_4);
        bipedRightArm.addChild(rightarm_5);
    
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

package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTest extends ModelBiped
{
    public ModelRenderer bipedRightArm;
    public ModelRenderer bipedLeftLeg;
    public ModelRenderer bipedHead;
    public ModelRenderer bipedBody;
    public ModelRenderer bipedLeftArm;
    public ModelRenderer bipedRightLeg;
    public ModelRenderer bipedRightArm_1;

    public ModelTest(float scale) {
    	 super(scale, 0, 128, 128);
    	 
    	 	textureWidth = 128;
    	 	textureHeight = 128;
        bipedBody = new ModelRenderer(this, 16, 16);
        bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
        bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        bipedLeftArm = new ModelRenderer(this, 40, 16);
        bipedLeftArm.mirror = true;
        bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
        bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        bipedRightLeg = new ModelRenderer(this, 0, 16);
        bipedRightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
        bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.1F);
        bipedRightArm = new ModelRenderer(this, 40, 16);
        bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        bipedRightArm_1 = new ModelRenderer(this, 40, 16);
        bipedRightArm_1.setRotationPoint(-5.0F, 2.0F, 0.0F);
        bipedRightArm_1.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.1F);
        bipedLeftLeg = new ModelRenderer(this, 0, 16);
        bipedLeftLeg.mirror = true;
        bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
        bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        bipedHead = new ModelRenderer(this, 0, 0);
        bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        
        bipedRightArm.addChild(bipedRightArm);
        bipedRightArm.addChild(bipedRightArm_1);
        bipedLeftArm.addChild(bipedLeftArm);
        bipedRightLeg.addChild(bipedRightLeg);
        bipedLeftLeg.addChild(bipedLeftLeg);
        bipedHead.addChild(bipedHead);
        bipedBody.addChild(bipedBody);
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

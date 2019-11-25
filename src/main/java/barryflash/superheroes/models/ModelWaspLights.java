package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWaspLights extends ModelHero
{
    public ModelRenderer body;
    public ModelRenderer body_1;
    public ModelRenderer leftarm;
    public ModelRenderer leftarm_1;
    public ModelRenderer leftarm_2;
    public ModelRenderer rightarm;
    public ModelRenderer rightarm_1;
    public ModelRenderer rightarm_2;
    public ModelRenderer body_2;
    public ModelRenderer body_3;
    public ModelRenderer body_4;
    public ModelRenderer head;

    public ModelWaspLights(float scale) {
      	 super(scale);
         textureWidth = 128;
         textureHeight = 128;
        rightarm_2 = new ModelRenderer(this, 80, 50);
        rightarm_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_2.addBox(-3.1F, 6.8F, 1.75F, 1, 2, 1, -0.4F);
        leftarm_1 = new ModelRenderer(this, 80, 50);
        leftarm_1.mirror = true;
        leftarm_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftarm_1.addBox(2.8F, 6.5F, -0.5F, 1, 2, 1, -0.35F);
        body_2 = new ModelRenderer(this, 80, 50);
        body_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_2.addBox(-0.5F, 0.3F, 2.3F, 1, 3, 1, -0.2F);
        leftarm = new ModelRenderer(this, 80, 50);
        leftarm.mirror = true;
        leftarm.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftarm.addBox(2.1F, 6.8F, -2.75F, 1, 2, 1, -0.4F);
        body = new ModelRenderer(this, 80, 50);
        body.mirror = true;
        body.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addBox(-12.7F, 1.3F, -2.6F, 2, 1, 1, -0.38F);
        setRotateAngle(body, 0.0F, 0.0F, -1.5357152088298105F);
        rightarm_1 = new ModelRenderer(this, 80, 50);
        rightarm_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_1.addBox(-3.1F, 6.8F, -2.75F, 1, 2, 1, -0.4F);
        body_3 = new ModelRenderer(this, 80, 50);
        body_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_3.addBox(-4.7F, 2.4F, 1.9F, 1, 2, 1, -0.3F);
        setRotateAngle(body_3, 0.0F, 0.0F, -0.40142572795869574F);
        body_4 = new ModelRenderer(this, 80, 50);
        body_4.mirror = true;
        body_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_4.addBox(3.7F, 2.4F, 1.9F, 1, 2, 1, -0.3F);
        setRotateAngle(body_4, 0.0F, 0.0F, 0.40142572795869574F);
        body_1 = new ModelRenderer(this, 80, 50);
        body_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_1.addBox(10.7F, 1.3F, -2.6F, 2, 1, 1, -0.38F);
        setRotateAngle(body_1, 0.0F, 0.0F, 1.5357152088298105F);
        rightarm = new ModelRenderer(this, 80, 50);
        rightarm.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm.addBox(-3.8F, 6.5F, -0.5F, 1, 2, 1, -0.35F);
        head = new ModelRenderer(this, 80, 50);
        head.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addBox(-0.5F, -3.7F, 3.2F, 1, 2, 1, -0.2F);
        setRotateAngle(head, -0.21345376751890652F, 0.0F, 0.0F);
        leftarm_2 = new ModelRenderer(this, 80, 50);
        leftarm_2.mirror = true;
        leftarm_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftarm_2.addBox(2.1F, 6.8F, 1.75F, 1, 2, 1, -0.4F);
        
        bipedHead.addChild(head);
      
   
     

        
        bipedBody.addChild(body);
        bipedBody.addChild(body_1);
        bipedBody.addChild(body_2);
        bipedBody.addChild(body_3);
        bipedBody.addChild(body_4);
      
      
      

        bipedLeftArm.addChild(leftarm);
        bipedLeftArm.addChild(leftarm_1);
        bipedLeftArm.addChild(leftarm_2);
       
       
        bipedRightArm.addChild(rightarm);
        bipedRightArm.addChild(rightarm_1);
        bipedRightArm.addChild(rightarm_2);
      
      
      
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

package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAntmanLights extends ModelHero
{
    public ModelRenderer body;
    public ModelRenderer leftarm;
    public ModelRenderer rightarm;
    public ModelRenderer body_1;
    public ModelRenderer head;
    public ModelRenderer body_2;
    public ModelRenderer body_3;

    public ModelAntmanLights(float scale) {
   	 super(scale);
	 
	 	textureWidth = 128;
	 	textureHeight = 128;
        leftarm = new ModelRenderer(this, 80, 0);
        leftarm.mirror = true;
        leftarm.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftarm.addBox(2.5F, 7.4F, -2.0F, 1, 1, 4, -0.1F);
        body_3 = new ModelRenderer(this, 80, 0);
        body_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_3.addBox(-3.7F, 10.5F, -2.7F, 1, 2, 1, -0.25F);
        head = new ModelRenderer(this, 80, 0);
        head.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addBox(-0.5F, -3.5F, 3.5F, 1, 3, 1, -0.15F);
        body_2 = new ModelRenderer(this, 80, 0);
        body_2.mirror = true;
        body_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_2.addBox(2.7F, 10.5F, -2.7F, 1, 2, 1, -0.25F);
        rightarm = new ModelRenderer(this, 80, 0);
        rightarm.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm.addBox(-3.5F, 7.4F, -2.0F, 1, 1, 4, -0.1F);
        body_1 = new ModelRenderer(this, 80, 4);
        body_1.mirror = true;
        body_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_1.addBox(-1.0F, 1.35F, 1.2F, 2, 3, 2, -0.6F);
        body = new ModelRenderer(this, 80, 0);
        body.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addBox(-0.5F, 11.0F, -2.4F, 1, 1, 1, 0.05F);
        
        bipedHead.addChild(head);
       
     

        
        bipedBody.addChild(body);
        bipedBody.addChild(body_1);
        bipedBody.addChild(body_2);
        bipedBody.addChild(body_3);
        
      
      

        bipedLeftArm.addChild(leftarm);
      
       
       
     
        bipedRightArm.addChild(rightarm);
       
       
     
        
        
       
       
    
    
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

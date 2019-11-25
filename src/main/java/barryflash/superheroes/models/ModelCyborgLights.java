package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCyborgLights extends ModelHero
{
    public ModelRenderer head;
    public ModelRenderer head_1;
    public ModelRenderer body;
    public ModelRenderer body_1;
    public ModelRenderer body_2;
    public ModelRenderer body_3;
    public ModelRenderer body_4;
    public ModelRenderer body_5;
    public ModelRenderer body_6;
    public ModelRenderer leftleg;
    public ModelRenderer rightleg;

    public ModelCyborgLights(float scale) {
     	 super(scale);
        textureWidth = 128;
        textureHeight = 128;
        body = new ModelRenderer(this, 51, 40);
        body.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addBox(-0.5F, 1.7F, -2.5F, 1, 3, 1, -0.2F);
        body_3 = new ModelRenderer(this, 52, 43);
        body_3.mirror = true;
        body_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_3.addBox(-3.3F, 5.8F, -2.57F, 1, 1, 1, -0.4F);
        body_5 = new ModelRenderer(this, 52, 43);
        body_5.mirror = true;
        body_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_5.addBox(-2.6F, 4.6F, -2.57F, 1, 1, 1, -0.4F);
        body_1 = new ModelRenderer(this, 52, 43);
        body_1.mirror = true;
        body_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_1.addBox(-3.2F, 6.7F, -2.57F, 1, 1, 1, -0.4F);
        body_4 = new ModelRenderer(this, 52, 43);
        body_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_4.addBox(2.3F, 5.8F, -2.57F, 1, 1, 1, -0.4F);
        body_6 = new ModelRenderer(this, 52, 43);
        body_6.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_6.addBox(1.6F, 4.6F, -2.57F, 1, 1, 1, -0.4F);
        leftleg = new ModelRenderer(this, 52, 43);
        leftleg.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftleg.addBox(0.3F, 1.4F, -2.47F, 2, 1, 1, -0.3F);
        rightleg = new ModelRenderer(this, 52, 43);
        rightleg.mirror = true;
        rightleg.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightleg.addBox(-2.3F, 1.4F, -2.47F, 2, 1, 1, -0.3F);
        head = new ModelRenderer(this, 50, 35);
        head.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addBox(1.0F, -4.0F, -4.05F, 2, 1, 1, 0.0F);
        body_2 = new ModelRenderer(this, 52, 43);
        body_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_2.addBox(2.2F, 6.7F, -2.57F, 1, 1, 1, -0.4F);
        head_1 = new ModelRenderer(this, 50, 51);
        head_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        head_1.addBox(-0.6F, -6.4F, -4.35F, 1, 1, 1, -0.2F);
        
        bipedHead.addChild(head);
        bipedHead.addChild(head_1);

        
        bipedBody.addChild(body);
        bipedBody.addChild(body_1);
        bipedBody.addChild(body_2);
        bipedBody.addChild(body_3);
        bipedBody.addChild(body_4);
        bipedBody.addChild(body_5);
        bipedBody.addChild(body_6);

       
        bipedLeftLeg.addChild(leftleg);
        
        bipedRightLeg.addChild(rightleg);
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

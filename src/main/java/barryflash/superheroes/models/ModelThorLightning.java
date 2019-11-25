package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelThorLightning extends ModelHero
{
    public ModelRenderer body;
    public ModelRenderer body_1;
    public ModelRenderer body_2;
    public ModelRenderer body_3;
    public ModelRenderer body_4;
    public ModelRenderer body_5;
    public ModelRenderer head;
    public ModelRenderer head_1;

    public ModelThorLightning(float scale) {
   	 super(scale);
     textureWidth = 64;
     textureHeight = 64;
        body_1 = new ModelRenderer(this, 30, 29);
        body_1.mirror = true;
        body_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_1.addBox(2.1F, 1.8F, -2.35F, 2, 2, 1, 0.25F);
        body_3 = new ModelRenderer(this, 30, 29);
        body_3.mirror = true;
        body_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_3.addBox(1.5F, 5.8F, -2.3F, 2, 2, 1, 0.05F);
        body_5 = new ModelRenderer(this, 30, 29);
        body_5.mirror = true;
        body_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_5.addBox(1.2F, 9.2F, -2.6F, 2, 2, 1, -0.15F);
        head = new ModelRenderer(this, 30, 30);
        head.mirror = true;
        head.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addBox(1.0F, -4.0F, -4.05F, 2, 1, 1, 0.0F);
        head_1 = new ModelRenderer(this, 30, 30);
        head_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        head_1.addBox(-3.0F, -4.0F, -4.05F, 2, 1, 1, 0.0F);
        body = new ModelRenderer(this, 30, 29);
        body.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addBox(-4.1F, 1.8F, -2.35F, 2, 2, 1, 0.25F);
        body_2 = new ModelRenderer(this, 30, 29);
        body_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_2.addBox(-3.5F, 5.8F, -2.3F, 2, 2, 1, 0.05F);
        body_4 = new ModelRenderer(this, 30, 29);
        body_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_4.addBox(-3.2F, 9.2F, -2.6F, 2, 2, 1, -0.15F);
        
        bipedBody.addChild(body);
        bipedBody.addChild(body_1);
        bipedBody.addChild(body_2);
        bipedBody.addChild(body_3);
        bipedBody.addChild(body_4);
        bipedBody.addChild(body_5);
        
        bipedHead.addChild(head);
        bipedHead.addChild(head_1);
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

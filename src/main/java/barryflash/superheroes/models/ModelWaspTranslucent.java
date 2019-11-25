package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelWaspTranslucent extends ModelHero
{
    public ModelRenderer body;
    public ModelRenderer body_1;
    public ModelRenderer body_2;
    public ModelRenderer body_3;
    public ModelRenderer body_4;
    public ModelRenderer body_5;
    public ModelRenderer head;

    public ModelWaspTranslucent(float scale) {
      	 super(scale);
         textureWidth = 128;
         textureHeight = 128;
        body = new ModelRenderer(this, 0, 100);
        body.mirror = true;
        body.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addBox(-0.5F, 0.7F, 2.62F, 2, 3, 0, 0.1F);
        setRotateAngle(body, 0.0F, 0.0F, -0.33283428835531864F);
        head = new ModelRenderer(this, 0, 50);
        head.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addBox(-3.5F, -6.4F, -4.05F, 7, 4, 1, 0.0F);
        body_4 = new ModelRenderer(this, 0, 100);
        body_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_4.addBox(-1.7F, 1.7F, 2.8F, 1, 8, 0, 0.1F);
        setRotateAngle(body_4, 0.0F, 0.0F, -0.11100294042683936F);
        body_1 = new ModelRenderer(this, 0, 100);
        body_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_1.addBox(-1.5F, 0.7F, 2.62F, 2, 3, 0, 0.1F);
        setRotateAngle(body_1, 0.0F, 0.0F, 0.33283428835531864F);
        body_5 = new ModelRenderer(this, 0, 100);
        body_5.mirror = true;
        body_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_5.addBox(0.7F, 1.7F, 2.8F, 1, 8, 0, 0.1F);
        setRotateAngle(body_5, 0.0F, 0.0F, 0.11100294042683936F);
        body_3 = new ModelRenderer(this, 0, 100);
        body_3.mirror = true;
        body_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_3.addBox(2.4F, 2.2F, 2.6F, 1, 8, 0, 0.1F);
        setRotateAngle(body_3, 0.0F, 0.0F, 0.31066860685499065F);
        body_2 = new ModelRenderer(this, 0, 100);
        body_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_2.addBox(-3.4F, 2.2F, 2.6F, 1, 8, 0, 0.1F);
        setRotateAngle(body_2, 0.0F, 0.0F, -0.31066860685499065F);
        
        bipedHead.addChild(head);
       
     

        
        bipedBody.addChild(body);
        bipedBody.addChild(body_1);
        bipedBody.addChild(body_2);
        bipedBody.addChild(body_3);
        bipedBody.addChild(body_4);
        bipedBody.addChild(body_5);
    

   
       
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

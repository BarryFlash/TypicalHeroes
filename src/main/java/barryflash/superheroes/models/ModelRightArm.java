package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRightArm extends ModelHero
{
    public ModelRenderer field_78112_f;

    public ModelRightArm(float scale) {
      	 super(scale);
    	 
 	 	textureWidth = 64;
 	 	textureHeight = 64;
        field_78112_f = new ModelRenderer(this, 40, 16);
        field_78112_f.setRotationPoint(-5.0F, 2.0F, 0.0F);
        field_78112_f.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        
        bipedRightArm.addChild(field_78112_f);
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

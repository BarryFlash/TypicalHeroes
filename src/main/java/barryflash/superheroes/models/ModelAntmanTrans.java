package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelAntmanTrans extends ModelHero
{
    public ModelRenderer head;

    public ModelAntmanTrans(float scale) {
   	 super(scale);
	 
	 	textureWidth = 128;
	 	textureHeight = 128;
        head = new ModelRenderer(this, 80, 0);
        head.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addBox(-3.5F, -6.3F, -4.33F, 7, 4, 1, -0.3F);
        
        bipedHead.addChild(head);
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

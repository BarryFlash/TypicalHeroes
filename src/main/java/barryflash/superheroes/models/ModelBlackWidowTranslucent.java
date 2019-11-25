package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelBlackWidowTranslucent extends ModelHero
{
    public ModelRenderer left_leg;
    public ModelRenderer right_leg;

    public ModelBlackWidowTranslucent(float scale) {
      	 super(scale);
        textureWidth = 64;
        textureHeight = 64;
        left_leg = new ModelRenderer(this, 0, 45);
        left_leg.mirror = true;
        left_leg.setRotationPoint(0.0F, 0.0F, 0.0F);
        left_leg.addBox(-0.5F, 4.4F, -1.8F, 1, 1, 0, 0.4F);
        right_leg = new ModelRenderer(this, 0, 45);
        right_leg.setRotationPoint(0.0F, 0.0F, 0.0F);
        right_leg.addBox(-0.5F, 4.4F, -1.8F, 1, 1, 0, 0.4F);
        
        bipedRightLeg.addChild(right_leg);
        bipedLeftLeg.addChild(left_leg);
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

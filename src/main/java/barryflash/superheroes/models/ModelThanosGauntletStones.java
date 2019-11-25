package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelThanosGauntletStones extends ModelHero
{
    public ModelRenderer rightarm_mind;
    public ModelRenderer rightarm_power;
    public ModelRenderer rightarm_space;
    public ModelRenderer rightarm_reality;
    public ModelRenderer rightarm_soul;
    public ModelRenderer rightarm_time;

    public ModelThanosGauntletStones(float scale) {
   	 super(scale);
     textureWidth = 128;
     textureHeight = 128;
        rightarm_power = new ModelRenderer(this, 37, 48);
        rightarm_power.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_power.addBox(-3.7F, 9.1F, -2.3F, 1, 1, 1, -0.1F);
        rightarm_mind = new ModelRenderer(this, 64, 48);
        rightarm_mind.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_mind.addBox(-3.4F, 6.7F, -0.5F, 1, 1, 1, 0.2F);
        rightarm_space = new ModelRenderer(this, 44, 48);
        rightarm_space.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_space.addBox(-3.7F, 9.1F, -1.1F, 1, 1, 1, -0.1F);
        rightarm_time = new ModelRenderer(this, 29, 48);
        rightarm_time.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_time.addBox(-1.2F, 6.4F, -3.5F, 1, 1, 1, -0.1F);
        setRotateAngle(rightarm_time, 0.0F, 0.3672172746196069F, 0.0F);
        rightarm_reality = new ModelRenderer(this, 50, 48);
        rightarm_reality.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_reality.addBox(-3.7F, 9.1F, 0.1F, 1, 1, 1, -0.1F);
        rightarm_soul = new ModelRenderer(this, 55, 48);
        rightarm_soul.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm_soul.addBox(-3.7F, 9.1F, 1.3F, 1, 1, 1, -0.1F);
        
        bipedRightArm.addChild(rightarm_power);
        bipedRightArm.addChild(rightarm_soul);
        bipedRightArm.addChild(rightarm_mind);
        bipedRightArm.addChild(rightarm_time);
        bipedRightArm.addChild(rightarm_space);
        bipedRightArm.addChild(rightarm_reality);
        
 
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

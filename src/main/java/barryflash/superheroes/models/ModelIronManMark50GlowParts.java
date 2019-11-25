package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelIronManMark50GlowParts extends ModelHero
{
    public ModelRenderer body_arc;
    public ModelRenderer body_arc_1;
    public ModelRenderer body_arc_2;
    public ModelRenderer body_arc_3;
    public ModelRenderer body_arc_4;
    public ModelRenderer body_arc_5;
    public ModelRenderer body_arc_6;
    public ModelRenderer body_arc_7;
    public ModelRenderer body_arc_8;
    public ModelRenderer body_arc_9;
    public ModelRenderer head;
    public ModelRenderer rightarm;
    public ModelRenderer leftarm;
    public ModelRenderer rightleg;
    public ModelRenderer leftleg;
    public ModelRenderer body;
    public ModelRenderer body_1;
    public ModelRenderer body_2;
    public ModelRenderer body_3;
    public ModelRenderer rightleg_1;
    public ModelRenderer leftleg_1;
    public ModelRenderer body_4;
    public ModelRenderer body_5;
    public ModelRenderer body_6;
    public ModelRenderer body_7;
    public ModelRenderer shield_39;
    public ModelRenderer shield_40;
    
    public ModelIronManMark50GlowParts(float scale) {
    	 super(scale);
    	 
    	 	textureWidth = 128;
    	 	textureHeight = 128;
    	 	shield_39 = new ModelRenderer(this, 110, 110);
            shield_39.mirror = true;
            shield_39.setRotationPoint(1.5F, 0.0F, 0.0F);
            shield_39.addBox(2.55F, 10.8F, 2.4F, 1, 1, 6, -0.15F);
            setRotateAngle(shield_39, 0.0F, -0.16912240451825053F, 0.0F);
    	    shield_40 = new ModelRenderer(this, 110, 110);
            shield_40.setRotationPoint(1.5F, 0.0F, 0.0F);
            shield_40.addBox(-6.35F, 10.8F, 1.8F, 1, 1, 6, -0.15F);
            setRotateAngle(shield_40, 0.0F, 0.16912240451825053F, 0.0F);
        rightleg = new ModelRenderer(this, 110, 110);
        rightleg.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightleg.addBox(-2.0F, 10.65F, -2.0F, 4, 2, 4, -0.5F);
        rightarm = new ModelRenderer(this, 110, 120);
        rightarm.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm.addBox(-3.0F, 8.65F, -2.0F, 4, 2, 4, -0.5F);
        head = new ModelRenderer(this, 110, 110);
        head.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addBox(-3.5F, -4.9F, -4.15F, 7, 1, 1, 0.0F);
        body_arc_1 = new ModelRenderer(this, 120, 120);
        body_arc_1.mirror = true;
        body_arc_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_arc_1.addBox(-0.8F, 1.6F, -2.25F, 1, 1, 1, -0.1F);
        setRotateAngle(body_arc_1, 0.0F, 0.0F, -0.5141739976375296F);
        body_arc_3 = new ModelRenderer(this, 120, 120);
        body_arc_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_arc_3.addBox(-0.51F, 2.52F, -2.15F, 1, 1, 1, 0.0F);
        body_arc_6 = new ModelRenderer(this, 120, 120);
        body_arc_6.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_arc_6.addBox(-1.2F, 1.12F, -2.45F, 1, 1, 1, -0.3F);
        body_6 = new ModelRenderer(this, 110, 110);
        body_6.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_6.addBox(-11.1F, 3.6F, -2.51F, 1, 1, 1, -0.3F);
        setRotateAngle(body_6, 0.0F, 0.0F, -0.9609782861480778F);
        leftarm = new ModelRenderer(this, 110, 110);
        leftarm.mirror = true;
        leftarm.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftarm.addBox(-1.0F, 8.65F, -2.0F, 4, 2, 4, -0.5F);
        body_5 = new ModelRenderer(this, 110, 110);
        body_5.mirror = true;
        body_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_5.addBox(9.8F, 3.6F, -2.51F, 1, 1, 1, -0.3F);
        setRotateAngle(body_5, 0.0F, 0.0F, 0.9609782861480778F);
        body_arc_2 = new ModelRenderer(this, 120, 120);
        body_arc_2.mirror = true;
        body_arc_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_arc_2.addBox(1.38F, 1.02F, -2.35F, 1, 2, 1, -0.2F);
        setRotateAngle(body_arc_2, 0.0F, 0.0F, 0.5080653452555492F);
        body_arc_4 = new ModelRenderer(this, 120, 120);
        body_arc_4.mirror = true;
        body_arc_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_arc_4.addBox(0.2F, 1.12F, -2.45F, 1, 1, 1, -0.3F);
        body_3 = new ModelRenderer(this, 110, 110);
        body_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_3.addBox(-4.38F, 2.82F, -2.55F, 1, 1, 1, -0.3F);
        setRotateAngle(body_3, 0.0F, 0.0F, -0.47420595776685937F);
        body_arc_7 = new ModelRenderer(this, 120, 120);
        body_arc_7.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_arc_7.addBox(-2.38F, 1.02F, -2.35F, 1, 2, 1, -0.2F);
        setRotateAngle(body_arc_7, 0.0F, 0.0F, -0.5080653452555492F);
        rightleg_1 = new ModelRenderer(this, 110, 110);
        rightleg_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightleg_1.addBox(-0.5F, 2.0F, -2.45F, 2, 1, 1, -0.2F);
        setRotateAngle(rightleg_1, 0.0F, 0.0F, 0.4895648551844094F);
        body_arc_9 = new ModelRenderer(this, 120, 120);
        body_arc_9.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_arc_9.addBox(-1.95F, 0.52F, -2.45F, 1, 1, 1, -0.3F);
        setRotateAngle(body_arc_9, 0.0F, 0.0F, -0.64943701466709F);
        body_1 = new ModelRenderer(this, 110, 110);
        body_1.mirror = true;
        body_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_1.addBox(3.38F, 2.82F, -2.55F, 1, 1, 1, -0.3F);
        setRotateAngle(body_1, 0.0F, 0.0F, 0.47420595776685937F);
        body_arc_8 = new ModelRenderer(this, 120, 120);
        body_arc_8.mirror = true;
        body_arc_8.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_arc_8.addBox(0.95F, 0.52F, -2.45F, 1, 1, 1, -0.3F);
        setRotateAngle(body_arc_8, 0.0F, 0.0F, 0.64943701466709F);
        body_7 = new ModelRenderer(this, 110, 110);
        body_7.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_7.addBox(-10.8F, 3.6F, -2.51F, 1, 1, 1, -0.3F);
        setRotateAngle(body_7, 0.0F, 0.0F, -0.9609782861480778F);
        body_2 = new ModelRenderer(this, 110, 110);
        body_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_2.addBox(-4.38F, 2.52F, -2.55F, 1, 1, 1, -0.3F);
        setRotateAngle(body_2, 0.0F, 0.0F, -0.47420595776685937F);
        leftleg_1 = new ModelRenderer(this, 110, 110);
        leftleg_1.mirror = true;
        leftleg_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftleg_1.addBox(-1.5F, 2.0F, -2.45F, 2, 1, 1, -0.2F);
        setRotateAngle(leftleg_1, 0.0F, 0.0F, -0.4895648551844094F);
        body = new ModelRenderer(this, 110, 110);
        body.mirror = true;
        body.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addBox(3.38F, 2.52F, -2.55F, 1, 1, 1, -0.3F);
        setRotateAngle(body, 0.0F, 0.0F, 0.47420595776685937F);
        body_4 = new ModelRenderer(this, 110, 110);
        body_4.mirror = true;
        body_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_4.addBox(10.1F, 3.6F, -2.51F, 1, 1, 1, -0.3F);
        setRotateAngle(body_4, 0.0F, 0.0F, 0.9609782861480778F);
        body_arc = new ModelRenderer(this, 120, 120);
        body_arc.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_arc.addBox(-0.5F, 1.9F, -1.95F, 1, 1, 1, 0.2F);
        leftleg = new ModelRenderer(this, 110, 110);
        leftleg.mirror = true;
        leftleg.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftleg.addBox(-2.0F, 10.65F, -2.0F, 4, 2, 4, -0.5F);
        body_arc_5 = new ModelRenderer(this, 120, 120);
        body_arc_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        body_arc_5.addBox(-0.2F, 1.6F, -2.25F, 1, 1, 1, -0.1F);
        setRotateAngle(body_arc_5, 0.0F, 0.0F, 0.5141739976375296F);
        
        bipedBody.addChild(body_arc);
        bipedBody.addChild(body_arc_1);
        bipedBody.addChild(body_arc_2);
        bipedBody.addChild(body_arc_3);
        bipedBody.addChild(body_arc_4);
        bipedBody.addChild(body_arc_5);
        bipedBody.addChild(body_arc_6);
        bipedBody.addChild(body_arc_7);
        bipedBody.addChild(body_arc_8);
        bipedBody.addChild(body_arc_9);
      
        bipedBody.addChild(body);
        bipedBody.addChild(body_1);
        bipedBody.addChild(body_2);
        bipedBody.addChild(body_3);
        bipedBody.addChild(body_4);
        bipedBody.addChild(body_5);
        bipedBody.addChild(body_6);
        bipedBody.addChild(body_7);
        
        bipedRightArm.addChild(rightarm);
        
        bipedRightArm.addChild(shield_39);
        bipedRightArm.addChild(shield_40);
        bipedRightArm.addChild(rightarm);
        bipedLeftArm.addChild(leftarm);
        
        bipedRightLeg.addChild(rightleg);
        bipedRightLeg.addChild(rightleg_1);
        
        bipedLeftLeg.addChild(leftleg);
        bipedLeftLeg.addChild(leftleg_1);
        
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

package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * SteveTrevorModel - BarryFlash
 * Created using Tabula 6.0.0
 */
public class SteveTrevorModel extends ModelBiped {

    private ModelRenderer shape8;
    private ModelRenderer shape9;
    private ModelRenderer shape10;
    private ModelRenderer shape10_1;
    private ModelRenderer shape10_2;
    private ModelRenderer shape10_3;
    private ModelRenderer shape10_4;
    private ModelRenderer shape10_5;
    private ModelRenderer shape10_6;
    private ModelRenderer shape10_7;
    private ModelRenderer shape10_8;
    private ModelRenderer shape10_9;
    private ModelRenderer shape10_10;
    private ModelRenderer bipedRightLeg_1;
    private ModelRenderer bipedRightLeg_2;
    private ModelRenderer bipedRightLeg_3;
    private ModelRenderer bipedRightLeg_4;
    private ModelRenderer shape10_11;
    private ModelRenderer shape10_12;
    private ModelRenderer shape10_13;
    private ModelRenderer bipedRightArm_1;
    private ModelRenderer bipedRightArm_2;
    private ModelRenderer bipedRightLeg_5;
    private ModelRenderer bipedRightLeg_6;
    private ModelRenderer shape8_1;
    private ModelRenderer shape8_2;
    private ModelRenderer shape8_3;
    private ModelRenderer shape8_4;
    private ModelRenderer shape8_5;
    private ModelRenderer shape8_6;
    private ModelRenderer shape10_14;
    private ModelRenderer shape10_15;
    private ModelRenderer shape10_16;
    private ModelRenderer shape10_17;
    private ModelRenderer shape10_18;
    private ModelRenderer shape10_19;
    private ModelRenderer shape10_20;
    private ModelRenderer shape10_21;
    private ModelRenderer shape48;
    private ModelRenderer shape48_1;
    private ModelRenderer shape10_22;

    public SteveTrevorModel(float scale) {
    	 super(scale, 0, 512, 512);
    	 
    	 textureWidth = 512;
    	 textureHeight = 512;

        this.shape10_10 = new ModelRenderer(this, 60, 98);
        this.shape10_10.setRotationPoint(-2.8F, 10.0F, -2.4F);
        this.shape10_10.addBox(0.0F, 0.0F, 0.0F, 3, 2, 1, 0.0F);
        this.setRotateAngle(shape10_10, 0.0F, 0.0F, 0.22759093446006054F);
        this.shape9 = new ModelRenderer(this, 100, 7);
        this.shape9.setRotationPoint(-2.5F, 0.0F, -2.3F);
        this.shape9.addBox(0.0F, 0.0F, 0.0F, 5, 5, 1, 0.0F);
        this.shape10_2 = new ModelRenderer(this, 80, 98);
        this.shape10_2.setRotationPoint(-0.1F, 2.4F, -2.5F);
        this.shape10_2.addBox(0.0F, 0.0F, 0.0F, 1, 9, 1, 0.0F);
        this.shape8_6 = new ModelRenderer(this, 350, 200);
        this.shape8_6.setRotationPoint(4.2F, -1.1F, 2.3F);
        this.shape8_6.addBox(0.0F, 0.0F, 0.0F, 4, 1, 3, 0.1F);
        this.setRotateAngle(shape8_6, 0.0F, 1.9594811512140335F, 0.0F);
        this.bipedRightLeg_3 = new ModelRenderer(this, 200, 247);
        this.bipedRightLeg_3.setRotationPoint(-4.0F, 18.0F, -2.0F);
        this.bipedRightLeg_3.addBox(2.0F, -12.0F, 0.0F, 4, 4, 4, 0.1F);
        this.shape8_4 = new ModelRenderer(this, 350, 200);
        this.shape8_4.setRotationPoint(-2.6F, -1.1F, -1.2F);
        this.shape8_4.addBox(0.0F, 0.0F, 0.0F, 4, 1, 3, 0.1F);
        this.setRotateAngle(shape8_4, 0.0F, -1.9577358219620393F, 0.0F);
        this.shape10_13 = new ModelRenderer(this, 300, 268);
        this.shape10_13.setRotationPoint(-2.6F, 0.9F, 0.3F);
        this.shape10_13.addBox(0.0F, 0.0F, 0.0F, 5, 13, 2, 0.0F);
        this.shape10_17 = new ModelRenderer(this, 320, 332);
        this.shape10_17.setRotationPoint(-4.3F, 0.9F, -0.69F);
        this.shape10_17.addBox(0.0F, 0.0F, 0.0F, 2, 13, 3, 0.0F);
        this.shape10_16 = new ModelRenderer(this, 300, 380);
        this.shape10_16.setRotationPoint(2.0F, 1.2F, -2.79F);
        this.shape10_16.addBox(0.0F, 0.0F, 0.0F, 2, 5, 5, 0.0F);
        this.shape10_8 = new ModelRenderer(this, 80, 98);
        this.shape10_8.setRotationPoint(-0.2F, 9.7F, -2.5F);
        this.shape10_8.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(shape10_8, 0.0F, 0.0F, 0.4553564018453205F);
        this.shape10_9 = new ModelRenderer(this, 80, 98);
        this.shape10_9.setRotationPoint(-0.2F, 9.9F, -2.51F);
        this.shape10_9.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
        this.shape10_15 = new ModelRenderer(this, 300, 380);
        this.shape10_15.setRotationPoint(3.3F, 1.6F, -2.8F);
        this.shape10_15.addBox(0.0F, 0.0F, 0.0F, 2, 5, 5, 0.0F);
        this.setRotateAngle(shape10_15, 0.0F, 0.0F, 0.27314402793711257F);
        this.shape10_19 = new ModelRenderer(this, 82, 100);
        this.shape10_19.setRotationPoint(-1.0F, 2.6F, -2.44F);
        this.shape10_19.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
        this.setRotateAngle(shape10_19, 0.0F, 0.0F, 0.8651597102135892F);
        this.bipedRightArm_2 = new ModelRenderer(this, 300, 307);
        this.bipedRightArm_2.setRotationPoint(4.0F, 0.0F, -2.0F);
        this.bipedRightArm_2.addBox(-5.0F, -1.5F, 0.0F, 4, 11, 4, 0.5F);
        this.shape10_11 = new ModelRenderer(this, 320, 374);
        this.shape10_11.setRotationPoint(-4.3F, 0.9F, -2.7F);
        this.shape10_11.addBox(0.0F, 0.0F, 0.0F, 2, 13, 2, 0.0F);
        this.bipedRightLeg_6 = new ModelRenderer(this, 200, 200);
        this.bipedRightLeg_6.setRotationPoint(0.0F, 22.0F, -2.0F);
        this.bipedRightLeg_6.addBox(-2.0F, -12.0F, 0.0F, 4, 2, 4, 0.2F);
        this.shape10_21 = new ModelRenderer(this, 74, 251);
        this.shape10_21.setRotationPoint(-0.4F, 9.6F, -2.45F);
        this.shape10_21.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(shape10_21, 0.0F, 0.0F, 0.4553564018453205F);
        this.shape10 = new ModelRenderer(this, 6, 98);
        this.shape10.setRotationPoint(-2.7F, 0.9F, -2.4F);
        this.shape10.addBox(0.0F, 0.0F, 0.0F, 1, 9, 1, 0.0F);
        this.setRotateAngle(shape10, 0.0F, 0.0F, -0.40980330836826856F);
        this.shape48 = new ModelRenderer(this, 400, 6);
        this.shape48.setRotationPoint(0.4F, 6.8F, -3.0F);
        this.shape48.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, -0.3F);
        this.shape10_14 = new ModelRenderer(this, 300, 392);
        this.shape10_14.setRotationPoint(-5.8F, 0.9F, -2.8F);
        this.shape10_14.addBox(0.0F, 0.0F, 0.0F, 2, 13, 2, 0.0F);
        this.setRotateAngle(shape10_14, 0.0F, 0.0F, -0.136659280431156F);
        this.shape10_7 = new ModelRenderer(this, 82, 144);
        this.shape10_7.setRotationPoint(-3.0F, 9.5F, -2.6F);
        this.shape10_7.addBox(0.0F, 0.0F, 0.0F, 6, 1, 1, 0.0F);
        this.shape10_1 = new ModelRenderer(this, 80, 98);
        this.shape10_1.setRotationPoint(1.1F, 0.9F, -2.5F);
        this.shape10_1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(shape10_1, 0.0F, 0.0F, 0.6373942428283291F);
        this.shape10_12 = new ModelRenderer(this, 300, 268);
        this.shape10_12.setRotationPoint(2.3F, 0.9F, -2.69F);
        this.shape10_12.addBox(0.0F, 0.0F, 0.0F, 2, 13, 5, 0.0F);
        this.shape10_18 = new ModelRenderer(this, 300, 300);
        this.shape10_18.setRotationPoint(-5.8F, 0.9F, -0.7F);
        this.shape10_18.addBox(0.0F, 0.0F, 0.0F, 2, 13, 3, 0.0F);
        this.setRotateAngle(shape10_18, 0.0F, 0.0F, -0.136659280431156F);
        this.shape8_5 = new ModelRenderer(this, 350, 200);
        this.shape8_5.setRotationPoint(0.6F, -1.1F, 1.5F);
        this.shape8_5.addBox(0.0F, 0.0F, 0.0F, 4, 1, 5, 0.1F);
        this.setRotateAngle(shape8_5, 0.0F, 0.9105382707654417F, 0.0F);
        this.bipedRightLeg_5 = new ModelRenderer(this, 200, 200);
        this.bipedRightLeg_5.setRotationPoint(-4.0F, 22.0F, -2.0F);
        this.bipedRightLeg_5.addBox(2.0F, -12.0F, 0.0F, 4, 2, 4, 0.2F);
        this.shape8_3 = new ModelRenderer(this, 350, 200);
        this.shape8_3.setRotationPoint(-3.0F, -1.1F, -1.6F);
        this.shape8_3.addBox(0.0F, 0.0F, 0.0F, 4, 1, 5, 0.1F);
        this.setRotateAngle(shape8_3, 0.0F, -0.9105382707654417F, 0.0F);
        this.bipedRightArm_1 = new ModelRenderer(this, 300, 307);
        this.bipedRightArm_1.setRotationPoint(-8.0F, 0.0F, -2.0F);
        this.bipedRightArm_1.addBox(5.0F, -1.5F, 0.0F, 4, 11, 4, 0.5F);
        this.bipedRightLeg_2 = new ModelRenderer(this, 60, 247);
        this.bipedRightLeg_2.setRotationPoint(0.0F, 12.0F, -2.0F);
        this.bipedRightLeg_2.addBox(-2.0F, -12.0F, 0.0F, 4, 6, 4, 0.2F);
        this.bipedRightLeg_4 = new ModelRenderer(this, 250, 247);
        this.bipedRightLeg_4.setRotationPoint(0.0F, 18.0F, -2.0F);
        this.bipedRightLeg_4.addBox(-2.0F, -12.0F, 0.0F, 4, 4, 4, 0.1F);
        this.shape8_1 = new ModelRenderer(this, 350, 300);
        this.shape8_1.setRotationPoint(-4.5F, 0.1F, -0.5F);
        this.shape8_1.addBox(0.0F, 0.0F, 0.0F, 9, 2, 5, 0.1F);
        this.shape8_2 = new ModelRenderer(this, 350, 200);
        this.shape8_2.setRotationPoint(-4.5F, -1.1F, -0.4F);
        this.shape8_2.addBox(0.0F, 0.0F, 0.0F, 9, 1, 5, 0.1F);
        this.shape10_22 = new ModelRenderer(this, 400, 144);
        this.shape10_22.setRotationPoint(-0.7F, 9.5F, -2.7F);
        this.shape10_22.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.1F);
        this.shape8 = new ModelRenderer(this, 85, 0);
        this.shape8.setRotationPoint(-4.5F, -0.3F, -4.5F);
        this.shape8.addBox(0.0F, 0.0F, 0.0F, 9, 2, 9, 0.0F);
        this.shape48_1 = new ModelRenderer(this, 400, 6);
        this.shape48_1.setRotationPoint(0.4F, 5.0F, -3.0F);
        this.shape48_1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, -0.3F);
        this.shape10_20 = new ModelRenderer(this, 74, 250);
        this.shape10_20.setRotationPoint(-0.3F, 2.4F, -2.45F);
        this.shape10_20.addBox(0.0F, 0.0F, 0.0F, 1, 9, 1, 0.0F);
        this.bipedRightLeg_1 = new ModelRenderer(this, 50, 247);
        this.bipedRightLeg_1.setRotationPoint(-4.0F, 12.0F, -2.0F);
        this.bipedRightLeg_1.addBox(2.0F, -12.0F, 0.0F, 4, 6, 4, 0.2F);
        this.shape10_6 = new ModelRenderer(this, 60, 98);
        this.shape10_6.setRotationPoint(-1.8F, 2.9F, -2.42F);
        this.shape10_6.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.shape10_3 = new ModelRenderer(this, 60, 98);
        this.shape10_3.setRotationPoint(-2.8F, 0.9F, -2.4F);
        this.shape10_3.addBox(0.0F, 0.0F, 0.0F, 1, 11, 1, 0.0F);
        this.shape10_5 = new ModelRenderer(this, 60, 98);
        this.shape10_5.setRotationPoint(-1.8F, 4.9F, -2.41F);
        this.shape10_5.addBox(0.0F, 0.0F, 0.0F, 3, 7, 1, 0.0F);
        this.shape10_4 = new ModelRenderer(this, 80, 98);
        this.shape10_4.setRotationPoint(0.9F, 0.9F, -2.5F);
        this.shape10_4.addBox(0.0F, 0.0F, 0.0F, 2, 11, 1, 0.0F);
        
        bipedHead.addChild(shape8);
        bipedBody.addChild(shape9);
        bipedBody.addChild(shape10);
        bipedBody.addChild(shape10_1);
        bipedBody.addChild(shape10_2);
        bipedBody.addChild(shape10_3);
        bipedBody.addChild(shape10_4);
        bipedBody.addChild(shape10_5);
        bipedBody.addChild(shape10_6);
        bipedBody.addChild(shape10_7);
        bipedBody.addChild(shape10_8);
        bipedBody.addChild(shape10_9);
        bipedBody.addChild(shape10_10);
        bipedBody.addChild(shape10_11);
        bipedBody.addChild(shape10_12);
        bipedBody.addChild(shape10_13);
        bipedBody.addChild(shape10_14);
        bipedBody.addChild(shape10_15);
        bipedBody.addChild(shape10_16);
        bipedBody.addChild(shape10_17);
        bipedBody.addChild(shape10_18);
        bipedBody.addChild(shape10_19);
        bipedBody.addChild(shape10_20);
        bipedBody.addChild(shape10_21);
        bipedBody.addChild(shape10_22);
        bipedHead.addChild(shape8_1);
        bipedHead.addChild(shape8_2);
        bipedHead.addChild(shape8_3);
        bipedHead.addChild(shape8_4);
        bipedHead.addChild(shape8_5);
        bipedHead.addChild(shape8_6);
        bipedBody.addChild(shape48);
        bipedBody.addChild(shape48_1);
        bipedLeftLeg.addChild(bipedRightLeg_6);
        bipedLeftLeg.addChild(bipedRightLeg_4);
        bipedLeftLeg.addChild(bipedRightLeg_2);
        bipedRightLeg.addChild(bipedRightLeg_5);
        bipedRightLeg.addChild(bipedRightLeg_3);
        bipedRightLeg.addChild(bipedRightLeg_1);
        bipedRightArm.addChild(bipedRightArm_1);
        bipedLeftArm.addChild(bipedRightArm_2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

package barryflash.superheroes.models;

import org.lwjgl.input.Keyboard;

import barryflash.superheroes.entities.projectiles.EntityTiara;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ModelWonderWomanLasso extends ModelHero
{

   

 
  

    public ModelRenderer leftskirt_23;
    public ModelRenderer leftskirt_24;
    public ModelRenderer leftskirt_25;
    public ModelRenderer leftskirt_26;
    public ModelRenderer leftskirt_27;
    public ModelRenderer leftskirt_28;
    public ModelRenderer leftskirt_29;
    public ModelRenderer leftskirt_30;
    public ModelRenderer leftskirt_31;
    public ModelRenderer leftskirt_32;
    public ModelRenderer leftskirt_33;
    public ModelRenderer leftskirt_34;
    public ModelRenderer leftskirt_35;

    public ModelWonderWomanLasso(float scale) {
     	 super(scale);
      	 
   	 	textureWidth = 512;
   	 	textureHeight = 512;
      
       
        leftskirt_30 = new ModelRenderer(this, 29, 420);
        leftskirt_30.setRotationPoint(2.0F, -12.0F, 0.0F);
        leftskirt_30.addBox(-4.9F, 10.3F, 8.07F, 1, 2, 1, -0.2F);
        setRotateAngle(leftskirt_30, -0.7285004297824331F, 0.0F, 0.0F);
        leftskirt_31 = new ModelRenderer(this, 29, 420);
        leftskirt_31.setRotationPoint(2.0F, -12.0F, 0.0F);
        leftskirt_31.addBox(-4.9F, 9.5F, 6.77F, 1, 1, 1, -0.2F);
        setRotateAngle(leftskirt_31, -0.7285004297824331F, 0.0F, 0.0F);
        leftskirt_23 = new ModelRenderer(this, 29, 420);
        leftskirt_23.setRotationPoint(2.0F, -12.0F, 0.0F);
        leftskirt_23.addBox(-4.9F, 11.7F, -1.5F, 1, 1, 3, -0.2F);
        leftskirt_32 = new ModelRenderer(this, 29, 420);
        leftskirt_32.setRotationPoint(2.0F, -12.0F, 0.0F);
        leftskirt_32.addBox(-4.9F, 13.1F, -1.0F, 1, 1, 2, -0.2F);
        leftskirt_28 = new ModelRenderer(this, 29, 420);
        leftskirt_28.setRotationPoint(2.0F, -12.0F, 0.0F);
        leftskirt_28.addBox(-4.8F, 7.9F, 8.8F, 1, 1, 1, -0.1F);
        setRotateAngle(leftskirt_28, -0.7285004297824331F, 0.0F, 0.0F);
        leftskirt_26 = new ModelRenderer(this, 29, 419);
        leftskirt_26.setRotationPoint(2.0F, -12.0F, 0.0F);
        leftskirt_26.addBox(-4.9F, 12.2F, 1.1F, 1, 4, 1, -0.2F);
        leftskirt_27 = new ModelRenderer(this, 29, 420);
        leftskirt_27.setRotationPoint(2.0F, -12.0F, 0.0F);
        leftskirt_27.addBox(-4.8F, 12.4F, 9.2F, 1, 1, 1, -0.1F);
        setRotateAngle(leftskirt_27, -0.7285004297824331F, 0.0F, 0.0F); 
        leftskirt_29 = new ModelRenderer(this, 29, 420);
        leftskirt_29.setRotationPoint(2.0F, -12.0F, 0.0F);
        leftskirt_29.addBox(-4.8F, 10.6F, 11.17F, 1, 1, 1, -0.1F);
        setRotateAngle(leftskirt_29, -0.7285004297824331F, 0.0F, 0.0F);
        leftskirt_33 = new ModelRenderer(this, 29, 419);
        leftskirt_33.setRotationPoint(2.0F, -12.0F, 0.0F);
        leftskirt_33.addBox(-4.9F, 13.6F, 0.0F, 1, 2, 1, -0.2F);
        leftskirt_34 = new ModelRenderer(this, 29, 420);
        leftskirt_34.setRotationPoint(2.0F, -12.0F, 0.0F);
        leftskirt_34.addBox(-4.9F, 10.8F, 10.07F, 1, 1, 1, -0.2F);
        setRotateAngle(leftskirt_34, -0.7285004297824331F, 0.0F, 0.0F);
        leftskirt_25 = new ModelRenderer(this, 29, 419);
        leftskirt_25.setRotationPoint(2.0F, -12.0F, 0.0F);
        leftskirt_25.addBox(-4.9F, 14.3F, -2.1F, 1, 2, 1, -0.2F);
        leftskirt_24 = new ModelRenderer(this, 29, 420);
        leftskirt_24.setRotationPoint(2.0F, -12.0F, 0.0F);
        leftskirt_24.addBox(-4.9F, 15.87F, -1.5F, 1, 1, 3, -0.2F);
        leftskirt_35 = new ModelRenderer(this, 29, 419);
        leftskirt_35.setRotationPoint(2.0F, -12.0F, 0.0F);
        leftskirt_35.addBox(-4.9F, 12.1F, -1.85F, 1, 1, 1, -0.2F);
     
        
     
       
        bipedRightLeg.addChild(leftskirt_23);
        bipedRightLeg.addChild(leftskirt_24);
        bipedRightLeg.addChild(leftskirt_25);
        bipedRightLeg.addChild(leftskirt_26);
        bipedRightLeg.addChild(leftskirt_27);
        bipedRightLeg.addChild(leftskirt_28);
        bipedRightLeg.addChild(leftskirt_29);
        bipedRightLeg.addChild(leftskirt_30);
        bipedRightLeg.addChild(leftskirt_31);
        bipedRightLeg.addChild(leftskirt_32);
        bipedRightLeg.addChild(leftskirt_33);
        bipedRightLeg.addChild(leftskirt_34);
        bipedRightLeg.addChild(leftskirt_35);

        



    
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

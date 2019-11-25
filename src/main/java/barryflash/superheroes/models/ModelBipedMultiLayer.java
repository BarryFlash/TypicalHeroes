package barryflash.superheroes.models;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import org.lwjgl.opengl.GL11;

public class ModelBipedMultiLayer
  extends ModelBiped
{
  public ModelRenderer bipedBodyL2;
  public ModelRenderer bipedRightArmL2;
  public ModelRenderer bipedLeftArmL2;
  public ModelRenderer bipedRightLegL2;
  public ModelRenderer bipedLeftLegL2;
  public ModelRenderer hatLayer;
  protected Minecraft mc = Minecraft.getMinecraft();
  public int armorSlot;
  
  public ModelBipedMultiLayer()
  {
    float scale = 0.01F;
    float scaleL2 = scale + 0.5F;
    this.textureWidth = 64;
    this.textureHeight = 64;
    this.hatLayer = new ModelRenderer(this, 32, 0);
    this.hatLayer.setTextureSize(64, 32);
    this.hatLayer.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.hatLayer.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, scale / 2.0F);
    this.bipedLeftArm = new ModelRenderer(this, 32, 48);
    this.bipedLeftArm.setRotationPoint(5.0F, 2.0F, -0.0F);
    this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, scale);
    setRotateAngle(this.bipedLeftArm, 0.0F, 0.0F, -0.1000074F);
    this.bipedBody = new ModelRenderer(this, 16, 16);
    this.bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, scale);
    this.bipedLeftArmL2 = new ModelRenderer(this, 48, 48);
    this.bipedLeftArmL2.setRotationPoint(5.0F, 2.0F, -0.0F);
    this.bipedLeftArmL2.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, scaleL2);
    setRotateAngle(this.bipedLeftArmL2, 0.0F, 0.0F, -0.1000074F);
    this.bipedHeadwear = new ModelRenderer(this, 32, 0);
    this.bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, scaleL2);
    this.bipedHeadwear = new ModelRenderer(this, 24, 0);
    this.bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bipedHeadwear.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, scale);
    this.bipedRightArmL2 = new ModelRenderer(this, 40, 32);
    this.bipedRightArmL2.setRotationPoint(-5.0F, 2.0F, 0.0F);
    this.bipedRightArmL2.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, scaleL2);
    setRotateAngle(this.bipedRightArmL2, 0.0F, 0.0F, 0.1000074F);
    this.bipedLeftLeg = new ModelRenderer(this, 16, 48);
    this.bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.1F);
    this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, scale);
    this.bipedRightArm = new ModelRenderer(this, 40, 16);
    this.bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
    this.bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, scale);
    setRotateAngle(this.bipedRightArm, 0.0F, 0.0F, 0.1F);
    this.bipedLeftLegL2 = new ModelRenderer(this, 0, 48);
    this.bipedLeftLegL2.setRotationPoint(1.9F, 12.0F, 0.1F);
    this.bipedLeftLegL2.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, scaleL2);
    this.bipedRightLeg = new ModelRenderer(this, 0, 16);
    this.bipedRightLeg.setRotationPoint(-1.9F, 12.0F, 0.1F);
    this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, scale);
    this.bipedBodyL2 = new ModelRenderer(this, 16, 32);
    this.bipedBodyL2.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bipedBodyL2.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, scaleL2);
    this.bipedHead = new ModelRenderer(this, 0, 0);
    this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
    this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, scale);
    this.bipedRightLegL2 = new ModelRenderer(this, 0, 32);
    this.bipedRightLegL2.setRotationPoint(-1.9F, 12.0F, 0.1F);
    this.bipedRightLegL2.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, scaleL2);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
   
    sync(this.bipedBody, this.bipedBodyL2);
    sync(this.bipedRightArm, this.bipedRightArmL2);
    sync(this.bipedLeftArm, this.bipedLeftArmL2);
    sync(this.bipedRightLeg, this.bipedRightLegL2);
    sync(this.bipedLeftLeg, this.bipedLeftLegL2);
    
    renderModel(entity, f, f1, f2, f3, f4, f5);
    {
 
    	 
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glAlphaFunc(516, 0.003921569F);
      GL11.glDisable(2896);
      renderModel(entity, f, f1, f2, f3, f4, f5);
      GL11.glEnable(2896);
      GL11.glAlphaFunc(516, 0.1F);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
    }

  }
  
  public void renderModel(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
	  
    this.bipedLeftArm.render(f5);
    this.bipedBody.render(f5);
    this.bipedLeftArmL2.render(f5);
    this.bipedHeadwear.render(f5);
    this.bipedRightArmL2.render(f5);
    this.bipedLeftLeg.render(f5);
    this.bipedRightArm.render(f5);
    this.bipedLeftLegL2.render(f5);
    this.bipedRightLeg.render(f5);
    this.bipedBodyL2.render(f5);
    this.bipedHead.render(f5);
    this.bipedRightLegL2.render(f5);
  }
  
  public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
  {
    modelRenderer.rotateAngleX = x;
    modelRenderer.rotateAngleY = y;
    modelRenderer.rotateAngleZ = z;
  }
  
  public static void sync(ModelRenderer parent, ModelRenderer child)
  {
    child.rotateAngleX = parent.rotateAngleX;
    child.rotateAngleY = parent.rotateAngleY;
    child.rotateAngleZ = parent.rotateAngleZ;
    
    child.rotationPointX = parent.rotationPointX;
    child.rotationPointY = parent.rotationPointY;
    child.rotationPointZ = parent.rotationPointZ;
    
    child.showModel = parent.showModel;
    child.isHidden = parent.isHidden;
    child.mirror = parent.mirror;
    
    child.offsetX = parent.offsetX;
    child.offsetY = parent.offsetY;
    child.offsetZ = parent.offsetZ;
  }
}

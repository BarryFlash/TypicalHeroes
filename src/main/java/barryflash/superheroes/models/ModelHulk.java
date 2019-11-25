package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModelHulk extends ModelBase
{
	public ModelRenderer right_arm1;
	public ModelRenderer body1;
	public ModelRenderer body1_1;
	public ModelRenderer head_base;
	public ModelRenderer head1;
	public ModelRenderer right_arm_base;
	public ModelRenderer right_arm1_1;
	public ModelRenderer body1_2;
	public ModelRenderer left_leg_base;
	public ModelRenderer left_leg1;
	public ModelRenderer head1_1;
	public ModelRenderer left_arm_base;
	public ModelRenderer left_arm1;
	public ModelRenderer left_arm1_1;
	public ModelRenderer right_leg_base;
	public ModelRenderer right_leg1;

    public ModelBiped.ArmPose leftArmPose;
    public ModelBiped.ArmPose rightArmPose;
    public boolean isSneak;
    public ModelHulk()
    {
        this(0.0F);
    }

    public ModelHulk(float modelSize)
    {
        this(modelSize, 0.0F, 64, 64);
    }

    public ModelHulk(float modelSize, float p_i1149_2_, int textureWidthIn, int textureHeightIn)
    {
    	this.leftArmPose = ModelBiped.ArmPose.EMPTY;
        this.rightArmPose = ModelBiped.ArmPose.EMPTY;
    	this.textureWidth = textureWidthIn;
        this.textureHeight = textureHeightIn;
        body1 = new ModelRenderer(this, 32, 7);
        body1.setRotationPoint(0.0F, -9.0F, 0.0F);
        body1.addBox(-5.5F, 16.3F, -1.5F, 11, 2, 5, 0.4F);
      
        left_arm1 = new ModelRenderer(this, 0, 21);
        left_arm1.mirror = true;
        left_arm1.setRotationPoint(6.6F, -6.5F, 0.0F);
        left_arm1.addBox(0.4F, -1.6F, -2.0F, 6, 8, 6, 0.0F);
        left_leg1 = new ModelRenderer(this, 38, 5);
        left_leg1.mirror = true;
        left_leg1.setRotationPoint(3.0F, 9.5F, 1.0F);
        left_leg1.addBox(-2.5F, 0.2F, -2.5F, 5, 5, 5, 0.4F);
        right_leg_base = new ModelRenderer(this, 44, 45);
        right_leg_base.setRotationPoint(-3.0F, 9.5F, 1.0F);
        right_leg_base.addBox(-2.5F, 0.2F, -2.5F, 5, 14, 5, 0.3F);
        left_arm1_1 = new ModelRenderer(this, 0, 23);
        left_arm1_1.mirror = true;
        left_arm1_1.setRotationPoint(6.6F, -6.5F, 0.0F);
        left_arm1_1.addBox(0.2999999999999998F, 7.9F, -2.0F, 6, 5, 6, 0.0F);
        head1 = new ModelRenderer(this, 0, 0);
        head1.setRotationPoint(0.0F, -9.0F, 0.0F);
        head1.addBox(-3.2F, -9.0F, -4.3F, 1, 2, 8, 0.0F);
        left_arm_base = new ModelRenderer(this, 40, 19);
        left_arm_base.mirror = true;
        left_arm_base.setRotationPoint(6.6F, -6.5F, 0.0F);
        left_arm_base.addBox(0.2F, -2.7F, -2.0F, 6, 20, 6, -0.2F);
        left_leg_base = new ModelRenderer(this, 44, 45);
        left_leg_base.mirror = true;
        left_leg_base.setRotationPoint(3.0F, 9.5F, 1.0F);
        left_leg_base.addBox(-2.5F, 0.2F, -2.5F, 5, 14, 5, 0.3F);
        right_arm_base = new ModelRenderer(this, 40, 19);
        right_arm_base.setRotationPoint(-6.6F, -6.5F, 0.0F);
        right_arm_base.addBox(-6.2F, -2.7F, -2.0F, 6, 20, 6, -0.2F);
        head_base = new ModelRenderer(this, 0, 0);
        head_base.setRotationPoint(0.0F, -9.0F, 0.0F);
        head_base.addBox(-4.0F, -9.2F, -3.0F, 8, 8, 8, 1.0F);
        body1_2 = new ModelRenderer(this, 0, 35);
        body1_2.setRotationPoint(0.0F, -9.0F, 0.0F);
        body1_2.addBox(-5.5F, 10.1F, -1.5F, 11, 7, 5, 0.3F);
        right_arm1_1 = new ModelRenderer(this, 0, 23);
        right_arm1_1.setRotationPoint(-6.6F, -6.5F, 0.0F);
        right_arm1_1.addBox(-6.3F, 7.9F, -2.0F, 6, 5, 6, 0.0F);
        body1 = new ModelRenderer(this, 32, 7);
        body1.setRotationPoint(0.0F, -9.0F, 0.0F);
        body1.addBox(-5.5F, 16.3F, -1.5F, 11, 2, 5, 0.4F);
        head1_1 = new ModelRenderer(this, 0, 0);
        head1_1.setRotationPoint(0.0F, -9.0F, 0.0F);
        head1_1.addBox(-3.1F, -10.0F, -3.5F, 4, 1, 8, 0.8F);
        right_leg1 = new ModelRenderer(this, 38, 5);
        right_leg1.setRotationPoint(-3.0F, 9.5F, 1.0F);
        right_leg1.addBox(-2.5F, 0.2F, -2.5F, 5, 5, 5, 0.4F);
        right_arm1 = new ModelRenderer(this, 0, 21);
        right_arm1.setRotationPoint(-6.6F, -6.5F, 0.0F);
        right_arm1.addBox(-6.4F, -1.6F, -2.0F, 6, 8, 6, 0.0F);
        body1_1 = new ModelRenderer(this, 0, 47);
        body1_1.setRotationPoint(0.0F, -9.0F, 0.0F);
        body1_1.addBox(-7.0F, -0.2F, -2.0F, 14, 11, 6, 0.0F);
        
    
        
    }
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        GlStateManager.pushMatrix();

        if (this.isChild)
        {
            float f = 2.0F;
            GlStateManager.scale(0.75F, 0.75F, 0.75F);
            GlStateManager.translate(0.0F, 16.0F * scale, 0.0F);
            this.head1.render(scale);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5F, 0.5F, 0.5F);
            GlStateManager.translate(0.0F, 24.0F * scale, 0.0F);
            this.body1.render(scale);
            this.right_arm1.render(scale);
            this.left_arm1.render(scale);
            this.left_leg1.render(scale);
            this.head1_1.render(scale);
            this.head_base.render(scale);
            this.right_arm1_1.render(scale);
            this.right_arm_base.render(scale);
            this.left_arm1_1.render(scale);
            this.left_arm_base.render(scale);
            this.right_leg1.render(scale);
            this.right_leg_base.render(scale);
            this.left_leg_base.render(scale);
            this.body1_1.render(scale);
            this.body1_2.render(scale);
        }
        else
        {
            if (entityIn.isSneaking())
            {
                GlStateManager.translate(0.0F, 0.2F, 0.0F);
            }

            this.head1.render(scale);
            this.body1.render(scale);
            this.right_arm1.render(scale);
            this.left_arm1.render(scale);
            this.left_leg1.render(scale);
            this.head1_1.render(scale);
            this.head_base.render(scale);
            this.right_arm1_1.render(scale);
            this.right_arm_base.render(scale);
            this.left_arm1_1.render(scale);
            this.left_arm_base.render(scale);
            this.right_leg1.render(scale);
            this.right_leg_base.render(scale);
            this.left_leg_base.render(scale);
            this.body1_1.render(scale);
            this.body1_2.render(scale);
        }

        GlStateManager.popMatrix();
    }

    @SuppressWarnings("incomplete-switch")
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
    
         this.head_base.rotateAngleY = netHeadYaw * 0.017453292F;

        
         this.head_base.rotateAngleX = headPitch * 0.017453292F;
         
         float f = 1.0F;
         this.body1.rotateAngleY = 0.0F;
         this.right_arm_base.rotationPointZ = 0.0F;
         this.right_arm_base.rotationPointX = -6.6F;
         this.left_arm_base.rotationPointZ = 0.0F;
         this.left_arm_base.rotationPointX = 6.6F;
        

         this.right_arm_base.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
         this.left_arm_base.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
         this.right_arm_base.rotateAngleZ = 0.0F;
         this.left_arm_base.rotateAngleZ = 0.0F;
         this.right_leg_base.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
         this.left_leg_base.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;
         this.right_leg_base.rotateAngleY = 0.0F;
         this.left_leg_base.rotateAngleY = 0.0F;
         this.right_leg_base.rotateAngleZ = 0.0F;
         this.left_leg_base.rotateAngleZ = 0.0F;

         if (this.isRiding)
         {
             this.right_arm_base.rotateAngleX += -((float)Math.PI / 5F);
             this.left_arm_base.rotateAngleX += -((float)Math.PI / 5F);
             this.right_leg_base.rotateAngleX = -1.4137167F;
             this.right_leg_base.rotateAngleY = ((float)Math.PI / 10F);
             this.right_leg_base.rotateAngleZ = 0.07853982F;
             this.left_leg_base.rotateAngleX = -1.4137167F;
             this.left_leg_base.rotateAngleY = -((float)Math.PI / 10F);
             this.left_leg_base.rotateAngleZ = -0.07853982F;
         }

         this.right_arm_base.rotateAngleY = 0.0F;
         this.right_arm_base.rotateAngleZ = 0.0F;

         switch (this.leftArmPose)
         {
             case EMPTY:
                 this.left_arm_base.rotateAngleY = 0.0F;
                 break;
             case BLOCK:
                 this.left_arm_base.rotateAngleX = this.left_arm_base.rotateAngleX * 0.5F - 0.9424779F;
                 this.left_arm_base.rotateAngleY = 0.5235988F;
                 break;
             case ITEM:
                 this.left_arm_base.rotateAngleX = this.left_arm_base.rotateAngleX * 0.5F - ((float)Math.PI / 10F);
                 this.left_arm_base.rotateAngleY = 0.0F;
         }

         switch (this.rightArmPose)
         {
             case EMPTY:
                 this.right_arm_base.rotateAngleY = 0.0F;
                 break;
             case BLOCK:
                 this.right_arm_base.rotateAngleX = this.right_arm_base.rotateAngleX * 0.5F - 0.9424779F;
                 this.right_arm_base.rotateAngleY = -0.5235988F;
                 break;
             case ITEM:
                 this.right_arm_base.rotateAngleX = this.right_arm_base.rotateAngleX * 0.5F - ((float)Math.PI / 10F);
                 this.right_arm_base.rotateAngleY = 0.0F;
         }

         if (this.swingProgress > 0.0F)
         {
             EnumHandSide enumhandside = this.getMainHand(entityIn);
             ModelRenderer modelrenderer = this.getArmForSide(enumhandside);
             float f1 = this.swingProgress;
             this.body1.rotateAngleY = MathHelper.sin(MathHelper.sqrt(f1) * ((float)Math.PI * 2F)) * 0.1F;

             if (enumhandside == EnumHandSide.LEFT)
             {
                 this.body1.rotateAngleY *= -1.0F;
             }

             this.right_arm_base.rotationPointZ = MathHelper.sin(this.body1.rotateAngleY) * 6.6F;
             this.right_arm_base.rotationPointX = -MathHelper.cos(this.body1.rotateAngleY) * 6.6F;
             this.left_arm_base.rotationPointZ = -MathHelper.sin(this.body1.rotateAngleY) * 6.6F;
             this.left_arm_base.rotationPointX = MathHelper.cos(this.body1.rotateAngleY) * 6.6F;
             this.right_arm_base.rotateAngleY += this.body1.rotateAngleY;
             this.left_arm_base.rotateAngleY += this.body1.rotateAngleY;
             this.left_arm_base.rotateAngleX += this.body1.rotateAngleY;
             f1 = 1.0F - this.swingProgress;
             f1 = f1 * f1;
             f1 = f1 * f1;
             f1 = 1.0F - f1;
             float f2 = MathHelper.sin(f1 * (float)Math.PI);
             float f3 = MathHelper.sin(this.swingProgress * (float)Math.PI) * -(this.head_base.rotateAngleX - 0.7F) * 0.75F;
             modelrenderer.rotateAngleX = (float)((double)modelrenderer.rotateAngleX - ((double)f2 * 1.2D + (double)f3));
             modelrenderer.rotateAngleY += this.body1.rotateAngleY * 2.0F;
             modelrenderer.rotateAngleZ += MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F;
             
         }

         if (this.isSneak)
         {
             this.body1.rotateAngleX = 0.4F;
             this.right_arm_base.rotateAngleX += 0.4F;
             this.left_arm_base.rotateAngleX += 0.4F;
             this.right_leg_base.rotationPointZ = 8.0F;
             this.left_leg_base.rotationPointZ = 8.0F;
             this.right_leg_base.rotationPointY = 7.0F;
             this.left_leg_base.rotationPointY = 7.0F;
             this.head_base.rotationPointY = -9.0F;
         }
         else
         {
             this.body1.rotateAngleX = 0.0F;
             this.right_leg_base.rotationPointZ = 1F;
             this.left_leg_base.rotationPointZ = 1F;
             this.right_leg_base.rotationPointY = 9.5F;
             this.left_leg_base.rotationPointY = 9.5F;
             this.head_base.rotationPointY = -9.0F;
         }

         this.right_arm_base.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
         this.left_arm_base.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
         this.right_arm_base.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
         this.left_arm_base.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;

         if (this.rightArmPose == ModelBiped.ArmPose.BOW_AND_ARROW)
         {
             this.right_arm_base.rotateAngleY = -0.1F + this.head_base.rotateAngleY;
             this.left_arm_base.rotateAngleY = 0.1F + this.head_base.rotateAngleY + 0.4F;
             this.right_arm_base.rotateAngleX = -((float)Math.PI / 2F) + this.head_base.rotateAngleX;
             this.left_arm_base.rotateAngleX = -((float)Math.PI / 2F) + this.head_base.rotateAngleX;
         }
         else if (this.leftArmPose == ModelBiped.ArmPose.BOW_AND_ARROW)
         {
             this.right_arm_base.rotateAngleY = -0.1F + this.head_base.rotateAngleY - 0.4F;
             this.left_arm_base.rotateAngleY = 0.1F + this.head_base.rotateAngleY;
             this.right_arm_base.rotateAngleX = -((float)Math.PI / 2F) + this.head_base.rotateAngleX;
             this.left_arm_base.rotateAngleX = -((float)Math.PI / 2F) + this.head_base.rotateAngleX;
         }

         copyModelAngles(this.head_base, this.head1_1);
         copyModelAngles(this.head_base, this.head1);
         copyModelAngles(this.right_arm_base, this.right_arm1_1);
         copyModelAngles(this.right_arm_base, this.right_arm1);
         copyModelAngles(this.left_arm_base, this.left_arm1_1);
         copyModelAngles(this.left_arm_base, this.left_arm1);
         copyModelAngles(this.right_leg_base, this.right_leg1);
         copyModelAngles(this.left_leg_base, this.left_leg1);
         copyModelAngles(this.body1, this.body1_1);
         copyModelAngles(this.body1, this.body1_2);
    }
    public void setModelAttributes(ModelBase model)
    {
        super.setModelAttributes(model);

        if (model instanceof ModelBiped)
        {
            ModelBiped modelbiped = (ModelBiped)model;
            this.leftArmPose = modelbiped.leftArmPose;
            this.rightArmPose = modelbiped.rightArmPose;
            this.isSneak = modelbiped.isSneak;
        }
    }

    public void setVisible(boolean visible)
    {
    	this.head1.showModel = visible;
        this.body1.showModel = visible;
        this.right_arm1.showModel = visible;
        this.left_arm1.showModel = visible;
        this.left_leg1.showModel = visible;
        this.head1_1.showModel = visible;
        this.head_base.showModel = visible;
        this.right_arm1_1.showModel = visible;
        this.right_arm_base.showModel = visible;
        this.left_arm1_1.showModel = visible;
        this.left_arm_base.showModel = visible;
        this.right_leg_base.showModel = visible;
        this.right_leg1.showModel = visible;
        this.left_leg_base.showModel = visible;
        this.body1_1.showModel = visible;
        this.body1_2.showModel = visible;
    }

    public void postRenderArm(float scale, EnumHandSide side)
    {
        this.getArmForSide(side).postRender(scale);
    }

    protected ModelRenderer getArmForSide(EnumHandSide side)
    {
        return side == EnumHandSide.LEFT ? this.left_arm_base : this.right_arm_base;
    }

    protected EnumHandSide getMainHand(Entity entityIn)
    {
        if (entityIn instanceof EntityLivingBase)
        {
            EntityLivingBase entitylivingbase = (EntityLivingBase)entityIn;
            EnumHandSide enumhandside = entitylivingbase.getPrimaryHand();
            return entitylivingbase.swingingHand == EnumHand.MAIN_HAND ? enumhandside : enumhandside.opposite();
        }
        else
        {
            return EnumHandSide.RIGHT;
        }
    }

    @SideOnly(Side.CLIENT)
    public static enum ArmPose
    {
        EMPTY,
        ITEM,
        BLOCK,
        BOW_AND_ARROW;
    }
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

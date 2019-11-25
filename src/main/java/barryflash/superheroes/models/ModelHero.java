package barryflash.superheroes.models;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import barryflash.superheroes.capabilities.BatmanProvider;
import barryflash.superheroes.capabilities.BlackWidowProvider;
import barryflash.superheroes.capabilities.CyborgProvider;
import barryflash.superheroes.capabilities.DoctorStrangeProvider;
import barryflash.superheroes.capabilities.FusionChamberProvider;
import barryflash.superheroes.capabilities.IBatman;
import barryflash.superheroes.capabilities.IBlackWidow;
import barryflash.superheroes.capabilities.ICyborg;
import barryflash.superheroes.capabilities.IDoctorStrange;
import barryflash.superheroes.capabilities.IFusionChamber;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IShazam;
import barryflash.superheroes.capabilities.ISuperman;
import barryflash.superheroes.capabilities.IThor;
import barryflash.superheroes.capabilities.IWasp;
import barryflash.superheroes.capabilities.IWonderWoman;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.capabilities.ShazamProvider;
import barryflash.superheroes.capabilities.SupermanProvider;
import barryflash.superheroes.capabilities.ThorProvider;
import barryflash.superheroes.capabilities.WaspProvider;
import barryflash.superheroes.capabilities.WonderWomanProvider;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemAntmanArmor;
import barryflash.superheroes.items.armor.ItemBatmanArmor;
import barryflash.superheroes.items.armor.ItemCyborgArmor;
import barryflash.superheroes.items.armor.ItemDoctorStrangeArmor;
import barryflash.superheroes.items.armor.ItemIronmanMark50Armor;
import barryflash.superheroes.items.armor.ItemShazamArmor;
import barryflash.superheroes.items.armor.ItemSupermanArmor;
import barryflash.superheroes.items.armor.ItemThorArmor;
import barryflash.superheroes.items.armor.ItemWaspArmor;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelHero extends ModelBiped
{
	public ModelRenderer bipedLeftArmwear;
    public ModelRenderer bipedRightArmwear;
    public ModelRenderer bipedLeftLegwear;
    public ModelRenderer bipedRightLegwear;
    public ModelRenderer bipedBodyWear;
    private final ModelRenderer bipedCape;
    private final ModelRenderer bipedDeadmau5Head;

    public ModelHero(float modelSize)
    {
        super(modelSize, 0.0F, 64, 64);
        this.bipedDeadmau5Head = new ModelRenderer(this, 24, 0);
        this.bipedDeadmau5Head.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, modelSize);
        this.bipedCape = new ModelRenderer(this, 0, 0);
        this.bipedCape.setTextureSize(64, 32);
        this.bipedCape.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, modelSize);

            this.bipedLeftArm = new ModelRenderer(this, 32, 48);
            this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, modelSize);
            this.bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
            this.bipedLeftArmwear = new ModelRenderer(this, 48, 48);
            this.bipedLeftArmwear.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, modelSize + 0.25F);
            this.bipedLeftArmwear.setRotationPoint(5.0F, 2.0F, 0.0F);
            this.bipedRightArmwear = new ModelRenderer(this, 40, 32);
            this.bipedRightArmwear.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, modelSize + 0.25F);
            this.bipedRightArmwear.setRotationPoint(-5.0F, 2.0F, 10.0F);

        this.bipedLeftLeg = new ModelRenderer(this, 16, 48);
        this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, modelSize);
        this.bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.bipedLeftLegwear = new ModelRenderer(this, 0, 48);
        this.bipedLeftLegwear.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, modelSize + 0.25F);
        this.bipedLeftLegwear.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.bipedRightLegwear = new ModelRenderer(this, 0, 32);
        this.bipedRightLegwear.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, modelSize + 0.25F);
        this.bipedRightLegwear.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.bipedBodyWear = new ModelRenderer(this, 16, 32);
        this.bipedBodyWear.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, modelSize + 0.25F);
        this.bipedBodyWear.setRotationPoint(0.0F, 0.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        GlStateManager.pushMatrix();

        if (this.isChild)
        {
            float f = 2.0F;
            GlStateManager.scale(0.5F, 0.5F, 0.5F);
            GlStateManager.translate(0.0F, 24.0F * scale, 0.0F);
            this.bipedLeftLegwear.render(scale);
            this.bipedRightLegwear.render(scale);
            this.bipedLeftArmwear.render(scale);
            this.bipedRightArmwear.render(scale);
            this.bipedBodyWear.render(scale);
        }
        else
        {
            if (entityIn.isSneaking())
            {
                GlStateManager.translate(0.0F, 0.2F, 0.0F);
            }

            this.bipedLeftLegwear.render(scale);
            this.bipedRightLegwear.render(scale);
            this.bipedLeftArmwear.render(scale);
            this.bipedRightArmwear.render(scale);
            this.bipedBodyWear.render(scale);
        }

        GlStateManager.popMatrix();
    }

    public void renderDeadmau5Head(float scale)
    {
        copyModelAngles(this.bipedHead, this.bipedDeadmau5Head);
        this.bipedDeadmau5Head.rotationPointX = 0.0F;
        this.bipedDeadmau5Head.rotationPointY = 0.0F;
        this.bipedDeadmau5Head.render(scale);
    }

    public void renderCape(float scale)
    {
        this.bipedCape.render(scale);
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity)
    {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
        copyModelAngles(this.bipedLeftLeg, this.bipedLeftLegwear);
        copyModelAngles(this.bipedRightLeg, this.bipedRightLegwear);
        copyModelAngles(this.bipedLeftArm, this.bipedLeftArmwear);
        copyModelAngles(this.bipedRightArm, this.bipedRightArmwear);
        copyModelAngles(this.bipedBody, this.bipedBodyWear);
        if (entity instanceof EntityPlayer) {
        IWasp waspcap = entity.getCapability(WaspProvider.WASP_CAP, null);
        IBatman batcap = entity.getCapability(BatmanProvider.BATMAN_CAP, null);
        IWonderWoman wwcap = entity.getCapability(WonderWomanProvider.WONDERWOMAN_CAP, null);
        ISuperman supercap = entity.getCapability(SupermanProvider.SUPERMAN_CAP, null);
        IIronman ironmancap = entity.getCapability(IronmanProvider.IRONMAN_CAP, null);
        IShazam shazamcap = entity.getCapability(ShazamProvider.SHAZAM_CAP, null);
        IFusionChamber fccap = entity.getCapability(FusionChamberProvider.FUSION_CHAMBER_CAP, null);
        IBlackWidow widowcap = entity.getCapability(BlackWidowProvider.BLACKWIDOW_CAP, null);
        ICyborg cyborgcap = entity.getCapability(CyborgProvider.CYBORG_CAP, null);
        IThor thorcap = entity.getCapability(ThorProvider.THOR_CAP, null);
        if (ItemThorArmor.isWearingFullSet((EntityPlayer) entity)) {
        	/*if (thorcap.isFlying() && thorcap.getFlyTicks() != 0) {
        		this.bipedRightArm.rotateAngleX = -3F;
            	this.bipedRightArm.rotateAngleY = 0.0F;
            	this.bipedRightArm.rotateAngleZ = 0.0F;
            	this.bipedLeftArm.rotateAngleX = 0F;
            	this.bipedLeftArm.rotateAngleY = 0.0F;
            	this.bipedLeftArm.rotateAngleZ = 0.0F;
            	this.bipedRightLeg.rotateAngleX = 0.0F;
            	this.bipedRightLeg.rotateAngleY = 0.0F;
            	this.bipedRightLeg.rotateAngleZ = 0.0F;
            	this.bipedLeftLeg.rotateAngleX = 0.0F;
            	this.bipedLeftLeg.rotateAngleY = 0.0F;
            	this.bipedLeftLeg.rotateAngleZ = 0.0F;
            	this.bipedHead.rotateAngleX = -1.5F;
            	  copyModelAngles(this.bipedHead, this.bipedHeadwear);
        	}*/
        }
        if (ItemCyborgArmor.isWearingFullSet((EntityPlayer) entity)) {
        	if (cyborgcap.isSonarCannon()) {
        		this.bipedRightArm.rotateAngleY = this.bipedHead.rotateAngleY;
               	this.bipedRightArm.rotateAngleZ = 0F;
             	this.bipedRightArm.rotateAngleX = -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
        	}
        	/*if (cyborgcap.isFlying() && cyborgcap.getFlyTick() != 0) {
        		this.bipedRightArm.rotateAngleX = 0F;
            	this.bipedRightArm.rotateAngleY = 0.0F;
            	this.bipedRightArm.rotateAngleZ = 0.0F;
            	this.bipedLeftArm.rotateAngleX = 0F;
            	this.bipedLeftArm.rotateAngleY = 0.0F;
            	this.bipedLeftArm.rotateAngleZ = 0.0F;
            	this.bipedRightLeg.rotateAngleX = 0.0F;
            	this.bipedRightLeg.rotateAngleY = 0.0F;
            	this.bipedRightLeg.rotateAngleZ = 0.0F;
            	this.bipedLeftLeg.rotateAngleX = 0.0F;
            	this.bipedLeftLeg.rotateAngleY = 0.0F;
            	this.bipedLeftLeg.rotateAngleZ = 0.0F;
            	this.bipedHead.rotateAngleX = -1.5F;
            	  copyModelAngles(this.bipedHead, this.bipedHeadwear);
        	}*/
        
        }
        if (widowcap.isShootingBlaster()) {
           	this.bipedRightArm.rotateAngleY = this.bipedHead.rotateAngleY  - 0.2F;
           	this.bipedRightArm.rotateAngleZ = 0F;
         	this.bipedRightArm.rotateAngleX = -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
        }
        if (fccap.isInside()) {
        	this.bipedRightArm.rotateAngleX = 0F;
        	this.bipedRightArm.rotateAngleY = 0.0F;
        	this.bipedRightArm.rotateAngleZ = 0.0F;
        	this.bipedLeftArm.rotateAngleX = 0F;
        	this.bipedLeftArm.rotateAngleY = 0.0F;
        	this.bipedLeftArm.rotateAngleZ = 0.0F;
        	this.bipedRightLeg.rotateAngleX = 0.0F;
        	this.bipedRightLeg.rotateAngleY = 0.0F;
        	this.bipedRightLeg.rotateAngleZ = 0.0F;
        	this.bipedLeftLeg.rotateAngleX = 0.0F;
        	this.bipedLeftLeg.rotateAngleY = 0.0F;
        	this.bipedLeftLeg.rotateAngleZ = 0.0F;
        	this.bipedHead.rotateAngleX = 0F;
        	this.bipedHead.rotateAngleY = 0F;
        	this.bipedHead.rotateAngleZ = 0F;
        	this.bipedBody.rotateAngleX = 0F;
        	this.bipedBody.rotateAngleY = 0F;
        	this.bipedBody.rotateAngleZ = 0F;
        }
        if (ItemWonderWomanArmor.isWearingFullSet((EntityPlayer) entity, ModItems.WonderWomanTiara, ModItems.WonderWomanChestplate, ModItems.WonderWomanSkirt, ModItems.WonderWomanBoots)) {
        if (wwcap.areBraceletsActive()) {
        	this.bipedRightArm.rotateAngleX = -1.5F;
        	this.bipedRightArm.rotateAngleY = -1.3F;
        	this.bipedRightArm.rotateAngleZ = -0.5F;
        	this.bipedLeftArm.rotateAngleX = -1.5F;
        	this.bipedLeftArm.rotateAngleY = 1.3F;
        	this.bipedLeftArm.rotateAngleZ = 0.5F;
        }
        }
        if (ItemShazamArmor.isWearingShazam((EntityPlayer) entity)) {
        	if (shazamcap.isShootingLightningBeam()) {
        		this.bipedLeftArm.rotateAngleZ = 0F;
               	this.bipedLeftArm.rotateAngleY = this.bipedHead.rotateAngleY + 0.2F;
               	this.bipedLeftArm.rotateAngleX =  -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
               	
               	this.bipedRightArm.rotateAngleY = this.bipedHead.rotateAngleY  - 0.2F;
               	this.bipedRightArm.rotateAngleZ = 0F;
             	this.bipedRightArm.rotateAngleX = -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
        	}
        	/*if (shazamcap.isFlying() && shazamcap.getFlyTicks() != 0) {
        		this.bipedRightArm.rotateAngleX = -3F;
            	this.bipedRightArm.rotateAngleY = 0.0F;
            	this.bipedRightArm.rotateAngleZ = 0.0F;
            	this.bipedLeftArm.rotateAngleX = 0F;
            	this.bipedLeftArm.rotateAngleY = 0.0F;
            	this.bipedLeftArm.rotateAngleZ = 0.0F;
            	this.bipedRightLeg.rotateAngleX = 0.0F;
            	this.bipedRightLeg.rotateAngleY = 0.0F;
            	this.bipedRightLeg.rotateAngleZ = 0.0F;
            	this.bipedLeftLeg.rotateAngleX = 0.0F;
            	this.bipedLeftLeg.rotateAngleY = 0.0F;
            	this.bipedLeftLeg.rotateAngleZ = 0.0F;
            	this.bipedHead.rotateAngleX = -1.5F;
            	  copyModelAngles(this.bipedHead, this.bipedHeadwear);
        	}*/
        }
        /*if (waspcap.isFlying() && waspcap.isSmall()) {
        	this.bipedRightArm.rotateAngleX = 0.0F;
        	this.bipedRightArm.rotateAngleY = 0.0F;
        	this.bipedRightArm.rotateAngleZ = 0.0F;
        	this.bipedLeftArm.rotateAngleX = 0.0F;
        	this.bipedLeftArm.rotateAngleY = 0.0F;
        	this.bipedLeftArm.rotateAngleZ = 0.0F;
        	this.bipedRightLeg.rotateAngleX = 0.0F;
        	this.bipedRightLeg.rotateAngleY = 0.0F;
        	this.bipedRightLeg.rotateAngleZ = 0.0F;
        	this.bipedLeftLeg.rotateAngleX = 0.0F;
        	this.bipedLeftLeg.rotateAngleY = 0.0F;
        	this.bipedLeftLeg.rotateAngleZ = 0.0F;
        }*/
       /* if (supercap.isFlying() && supercap.getFlyTicks() != 0) {
        	this.bipedRightArm.rotateAngleX = -3F;
        	this.bipedRightArm.rotateAngleY = 0.0F;
        	this.bipedRightArm.rotateAngleZ = 0.0F;
        	this.bipedLeftArm.rotateAngleX = -3F;
        	this.bipedLeftArm.rotateAngleY = 0.0F;
        	this.bipedLeftArm.rotateAngleZ = 0.0F;
        	this.bipedRightLeg.rotateAngleX = 0.0F;
        	this.bipedRightLeg.rotateAngleY = 0.0F;
        	this.bipedRightLeg.rotateAngleZ = 0.0F;
        	this.bipedLeftLeg.rotateAngleX = 0.0F;
        	this.bipedLeftLeg.rotateAngleY = 0.0F;
        	this.bipedLeftLeg.rotateAngleZ = 0.0F;
        	this.bipedHead.rotateAngleX = -1.5F;
        	  copyModelAngles(this.bipedHead, this.bipedHeadwear);
        }
        if (batcap.isGliding()) {
        	this.bipedRightArm.rotateAngleX = 0.0F;
        	this.bipedRightArm.rotateAngleY = 0.0F;
        	this.bipedRightArm.rotateAngleZ = 1.2F;
        	this.bipedLeftArm.rotateAngleX = 0.0F;
        	this.bipedLeftArm.rotateAngleY = 0.0F;
        	this.bipedLeftArm.rotateAngleZ = -1.2F;
        	this.bipedRightLeg.rotateAngleX = 0.0F;
        	this.bipedRightLeg.rotateAngleY = 0.0F;
        	this.bipedRightLeg.rotateAngleZ = 0.0F;
        	this.bipedLeftLeg.rotateAngleX = 0.0F;
        	this.bipedLeftLeg.rotateAngleY = 0.0F;
        	this.bipedLeftLeg.rotateAngleZ = 0.0F;
        	
        }*/
    	/*if (waspcap.areBlastersActive()) {
    	if (waspcap.shotFromRightArm()) {
    		this.bipedRightArm.rotateAngleY = this.bipedHead.rotateAngleY;
           	this.bipedRightArm.rotateAngleZ = 0F;
         	this.bipedRightArm.rotateAngleX = -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
         	
    	}
    	if (waspcap.shotFromLeftArm()) {
        	this.bipedLeftArm.rotateAngleZ = 0F;
           	this.bipedLeftArm.rotateAngleY = this.bipedHead.rotateAngleY;
        	
           	this.bipedLeftArm.rotateAngleX =  -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
           	this.bipedRightArm.rotateAngleY = 0F;
           	this.bipedRightArm.rotateAngleZ = 0F;
         	this.bipedRightArm.rotateAngleX = 0F;
       
        		}
    	}*/
        if (ItemIronmanMark50Armor.isWearingFullSet((EntityPlayer) entity, ModItems.IronManMk50Helmet,  ModItems.IronManMk50Chest,  ModItems.IronManMk50Legs,  ModItems.IronManMk50Boots)) {
        
        	if (!entity.onGround) {
        			Vec3d vec3d = entity.getLookVec();
        			double d0 = entity.motionX * entity.motionX + entity.motionZ * entity.motionZ;
                    double d1 = vec3d.x * vec3d.x + vec3d.z * vec3d.z;
              
                
                  
        		
        	}
        	
        	
        	
        	if (ironmancap.areKnockbackFistsActivated()) {
        	 	this.bipedLeftArm.rotateAngleZ = 0F;
               	this.bipedLeftArm.rotateAngleY = this.bipedHead.rotateAngleY;
            	this.bipedRightArm.rotateAngleY = this.bipedHead.rotateAngleY;
               	this.bipedRightArm.rotateAngleZ = 0F;
               	this.bipedLeftArm.rotateAngleX =  -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
               	this.bipedRightArm.rotateAngleX = -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
        	}
        	if (ironmancap.isJetThrusterActivated()) {
        		this.bipedLeftLeg.rotateAngleX = 0F;
        		this.bipedRightLeg.rotateAngleX = 0F;
        	}
        	/*
        	if (ironmancap.isFlight()) {
        		this.bipedRightArm.rotateAngleX = 0F;
        		this.bipedLeftArm.rotateAngleX = 0F;
        		this.bipedRightArm.rotateAngleY = 0F;
        		this.bipedLeftArm.rotateAngleY = 0F;
        		this.bipedRightArm.rotateAngleZ = 0F;
        		this.bipedLeftArm.rotateAngleZ = 0F;
        		this.bipedRightLeg.rotateAngleX = 0F;
        		this.bipedLeftLeg.rotateAngleX = 0F;
        		this.bipedHead.rotateAngleX = -1.5F;
        		copyModelAngles(this.bipedHead, this.bipedHeadwear);
        	}
         	if (ironmancap.isShieldActivated()) {
        		this.bipedRightArm.rotateAngleY = this.bipedHead.rotateAngleY -0.2F;
        		this.bipedRightArm.rotateAngleX = -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
        		this.bipedRightArm.rotateAngleZ = 0.0F;
        	} */
         	if (ironmancap.areCannonsActivated()) {
         		this.bipedLeftArm.rotateAngleZ = 0F;
               	this.bipedLeftArm.rotateAngleY = 0.0F;
            	this.bipedRightArm.rotateAngleY = 0.0F;
               	this.bipedRightArm.rotateAngleZ = 0F;
               	this.bipedLeftArm.rotateAngleX =  -1.6F;
               	this.bipedRightArm.rotateAngleX = -1.6F;
         
         	}
        	if (ironmancap.repulsorsActivated()) {
        		if (ironmancap.shotFromRightArm()) {
        			this.bipedRightArm.rotateAngleY = this.bipedHead.rotateAngleY;
                   	this.bipedRightArm.rotateAngleZ = 0F;
                 	this.bipedRightArm.rotateAngleX = -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
                 	 copyModelAngles(this.bipedRightArm, this.bipedRightArmwear);
                     copyModelAngles(this.bipedHead, this.bipedHeadwear);
        		}
        		if (ironmancap.shotFromLeftArm()) {
        	this.bipedLeftArm.rotateAngleZ = 0F;
           	this.bipedLeftArm.rotateAngleY = this.bipedHead.rotateAngleY;
        	
           	this.bipedLeftArm.rotateAngleX =  -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
          
           	copyModelAngles(this.bipedLeftArm, this.bipedLeftArmwear);
         
            copyModelAngles(this.bipedHead, this.bipedHeadwear);
        		}
        	}
        }
        	
        } else if (entity instanceof EntityArmorStand) {
        
        	this.bipedHeadwear.showModel = false;
        	this.bipedBodyWear.showModel = false;
        	this.bipedRightArmwear.showModel = false;
        	this.bipedLeftArmwear.showModel = false;
        	this.bipedRightLegwear.showModel = false;
        	this.bipedLeftLegwear.showModel = false;
        	this.bipedHead.rotateAngleY = 0;
        	this.bipedRightArm.rotateAngleX = 0;
        	this.bipedLeftArm.rotateAngleX = 0;
        	this.bipedRightArm.rotateAngleZ = 0;
        	this.bipedLeftArm.rotateAngleZ = 0;
        }
        /*if (ItemDoctorStrangeArmor.isWearingFullSet(Minecraft.getMinecraft().thePlayer, ModItems.DoctorStrangeRobe, ModItems.DoctorStrangeLeggings, ModItems.DoctorStrangeBoots)) {
        	IDoctorStrange docstrangecap = Minecraft.getMinecraft().thePlayer.getCapability(DoctorStrangeProvider.DOCTORSTRANGE_CAP, null);
        	if (docstrangecap.EyeofAgamottoInProgress()) {
        		this.bipedLeftArm.rotateAngleZ = 0F;
               	this.bipedLeftArm.rotateAngleY = this.bipedHead.rotateAngleY + 0.5F;
            	this.bipedRightArm.rotateAngleY = this.bipedHead.rotateAngleY;
               	this.bipedRightArm.rotateAngleZ = 0F;
               	this.bipedLeftArm.rotateAngleX =  -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
               	this.bipedRightArm.rotateAngleX = -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
               	copyModelAngles(this.bipedLeftArm, this.bipedLeftArmwear);
                copyModelAngles(this.bipedRightArm, this.bipedRightArmwear);
                copyModelAngles(this.bipedHead, this.bipedHeadwear);
        	}
        	if(Keyboard.isKeyDown(Keyboard.KEY_C)) {
           	this.bipedLeftArm.rotateAngleZ = 0F;
           	this.bipedLeftArm.rotateAngleY = this.bipedHead.rotateAngleY;
        	this.bipedRightArm.rotateAngleY = this.bipedHead.rotateAngleY;
           	this.bipedRightArm.rotateAngleZ = 0F;
           	this.bipedLeftArm.rotateAngleX =  -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
           	this.bipedRightArm.rotateAngleX = -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
           	copyModelAngles(this.bipedLeftArm, this.bipedLeftArmwear);
            copyModelAngles(this.bipedRightArm, this.bipedRightArmwear);
            copyModelAngles(this.bipedHead, this.bipedHeadwear);
           	 
            }
        	if(Keyboard.isKeyDown(Keyboard.KEY_X)) {
        		this.bipedLeftArm.rotateAngleZ = 0F;
               	this.bipedLeftArm.rotateAngleY = this.bipedHead.rotateAngleY;
            	this.bipedRightArm.rotateAngleY = 0F;
               	this.bipedRightArm.rotateAngleZ = 0F;
               	this.bipedLeftArm.rotateAngleX =  -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
               	this.bipedRightArm.rotateAngleX = -1.5F;
        		copyModelAngles(this.bipedLeftArm, this.bipedLeftArmwear);
                copyModelAngles(this.bipedRightArm, this.bipedRightArmwear);
                copyModelAngles(this.bipedHead, this.bipedHeadwear);
        	}
        	if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
        		if (Minecraft.getMinecraft().thePlayer.isAirBorne) {
        			this.bipedLeftArm.rotateAngleX = 0.5F;
        			this.bipedRightArm.rotateAngleX = 0.5F;
        			this.bipedLeftLeg.rotateAngleX = 0.2F;
        			this.bipedRightLeg.rotateAngleX = 0.2F;
        			this.bipedLeftArm.rotateAngleY = 0.5F;
        			this.bipedRightArm.rotateAngleY = -0.5F;
        			this.bipedLeftLeg.rotateAngleY = 0.5F;
        			this.bipedRightLeg.rotateAngleY = -0.5F;
        			copyModelAngles(this.bipedLeftArm, this.bipedLeftArmwear);
                    copyModelAngles(this.bipedRightArm, this.bipedRightArmwear);
                    copyModelAngles(this.bipedLeftLeg, this.bipedLeftLegwear);
                    copyModelAngles(this.bipedRightLeg, this.bipedRightLegwear);
        		}
        		
        	}
        	
        }*/
        if (entity.isSneaking())
        {
            this.bipedCape.rotationPointY = 2.0F;
        }
        else
        {
            this.bipedCape.rotationPointY = 0.0F;
        }
    }

    public void setVisible(boolean visible)
    {
        super.setVisible(visible);
        this.bipedLeftArmwear.showModel = visible;
        this.bipedRightArmwear.showModel = visible;
        this.bipedLeftLegwear.showModel = visible;
        this.bipedRightLegwear.showModel = visible;
        this.bipedBodyWear.showModel = visible;
        this.bipedCape.showModel = visible;
        this.bipedDeadmau5Head.showModel = visible;
    }

    public void postRenderArm(float scale, EnumHandSide side)
    {
        ModelRenderer modelrenderer = this.getArmForSide(side);

       
            modelrenderer.postRender(scale);
        
    }
}
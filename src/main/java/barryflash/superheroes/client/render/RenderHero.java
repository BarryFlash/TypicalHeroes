package barryflash.superheroes.client.render;

import barryflash.superheroes.capabilities.BatmanProvider;
import barryflash.superheroes.capabilities.CyborgProvider;
import barryflash.superheroes.capabilities.HulkProvider;
import barryflash.superheroes.capabilities.IBatman;
import barryflash.superheroes.capabilities.ICyborg;
import barryflash.superheroes.capabilities.IHulk;
import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IShazam;
import barryflash.superheroes.capabilities.ISuperman;
import barryflash.superheroes.capabilities.IThor;
import barryflash.superheroes.capabilities.IWasp;
import barryflash.superheroes.capabilities.IZod;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.capabilities.ShazamProvider;
import barryflash.superheroes.capabilities.SupermanProvider;
import barryflash.superheroes.capabilities.ThorProvider;
import barryflash.superheroes.capabilities.WaspProvider;
import barryflash.superheroes.capabilities.ZodProvider;
import barryflash.superheroes.client.render.layers.DoctorStrangeCapeHeadLayer;
import barryflash.superheroes.client.render.layers.DoctorStrangeCapeLayer;
import barryflash.superheroes.client.render.layers.DoctorStrangeEyeMagicLayer;
import barryflash.superheroes.client.render.layers.DoctorStrangeEyeOnLayer;
import barryflash.superheroes.client.render.layers.DoctorStrangeShieldsLayer;
import barryflash.superheroes.client.render.layers.LayerCustomHeldItem;
import barryflash.superheroes.client.render.layers.RenderAquamanLayer;
import barryflash.superheroes.client.render.layers.RenderBatmanCapeLayer;
import barryflash.superheroes.client.render.layers.RenderBatmanLayer;
import barryflash.superheroes.client.render.layers.RenderBlackWidowLayer;
import barryflash.superheroes.client.render.layers.RenderCaptainAmericaLayer;
import barryflash.superheroes.client.render.layers.RenderCustomArmorLayer;
import barryflash.superheroes.client.render.layers.RenderCyborgLayer;
import barryflash.superheroes.client.render.layers.RenderGeneralZodLayer;
import barryflash.superheroes.client.render.layers.RenderIronManShieldLayer;
import barryflash.superheroes.client.render.layers.RenderLokiLayer;
import barryflash.superheroes.client.render.layers.RenderQuiverLayer;
import barryflash.superheroes.client.render.layers.RenderShazamLayer;
import barryflash.superheroes.client.render.layers.RenderSupermanLayer;
import barryflash.superheroes.client.render.layers.RenderThanosGauntletLayer;
import barryflash.superheroes.client.render.layers.RenderThorLayer;
import barryflash.superheroes.client.render.layers.RenderWonderWomanLayer;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemHulkArmor;
import barryflash.superheroes.items.armor.ItemIronmanMark50ArcReactorArmor;
import barryflash.superheroes.items.armor.ItemShazamArmor;
import barryflash.superheroes.items.armor.ItemSupermanArmor;
import barryflash.superheroes.items.armor.ItemThorArmor;
import barryflash.superheroes.models.ModelHero;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerArrow;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
 
@SideOnly(Side.CLIENT)
public class RenderHero extends RenderLivingBase {
 
 
	 private final float shadowSize;

	    
	    public RenderHero(RenderManager renderManager, ModelBase model, float shadowSize)
	    {
	        super(renderManager, model, shadowSize);
	        this.shadowSize = shadowSize;
	        this.mainModel = model;
	        this.addLayer(new LayerBipedArmor(this));
	        this.addLayer(new LayerCustomHeldItem(this));
	        this.addLayer(new LayerArrow(this)); 
	        this.addLayer(new DoctorStrangeCapeLayer());
	        this.addLayer(new DoctorStrangeCapeHeadLayer());
	        this.addLayer(new DoctorStrangeShieldsLayer(this));
	        this.addLayer(new DoctorStrangeEyeMagicLayer(this));
	        this.addLayer(new DoctorStrangeEyeOnLayer());
	        this.addLayer(new RenderIronManShieldLayer(this));
	        this.addLayer(new RenderCustomArmorLayer(this));
	        this.addLayer(new RenderThanosGauntletLayer(this));
	        this.addLayer(new RenderThorLayer());
	        this.addLayer(new RenderAquamanLayer(this));
	        //this.addLayer(new RenderWaspLayer(this));
	        //this.addLayer(new RenderAntmanLayer(this));
	        this.addLayer(new RenderBatmanCapeLayer());
	        this.addLayer(new RenderBatmanLayer(this));
	        this.addLayer(new RenderSupermanLayer());
	        this.addLayer(new RenderWonderWomanLayer(this));
	        this.addLayer(new RenderShazamLayer(this));
	        this.addLayer(new RenderCaptainAmericaLayer(this));
	        this.addLayer(new RenderBlackWidowLayer(this));
	        this.addLayer(new RenderQuiverLayer(this));
	        this.addLayer(new RenderLokiLayer());
	        this.addLayer(new RenderGeneralZodLayer());
	        this.addLayer(new RenderCyborgLayer(this));
	    }
    
 
	    public void doRender(AbstractClientPlayer entity, double x, double y, double z, float entityYaw, float partialTicks)
	    {

	        if (!entity.isUser() || this.renderManager.renderViewEntity == entity)

        
	        {
	            double d0 = y;

	            if (entity.isSneaking() && !(entity instanceof EntityPlayerSP))
	            {
	                d0 = y - 0.125D;
	            }
	           
	            
	                
	            	
	            this.setModelVisibilities(entity);

	            super.doRender(entity, x, d0, z, entityYaw, partialTicks);
	      
	           
	        }
	        
	    }

     private void setModelVisibilities(AbstractClientPlayer clientPlayer)
     {
         ModelHero modelplayer =  (ModelHero) this.getMainModel();
 
         if (clientPlayer.isSpectator())
         {
             modelplayer.setVisible(false);
             modelplayer.bipedHead.showModel = true;
             modelplayer.bipedHeadwear.showModel = true;
         }
         else
         {
        	 IShazam shazamcap = clientPlayer.getCapability(ShazamProvider.SHAZAM_CAP, null);
        	 IHulk hulkcap = clientPlayer.getCapability(HulkProvider.HULK_CAP, null);
             ItemStack itemstack = clientPlayer.getHeldItemMainhand();
             ItemStack itemstack1 = clientPlayer.getHeldItemOffhand();
             modelplayer.setVisible(true);
             if ((ItemShazamArmor.isWearingShazam(clientPlayer) && !shazamcap.isShazam()) || (ItemHulkArmor.isWearingHulk(clientPlayer))) {
              modelplayer.bipedHeadwear.showModel = true;
           	  modelplayer.bipedRightArmwear.showModel = true;
           	  modelplayer.bipedLeftArmwear.showModel = true;
           	  modelplayer.bipedRightLegwear.showModel = true;
           	  modelplayer.bipedLeftLegwear.showModel = true;
           	  modelplayer.bipedBodyWear.showModel = true;
             } else
             if (ItemSupermanArmor.isWearingFullSet(clientPlayer, ModItems.SupermanChest, ModItems.SupermanLeggings, ModItems.SupermanBoots) || (ItemShazamArmor.isWearingShazam(clientPlayer) && shazamcap.isShazam()) || ItemThorArmor.isWearingFullSet(clientPlayer)) {
             modelplayer.bipedHeadwear.showModel = true;
             modelplayer.bipedBodyWear.showModel = false;
             modelplayer.bipedLeftLegwear.showModel = false;
             modelplayer.bipedRightLegwear.showModel = false;
             modelplayer.bipedLeftArmwear.showModel = false;
             modelplayer.bipedRightArmwear.showModel = false;
             } else if (ItemIronmanMark50ArcReactorArmor.isWearingReactor(clientPlayer, ModItems.IronManArcReactor)){
            	  modelplayer.bipedHeadwear.showModel = true;
            	  modelplayer.bipedRightArmwear.showModel = true;
            	  modelplayer.bipedLeftArmwear.showModel = true;
            	  modelplayer.bipedRightLegwear.showModel = true;
            	  modelplayer.bipedLeftLegwear.showModel = true;
            	  modelplayer.bipedBodyWear.showModel = false;
             } else {
            	  modelplayer.bipedHeadwear.showModel = false;
            	 modelplayer.bipedBodyWear.showModel = false;
                 modelplayer.bipedLeftLegwear.showModel = false;
                 modelplayer.bipedRightLegwear.showModel = false;
                 modelplayer.bipedLeftArmwear.showModel = false;
                 modelplayer.bipedRightArmwear.showModel = false;
             }
            
             modelplayer.isSneak = clientPlayer.isSneaking();
             ModelBiped.ArmPose modelbiped$armpose = ModelBiped.ArmPose.EMPTY;
             ModelBiped.ArmPose modelbiped$armpose1 = ModelBiped.ArmPose.EMPTY;
            /* if (ItemHulkArmor.isWearingFullSet(clientPlayer, ModItems.HulkHead, ModItems.HulkChest, ModItems.HulkPants, ModItems.HulkFeet)) {
                 
                 modelplayer.setInvisible(false);
                 modelplayer.bipedRightArm.showModel = true;
                 modelplayer.bipedRightArmwear.showModel = true;
                 modelplayer.bipedBody.showModel = false;
                 modelplayer.bipedBodyWear.showModel = false;
             }*/
             if (!itemstack.isEmpty())
             {
                 modelbiped$armpose = ModelBiped.ArmPose.ITEM;

                 if (clientPlayer.getItemInUseCount() > 0)
                 {
                     EnumAction enumaction = itemstack.getItemUseAction();

                     if (enumaction == EnumAction.BLOCK)
                     {
                         modelbiped$armpose = ModelBiped.ArmPose.BLOCK;
                     }
                     else if (enumaction == EnumAction.BOW)
                     {
                         modelbiped$armpose = ModelBiped.ArmPose.BOW_AND_ARROW;
                     }
                 }
             }

             if (!itemstack1.isEmpty())
             {
                 modelbiped$armpose1 = ModelBiped.ArmPose.ITEM;

                 if (clientPlayer.getItemInUseCount() > 0)
                 {
                     EnumAction enumaction1 = itemstack1.getItemUseAction();

                     if (enumaction1 == EnumAction.BLOCK)
                     {
                         modelbiped$armpose1 = ModelBiped.ArmPose.BLOCK;
                     }
                     // FORGE: fix MC-88356 allow offhand to use bow and arrow animation
                     else if (enumaction1 == EnumAction.BOW)
                     {
                         modelbiped$armpose1 = ModelBiped.ArmPose.BOW_AND_ARROW;
                     }
                 }
             }

             if (clientPlayer.getPrimaryHand() == EnumHandSide.RIGHT)
             {
                 modelplayer.rightArmPose = modelbiped$armpose;
                 modelplayer.leftArmPose = modelbiped$armpose1;
             }
             else
             {
                 modelplayer.rightArmPose = modelbiped$armpose1;
                 modelplayer.leftArmPose = modelbiped$armpose;
             }
            
         }
     }

  
   
     public void transformHeldFull3DItemLayer()
     {
         GlStateManager.translate(0.0F, 0.1875F, 0.0F);
     }

   
     protected void preRenderCallback(AbstractClientPlayer entitylivingbaseIn, float partialTickTime)
     {
         float f = 0.9375F;
         GlStateManager.scale(0.9375F, 0.9375F, 0.9375F);
         
     }

     protected void renderEntityName(AbstractClientPlayer entityIn, double x, double y, double z, String name, double distanceSq)
     {
         if (distanceSq < 100.0D)
         {
             Scoreboard scoreboard = entityIn.getWorldScoreboard();
             ScoreObjective scoreobjective = scoreboard.getObjectiveInDisplaySlot(2);

             if (scoreobjective != null)
             {
                 Score score = scoreboard.getOrCreateScore(entityIn.getName(), scoreobjective);
                 this.renderLivingLabel(entityIn, score.getScorePoints() + " " + scoreobjective.getDisplayName(), x, y, z, 64);
                 y += (double)((float)this.getFontRendererFromRenderManager().FONT_HEIGHT * 1.15F * 0.025F);
             }
         }

         super.renderEntityName(entityIn, x, y, z, name, distanceSq);
     }

     public void renderRightArm(AbstractClientPlayer clientPlayer)
     {
         float f = 1.0F;
         GlStateManager.color(1.0F, 1.0F, 1.0F);
         float f1 = 0.0625F;
         ModelHero modelplayer = (ModelHero) this.getMainModel();
         this.setModelVisibilities(clientPlayer);
         GlStateManager.enableBlend();
         modelplayer.swingProgress = 0.0F;
         modelplayer.isSneak = false;
         modelplayer.setRotationAngles(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, clientPlayer);
         modelplayer.bipedRightArm.rotateAngleX = 0.0F;
         modelplayer.bipedRightArm.render(0.0625F);
         modelplayer.bipedRightArmwear.rotateAngleX = 0.0F;
         modelplayer.bipedRightArmwear.render(0.0625F);
         GlStateManager.disableBlend();
     }

     public void renderLeftArm(AbstractClientPlayer clientPlayer)
     {
         float f = 1.0F;
         GlStateManager.color(1.0F, 1.0F, 1.0F);
         float f1 = 0.0625F;
         ModelHero modelplayer = (ModelHero) this.getMainModel();
         this.setModelVisibilities(clientPlayer);
         GlStateManager.enableBlend();
         modelplayer.isSneak = false;
         modelplayer.swingProgress = 0.0F;
         modelplayer.setRotationAngles(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, clientPlayer);
         
         modelplayer.bipedLeftArm.rotateAngleX = 0.0F;
         modelplayer.bipedLeftArm.render(0.0625F);
         modelplayer.bipedLeftArmwear.rotateAngleX = 0.0F;
         modelplayer.bipedLeftArmwear.render(0.0625F);
         GlStateManager.disableBlend();
     }


     protected void renderLivingAt(AbstractClientPlayer entityLivingBaseIn, double x, double y, double z)
     {
         if (entityLivingBaseIn.isEntityAlive() && entityLivingBaseIn.isPlayerSleeping())
         {
             super.renderLivingAt(entityLivingBaseIn, x + (double)entityLivingBaseIn.renderOffsetX, y + (double)entityLivingBaseIn.renderOffsetY, z + (double)entityLivingBaseIn.renderOffsetZ);
         }
         else
         {
             super.renderLivingAt(entityLivingBaseIn, x, y, z);
         }
     }
     private int ironmanTick = 0;
    @Override
    protected void applyRotations(EntityLivingBase entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
    	 IWasp waspcap = entityLiving.getCapability(WaspProvider.WASP_CAP, null);
    	 IBatman batcap = entityLiving.getCapability(BatmanProvider.BATMAN_CAP, null);
    	 ISuperman supercap = entityLiving.getCapability(SupermanProvider.SUPERMAN_CAP, null);
    	 IIronman ironmancap = entityLiving.getCapability(IronmanProvider.IRONMAN_CAP, null);
    	 ICyborg cyborgcap = entityLiving.getCapability(CyborgProvider.CYBORG_CAP, null);
    	 IZod zodcap = entityLiving.getCapability(ZodProvider.ZOD_CAP, null);
 			IShazam shazamcap = entityLiving.getCapability(ShazamProvider.SHAZAM_CAP, null);
 			IThor thorcap = entityLiving.getCapability(ThorProvider.THOR_CAP, null);
    	 if (entityLiving.isEntityAlive())
         {
    		 if (entityLiving.isPlayerSleeping()) {
             GlStateManager.rotate(((EntityPlayer) entityLiving).getBedOrientationInDegrees(), 0.0F, 1.0F, 0.0F);
             GlStateManager.rotate(this.getDeathMaxRotation(entityLiving), 0.0F, 0.0F, 1.0F);
             GlStateManager.rotate(270.0F, 0.0F, 1.0F, 0.0F);
    		 }
    		/* if (shazamcap.isFlying() && shazamcap.getFlyTicks() != 0) {
    			 GlStateManager.rotate(180.0F - rotationYaw, 0.0F, 1.0F, 0.0F);
            	 
                 float f = (float)shazamcap.getFlyTicks() + partialTicks;
                 float f1 = MathHelper.clamp(f * f / 100.0F, 0.0F, 1.0F);
                 GlStateManager.rotate(f1 * (-90.0F - entityLiving.rotationPitch), 1.0F, 0.0F, 0.0F);
                 Vec3d vec3d = entityLiving.getLook(partialTicks);
                 double d0 = entityLiving.motionX * entityLiving.motionX + entityLiving.motionZ * entityLiving.motionZ;
                 double d1 = (vec3d.x * vec3d.x + vec3d.z * vec3d.z)/3;

                 if (d0 > 0.0D && d1 > 0.0D)
                 {
                     double d2 = (entityLiving.motionX * vec3d.x + entityLiving.motionZ * vec3d.z) / (Math.sqrt(d0) * Math.sqrt(d1));
                     double d3 = entityLiving.motionX * vec3d.z - entityLiving.motionZ * vec3d.x;
                  
                     
                     GlStateManager.rotate(180.0F - rotationYaw, 0.0F, -1.0F, 0.0F);
                 }
    		 }
    		 if (zodcap.isFlying() && zodcap.getFlyTicks() != 0) {
    			 GlStateManager.rotate(180.0F - rotationYaw, 0.0F, 1.0F, 0.0F);
            	 
                 float f = (float)zodcap.getFlyTicks() + partialTicks;
                 float f1 = MathHelper.clamp(f * f / 100.0F, 0.0F, 1.0F);
                 GlStateManager.rotate(f1 * (-90.0F - entityLiving.rotationPitch), 1.0F, 0.0F, 0.0F);
                 Vec3d vec3d = entityLiving.getLook(partialTicks);
                 double d0 = entityLiving.motionX * entityLiving.motionX + entityLiving.motionZ * entityLiving.motionZ;
                 double d1 = (vec3d.x * vec3d.x + vec3d.z * vec3d.z)/3;

                 if (d0 > 0.0D && d1 > 0.0D)
                 {
                     double d2 = (entityLiving.motionX * vec3d.x + entityLiving.motionZ * vec3d.z) / (Math.sqrt(d0) * Math.sqrt(d1));
                     double d3 = entityLiving.motionX * vec3d.z - entityLiving.motionZ * vec3d.x;
                  
                     
                     GlStateManager.rotate(180.0F - rotationYaw, 0.0F, -1.0F, 0.0F);
                 }
    		 }
    		 if (cyborgcap.isFlying() && cyborgcap.getFlyTick() != 0) {
    			 GlStateManager.rotate(180.0F - rotationYaw, 0.0F, 1.0F, 0.0F);
            	 
                 float f = (float)cyborgcap.getFlyTick() + partialTicks;
                 float f1 = MathHelper.clamp(f * f / 100.0F, 0.0F, 1.0F);
                 GlStateManager.rotate(f1 * (-90.0F - entityLiving.rotationPitch), 1.0F, 0.0F, 0.0F);
                 Vec3d vec3d = entityLiving.getLook(partialTicks);
                 double d0 = entityLiving.motionX * entityLiving.motionX + entityLiving.motionZ * entityLiving.motionZ;
                 double d1 = (vec3d.x * vec3d.x + vec3d.z * vec3d.z)/3;

                 if (d0 > 0.0D && d1 > 0.0D)
                 {
                     double d2 = (entityLiving.motionX * vec3d.x + entityLiving.motionZ * vec3d.z) / (Math.sqrt(d0) * Math.sqrt(d1));
                     double d3 = entityLiving.motionX * vec3d.z - entityLiving.motionZ * vec3d.x;
                  
                     
                     GlStateManager.rotate(180.0F - rotationYaw, 0.0F, -1.0F, 0.0F);
                 }
    		 }
             /*if (waspcap.isFlying() && waspcap.isSmall()) {
            	
            
            	GlStateManager.rotate(180.0F - rotationYaw, 0.0F, 1.0F, 0.0F);
            	 
                 float f = (float)waspcap.getFlyTicks() + partialTicks;
                 float f1 = MathHelper.clamp(f * f / 100.0F, 0.0F, 1.0F);
                 GlStateManager.rotate(f1 * (-90.0F - entityLiving.rotationPitch), 1.0F, 0.0F, 0.0F);
                 Vec3d vec3d = entityLiving.getLook(partialTicks);
                 double d0 = entityLiving.motionX * entityLiving.motionX + entityLiving.motionZ * entityLiving.motionZ;
                 double d1 = (vec3d.x * vec3d.x + vec3d.z * vec3d.z)/3;

                 if (d0 > 0.0D && d1 > 0.0D)
                 {
                     double d2 = (entityLiving.motionX * vec3d.x + entityLiving.motionZ * vec3d.z) / (Math.sqrt(d0) * Math.sqrt(d1));
                     double d3 = entityLiving.motionX * vec3d.z - entityLiving.motionZ * vec3d.x;
                  
                     
                     GlStateManager.rotate(180.0F - rotationYaw, 0.0F, -1.0F, 0.0F);
                 }
             }
             if (thorcap.isFlying() && thorcap.getFlyTicks() != 0) {
             	
                 
            	 GlStateManager.rotate(180.0F - rotationYaw, 0.0F, 1.0F, 0.0F);
            	 
                 float f = (float)thorcap.getFlyTicks() + partialTicks;
                 float f1 = MathHelper.clamp(f * f / 100.0F, 0.0F, 1.0F);
                 GlStateManager.rotate(f1 * (-90.0F - entityLiving.rotationPitch), 1.0F, 0.0F, 0.0F);
                 Vec3d vec3d = entityLiving.getLook(partialTicks);
                 double d0 = entityLiving.motionX * entityLiving.motionX + entityLiving.motionZ * entityLiving.motionZ;
                 double d1 = (vec3d.x * vec3d.x + vec3d.z * vec3d.z)/3;

                 if (d0 > 0.0D && d1 > 0.0D)
                 {
                     double d2 = (entityLiving.motionX * vec3d.x + entityLiving.motionZ * vec3d.z) / (Math.sqrt(d0) * Math.sqrt(d1));
                     double d3 = entityLiving.motionX * vec3d.z - entityLiving.motionZ * vec3d.x;
                  
                  
                     GlStateManager.rotate(180.0F - rotationYaw, 0.0F, -1.0F, 0.0F);
                 }
             }
             if (supercap.isFlying() && supercap.getFlyTicks() != 0) {
             	
                 
            	 GlStateManager.rotate(180.0F - rotationYaw, 0.0F, 1.0F, 0.0F);
            	 
                 float f = (float)supercap.getFlyTicks() + partialTicks;
                 float f1 = MathHelper.clamp(f * f / 100.0F, 0.0F, 1.0F);
                 GlStateManager.rotate(f1 * (-90.0F - entityLiving.rotationPitch), 1.0F, 0.0F, 0.0F);
                 Vec3d vec3d = entityLiving.getLook(partialTicks);
                 double d0 = entityLiving.motionX * entityLiving.motionX + entityLiving.motionZ * entityLiving.motionZ;
                 double d1 = (vec3d.x * vec3d.x + vec3d.z * vec3d.z)/3;

                 if (d0 > 0.0D && d1 > 0.0D)
                 {
                     double d2 = (entityLiving.motionX * vec3d.x + entityLiving.motionZ * vec3d.z) / (Math.sqrt(d0) * Math.sqrt(d1));
                     double d3 = entityLiving.motionX * vec3d.z - entityLiving.motionZ * vec3d.x;
                  
                  
                     GlStateManager.rotate(180.0F - rotationYaw, 0.0F, -1.0F, 0.0F);
                 }
             }
             if (ironmancap.isFlight()) {
             	ironmanTick++;
             
            	 GlStateManager.rotate(180.0F - rotationYaw, 0.0F, 1.0F, 0.0F);
            	 
                 float f = (float)ironmanTick + partialTicks;
                 float f1 = MathHelper.clamp(f * f / 100.0F, 0.0F, 1.0F);
                 GlStateManager.rotate(f1 * (-90.0F - entityLiving.rotationPitch), 1.0F, 0.0F, 0.0F);
                 Vec3d vec3d = entityLiving.getLook(partialTicks);
                 double d0 = entityLiving.motionX * entityLiving.motionX + entityLiving.motionZ * entityLiving.motionZ;
                 double d1 = (vec3d.x * vec3d.x + vec3d.z * vec3d.z)/3;

                 if (d0 > 0.0D && d1 > 0.0D)
                 {
                     double d2 = (entityLiving.motionX * vec3d.x + entityLiving.motionZ * vec3d.z) / (Math.sqrt(d0) * Math.sqrt(d1));
                     double d3 = entityLiving.motionX * vec3d.z - entityLiving.motionZ * vec3d.x;
                  
                  
                     GlStateManager.rotate(180.0F - rotationYaw, 0.0F, -1.0F, 0.0F);
                 }
             } else {
            	 ironmanTick = 0;
             }
             if (batcap.isGliding()) {
             	
                 
            	 GlStateManager.rotate(180.0F - rotationYaw, 0.0F, 1.0F, 0.0F);
            	 
                 float f = (float)batcap.getGlideTicks() + partialTicks;
                 float f1 = MathHelper.clamp(f * f / 100.0F, 0.0F, 1.0F);
                 GlStateManager.rotate(f1 * (-90.0F - entityLiving.rotationPitch), 1.0F, 0.0F, 0.0F);
                 Vec3d vec3d = entityLiving.getLook(partialTicks);
                 double d0 = entityLiving.motionX * entityLiving.motionX + entityLiving.motionZ * entityLiving.motionZ;
                 double d1 = (vec3d.x * vec3d.x + vec3d.z * vec3d.z)/3;

                 if (d0 > 0.0D && d1 > 0.0D)
                 {
                     double d2 = (entityLiving.motionX * vec3d.x + entityLiving.motionZ * vec3d.z) / (Math.sqrt(d0) * Math.sqrt(d1));
                     double d3 = entityLiving.motionX * vec3d.z - entityLiving.motionZ * vec3d.x;
                  
                    
                     GlStateManager.rotate(180.0F - rotationYaw, 0.0F, -1.0F, 0.0F);
                 }
             }*/
         if (entityLiving.isElytraFlying())
         {
        	
             super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
             float f = (float)entityLiving.getTicksElytraFlying() + partialTicks;
             float f1 = MathHelper.clamp(f * f / 100.0F, 0.0F, 1.0F);
             GlStateManager.rotate(f1 * (-90.0F - entityLiving.rotationPitch), 1.0F, 0.0F, 0.0F);
             Vec3d vec3d = entityLiving.getLook(partialTicks);
             double d0 = entityLiving.motionX * entityLiving.motionX + entityLiving.motionZ * entityLiving.motionZ;
             double d1 = vec3d.x * vec3d.x + vec3d.z * vec3d.z;

             if (d0 > 0.0D && d1 > 0.0D)
             {
                 double d2 = (entityLiving.motionX * vec3d.x + entityLiving.motionZ * vec3d.z) / (Math.sqrt(d0) * Math.sqrt(d1));
                 double d3 = entityLiving.motionX * vec3d.z - entityLiving.motionZ * vec3d.x;
                 GlStateManager.rotate((float)(Math.signum(d3) * Math.acos(d2)) * 180.0F / (float)Math.PI, 0.0F, 1.0F, 0.0F);
             }
         }
         
         
         else
         {
             super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
         }
         }
    }
   
     private ResourceLocation resourcelocation;
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		Minecraft mc = Minecraft.getMinecraft();

		
		return ((AbstractClientPlayer)entity).getLocationSkin();

	}
 }
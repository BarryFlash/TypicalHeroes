package barryflash.superheroes.entities;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

import barryflash.superheroes.capabilities.DoctorStrangeProvider;
import barryflash.superheroes.capabilities.IDoctorStrange;

import java.util.List;
import javax.annotation.Nullable;

import org.lwjgl.input.Keyboard;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBeg;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.client.CPacketSteerBoat;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityDoctorStrangeCape extends EntityTameable
{

	public EntityDoctorStrangeCape(World worldIn) {
		super(worldIn);
		this.aiSit = new EntityAISit(this);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0D, true));
        this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(6, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[0]));
		this.setTamed(false);
		this.setSize(0.6f, 1.5f);
		
	}
	@Override
	protected void initEntityAI() {
		
        
	}
	@Override
	protected void applyEntityAttributes() {
		// TODO Auto-generated method stub
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
	}
	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub
		super.entityInit();
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected SoundEvent getDeathSound() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected void playStepSound(BlockPos pos, Block blockIn) {
		
	}
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		// TODO Auto-generated method stub
		return EnumCreatureAttribute.UNDEAD;
	}
	private int tick;
	private int ticklater;
	@Override
	public void onLivingUpdate() {

		
		if (!this.world.isRemote)
        {
			
			
            	if (!this.isTamed()) {
                this.setTamed(true);
                this.playTameEffect(false);
                this.navigator.clearPath();
                this.setAttackTarget((EntityLivingBase)null);
                this.setHealth(20.0F);
                this.setOwnerId(Minecraft.getMinecraft().player.getUniqueID());
                this.world.setEntityState(this, (byte)7);
            	
            }
        }
		super.onLivingUpdate();
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (this.aiSit != null)
        {
            this.aiSit.setSitting(false);
        }
		return false;
	}
	
	 public void setTamed(boolean tamed)
	    {
	        super.setTamed(tamed);

	        if (tamed)
	        {
	            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
	        }
	        else
	        {
	            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
	        }


	    }
	 @Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		 
		if (this.isTamed()) {
			 if (this.isOwner(player) && !this.world.isRemote && !this.isBreedingItem(player.getActiveItemStack()))
	            {
	                this.aiSit.setSitting(!this.isSitting());
	                this.isJumping = false;
	                this.navigator.clearPath();
	                this.setAttackTarget((EntityLivingBase)null);
	                if (player.isSneaking()) {
	                	IDoctorStrange docstrangecap = Minecraft.getMinecraft().player.getCapability(DoctorStrangeProvider.DOCTORSTRANGE_CAP, null);
	                	docstrangecap.setCapeNotAlive();
	                	this.isDead = true;
	                	
	                }
	            }
		}
		return super.processInteract(player, hand);
	}
	@Override
	public void updateRidden() {
		// TODO Auto-generated method stub
		super.updateRidden();
		if(this.getRidingEntity() instanceof EntityCreature) {
			EntityCreature entityCreature = (EntityCreature) this.getRidingEntity();
			this.renderYawOffset = entityCreature.renderYawOffset;
		}
	}
	
	@Override
	public void onDeath(DamageSource cause) {
		// TODO Auto-generated method stub
		super.onDeath(cause);
	}
	@Override
	protected Item getDropItem() {
		// TODO Auto-generated method stub
		return null;
	}
	 public boolean attackEntityAsMob(Entity entityIn)
	    {
	        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));

	        if (flag)
	        {
	            this.applyEnchantments(this, entityIn);
	        }

	        return flag;
	    }
	@Override
	public boolean shouldAttackEntity(EntityLivingBase p_142018_1_, EntityLivingBase p_142018_2_) {
		if (!(p_142018_1_ instanceof EntityEnderman) && !(p_142018_1_ instanceof EntityGhast))
        {
		 if (p_142018_1_ instanceof EntityDoctorStrangeCape)
         {
			 EntityDoctorStrangeCape entitycape = (EntityDoctorStrangeCape)p_142018_1_;

             if (entitycape.isTamed() && entitycape.getOwner() == p_142018_2_)
             {
                 return false;
             }
         }
             return p_142018_1_ instanceof EntityPlayer && p_142018_2_ instanceof EntityPlayer && !((EntityPlayer)p_142018_2_).canAttackPlayer((EntityPlayer)p_142018_1_) ? false : !(p_142018_1_ instanceof EntityHorse) || !((EntityHorse)p_142018_1_).isTame();
         
        }
		 else
	        {
	            return false;
	        }
	}
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		this.setEquipmentBasedOnDifficulty(difficulty);
		this.setEnchantmentBasedOnDifficulty(difficulty);
		return livingdata;
	}
	@Override
	public float getEyeHeight() {
		// TODO Auto-generated method stub
		return 1.3F;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		// TODO Auto-generated method stub
		return null;
	}
}
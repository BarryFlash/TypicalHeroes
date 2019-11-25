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
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityDoctorStrangePortal extends EntityLiving
{
	public int portal;
	public boolean twoPortals;
	public EntityDoctorStrangePortal(World worldIn, int portalNumber) {
		super(worldIn);
		this.portal = portalNumber;
		if (this.portal > 1) {
			twoPortals = true;
		}
		
	}
	private int tickCount = 0;
	@Override
	public void onEntityUpdate() {
	// TODO Auto-generated method stub
	super.onEntityUpdate();
	++tickCount;
	float x = (float) (this.posX + 2 * Math.cos(2 * 3.141 * (tickCount / 20.0) * 0.5));
	float y = (float) (this.posY + 2 * Math.sin(2 * 3.141 * (tickCount / 20.0) * 0.5));

	this.getEntityWorld().spawnParticle(EnumParticleTypes.DRAGON_BREATH, x, y + 1, this.posZ, 0, 0, 0);
	this.motionX = 0;
	this.motionY = 0;
	this.motionZ = 0;
	}
	@Override
	public void onCollideWithPlayer(EntityPlayer player) {
		BlockPos portalPos = getPortalPosition(this.portal);
	
			player.attemptTeleport(portalPos.getX(), portalPos.getY(), portalPos.getZ());
		
	}
	public BlockPos getPortalPosition(int portalNum) {
		if (portalNum == 1) {
			return this.getPosition();
		}
		if (portalNum == 2) {
			return this.getPosition();
		}
		return null;
	}
}
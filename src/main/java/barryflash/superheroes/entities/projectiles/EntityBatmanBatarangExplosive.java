package barryflash.superheroes.entities.projectiles;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import barryflash.superheroes.capabilities.IIronman;
import barryflash.superheroes.capabilities.IronmanProvider;
import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.entities.particles.ParticleSpawnerDoctorStrangeShields;
import barryflash.superheroes.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketChangeGameState;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityBatmanBatarangExplosive extends EntityArrow {
	
	   public EntityBatmanBatarangExplosive(World worldIn)
	    {
	        super(worldIn);
	      
	    }

	    public EntityBatmanBatarangExplosive(World worldIn, double x, double y, double z)
	    {
	        super(worldIn, x, y, z);
	    }

	    public EntityBatmanBatarangExplosive(World worldIn, EntityLivingBase shooter)
	    {
	        super(worldIn, shooter);
	    }

		@Override
		protected ItemStack getArrowStack() {
			// TODO Auto-generated method stub
			return ItemStack.EMPTY;
		}
		
		public void onUpdate() {
			// TODO Auto-generated method stub
			super.onUpdate();
			if (this.inGround && !world.isRemote) {
				
				if (this.timeInGround > 40) {
					this.world.createExplosion(this, this.posX, this.posY, this.posZ, 2F, true);
					this.setDead();
				}
			}
		}
		
		protected void onHit(RayTraceResult raytraceResultIn) {
			// TODO Auto-generated method stub
			super.onHit(raytraceResultIn);
			if (raytraceResultIn.entityHit != null) {
				if (raytraceResultIn.entityHit != this.shootingEntity) {
			this.world.createExplosion(this, this.posX, this.posY, this.posZ, 2F, true);
			this.setDead();
				}
			}
			if (raytraceResultIn.typeOfHit == raytraceResultIn.typeOfHit.BLOCK) {
				this.world.playSound(this.posX, this.posY, this.posZ, THSoundHandler.BATMAN_BEEP, SoundCategory.PLAYERS, 1F, 1.0F, true);
			}
		}
}

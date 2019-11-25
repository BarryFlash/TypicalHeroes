package barryflash.superheroes.entities.projectiles;

import barryflash.superheroes.util.vec;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityBatmanGrappleHook extends EntityThrowable implements IEntityAdditionalSpawnData

{

	public Entity shootingEntity = null;

	public int shootingEntityID;

	

	private boolean firstattach = false;

	public vec thispos;

	

	public boolean righthand = true;

	

	public boolean attached = false;

	

	public double taut = 1;

	

	public boolean ignoreFrustumCheck = true;

	

	public EntityBatmanGrappleHook(World worldIn) {

		super(worldIn);

	}

	

	public EntityBatmanGrappleHook(World worldIn, EntityLivingBase shooter,

			boolean righthand) {

		super(worldIn, shooter);

		

		this.shootingEntity = shooter;

		this.shootingEntityID = this.shootingEntity.getEntityId();

		

		/*

		double x = 0.36;

		if (righthand) {x = -0.36;}

        vec pos = vec.positionvec(this);

        pos.add_ip(new vec(x, -0.175, 0.45).rotate_yaw(Math.toRadians(shooter.rotationYaw)));

        this.setPosition(pos.x, pos.y, pos.z);

        */




		

		this.righthand = righthand;

	}

	

	@Override

	public void onEntityUpdate(){

		super.onEntityUpdate();

		

		if (this.shootingEntityID == 0) { // removes ghost grappling hooks

			this.remove();

		}

		

		if (this.firstattach) {

			this.motionX = 0;

			this.motionY = 0;

			this.motionZ = 0;

			this.firstattach = false;

			super.setPosition(this.thispos.x, this.thispos.y, this.thispos.z);

		}

		

		

		

	}

		

	

	@Override

	@SideOnly(Side.CLIENT)

	public boolean isInRangeToRender3d(double x, double y, double z) {

		return true;

	}



	@Override

	@SideOnly(Side.CLIENT)

	public boolean isInRangeToRenderDist(double distance) {

		return true;

	}



	public final int RenderBoundingBoxSize = 999;

	@Override

	@SideOnly(Side.CLIENT)

	public AxisAlignedBB getRenderBoundingBox() {

		return new AxisAlignedBB(-RenderBoundingBoxSize, -RenderBoundingBoxSize, -RenderBoundingBoxSize, 

				RenderBoundingBoxSize, RenderBoundingBoxSize, RenderBoundingBoxSize);

	}



	



	public void setPosition(double x, double y, double z) {

		if (this.thispos != null) {

			x = this.thispos.x;

			y = this.thispos.y;

			z = this.thispos.z;

		}

		super.setPosition(x, y, z);

	}

	

	

	@Override

    public void writeSpawnData(ByteBuf data)

    {

	    data.writeInt(this.shootingEntity != null ? this.shootingEntity.getEntityId() : 0);

	    data.writeBoolean(this.righthand);

    }

	

	@Override

    public void readSpawnData(ByteBuf data)

    {

    	this.shootingEntityID = data.readInt();

	    this.shootingEntity = this.world.getEntityByID(this.shootingEntityID);

	    this.righthand = data.readBoolean();

    }

	

	public void remove() {

		this.setDead();

	}

	

	@Override

	public String toString() {

		return super.toString() + String.valueOf(System.identityHashCode(this)) + "]";

	}



	@Override

	protected void onImpact(RayTraceResult movingobjectposition) {

		if (!this.world.isRemote) {

			if (this.shootingEntityID != 0) {

				if (movingobjectposition.typeOfHit == RayTraceResult.Type.ENTITY) {

					// hit entity

					Entity entityhit = movingobjectposition.entityHit;

					if (entityhit == this.shootingEntity) {

						return;

					}

					

					vec playerpos = vec.positionvec(this.shootingEntity);

					vec entitypos = vec.positionvec(entityhit);

					vec yank = playerpos.sub(entitypos).mult(0.4);

					entityhit.addVelocity(yank.x, Math.min(yank.y, 2), yank.z);

					

					this.removeServer();

					return;

				}

				

				BlockPos blockpos = null;

				

				if (movingobjectposition.typeOfHit == RayTraceResult.Type.BLOCK) {

					blockpos = movingobjectposition.getBlockPos();

				}

				vec vec3 = null;

		        

		        if (movingobjectposition != null)

		        {

		            vec3 = new vec(movingobjectposition.hitVec.x, movingobjectposition.hitVec.y, movingobjectposition.hitVec.z);

		        }

		        

		        this.serverAttach(blockpos, vec3, movingobjectposition.sideHit);

			}

		}

	}

	

	public void serverAttach(BlockPos blockpos, vec pos, EnumFacing sideHit) {

		if (this.attached) {

			return;

		}

		this.attached = true;

		

		if (blockpos != null) {

			

				Block block = this.world.getBlockState(blockpos).getBlock();



			
					this.removeServer();

					return;

				

			

		}

		

		vec vec3 = vec.positionvec(this);

		vec3.add_ip(vec.motionvec(this));

		if (pos != null) {

            vec3 = pos;

            

            this.setPositionAndUpdate(vec3.x, vec3.y, vec3.z);

		}

		

		//west -x

		//north -z

		if (sideHit == EnumFacing.DOWN) {

			this.posY -= 0.3;

		} else if (sideHit == EnumFacing.WEST) {

			this.posX -= 0.05;

		} else if (sideHit == EnumFacing.NORTH) {

			this.posZ -= 0.05;

		}





		

		

        this.motionX = 0;

        this.motionY = 0;

        this.motionZ = 0;

        

        this.thispos = vec.positionvec(this);

		this.firstattach = true;


		

		this.clientAttach(this.posX, this.posY, this.posZ);

		

	}

	

	public void clientAttach(double x, double y, double z) {

		this.setAttachPos(x, y, z);

		

	

	}

	

	

	@Override

    protected float getGravityVelocity()

    {

        return 0F;

    }

	

    public float getVelocity()

    {

        return 5F;

    }



	public void removeServer() {

		this.setDead();

		this.shootingEntityID = 0;



	}

	

	



	public void setAttachPos(double x, double y, double z) {

		this.setPositionAndUpdate(x, y, z);



		this.motionX = 0;

		this.motionY = 0;

		this.motionZ = 0;

		this.firstattach = true;

		this.attached = true;

        this.thispos = new vec(x, y, z);

	}

}

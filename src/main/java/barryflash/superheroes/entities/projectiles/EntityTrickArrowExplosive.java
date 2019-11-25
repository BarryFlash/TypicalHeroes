package barryflash.superheroes.entities.projectiles;

import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.init.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityTrickArrowExplosive extends EntityTrickArrow {

	public EntityTrickArrowExplosive(World worldIn)
    {
        super(worldIn);
      
    }

    public EntityTrickArrowExplosive(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public EntityTrickArrowExplosive(World worldIn, EntityLivingBase shooter)
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
			if (!world.isRemote) {
			if (raytraceResultIn.entityHit != this.shootingEntity) {

		this.world.createExplosion(this, this.posX, this.posY, this.posZ, 2F, true);
				}
		this.setDead();
				
			}
		}
		if (raytraceResultIn.typeOfHit == raytraceResultIn.typeOfHit.BLOCK) {
			this.world.playSound(this.posX, this.posY, this.posZ, THSoundHandler.BATMAN_BEEP, SoundCategory.PLAYERS, 1F, 1.0F, true);
		}
	}
}

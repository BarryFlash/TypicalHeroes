package barryflash.superheroes.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class LassoTrapEntity extends EntityThrowable{
	

	

		public LassoTrapEntity(World worldIn)

		{

			super(worldIn);

		}



		public LassoTrapEntity(World worldIn, EntityLivingBase throwerIn)

		{

			super(worldIn, throwerIn);

		}



		public LassoTrapEntity(World worldIn, double x, double y, double z)

		{

			super(worldIn, x, y, z);

		}

		

		

		@Override

		protected void onImpact(RayTraceResult result){
			if (result.entityHit != null)
	        {
	            result.entityHit.setVelocity(0, 0, 0);
		        	}
			this.setDead();
}
	        }
		
		

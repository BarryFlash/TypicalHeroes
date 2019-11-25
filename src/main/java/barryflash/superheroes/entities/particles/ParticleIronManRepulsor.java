package barryflash.superheroes.entities.particles;

import net.minecraft.client.particle.ParticleDragonBreath;
import net.minecraft.client.particle.ParticleFlame;
import net.minecraft.client.particle.ParticleRedstone;
import net.minecraft.client.particle.ParticleSmokeLarge;
import net.minecraft.world.World;

public class ParticleIronManRepulsor extends ParticleSmokeLarge {

	 public ParticleIronManRepulsor(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, float p_i46349_8_, float p_i46349_9_, float p_i46349_10_)
	    {
	        this(worldIn, xCoordIn, yCoordIn, zCoordIn, 1.0F, p_i46349_8_, p_i46349_9_, p_i46349_10_);
	    }

	    public ParticleIronManRepulsor(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, float p_i46350_8_, float p_i46350_9_, float p_i46350_10_, float p_i46350_11_)
	    {
	        super(worldIn, xCoordIn, yCoordIn, zCoordIn, p_i46350_8_, p_i46350_9_, p_i46350_10_);
	        this.particleRed = 0.8F;
	        this.particleGreen = 0.5F;
	        this.particleBlue = 0.3F;
	        this.particleAlpha = 0.7F;
	        this.motionX = 0;
	        this.motionY = 0;
	        this.motionZ = 0;
	        
	     
	        this.particleMaxAge = 6;
	        
	        
	    }

}

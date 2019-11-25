package barryflash.superheroes.entities.particles;

import net.minecraft.client.particle.ParticleRedstone;
import net.minecraft.world.World;

public class ParticleDoctorStrangeShields extends ParticleRedstone {

	 public ParticleDoctorStrangeShields(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, float p_i46349_8_, float p_i46349_9_, float p_i46349_10_)
	    {
	        this(worldIn, xCoordIn, yCoordIn, zCoordIn, 1.0F, p_i46349_8_, p_i46349_9_, p_i46349_10_);
	    }

	    public ParticleDoctorStrangeShields(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, float p_i46350_8_, float p_i46350_9_, float p_i46350_10_, float p_i46350_11_)
	    {
	        super(worldIn, xCoordIn, yCoordIn, zCoordIn, p_i46350_8_, p_i46350_9_, p_i46350_10_, p_i46350_11_);
	        this.particleRed = 1.0F;
	        this.particleGreen = 0.5F;
	        this.particleBlue = 0.0F;

	    }

}

package barryflash.superheroes.entities.particles;

import net.minecraft.client.particle.ParticleCloud;
import net.minecraft.client.particle.ParticleDragonBreath;
import net.minecraft.client.particle.ParticleFlame;
import net.minecraft.client.particle.ParticleRedstone;
import net.minecraft.client.particle.ParticleSmokeLarge;
import net.minecraft.world.World;

public class ParticleTesseract extends ParticleCloud {

	 public ParticleTesseract(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, float p_i46349_8_, float p_i46349_9_, float p_i46349_10_)
	    {
	        this(worldIn, xCoordIn, yCoordIn, zCoordIn, 1.0F, p_i46349_8_, p_i46349_9_, p_i46349_10_);
	    }

	    public ParticleTesseract(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, float p_i46350_8_, float p_i46350_9_, float p_i46350_10_, float p_i46350_11_)
	    {
	        super(worldIn, xCoordIn, yCoordIn, zCoordIn, p_i46350_8_, p_i46350_9_, p_i46350_10_);
	        this.particleRed = 0.0F;
	        this.particleGreen = 0.6F;
	        this.particleBlue = 0.8F;
	        this.particleAlpha = 0.8F;
	        this.motionX = 0;
	        this.motionY = 0.03;
	        this.motionZ = 0;
	        
	        
	        this.particleMaxAge = 20;
	        
	        
	    }

}

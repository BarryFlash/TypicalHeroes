package barryflash.superheroes.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class LassoParticle extends Particle{

	    float reddustParticleScale;

	    

		private BufferBuilder worldRenderer;

	    

	    public LassoParticle(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, float red, float green, float blue)

	    {

	        super(worldIn, xCoordIn, yCoordIn, zCoordIn, 0.0D, 0.0D, 0.0D);

	        

	        this.particleRed = 1.0F;

	        this.particleGreen = 1.0F;

	        this.particleBlue = 1.0F;

	        this.particleAlpha = 1.0F;

	        

	        

	        this.setRBGColorF(100, 100, 100);

	        

	        this.setSize(0.2F, 0.2F);

	        this.particleScale *= this.rand.nextFloat() * 0.6F + 0.5F;

	        this.motionX *= 0.019999999552965164D;

	        this.motionY *= 0.019999999552965164D;

	        this.motionZ *= 0.019999999552965164D;

	        this.particleMaxAge = (int)(20.0D / (Math.random() * 0.8D + 0.2D));

	    }

	    

	    @Override

	    public int getFXLayer()

	    {

	      return 1;

	    }



	    @Override

	    public void onUpdate()

	    {

	        this.prevPosX = this.posX;

	        this.prevPosY = this.posY;

	        this.prevPosZ = this.posZ;

	        this.move(this.motionX, this.motionY, this.motionZ);

	        this.motionX *= 0.99D;

	        this.motionY *= 0.99D;

	        this.motionZ *= 0.99D;



	        if (this.particleMaxAge-- <= 0)

	        {

	            this.setExpired();

	        }

	    }

	}


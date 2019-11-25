package barryflash.superheroes.entities.particles;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleRedstone;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.FMLClientHandler;

public class ParticleWaspBlast extends Particle

{

	public static TextureAtlasSprite blast;

	private int particleLifetime = 4;
	private int tick;
	private float scalez = 0.4F;

  /**

   * Construct a new FlameParticle at the given [x,y,z] position with the given initial velocity.

   */

  public ParticleWaspBlast(World world, double x, double y, double z,

                       double offsetX, double offsetY, double offsetZ)

  {

    super(world, x, y, z, offsetX, offsetY, offsetZ);
    


     /// arbitrary block!  not required here since we have

    // overriden onUpdate()

    particleMaxAge = 20; // not used since we have overridden onUpdate



    final float ALPHA_VALUE = 0.69F;

    this.particleAlpha = ALPHA_VALUE;  // a value less than 1 turns on alpha blending. Otherwise, alpha blending is off

    // and the particle won't be transparent.



    //the vanilla Particle constructor added random variation to our starting velocity.  Undo it!

    motionX = offsetX;

    motionY = offsetY;

    motionZ = offsetZ;



    // set the texture to the flame texture, which we have previously added using TextureStitchEvent


    
   
    setParticleTexture(blast);
    
    
    

  }



  /**

   * Used to control what texture and lighting is used for the EntityFX.

   * Returns 1, which means "use a texture from the blocks + items texture sheet"

   * The vanilla layers are:

   * normal particles: ignores world brightness lighting map

   *   Layer 0 - uses the particles texture sheet (textures\particle\particles.png)

   *   Layer 1 - uses the blocks + items texture sheet

   * lit particles: changes brightness depending on world lighting i.e. block light + sky light

   *   Layer 3 - uses the blocks + items texture sheet (I think)

   *

   * @return

   */

  @Override

  public int getFXLayer()

  {

    return 1;

  }



  // can be used to change the brightness of the rendered Particle.

  @Override

  public int getBrightnessForRender(float partialTick)

  {

    final int FULL_BRIGHTNESS_VALUE = 0xf000f0;

    return FULL_BRIGHTNESS_VALUE;



    // if you want the brightness to be the local illumination (from block light and sky light) you can just use

    //  Entity.getBrightnessForRender() base method, which contains:

    //    BlockPos blockpos = new BlockPos(this.posX, this.posY, this.posZ);

    //    return this.worldObj.isBlockLoaded(blockpos) ? this.worldObj.getCombinedLight(blockpos, 0) : 0;

  }



  // this function is used by ParticleManager.addEffect() to determine whether depthmask writing should be on or not.

  // FlameBreathFX uses alphablending (i.e. the FX is partially transparent) but we want depthmask writing on,

  //   otherwise translucent objects (such as water) render over the top of our breath, even if the breath is in front

  //  of the water and not behind
  




  /**

   * call once per tick to update the Particle position, calculate collisions, remove when max lifetime is reached, etc

   */

  @Override

  public void onUpdate()

  {

    prevPosX = posX;

    prevPosY = posY;

    prevPosZ = posZ;


    scalez -= 0.1;
    this.move(motionX, motionY, motionZ);
    this.move(motionX - 0.5, motionY, motionZ- 0.5);// simple linear motion.  You can change speed by changing motionX, motionY,
    this.move(motionX + 0.5, motionY, motionZ+ 0.5);
    this.move(motionX - 0.5, motionY, motionZ+ 0.5);
    this.move(motionX + 0.5, motionY, motionZ- 0.5);
      // motionZ every tick.  For example - you can make the particle accelerate downwards due to gravity by

      // final double GRAVITY_ACCELERATION_PER_TICK = -0.02;

      // motionY += GRAVITY_ACCELERATION_PER_TICK;
   
    // collision with a block makes the ball disappear.  But does not collide with entities

    if (this.onGround) {  // isCollided is only true if the particle collides while it is moving downwards...

      this.setExpired();

    }



    if (prevPosY == posY && motionY > 0) {  // detect a collision while moving upwards (can't move up at all)

      this.setExpired();

    }


    this.tick = 0;
    this.tick++;
    if (this.tick > 4) {
    	this.tick = 0;
    }
    if (this.particleLifetime-- <= 0) {

      this.setExpired();

    }

  }



  /**

   * Render the Particle onto the screen.  For more help with the tessellator see

   * http://greyminecraftcoder.blogspot.co.at/2014/12/the-tessellator-and-worldrenderer-18.html

   * <p/>

   * You don't actually need to override this method, this is just a deobfuscated example of the vanilla, to show you

   * how it works in case you want to do something a bit unusual.

   * <p/>

   * The Particle is rendered as a two-dimensional object (Quad) in the world (three-dimensional coordinates).

   * The corners of the quad are chosen so that the Particle is drawn directly facing the viewer (or in other words,

   * so that the quad is always directly face-on to the screen.)

   * In order to manage this, it needs to know two direction vectors:

   * 1) the 3D vector direction corresponding to left-right on the viewer's screen (edgeLRdirection)

   * 2) the 3D vector direction corresponding to up-down on the viewer's screen (edgeUDdirection)

   * These two vectors are calculated by the caller.

   * For example, the top right corner of the quad on the viewer's screen is equal to:

   * the centre point of the quad (x,y,z)

   * plus the edgeLRdirection vector multiplied by half the quad's width

   * plus the edgeUDdirection vector multiplied by half the quad's height.

   * NB edgeLRdirectionY is not provided because it's always 0, i.e. the top of the viewer's screen is always directly

   * up, so moving left-right on the viewer's screen doesn't affect the y coordinate position in the world

   *

   * @param vertexBuffer

   * @param entity

   * @param partialTick

   * @param edgeLRdirectionX edgeLRdirection[XYZ] is the vector direction pointing left-right on the player's screen

   * @param edgeUDdirectionY edgeUDdirection[XYZ] is the vector direction pointing up-down on the player's screen

   * @param edgeLRdirectionZ edgeLRdirection[XYZ] is the vector direction pointing left-right on the player's screen

   * @param edgeUDdirectionX edgeUDdirection[XYZ] is the vector direction pointing up-down on the player's screen

   * @param edgeUDdirectionZ edgeUDdirection[XYZ] is the vector direction pointing up-down on the player's screen

   */

  @Override

  public void renderParticle(BufferBuilder vertexBuffer, Entity entity, float partialTick,

                            float edgeLRdirectionX, float edgeUDdirectionY, float edgeLRdirectionZ,

                            float edgeUDdirectionX, float edgeUDdirectionZ)

  {

    double minU = this.particleTexture.getMinU();

    double maxU = this.particleTexture.getMaxU();

    double minV = this.particleTexture.getMinV();

    double maxV = this.particleTexture.getMaxV();

    

    float scale = this.scalez;  // vanilla scaling factor

    final float scaleLR = scale;

    final float scaleUD = scale;

    double x = this.prevPosX + (this.posX - this.prevPosX) * partialTick - interpPosX;

    double y = this.prevPosY + (this.posY - this.prevPosY) * partialTick - interpPosY;

    double z = this.prevPosZ + (this.posZ - this.prevPosZ) * partialTick - interpPosZ;





    // "lightmap" changes the brightness of the particle depending on the local illumination (block light, sky light)

    //  in this example, it's held constant, but we still need to add it to each vertex anyway.

    int combinedBrightness = this.getBrightnessForRender(partialTick);

    int skyLightTimes16 = combinedBrightness >> 16 & 65535;

    int blockLightTimes16 = combinedBrightness & 65535;



    // the caller has already initiated rendering, using:

//    worldRenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);

    

    vertexBuffer.pos(x - edgeLRdirectionX * scaleLR - edgeUDdirectionX * scaleUD,

            y - edgeUDdirectionY * scaleUD,

            z - edgeLRdirectionZ * scaleLR - edgeUDdirectionZ * scaleUD)

                 .tex(maxU, maxV)

                 .color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha)

                 .lightmap(skyLightTimes16, blockLightTimes16)

                 .endVertex();

    vertexBuffer.pos(x - edgeLRdirectionX * scaleLR + edgeUDdirectionX * scaleUD,

            y + edgeUDdirectionY * scaleUD,

            z - edgeLRdirectionZ * scaleLR + edgeUDdirectionZ * scaleUD)

            .tex(maxU, minV)

            .color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha)

            .lightmap(skyLightTimes16, blockLightTimes16)

            .endVertex();

    vertexBuffer.pos(x + edgeLRdirectionX * scaleLR + edgeUDdirectionX * scaleUD,

            y + edgeUDdirectionY * scaleUD,

            z + edgeLRdirectionZ * scaleLR + edgeUDdirectionZ * scaleUD)

            .tex(minU, minV)

            .color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha)

            .lightmap(skyLightTimes16, blockLightTimes16)

            .endVertex();

    vertexBuffer.pos(x + edgeLRdirectionX * scaleLR - edgeUDdirectionX * scaleUD,

            y - edgeUDdirectionY * scaleUD,

            z + edgeLRdirectionZ * scaleLR - edgeUDdirectionZ * scaleUD)

            .tex(minU, maxV)

            .color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha)

            .lightmap(skyLightTimes16, blockLightTimes16)

            .endVertex();



  }



}

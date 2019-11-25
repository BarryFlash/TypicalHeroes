package barryflash.superheroes.entities.particles;

import javax.annotation.Nullable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;

public class ParticleSpawnerDoctorStrangeShields {

	private static Minecraft mc = Minecraft.getMinecraft();

	public static Particle spawnParticle(String particleName, double x, double y, double z, double offsetX, double offsetY, double offsetZ, @Nullable float[] color)
	{
		if (mc != null && mc.getRenderViewEntity() != null && mc.effectRenderer != null)
		 {
		 int var14 = mc.gameSettings.particleSetting;

		 if (var14 == 1 && mc.world.rand.nextInt(3) == 0)
		 {
		 var14 = 2;
		 }

		 double var15 = mc.getRenderViewEntity().posX - x;
		 double var17 = mc.getRenderViewEntity().posY - y;
		 double var19 = mc.getRenderViewEntity().posZ - z;
		 Particle var21 = null;
		 double var22 = 16.0D;

		
		  if (var14 > 1)
		 {
		 return null;
		 }
		 else
		 {
		 if (particleName.equals("doctorstrange_shields"))
		 {
		 var21 = new ParticleDoctorStrangeShields(mc.world, x, y, z, (float)offsetX, (float)offsetY, (float)offsetZ);
		 }
		 if (particleName.equals("doctorstrange_eye"))
		 {
		 var21 = new ParticleDoctorStrangeEye(mc.world, x, y, z, (float)offsetX, (float)offsetY, (float)offsetZ);
		 }
		 if (particleName.equals("ironman_repulsor"))
		 {
		 var21 = new ParticleIronManRepulsor(mc.world, x, y, z, (float)offsetX, (float)offsetY, (float)offsetZ);
		 }
		 
		 if (particleName.equals("tesseract"))
		 {
		 var21 = new ParticleTesseract(mc.world, x, y, z, (float)offsetX, (float)offsetY, (float)offsetZ);
		 }
		 if (particleName.equals("wasp"))
		 {
		 var21 = new ParticleWaspBlast(mc.world, x, y, z, offsetX, offsetY, offsetZ);
		 }
		 if (particleName.equals("wasp2"))
		 {
		 var21 = new ParticleWaspBlast2(mc.world, x, y, z, offsetX, offsetY, offsetZ);
		 }
		 if (particleName.equals("waspS"))
		 {
		 var21 = new ParticleWaspBlastSmall(mc.world, x, y, z, offsetX, offsetY, offsetZ);
		 }
		 if (particleName.equals("waspS2"))
		 {
		 var21 = new ParticleWaspBlastSmall2(mc.world, x, y, z, offsetX, offsetY, offsetZ);
		 }
		 if (particleName.equals("custom"))
		 {
			 if (color != null) {
				 var21 = new ParticleCustomColor(mc.world, x, y, z, (float)offsetX, (float)offsetY, (float)offsetZ, color);
			 }
		 }
		 mc.effectRenderer.addEffect(var21);
		 return var21;
		 }
		 }
		 return null;
		 

	}

}

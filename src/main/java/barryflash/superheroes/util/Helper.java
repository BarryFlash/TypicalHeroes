package barryflash.superheroes.util;

import barryflash.superheroes.client.particle.LassoParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.world.World;

public class Helper {
	
	public static float getArmorModelScale(EntityEquipmentSlot slot)

	{
		if (slot == EntityEquipmentSlot.HEAD)
			
		{

			return -0.6F;
			
		}

		return -1.5F;

	}
	

}

package barryflash.superheroes.armor.handler;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import barryflash.superheroes.Reference;
import barryflash.superheroes.entities.particles.ParticleSpawnerDoctorStrangeShields;
import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemDoctorStrangeArmor;
import barryflash.superheroes.models.ModelDoctorStrange;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DoctorStrangeShields {

	@SubscribeEvent
	public void onLivingAttacked(LivingAttackEvent event) {
		/*if (event.getEntity() instanceof EntityPlayer) {
			if (ItemDoctorStrangeArmor.isWearingFullSet((EntityPlayer) event.getEntity(), ModArmor.DoctorStrangeRobe, ModArmor.DoctorStrangeLeggings, ModArmor.DoctorStrangeBoots)) {
				if (Keyboard.isKeyDown(Keyboard.KEY_C)) {
			
					if (event.getEntity().getHorizontalFacing().equals(event.getEntity().getHorizontalFacing().EAST)) {				
						if (event.getSource().getDamageLocation().xCoord > event.getEntity().posX) {
							event.setCanceled(true);
						}
					}
					if (event.getEntity().getHorizontalFacing().equals(event.getEntity().getHorizontalFacing().WEST)) {				
						if (event.getSource().getDamageLocation().xCoord < event.getEntity().posX) {
							event.setCanceled(true);
						}
					}
					if (event.getEntity().getHorizontalFacing().equals(event.getEntity().getHorizontalFacing().NORTH)) {				
						if (event.getSource().getDamageLocation().zCoord < event.getEntity().posZ) {
							event.setCanceled(true);
						}
					}
					if (event.getEntity().getHorizontalFacing().equals(event.getEntity().getHorizontalFacing().SOUTH)) {				
						if (event.getSource().getDamageLocation().zCoord > event.getEntity().posZ) {
							event.setCanceled(true);
						}
					}
					if (event.isCanceled()) {
						ParticleSpawnerDoctorStrangeShields.spawnParticle("doctorstrange_shields", event.getEntity().posX + 0.7, event.getEntity().posY + 1.2, event.getEntity().posZ - 0.5, 0.0D, 0.2D, 0.0D);
						ParticleSpawnerDoctorStrangeShields.spawnParticle("doctorstrange_shields", event.getEntity().posX + 0.6, event.getEntity().posY + 1.3, event.getEntity().posZ - 0.5, 0.0D, 0.2D, 0.0D);
						ParticleSpawnerDoctorStrangeShields.spawnParticle("doctorstrange_shields", event.getEntity().posX + 0.5, event.getEntity().posY + 1.1, event.getEntity().posZ - 0.5, 0.0D, 0.2D, 0.0D);
						ParticleSpawnerDoctorStrangeShields.spawnParticle("doctorstrange_shields", event.getEntity().posX + 0.4, event.getEntity().posY + 1.2, event.getEntity().posZ - 0.5, 0.0D, 0.2D, 0.0D);
						ParticleSpawnerDoctorStrangeShields.spawnParticle("doctorstrange_shields", event.getEntity().posX + 0.3, event.getEntity().posY + 1.3, event.getEntity().posZ - 0.5, 0.0D, 0.2D, 0.0D);
						ParticleSpawnerDoctorStrangeShields.spawnParticle("doctorstrange_shields", event.getEntity().posX + 0.2, event.getEntity().posY + 1.1, event.getEntity().posZ - 0.5, 0.0D, 0.2D, 0.0D);
						
						ParticleSpawnerDoctorStrangeShields.spawnParticle("doctorstrange_shields", event.getEntity().posX + 0.5, event.getEntity().posY + 1.2, event.getEntity().posZ - 0.5, 0.0D, 0.2D, 0.0D);
						ParticleSpawnerDoctorStrangeShields.spawnParticle("doctorstrange_shields", event.getEntity().posX + 0.4, event.getEntity().posY + 1.3, event.getEntity().posZ - 0.5, 0.0D, 0.2D, 0.0D);
						ParticleSpawnerDoctorStrangeShields.spawnParticle("doctorstrange_shields", event.getEntity().posX + 0.3, event.getEntity().posY + 1.1, event.getEntity().posZ - 0.5, 0.0D, 0.2D, 0.0D);
						ParticleSpawnerDoctorStrangeShields.spawnParticle("doctorstrange_shields", event.getEntity().posX - 0.5, event.getEntity().posY + 1.2, event.getEntity().posZ - 0.5, 0.0D, 0.2D, 0.0D);
						ParticleSpawnerDoctorStrangeShields.spawnParticle("doctorstrange_shields", event.getEntity().posX - 0.4, event.getEntity().posY + 1.3, event.getEntity().posZ - 0.5, 0.0D, 0.2D, 0.0D);
						ParticleSpawnerDoctorStrangeShields.spawnParticle("doctorstrange_shields", event.getEntity().posX - 0.3, event.getEntity().posY + 1.1, event.getEntity().posZ - 0.5, 0.0D, 0.2D, 0.0D);
						System.out.println("particles");
					}
					}
				} else {
					event.setCanceled(false);
				}

		}*/
	}
}

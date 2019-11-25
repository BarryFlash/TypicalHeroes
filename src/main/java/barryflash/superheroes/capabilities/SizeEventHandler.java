package barryflash.superheroes.capabilities;

import barryflash.superheroes.entities.EntityAnt;
import barryflash.superheroes.entities.projectiles.EntityGrowDisc;
import barryflash.superheroes.entities.projectiles.EntityShrinkDisc;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SizeEventHandler {
	private int ent;
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onScaleEntities(RenderLivingEvent.Pre event) {
		Entity e = event.getEntity().world.getEntityByID(ent);
		
		if (event.getEntity() == e) {
			
		
		GlStateManager.pushMatrix();
		GlStateManager.scale(0.2F, 0.2F, 0.2F);
		GlStateManager.translate((event.getX() / 0.5F) - event.getX(), (event.getY() / 0.5F) - event.getY(), (event.getZ() / 0.5F) - event.getZ());
		if (event.getEntity().isSneaking()) {
			GlStateManager.translate(0, 0.125F / 0.5F, 0);
			GlStateManager.translate(0, -0.125F, 0);
		}
		}
		
	
	}
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onScaleEntities(RenderLivingEvent.Post event) {
		Entity e = event.getEntity().world.getEntityByID(ent);
	
		if (event.getEntity() == e ) {
			
	
		GlStateManager.popMatrix();
		
		}
		
	}
	 @SubscribeEvent
	 public void onAttackEvent(LivingAttackEvent event) {
		 if (event.getSource().getImmediateSource() instanceof EntityShrinkDisc) {
			
			
			 ent = event.getEntityLiving().getEntityId();
		 }
		 
	 }
	 public static ISize getHandler(Entity entity) {

	        if (entity.hasCapability(SizeProvider.SIZE_CAP, null))
	            return entity.getCapability(SizeProvider.SIZE_CAP, null);
	        return null;
	    }
	
}

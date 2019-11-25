package barryflash.superheroes.capabilities;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

public interface IBatman {
	
	public void setBatarang(int batarangType);
	public boolean isBatarangActive(int batarangType);
	public void resetBatarang();
	public int getActiveBatarangType();
	public boolean areBatarangs();
	public void setGliding();
	public void unsetGliding();
	public boolean isGliding();
	
	public void increaseBatarangType();
	public int ticksGliding(int tick);
	public int getGlideTicks();
	public void increaseTicksGliding();
	public void setTicksGliding(int tick);
	
	public void setBatarangCooldown();
	public void unsetBatarangCooldown();
	public boolean isBatarangCooldown();
	
	public void setBatarangExplosiveCooldown();
	public void unsetBatarangExplosiveCooldown();
	public boolean isBatarangExplosiveCooldown();
	
	public void setBatarangPoisonCooldown();
	public void unsetBatarangPoisonCooldown();
	public boolean isBatarangPoisonCooldown();
	
	public void setBatarangElectricCooldown();
	public void unsetBatarangElectricCooldown();
	public boolean isBatarangElectricCooldown();
	
	public void setSmokebombCooldown();
	public void unsetSmokebombCooldown();
	public boolean isSmokebombCooldown();
	
	public void setGrappleStartVec(Vec3d svec);
	public void setGrappleEndVec(Vec3d evec);
	public Vec3d getGrappleStartVec();
	public Vec3d getGrappleEndVec();
	public void shootGrapple();
	public void retractGrapple();
	public boolean isGrappleShot();
	public void setGrappleType(String type);
	public String getGrappleType();
	public void setGrappleEntity(Entity entity);
	public Entity getGrappleEntity();
	
	public void addEntityToList(Entity entity);
	public ArrayList<Entity> getList();
	public void clearList();
	
	public void setBatarangEntity(Entity entity);
	public Entity getBatarangEntity();
	
	public void setArmorWorn(boolean armor);
	public boolean isArmorWorn();
	
	public int getBatarangCooldown(int index);
	public void increaseBatarangCooldown(int index);
	public void setBatarangCooldown(int index, int amount);
	
	public boolean getBatarangCooldownBool(int index);
	public void setBatarangCooldownBool(int index, boolean bool);
	
	public int getMaxAmount();
}

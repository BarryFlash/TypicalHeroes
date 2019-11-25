package barryflash.superheroes.capabilities;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

public interface ISpecialEffects {

	public void setShock(boolean bool);
	public boolean isShocked();
	
	public void setShockTick(int tick);
	public void increaseShockTick();
	public void decreaseShockTick();
	public int getShockTick();
	
	public void setGrapple(boolean bool);
	public boolean isGrappled();
	
	public void addGrappleEntityToList(Entity ent);
	public void removeGrappleEntityToList(Entity ent);
	public ArrayList<Entity> getGrappleEntityList();
	public void clearGrappleEntityList();
	
	public void setTier(int tier);
	public int getTier();
	
	public void setSuitInfo(boolean bool);
	public boolean getSuitInfo();
}

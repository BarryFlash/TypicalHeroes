package barryflash.superheroes.capabilities;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

public class SpecialEffects implements ISpecialEffects {

	private boolean shock;
	private int tick;
	private boolean grapple;
	private int tier;
	private boolean suitinfo;
	private ArrayList<Entity> list = new ArrayList<Entity>();
	@Override
	public void setShock(boolean bool) {
		// TODO Auto-generated method stub
		this.shock = bool;
	}

	@Override
	public boolean isShocked() {
		// TODO Auto-generated method stub
		return shock;
	}

	@Override
	public void setShockTick(int tick) {
		// TODO Auto-generated method stub
		this.tick = tick;
	}

	@Override
	public void increaseShockTick() {
		// TODO Auto-generated method stub
		tick++;
	}

	@Override
	public void decreaseShockTick() {
		// TODO Auto-generated method stub
		tick--;
	}

	@Override
	public int getShockTick() {
		// TODO Auto-generated method stub
		return tick;
	}

	@Override
	public void setGrapple(boolean bool) {
		// TODO Auto-generated method stub
		grapple = bool;
	}

	@Override
	public boolean isGrappled() {
		// TODO Auto-generated method stub
		return grapple;
	}


	@Override
	public void addGrappleEntityToList(Entity ent) {
		// TODO Auto-generated method stub
		this.list.add(ent);
	}

	@Override
	public ArrayList<Entity> getGrappleEntityList() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public void clearGrappleEntityList() {
		// TODO Auto-generated method stub
		list.clear();
	}

	@Override
	public void removeGrappleEntityToList(Entity ent) {
		if (list.contains(ent)) {
			list.remove(ent);
		}
		
	}

	@Override
	public void setTier(int tier) {
		// TODO Auto-generated method stub
		this.tier = tier;
	}

	@Override
	public int getTier() {
		// TODO Auto-generated method stub
		return tier;
	}

	@Override
	public void setSuitInfo(boolean bool) {
		// TODO Auto-generated method stub
		suitinfo = bool;
	}

	@Override
	public boolean getSuitInfo() {
		// TODO Auto-generated method stub
		return suitinfo;
	}

}

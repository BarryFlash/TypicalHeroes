package barryflash.superheroes.capabilities;

import java.util.LinkedList;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class Flash implements IFlash {
	
	private boolean trail;
	private LinkedList<Vec3d> list = new LinkedList<Vec3d>();
	private boolean speed;
	private boolean phasing;
	private int level;
	private int still;
	private int circle;
	
	@Override
	public void setTrail(boolean trail) {
		// TODO Auto-generated method stub
		this.trail = trail;
	}

	@Override
	public boolean isTrailActive() {
		// TODO Auto-generated method stub
		return trail;
	}

	@Override
	public void addToList(Vec3d pos) {
		// TODO Auto-generated method stub
		
		list.add(pos);
		if (list.size() > 10) {
			list.removeFirst();
		}
	}

	@Override
	public LinkedList getList() {
		// TODO Auto-generated method stub
		return list;
	}

	private boolean armor;
	@Override
	public void setArmorWorn(boolean armor) {
		 this.armor = armor;
		
	}
	
	@Override
	public boolean isArmorWorn() {
		// TODO Auto-generated method stub
		return armor;
	}

	@Override
	public void setSuperSpeed(boolean speed) {
		// TODO Auto-generated method stub
		this.speed = speed;
	}

	@Override
	public boolean isInSuperSpeed() {
		// TODO Auto-generated method stub
		return speed;
	}

	@Override
	public void setPhasing(boolean phase) {
		// TODO Auto-generated method stub
		phasing = phase;
	}

	@Override
	public boolean isPhasing() {
		// TODO Auto-generated method stub
		return phasing;
	}

	@Override
	public void setSpeedLevel(int speed) {
		// TODO Auto-generated method stub
		level = speed;
	}

	@Override
	public void increaseSpeedLevel() {
		// TODO Auto-generated method stub
		level++;
	}
	
	@Override
	public void decreaseSpeedLevel() {
		// TODO Auto-generated method stub
		level--;
	}

	@Override
	public int getSpeedLevel() {
		// TODO Auto-generated method stub
		return level;
	}

	@Override
	public void clearList() {
		list.clear();
		
	}

	@Override
	public void setTicksStill(int tick) {
		// TODO Auto-generated method stub
		still = tick;
	}

	@Override
	public void increaseTicksStill() {
		// TODO Auto-generated method stub
		still++;
	}

	@Override
	public int getTicksStill() {
		// TODO Auto-generated method stub
		return still;
	}

	@Override
	public void setTicksCircle(int tick) {
		// TODO Auto-generated method stub
		circle = tick;
	}

	@Override
	public void increaseTicksCircle() {
		// TODO Auto-generated method stub
		circle++;
	}

	@Override
	public int getTicksCircle() {
		// TODO Auto-generated method stub
		return circle;
	}

}

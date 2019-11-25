package barryflash.superheroes.capabilities;

import java.util.LinkedList;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public interface IFlash {

	public void setTrail(boolean trail);
	public boolean isTrailActive();
	
	public void addToList(Vec3d pos);
	public LinkedList getList();
	public void clearList();
	
	public void setArmorWorn(boolean armor);
	public boolean isArmorWorn();
	
	public void setSuperSpeed(boolean speed);
	public boolean isInSuperSpeed();
	
	public void setPhasing(boolean phase);
	public boolean isPhasing();
	
	public void setSpeedLevel(int speed);
	public void increaseSpeedLevel();
	public void decreaseSpeedLevel();
	public int getSpeedLevel();
	
	public void setTicksStill(int tick);
	public void increaseTicksStill();
	public int getTicksStill();
	
	public void setTicksCircle(int tick);
	public void increaseTicksCircle();
	public int getTicksCircle();
	
	
}

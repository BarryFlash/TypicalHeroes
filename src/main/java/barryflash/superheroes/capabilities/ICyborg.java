package barryflash.superheroes.capabilities;

public interface ICyborg {

	public void setSonarCannon(boolean bool);
	public boolean isSonarCannon();
	
	public void setSonarTick(int tick);
	public void incrementSonarTick();
	public void decrementSonarTick();
	public int getSonarTick();
	
	public void setLaser(boolean bool);
	public boolean isLaser();
	
	public void setLaserTick(int tick);
	public void incrementLaserTick();
	public void decrementLaserTick();
	public int getLaserTick();
	
	public void setFly(boolean bool);
	public boolean isFlying();
	
	public void setFlyTick(int tick);
	public void incrementFlyTick();
	public void decrementFlyTick();
	public int getFlyTick();
	
}

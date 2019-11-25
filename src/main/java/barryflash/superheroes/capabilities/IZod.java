package barryflash.superheroes.capabilities;

public interface IZod {
	public void setFlying();
	public void unsetFlying();
	public boolean isFlying();
	public void setFlyTicks(int ticks);
	public void increaseFlyTicks();
	public void decreaseFlyTicks();
	public int getFlyTicks();
	
	public void setHeatVision();
	public void unsetHeatVision();
	public boolean isUsingHeatVision();
	
	public void setXRay();
	public void unsetXRay();
	public boolean isUsingXRay();
	
	public void setKrpyonite(boolean affected);
	public boolean isAffectedByKryptonite();
	
	public void setArmorWorn(boolean armor);
	public boolean isArmorWorn();
	
	public void setHeatVisionSoundTick(int tick);
	public void increaseHeatVisionSoundTick();
	public int getHeatVisionSoundTick();
}

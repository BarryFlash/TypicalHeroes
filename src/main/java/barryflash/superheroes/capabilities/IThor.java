package barryflash.superheroes.capabilities;

public interface IThor {

	public void setLightningBeam(boolean beam);
	public boolean isShootingLightning();
	
	public void setFly(boolean bool);
	public boolean isFlying();
	
	public void setFlyTicks(int tick);
	public void incrementFlyTicks();
	public void decrementFlyTicks();
	public int getFlyTicks();
	
	public void setSoundTicks(int tick);
	public void incrementSoundTicks();
	public void decrementSoundTicks();
	public int getSoundTicks();
}

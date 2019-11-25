package barryflash.superheroes.capabilities;

public interface IShazam {

	public void setLightning();
	public void unsetLightning();
	public boolean isLightning();
	
	public void setShazam(boolean shazam);
	public boolean isShazam();
	
	public void shootLightningBeam();
	public void stopShootingLightningBeam();
	public boolean isShootingLightningBeam();
	public void setLightningBeamCharge(int charge);
	public void decreaseLightningBeamCharge(int charge);
	public void increaseLightningBeamCharge(int charge);
	public int getLightningBeamCharge();
	
	public void setLightningBeamCooldown();
	public void unsetLightningBeamCooldown();
	public boolean isLightningBeamOnCooldown();
	
	public void setFlight(boolean flight);
	public boolean isFlying();
	
	public void setFlyTicks(int tick);
	public void incrementFlyTicks();
	public void decrementFlyTicks();
	public int getFlyTicks();
	
	public void setSoundTicks(int tick);
	public void incrementSoundTicks();
	public void decrementSoundTicks();
	public int getSoundTicks();
	
	public void setTransitionTicks(int tick);
	public void incrementTransitionTicks();
	public void decrementTransitionTicks();
	public int getTransitionTicks();
	
	public void setLightningTicks(int tick);
	public void incrementLightningTicks();
	public void decrementLightningTicks();
	public int getLightningTicks();
	
	
}

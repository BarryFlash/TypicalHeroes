package barryflash.superheroes.capabilities;

public class Shazam implements IShazam {
	private boolean lightning;
	private boolean shazam;
	private boolean beam;
	private int charge;
	private boolean cooldown;
	private int flyticks;
	private boolean fly;
	private int transitionTicks;
	private int lightningTicks;
	private int soundTicks;
	@Override
	public void setLightning() {
		// TODO Auto-generated method stub
		lightning = true;
	}

	@Override
	public void unsetLightning() {
		// TODO Auto-generated method stub
		lightning = false;
	}

	@Override
	public boolean isLightning() {
		// TODO Auto-generated method stub
		return lightning;
	}

	@Override
	public void setShazam(boolean shazam) {
		// TODO Auto-generated method stub
		this.shazam = shazam;
	}

	

	@Override
	public boolean isShazam() {
		// TODO Auto-generated method stub
		return shazam;
	}

	@Override
	public void shootLightningBeam() {
		// TODO Auto-generated method stub
		beam = true;
	}

	@Override
	public void stopShootingLightningBeam() {
		// TODO Auto-generated method stub
		beam = false;
	}

	@Override
	public boolean isShootingLightningBeam() {
		// TODO Auto-generated method stub
		return beam;
	}

	@Override
	public void setLightningBeamCharge(int charge) {
		// TODO Auto-generated method stub
		this.charge = charge;
	}

	@Override
	public void decreaseLightningBeamCharge(int charge) {
		// TODO Auto-generated method stub
		this.charge -= charge;
	}

	@Override
	public void increaseLightningBeamCharge(int charge) {
		// TODO Auto-generated method stub
		this.charge += charge;
	}

	@Override
	public int getLightningBeamCharge() {
		// TODO Auto-generated method stub
		return charge;
	}

	@Override
	public void setLightningBeamCooldown() {
		// TODO Auto-generated method stub
		cooldown = true;
	}

	@Override
	public void unsetLightningBeamCooldown() {
		// TODO Auto-generated method stub
		cooldown = false;
	}

	@Override
	public boolean isLightningBeamOnCooldown() {
		// TODO Auto-generated method stub
		return cooldown;
	}

	@Override
	public void setFlight(boolean flight) {
		// TODO Auto-generated method stub
		fly = flight;
	}

	@Override
	public boolean isFlying() {
		// TODO Auto-generated method stub
		return fly;
	}

	

	@Override
	public void setFlyTicks(int ticks) {
		flyticks = ticks;
		
	}

	@Override
	public int getFlyTicks() {
		// TODO Auto-generated method stub
		return flyticks;
	}

	@Override
	public void setTransitionTicks(int tick) {
		// TODO Auto-generated method stub
		transitionTicks = tick;
	}

	@Override
	public void incrementTransitionTicks() {
		// TODO Auto-generated method stub
		transitionTicks++;
	}

	@Override
	public void decrementTransitionTicks() {
		// TODO Auto-generated method stub
		transitionTicks--;
	}

	@Override
	public int getTransitionTicks() {
		// TODO Auto-generated method stub
		return transitionTicks;
	}

	@Override
	public void setLightningTicks(int tick) {
		// TODO Auto-generated method stub
		lightningTicks = tick;
	}

	@Override
	public void incrementLightningTicks() {
		// TODO Auto-generated method stub
		lightningTicks++;
	}

	@Override
	public void decrementLightningTicks() {
		// TODO Auto-generated method stub
		lightningTicks--;
	}

	@Override
	public int getLightningTicks() {
		// TODO Auto-generated method stub
		return lightningTicks;
	}

	@Override
	public void incrementFlyTicks() {
		// TODO Auto-generated method stub
		flyticks++;
	}

	@Override
	public void decrementFlyTicks() {
		// TODO Auto-generated method stub
		flyticks--;
	}

	@Override
	public void setSoundTicks(int tick) {
		// TODO Auto-generated method stub
		soundTicks = tick;
	}

	@Override
	public void incrementSoundTicks() {
		// TODO Auto-generated method stub
		soundTicks++;
	}

	@Override
	public void decrementSoundTicks() {
		// TODO Auto-generated method stub
		soundTicks--;
	}

	@Override
	public int getSoundTicks() {
		// TODO Auto-generated method stub
		return soundTicks;
	}
}

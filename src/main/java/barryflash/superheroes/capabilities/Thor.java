package barryflash.superheroes.capabilities;

public class Thor implements IThor{
	private boolean beam;
	private int flyTicks;
	private boolean fly;
	private int soundTicks;
	@Override
	public void setLightningBeam(boolean beam) {
		// TODO Auto-generated method stub
		this.beam = beam;
	}

	@Override
	public boolean isShootingLightning() {
		// TODO Auto-generated method stub
		return beam;
	}

	@Override
	public void setFlyTicks(int tick) {
		// TODO Auto-generated method stub
		flyTicks = tick;
	}

	@Override
	public void incrementFlyTicks() {
		// TODO Auto-generated method stub
		flyTicks++;
	}

	@Override
	public void decrementFlyTicks() {
		// TODO Auto-generated method stub
		flyTicks--;
	}

	@Override
	public int getFlyTicks() {
		// TODO Auto-generated method stub
		return flyTicks;
	}

	@Override
	public void setFly(boolean bool) {
		// TODO Auto-generated method stub
		fly = bool;
	}

	@Override
	public boolean isFlying() {
		// TODO Auto-generated method stub
		return fly;
	}

	@Override
	public void setSoundTicks(int tick) {
		// TODO Auto-generated method stub
		soundTicks = tick;
	}

	@Override
	public void incrementSoundTicks() {
		// TODO Auto-generated method stub
		soundTicks--;
	}

	@Override
	public void decrementSoundTicks() {
		// TODO Auto-generated method stub
		soundTicks++;
	}

	@Override
	public int getSoundTicks() {
		// TODO Auto-generated method stub
		return soundTicks;
	}

	
}

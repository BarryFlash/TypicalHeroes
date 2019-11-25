package barryflash.superheroes.capabilities;

public class BlackWidow implements IBlackWidow {

	private boolean blast;
	private int tick;
	private boolean blastCooldown;
	private int blastCooldownInt;
	
	@Override
	public void setShootBlaster(boolean blast) {
		// TODO Auto-generated method stub
		this.blast = blast;
	}

	@Override
	public boolean isShootingBlaster() {
		// TODO Auto-generated method stub
		return blast;
	}

	@Override
	public void setArmTick(int ticks) {
		// TODO Auto-generated method stub
		this.tick = ticks;
	}

	@Override
	public int getArmTicks() {
		// TODO Auto-generated method stub
		return tick;
	}

	@Override
	public void increaseArmTick() {
		this.tick++;
		
	}

	@Override
	public void setBlasterCooldown(boolean bool) {
		// TODO Auto-generated method stub
		this.blastCooldown = bool;
	}

	@Override
	public boolean getBlasterCooldown() {
		// TODO Auto-generated method stub
		return this.blastCooldown;
	}

	@Override
	public void setBlasterCooldownInt(int cooldown) {
		// TODO Auto-generated method stub
		this.blastCooldownInt = cooldown;
	}

	@Override
	public void increaseBlasterCooldownInt() {
		// TODO Auto-generated method stub
		this.blastCooldownInt++;
	}

	@Override
	public int getBlasterCooldownInt() {
		// TODO Auto-generated method stub
		return this.blastCooldownInt;
	}

}

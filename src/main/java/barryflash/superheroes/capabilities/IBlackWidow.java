package barryflash.superheroes.capabilities;

public interface IBlackWidow {

	public void setShootBlaster(boolean blast);
	public boolean isShootingBlaster();
	
	public void setArmTick(int ticks);
	public void increaseArmTick();
	public int getArmTicks();
	
	public void setBlasterCooldown(boolean bool);
	public boolean getBlasterCooldown();
	
	public void setBlasterCooldownInt(int cooldown);
	public void increaseBlasterCooldownInt();
	public int getBlasterCooldownInt();
}

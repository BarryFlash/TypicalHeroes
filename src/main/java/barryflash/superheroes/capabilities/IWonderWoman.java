package barryflash.superheroes.capabilities;

public interface IWonderWoman {

	public void setBracelets();
	public void unsetBracelets();
	public boolean areBraceletsActive();
	public void setBlast();
	public void unsetBlast();
	public boolean isBlast();
	public void setTiara();
	public void unsetTiara();
	public boolean isTiara();
	
	public void setBlastCooldown();
	public void unsetBlastCooldown();
	public boolean isBlastCooldown();
	
	public void setArmorWorn(boolean armor);
	public boolean isArmorWorn();
	
	public void setScale(int scale);
	public void increaseScale();
	public int getScale();
	
	public void setJump(boolean jump);
	public boolean canJump();
	
	public void setUp(boolean up);
	public boolean canUp();
	
	public void setLeapTick(int tick);
	public void increaseLeapTick();
	public int getLeapTick();
	
	public void setLTick(float tick);
	public void increaseLTick();
	public float getLTick();
	
	public void setBlastCooldown(int tick);
	public void increaseBlastCooldown();
	public int getBlastCooldown();
}

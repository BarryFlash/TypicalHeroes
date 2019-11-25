package barryflash.superheroes.capabilities;

public interface IHulk {

	public void setHulk(boolean hulk);
	public boolean isHulk();
	
	public void setTransformTick(int tick);
	public void increaseTransformTick();
	public int getTransformTick();
	
	public void setHTransformTick(int tick);
	public void increaseHTransformTick();
	public int getHTransformTick();
	
	public void setTransformation(boolean transform);
	public boolean isTransforming();
	public void setDetransforming(boolean transform);
	public boolean isDetransforming();
	public void setHumanTransformation(boolean transform);
	public boolean isHumanTransforming();
	public void setAlpha(float alpha);
	public void addAlpha(float alpha);
	public void removeAlpha(float alpha);
	public float getAlpha();
	
	public void setSize(float size);
	public void addSize(float size);
	public void removeSize(float size);
	public float getSize();
	
	public void setHAlpha(float alpha);
	public void addHAlpha(float alpha);
	public void removeHAlpha(float alpha);
	public float getHAlpha();
	
	public void setWallCliming(boolean climb);
	public boolean isWallClimbing();
	
	public void setLeap(boolean leap);
	public boolean isLeaping();
	
	public void setSmash(boolean smash);
	public boolean isSmash();
	
	public void setSmashCooldown(boolean bool);
	public boolean isSmashCooldown();
	
	public void setSmashCooldownInt(int cooldown);
	public void increaseSmashCooldownInt();
	public int getSmashCooldownInt();
	
	public void setUp(boolean bool);
	public boolean getUp();
	
	public void setLeapTick(int tick);
	public void increaseLeapTick();
	public int getLeapTick();
	
	public void setLTick(int tick);
	public void increaseLTick();
	public int getLTick();
}

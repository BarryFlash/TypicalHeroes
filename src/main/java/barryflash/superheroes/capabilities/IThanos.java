package barryflash.superheroes.capabilities;

public interface IThanos {
	
	public void setInfinityGauntlet();
	public void unsetInfinityGauntlet();
	public boolean holdingInfinityGauntlet();
	
	public void setSpaceStoneAnimationStart();
	public void setSpaceStoneAnimationEnd();
	public boolean isSpaceStoneAnimationActive();
	
	public boolean atcurrentStep(int step);
	
	public void animationStep(int step);
	
	public void setUsingSpaceStone();
	public void unsetUsingSpaceStone();
	public boolean isUsingSpaceStone();
	
	public void setUsingTimeStone();
	public void unsetUsingTimeStone();
	public boolean isUsingTimeStone();

	public void setUsingPowerStone();
	public void unsetUsingPowerStone();
	public boolean isUsingPowerStone();
	
	public void setUsingMindStone();
	public void unsetUsingMindStone();
	public boolean isUsingMindStone();
	
	public void setUsingRealityStone();
	public void unsetUsingRealityStone();
	public boolean isUsingRealityStone();
	
	public void setUsingSoulStone();
	public void unsetUsingSoulStone();
	public boolean isUsingSoulStone();
}

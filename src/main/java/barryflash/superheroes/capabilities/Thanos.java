package barryflash.superheroes.capabilities;

public class Thanos implements IThanos {
	private boolean infinitygauntlet;
	@Override
	public void setInfinityGauntlet() {
		// TODO Auto-generated method stub
		this.infinitygauntlet = true;
	}

	@Override
	public void unsetInfinityGauntlet() {
		// TODO Auto-generated method stub
		this.infinitygauntlet = false;
	}

	@Override
	public boolean holdingInfinityGauntlet() {
		// TODO Auto-generated method stub
		return this.infinitygauntlet;
	}
	private boolean spaceStoneAnimation;
	@Override
	public void setSpaceStoneAnimationStart() {
		// TODO Auto-generated method stub
		this.spaceStoneAnimation = true;
	}

	@Override
	public void setSpaceStoneAnimationEnd() {
		// TODO Auto-generated method stub
		this.spaceStoneAnimation = false;
	}

	@Override
	public boolean isSpaceStoneAnimationActive() {
		// TODO Auto-generated method stub
		return this.spaceStoneAnimation;
	}
	private int spaceStoneAnimationStep;
	@Override
	public boolean atcurrentStep(int step) {
		if (this.spaceStoneAnimationStep == step) {
		return true;
		} else return false;
	}
	@Override
	public void animationStep(int step) {
		this.spaceStoneAnimationStep = step;
		
	}
	private boolean spaceStone;
	private boolean powerStone;
	private boolean soulStone;
	private boolean timeStone;
	private boolean realityStone;
	private boolean mindStone;
	@Override
	public void setUsingSpaceStone() {
		// TODO Auto-generated method stub
		this.spaceStone = true;
	}

	@Override
	public void unsetUsingSpaceStone() {
		// TODO Auto-generated method stub
		this.spaceStone = false;
	}

	@Override
	public boolean isUsingSpaceStone() {
		// TODO Auto-generated method stub
		return this.spaceStone;
	}

	@Override
	public void setUsingTimeStone() {
		// TODO Auto-generated method stub
		this.timeStone = true;
	}

	@Override
	public void unsetUsingTimeStone() {
		// TODO Auto-generated method stub
		this.timeStone = false;
	}

	@Override
	public boolean isUsingTimeStone() {
		// TODO Auto-generated method stub
		return this.timeStone;
	}

	@Override
	public void setUsingPowerStone() {
		// TODO Auto-generated method stub
		this.powerStone = true;
	}

	@Override
	public void unsetUsingPowerStone() {
		// TODO Auto-generated method stub
		this.powerStone = false;
	}

	@Override
	public boolean isUsingPowerStone() {
		// TODO Auto-generated method stub
		return this.powerStone;
	}

	@Override
	public void setUsingMindStone() {
		// TODO Auto-generated method stub
		this.mindStone = true;
	}

	@Override
	public void unsetUsingMindStone() {
		// TODO Auto-generated method stub
		this.mindStone = false;
	}

	@Override
	public boolean isUsingMindStone() {
		// TODO Auto-generated method stub
		return this.mindStone;
	}

	@Override
	public void setUsingRealityStone() {
		// TODO Auto-generated method stub
		this.realityStone = true;
	}

	@Override
	public void unsetUsingRealityStone() {
		// TODO Auto-generated method stub
		this.realityStone = false;
	}

	@Override
	public boolean isUsingRealityStone() {
		// TODO Auto-generated method stub
		return this.realityStone;
	}

	@Override
	public void setUsingSoulStone() {
		this.soulStone = true;
		
	}

	@Override
	public void unsetUsingSoulStone() {
		// TODO Auto-generated method stub
		this.soulStone = false;
	}

	@Override
	public boolean isUsingSoulStone() {
		// TODO Auto-generated method stub
		return this.soulStone;
	}

}

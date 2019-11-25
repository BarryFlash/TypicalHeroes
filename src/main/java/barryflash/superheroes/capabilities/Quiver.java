package barryflash.superheroes.capabilities;

public class Quiver implements IQuiver {
	private boolean quiver = false;
	private int arrow = 0;
	private static int MAX_ARROWS = 4;
	private boolean[] cooldownArray = new boolean[MAX_ARROWS+1];
	private int[] cooldownAmountArray = new int[MAX_ARROWS+1];
	@Override
	public void setArrowSelected(int index) {
		// TODO Auto-generated method stub
		arrow = index;
	}

	@Override
	public void addArrowSelected(int amount) {
		// TODO Auto-generated method stub
		if (arrow + amount > MAX_ARROWS) {
			arrow = MAX_ARROWS;
		} else {
			arrow += amount;
		}
	}

	@Override
	public void subtractArrowSelected(int amount) {
		// TODO Auto-generated method stub
		if (arrow - amount < 0) {
			arrow = 0;
		} else {
			arrow -= amount;
		}
	}

	@Override
	public int getArrowSelected() {
		// TODO Auto-generated method stub
		return arrow;
	}

	@Override
	public void setCooldownBoolForArrow(int index, boolean bool) {
		// TODO Auto-generated method stub
		cooldownArray[index] = bool;
	}

	

	@Override
	public boolean isArrowInCooldown(int index) {
		// TODO Auto-generated method stub
		return cooldownArray[index];
	}

	@Override
	public void setWearingQuiver(boolean bool) {
		// TODO Auto-generated method stub
		quiver = bool;
	}

	@Override
	public boolean isWearingQuiver() {
		// TODO Auto-generated method stub
		return quiver;
	}

	@Override
	public void setCooldownForArrow(int index, int amount) {
		// TODO Auto-generated method stub
		cooldownAmountArray[index] = amount;
	}

	@Override
	public void increaseCooldownForArrow(int index) {
		// TODO Auto-generated method stub
		cooldownAmountArray[index]++;
	}

	@Override
	public int getCooldownForArrow(int index) {
		// TODO Auto-generated method stub
		return cooldownAmountArray[index];
	}

	@Override
	public int getMaxAmount() {
		// TODO Auto-generated method stub
		return MAX_ARROWS;
	}
}

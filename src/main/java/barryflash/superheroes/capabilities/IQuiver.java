package barryflash.superheroes.capabilities;

public interface IQuiver {
	public void setWearingQuiver(boolean bool);
	public boolean isWearingQuiver();
	public void setArrowSelected(int index);
	public void addArrowSelected(int amount);
	public void subtractArrowSelected(int amount);
	public int getArrowSelected();
	public void setCooldownBoolForArrow(int index, boolean bool);
	public boolean isArrowInCooldown(int index);
	public void setCooldownForArrow(int index, int amount);
	public void increaseCooldownForArrow(int index);
	public int getCooldownForArrow(int index);
	public int getMaxAmount();
}

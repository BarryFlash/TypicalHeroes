package barryflash.superheroes.capabilities;

public class CaptainAmerica implements ICaptainAmerica {
	private boolean held;

	@Override
	public void setShield(boolean held) {
		// TODO Auto-generated method stub
		this.held = held;
	}

	@Override
	public boolean isHoldingShield() {
		// TODO Auto-generated method stub
		return held;
	}

}

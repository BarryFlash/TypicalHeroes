package barryflash.superheroes.capabilities;

public class Keys implements IKeys{
	private boolean space;
	private boolean r;
	private boolean f;
	@Override
	public void setSpace(boolean bool) {
		// TODO Auto-generated method stub
		space = bool;
	}

	@Override
	public boolean isSpaceDown() {
		// TODO Auto-generated method stub
		return space;
	}

	@Override
	public void setR(boolean bool) {
		// TODO Auto-generated method stub
		r = bool;
	}

	@Override
	public boolean isRDown() {
		// TODO Auto-generated method stub
		return r;
	}

	@Override
	public void setF(boolean bool) {
		// TODO Auto-generated method stub
		f = bool;
	}

	@Override
	public boolean isFDown() {
		// TODO Auto-generated method stub
		return f;
	}

}

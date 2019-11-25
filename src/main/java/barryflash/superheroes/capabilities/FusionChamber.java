package barryflash.superheroes.capabilities;

public class FusionChamber implements IFusionChamber {

	private boolean inside;
	
	@Override
	public void setInside(boolean inside) {
		// TODO Auto-generated method stub
		this.inside = inside;
	}

	@Override
	public boolean isInside() {
		// TODO Auto-generated method stub
		return inside;
	}

}

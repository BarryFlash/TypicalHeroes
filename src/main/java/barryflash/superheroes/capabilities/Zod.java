package barryflash.superheroes.capabilities;

public class Zod implements IZod {

	private boolean fly;
	private boolean heatvision;
	private boolean kryptonite;
	private int flytick, hvtick;
	@Override
	public void setFlying() {
		// TODO Auto-generated method stub
		fly = true;
	}

	@Override
	public void unsetFlying() {
		// TODO Auto-generated method stub
		fly = false;
	}

	@Override
	public boolean isFlying() {
		// TODO Auto-generated method stub
		return fly;
	}

	
	@Override
	public void setHeatVision() {
		// TODO Auto-generated method stub
		heatvision = true;
	}

	@Override
	public void unsetHeatVision() {
		// TODO Auto-generated method stub
		heatvision = false;
	}

	@Override
	public boolean isUsingHeatVision() {
		// TODO Auto-generated method stub
		return heatvision;
	}
	private boolean xray;
	@Override
	public void setXRay() {
		// TODO Auto-generated method stub
		xray = true;
	}

	@Override
	public void unsetXRay() {
		// TODO Auto-generated method stub
		xray = false;
	}

	@Override
	public boolean isUsingXRay() {
		// TODO Auto-generated method stub
		return xray;
	}

	@Override
	public void setKrpyonite(boolean affected) {
		// TODO Auto-generated method stub
		kryptonite = affected;
	}

	@Override
	public boolean isAffectedByKryptonite() {
		// TODO Auto-generated method stub
		return kryptonite;
	}
	private boolean armor;
	@Override
	public void setArmorWorn(boolean armor) {
		 this.armor = armor;
		
	}
	
	@Override
	public boolean isArmorWorn() {
		// TODO Auto-generated method stub
		return armor;
	}

	@Override
	public void setFlyTicks(int ticks) {
		// TODO Auto-generated method stub
		flytick = ticks;
	}

	@Override
	public void increaseFlyTicks() {
		// TODO Auto-generated method stub
		flytick++;
	}

	@Override
	public int getFlyTicks() {
		// TODO Auto-generated method stub
		return flytick;
	}

	@Override
	public void decreaseFlyTicks() {
		// TODO Auto-generated method stub
		flytick--;
	}

	@Override
	public void setHeatVisionSoundTick(int tick) {
		// TODO Auto-generated method stub
		hvtick = tick;
	}

	@Override
	public void increaseHeatVisionSoundTick() {
		// TODO Auto-generated method stub
		hvtick++;
	}

	@Override
	public int getHeatVisionSoundTick() {
		// TODO Auto-generated method stub
		return hvtick;
	}
}

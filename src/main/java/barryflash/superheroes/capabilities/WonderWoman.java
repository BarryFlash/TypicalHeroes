package barryflash.superheroes.capabilities;

public class WonderWoman implements IWonderWoman {
	private boolean bracelets;
	private boolean blast;
	private boolean tiara;
	private int scale;
	private boolean leap;
	private boolean up;
	private int leapTick;
	private float ltick = -240;
	private int blastTick;
	@Override
	public void setBracelets() {
		// TODO Auto-generated method stub
		bracelets = true;
	}

	@Override
	public void unsetBracelets() {
		// TODO Auto-generated method stub
		bracelets = false;
	}

	@Override
	public boolean areBraceletsActive() {
		// TODO Auto-generated method stub
		return bracelets;
	}

	@Override
	public void setBlast() {
		// TODO Auto-generated method stub
		blast = true;
	}

	@Override
	public void unsetBlast() {
		// TODO Auto-generated method stub
		blast = false;
	}

	@Override
	public boolean isBlast() {
		// TODO Auto-generated method stub
		return blast;
	}

	@Override
	public void setTiara() {
		// TODO Auto-generated method stub
		tiara = true;
	}

	@Override
	public void unsetTiara() {
		// TODO Auto-generated method stub
		tiara = false;
	}

	@Override
	public boolean isTiara() {
		// TODO Auto-generated method stub
		return tiara;
	}
	private boolean blastCooldown;
	@Override
	public void setBlastCooldown() {
		// TODO Auto-generated method stub
		blastCooldown = true;
	}

	@Override
	public void unsetBlastCooldown() {
		// TODO Auto-generated method stub
		blastCooldown = false;
	}

	@Override
	public boolean isBlastCooldown() {
		// TODO Auto-generated method stub
		return blastCooldown;
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
	public void setScale(int scale) {
		// TODO Auto-generated method stub
		this.scale = scale;
	}

	@Override
	public void increaseScale() {
		// TODO Auto-generated method stub
		scale++;
	}

	@Override
	public int getScale() {
		// TODO Auto-generated method stub
		return scale;
	}

	@Override
	public void setJump(boolean jump) {
		// TODO Auto-generated method stub
		leap = jump;
	}

	@Override
	public boolean canJump() {
		// TODO Auto-generated method stub
		return leap;
	}

	@Override
	public void setUp(boolean up) {
		// TODO Auto-generated method stub
		this.up = up;
	}

	@Override
	public boolean canUp() {
		// TODO Auto-generated method stub
		return up;
	}

	@Override
	public void setLeapTick(int tick) {
		// TODO Auto-generated method stub
		leapTick = tick;
	}

	@Override
	public void increaseLeapTick() {
		// TODO Auto-generated method stub
		leapTick++;
	}

	@Override
	public int getLeapTick() {
		// TODO Auto-generated method stub
		return leapTick;
	}

	@Override
	public void setLTick(float tick) {
		// TODO Auto-generated method stub
		ltick = tick;
	}

	@Override
	public void increaseLTick() {
		// TODO Auto-generated method stub
		ltick++;
	}

	@Override
	public float getLTick() {
		// TODO Auto-generated method stub
		return ltick;
	}

	@Override
	public void setBlastCooldown(int tick) {
		// TODO Auto-generated method stub
		blastTick = tick;
	}

	@Override
	public void increaseBlastCooldown() {
		// TODO Auto-generated method stub
		blastTick++;
	}

	@Override
	public int getBlastCooldown() {
		// TODO Auto-generated method stub
		return blastTick;
	}
}

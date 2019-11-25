package barryflash.superheroes.capabilities;

public class Hulk implements IHulk {
	private boolean hulk;
	private boolean transformation;
	private boolean detransformation;
	private boolean htransformation;
	private float alpha;
	private float halpha;
	private float size;
	private boolean climb;
	private boolean leap;
	private boolean smash;
	private boolean smashCooldown;
	private int smashCooldownInt;
	private boolean up;
	private int leapTick;
	private int ltick = -240;
	private int transformTick, htransformTick;
	@Override
	public void setHulk(boolean hulk) {
		// TODO Auto-generated method stub
		this.hulk = hulk;
	}
	@Override
	public boolean isHulk() {
		// TODO Auto-generated method stub
		return this.hulk;
	}
	@Override
	public void setTransformation(boolean transform) {
		// TODO Auto-generated method stub
		transformation = transform;
	}
	@Override
	public boolean isTransforming() {
		// TODO Auto-generated method stub
		return transformation;
	}
	@Override
	public void setAlpha(float alpha) {
		// TODO Auto-generated method stub
		this.alpha = alpha;
	}
	@Override
	public void addAlpha(float alpha) {
		// TODO Auto-generated method stub
		this.alpha += alpha;
	}
	@Override
	public void removeAlpha(float alpha) {
		// TODO Auto-generated method stub
		this.alpha -= alpha;
	}
	@Override
	public float getAlpha() {
		// TODO Auto-generated method stub
		return alpha;
	}
	@Override
	public void setDetransforming(boolean transform) {
		// TODO Auto-generated method stub
		detransformation = transform;
	}
	@Override
	public boolean isDetransforming() {
		// TODO Auto-generated method stub
		return detransformation;
	}
	@Override
	public void setSize(float size) {
		// TODO Auto-generated method stub
		this.size = size;
	}
	@Override
	public void addSize(float size) {
		// TODO Auto-generated method stub
		this.size += size;
	}
	@Override
	public void removeSize(float size) {
		// TODO Auto-generated method stub
		this.size -= size;
	}
	@Override
	public float getSize() {
		// TODO Auto-generated method stub
		return this.size;
	}
	@Override
	public void setHumanTransformation(boolean transform) {
		// TODO Auto-generated method stub
		htransformation = transform;
	}
	@Override
	public boolean isHumanTransforming() {
		// TODO Auto-generated method stub
		return htransformation;
	}
	@Override
	public void setHAlpha(float alpha) {
		// TODO Auto-generated method stub
		halpha = alpha;
	}
	@Override
	public void addHAlpha(float alpha) {
		// TODO Auto-generated method stub
		halpha += alpha;
	}
	@Override
	public void removeHAlpha(float alpha) {
		// TODO Auto-generated method stub
		halpha -= alpha;
	}
	@Override
	public float getHAlpha() {
		// TODO Auto-generated method stub
		return halpha;
	}
	@Override
	public void setWallCliming(boolean climb) {
		// TODO Auto-generated method stub
		this.climb = climb;
	}
	@Override
	public boolean isWallClimbing() {
		// TODO Auto-generated method stub
		return climb;
	}
	@Override
	public void setLeap(boolean leap) {
		// TODO Auto-generated method stub
		this.leap = leap;
	}
	@Override
	public boolean isLeaping() {
		// TODO Auto-generated method stub
		return leap;
	}
	@Override
	public void setSmash(boolean smash) {
		// TODO Auto-generated method stub
		this.smash = smash;
	}
	@Override
	public boolean isSmash() {
		// TODO Auto-generated method stub
		return smash;
	}
	@Override
	public void setSmashCooldown(boolean bool) {
		// TODO Auto-generated method stub
		this.smashCooldown = bool;
	}
	@Override
	public boolean isSmashCooldown() {
		// TODO Auto-generated method stub
		return this.smashCooldown;
	}
	@Override
	public void setSmashCooldownInt(int cooldown) {
		// TODO Auto-generated method stub
		this.smashCooldownInt = cooldown;
	}
	@Override
	public void increaseSmashCooldownInt() {
		// TODO Auto-generated method stub
		this.smashCooldownInt++;
	}
	@Override
	public int getSmashCooldownInt() {
		// TODO Auto-generated method stub
		return this.smashCooldownInt;
	}
	@Override
	public void setUp(boolean bool) {
		// TODO Auto-generated method stub
		up = bool;
	}
	@Override
	public boolean getUp() {
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
	public void setLTick(int tick) {
		// TODO Auto-generated method stub
		ltick = tick;
	}
	@Override
	public void increaseLTick() {
		// TODO Auto-generated method stub
		ltick++;
	}
	@Override
	public int getLTick() {
		// TODO Auto-generated method stub
		return ltick;
	}
	@Override
	public void setTransformTick(int tick) {
		// TODO Auto-generated method stub
		transformTick = tick;
	}
	@Override
	public void increaseTransformTick() {
		// TODO Auto-generated method stub
		transformTick++;
	}
	@Override
	public int getTransformTick() {
		// TODO Auto-generated method stub
		return transformTick;
	}

	@Override
	public void setHTransformTick(int tick) {
		// TODO Auto-generated method stub
		htransformTick = tick;
	}
	@Override
	public void increaseHTransformTick() {
		// TODO Auto-generated method stub
		htransformTick++;
	}
	@Override
	public int getHTransformTick() {
		// TODO Auto-generated method stub
		return htransformTick;
	}
}

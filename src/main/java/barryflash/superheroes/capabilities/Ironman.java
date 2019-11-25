package barryflash.superheroes.capabilities;

public class Ironman implements IIronman {
	private boolean animation, animationOff, cannon, swordOn;
	private int step;
	private boolean repulsors;
	private boolean disabled;
	private boolean[] cooldownAccess = new boolean[7];
	private int[] cooldown = new int[7];
	private int weaponNum, flymode;
	private boolean fly;
	private int tick;
	private int animationTick;
	private int disabledTimer, cannonTick;
	@Override
	public void animationStart() {
		// TODO Auto-generated method stub
		this.animation = true;
	}

	@Override
	public void animationEnd() {
		// TODO Auto-generated method stub
		this.animation = false;
	}

	@Override
	public boolean atcurrentStep(int step) {
		if (this.step == step) {
		return true;
		} else return false;
	}



	@Override
	public boolean isAnimationInProgress() {
		// TODO Auto-generated method stub
		return animation;
	}

	@Override
	public void activateRepulsors() {
		// TODO Auto-generated method stub
		this.repulsors = true;
	}

	@Override
	public void deactivateRepulsors() {
		// TODO Auto-generated method stub
		this.repulsors = false;
	}

	@Override
	public boolean repulsorsActivated() {
		// TODO Auto-generated method stub
		return this.repulsors;
	}
	private boolean rightarm;
	private boolean leftarm;



	@Override
	public boolean shotFromRightArm() {
		// TODO Auto-generated method stub
		return rightarm;
	}

	@Override
	public boolean shotFromLeftArm() {
		// TODO Auto-generated method stub
		return leftarm;
	}

	@Override
	public void shootRightArm() {
		// TODO Auto-generated method stub
		rightarm = true;
	}

	@Override
	public void shootLeftArm() {
		// TODO Auto-generated method stub
		leftarm = true;
	}

	@Override
	public void cancelRightArm() {
		rightarm = false;
		
	}

	@Override
	public void cancelLeftArm() {
		// TODO Auto-generated method stub
		leftarm = false;
	}
	private boolean shield;
	@Override
	public void activateShield() {
		// TODO Auto-generated method stub
		shield = true;
	}

	@Override
	public void deactivateShield() {
		// TODO Auto-generated method stub
		shield = false;
	}
	private int weapon;
	@Override
	public boolean isShieldActivated() {
		// TODO Auto-generated method stub
		return shield;
	}
	private boolean cannons;
	@Override
	public boolean areCannonsActivated() {
		// TODO Auto-generated method stub
		return cannons;
	}



	

	@Override
	public void activateCannons(boolean act) {
		if (act == true) {
			cannons = true;
		} else {
			cannons = false;
		}
	}

	private boolean flight;
	@Override
	public void activateFlight() {
		// TODO Auto-generated method stub
		flight = true;
	}

	@Override
	public void deactivateFlight() {
		// TODO Auto-generated method stub
		flight = false;
	}

	@Override
	public boolean isFlight() {
		// TODO Auto-generated method stub
		return flight;
	}
	private boolean jet;
	@Override
	public void activateJetThruster() {
		// TODO Auto-generated method stub
		jet = true;
	}

	@Override
	public void deactivateJetThruster() {
		// TODO Auto-generated method stub
		jet = false;
	}

	@Override
	public boolean isJetThrusterActivated() {
		// TODO Auto-generated method stub
		return jet;
	}
	private boolean wings;
	@Override
	public void activateWings() {
		// TODO Auto-generated method stub
		wings = true;
	}

	@Override
	public void deactivateWings() {
		// TODO Auto-generated method stub
		wings = false;
	}

	@Override
	public boolean areWingsActivated() {
		// TODO Auto-generated method stub
		return wings;
	}
	private boolean knockbackFists;
	private boolean sword;
	private boolean missiles;
	@Override
	public void activateKnockbackFists() {
		// TODO Auto-generated method stub
		knockbackFists = true;
	}

	@Override
	public void deactivateKnockbackFists() {
		// TODO Auto-generated method stub
		knockbackFists = false;
	}

	@Override
	public boolean areKnockbackFistsActivated() {
		// TODO Auto-generated method stub
		return knockbackFists;
	}

	@Override
	public void activateSword() {
		// TODO Auto-generated method stub
		sword = true;
	}

	@Override
	public void deactivateSword() {
		// TODO Auto-generated method stub
		sword = false;
	}

	@Override
	public boolean isSwordActivated() {
		// TODO Auto-generated method stub
		return sword;
	}

	@Override
	public void activateMissiles() {
		// TODO Auto-generated method stub
		missiles = true;
	}

	@Override
	public void deactivateMissiles() {
		// TODO Auto-generated method stub
		missiles = false;
	}

	@Override
	public boolean areMissilesActivated() {
		// TODO Auto-generated method stub
		return missiles;
	}
	private boolean arc;
	@Override
	public void shootArc() {
		// TODO Auto-generated method stub
		arc = true;
	}

	@Override
	public void cancelArc() {
		// TODO Auto-generated method stub
		arc = false;
	}

	@Override
	public boolean shotFromArc() {
		// TODO Auto-generated method stub
		return arc;
	}
	private boolean rightArmCooldown;
	private boolean leftArmCooldown;
	private boolean unibeamCooldown;
	@Override
	public void setRightArmCooldown() {
		// TODO Auto-generated method stub
		this.rightArmCooldown = true;
	}

	@Override
	public void unsetRightArmCooldown() {
		// TODO Auto-generated method stub
		this.rightArmCooldown = false;
	}

	@Override
	public boolean rightArmCooldown() {
		// TODO Auto-generated method stub
		return this.rightArmCooldown;
	}

	@Override
	public void setLeftArmCooldown() {
		// TODO Auto-generated method stub
		this.leftArmCooldown = true;
	}

	@Override
	public void unsetLeftArmCooldown() {
		// TODO Auto-generated method stub
		this.leftArmCooldown = false;
	}

	@Override
	public boolean leftArmCooldown() {
		// TODO Auto-generated method stub
		return this.leftArmCooldown;
	}

	@Override
	public void setUnibeamCooldown() {
		// TODO Auto-generated method stub
		this.unibeamCooldown = true;
	}

	@Override
	public void unsetUnibeamCooldown() {
		// TODO Auto-generated method stub
		this.unibeamCooldown = false;
	}

	@Override
	public boolean unibeamCooldown() {
		// TODO Auto-generated method stub
		return this.unibeamCooldown;
	}

	private int flytick;
	@Override
	public int ticksFlying(int tick) {
		// TODO Auto-generated method stub
		return flytick = tick;
	}

	@Override
	public int getFlyTicks() {
		// TODO Auto-generated method stub
		return flytick;
	}

	private boolean weaponCooldown;
	private boolean missileCooldown;
	private boolean swordCooldown;
	private boolean knockbackCooldown;
	@Override
	public void setWeaponCooldown() {
		// TODO Auto-generated method stub
		this.weaponCooldown = true;
	}

	@Override
	public void unsetWeaponCooldown() {
		// TODO Auto-generated method stub
		this.weaponCooldown = false;
	}

	@Override
	public boolean weaponCooldown() {
		// TODO Auto-generated method stub
		return this.weaponCooldown;
	}

	@Override
	public void setMissileCooldown() {
		// TODO Auto-generated method stub
		this.missileCooldown = true;
	}

	@Override
	public void unsetMissileCooldown() {
		// TODO Auto-generated method stub
		this.missileCooldown = false;
	}

	@Override
	public boolean missileCooldown() {
		// TODO Auto-generated method stub
		return this.missileCooldown;
	}

	@Override
	public void setSwordCooldown() {
		this.swordCooldown = true;
		
	}

	@Override
	public void unsetSwordCooldown() {
		// TODO Auto-generated method stub
		this.swordCooldown = false;
	}

	@Override
	public boolean swordCooldown() {
		// TODO Auto-generated method stub
		return this.swordCooldown;
	}

	@Override
	public void setKnockbackFistsCooldown() {
		// TODO Auto-generated method stub
		this.knockbackCooldown = true;
	}

	@Override
	public void unsetKnockbackFistsCooldown() {
		// TODO Auto-generated method stub
		this.knockbackCooldown = false;
	}

	@Override
	public boolean knockbackFistsCooldown() {
		// TODO Auto-generated method stub
		return this.knockbackCooldown;
	}

	
	private boolean reactor;
	@Override
	public void setFlightMode() {
		// TODO Auto-generated method stub
		reactor = true;
	}

	@Override
	public void unsetFlightMode() {
		// TODO Auto-generated method stub
		reactor = false;
	}

	@Override
	public boolean isFlightMode() {
		// TODO Auto-generated method stub
		return reactor;
	}

	@Override
	public void setIronmanDisabled(boolean disabled) {
		// TODO Auto-generated method stub
		this.disabled = disabled;
	}

	@Override
	public boolean isIronmanDisabled() {
		// TODO Auto-generated method stub
		return disabled;
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
	public void setCooldownAccess(int index, boolean bool) {
		// TODO Auto-generated method stub
		this.cooldownAccess[index] = bool;
	}

	@Override
	public boolean getCooldownAccess(int index) {
		// TODO Auto-generated method stub
		return this.cooldownAccess[index];
	}

	@Override
	public void setCooldown(int index, int amount) {
		// TODO Auto-generated method stub
		this.cooldown[index] = amount;
	}

	@Override
	public void increaseCooldown(int index) {
		// TODO Auto-generated method stub
		this.cooldown[index]++;
	}

	@Override
	public int getCooldown(int index) {
		// TODO Auto-generated method stub
		return this.cooldown[index];
	}

	@Override
	public void setWeapon(int index) {
		// TODO Auto-generated method stub
		weaponNum = index;
	}

	@Override
	public void increaseWeapon() {
		// TODO Auto-generated method stub
		weaponNum++;
	}

	@Override
	public int getWeapon() {
		// TODO Auto-generated method stub
		return weaponNum;
	}

	@Override
	public void setFlyMode(int index) {
		// TODO Auto-generated method stub
		flymode = index;
	}

	@Override
	public void increaseFlyMode() {
		// TODO Auto-generated method stub
		flymode++;
	}

	@Override
	public int getFlyMode() {
		// TODO Auto-generated method stub
		return flymode;
	}

	@Override
	public void setFlight(boolean bool) {
		// TODO Auto-generated method stub
		fly = bool;
	}

	@Override
	public boolean getFlight() {
		// TODO Auto-generated method stub
		return fly;
	}

	@Override
	public void setFlyTicks(int ticks) {
		// TODO Auto-generated method stub
		tick = ticks;
	}

	@Override
	public void increaseFlyTicks() {
		// TODO Auto-generated method stub
		tick++;
	}

	@Override
	public int getFlyTick() {
		// TODO Auto-generated method stub
		return tick;
	}

	@Override
	public void setAnimationStep(int step) {
		// TODO Auto-generated method stub
		this.step = step;
	}

	@Override
	public void increaseAnimationStep() {
		// TODO Auto-generated method stub
		this.step++;
	}

	@Override
	public void decreaseAnimationStep() {
		// TODO Auto-generated method stub
		this.step--;
	}

	@Override
	public int getAnimationStep() {
		// TODO Auto-generated method stub
		return this.step;
	}

	@Override
	public void setAnimationTick(int tick) {
		// TODO Auto-generated method stub
		animationTick = tick;
	}

	@Override
	public void increaseAnimationTick() {
		// TODO Auto-generated method stub
		animationTick++;
	}

	@Override
	public int getAnimationTick() {
		// TODO Auto-generated method stub
		return animationTick;
	}

	@Override
	public void setAnimationOff(boolean bool) {
		// TODO Auto-generated method stub
		animationOff = bool;
	}

	@Override
	public boolean isAnimationOff() {
		// TODO Auto-generated method stub
		return animationOff;
	}

	@Override
	public void setDisabledTimer(int tick) {
		// TODO Auto-generated method stub
		disabledTimer = tick;
	}

	@Override
	public void increaseDisabledTimer() {
		// TODO Auto-generated method stub
		disabledTimer++;
	}

	@Override
	public int getDisabledTimer() {
		// TODO Auto-generated method stub
		return disabledTimer;
	}

	@Override
	public void setCannon(boolean bool) {
		// TODO Auto-generated method stub
		cannon = bool;
	}

	@Override
	public boolean getCannon() {
		// TODO Auto-generated method stub
		return cannon;
	}

	@Override
	public void setCannonTick(int tick) {
		// TODO Auto-generated method stub
		cannonTick=tick;
	}

	@Override
	public void increaseCannonTick() {
		// TODO Auto-generated method stub
		cannonTick++;
	}

	@Override
	public int getCannonTick() {
		// TODO Auto-generated method stub
		return cannonTick;
	}

	@Override
	public void setSwordOn(boolean bool) {
		// TODO Auto-generated method stub
		swordOn = bool;
	}

	@Override
	public boolean getSwordOn() {
		// TODO Auto-generated method stub
		return swordOn;
	}

}

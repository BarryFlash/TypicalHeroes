package barryflash.superheroes.capabilities;

public interface IIronman {
	
	public void setFlightMode();
	public void unsetFlightMode();
	public boolean isFlightMode();
	public int ticksFlying(int tick);
	public int getFlyTicks();
	public void animationStart();
	public void animationEnd();
	public void setAnimationOff(boolean bool);
	public boolean isAnimationOff();
	public void setAnimationTick(int tick);
	public void increaseAnimationTick();
	public int getAnimationTick();
	
	public void setCannon(boolean bool);
	public boolean getCannon();
	public void setCannonTick(int tick);
	public void increaseCannonTick();
	public int getCannonTick();
	
	public void setDisabledTimer(int tick);
	public void increaseDisabledTimer();
	public int getDisabledTimer();
	
	public void setSwordOn(boolean bool);
	public boolean getSwordOn();
	
	public boolean isAnimationInProgress();
	public boolean atcurrentStep(int step);
	
	public void setAnimationStep(int step);
	public void increaseAnimationStep();
	public void decreaseAnimationStep();
	public void activateRepulsors();
	public void deactivateRepulsors();
	public boolean repulsorsActivated();
	public int getAnimationStep();
	
	public void shootRightArm();
	public void shootLeftArm();
	public void shootArc();
	public void cancelRightArm();
	public void cancelLeftArm();
	public void cancelArc();
	public boolean shotFromRightArm();
	public boolean shotFromLeftArm();
	public boolean shotFromArc();
	public void setRightArmCooldown();
	public void unsetRightArmCooldown();
	public boolean rightArmCooldown();
	public void setLeftArmCooldown();
	public void unsetLeftArmCooldown();
	public boolean leftArmCooldown();
	public void setUnibeamCooldown();
	public void unsetUnibeamCooldown();
	public boolean unibeamCooldown();
	public void setWeaponCooldown();
	public void unsetWeaponCooldown();
	public boolean weaponCooldown();
	public void setMissileCooldown();
	public void unsetMissileCooldown();
	public boolean missileCooldown();
	public void setSwordCooldown();
	public void unsetSwordCooldown();
	public boolean swordCooldown();
	public void setKnockbackFistsCooldown();
	public void unsetKnockbackFistsCooldown();
	public boolean knockbackFistsCooldown();

	public void activateShield();
	public void deactivateShield();
	public boolean isShieldActivated();
	
	public void activateCannons(boolean act);
	public boolean areCannonsActivated();
	
	public void activateFlight();
	public void deactivateFlight();
	public boolean isFlight();
	
	public void activateJetThruster();
	public void deactivateJetThruster();
	public boolean isJetThrusterActivated();
	
	public void activateWings();
	public void deactivateWings();
	public boolean areWingsActivated();
	
	public void activateKnockbackFists();
	public void deactivateKnockbackFists();
	public boolean areKnockbackFistsActivated();
	
	public void activateSword();
	public void deactivateSword();
	public boolean isSwordActivated();
	
	public void activateMissiles();
	public void deactivateMissiles();
	public boolean areMissilesActivated();
	
	public void setIronmanDisabled(boolean disabled);
	public boolean isIronmanDisabled();
	
	public void setArmorWorn(boolean armor);
	public boolean isArmorWorn();
	
	public void setCooldownAccess(int index, boolean bool);
	public boolean getCooldownAccess(int index);
	
	public void setCooldown(int index, int amount);
	public void increaseCooldown(int index);
	public int getCooldown(int index);
	
	public void setWeapon(int index);
	public void increaseWeapon();
	public int getWeapon();
	
	public void setFlyMode(int index);
	public void increaseFlyMode();
	public int getFlyMode();
	
	public void setFlight(boolean bool);
	public boolean getFlight();
	
	public void setFlyTicks(int ticks);
	public void increaseFlyTicks();
	public int getFlyTick();
	
}

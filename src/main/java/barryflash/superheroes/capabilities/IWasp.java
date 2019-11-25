package barryflash.superheroes.capabilities;

public interface IWasp {

	public void setFly();
	public void unsetFly();
	public boolean isFlying();
	
	public void setSmall();
	public boolean isSmall();
	public void resetSize();
	
	public void setAnimationStart();
	public void setStep1();
	public void setStep2();
	public void setStep3();
	public void setStep4();
	public void unsetStep1();
	public void unsetStep2();
	public void unsetStep3();
	public void unsetStep4();
	public boolean atStep1();
	public boolean atStep2();
	public boolean atStep3();
	public boolean atStep4();
	public void setAnimationEnd();
	public boolean isAnimationInProgress();
	
	public void setGrowAnimationStart();
	public void setGrowStep1();
	public void setGrowStep2();
	public void setGrowStep3();
	public void setGrowStep4();
	public void unsetGrowStep1();
	public void unsetGrowStep2();
	public void unsetGrowStep3();
	public void unsetGrowStep4();
	public boolean atGrowStep1();
	public boolean atGrowStep2();
	public boolean atGrowStep3();
	public boolean atGrowStep4();
	public void setGrowAnimationEnd();
	public boolean isGrowAnimationInProgress();
	
	public void helmetOnanimationStart();
	public void helmetOnanimationEnd();
	
	public void helmetOffanimationStart();
	public void helmetOffanimationEnd();
	
	public boolean isHelmetAnimationInProgress();
	public boolean atcurrentHelmetOnStep(int step);
	public void helmetanimationStep(int step);
	
	public boolean isHelmetOffAnimationInProgress();
	public boolean atcurrentHelmetOffStep(int step);
	public void helmetOffanimationStep(int step);
	
	
	public void setHelmetOff();
	public void setHelmetOn();
	public boolean isHelmetOn();
	
	public void activateBlasters();
	public void deactivateBlasters();
	public boolean areBlastersActive();
	
	public void setShotFromRightArm();
	public void unsetShotFromRightArm();
	public boolean shotFromRightArm();
	
	public void setShotFromLeftArm();
	public void unsetShotFromLeftArm();
	public boolean shotFromLeftArm();
		
	public int ticksFlying(int tick);
	public int getFlyTicks();
}

package barryflash.superheroes.capabilities;

public interface IAntman {

	
	public void setSmall();
	public boolean isSmall();
	public void setBig();
	public boolean isBig();
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
	
	public void giantanimationStart();
	public void giantanimationEnd();
	public boolean isGiantAnimationInProgress();
	
	public void giantShrinkanimationStart();
	public void giantShrinkanimationEnd();
	public boolean isGiantShrinkAnimationInProgress();
	

	public void setGiantStep1();
	public void setGiantStep2();
	public void setGiantStep3();
	public void setGiantStep4();
	public void setGiantStep5();
	public void setGiantStep6();
	public void unsetGiantStep1();
	public void unsetGiantStep2();
	public void unsetGiantStep3();
	public void unsetGiantStep4();
	public void unsetGiantStep5();
	public void unsetGiantStep6();
	public boolean atGiantStep1();
	public boolean atGiantStep2();
	public boolean atGiantStep3();
	public boolean atGiantStep4();
	public boolean atGiantStep5();
	public boolean atGiantStep6();
	public void setGiantShrinkStep1();
	public void setGiantShrinkStep2();
	public void setGiantShrinkStep3();
	public void setGiantShrinkStep4();
	public void setGiantShrinkStep5();
	public void setGiantShrinkStep6();
	public void unsetGiantShrinkStep1();
	public void unsetGiantShrinkStep2();
	public void unsetGiantShrinkStep3();
	public void unsetGiantShrinkStep4();
	public void unsetGiantShrinkStep5();
	public void unsetGiantShrinkStep6();
	public boolean atGiantShrinkStep1();
	public boolean atGiantShrinkStep2();
	public boolean atGiantShrinkStep3();
	public boolean atGiantShrinkStep4();
	public boolean atGiantShrinkStep5();
	public boolean atGiantShrinkStep6();
	public boolean isNormalSize();
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
	
	public boolean isInGroundPound();
	public void setGroundPound();
	public void unsetGroundPound();
	
	public void setGroundPoundCooldown();
	public void unsetGroundPoundCooldown();
	public boolean isGroundPoundCooldown();
	
}

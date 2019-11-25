package barryflash.superheroes.capabilities;

public class Antman implements IAntman {
	private boolean fly;
	private boolean small;
	private boolean big;
	private boolean normal = true;
	private boolean gpoundcooldown;
	
	@Override
	public void setSmall() {
		// TODO Auto-generated method stub
		small = true;
		normal = false;
	}

	@Override
	public boolean isSmall() {
		// TODO Auto-generated method stub
		return small;
	}

	@Override
	public void resetSize() {
		normal = true;
		small = false;
		big = false;
	}
	private boolean step1;
	private boolean step2;
	private boolean step3;
	private boolean step4;
	private boolean animation;
	@Override
	public void setAnimationStart() {
		// TODO Auto-generated method stub
		animation = true;
	}

	@Override
	public void setStep1() {
		// TODO Auto-generated method stub
		step1 = true;
	}

	@Override
	public void setStep2() {
		// TODO Auto-generated method stub
		step2 = true;
	}

	@Override
	public void setStep3() {
		// TODO Auto-generated method stub
		step3 = true;
	}

	@Override
	public void setStep4() {
		// TODO Auto-generated method stub
		step4 = true;
	}

	@Override
	public void unsetStep1() {
		// TODO Auto-generated method stub
		step1 = false;
	}

	@Override
	public void unsetStep2() {
		// TODO Auto-generated method stub
		step2 = false;
	}

	@Override
	public void unsetStep3() {
		// TODO Auto-generated method stub
		step3 = false;
	}

	@Override
	public void unsetStep4() {
		// TODO Auto-generated method stub
		step4 = false;
	}

	@Override
	public boolean atStep1() {
		// TODO Auto-generated method stub
		return step1;
	}

	@Override
	public boolean atStep2() {
		// TODO Auto-generated method stub
		return step2;
	}

	@Override
	public boolean atStep3() {
		// TODO Auto-generated method stub
		return step3;
	}

	@Override
	public boolean atStep4() {
		// TODO Auto-generated method stub
		return step4;
	}

	@Override
	public void setAnimationEnd() {
		// TODO Auto-generated method stub
		animation = false;
	}

	@Override
	public boolean isAnimationInProgress() {
		// TODO Auto-generated method stub
		return animation;
	}
	private boolean gstep1;
	private boolean gstep2;
	private boolean gstep3;
	private boolean gstep4;
	private boolean ganimation;
	@Override
	public void setGrowAnimationStart() {
		// TODO Auto-generated method stub
		ganimation = true;
	}

	@Override
	public void setGrowStep1() {
		// TODO Auto-generated method stub
		gstep1 = true;
	}

	@Override
	public void setGrowStep2() {
		// TODO Auto-generated method stub
		gstep2 = true;
	}

	@Override
	public void setGrowStep3() {
		// TODO Auto-generated method stub
		gstep3 = true;
	}

	@Override
	public void setGrowStep4() {
		// TODO Auto-generated method stub
		gstep4 = true;
	}

	@Override
	public void unsetGrowStep1() {
		// TODO Auto-generated method stub
		gstep1 = false;
	}

	@Override
	public void unsetGrowStep2() {
		// TODO Auto-generated method stub
		gstep2 = false;
	}

	@Override
	public void unsetGrowStep3() {
		// TODO Auto-generated method stub
		gstep3 = false;
	}

	@Override
	public void unsetGrowStep4() {
		// TODO Auto-generated method stub
		gstep4 = false;
	}

	@Override
	public boolean atGrowStep1() {
		// TODO Auto-generated method stub
		return gstep1;
	}

	@Override
	public boolean atGrowStep2() {
		// TODO Auto-generated method stub
		return gstep2;
	}

	@Override
	public boolean atGrowStep3() {
		// TODO Auto-generated method stub
		return gstep3;
	}

	@Override
	public boolean atGrowStep4() {
		// TODO Auto-generated method stub
		return gstep4;
	}

	@Override
	public void setGrowAnimationEnd() {
		// TODO Auto-generated method stub
		ganimation = false;
	}

	@Override
	public boolean isGrowAnimationInProgress() {
		// TODO Auto-generated method stub
		return ganimation;
	}
	private boolean hanimation;
	private int helmetStep;
	@Override
	public void helmetOnanimationStart() {
		// TODO Auto-generated method stub
		hanimation = true;
	}

	@Override
	public void helmetOnanimationEnd() {
		// TODO Auto-generated method stub
		hanimation = false;
	}

	@Override
	public boolean isHelmetAnimationInProgress() {
		// TODO Auto-generated method stub
		return hanimation;
	}

	@Override
	public boolean atcurrentHelmetOnStep(int step) {
		// TODO Auto-generated method stub
		if (this.helmetStep == step) {
			return true;
			} else return false;
	}

	@Override
	public void helmetanimationStep(int step) {
		// TODO Auto-generated method stub
		this.helmetStep = step;
	}
	private boolean helmet = true;
	@Override
	public void setHelmetOff() {
		// TODO Auto-generated method stub
		helmet = false;
	}

	@Override
	public void setHelmetOn() {
		// TODO Auto-generated method stub
		helmet = true;
	}

	@Override
	public boolean isHelmetOn() {
		// TODO Auto-generated method stub
		return helmet;
	}
	private int helmetOffStep;
	private boolean helmetOff;
	@Override
	public boolean isHelmetOffAnimationInProgress() {
		// TODO Auto-generated method stub
		return helmetOff;
	}

	@Override
	public boolean atcurrentHelmetOffStep(int step) {
		// TODO Auto-generated method stub
		if (this.helmetOffStep == step) {
			return true;
			} else return false;
	}

	@Override
	public void helmetOffanimationStep(int step) {
		// TODO Auto-generated method stub
		this.helmetOffStep = step;
	}

	@Override
	public void helmetOffanimationStart() {
		// TODO Auto-generated method stub
		helmetOff = true;
	}

	@Override
	public void helmetOffanimationEnd() {
		// TODO Auto-generated method stub
		helmetOff = false;
	}
	
	@Override
	public void setBig() {
		normal = false;
		big = true;
	}

	@Override
	public boolean isBig() {
		// TODO Auto-generated method stub
		return big;
	}
	private boolean giant;
	private boolean giantS;
	private int giantStep;
	private int giantShrinkStep;
	@Override
	public void giantanimationStart() {
		// TODO Auto-generated method stub
		giant = true;
	}

	@Override
	public void giantanimationEnd() {
		// TODO Auto-generated method stub
		giant = false;
	}

	@Override
	public boolean isGiantAnimationInProgress() {
		// TODO Auto-generated method stub
		return giant;
	}

	@Override
	public void giantShrinkanimationStart() {
		// TODO Auto-generated method stub
		giantS = true;
	}

	@Override
	public void giantShrinkanimationEnd() {
		// TODO Auto-generated method stub
		giantS = false;
	}

	@Override
	public boolean isGiantShrinkAnimationInProgress() {
		// TODO Auto-generated method stub
		return giantS;
	}
	private boolean giantstep1;
	private boolean giantstep2;
	private boolean giantstep3;
	private boolean giantstep4;
	private boolean giantstep5;
	private boolean giantstep6;
	@Override
	public void setGiantStep1() {
		// TODO Auto-generated method stub
		giantstep1 = true;
	}

	@Override
	public void setGiantStep2() {
		// TODO Auto-generated method stub
		giantstep2 = true;
	}

	@Override
	public void setGiantStep3() {
		// TODO Auto-generated method stub
		giantstep3 = true;
	}

	@Override
	public void setGiantStep4() {
		// TODO Auto-generated method stub
		giantstep4 = true;
	}
	@Override
	public void setGiantStep5() {
		// TODO Auto-generated method stub
		giantstep5 = true;
	}
	@Override
	public void setGiantStep6() {
		// TODO Auto-generated method stub
		giantstep6 = true;
	}

	@Override
	public void unsetGiantStep1() {
		// TODO Auto-generated method stub
		giantstep1 = false;
	}

	@Override
	public void unsetGiantStep2() {
		// TODO Auto-generated method stub
		giantstep2 = false;
	}

	@Override
	public void unsetGiantStep3() {
		// TODO Auto-generated method stub
		giantstep3 = false;
	}

	@Override
	public void unsetGiantStep4() {
		// TODO Auto-generated method stub
		giantstep4 = false;
	}
	
	@Override
	public void unsetGiantStep5() {
		// TODO Auto-generated method stub
		giantstep5 = false;
	}
	@Override
	public void unsetGiantStep6() {
		// TODO Auto-generated method stub
		giantstep6 = false;
	}
	
	@Override
	public boolean atGiantStep1() {
		// TODO Auto-generated method stub
		return giantstep1;
	}

	@Override
	public boolean atGiantStep2() {
		// TODO Auto-generated method stub
		return giantstep2;
	}

	@Override
	public boolean atGiantStep3() {
		// TODO Auto-generated method stub
		return giantstep3;
	}

	@Override
	public boolean atGiantStep4() {
		// TODO Auto-generated method stub
		return giantstep4;
	}
	
	@Override
	public boolean atGiantStep5() {
		// TODO Auto-generated method stub
		return giantstep5;
	}
	
	@Override
	public boolean atGiantStep6() {
		// TODO Auto-generated method stub
		return giantstep6;
	}

	private boolean giantShrinkstep1;
	private boolean giantShrinkstep2;
	private boolean giantShrinkstep3;
	private boolean giantShrinkstep4;
	private boolean giantShrinkstep5;
	private boolean giantShrinkstep6;
	@Override
	public void setGiantShrinkStep1() {
		// TODO Auto-generated method stub
		giantShrinkstep1 = true;
	}

	@Override
	public void setGiantShrinkStep2() {
		// TODO Auto-generated method stub
		giantShrinkstep2 = true;
	}

	@Override
	public void setGiantShrinkStep3() {
		// TODO Auto-generated method stub
		giantShrinkstep3 = true;
	}

	@Override
	public void setGiantShrinkStep4() {
		// TODO Auto-generated method stub
		giantShrinkstep4 = true;
	}
	@Override
	public void setGiantShrinkStep5() {
		// TODO Auto-generated method stub
		giantShrinkstep5 = true;
	}
	@Override
	public void setGiantShrinkStep6() {
		// TODO Auto-generated method stub
		giantShrinkstep6 = true;
	}

	@Override
	public void unsetGiantShrinkStep1() {
		// TODO Auto-generated method stub
		giantShrinkstep1 = false;
	}

	@Override
	public void unsetGiantShrinkStep2() {
		// TODO Auto-generated method stub
		giantShrinkstep2 = false;
	}

	@Override
	public void unsetGiantShrinkStep3() {
		// TODO Auto-generated method stub
		giantShrinkstep3 = false;
	}

	@Override
	public void unsetGiantShrinkStep4() {
		// TODO Auto-generated method stub
		giantShrinkstep4 = false;
	}
	
	@Override
	public void unsetGiantShrinkStep5() {
		// TODO Auto-generated method stub
		giantShrinkstep5 = false;
	}
	@Override
	public void unsetGiantShrinkStep6() {
		// TODO Auto-generated method stub
		giantShrinkstep6 = false;
	}
	
	@Override
	public boolean atGiantShrinkStep1() {
		// TODO Auto-generated method stub
		return giantShrinkstep1;
	}

	@Override
	public boolean atGiantShrinkStep2() {
		// TODO Auto-generated method stub
		return giantShrinkstep2;
	}

	@Override
	public boolean atGiantShrinkStep3() {
		// TODO Auto-generated method stub
		return giantShrinkstep3;
	}

	@Override
	public boolean atGiantShrinkStep4() {
		// TODO Auto-generated method stub
		return giantShrinkstep4;
	}
	
	@Override
	public boolean atGiantShrinkStep5() {
		// TODO Auto-generated method stub
		return giantShrinkstep5;
	}
	
	@Override
	public boolean atGiantShrinkStep6() {
		// TODO Auto-generated method stub
		return giantShrinkstep6;
	}

	@Override
	public boolean isNormalSize() {
		// TODO Auto-generated method stub
		return normal;
	}
	private boolean groundpound;
	@Override
	public boolean isInGroundPound() {
		// TODO Auto-generated method stub
		return groundpound;
	}

	@Override
	public void setGroundPound() {
		// TODO Auto-generated method stub
		groundpound = true;
	}

	@Override
	public void unsetGroundPound() {
		// TODO Auto-generated method stub
		groundpound = false;
	}

	@Override
	public void setGroundPoundCooldown() {
		// TODO Auto-generated method stub
		this.gpoundcooldown = true;
	}

	@Override
	public void unsetGroundPoundCooldown() {
		// TODO Auto-generated method stub
		this.gpoundcooldown = false;
	}

	@Override
	public boolean isGroundPoundCooldown() {
		// TODO Auto-generated method stub
		return this.gpoundcooldown;
	}


	
	
	

}

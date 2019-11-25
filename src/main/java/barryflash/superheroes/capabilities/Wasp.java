package barryflash.superheroes.capabilities;

public class Wasp implements IWasp {
	private boolean fly;
	private boolean small;
	@Override
	public void setFly() {
		// TODO Auto-generated method stub
		fly = true;
	}

	@Override
	public void unsetFly() {
		// TODO Auto-generated method stub
		fly = false;
	}

	@Override
	public boolean isFlying() {
		// TODO Auto-generated method stub
		return fly;
	}

	@Override
	public void setSmall() {
		// TODO Auto-generated method stub
		small = true;
	}

	@Override
	public boolean isSmall() {
		// TODO Auto-generated method stub
		return small;
	}

	@Override
	public void resetSize() {
		// TODO Auto-generated method stub
		small = false;
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
	private boolean blasters;
	private boolean rightarm;
	private boolean leftarm;
	@Override
	public void activateBlasters() {
		// TODO Auto-generated method stub
		blasters = true;
	}

	@Override
	public void deactivateBlasters() {
		// TODO Auto-generated method stub
		blasters = false;
	}

	@Override
	public boolean areBlastersActive() {
		// TODO Auto-generated method stub
		return blasters;
	}

	@Override
	public void setShotFromRightArm() {
		// TODO Auto-generated method stub
		rightarm = true;
	}

	@Override
	public void unsetShotFromRightArm() {
		// TODO Auto-generated method stub
		rightarm = false;
	}

	@Override
	public boolean shotFromRightArm() {
		// TODO Auto-generated method stub
		return rightarm;
	}

	@Override
	public void setShotFromLeftArm() {
		// TODO Auto-generated method stub
		leftarm = true;
	}

	@Override
	public void unsetShotFromLeftArm() {
		// TODO Auto-generated method stub
		leftarm = false;
	}

	@Override
	public boolean shotFromLeftArm() {
		// TODO Auto-generated method stub
		return leftarm;
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
	

}

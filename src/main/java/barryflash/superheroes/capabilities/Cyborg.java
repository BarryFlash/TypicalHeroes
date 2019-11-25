package barryflash.superheroes.capabilities;

public class Cyborg implements ICyborg {

	private boolean sonar;
	private int sonarTick;
	private boolean laser;
	private int laserTick;
	private int flyTick;
	private boolean fly;
	@Override
	public void setSonarCannon(boolean bool) {
		// TODO Auto-generated method stub
		sonar = bool;
	}

	@Override
	public boolean isSonarCannon() {
		// TODO Auto-generated method stub
		return sonar;
	}

	@Override
	public void setSonarTick(int tick) {
		// TODO Auto-generated method stub
		sonarTick = tick;
	}

	@Override
	public void incrementSonarTick() {
		// TODO Auto-generated method stub
		sonarTick++;
	}

	@Override
	public void decrementSonarTick() {
		// TODO Auto-generated method stub
		sonarTick--;
	}

	@Override
	public int getSonarTick() {
		// TODO Auto-generated method stub
		return sonarTick;
	}

	@Override
	public void setLaser(boolean bool) {
		// TODO Auto-generated method stub
		laser = bool;
	}

	@Override
	public boolean isLaser() {
		// TODO Auto-generated method stub
		return laser;
	}

	@Override
	public void setLaserTick(int tick) {
		// TODO Auto-generated method stub
		laserTick = tick;
	}

	@Override
	public void incrementLaserTick() {
		// TODO Auto-generated method stub
		laserTick++;
	}

	@Override
	public void decrementLaserTick() {
		// TODO Auto-generated method stub
		laserTick--;
	}

	@Override
	public int getLaserTick() {
		// TODO Auto-generated method stub
		return laserTick;
	}

	@Override
	public void setFly(boolean bool) {
		// TODO Auto-generated method stub
		fly = bool;
	}

	@Override
	public boolean isFlying() {
		// TODO Auto-generated method stub
		return fly;
	}

	@Override
	public void setFlyTick(int tick) {
		// TODO Auto-generated method stub
		flyTick = tick;
	}

	@Override
	public void incrementFlyTick() {
		// TODO Auto-generated method stub
		flyTick++;
	}

	@Override
	public void decrementFlyTick() {
		// TODO Auto-generated method stub
		flyTick--;
	}

	@Override
	public int getFlyTick() {
		// TODO Auto-generated method stub
		return flyTick;
	}

	
}

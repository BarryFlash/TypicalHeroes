package barryflash.superheroes.capabilities;

public class Portal implements IPortal {
	
	private boolean portalSpace1;
	private boolean portalSpace2;
	private boolean portalDoctorStrange1;
	private boolean portalDoctorStrange2;
	
	@Override
	public void setPortalSpace1() {
		// TODO Auto-generated method stub
		this.portalSpace1 = true;
	}

	@Override
	public void unsetPortalSpace1() {
		// TODO Auto-generated method stub
		this.portalSpace1 = false;
	}

	@Override
	public boolean isPortalSpace1() {
		// TODO Auto-generated method stub
		return this.portalSpace1;
	}

	@Override
	public void setPortalSpace2() {
		// TODO Auto-generated method stub
		this.portalSpace2 = true;
	}

	@Override
	public void unsetPortalSpace2() {
		// TODO Auto-generated method stub
		this.portalSpace2 = false;
	}

	@Override
	public boolean isPortalSpace2() {
		// TODO Auto-generated method stub
		return this.portalSpace2;
	}

	@Override
	public void setPortalDoctorStrange1() {
		// TODO Auto-generated method stub
		this.portalDoctorStrange1 = true;
	}

	@Override
	public void unsetPortalDoctorStrange1() {
		// TODO Auto-generated method stub
		this.portalDoctorStrange1 = false;
	}

	@Override
	public boolean isPortalDoctorStrange1() {
		// TODO Auto-generated method stub
		return this.portalDoctorStrange1;
	}

	@Override
	public void setPortalDoctorStrange2() {
		// TODO Auto-generated method stub
		this.portalDoctorStrange2 = true;
	}

	@Override
	public void unsetPortalDoctorStrange2() {
		// TODO Auto-generated method stub
		this.portalDoctorStrange2 = false;
	}

	@Override
	public boolean isPortalDoctorStrange2() {
		// TODO Auto-generated method stub
		return this.portalDoctorStrange2;
	}

}

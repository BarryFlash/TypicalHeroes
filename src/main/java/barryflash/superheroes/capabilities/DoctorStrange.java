package barryflash.superheroes.capabilities;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;

public class DoctorStrange implements IDoctorStrange {

	private boolean capeAlive;
	private boolean coveringEnemy;
	private boolean atpos1;
	private boolean atpos2;
	private boolean atpos3;
	private boolean atpos4;
	private boolean atpos5;
	private boolean atpos6;
	
	@Override
	public boolean isCapeAlive() {
		// TODO Auto-generated method stub
		return capeAlive;
	}

	@Override
	public boolean isCapeInOffense() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCapeInDefense() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCapeFollow() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCapeCoveringEnemy() {
		// TODO Auto-generated method stub
		return coveringEnemy;
	}

	@Override
	public void setCapeAlive() {
		this.capeAlive = true;
		
	}

	@Override
	public void setCapeInOffense() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCapeInDefense() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCapeFollow() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCapeCoveringEnemy() {
		this.coveringEnemy = true;
		
	}

	

	@Override
	public void setCapeNotAlive() {
		this.capeAlive = false;
		this.coveringEnemy = false;
	}
	private boolean eye;
	private BlockPos pos1;
	private BlockPos pos2;
	private BlockPos pos3;
	private BlockPos pos4;
	private BlockPos pos5;
	private BlockPos pos6;
	@Override
	public boolean isUsingEyeOfAgamotto() {
		// TODO Auto-generated method stub
		return eye;
	}

	@Override
	public void setEyeOfAgamotto() {
		// TODO Auto-generated method stub
		this.eye = true;
	}

	@Override
	public void setEntityPos1(BlockPos pos) {
		// TODO Auto-generated method stub
		this.pos1 = pos;
		
	}

	@Override
	public void setEntityPos2(BlockPos pos) {
		// TODO Auto-generated method stub
		this.pos2 = pos;
		
	}

	@Override
	public void setEntityPos3(BlockPos pos) {
		// TODO Auto-generated method stub
		this.pos3 = pos;
		
	}

	@Override
	public void setEntityPos4(BlockPos pos) {
		// TODO Auto-generated method stub
		this.pos4 = pos;
		
	}

	@Override
	public void setEntityPos5(BlockPos pos) {
		// TODO Auto-generated method stub
		this.pos5 = pos;
		
	}

	@Override
	public void setEntityPos6(BlockPos pos) {
		// TODO Auto-generated method stub
		this.pos6 = pos;
		
	}

	@Override
	public BlockPos getEntityPos1() {
		// TODO Auto-generated method stub
		return this.pos1;
	}

	@Override
	public BlockPos getEntityPos2() {
		// TODO Auto-generated method stub
		return this.pos2;
	}

	@Override
	public BlockPos getEntityPos3() {
		// TODO Auto-generated method stub
		return this.pos3;
	}

	@Override
	public BlockPos getEntityPos4() {
		// TODO Auto-generated method stub
		return this.pos4;
	}

	@Override
	public BlockPos getEntityPos5() {
		// TODO Auto-generated method stub
		return this.pos5;
	}

	@Override
	public BlockPos getEntityPos6() {
		// TODO Auto-generated method stub
		return this.pos6;
	}

	@Override
	public void unsetEyeOfAgamotto() {
		this.eye = false;
		
	}
	private boolean eyeofagamotto;
	@Override
	public boolean EyeofAgamottoInProgress() {
		// TODO Auto-generated method stub
		return this.eyeofagamotto;
	}

	@Override
	public void startEyeOfAgamotto() {
		// TODO Auto-generated method stub
		this.eyeofagamotto = true;
	}

	@Override
	public void endEyeOfAgamotto() {
		// TODO Auto-generated method stub
		this.eyeofagamotto = false;
		this.eye = false;
		this.atpos1 = false;
		this.atpos2 = false;
		this.atpos3 = false;
		this.atpos4 = false;
		this.atpos5 = false;
		this.atpos6 = false;
	}

	@Override
	public boolean atEntityPos1() {
		// TODO Auto-generated method stub
		return this.atpos1;
	}

	@Override
	public boolean atEntityPos2() {
		// TODO Auto-generated method stub
		return this.atpos2;
	}

	@Override
	public boolean atEntityPos3() {
		// TODO Auto-generated method stub
		return this.atpos3;
	}

	@Override
	public boolean atEntityPos4() {
		// TODO Auto-generated method stub
		return this.atpos4;
	}

	@Override
	public boolean atEntityPos5() {
		// TODO Auto-generated method stub
		return this.atpos5;
	}

	@Override
	public boolean atEntityPos6() {
		// TODO Auto-generated method stub
		return this.atpos6;
		
	}

	@Override
	public void setAtEntityPos1() {
		this.atpos1 = true;
		
	}

	@Override
	public void setAtEntityPos2() {
		// TODO Auto-generated method stub
		this.atpos2 = true;
	}

	@Override
	public void setAtEntityPos3() {
		// TODO Auto-generated method stub
		this.atpos3 = true;
	}

	@Override
	public void setAtEntityPos4() {
		// TODO Auto-generated method stub
		this.atpos4 = true;
	}

	@Override
	public void setAtEntityPos5() {
		// TODO Auto-generated method stub
		this.atpos5 = true;
	}

	@Override
	public void setAtEntityPos6() {
		// TODO Auto-generated method stub
		this.atpos6 = true;
	}

	@Override
	public void unsetAtEntityPos1() {
		// TODO Auto-generated method stub
		this.atpos1 = false;
	}

	@Override
	public void unsetAtEntityPos2() {
		// TODO Auto-generated method stub
		this.atpos2 = false;
	}

	@Override
	public void unsetAtEntityPos3() {
		// TODO Auto-generated method stub
		this.atpos3 = false;
	}

	@Override
	public void unsetAtEntityPos4() {
		// TODO Auto-generated method stub
		this.atpos4 = false;
	}

	@Override
	public void unsetAtEntityPos5() {
		// TODO Auto-generated method stub
		this.atpos5 = false;
	}

	@Override
	public void unsetAtEntityPos6() {
		// TODO Auto-generated method stub
		this.atpos6 = false;
	}
	private boolean beam;
	@Override
	public void setBeam() {
		
		beam = true;
	}

	@Override
	public void unsetBeam() {
	
		beam = false;
	}

	@Override
	public boolean isBeam() {
		// TODO Auto-generated method stub
		return beam;
	}
	
	
	

}

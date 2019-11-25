package barryflash.superheroes.capabilities;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;

public interface IDoctorStrange {

	public boolean isCapeAlive();
	public boolean isCapeInOffense();
	public boolean isCapeInDefense();
	public boolean isCapeFollow();
	public boolean isCapeCoveringEnemy();
	public boolean isUsingEyeOfAgamotto();
	public boolean EyeofAgamottoInProgress();
	public void setCapeAlive();
	public void setCapeNotAlive();
	public void setCapeInOffense();
	public void setCapeInDefense();
	public void setCapeFollow();
	public void setCapeCoveringEnemy();
	public void setEyeOfAgamotto();
	public void unsetEyeOfAgamotto();
	public void startEyeOfAgamotto();
	public void endEyeOfAgamotto();
	
	public void setEntityPos1(BlockPos pos);
	public void setEntityPos2(BlockPos pos);
	public void setEntityPos3(BlockPos pos);
	public void setEntityPos4(BlockPos pos);
	public void setEntityPos5(BlockPos pos);
	public void setEntityPos6(BlockPos pos);
	
	public boolean atEntityPos1();
	public boolean atEntityPos2();
	public boolean atEntityPos3();
	public boolean atEntityPos4();
	public boolean atEntityPos5();
	public boolean atEntityPos6();
	
	public void setAtEntityPos1();
	public void setAtEntityPos2();
	public void setAtEntityPos3();
	public void setAtEntityPos4();
	public void setAtEntityPos5();
	public void setAtEntityPos6();
	
	public void unsetAtEntityPos1();
	public void unsetAtEntityPos2();
	public void unsetAtEntityPos3();
	public void unsetAtEntityPos4();
	public void unsetAtEntityPos5();
	public void unsetAtEntityPos6();
	
	public BlockPos getEntityPos1();
	public BlockPos getEntityPos2();
	public BlockPos getEntityPos3();
	public BlockPos getEntityPos4();
	public BlockPos getEntityPos5();
	public BlockPos getEntityPos6();
	
	public void setBeam();
	public void unsetBeam();
	public boolean isBeam();
}

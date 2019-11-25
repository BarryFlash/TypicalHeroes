package barryflash.superheroes.capabilities;

import net.minecraft.util.math.BlockPos;

public interface IAquaman {

	public void setSource();
	public void unsetSource();
	public boolean isSourceActive();
	
	public void setsourcePos(BlockPos pos);
	public BlockPos getSourcePos();
}

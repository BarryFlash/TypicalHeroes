package barryflash.superheroes.capabilities;

import net.minecraft.util.math.BlockPos;

public interface IZeusAltar {
	public void addProgress(int progress);
	public void setProgress(int progress);
	public int getProgress();
	public boolean isProgressComplete();
	public void setInitialConnection(BlockPos pos);
	public void resetConnections();
	public void setEndConnection(BlockPos pos);
	public BlockPos getInitialConnection();
	public BlockPos getEndConnection();
}

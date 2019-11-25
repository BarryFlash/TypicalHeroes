package barryflash.superheroes.capabilities;

import net.minecraft.util.math.BlockPos;

public class ZeusAltar implements IZeusAltar {
	private int progress = 0;
	@Override
	public void addProgress(int progress) {
		// TODO Auto-generated method stub
		this.progress += progress;
	}

	@Override
	public void setProgress(int progress) {
		// TODO Auto-generated method stub
		this.progress = progress;
	}

	@Override
	public int getProgress() {
		// TODO Auto-generated method stub
		return this.progress;
	}

	@Override
	public boolean isProgressComplete() {
		if (this.progress >= 100) {
			return true;
		} else {
			return false;
		}
	}
	private BlockPos initial;
	private BlockPos end;
	@Override
	public void setInitialConnection(BlockPos pos) {
		initial = pos;
		
	}

	@Override
	public void resetConnections() {
		// TODO Auto-generated method stub
		initial = null;
		end = null;
	}

	@Override
	public void setEndConnection(BlockPos pos) {
		// TODO Auto-generated method stub
		end = pos;
	}

	@Override
	public BlockPos getInitialConnection() {
		// TODO Auto-generated method stub
		return initial;
	}

	@Override
	public BlockPos getEndConnection() {
		// TODO Auto-generated method stub
		return end;
	}
	

}

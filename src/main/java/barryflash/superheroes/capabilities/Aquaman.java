package barryflash.superheroes.capabilities;

import net.minecraft.util.math.BlockPos;

public class Aquaman implements IAquaman {
	private boolean source;
	@Override
	public void setSource() {
		// TODO Auto-generated method stub
		this.source = true;
	}

	@Override
	public void unsetSource() {
		// TODO Auto-generated method stub
		this.source = false;
	}

	@Override
	public boolean isSourceActive() {
		// TODO Auto-generated method stub
		return source;
	}
	private BlockPos sourcePos;
	@Override
	public void setsourcePos(BlockPos pos) {
		if (sourcePos == null) {
		sourcePos = pos;
		} else {
			sourcePos = null;
		}
	}

	@Override
	public BlockPos getSourcePos() {
		// TODO Auto-generated method stub
		return sourcePos;
	}

}

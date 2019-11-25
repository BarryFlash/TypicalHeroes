package barryflash.superheroes.capabilities;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class Loki implements ILoki {
	private boolean teleport;
	private Vec3d pos;
	private boolean invis;
	@Override
	public void setTeleport(boolean bool) {
		// TODO Auto-generated method stub
		teleport = bool;
	}

	@Override
	public boolean isTeleporting() {
		// TODO Auto-generated method stub
		return teleport;
	}

	@Override
	public void setTeleportingVec(Vec3d pos) {
		// TODO Auto-generated method stub
		this.pos = pos;
	}

	@Override
	public Vec3d getTeleportingVec() {
		// TODO Auto-generated method stub
		return pos;
	}

	@Override
	public void setInvisible(boolean bool) {
		// TODO Auto-generated method stub
		invis = bool;
	}

	@Override
	public boolean isInvisible() {
		// TODO Auto-generated method stub
		return invis;
	}
}

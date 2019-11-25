package barryflash.superheroes.capabilities;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public interface ILoki {

	public void setTeleport(boolean bool);
	public boolean isTeleporting();
	
	public void setTeleportingVec(Vec3d pos);
	public Vec3d getTeleportingVec();
	
	public void setInvisible(boolean bool);
	public boolean isInvisible();
}

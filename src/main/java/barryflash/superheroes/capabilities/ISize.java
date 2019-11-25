package barryflash.superheroes.capabilities;

import net.minecraft.entity.Entity;

public interface ISize {
	public void setSmall();
	public void resetSize();
	public void setBig();
	public boolean isSmall();
	public boolean isBig();
	
	public Entity getEntityHit();
	public void setEntityHit(Entity e);
}

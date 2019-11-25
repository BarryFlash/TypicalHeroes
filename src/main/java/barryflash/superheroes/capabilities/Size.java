package barryflash.superheroes.capabilities;

import net.minecraft.entity.Entity;

public class Size implements ISize{
	private boolean small;
	private boolean big;

	@Override
	public void setSmall() {
		// TODO Auto-generated method stub
		small = true;
	}

	@Override
	public void resetSize() {
		// TODO Auto-generated method stub
		small = false;
		big = false;
	}

	@Override
	public void setBig() {
		// TODO Auto-generated method stub
		big = true;
	}

	@Override
	public boolean isSmall() {
		// TODO Auto-generated method stub
		return small;
	}

	@Override
	public boolean isBig() {
		// TODO Auto-generated method stub
		return big;
	}
	private Entity ent;
	@Override
	public Entity getEntityHit() {
		// TODO Auto-generated method stub
		return ent;
	}

	@Override
	public void setEntityHit(Entity e) {
		ent = e;
		
	}
	
}

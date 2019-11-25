package barryflash.superheroes.client;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.EntityEvent;

public class EntityLocation extends EntityEvent{
	
	private final BlockPos entitylocation;
	
	 public EntityLocation(Entity entity, BlockPos entitylocation) {
		 super(entity);
		 this.entitylocation = entitylocation;
	 }
	 public BlockPos getEntityLocation()
	    {
	        return entitylocation;
	    }
}

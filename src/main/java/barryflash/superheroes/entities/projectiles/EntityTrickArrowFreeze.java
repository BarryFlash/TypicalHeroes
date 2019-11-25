package barryflash.superheroes.entities.projectiles;

import barryflash.superheroes.client.THSoundHandler;
import barryflash.superheroes.init.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityTrickArrowFreeze extends EntityTrickArrow {

	public EntityTrickArrowFreeze(World worldIn)
    {
        super(worldIn);
      
    }

    public EntityTrickArrowFreeze(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public EntityTrickArrowFreeze(World worldIn, EntityLivingBase shooter)
    {
        super(worldIn, shooter);
    }

	@Override
	protected ItemStack getArrowStack() {
		// TODO Auto-generated method stub
		return ItemStack.EMPTY;
	}

	
}

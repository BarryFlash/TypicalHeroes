package barryflash.superheroes.client;

import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class BraceletAnimation extends ModelPlayer
{

	
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
	    {
	        this.bipedLeftArmwear.rotationPointY = 1.0F;
	        this.bipedRightArmwear.rotationPointY = 1.0F;
	        this.bipedLeftArm.rotationPointY = 1.0F;
	        this.bipedRightArm.rotationPointY = 1.0F;
}
	public BraceletAnimation(float modelSize, boolean smallArmsIn) {
		super(modelSize, smallArmsIn);
		// TODO Auto-generated constructor stub
	}
	}

 
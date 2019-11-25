package barryflash.superheroes.capabilities;

import net.minecraft.entity.player.EntityPlayer;

public interface ISuperheroes {

	public boolean isSuperman(EntityPlayer player);
	public boolean isIronman(EntityPlayer player);
	public boolean isBatman(EntityPlayer player);
	public boolean isWonderWoman(EntityPlayer player);
	public boolean isAntman(EntityPlayer player);
	public boolean isWasp(EntityPlayer player);
	public boolean isIronmanReactor(EntityPlayer player);
	public boolean isHulk(EntityPlayer player);
}

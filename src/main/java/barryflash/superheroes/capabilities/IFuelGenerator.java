package barryflash.superheroes.capabilities;

import java.util.ArrayList;

import net.minecraft.tileentity.TileEntity;

public interface IFuelGenerator {

	public void addToList(TileEntity tile);
	public ArrayList<TileEntity> getList();
	
	public void removeFromList(TileEntity tile);
	
	
}

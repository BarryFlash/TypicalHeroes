package barryflash.superheroes.capabilities;

import java.util.ArrayList;

import net.minecraft.tileentity.TileEntity;

public class FuelGenerator implements IFuelGenerator {
	private ArrayList<TileEntity> list = new ArrayList<TileEntity>();
	@Override
	public void addToList(TileEntity tile) {
		// TODO Auto-generated method stub
		list.add(tile);
	}

	@Override
	public ArrayList<TileEntity> getList() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public void removeFromList(TileEntity tile) {
		list.remove(tile);		
	}

}

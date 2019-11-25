package barryflash.superheroes.util;

import net.minecraft.util.IStringSerializable;

public class EnumHandler {
	public static enum CarbonFiberTypes implements IStringSerializable {
		BASIC("basic", 0),
		RED("red", 1),
		BLACK("black", 2),
		YELLOW("yellow", 3),
		BLUE("blue", 4),
		;

		private int ID;
		private String name;
		
		private CarbonFiberTypes(String name, int ID) {
			this.ID = ID;
			this.name = name;
		}
		
		@Override
		public String getName() {
			return null;
		}
		public int getID() {
			return ID;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return getName();
		}
		
	}
}

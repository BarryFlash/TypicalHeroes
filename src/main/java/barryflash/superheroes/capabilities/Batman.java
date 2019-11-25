package barryflash.superheroes.capabilities;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

public class Batman implements IBatman {
	private int batarang;
	private boolean gliding;
	private ArrayList<Entity> list;
	private Entity ent;
	private static int MAX_BATARANGS = 4;
	private boolean[] cooldownArray = new boolean[MAX_BATARANGS+1];
	private int[] cooldownAmountArray = new int[MAX_BATARANGS+1];
	@Override
	public void setBatarang(int batarangType) {
		// TODO Auto-generated method stub
		batarang = batarangType;
	}

	@Override
	public boolean isBatarangActive(int batarangType) {
		if (batarang == batarangType) {
		return true;
		} else {
			return false;
		}
	}

	@Override
	public void resetBatarang() {
		batarang = 0;
		
	}

	@Override
	public int getActiveBatarangType() {
		// TODO Auto-generated method stub
		return batarang;
	}

	@Override
	public boolean areBatarangs() {
		if (batarang > 0) {
		return true;
		} else {
			return false;
		}
	}

	@Override
	public void setGliding() {
		// TODO Auto-generated method stub
		gliding = true;
	}

	@Override
	public void unsetGliding() {
		// TODO Auto-generated method stub
		gliding = false;
	}

	@Override
	public boolean isGliding() {
		// TODO Auto-generated method stub
		return gliding;
	}
	private int glidetick;
	@Override
	public int ticksGliding(int tick) {
		// TODO Auto-generated method stub
		return glidetick = tick;
	}

	@Override
	public int getGlideTicks() {
		// TODO Auto-generated method stub
		return glidetick;
	}
	private boolean batarangCooldown;
	private boolean batarangExplosiveCooldown;
	private boolean batarangPoisonCooldown;
	private boolean batarangElectricCooldown;
	private boolean smokebombCooldown;
	@Override
	public void setBatarangCooldown() {
		// TODO Auto-generated method stub
		this.batarangCooldown = true;
	}

	@Override
	public void unsetBatarangCooldown() {
		// TODO Auto-generated method stub
		this.batarangCooldown = false;
	}

	@Override
	public boolean isBatarangCooldown() {
		// TODO Auto-generated method stub
		return this.batarangCooldown;
	}

	@Override
	public void setBatarangExplosiveCooldown() {
		// TODO Auto-generated method stub
		this.batarangExplosiveCooldown = true;
	}

	@Override
	public void unsetBatarangExplosiveCooldown() {
		// TODO Auto-generated method stub
		this.batarangExplosiveCooldown = false;
	}

	@Override
	public boolean isBatarangExplosiveCooldown() {
		// TODO Auto-generated method stub
		return this.batarangExplosiveCooldown;
	}

	@Override
	public void setBatarangPoisonCooldown() {
		// TODO Auto-generated method stub
		this.batarangPoisonCooldown = true;
	}

	@Override
	public void unsetBatarangPoisonCooldown() {
		// TODO Auto-generated method stub
		this.batarangPoisonCooldown = false;
	}

	@Override
	public boolean isBatarangPoisonCooldown() {
		// TODO Auto-generated method stub
		return this.batarangPoisonCooldown;
	}

	@Override
	public void setBatarangElectricCooldown() {
		// TODO Auto-generated method stub
	this.batarangElectricCooldown = true;	
	}

	@Override
	public void unsetBatarangElectricCooldown() {
		// TODO Auto-generated method stub
		this.batarangElectricCooldown = false;
	}

	@Override
	public boolean isBatarangElectricCooldown() {
		// TODO Auto-generated method stub
		return this.batarangElectricCooldown;
	}

	@Override
	public void setSmokebombCooldown() {
		// TODO Auto-generated method stub
		this.smokebombCooldown = true;
	}

	@Override
	public void unsetSmokebombCooldown() {
		// TODO Auto-generated method stub
		this.smokebombCooldown = false;
	}

	@Override
	public boolean isSmokebombCooldown() {
		// TODO Auto-generated method stub
		return this.smokebombCooldown;
	}
	private Vec3d svec;
	private Vec3d evec;
	private boolean grapple;
	@Override
	public void setGrappleStartVec(Vec3d svec) {
		// TODO Auto-generated method stub
		this.svec = svec;
	}

	@Override
	public void setGrappleEndVec(Vec3d evec) {
		// TODO Auto-generated method stub
		this.evec = evec;
	}

	@Override
	public Vec3d getGrappleStartVec() {
		// TODO Auto-generated method stub
		return svec;
	}

	@Override
	public Vec3d getGrappleEndVec() {
		// TODO Auto-generated method stub
		return evec;
	}

	@Override
	public void shootGrapple() {
		// TODO Auto-generated method stub
		grapple = true;
	}

	@Override
	public void retractGrapple() {
		// TODO Auto-generated method stub
		grapple = false;
	}

	@Override
	public boolean isGrappleShot() {
		// TODO Auto-generated method stub
		return grapple;
	}
	private String type;
	private Entity entity;
	@Override
	public void setGrappleType(String type) {
		// TODO Auto-generated method stub
		this.type = type;
	}

	@Override
	public String getGrappleType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public void setGrappleEntity(Entity entity) {
		// TODO Auto-generated method stub
		this.entity = entity;
	}

	@Override
	public Entity getGrappleEntity() {
		// TODO Auto-generated method stub
		return entity;
	}

	@Override
	public void addEntityToList(Entity entity) {
		// TODO Auto-generated method stub
		list.add(entity);
	}

	@Override
	public ArrayList<Entity> getList() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public void clearList() {
		list.clear();
		
	}

	@Override
	public void setBatarangEntity(Entity entity) {
		// TODO Auto-generated method stub
		ent = entity;
	}

	@Override
	public Entity getBatarangEntity() {
		// TODO Auto-generated method stub
		return ent;
	}
	private boolean armor;
	@Override
	public void setArmorWorn(boolean armor) {
		 this.armor = armor;
		
	}
	
	@Override
	public boolean isArmorWorn() {
		// TODO Auto-generated method stub
		return armor;
	}

	@Override
	public int getBatarangCooldown(int index) {
		// TODO Auto-generated method stub
		return cooldownAmountArray[index];
	}

	@Override
	public void increaseBatarangCooldown(int index) {
		// TODO Auto-generated method stub
		cooldownAmountArray[index]++;
	}

	@Override
	public void setBatarangCooldown(int index, int amount) {
		// TODO Auto-generated method stub
		cooldownAmountArray[index] = amount;
	}
	
	@Override
	public int getMaxAmount() {
		// TODO Auto-generated method stub
		return MAX_BATARANGS;
	}


	@Override
	public boolean getBatarangCooldownBool(int index) {
		// TODO Auto-generated method stub
		return cooldownArray[index];
	}

	@Override
	public void setBatarangCooldownBool(int index, boolean bool) {
		cooldownArray[index] = bool;
		
	}

	@Override
	public void increaseTicksGliding() {
		glidetick++;
		
	}

	@Override
	public void setTicksGliding(int tick) {
		// TODO Auto-generated method stub
		glidetick = tick;
	}

	@Override
	public void increaseBatarangType() {
		// TODO Auto-generated method stub
		batarang++;
	}
}

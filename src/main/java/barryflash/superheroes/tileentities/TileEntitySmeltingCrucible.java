package barryflash.superheroes.tileentities;

import barryflash.superheroes.network.MessageRequestUpdateSmeltingCrucible;
import barryflash.superheroes.network.MessageUpdateSmeltingCrucible;
import barryflash.superheroes.network.NetworkHandler;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class TileEntitySmeltingCrucible extends TileEntity implements ITickable {
	private int count;
	public long lastChangeTime;
	private int smeltTime;
	private int titanium = 0;
	private int gold = 0;
	private int tg = 0;
	public int cookTime = 0;
	private float offset = 0.0F;
	private String currentItem = "none";
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setInteger("count", count);
		compound.setInteger("smeltTime", smeltTime);
		compound.setLong("lastChangeTime", lastChangeTime);
		compound.setInteger("titanium", titanium);
		compound.setInteger("gold", gold);
		compound.setInteger("tg", tg);
		compound.setInteger("cookTime", cookTime);
		compound.setInteger("smeltTime", smeltTime);
		compound.setFloat("offset", offset);
		compound.setString("currentItem", currentItem);
		return super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		count = compound.getInteger("count");
		smeltTime = compound.getInteger("smeltTime");
		lastChangeTime = compound.getLong("lastChangeTime");
		titanium = compound.getInteger("titanium");
		gold = compound.getInteger("gold");
		tg = compound.getInteger("tg");
		cookTime = compound.getInteger("cookTime");
		smeltTime = compound.getInteger("smeltTime");
		offset = compound.getFloat("offset");
		currentItem = compound.getString("currentItem");
		super.readFromNBT(compound);
	}
	public float getOffset() {
		return offset;
	}
	public int getCookTime() {
		return cookTime;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public boolean isSmelting() {
		return this.smeltTime > 0;
	}
	public void setSmeltTime(int time) {
		smeltTime = time;
	}
	public int getSmeltTime() {
		return smeltTime;
	}
	public void setCookTime(int time) {
		cookTime = time;
	}
	public void setTitanium(int num) {
		titanium = num;
	}
	public void setGold(int num) {
		gold = num;
	}
	public void setTitaniumGold(int num) {
		tg = num;
	}
	public void setOffset(float num) {
		offset = num;
	}
	public int getTitanium() {
		return titanium;
	}
	public int getGold() {
		return gold;
	}
	public String getCurrentItemSmelted() {
		return currentItem;
	}
	public void setCurrentItemSmelted(String item) {
		this.currentItem = item;
	}
	public void addTitanium() {
		if (this.isSmelting() == false && this.getCount() <= 6) {
		titanium++;
		smeltTime = 400;
		markDirty();
		NetworkHandler.sendToAllAround(new MessageUpdateSmeltingCrucible(TileEntitySmeltingCrucible.this), new NetworkRegistry.TargetPoint(world.provider.getDimension(), pos.getX(), pos.getY(), pos.getZ(), 64));
		}
	}
	public void addGold() {
		if (this.isSmelting() == false && this.getCount() <= 6) {
		gold++;
		smeltTime = 400;
		markDirty();
		NetworkHandler.sendToAllAround(new MessageUpdateSmeltingCrucible(TileEntitySmeltingCrucible.this), new NetworkRegistry.TargetPoint(world.provider.getDimension(), pos.getX(), pos.getY(), pos.getZ(), 64));
		}
	}
	public void removeTitanium(int amount) {
		if (this.isSmelting() == false && titanium > 0) {
			titanium=titanium-amount;
			count=count-amount;
			cookTime = cookTime - 400*amount;
		markDirty();
		NetworkHandler.sendToAllAround(new MessageUpdateSmeltingCrucible(TileEntitySmeltingCrucible.this), new NetworkRegistry.TargetPoint(world.provider.getDimension(), pos.getX(), pos.getY(), pos.getZ(), 64));
		}
	}
	public void removeGold(int amount) {
		if (this.isSmelting() == false && gold > 0) {
			gold=gold-amount;
			count=count-amount;
		cookTime = cookTime - 400*amount;
		markDirty();
		NetworkHandler.sendToAllAround(new MessageUpdateSmeltingCrucible(TileEntitySmeltingCrucible.this), new NetworkRegistry.TargetPoint(world.provider.getDimension(), pos.getX(), pos.getY(), pos.getZ(), 64));
		}
	}
	public void addTitaniumGold() {
		if (this.isSmelting() == false && this.getCount() <= 6) {
		tg=tg + 6;
		count = 6;
		smeltTime = 400;
		lastChangeTime = world.getTotalWorldTime();
		markDirty();
		NetworkHandler.sendToAllAround(new MessageUpdateSmeltingCrucible(TileEntitySmeltingCrucible.this), new NetworkRegistry.TargetPoint(world.provider.getDimension(), pos.getX(), pos.getY(), pos.getZ(), 64));
		}
	}
	public void removeTitaniumGold() {
		if (this.isSmelting() == false && tg >= 6) {
		tg = tg -6;
		count = count - 6;
		cookTime = 0;
		markDirty();
		NetworkHandler.sendToAllAround(new MessageUpdateSmeltingCrucible(TileEntitySmeltingCrucible.this), new NetworkRegistry.TargetPoint(world.provider.getDimension(), pos.getX(), pos.getY(), pos.getZ(), 64));
		}
	}
	public int getTitaniumGold() {
		return tg;
	}
	public void incrementCount() {
		if (this.isSmelting() == false && this.getCount() <= 6) {
		count++;
		
		offset = 0;
		
		markDirty();
		lastChangeTime = world.getTotalWorldTime();
		NetworkHandler.sendToAllAround(new MessageUpdateSmeltingCrucible(TileEntitySmeltingCrucible.this), new NetworkRegistry.TargetPoint(world.provider.getDimension(), pos.getX(), pos.getY(), pos.getZ(), 64));
		
		}
	}
	
	public void decrementCount() {
		count--;
		markDirty();
	}
	@Override
	public void onChunkUnload() {
		// TODO Auto-generated method stub
		super.onChunkUnload();
		if (world.isRemote) {
			//NetworkHandler.sendToServer(new MessageRequestUpdateSmeltingCrucible(this));
		}
	}
	@Override
	public void onLoad() {
		if (world.isRemote) {
			//NetworkHandler.sendToServer(new MessageRequestUpdateSmeltingCrucible(this));
		}
	
	}

	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return new AxisAlignedBB(getPos(), getPos().add(1, 2, 1));
	}
	public void update() {
		if (this.isSmelting() && world.getBlockState(pos.down()).getBlock() == Blocks.FIRE) {
			if (this.getCurrentItemSmelted().equals("titaniumgold")) {
			--this.smeltTime;
			this.cookTime = this.cookTime + 6;
			} else {
				--this.smeltTime;
				this.cookTime++;
			}
			markDirty();
			NetworkHandler.sendToAllAround(new MessageUpdateSmeltingCrucible(TileEntitySmeltingCrucible.this), new NetworkRegistry.TargetPoint(world.provider.getDimension(), pos.getX(), pos.getY(), pos.getZ(), 64));
		}
		
		if (this.getTitanium() >= 3 && this.getGold() >= 3 && !this.isSmelting()) {
			this.setCurrentItemSmelted("titaniumgold");
			this.cookTime = 0;
			this.setTitanium(0);
			this.setGold(0);
			this.addTitaniumGold();
			markDirty();
			NetworkHandler.sendToAllAround(new MessageUpdateSmeltingCrucible(TileEntitySmeltingCrucible.this), new NetworkRegistry.TargetPoint(world.provider.getDimension(), pos.getX(), pos.getY(), pos.getZ(), 64));
		}
		
	}
}

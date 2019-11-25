package barryflash.superheroes.tileentities;

import barryflash.superheroes.energy.CustomEnergyStorage;
import barryflash.superheroes.init.ModBlocks;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.network.MessageRequestUpdateDnaExtractor;
import barryflash.superheroes.network.MessageUpdateDnaExtractor;
import barryflash.superheroes.network.MessageUpdateSmeltingCrucible;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.recipes.NanoCompacterRecipes;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityDnaExtractor extends TileEntity implements ITickable {

	public ItemStackHandler inventory = new ItemStackHandler(2) {
		@Override
		protected void onContentsChanged(int slot) {
			if (!world.isRemote) {
				lastChangeTime = world.getTotalWorldTime();
				NetworkHandler.sendToAllAround(new MessageUpdateDnaExtractor(TileEntityDnaExtractor.this), new NetworkRegistry.TargetPoint(world.provider.getDimension(), pos.getX(), pos.getY(), pos.getZ(), 64));
			}
		}
	};

	private CustomEnergyStorage storage = new CustomEnergyStorage(5000, 30, 20);
	private int energy = storage.getEnergyStored();
	public int cookTime = 0;
	private ItemStack smelting = ItemStack.EMPTY;
	public long lastChangeTime;
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setTag("inventory", inventory.serializeNBT());
		storage.writeToNBT(compound);
		compound.setInteger("energyGUI", energy);
		compound.setInteger("cookTime", cookTime);
		compound.setLong("lastChangeTime", lastChangeTime);
		return compound;
	}
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.readFromNBT(compound);
		inventory.deserializeNBT(compound.getCompoundTag("inventory"));
		storage.readFromNBT(compound);
		energy = compound.getInteger("energyGUI");
		cookTime = compound.getInteger("cookTime");
		lastChangeTime = compound.getLong("lastChangeTime");

	}
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == CapabilityEnergy.ENERGY) return true;
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
		return super.hasCapability(capability, facing);
	}
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return (T) inventory;
		if (capability == CapabilityEnergy.ENERGY) return (T) storage;
		return super.getCapability(capability, facing);
	}
	
	@Override
	public void update() {

			if (storage.getEnergyStored() != 0) {
			energy = storage.getEnergyStored();
			}
			if (!world.isRemote) {
			ItemStack[] inputs = new ItemStack[] {inventory.getStackInSlot(0)};
				
			if (storage.getEnergyStored() > 20) {
				if (cookTime > 0) {
					if(!inputs[0].isEmpty())
					{
						storage.extractEnergy(20, false);
						
						cookTime++;
						if (cookTime % 20 == 1) {
							WorldServer w = (WorldServer) getWorld();
							w.spawnParticle(EnumParticleTypes.DRAGON_BREATH, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 4, 0, 0, 0, 0.01D, null);
							w.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 4, 0, 0, 0, 0.01D, null);
						}
						
					} else {
						cookTime = 0;
					}
					
					if (cookTime == 200) {
						
						inputs[0].shrink(1);
						inventory.setStackInSlot(0, inputs[0]);
						if (!inventory.getStackInSlot(1).isEmpty()) {
							inventory.getStackInSlot(1).grow(1);
							
						} else {
							inventory.insertItem(1, smelting, false);
							
						}
						smelting = ItemStack.EMPTY;
						cookTime = 0;
						markDirty();
						return;
					}
				} else {
					if(!inputs[0].isEmpty())
					{
						ItemStack output = ItemStack.EMPTY;
						if (inputs[0].getItem() == ModItems.KRYPTONIAN_BONE) {
							output = new ItemStack(ModItems.DNA_FRAGMENT);
						} else {
							output = ItemStack.EMPTY;
						}
						
						if(!output.isEmpty())
						{
							if (inventory.getStackInSlot(1).getItem() == output.getItem() || inventory.getStackInSlot(1).isEmpty()) {
								if (inventory.getStackInSlot(1).getCount() < 64) {
									smelting = output;
									cookTime++;
									markDirty();
								}
							}
						}
					}
				}
			}
			}
	}
	@Override
	public void onLoad() {
		if (world.isRemote) {
			NetworkHandler.sendToServer(new MessageRequestUpdateDnaExtractor(this));
		}
	}
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return new AxisAlignedBB(getPos(), getPos().add(1, 2, 1));
	}

	public int getEnergy() {
		return energy;
	}
	
	public int getMaxEnergyStored()

	{

		return this.storage.getMaxEnergyStored();

	}
	public int getField(int id) 

	{

		switch(id) 

		{
		case 0:

			return this.cookTime;
		case 1:

			return this.energy;

		default:

			return 0;

		}

	}



	public void setField(int id, int value) 

	{

		switch(id) 

		{
		case 0:

			this.cookTime = value;

			break;
		case 1:

			this.energy = value;

		}
		

	}
}

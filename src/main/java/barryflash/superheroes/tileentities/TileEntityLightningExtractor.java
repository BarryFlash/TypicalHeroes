package barryflash.superheroes.tileentities;

import barryflash.superheroes.energy.CustomEnergyStorage;
import barryflash.superheroes.init.ModBlocks;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.network.MessageRequestUpdateDnaExtractor;
import barryflash.superheroes.network.MessageRequestUpdateLightningExtractor;
import barryflash.superheroes.network.MessageUpdateDnaExtractor;
import barryflash.superheroes.network.MessageUpdateLightningExtractor;
import barryflash.superheroes.network.MessageUpdateSmeltingCrucible;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.recipes.NanoCompacterRecipes;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.effect.EntityLightningBolt;
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

public class TileEntityLightningExtractor extends TileEntity implements ITickable {

	public ItemStackHandler inventory = new ItemStackHandler(2) {
		@Override
		protected void onContentsChanged(int slot) {
			if (!world.isRemote) {
				lastChangeTime = world.getTotalWorldTime();
				NetworkHandler.sendToAllAround(new MessageUpdateLightningExtractor(TileEntityLightningExtractor.this), new NetworkRegistry.TargetPoint(world.provider.getDimension(), pos.getX(), pos.getY(), pos.getZ(), 64));
			}
		}
	};

	private CustomEnergyStorage storage = new CustomEnergyStorage(5000, 30, 20);
	private int energy = storage.getEnergyStored();
	public int cookTime = 0, lightning = 0;
	private ItemStack smelting = ItemStack.EMPTY;
	public long lastChangeTime;
	public boolean canHarness = false;
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setTag("inventory", inventory.serializeNBT());
		storage.writeToNBT(compound);
		compound.setInteger("energyGUI", energy);
		compound.setInteger("cookTime", cookTime);
		compound.setLong("lastChangeTime", lastChangeTime);
		compound.setInteger("lightning", lightning);
		compound.setBoolean("harness", canHarness);
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
		lightning = compound.getInteger("lightning");
		canHarness = compound.getBoolean("harness");

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
	
			
			if (this.getPos().getY() >= 100 && this.world.getWorldInfo().isThundering()) {
				canHarness = true;
			} else {
				canHarness = false;
			}
		
		
			if (canHarness && lightning <= 995) {
				int rand = this.world.rand.nextInt(1000);
				if (rand >= 0 && rand <= 20) {
					EntityLightningBolt lightning = new EntityLightningBolt(world, this.pos.getX(), this.pos.getY() + 1, this.pos.getZ(), false);
					world.addWeatherEffect(lightning);
					this.lightning += 50;
				}
			}
			if (storage.getEnergyStored() != 0) {
			energy = storage.getEnergyStored();
			}
			if (!world.isRemote) {
			ItemStack[] inputs = new ItemStack[] {inventory.getStackInSlot(0)};
			if (storage.getEnergyStored() > 20 && lightning > 100) {
				if (cookTime > 0) {
					
					
					if (cookTime == 200) {
						
						
						if (!inventory.getStackInSlot(1).isEmpty()) {
							inventory.getStackInSlot(1).grow(1);
							
						} else {
							inventory.insertItem(1, new ItemStack(ModItems.LIGHTNING_ESSENCE, 1), false);
							
						}
						cookTime = 0;
						markDirty();
						return;
					} else {
						storage.extractEnergy(20, false);
						lightning -= 5;
						cookTime++;
					}
				} else {
					if(!inputs[0].isEmpty())
					{
						
							if (inventory.getStackInSlot(1).getItem() == ModItems.LIGHTNING_ESSENCE || inventory.getStackInSlot(1).isEmpty()) {
								if (inventory.getStackInSlot(1).getCount() < 64) {
									cookTime++;
									inputs[0].shrink(1);
									inventory.setStackInSlot(0, inputs[0]);
									markDirty();
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
			NetworkHandler.sendToServer(new MessageRequestUpdateLightningExtractor(this));
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
		case 2:

			return this.lightning;


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
			break;
		case 2:

			this.lightning = value;
			break;
		}
		

	}
}

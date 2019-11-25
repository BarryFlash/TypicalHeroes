package barryflash.superheroes.tileentities;

import java.util.ArrayList;

import barryflash.superheroes.energy.CustomEnergyStorage;
import barryflash.superheroes.init.ModBlocks;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.network.MessageFuelGeneratorAddConnectionClient;
import barryflash.superheroes.network.MessageFuelGeneratorRemoveConnection;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.recipes.NanoCompacterRecipes;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityFuelGenerator extends TileEntity implements ITickable {

	ItemStackHandler inventory = new ItemStackHandler(1);
	private CustomEnergyStorage storage = new CustomEnergyStorage(5000, 0, 20);
	private int energy = storage.getEnergyStored();
	public int cookTime = 0;
	private int listCount = 0;
	private ItemStack smelting = ItemStack.EMPTY;
	private ArrayList<TileEntity> list = new ArrayList<TileEntity>();
	private ArrayList<BlockPos> posList = new ArrayList<BlockPos>();
	private int player;
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setTag("inventory", inventory.serializeNBT());
		storage.writeToNBT(compound);
		compound.setInteger("energyGUI", energy);
		compound.setInteger("cookTime", cookTime);
		compound.setInteger("listCount", list.size());
		if (player != 0) {
		compound.setInteger("player", player);
		}
		NBTTagList tagList = new NBTTagList();
		 for(int i = 0; i < list.size(); i++)
		 {
			if (list.get(i) != null) {
		  BlockPos s = list.get(i).getPos();
		  if(s != null)
		  {
		   NBTTagCompound tag = new NBTTagCompound();
		   tag.setLong("MyString" + i, s.toLong());
		   tagList.appendTag(tag);
		  }
			}
		 }
		 compound.setTag("MyStringList", tagList);
		return compound;
	}
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		inventory.deserializeNBT(compound.getCompoundTag("inventory"));
		storage.readFromNBT(compound);
		energy = compound.getInteger("energyGUI");
		cookTime = compound.getInteger("cookTime");
		listCount = compound.getInteger("listCount");
		if (compound.getInteger("player") != 0) {
		player = compound.getInteger("player");
		}
		NBTTagList tagList = compound.getTagList("MyStringList", Constants.NBT.TAG_COMPOUND);
		 for(int i = 0; i < tagList.tagCount(); i++)
		 {
		  NBTTagCompound tag = tagList.getCompoundTagAt(i);
		  long s = tag.getLong("MyString" + i);
		  posList.add(i, BlockPos.fromLong(s));
		 }

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

			if (!world.isRemote) {
				
				if (world.getEntityByID(player) instanceof EntityPlayer) {
					for (int i = 0; i < posList.size(); i++) {
						
						if (!list.contains(world.getTileEntity(posList.get(i)))) {
							
							list.add(i, world.getTileEntity(posList.get(i)));
							NetworkHandler.sendTo(new MessageFuelGeneratorAddConnectionClient(this.getPos(), posList.get(i)), (EntityPlayerMP) world.getEntityByID(player));
						}

					}
					for (int i = 0; i < list.size(); i++) {
						
						if (world.getTileEntity(list.get(i).getPos()) == null) {
							
							list.remove(i);
							NetworkHandler.sendTo(new MessageFuelGeneratorRemoveConnection(this.getPos(), i), (EntityPlayerMP) world.getEntityByID(player));
						}
					}
				}
			}
			if (storage.getEnergyStored() != 0) {
			energy = storage.getEnergyStored();
			}
			ItemStack input = inventory.getStackInSlot(0);
			if (storage.getEnergyStored() < storage.getMaxEnergyStored()) {
			if (!input.isEmpty()) {
				if (input.getItem() == Items.COAL) {
					if (cookTime == 0) {
					cookTime++;
					input.shrink(1);
					inventory.setStackInSlot(0, input);
					return;
					}
				}
			} 
			if (cookTime > 0) {
				cookTime++;
				storage.receiveEnergyInternal(10, false);
				if (cookTime == 80) {
					
					
					cookTime = 0;
					markDirty();
				}
			}
			} else {
				cookTime = 0;
				markDirty();
			}
			if (list.size() > 0 && storage.getEnergyStored() > 0) {
				IEnergyStorage handler = null;
	 			for (int i = 0; i < list.size(); i++) {
		            if (list.get(i).hasCapability(CapabilityEnergy.ENERGY, null)) {
		            	
		                handler = list.get(i).getCapability(CapabilityEnergy.ENERGY, null);
		                if (handler.canReceive()) {
		                	
		                	int amount = 10/list.size();
		                	if (handler.getEnergyStored() < handler.getMaxEnergyStored()) {
		    

		                    	
		                        int filled = handler.receiveEnergy(amount, false);
		
		                        storage.extractEnergy(amount, false);
			                   markDirty();
		                    	}
		                    
		                }
		            }
				}
			}
			for (EnumFacing neighbor : EnumFacing.VALUES)

            {

                TileEntity e = world.getTileEntity(pos.offset(neighbor));

                EnumFacing from = neighbor.getOpposite();
                if (e == null)

                    continue;
                


                IEnergyStorage handler = null;

                if (e.hasCapability(CapabilityEnergy.ENERGY, from))

                {
                	
                    handler = e.getCapability(CapabilityEnergy.ENERGY, from);
                    if (handler.canReceive()) {

                    	int drain = storage.extractEnergy(20, true);

                        if (drain > 0) {

                            int filled = handler.receiveEnergy(drain, false);

                            storage.extractEnergy(filled, false);
		                   markDirty();
                	}
                    }

                 

                }
            }
			
	}
	public void setPlayer(EntityPlayer player) {
		this.player = player.getEntityId();
	}
	public void addToList(TileEntity tile) {
		if (!list.contains(tile)) {
		list.add(tile);
		markDirty();
		}
	}
	public void removeFromList(int index) {
		if (index < list.size()) {
			list.remove(index);
			markDirty();
		}
	}
	public void removeTileFromList(TileEntity tile) {
		if (list.contains(tile)) {
			list.remove(tile);
			markDirty();
			}
	}
	public ArrayList<TileEntity> getList() {
		return list;
	}
	public void setList(ArrayList<TileEntity> tileList) {
		list = tileList;
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

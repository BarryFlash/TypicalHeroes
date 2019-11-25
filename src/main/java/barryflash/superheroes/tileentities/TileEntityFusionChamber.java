package barryflash.superheroes.tileentities;

import java.util.Random;

import barryflash.superheroes.blocks.BlockFusionChamberRegular;
import barryflash.superheroes.energy.CustomEnergyStorage;
import barryflash.superheroes.entities.particles.ParticleSpawnerDoctorStrangeShields;
import barryflash.superheroes.init.ModBlocks;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.network.MessageRequestUpdateDnaExtractor;
import barryflash.superheroes.network.MessageRequestUpdateFusionChamber;
import barryflash.superheroes.network.MessageUpdateDnaExtractor;
import barryflash.superheroes.network.MessageUpdateFusionChamber;
import barryflash.superheroes.network.MessageUpdateSmeltingCrucible;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.recipes.NanoCompacterRecipes;
import net.minecraft.block.Block;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityFusionChamber extends TileEntity implements ITickable {
	
	public ItemStackHandler inventory = new ItemStackHandler(1) {
		@Override
		protected void onContentsChanged(int slot) {
			if (!world.isRemote) {
				lastChangeTime = world.getTotalWorldTime();
				NetworkHandler.sendToAllAround(new MessageUpdateFusionChamber(TileEntityFusionChamber.this), new NetworkRegistry.TargetPoint(world.provider.getDimension(), pos.getX(), pos.getY(), pos.getZ(), 64));
			}
		}
	};
	public CustomEnergyStorage storage = new CustomEnergyStorage(10000, 30, 20);
	public int energy = storage.getEnergyStored();
	public int gas = 0;
	public String gasType = "none";
	public long lastChangeTime;
	private int tick = 0;
	public boolean built = false;
	public int insideX = 0, insideY = 0, insideZ = 0;
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		storage.writeToNBT(compound);
		compound.setTag("inventory", inventory.serializeNBT());;
		compound.setInteger("gas", gas);
		compound.setString("gasType", gasType);
		compound.setLong("lastChangeTime", lastChangeTime);
		compound.setInteger("tick", tick);
		compound.setBoolean("built", built);
		compound.setInteger("energyGUI", energy);
		compound.setInteger("x", insideX);
		compound.setInteger("y", insideY);
		compound.setInteger("z", insideZ);
		return compound;
	}
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.readFromNBT(compound);
		storage.readFromNBT(compound);
		inventory.deserializeNBT(compound.getCompoundTag("inventory"));
		gas = compound.getInteger("gas");
		gasType = compound.getString("gasType");
		lastChangeTime = compound.getLong("lastChangeTime");
		tick = compound.getInteger("tick");
		built = compound.getBoolean("built");	
		energy = compound.getInteger("energyGUI");
		insideX = compound.getInteger("x");
		insideY = compound.getInteger("y");
		insideZ = compound.getInteger("z");
		
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
			if (storage.getEnergyStored() != 0) {
				energy = storage.getEnergyStored();
				
				}
		
		
		 	
		if (inventory.getStackInSlot(0).getItem() == ModItems.RADIATION_VIAL) {
			if (gasType.equals("none") || gasType.equals("radiation")) {
				if (gas < 100) {
					gasType = "radiation";
					gas += 25;
					inventory.getStackInSlot(0).shrink(1);
					markDirty();
				}
			}
		} else if (inventory.getStackInSlot(0).getItem() == ModItems.SUPERSOLDIER_SERUM) {
			if (gasType.equals("none") || gasType.equals("super soldier serum")) {
				if (gas < 100) {
					
					gasType = "super soldier serum";
					gas += 25;
					inventory.getStackInSlot(0).shrink(1);
					markDirty();
				}
			}
		} else if (inventory.getStackInSlot(0).getItem() == Item.getItemFromBlock(ModBlocks.MOTHER_BOX)) {
			if (gasType.equals("none") || gasType.equals("motherbox")) {
				if (gas < 100) {
					gasType = "motherbox";
					gas += 25;
					inventory.getStackInSlot(0).shrink(1);
					markDirty();
				}
			}
		} else if (inventory.getStackInSlot(0).getItem() == ModItems.LIGHTNING_ESSENCE) {
			if (gasType.equals("none") || gasType.equals("lightning")) {
				if (gas < 100) {
					gasType = "lightning";
					gas += 25;
					inventory.getStackInSlot(0).shrink(1);
					markDirty();
				}
			}
		}
		
		if (tick < 20) {
			tick++;
		} else {
			tick = 0;
			
			for (EnumFacing neighbor : EnumFacing.VALUES)

            {
				if (neighbor != EnumFacing.UP && neighbor != EnumFacing.DOWN) {
                Block e = world.getBlockState(pos.offset(neighbor).down()).getBlock();
                BlockPos core = pos.offset(neighbor);

                EnumFacing from = neighbor.getOpposite();
                if (e == null || e != ModBlocks.FUSION_CHAMBER_CORE)

                    continue;
                //Level 1:
                insideX = core.getX();
                insideY = core.getY();
                insideZ = core.getZ();
                BlockPos secorner1 = core.offset(EnumFacing.EAST).offset(EnumFacing.SOUTH);
                BlockPos swcorner1 = core.offset(EnumFacing.SOUTH).offset(EnumFacing.WEST);
                BlockPos nwcorner1 = core.offset(EnumFacing.WEST).offset(EnumFacing.NORTH);
                BlockPos necorner1 = core.offset(EnumFacing.NORTH).offset(EnumFacing.EAST);
                BlockPos n1 = core.offset(EnumFacing.NORTH);
                BlockPos s1 = core.offset(EnumFacing.SOUTH);
                BlockPos e1 = core.offset(EnumFacing.EAST);
                BlockPos w1 = core.offset(EnumFacing.WEST);
                //Level 2:
                BlockPos secorner2 = secorner1.up();
                BlockPos swcorner2 = swcorner1.up();
                BlockPos nwcorner2 = nwcorner1.up();
                BlockPos necorner2 = necorner1.up();
                BlockPos n2 = n1.up();
                BlockPos s2 = s1.up();
                BlockPos e2 = e1.up();
                BlockPos w2 = w1.up();
                //Level 3:
                BlockPos secorner3 = secorner2.up();
                BlockPos swcorner3 = swcorner2.up();
                BlockPos nwcorner3 = nwcorner2.up();
                BlockPos necorner3 = necorner2.up();
                BlockPos n3 = n2.up();
                BlockPos s3 = s2.up();
                BlockPos e3 = e2.up();
                BlockPos w3 = w2.up();
                if (world.getBlockState(secorner1).getBlock() == ModBlocks.FUSION_CHAMBER_BLOCK
                		&& world.getBlockState(swcorner1).getBlock() == ModBlocks.FUSION_CHAMBER_BLOCK
                		&& world.getBlockState(nwcorner1).getBlock() == ModBlocks.FUSION_CHAMBER_BLOCK
                		&& world.getBlockState(necorner1).getBlock() == ModBlocks.FUSION_CHAMBER_BLOCK
                		&& (world.getBlockState(n1).getBlock() == ModBlocks.FUSION_CHAMBER_BLOCK
                		|| world.getBlockState(n1).getBlock() == ModBlocks.FUSION_CHAMBER_DOOR
                		|| world.getBlockState(n1).getBlock() == world.getBlockState(this.getPos()).getBlock())
                		&& (world.getBlockState(s1).getBlock() == ModBlocks.FUSION_CHAMBER_BLOCK
                		|| world.getBlockState(s1).getBlock() == ModBlocks.FUSION_CHAMBER_DOOR
                		|| world.getBlockState(s1).getBlock() == world.getBlockState(this.getPos()).getBlock())
                		&& (world.getBlockState(e1).getBlock() == ModBlocks.FUSION_CHAMBER_BLOCK
                		|| world.getBlockState(e1).getBlock() == ModBlocks.FUSION_CHAMBER_DOOR
                		|| world.getBlockState(e1).getBlock() == world.getBlockState(this.getPos()).getBlock())
                		&& (world.getBlockState(w1).getBlock() == ModBlocks.FUSION_CHAMBER_BLOCK
                		|| world.getBlockState(w1).getBlock() == ModBlocks.FUSION_CHAMBER_DOOR
                		|| world.getBlockState(w1).getBlock() == world.getBlockState(this.getPos()).getBlock())) {
                	if (world.getBlockState(secorner2).getBlock() == ModBlocks.FUSION_CHAMBER_BLOCK
                    		&& world.getBlockState(swcorner2).getBlock() == ModBlocks.FUSION_CHAMBER_BLOCK
                    		&& world.getBlockState(nwcorner2).getBlock() == ModBlocks.FUSION_CHAMBER_BLOCK
                    		&& world.getBlockState(necorner2).getBlock() == ModBlocks.FUSION_CHAMBER_BLOCK
                    		&& (world.getBlockState(n2).getBlock() == ModBlocks.FUSION_CHAMBER_BLOCK
                    		|| world.getBlockState(n2).getBlock() == ModBlocks.FUSION_CHAMBER_DOOR
                    		|| world.getBlockState(n2).getBlock() == ModBlocks.FUSION_CHAMBER_WINDOW)
                    		&& (world.getBlockState(s2).getBlock() == ModBlocks.FUSION_CHAMBER_BLOCK
                    		|| world.getBlockState(s2).getBlock() == ModBlocks.FUSION_CHAMBER_DOOR
                    		|| world.getBlockState(s2).getBlock() == ModBlocks.FUSION_CHAMBER_WINDOW)
                    		&& (world.getBlockState(e2).getBlock() == ModBlocks.FUSION_CHAMBER_BLOCK
                    		|| world.getBlockState(e2).getBlock() == ModBlocks.FUSION_CHAMBER_DOOR
                    		|| world.getBlockState(e2).getBlock() == ModBlocks.FUSION_CHAMBER_WINDOW)
                    		&& (world.getBlockState(w2).getBlock() == ModBlocks.FUSION_CHAMBER_BLOCK
                    		|| world.getBlockState(w2).getBlock() == ModBlocks.FUSION_CHAMBER_DOOR
                    		|| world.getBlockState(w2).getBlock() == ModBlocks.FUSION_CHAMBER_WINDOW)) {
                		if (world.getBlockState(secorner3).getBlock() == ModBlocks.FUSION_CHAMBER_BLOCK
                        		&& world.getBlockState(swcorner3).getBlock() == ModBlocks.FUSION_CHAMBER_BLOCK
                        		&& world.getBlockState(nwcorner3).getBlock() == ModBlocks.FUSION_CHAMBER_BLOCK
                        		&& world.getBlockState(necorner3).getBlock() == ModBlocks.FUSION_CHAMBER_BLOCK
                        		&& world.getBlockState(n3).getBlock() == ModBlocks.FUSION_CHAMBER_BLOCK
                        		&& world.getBlockState(s3).getBlock() == ModBlocks.FUSION_CHAMBER_BLOCK
                        		&& world.getBlockState(e3).getBlock() == ModBlocks.FUSION_CHAMBER_BLOCK
                        		&& world.getBlockState(w3).getBlock() == ModBlocks.FUSION_CHAMBER_BLOCK) {
                			built = true;
                			markDirty();
                    	} else {
                    		built = false;
                    		markDirty();
                    	}
                	} else {
                		built = false;
                		markDirty();
                	}
                } else {
            		built = false;
            		markDirty();
            	}
				}
            }
            }
		}
		
		
			
	}
	@Override
	public void onLoad() {
		if (world.isRemote) {
			NetworkHandler.sendToServer(new MessageRequestUpdateFusionChamber(this));
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
	public int getGas() {
		return gas;
	}
	
	public String getGasType()

	{

		return gasType;

	}
	public int getField(int id) 

	{

		switch(id) 

		{
		case 0:

			return this.gas;
		case 1:
			if (gasType.equals("none")) {
				return -1;
			} else if (gasType.equals("radiation")) {
				return 0;
			} else if (gasType.equals("super soldier serum")) {
				return 1;
			} else if (gasType.equals("motherbox")) {
				return 2;
			} else if (gasType.equals("lightning")) {
				return 3;
			} else {
				System.out.println(gasType);
			}
		case 2:
			if (built) {
				return 1;
			} else {
				return 0;
			}
		case 3:
			return insideX;
		case 4:
			return insideY;
		case 5:
			return insideZ;
		case 6:
			return energy;
		default:

			return 0;

		}

	}



	public void setField(int id, int value) 

	{
	
		switch(id) 

		{
		case 0:

			this.gas = value;

		case 1:
			if (value == -1) {
				this.gasType = "none";
			}
			if (value == 0) {
				this.gasType = "radiation";
			} else if (value == 1) {
				this.gasType = "super soldier serum";
			} else if (value == 2) {
				this.gasType = "motherbox";
			} else if (value == 3) {
				this.gasType = "lightning";
			} 

		case 2:
			if (value == 1) {
				built = true;
			} else {
				built = false;
			}
		case 3:
			
			insideX = value;
		case 4:
			insideY = value;
			
		case 5:
			insideZ = value;
			
		case 6:
			energy = value;
		}
		
		
	}
}

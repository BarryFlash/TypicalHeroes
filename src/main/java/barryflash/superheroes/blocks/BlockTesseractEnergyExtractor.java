package barryflash.superheroes.blocks;

import java.util.List;
import java.util.Random;

import barryflash.superheroes.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.energy.IEnergyStorage;

public class BlockTesseractEnergyExtractor extends Block implements IEnergyStorage {
	public BlockTesseractEnergyExtractor(String unlocalizedName, String registryName) {
		super(Material.IRON);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MODID, registryName));
		this.setHardness(4);
		this.setResistance(20);

	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	 public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4)
	    {
	        list.add("\u00A7l" + "\u00A7b" + "Block that extracts energy from tesseract and makes it usable.");
	    }

	@Override
	public int receiveEnergy(int maxReceive, boolean simulate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int extractEnergy(int maxExtract, boolean simulate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEnergyStored() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxEnergyStored() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean canExtract() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canReceive() {
		// TODO Auto-generated method stub
		return false;
	}
	}

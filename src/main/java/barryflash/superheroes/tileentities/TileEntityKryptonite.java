package barryflash.superheroes.tileentities;

import java.util.ArrayList;
import java.util.List;

import barryflash.superheroes.capabilities.ISuperman;
import barryflash.superheroes.capabilities.SupermanProvider;
import barryflash.superheroes.energy.CustomEnergyStorage;
import barryflash.superheroes.init.ModBlocks;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ItemSupermanArmor;
import barryflash.superheroes.network.MessageRequestUpdateDnaExtractor;
import barryflash.superheroes.network.MessageUpdateDnaExtractor;
import barryflash.superheroes.network.MessageUpdateSmeltingCrucible;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.recipes.NanoCompacterRecipes;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
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

public class TileEntityKryptonite extends TileEntity implements ITickable {

	private ArrayList<EntityPlayer> playerList = new ArrayList<EntityPlayer>();

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		return compound;
	}
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.readFromNBT(compound);


	}
	
	@Override
	public void update() {

		if (!playerList.isEmpty()) {
			for (int i = 0; i < playerList.size(); i++) {
				ISuperman supercap = playerList.get(i).getCapability(SupermanProvider.SUPERMAN_CAP, null);
				if (supercap.isAffectedByKryptonite()) {
				supercap.setKrpyonite(false);
				}
			}
			playerList.clear();
			}
		double k1 = this.getPos().getX() + 12;
		double l1 = this.getPos().getX() - 12;
		double i2 = this.getPos().getY() + 12;
		double i1 = this.getPos().getY() - 12;
		double j2 = this.getPos().getZ() + 12;
		double j1 = this.getPos().getZ() - 12;
    		
		List<EntityPlayer> list = this.world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(k1, i2, j2, l1, i1, j1));
		for (int k2 = 0; k2 < list.size(); ++k2) {
			EntityPlayer entity = (EntityPlayer)list.get(k2);
			
    		if (ItemSupermanArmor.isWearingFullSet(entity, ModItems.SupermanChest, ModItems.SupermanLeggings, ModItems.SupermanBoots)) {
    			ISuperman supercap = entity.getCapability(SupermanProvider.SUPERMAN_CAP, null);
    			
    			if (!supercap.isAffectedByKryptonite()) {
    				supercap.setKrpyonite(true);
    				if (supercap.isUsingHeatVision()) {
    					supercap.unsetHeatVision();
    				}
    				if (supercap.isFlying()) {
    					supercap.unsetFlying();
    				}
    				if (supercap.isUsingXRay()) {
    					supercap.unsetXRay();
    				}
    				if (supercap.getFlyTicks() > 0) {
    					supercap.setFlyTicks(0);
    				}
    				playerList.add(entity);
    			}
    		}
    	}
			
	}
	public ArrayList<EntityPlayer> getList() {
		return this.playerList;
	}
}

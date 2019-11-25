package barryflash.superheroes.client.gui;

import barryflash.superheroes.SuperheroesMod;
import barryflash.superheroes.client.gui.container.ContainerInfinityGauntlet;
import barryflash.superheroes.client.gui.container.InventoryInfinityGauntlet;
import barryflash.superheroes.container.ContainerDnaExtractor;
import barryflash.superheroes.container.ContainerFuelGenerator;
import barryflash.superheroes.container.ContainerFusionChamber;
import barryflash.superheroes.container.ContainerLightningExtractor;
import barryflash.superheroes.container.ContainerNanoCompacter;
import barryflash.superheroes.container.ContainerSuitMaker;
import barryflash.superheroes.tileentities.TileEntityDnaExtractor;
import barryflash.superheroes.tileentities.TileEntityFuelGenerator;
import barryflash.superheroes.tileentities.TileEntityFusionChamber;
import barryflash.superheroes.tileentities.TileEntityLightningExtractor;
import barryflash.superheroes.tileentities.TileEntityNanoCompacter;
import barryflash.superheroes.tileentities.TileEntitySuitMaker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	public static final int FUEL_GENERATOR = 0;
	public static final int NANO_COMPACTER = 1;
	public static final int DNA_EXTRACTOR = 2;
	public static final int FUSION_CHAMBER = 3;
	public static final int SUIT_MAKER = 4;
	public static final int ZEUS_SHRINE = 5;
	public static final int LIGHTNING_EXTRACTOR = 6;
	//public static final int SUIT_MAKER = 2;
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == FUEL_GENERATOR) return new ContainerFuelGenerator(player.inventory, (TileEntityFuelGenerator)world.getTileEntity(new BlockPos(x,y,z)));
		if(ID == NANO_COMPACTER) return new ContainerNanoCompacter(player.inventory, (TileEntityNanoCompacter)world.getTileEntity(new BlockPos(x,y,z)));
		if(ID == DNA_EXTRACTOR) return new ContainerDnaExtractor(player.inventory, (TileEntityDnaExtractor)world.getTileEntity(new BlockPos(x,y,z)));
		if(ID == FUSION_CHAMBER) return new ContainerFusionChamber(player.inventory, (TileEntityFusionChamber)world.getTileEntity(new BlockPos(x,y,z)));
		if(ID == LIGHTNING_EXTRACTOR) return new ContainerLightningExtractor(player.inventory, (TileEntityLightningExtractor)world.getTileEntity(new BlockPos(x,y,z)));
		//if(ID == SUIT_MAKER) return new ContainerSuitMaker(player.inventory, (TileEntitySuitMaker)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == FUEL_GENERATOR) return new GuiFuelGenerator(player.inventory, (TileEntityFuelGenerator)world.getTileEntity(new BlockPos(x,y,z)));
		if(ID == NANO_COMPACTER) return new GuiNanoCompacter(player.inventory, (TileEntityNanoCompacter)world.getTileEntity(new BlockPos(x,y,z)));
		if(ID == DNA_EXTRACTOR) return new GuiDnaExtractor(player.inventory, (TileEntityDnaExtractor)world.getTileEntity(new BlockPos(x,y,z)));
		if(ID == FUSION_CHAMBER) return new GuiFusionChamber(player.inventory, (TileEntityFusionChamber)world.getTileEntity(new BlockPos(x,y,z)));
		if(ID == SUIT_MAKER) return new GuiSuitMaker();
		if(ID == ZEUS_SHRINE) return new GuiZeusAltar();
		if(ID == LIGHTNING_EXTRACTOR) return new GuiLightningExtractor(player.inventory, (TileEntityLightningExtractor)world.getTileEntity(new BlockPos(x,y,z)));
		//if(ID == SUIT_MAKER) return new GuiSuitMaker(player.inventory, (TileEntitySuitMaker)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}
}

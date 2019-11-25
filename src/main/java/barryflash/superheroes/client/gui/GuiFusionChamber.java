package barryflash.superheroes.client.gui;

import java.awt.Color;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import barryflash.superheroes.Reference;
import barryflash.superheroes.capabilities.FusionChamberProvider;
import barryflash.superheroes.capabilities.IFusionChamber;
import barryflash.superheroes.container.ContainerDnaExtractor;
import barryflash.superheroes.container.ContainerFusionChamber;
import barryflash.superheroes.container.ContainerNanoCompacter;
import barryflash.superheroes.entities.particles.ParticleSpawnerDoctorStrangeShields;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.network.MessageAddSuitToInventoryServer;
import barryflash.superheroes.network.MessageFusionChamberEnergyUpdate;
import barryflash.superheroes.network.MessageFusionChamberUpdateGas;
import barryflash.superheroes.network.MessageRequestUpdateFusionChamber;
import barryflash.superheroes.network.NetworkHandler;
import barryflash.superheroes.tileentities.TileEntityDnaExtractor;
import barryflash.superheroes.tileentities.TileEntityFusionChamber;
import barryflash.superheroes.tileentities.TileEntityNanoCompacter;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.energy.CapabilityEnergy;

public class GuiFusionChamber extends GuiContainer {
	private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID, "textures/gui/fusion_chamber.png");
	private final InventoryPlayer player;
	private final TileEntityFusionChamber tileentity;
	private String error = "None";
	public GuiFusionChamber(InventoryPlayer player, TileEntityFusionChamber tileentity) {
		super(new ContainerFusionChamber(player, tileentity));
		this.player = player;
		this.tileentity = tileentity;
		this.xSize = 255;
		this.ySize = 154;
	}
	public boolean isHovering(int mouseX, int mouseY, int posX, int posY, int width, int height) {
		if (mouseX >= posX && mouseX <= posX + width && mouseY >= posY && mouseY <= posY + height) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
		if (this.isHovering(mouseX, mouseY, this.guiLeft + 8, this.guiTop + 130, 16, 16)) {
			this.drawHoveringText("Clear tank", mouseX, mouseY);
		}
		if (this.isHovering(mouseX, mouseY, this.guiLeft + 93, this.guiTop + 15, 50, 16)) {
			this.drawHoveringText("Release gas into chamber", mouseX, mouseY);
		}
		if (this.isHovering(mouseX, mouseY, this.guiLeft + 146, this.guiTop + 15, 16, 16)) {
			this.drawHoveringText(error, mouseX, mouseY);
		}
		if (this.isHovering(mouseX, mouseY, this.guiLeft + 231, this.guiTop + 13, 16, 73)) {
			this.drawHoveringText(tileentity.getEnergy() + "/" + tileentity.getMaxEnergyStored() + " FE", mouseX, mouseY);
		}
		if (this.isHovering(mouseX, mouseY, this.guiLeft + 8, this.guiTop + 10, 16, 73)) {
			ArrayList<String> list = new ArrayList<String>();
			list.add(tileentity.gas + "/100");
			list.add("Type: " + tileentity.gasType);
			this.drawHoveringText(list, mouseX, mouseY, mc.fontRenderer);
		}
	}
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRenderer.drawString("Inventory", 52, 54, Color.DARK_GRAY.getRGB());
		this.fontRenderer.drawString("Release", 98, 19, Color.WHITE.getRGB());
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		this.mc.getTextureManager().bindTexture(TEXTURES);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		int barY = tileentity.gas * 73/100;
		if (tileentity.gasType == "radiation") {
		this.drawTexturedModalRect(this.guiLeft + 8, this.guiTop + 10, 16, 161, 16, barY);
		} else if (tileentity.gasType == "super soldier serum") {
			this.drawTexturedModalRect(this.guiLeft + 8, this.guiTop + 10, 32, 161, 16, barY);
		} else if (tileentity.gasType == "motherbox") {
			this.drawTexturedModalRect(this.guiLeft + 8, this.guiTop + 10, 64, 161, 16, barY);
		} else if (tileentity.gasType == "lightning") {
			this.drawTexturedModalRect(this.guiLeft + 8, this.guiTop + 10, 173, 161, 16, barY);
		}
		if (tileentity.built && tileentity.gas == 100 && tileentity.getEnergy() == 10000 && (player.player.getPosition().equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ))  || player.player.getPosition().add(1, 0, -1).equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ))  || player.player.getPosition().add(-1, 0, 1).equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ)) || player.player.getPosition().add(0, 0, 1).equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ))  || player.player.getPosition().add(0, 0, -1).equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ))  || player.player.getPosition().add(1, 0, 0).equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ))  || player.player.getPosition().add(-1, 0, 0).equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ)) || player.player.getPosition().add(1, 0, 1).equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ)) || player.player.getPosition().add(-1, 0, -1).equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ))) && player.player.inventory.armorItemInSlot(0).isEmpty()
				&& player.player.inventory.armorItemInSlot(1).isEmpty()
				&& player.player.inventory.armorItemInSlot(2).isEmpty()
				&& player.player.inventory.armorItemInSlot(3).isEmpty()) {
				error = "Fusion Chamber completed.";
			if (this.isHovering(mouseX, mouseY, this.guiLeft + 93, this.guiTop + 15, 50, 16)) {
				this.drawTexturedModalRect(this.guiLeft + 93, this.guiTop + 15, 80, 193, 50, 16);
			} else {
				this.drawTexturedModalRect(this.guiLeft + 93, this.guiTop + 15, 80, 177, 50, 16);
			}
			this.drawTexturedModalRect(this.guiLeft + 146, this.guiTop + 15, 146, 161, 16, 16);
		} else {
			
			this.drawTexturedModalRect(this.guiLeft + 93, this.guiTop + 15, 80, 161, 50, 16);
			this.drawTexturedModalRect(this.guiLeft + 146, this.guiTop + 15, 146, 177, 16, 16);
			if (!tileentity.built) {
				error = "Fusion Chamber not completed. Look for instructions in the Typical Machine Unit.";
			} else {
				if (tileentity.getEnergy() != 10000) {
					error = "Not enough energy.";
				} else {
					if (tileentity.gas != 100) {
						error = "Not enough substance stored.";
					} else {
						if (!player.player.getPosition().equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ))  && !player.player.getPosition().add(0, 0, 1).equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ))  && !player.player.getPosition().add(0, 0, -1).equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ)) && !player.player.getPosition().add(1, 0, 0).equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ))  && !player.player.getPosition().add(-1, 0, 0).equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ)) && !player.player.getPosition().add(1, 0, 1).equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ)) && !player.player.getPosition().add(1, 0, -1).equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ))  && !player.player.getPosition().add(-1, 0, 1).equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ)) && !player.player.getPosition().add(-1, 0, -1).equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ))) {
							error = "Stand inside the chamber.";
						} else {
							if (!player.player.inventory.armorItemInSlot(0).isEmpty()
									|| !player.player.inventory.armorItemInSlot(1).isEmpty()
									|| !player.player.inventory.armorItemInSlot(2).isEmpty()
									|| !player.player.inventory.armorItemInSlot(3).isEmpty()) {
								error = "Remove armor.";
							}
						}
					}
				}
			}
		}
		if (tileentity.gas > 0) {
			if (this.isHovering(mouseX, mouseY, this.guiLeft + 8, this.guiTop + 130, 16, 16)) {
				this.drawTexturedModalRect(this.guiLeft + 8, this.guiTop + 130, 130, 193, 16, 16);
			} else {
				this.drawTexturedModalRect(this.guiLeft + 8, this.guiTop + 130, 130, 177, 16, 16);
			}
		} else {
		this.drawTexturedModalRect(this.guiLeft + 8, this.guiTop + 130, 130, 161, 16, 16);
		}
		int barYEnergy = tileentity.getEnergy() * 73/tileentity.getMaxEnergyStored();
		this.drawTexturedModalRect(this.guiLeft + 231, this.guiTop + 13, 0, 161, 16, 73 - barYEnergy);
	}
	@Override
	public void onGuiClosed() {
		// TODO Auto-generated method stub
		super.onGuiClosed();
		//EntityPlayer player = Minecraft.getMinecraft().player;
		//IFusionChamber fccap = player.getCapability(FusionChamberProvider.FUSION_CHAMBER_CAP, null);
		//BlockPos front = tileentity.getPos().offset(Minecraft.getMinecraft().world.getBlockState(tileentity.getPos()).getValue(BlockHorizontal.FACING), 1);
		//player.setPosition(front.getX() + 0.5, front.getY(), front.getZ() + 0.5);
		//fccap.setInside(false);
		
	}
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		// TODO Auto-generated method stub
		super.mouseClicked(mouseX, mouseY, mouseButton);
		if (tileentity.gas > 0) {
		if (this.isHovering(mouseX, mouseY, this.guiLeft + 8, this.guiTop + 130, 16, 16)) {
			
			tileentity.gasType = "none";
			tileentity.gas = 0;
			NetworkHandler.sendToServer(new MessageFusionChamberUpdateGas(tileentity.getPos(), 0, "none"));
		
		}
		}
		if (this.isHovering(mouseX, mouseY, this.guiLeft + 93, this.guiTop + 15, 50, 16)) {
			if (tileentity.built && tileentity.gas == 100 && tileentity.getEnergy() == 10000 && (player.player.getPosition().equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ))  || player.player.getPosition().add(0, 0, 1).equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ))  || player.player.getPosition().add(0, 0, -1).equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ)) || player.player.getPosition().add(1, 0, 0).equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ))  || player.player.getPosition().add(0, 0, 1).equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ)) || player.player.getPosition().add(1, 0, -1).equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ))  || player.player.getPosition().add(-1, 0, 1).equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ)) || player.player.getPosition().add(1, 0, 1).equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ)) || player.player.getPosition().add(-1, 0, -1).equals(new BlockPos(tileentity.insideX, tileentity.insideY, tileentity.insideZ))) && player.player.inventory.armorItemInSlot(0).isEmpty()
					&& player.player.inventory.armorItemInSlot(1).isEmpty()
					&& player.player.inventory.armorItemInSlot(2).isEmpty()
					&& player.player.inventory.armorItemInSlot(3).isEmpty()) {
							Random rand = mc.world.rand;
								if (tileentity.gasType == "radiation") {
									player.player.inventory.armorInventory.set(3, new ItemStack(ModItems.HulkHead));
									player.player.inventory.armorInventory.set(2, new ItemStack(ModItems.HulkChest));
									player.player.inventory.armorInventory.set(1, new ItemStack(ModItems.HulkPants));
									player.player.inventory.armorInventory.set(0, new ItemStack(ModItems.HulkFeet));
									for (int i = 0; i < 150; i++) {
										ParticleSpawnerDoctorStrangeShields.spawnParticle("custom", tileentity.insideX + rand.nextFloat(), tileentity.insideY + rand.nextFloat()*2, tileentity.insideZ + rand.nextFloat(), 0, 0, 0, new float[] {0.1F, 0.6F, 0.1F});
									}
									NetworkHandler.sendToServer(new MessageAddSuitToInventoryServer(
											new ItemStack(ModItems.HulkHead),
											new ItemStack(ModItems.HulkChest),
											new ItemStack(ModItems.HulkPants),
											 new ItemStack(ModItems.HulkFeet)));
								}
								if (tileentity.gasType == "super soldier serum") {
									player.player.inventory.armorInventory.set(3, new ItemStack(ModItems.CaptainAmericaHelmet));
									player.player.inventory.armorInventory.set(2, new ItemStack(ModItems.CaptainAmericaChest));
									player.player.inventory.armorInventory.set(1, new ItemStack(ModItems.CaptainAmericaLeggings));
									player.player.inventory.armorInventory.set(0, new ItemStack(ModItems.CaptainAmericaBoots));
									for (int i = 0; i < 150; i++) {
										ParticleSpawnerDoctorStrangeShields.spawnParticle("custom", tileentity.insideX + rand.nextFloat(), tileentity.insideY + rand.nextFloat()*2, tileentity.insideZ + rand.nextFloat(), 0, 0, 0, new float[] {0.1F, 0.45F, 0.5F});
									}
									NetworkHandler.sendToServer(new MessageAddSuitToInventoryServer(
											new ItemStack(ModItems.CaptainAmericaHelmet),
											new ItemStack(ModItems.CaptainAmericaChest),
											new ItemStack(ModItems.CaptainAmericaLeggings),
											 new ItemStack(ModItems.CaptainAmericaBoots)));
								}
								if (tileentity.gasType == "motherbox") {
									player.player.inventory.armorInventory.set(3, new ItemStack(ModItems.CyborgHelmet));
									player.player.inventory.armorInventory.set(2, new ItemStack(ModItems.CyborgChest));
									player.player.inventory.armorInventory.set(1, new ItemStack(ModItems.CyborgLegs));
									player.player.inventory.armorInventory.set(0, new ItemStack(ModItems.CyborgBoots));
									for (int i = 0; i < 150; i++) {
										ParticleSpawnerDoctorStrangeShields.spawnParticle("custom", tileentity.insideX + rand.nextFloat(), tileentity.insideY + rand.nextFloat()*2, tileentity.insideZ + rand.nextFloat(), 0, 0, 0, new float[] {0.5F, 0.3F, 0.1F});
									}
									NetworkHandler.sendToServer(new MessageAddSuitToInventoryServer(
											new ItemStack(ModItems.CyborgHelmet),
											new ItemStack(ModItems.CyborgChest),
											new ItemStack(ModItems.CyborgLegs),
											 new ItemStack(ModItems.CyborgBoots)));
								}
								if (tileentity.gasType == "lightning") {
									player.player.inventory.armorInventory.set(3, new ItemStack(ModItems.FlashMask));
									player.player.inventory.armorInventory.set(2, new ItemStack(ModItems.FlashChest));
									player.player.inventory.armorInventory.set(1, new ItemStack(ModItems.FlashLeggings));
									player.player.inventory.armorInventory.set(0, new ItemStack(ModItems.FlashBoots));
									for (int i = 0; i < 150; i++) {
										ParticleSpawnerDoctorStrangeShields.spawnParticle("custom", tileentity.insideX + rand.nextFloat(), tileentity.insideY + rand.nextFloat()*2, tileentity.insideZ + rand.nextFloat(), 0, 0, 0, new float[] {0.1F, 0.7F, 0.72F});
									}
									NetworkHandler.sendToServer(new MessageAddSuitToInventoryServer(
											new ItemStack(ModItems.FlashMask),
											new ItemStack(ModItems.FlashChest),
											new ItemStack(ModItems.FlashLeggings),
											 new ItemStack(ModItems.FlashBoots)));
								}
							tileentity.gas = 0;
							tileentity.gasType = "none";
							tileentity.energy = 0;
							NetworkHandler.sendToServer(new MessageFusionChamberUpdateGas(tileentity.getPos(), tileentity.gas, tileentity.gasType));
							NetworkHandler.sendToServer(new MessageFusionChamberEnergyUpdate(tileentity.getPos()));
							
			
				
			}
		}
	}

}

package barryflash.superheroes.client.gui;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import barryflash.superheroes.Reference;
import barryflash.superheroes.capabilities.FlashProvider;
import barryflash.superheroes.capabilities.IFlash;
import barryflash.superheroes.capabilities.ISpecialEffects;
import barryflash.superheroes.capabilities.SpecialEffectsProvider;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.items.armor.ArmorBase;
import barryflash.superheroes.items.armor.ItemAntmanArmor;
import barryflash.superheroes.items.armor.ItemBatmanArmor;
import barryflash.superheroes.items.armor.ItemBlackWidowArmor;
import barryflash.superheroes.items.armor.ItemCaptainAmericaArmor;
import barryflash.superheroes.items.armor.ItemCyborgArmor;
import barryflash.superheroes.items.armor.ItemFlashArmor;
import barryflash.superheroes.items.armor.ItemGeneralZodArmor;
import barryflash.superheroes.items.armor.ItemHawkeyeArmor;
import barryflash.superheroes.items.armor.ItemHulkArmor;
import barryflash.superheroes.items.armor.ItemIronmanMark50ArcReactorArmor;
import barryflash.superheroes.items.armor.ItemIronmanMark50Armor;
import barryflash.superheroes.items.armor.ItemLokiArmor;
import barryflash.superheroes.items.armor.ItemShazamArmor;
import barryflash.superheroes.items.armor.ItemSupermanArmor;
import barryflash.superheroes.items.armor.ItemThorArmor;
import barryflash.superheroes.items.armor.ItemWaspArmor;
import barryflash.superheroes.items.armor.ItemWonderWomanArmor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GuiGunAmmoIndicatorOverlay extends Gui {
	
	private static final ResourceLocation suit_info = new ResourceLocation(Reference.MODID, "textures/gui/suit_info.png");
	private static final ResourceLocation speed = new ResourceLocation(Reference.MODID, "textures/gui/speed.png");
	@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent event) {
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.player;
		if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			if (ItemFlashArmor.isWearingFlash(player)) {
				IFlash flashcap = player.getCapability(FlashProvider.FLASH_CAP, null);
				int height = event.getResolution().getScaledHeight();
				int width = event.getResolution().getScaledWidth();
				GlStateManager.pushMatrix();
				GlStateManager.enableBlend();
				GlStateManager.color(1, 1, 1);
				mc.renderEngine.bindTexture(speed);
				GlStateManager.translate(width - 55, height/2 - 32, 0);
				GlStateManager.scale(1.5F, 1.5F, 1);
				drawTexturedModalRect(0, 0, 0, 0, 25, 65);
				drawTexturedModalRect(0, 0, 25, 0, 25, 65 - 65*flashcap.getSpeedLevel()/6);
				GlStateManager.disableBlend();
				GlStateManager.popMatrix();
				drawCenteredString(mc.fontRenderer, "Speed Level:", width - 40, height/2 - 52, 0x66C3E2);
				drawCenteredString(mc.fontRenderer, flashcap.getSpeedLevel() +"/6", width - 40, height/2 - 42, 0x66C3E2);
			}
			if (player.getHeldItemMainhand().getItem() == ModItems.PISTOL) {
				ItemStack pistol = player.getHeldItemMainhand();
				if (pistol.hasTagCompound() && pistol.getTagCompound().hasKey("Bullets") && pistol.getTagCompound().hasKey("ReloadTicks") && pistol.getTagCompound().hasKey("Reload")) {
				drawCenteredString(mc.fontRenderer, "Ammo:", event.getResolution().getScaledWidth() - 50, event.getResolution().getScaledHeight() - 50, 0xFFFFFF);
				drawCenteredString(mc.fontRenderer, pistol.getTagCompound().getInteger("Bullets") + "/8", event.getResolution().getScaledWidth() - 50, event.getResolution().getScaledHeight() - 40, 0xFFFFFF);
				if (pistol.getTagCompound().getBoolean("Reload")) {
				drawCenteredString(mc.fontRenderer, "Reloading...", event.getResolution().getScaledWidth() - 50, event.getResolution().getScaledHeight() - 30, 0xFFFFFF);
				}
				}
			}
			if (player.getHeldItemOffhand().getItem() == ModItems.PISTOL) {
				
				ItemStack pistol = player.getHeldItemOffhand();
				if (pistol.hasTagCompound() && pistol.getTagCompound().hasKey("Bullets") && pistol.getTagCompound().hasKey("ReloadTicks") && pistol.getTagCompound().hasKey("Reload")) {
				
				drawCenteredString(mc.fontRenderer, "Ammo:", event.getResolution().getScaledWidth() - event.getResolution().getScaledWidth() + 50, event.getResolution().getScaledHeight() - 50, 0xFFFFFF);
				drawCenteredString(mc.fontRenderer, pistol.getTagCompound().getInteger("Bullets") + "/8", event.getResolution().getScaledWidth() - event.getResolution().getScaledWidth()  + 50, event.getResolution().getScaledHeight() - 40, 0xFFFFFF);
				if (pistol.getTagCompound().getBoolean("Reload")) {
				drawCenteredString(mc.fontRenderer, "Reloading...", event.getResolution().getScaledWidth() - event.getResolution().getScaledWidth()  + 50, event.getResolution().getScaledHeight() - 30, 0xFFFFFF);
				}
				}
			}
		}
		if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
			if (ItemGeneralZodArmor.isWearingFullSet(player) || ItemLokiArmor.isWearingFullSet(player) || ItemHawkeyeArmor.isWearingFullSet(player) || ItemBlackWidowArmor.isWearingFullSet(player) || ItemCyborgArmor.isWearingFullSet(player) || ItemCaptainAmericaArmor.isWearingFullSet(player) || ItemFlashArmor.isWearingFlash(player) || ItemThorArmor.isWearingFullSet(player) || ItemHulkArmor.isWearingHulk(player) || ItemShazamArmor.isWearingShazam(player) || ItemIronmanMark50Armor.isWearingFullSet(player, ModItems.IronManMk50Helmet, ModItems.IronManMk50Chest, ModItems.IronManMk50Legs, ModItems.IronManMk50Boots) || ItemWonderWomanArmor.isWearingFullSet(player, ModItems.WonderWomanTiara, ModItems.WonderWomanChestplate, ModItems.WonderWomanSkirt, ModItems.WonderWomanBoots) || ItemBatmanArmor.isWearingFullSet(player, ModItems.BatmanCowl, ModItems.BatmanChest, ModItems.BatmanLeggings, ModItems.BatmanBoots) || ItemSupermanArmor.isWearingFullSet(player, ModItems.SupermanChest, ModItems.SupermanLeggings, ModItems.SupermanBoots) || ItemIronmanMark50ArcReactorArmor.isWearingReactor(player, ModItems.IronManArcReactor)) {
				ISpecialEffects specialcap = player.getCapability(SpecialEffectsProvider.SPECIALEFFECTS_CAP, null);
				if (specialcap.getSuitInfo()) {
					int height = event.getResolution().getScaledHeight();
					int width = event.getResolution().getScaledWidth();
					drawRect(0, height/2 - 75, width, height-height/2 + 80, 0x992A6060);
					drawRect(0, height/2 - 85, width, height/2 -75, 0xFF57C5C6);
					drawRect(0, height-height/2 + 85, width, height-height/2 + 75, 0xFF57C5C6);
					GlStateManager.pushMatrix();
					GlStateManager.translate(width/2, height/2 - 70, 0);
					GlStateManager.scale(1.5F, 1.5F, 1);
					ArmorBase item = (ArmorBase) player.inventory.armorItemInSlot(2).getItem();
					drawCenteredString(mc.fontRenderer, "Suit: " + ArmorBase.getName(player.inventory.armorItemInSlot(2).getItem()) + " (Tier " + item.getTier() +")", 0, 0, 0x57C5C6);
					GlStateManager.popMatrix();
					drawCenteredString(mc.fontRenderer, "Armor: +" + item.getArmor(), width/10, height/2 - 68, 0x57C5C6);
					drawCenteredString(mc.fontRenderer, "HP: +" + item.getHP(), width/4, height/2 - 68, 0x57C5C6);
					drawCenteredString(mc.fontRenderer, "Speed: " + item.getSpeed(item), (width - width/10), height/2 - 68, 0x57C5C6);
					drawCenteredString(mc.fontRenderer, "Damage: +" + item.getDamage(), width - width/4, height/2 - 68, 0x57C5C6);
					
					ArrayList list = ArmorBase.getAbilities(player.inventory.armorItemInSlot(2).getItem());
					ArrayList<String> keyList = (ArrayList<String>) list.get(0);
					ArrayList<String> nameList = (ArrayList<String>) list.get(1);
					ArrayList<String> descList = (ArrayList<String>) list.get(2);
					ArrayList<int[]> posList = (ArrayList<int[]>) list.get(3);
					if (keyList.size() == nameList.size() && keyList.size() == descList.size()) {
						for (int i = 0; i < keyList.size(); i++) {
							
							drawCenteredString(mc.fontRenderer, nameList.get(i), (i+1)*width/(keyList.size() + 1), height/2 - 50, 0x57C5C6);
							drawCenteredString(mc.fontRenderer, "Key: " + keyList.get(i), (i+1)*width/(keyList.size() + 1), height/2 + 5, 0x57C5C6);
							drawCenteredString(mc.fontRenderer, "Description:", (i+1)*width/(keyList.size() + 1), height/2 + 17, 0x57C5C6);
							GlStateManager.pushMatrix();
							GlStateManager.translate((i+1)*width/(keyList.size() + 1), height/2 + 30, 0);
							GlStateManager.scale(0.5F, 0.5F, 1F);
							if (descList.get(i).length() > 34) {
								String[] stringArray = descList.get(i).split("-");
								int offset = 0;
								for (int j = 0; j < stringArray.length; j++) {
									drawCenteredString(mc.fontRenderer, stringArray[j], 0, offset, 0x57C5C6);
									offset += 10;
								}
							} else {
							drawCenteredString(mc.fontRenderer, descList.get(i), 0, 0, 0x57C5C6);
							}
							GlStateManager.popMatrix();
							GlStateManager.pushMatrix();
							mc.renderEngine.bindTexture(suit_info);
							GlStateManager.enableAlpha();
							GlStateManager.enableBlend();
							drawTexturedModalRect((i+1)*width/(keyList.size() + 1) - 19.5F, height/2 - 38, 0, 0, 39, 39);
							if (posList.get(i)[0] != 0 && posList.get(i)[1] != 0) {
								drawTexturedModalRect((i+1)*width/(keyList.size() + 1) - 19.5F, height/2 - 38, 39*(posList.get(i)[0] - 1)+(posList.get(i)[0]), (39*posList.get(i)[1])+(posList.get(i)[1]), 38, 38);
							}
							GlStateManager.disableAlpha();
							GlStateManager.disableBlend();
							GlStateManager.popMatrix();
						}
					}
			

					
				}
			}
			
			
		}
	}
}

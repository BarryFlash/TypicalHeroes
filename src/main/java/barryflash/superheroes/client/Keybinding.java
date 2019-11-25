package barryflash.superheroes.client;

import org.lwjgl.input.Keyboard;

import barryflash.superheroes.init.ModArmor;
import barryflash.superheroes.items.armor.ItemIronmanMark50Armor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class Keybinding {
	public static KeyBinding Ability1;
	public static KeyBinding Ability2;
	public static KeyBinding Ability3;
	public static KeyBinding Ability4;
	public static KeyBinding Ability5;
	public static KeyBinding Ability6;
	
	public static KeyBinding Ability7;
	public static KeyBinding flightTakeOff;
	public static KeyBinding quiverForward;
	public static KeyBinding quiverBackward;
	public static KeyBinding suitInfo;
	
	
		
	public static void register() {
		
		
		Ability1 = new KeyBinding("key.Ability1", Keyboard.KEY_Z, "key.abilities");
		Ability2 = new KeyBinding("key.Ability2", Keyboard.KEY_X, "key.abilities");
		Ability3 = new KeyBinding("key.Ability3", Keyboard.KEY_C, "key.abilities");
		Ability4 = new KeyBinding("key.Ability4", Keyboard.KEY_F, "key.abilities");
		Ability5 = new KeyBinding("key.Ability5", Keyboard.KEY_R, "key.abilities");
		Ability6 = new KeyBinding("key.Ability6", Keyboard.KEY_G, "key.abilities");
		Ability7 = new KeyBinding("key.Ability7", Keyboard.KEY_V, "key.abilities");
		flightTakeOff = new KeyBinding("key.flightTakeOff", Keyboard.KEY_B, "key.utility");
		quiverForward = new KeyBinding("key.quiverForward", Keyboard.KEY_RBRACKET, "key.utility");
		quiverBackward = new KeyBinding("key.quiverBackward", Keyboard.KEY_LBRACKET, "key.utility");
		suitInfo = new KeyBinding("key.suitInfo", Keyboard.KEY_GRAVE, "key.utility");
		ClientRegistry.registerKeyBinding(Ability1);
		ClientRegistry.registerKeyBinding(Ability2);
		ClientRegistry.registerKeyBinding(Ability3);
		ClientRegistry.registerKeyBinding(Ability4);
		ClientRegistry.registerKeyBinding(Ability5);	
		ClientRegistry.registerKeyBinding(Ability6);
		ClientRegistry.registerKeyBinding(Ability7);
		ClientRegistry.registerKeyBinding(flightTakeOff);
		ClientRegistry.registerKeyBinding(quiverForward);
		ClientRegistry.registerKeyBinding(quiverBackward);
		ClientRegistry.registerKeyBinding(suitInfo);
	}
}

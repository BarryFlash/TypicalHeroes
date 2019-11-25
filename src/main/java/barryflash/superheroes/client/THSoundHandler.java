package barryflash.superheroes.client;

import java.util.ArrayList;
import java.util.List;

import barryflash.superheroes.Reference;
import barryflash.superheroes.init.ModItems;
import barryflash.superheroes.util.Utils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class THSoundHandler {
public static final List<SoundEvent> SOUNDS = new ArrayList<SoundEvent>();
	
	public static SoundEvent SHRINK = createSoundEvent("abilities.shrink");
	public static SoundEvent REPULSOR_CHARGE = createSoundEvent("abilities.repulsorcharge");
	public static SoundEvent REPULSOR_SHOOT = createSoundEvent("abilities.repulsor");
	public static SoundEvent BATMAN_GADGET_SWITCH = createSoundEvent("abilities.gadgetswitch");
	public static SoundEvent SMOKEBOMB = createSoundEvent("abilities.smokebomb");
	public static SoundEvent THROW = createSoundEvent("abilities.throw");
	public static SoundEvent HEATVISION = createSoundEvent("abilities.heatvision");
	public static SoundEvent HELMET = createSoundEvent("abilities.helmet");
	public static SoundEvent SUIT = createSoundEvent("abilities.suit");
	public static SoundEvent BRACELET = createSoundEvent("abilities.bracelet");
	public static SoundEvent BRACELET_BLAST =createSoundEvent("abilities.braceletblast");
	public static SoundEvent BATMAN_GLIDE = createSoundEvent("abilities.glide");
	public static SoundEvent BATMAN_BEEP = createSoundEvent("abilities.beep");
	public static SoundEvent KNOCKBACKFISTS = createSoundEvent("abilities.knockbackfists");
	public static SoundEvent MISSILE = createSoundEvent("abilities.missile");
	public static SoundEvent CANNONS = createSoundEvent("abilities.cannons");
	public static SoundEvent LIGHTNING = createSoundEvent("abilities.lightning");
	public static SoundEvent SHIELD_THROW = createSoundEvent("abilities.shield_throw");
	public static SoundEvent SHIELD_HIT = createSoundEvent("abilities.shield_hit");
	public static SoundEvent PISTOL_SHOT = createSoundEvent("abilities.pistolshot");
	public static SoundEvent PISTOL_RELOAD = createSoundEvent("abilities.pistolreload");
	
	private static SoundEvent createSoundEvent(String soundName) {
		final ResourceLocation soundID = new ResourceLocation(Reference.MODID, soundName);
		return new SoundEvent(soundID).setRegistryName(soundID);
	}

}

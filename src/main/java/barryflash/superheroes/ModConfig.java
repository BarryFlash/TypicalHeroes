package barryflash.superheroes;

import java.io.File;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.LangKey;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.RangeDouble;
import net.minecraftforge.common.config.Config.RangeInt;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/*@LangKey("sm.config.types")
@Config(modid = Reference.MODID, type = Type.INSTANCE, name = Reference.MODID + "_types")
public class ModConfig {
	public static SubCategory SUPERMAN = new SubCategory();

	public static class SubCategory {
		@Comment("Edit the amount of damage dealt when Superman suit is worn.")
		@Name("Superman Damage")
		@RangeDouble(min = 1, max = 40)
		public double supermanDamage = 15.0D;
	}
	@Mod.EventBusSubscriber(modid = Reference.MODID)
	private static class EventHandler {
		@SubscribeEvent
		public static void onConfigChanged(OnConfigChangedEvent event) {
			if (event.getModID().equals(Reference.MODID)) {
				ConfigManager.sync(Reference.MODID, Type.INSTANCE);
			}
		}
	}
}*/

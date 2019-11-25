package barryflash.superheroes.util;

import org.apache.logging.log4j.Level;

import barryflash.superheroes.Reference;
import io.netty.handler.logging.LogLevel;
import net.minecraftforge.fml.common.FMLLog;


public class LogHelper {
	public static void log(Level logLevel, Object object)

    {

        FMLLog.log(Reference.NAME, logLevel, String.valueOf(object));

    }

	public static void info(Object object) { log(Level.INFO, object); }
}

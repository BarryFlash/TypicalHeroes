package barryflash.superheroes.entities.particles;


import barryflash.superheroes.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TextureStitcherWaspBlast2 {

	 @SubscribeEvent
	  public void stitcherEventPre(TextureStitchEvent.Pre event) {
	    ResourceLocation blast = new ResourceLocation(Reference.MODID + ":entity/wasp2_particle");
	    ParticleWaspBlast2.blast = event.getMap().registerSprite(blast);
	  }
}

package barryflash.superheroes.entities.particles;


import barryflash.superheroes.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TextureStitcherLightning {

	 @SubscribeEvent
	  public void stitcherEventPre(TextureStitchEvent.Pre event) {
	    ResourceLocation blast = new ResourceLocation(Reference.MODID + ":entity/wasp_particle");
	    ParticleWaspBlast.blast = event.getMap().registerSprite(blast);
	
	  }
}

package barryflash.superheroes.capabilities;

import barryflash.superheroes.Reference;
import barryflash.superheroes.entities.EntityAnt;
import barryflash.superheroes.entities.EntityDoctorStrangeCape;
import barryflash.superheroes.entities.EntityThanosPortal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {
	//public static final ResourceLocation DOCTORSTRANGE_CAP = new ResourceLocation(Reference.MODID, "doctorstrangecap");
	public static final ResourceLocation IRONMAN_CAP = new ResourceLocation(Reference.MODID, "ironmancap");
	//public static final ResourceLocation THANOS_CAP = new ResourceLocation(Reference.MODID, "thanoscap");
	public static final ResourceLocation THOR_CAP = new ResourceLocation(Reference.MODID, "thorcap");
	//public static final ResourceLocation PORTAL_CAP = new ResourceLocation(Reference.MODID, "portalcap");
	//public static final ResourceLocation AQUAMAN_CAP = new ResourceLocation(Reference.MODID, "aquamancap");
	public static final ResourceLocation WASP_CAP = new ResourceLocation(Reference.MODID, "waspcap");
	public static final ResourceLocation ANTMAN_CAP = new ResourceLocation(Reference.MODID, "antmancap");
	public static final ResourceLocation FLASH_CAP = new ResourceLocation(Reference.MODID, "flashcap");
	//public static final ResourceLocation SIZE_CAP = new ResourceLocation(Reference.MODID, "sizecap");
	public static final ResourceLocation BATMAN_CAP = new ResourceLocation(Reference.MODID, "batcap");
	public static final ResourceLocation WONDERWOMAN_CAP = new ResourceLocation(Reference.MODID, "wwcap");
	public static final ResourceLocation SUPERMAN_CAP = new ResourceLocation(Reference.MODID, "supercap");
	public static final ResourceLocation SUPERHEROES_CAP = new ResourceLocation(Reference.MODID, "superheroescap");
	public static final ResourceLocation ZEUS_ALTAR_CAP = new ResourceLocation(Reference.MODID, "zeusaltarcap");
	public static final ResourceLocation SHAZAM_CAP = new ResourceLocation(Reference.MODID, "shazamcap");
	public static final ResourceLocation HULK_CAP = new ResourceLocation(Reference.MODID, "hulkcap");
	public static final ResourceLocation KEYS_CAP = new ResourceLocation(Reference.MODID, "keyscap");
	public static final ResourceLocation CAPTAINAMERICA_CAP = new ResourceLocation(Reference.MODID, "captainamericacap");
	public static final ResourceLocation ATTRIBUTES_CAP = new ResourceLocation(Reference.MODID, "attributescap");
	public static final ResourceLocation BLACKWIDOW_CAP = new ResourceLocation(Reference.MODID, "blackwidowcap");
	public static final ResourceLocation FUSIONCHAMBER_CAP = new ResourceLocation(Reference.MODID, "fusionchambercap");
	public static final ResourceLocation SPECIALEFFECTS_CAP = new ResourceLocation(Reference.MODID, "specialeffectscap");
	public static final ResourceLocation LOKI_CAP = new ResourceLocation(Reference.MODID, "lokicap");
	public static final ResourceLocation ZOD_CAP = new ResourceLocation(Reference.MODID, "zodcap");
	public static final ResourceLocation CYBORG_CAP = new ResourceLocation(Reference.MODID, "cyborgcap");
	public static final ResourceLocation QUIVER_CAP = new ResourceLocation(Reference.MODID, "quivercap");
	 @SubscribeEvent

	 public void attachCapability(AttachCapabilitiesEvent<Entity> event)

	 {
		 /*if (event.getObject() instanceof EntityLiving) {
			 event.addCapability(SIZE_CAP, new SizeProvider());
			
		 }
		
		 if (event.getObject() instanceof EntityPlayer || event.getObject() instanceof EntityDoctorStrangeCape) {
		 event.addCapability(DOCTORSTRANGE_CAP, new DoctorStrangeProvider());
		
	 }*/

	 

	 

	 
	 
	 if (event.getObject() instanceof EntityPlayer) {
		 event.addCapability(SPECIALEFFECTS_CAP, new SpecialEffectsProvider());
	 event.addCapability(SUPERHEROES_CAP, new SuperheroesProvider());	
	 event.addCapability(IRONMAN_CAP, new IronmanProvider());	 
	 //event.addCapability(THANOS_CAP, new ThanosProvider()); 
	 event.addCapability(THOR_CAP, new ThorProvider());
	 //event.addCapability(AQUAMAN_CAP, new AquamanProvider());
	 //event.addCapability(WASP_CAP, new WaspProvider());
	 //event.addCapability(ANTMAN_CAP, new AntmanProvider());
	 event.addCapability(FLASH_CAP, new FlashProvider());
	 event.addCapability(BATMAN_CAP, new BatmanProvider());
	 event.addCapability(WONDERWOMAN_CAP, new WonderWomanProvider());
	 event.addCapability(SUPERMAN_CAP, new SupermanProvider());
	 event.addCapability(ZEUS_ALTAR_CAP, new ZeusAltarProvider());
	 event.addCapability(SHAZAM_CAP, new ShazamProvider());
	 event.addCapability(HULK_CAP, new HulkProvider());
	 event.addCapability(KEYS_CAP, new KeysProvider());
	 event.addCapability(CAPTAINAMERICA_CAP, new CaptainAmericaProvider());
	 event.addCapability(ATTRIBUTES_CAP, new AttributesProvider());
	 event.addCapability(BLACKWIDOW_CAP, new BlackWidowProvider());
	 event.addCapability(FUSIONCHAMBER_CAP, new FusionChamberProvider());
	 event.addCapability(LOKI_CAP, new LokiProvider());
	 event.addCapability(ZOD_CAP, new ZodProvider());
	 event.addCapability(CYBORG_CAP, new CyborgProvider());
	 event.addCapability(QUIVER_CAP, new QuiverProvider());
	 } else {
		 if (event.getObject() instanceof EntityLiving) {
			 event.addCapability(SPECIALEFFECTS_CAP, new SpecialEffectsProvider());
		 }
	 }
	 /* if (event.getObject() instanceof EntityThanosPortal) {
		 event.addCapability(PORTAL_CAP, new PortalProvider());
		
	 }*/

	 
	
	 
	
	 }
	 
	 
}

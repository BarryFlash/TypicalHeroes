package barryflash.superheroes.client.render.entities;

import barryflash.superheroes.Reference;
import barryflash.superheroes.client.render.layers.DoctorStrangeCapeLayer;
import barryflash.superheroes.entities.EntityDoctorStrangeCape;
import barryflash.superheroes.entities.EntityDoctorStrangePortal;
import barryflash.superheroes.models.ModelDoctorStrangeCapeEntity;
import barryflash.superheroes.models.ModelDoctorStrangeCapeHead;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEntityDoctorStrangePortal extends RenderLiving<EntityDoctorStrangePortal> {

		
		private static final ResourceLocation capeTexture = new ResourceLocation(Reference.MODID, "textures/models/armor/DoctorStrange_layer_1.png");
		
		 public static final Factory FACTORY = new Factory();
		 
		public RenderEntityDoctorStrangePortal(RenderManager rendermanagerIn) {
			super(rendermanagerIn, new ModelDoctorStrangeCapeEntity(), 0.0F);
		
		
		}
		
		
		
		@Override
		protected ResourceLocation getEntityTexture(EntityDoctorStrangePortal entity) {
			return this.capeTexture;
		}
		  public static class Factory implements IRenderFactory<EntityDoctorStrangePortal> {



		        @Override

		        public Render<? super EntityDoctorStrangePortal> createRenderFor(RenderManager manager) {

		            return new RenderEntityDoctorStrangePortal(manager);

		        }



		    }
	}

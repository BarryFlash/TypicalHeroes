package barryflash.superheroes.client.render.entities;

import barryflash.superheroes.Reference;
import barryflash.superheroes.client.render.layers.DoctorStrangeCapeLayer;
import barryflash.superheroes.entities.EntityAnt;
import barryflash.superheroes.entities.EntityDoctorStrangeCape;
import barryflash.superheroes.models.ModelAnt;
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
public class RenderEntityAnt extends RenderLiving<EntityAnt> {

		
		private static final ResourceLocation antTexture = new ResourceLocation(Reference.MODID, "textures/models/ant.png");
		
		 public static final Factory FACTORY = new Factory();
		 
		public RenderEntityAnt(RenderManager rendermanagerIn) {
			super(rendermanagerIn, new ModelAnt(), 0.0F);
			
		
		}
		
		
		
		@Override
		protected ResourceLocation getEntityTexture(EntityAnt entity) {
			return this.antTexture;
		}
		  public static class Factory implements IRenderFactory<EntityAnt> {



		        @Override

		        public Render<? super EntityAnt> createRenderFor(RenderManager manager) {

		            return new RenderEntityAnt(manager);

		        }



		    }
	}

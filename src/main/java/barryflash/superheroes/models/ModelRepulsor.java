package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelRepulsor extends ModelBase
{
    public ModelRenderer shape1;
    public ModelRenderer shape1_1;

    public ModelRepulsor()
    {
        textureWidth = 64;
        textureHeight = 32;
        shape1 = new ModelRenderer(this, 0, 6);
        shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
        shape1.addBox(0.0F, 0.0F, 0.0F, 14, 3, 3, 0.0F);
        shape1_1 = new ModelRenderer(this, 0, 0);
        shape1_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        shape1_1.addBox(0.0F, 0.0F, 0.0F, 14, 3, 3, 0.3F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        shape1.render(f5);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.4F);
        shape1_1.render(f5);
        GL11.glDisable(GL11.GL_BLEND);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

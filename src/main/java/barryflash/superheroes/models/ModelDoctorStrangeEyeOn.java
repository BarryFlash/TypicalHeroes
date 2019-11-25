package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDoctorStrangeEyeOn extends ModelBiped
{
    public ModelRenderer eye;

    public ModelDoctorStrangeEyeOn()
    {
        textureWidth = 16;
        textureHeight = 16;
        eye = new ModelRenderer(this, 50, 65);
        eye.mirror = true;
        eye.setRotationPoint(0.0F, 0.0F, 0.0F);
        eye.addBox(-0.5F, 4.0F, -2.65F, 1, 1, 1, -0.08F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        eye.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

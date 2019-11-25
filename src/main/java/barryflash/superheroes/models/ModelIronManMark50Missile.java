package barryflash.superheroes.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelIronManMark50Missile extends ModelBase
{
    public ModelRenderer leftarm;
    public ModelRenderer leftarm_1;
    public ModelRenderer leftarm_2;
    public ModelRenderer leftarm_3;
    public ModelRenderer leftarm_4;

    public ModelIronManMark50Missile()
    {
        textureWidth = 128;
        textureHeight = 128;
        leftarm = new ModelRenderer(this, 90, 90);
        leftarm.mirror = true;
        leftarm.setRotationPoint(5.0F, 2.0F, 0.0F);
        leftarm.addBox(0.7F, -3.5F, -5.5F, 1, 1, 2, 0.0F);
        leftarm_1 = new ModelRenderer(this, 110, 110);
        leftarm_1.mirror = true;
        leftarm_1.setRotationPoint(5.0F, 2.0F, 0.0F);
        leftarm_1.addBox(0.7F, -3.5F, -4.3F, 1, 1, 1, -0.1F);
        leftarm_2 = new ModelRenderer(this, 90, 90);
        leftarm_2.mirror = true;
        leftarm_2.setRotationPoint(5.0F, 2.0F, 0.0F);
        leftarm_2.addBox(2.7F, -4.7F, 0.1F, 1, 1, 2, -0.3F);
        setRotateAngle(leftarm_2, 0.7592182246175333F, 0.5321508889330709F, 0.00767944870877505F);
        leftarm_3 = new ModelRenderer(this, 90, 90);
        leftarm_3.setRotationPoint(5.0F, 2.0F, 0.0F);
        leftarm_3.addBox(-1.7F, -5.5F, -0.8F, 1, 1, 2, -0.3F);
        setRotateAngle(leftarm_3, 0.7592182246175333F, -0.5321508889330709F, -0.00767944870877505F);
        leftarm_4 = new ModelRenderer(this, 90, 90);
        leftarm_4.mirror = true;
        leftarm_4.setRotationPoint(5.0F, 2.0F, 0.0F);
        leftarm_4.addBox(0.7F, -5.0F, -1.1F, 1, 2, 1, -0.3F);
        setRotateAngle(leftarm_4, 0.8155923594569501F, 0.0F, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        leftarm.render(f5);
        leftarm_1.render(f5);
        leftarm_2.render(f5);
        leftarm_3.render(f5);
        leftarm_4.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

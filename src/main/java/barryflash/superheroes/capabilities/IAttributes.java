package barryflash.superheroes.capabilities;

import net.minecraft.entity.ai.attributes.AttributeModifier;

public interface IAttributes {

	public void setDamage(float damage);
	public void setSpeed(float speed);
	public void setArmor(float armor);
	public void setToughness(float toughness);
	public void setHealth(float health);
	
	public AttributeModifier getDamage();
	public AttributeModifier getSpeed();
	public AttributeModifier getArmor();
	public AttributeModifier getToughness();
	public AttributeModifier getHealth();
	

}

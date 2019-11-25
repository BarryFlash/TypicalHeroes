package barryflash.superheroes.capabilities;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.util.math.MathHelper;

public class Attributes implements IAttributes {
	private AttributeModifier damageModifier;
	private AttributeModifier speedModifier;
	private AttributeModifier armorModifier;
	private AttributeModifier toughnessModifier;
	private AttributeModifier healthModifier;
	@Override
	public void setDamage(float damage) {
		// TODO Auto-generated method stub
		damageModifier = new AttributeModifier(MathHelper.getRandomUUID(), "th:damage", damage, 0).setSaved(true);
	}

	@Override
	public void setSpeed(float speed) {
		// TODO Auto-generated method stub
		speedModifier = new AttributeModifier(MathHelper.getRandomUUID(), "th:damage", speed, 0).setSaved(true);
	}

	@Override
	public void setArmor(float armor) {
		// TODO Auto-generated method stub
		armorModifier = new AttributeModifier(MathHelper.getRandomUUID(), "th:damage", armor, 0).setSaved(true);
	}

	@Override
	public void setToughness(float toughness) {
		// TODO Auto-generated method stub
		toughnessModifier = new AttributeModifier(MathHelper.getRandomUUID(), "th:damage", toughness, 0).setSaved(true);
	}

	@Override
	public void setHealth(float health) {
		// TODO Auto-generated method stub
		healthModifier = new AttributeModifier(MathHelper.getRandomUUID(), "th:damage", health, 0).setSaved(true);
	}

	@Override
	public AttributeModifier getDamage() {
		// TODO Auto-generated method stub
		return damageModifier;
	}

	@Override
	public AttributeModifier getSpeed() {
		// TODO Auto-generated method stub
		return speedModifier;
	}

	@Override
	public AttributeModifier getArmor() {
		// TODO Auto-generated method stub
		return armorModifier;
	}

	@Override
	public AttributeModifier getToughness() {
		// TODO Auto-generated method stub
		return toughnessModifier;
	}

	@Override
	public AttributeModifier getHealth() {
		// TODO Auto-generated method stub
		return healthModifier;
	}


}

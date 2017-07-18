package edu.QATestLab.WarOfRaces.model.Human;

import edu.QATestLab.WarOfRaces.model.Unit.Unit;

public class CrossbowArcher extends RaceOfHuman {
	
	private float damageFirst;
	private float damageSecond;
	
	public float getDamageFirst() {
		return damageFirst;
	}

	public void setDamageFirst(float damageFirst) {
		this.damageFirst = damageFirst;
	}

	public float getDamageSecond() {
		return damageSecond;
	}

	public void setDamageSecond(float damageSecond) {
		this.damageSecond = damageSecond;
	}

	public CrossbowArcher(float hp, String name, float damageFirst, float damageSecond) {
		super(hp, name, damageSecond, damageSecond);
		this.damageFirst = damageFirst;
		this.damageSecond = damageSecond;
	}

	@Override
	public void attackFirst(Unit u) {
		u.setHp((float) (u.getHp() - damageFirst));
	}

	@Override
	public void attackSecond(Unit u) {
		u.setHp((float) (u.getHp() - damageSecond));
	}
}

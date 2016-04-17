public class Skeleton extends Monster
{
	public Skeleton(String name, int hitPoints, int attackSpeed, int minDamage, int maxDamage, double hitChance, 
			 double healChance, int minHeal, int maxHeal)
	{
		super(name, hitPoints, attackSpeed, minDamage, maxDamage, hitChance, healChance, minHeal, maxHeal);
		setName("Solomon the Skeleton");
		setHitPoints(100);
		setAttackSpeed(2);
		setMinDamage(30);
		setMaxDamage(50);
		setHitChance(0.8);
		setHealChance(0.3);
		setMinHeal(30);
		setMaxHeal(50);		
	}
}

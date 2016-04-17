public class Gremlin extends Monster
{
	public Gremlin(String name, int hitPoints, int attackSpeed, int minDamage, int maxDamage, double hitChance, 
			 double healChance, int minHeal, int maxHeal)
	{
		super(name, hitPoints, attackSpeed, minDamage, maxDamage, hitChance, healChance, minHeal, maxHeal);
		setName("Rhazin the Gremlin");
		setHitPoints(70);
		setAttackSpeed(5);
		setMinDamage(15);
		setMaxDamage(30);
		setHitChance(0.8);
		setHealChance(0.4);
		setMinHeal(20);
		setMaxHeal(40);		
	}
}

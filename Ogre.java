public class Ogre extends Monster
{
	public Ogre(String name, int hitPoints, int attackSpeed, int minDamage, int maxDamage, double hitChance, 
			 double healChance, int minHeal, int maxHeal)
	{
		super(name, hitPoints, attackSpeed, minDamage, maxDamage, hitChance, healChance, minHeal, maxHeal);
		setName("Narok the Ogre");
		setHitPoints(200);
		setAttackSpeed(2);
		setMinDamage(30);
		setMaxDamage(60);
		setHitChance(0.6);
		setHealChance(0.1);
		setMinHeal(30);
		setMaxHeal(60);		
	}
}

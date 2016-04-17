public abstract class Monster extends DungeonCharacter
{
	protected double healChance;
	protected int minHeal;
	protected int maxHeal;
	
	public Monster(String name, int hitPoints, int attackSpeed, int minDamage, int maxDamage, double hitChance, 
				 double healChance, int minHeal, int maxHeal)
	{
		super(name, hitPoints, attackSpeed, minDamage, maxDamage, hitChance);
		this.healChance = healChance;
		this.minHeal = minHeal;
		this.maxHeal = maxHeal;
	}
	
	public void setHealChance(double healChance)
	{
		this.healChance = healChance;
	}
	
	public double getHealChance()
	{
		return healChance;
	}
	
	public void setMinHeal(int minHeal)
	{
		this.minHeal = minHeal;
	}
	
	public int getMinHeal()
	{
		return minHeal;
	}
	
	public void setMaxHeal(int maxHeal)
	{
		this.maxHeal = maxHeal;
	}
	
	public int getMaxHeal()
	{
		return maxHeal;
	}
	
	public static void heal(Monster m1)
	{
		String s = null;
		
		if (m1.hitPoints > 0) //also need to check that hit points were lost
		{
			if (DungeonCharacter.randomNum.nextDouble() < m1.healChance)
			{
				int heal = randomNum.nextInt((m1.maxHeal - m1.minHeal) + 1) + m1.minHeal;
				int hp = m1.hitPoints;
				
				m1.setHitPoints(hp + heal);
				
				s = m1.name + " has healed itself for " + heal + " points.\n" + m1.name + " now has " +
						m1.hitPoints + " hit points remaining.\n";
				System.out.println(s);
			}
		}
	}
}

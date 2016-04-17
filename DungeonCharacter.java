import java.util.Random;

public abstract class DungeonCharacter
{
	protected String name;
	protected int hitPoints;
	protected int attackSpeed;
	protected int minDamage;
	protected int maxDamage;
	protected double hitChance;
	static Random randomNum = new Random();
	
	public DungeonCharacter(String name, int hitPoints, int attackSpeed, int minDamage, int maxDamage, double hitChance)
	{
		this.name = name;
		this.hitPoints = hitPoints;
		this.attackSpeed = attackSpeed;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.hitChance = hitChance;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setHitPoints(int hitPoints)
	{
		this.hitPoints = hitPoints;
	}
	
	public int getHitPoints()
	{
		return hitPoints;
	}
	
	public void setAttackSpeed(int attackSpeed)
	{
		this.attackSpeed = attackSpeed;
	}
	
	public int getAttackSpeed()
	{
		return attackSpeed;
	}
	
	public void setMinDamage(int minDamage)
	{
		this.minDamage = minDamage;
	}
	
	public int getMinDamage()
	{
		return minDamage;
	}
	
	public void setMaxDamage(int maxDamage)
	{
		this.maxDamage = maxDamage;
	}
	
	public int getMaxDamage()
	{
		return maxDamage;
	}
	
	public void setHitChance(double hitChance)
	{
		this.hitChance = hitChance;
	}
	
	public double getHitChance()
	{
		return hitChance;
	}
	
	public void attack(DungeonCharacter d1, DungeonCharacter d2)
	{
		String s = null;
		
		if (randomNum.nextDouble() < d1.hitChance)
		{
			int hit = randomNum.nextInt((d1.maxDamage - d1.minDamage) + 1) + d1.minDamage;
			int hp = d2.hitPoints;
			
			d2.setHitPoints(hp - hit);
			
			if (d2.hitPoints <= 0)
			{
				d2.setHitPoints(0);
			}
				
			s = d2.name + " is hit for " + hit + " points damage.\n" + d2.name + " now has " + 
				d2.hitPoints + " hit points remaining.\n";
		}
		
		else
		{
			s = d1.name + "'s attack has failed.\n";
		}
		
		System.out.println(s);
	}
	
//	public void attack(Monster d1, Hero d2)
//	{
//		String s = null;
//		
//		if (randomNum.nextDouble() < d1.hitChance)
//		{
//			int hit = randomNum.nextInt((d1.maxDamage - d1.minDamage) + 1) + d1.minDamage;
//			int hp = d2.hitPoints;
//			
//			d2.setHitPoints(hp - hit);
//			
//			if (d2.hitPoints <= 0)
//			{
//				d2.setHitPoints(0);
//			}
//				
//			s = d2.name + " is hit for " + hit + " points damage.\n" + d2.name + " now has " + 
//				d2.hitPoints + " hit points remaining.\n";
//		}
//		
//		else
//		{
//			s = d1.name + "'s attack has failed.\n";
//		}
//		
//		System.out.println(s);
//	}
	
//	public abstract double getBlockChance();
//	public abstract double getHealChance();
//	public abstract int getMinHeal();
//	public abstract int getMaxHeal();
}


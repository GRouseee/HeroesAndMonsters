import java.util.Scanner;

public class Warrior extends Hero
{	
	public Warrior(String name, int hitPoints, int attackSpeed, int minDamage, int maxDamage, double hitChance, 
			double blockChance, int turns, int oppAttackSpeed)
	{
		super(name, hitPoints, attackSpeed, minDamage, maxDamage, hitChance, blockChance, turns, oppAttackSpeed);
		
		setHitPoints(125);
		setAttackSpeed(4);
		setMinDamage(35);
		setMaxDamage(60);
		setHitChance(0.8);
		setBlockChance(0.2);
	}
	
	public void crushingBlow(DungeonCharacter h1)
	{
		h1.setHitChance(0.4);
		
		if (DungeonCharacter.randomNum.nextDouble() < h1.hitChance)
		{
			h1.setMinDamage(75);
			h1.setMaxDamage(175);
		}
		
		else
		{
			h1.setHitChance(0.8);
		}
	}
	
	@Override
	public void attack(DungeonCharacter d1, DungeonCharacter d2)
	{
		Scanner input = new Scanner(System.in);
		int choice;
		
		System.out.print("1. Attack Opponent\n2.Crushing Blow on Opponent\nChoose an Option: ");
		choice = input.nextInt();
		System.out.print("\n");
		
		if(choice == 1)
		{
			super.attack(d1, d2);
//			if (randomNum.nextDouble() < d1.hitChance)
//			{
//				int hit = randomNum.nextInt((d1.maxDamage - d1.minDamage) + 1) + d1.minDamage;
//				int hp = d2.hitPoints;
//				
//				d2.setHitPoints(hp - hit);
//				
//				if (d2.hitPoints <= 0)
//				{
//					d2.setHitPoints(0);
//				}
//					
//				s = d2.name + " is hit for " + hit + " points damage.\n" + d2.name + " now has " + 
//					d2.hitPoints + " hit points remaining.\n";
//			}
//			
//			else
//			{
//				s = d1.name + "'s attack has failed.\n";
//			}
		}
		
		else if (choice == 2)
		{
			String s = null;
			crushingBlow(d1);
			
			if (d1.hitChance == 0.4)
			{
				int hit = randomNum.nextInt((d1.maxDamage - d1.minDamage) + 1) + d1.minDamage;
				int hp = d2.hitPoints;
				
				d2.setHitPoints(hp - hit);
				
				if (d2.hitPoints <= 0)
				{
					d2.setHitPoints(0);
				}
					
				s = d1.name + " lands a cruching blow on " + d2.name + " for " + hit + " points damage.\n" + d2.name + " now has " + 
					d2.hitPoints + " hit points remaining.\n";
				
				d1.setHitChance(0.8);
				d1.setMinDamage(35);
				d1.setMaxDamage(60);
			}
			
			else if (d1.hitChance == 0.8)
			{
				s = d1.name + " failed to land a crushing blow.\n";
				d1.setMinDamage(35);
				d1.setMaxDamage(60);
			}
			
			System.out.println(s);
		}
	}
}




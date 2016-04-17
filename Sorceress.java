import java.util.Scanner;

public class Sorceress extends Hero
{
	public Sorceress(String name, int hitPoints, int attackSpeed, int minDamage, int maxDamage, double hitChance, 
			double blockChance, int turns, int oppAttackSpeed)
	{
		super(name, hitPoints, attackSpeed, minDamage, maxDamage, hitChance, blockChance, turns, oppAttackSpeed);

		setHitPoints(75);
		setAttackSpeed(5);
		setMinDamage(25);
		setMaxDamage(45);
		setHitChance(0.7);
		setBlockChance(0.3);
	}
	
	public void heal(DungeonCharacter h1)
	{
		int add = DungeonCharacter.randomNum.nextInt((50-25) + 1) + 25;
		int hp = h1.hitPoints;
		
		h1.setHitPoints(hp + add);
		
		System.out.println(h1.name + " added " + add + " hit points.\n" + h1.name + " now has " + h1.hitPoints + " remaining.\n");
	}
	
	@Override
	public void attack(DungeonCharacter d1, DungeonCharacter d2)
	{
		Scanner input = new Scanner(System.in);
		int choice;
		
		System.out.print("1. Attack Opponent\n2. Increase Hit Points\nChoose an Option: ");
		choice = input.nextInt();
		System.out.print("\n");
		
		if (choice == 1)
		{
			super.attack(d1, d2);
		}
		
		if (choice == 2)
		{
			heal(d1);
		}
	}
}

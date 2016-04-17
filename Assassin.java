import java.util.Scanner;

public class Assassin extends Hero
{
	public Assassin(String name, int hitPoints, int attackSpeed, int minDamage, int maxDamage, double hitChance, 
			double blockChance, int turns, int oppAttackSpeed)
	{
		super(name, hitPoints, attackSpeed, minDamage, maxDamage, hitChance, blockChance, turns, oppAttackSpeed);

		setHitPoints(100);
		setAttackSpeed(6);
		setMinDamage(25);
		setMaxDamage(40);
		setHitChance(0.8);
		setBlockChance(0.3);
	}
	
	public void poisonDagger(DungeonCharacter m1)
	{
		if (DungeonCharacter.randomNum.nextDouble() < 0.2)
		{
			m1.hitPoints = 0;
			System.out.println("You were able to land a strike with your poison dagger!\n" + m1.name + " has been poisoned.\n");
		}
		
		else
		{
			System.out.println(m1.name + " blocked your dagger before you could strike him.\n");
		}
	}
	
	@Override
	public void attack(DungeonCharacter d1, DungeonCharacter d2)
	{
		Scanner input = new Scanner(System.in);
		int choice;
		
		System.out.print("1. Attack Opponent\n2. Use Poison Dagger\nChoose an Option: ");
		choice = input.nextInt();
		System.out.print("\n");
		
		if (choice == 1)
		{
			super.attack(d1, d2);
		}
		
		if (choice == 2)
		{
			poisonDagger(d2);
		}
	}
}

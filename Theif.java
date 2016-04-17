import java.util.Scanner;

public class Theif extends Hero
{
	public Theif(String name, int hitPoints, int attackSpeed, int minDamage, int maxDamage, double hitChance, 
			double blockChance, int turns, int oppAttackSpeed)
	{
		super(name, hitPoints, attackSpeed, minDamage, maxDamage, hitChance, blockChance, turns, oppAttackSpeed);

		setHitPoints(75);
		setAttackSpeed(6);
		setMinDamage(20);
		setMaxDamage(40);
		setHitChance(0.8);
		setBlockChance(0.4);
	}
	
	public int surpriseAttack(Hero h1)
	{
		double random = DungeonCharacter.randomNum.nextDouble();
		int result = 0;
		
		if (random < 0.4)
		{
			h1.turns += 1;
			System.out.println("Surprise attack was successful!\n" + h1.name + " gets an additional turn.\n");
			result = 1;
		}
		
		else if (random >= 0.4 && random < 0.6)
		{
			result = 2;
		}
		
		else if (random >= 0.6)
		{
			result = 3;
		}
		
		return result;
	}
	
	@Override
	public void attack(DungeonCharacter d1, DungeonCharacter d2)
	{
		Scanner input = new Scanner(System.in);
		int choice;
		
		System.out.print("1. Attack Opponent\n2. Surprise Attack\nChoose an Option: ");
		choice = input.nextInt();
		System.out.print("\n");
		
		if (choice == 1)
		{
			super.attack(d1, d2);
		}
		
		else if (choice == 2)
		{
			int r = surpriseAttack((Hero) d1);
			
			if (r == 1)
			{
				super.attack(d1, d2);
			}
			
			else if (r == 2)
			{
				System.out.println(d2.name + " saw you and blocked your attack!\n");
			}
			
			else if (r == 3)
			{
				super.attack(d1, d2);
			}
		}
	}
}

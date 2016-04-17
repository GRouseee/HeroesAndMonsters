/********************************************************
 * Gavin Rouse											*
 * Programming Principles II 9am 						*
 * 														*
 * Couldn't figure out how to implement the # of turns 	*
 * system properly, so I left it out in order to ensure	*
 * that the program would still run properly.			*
 * 														*
 * Attempted the add a hero extra credit. Added the		*
 * Assassin with the special skill poison dagger.		*
 ********************************************************/

import java.util.Scanner;

public class HeroesVersusMonsters
{	
	public static void main(String[] args)
	{
		String s = "Y";
		
		while (s.equals("Y") || s.equals("YES"))
		{
			int choice = heroChoice();
			int otherChoice = DungeonCharacter.randomNum.nextInt(3) + 1;
			int turns = 0;
			DungeonCharacter h1 = null;
			DungeonCharacter m1 = null;
			
			if (otherChoice == 1)
			{
				m1 = new Ogre("", 0, 0, 0, 0, 0.0, 0.0, 0, 0);
			}
			
			else if (otherChoice == 2)
			{
				m1 = new Gremlin("", 0, 0, 0, 0, 0.0, 0.0, 0, 0);
			}
			
			else if (otherChoice == 3)
			{
				m1 = new Skeleton("", 0, 0, 0, 0, 0.0, 0.0, 0, 0);
			}
			
			int oppAttackSpeed = m1.attackSpeed;
			
			if (choice == 1)
			{
				h1 = new Warrior("", 0, 0, 0, 0, 0.0, 0.0, 0, oppAttackSpeed);
			}
			
			else if (choice == 2)
			{
				h1 = new Sorceress("", 0, 0, 0, 0, 0.0, 0.0, 0, oppAttackSpeed);
			}
			
			else if (choice == 3)
			{
				h1 = new Theif("", 0, 0, 0, 0, 0.0, 0.0, 0, oppAttackSpeed);
			}
			
			else if (choice == 4)
			{
				h1 = new Assassin("", 0, 0, 0, 0, 0.0, 0.0, 0, oppAttackSpeed);
			}

			battle(h1, m1);
			s = playAgain();
		}
	}
	
	public static void battle(DungeonCharacter h1, DungeonCharacter m1)
	{
		Scanner input = new Scanner(System.in);
		
		String s = "";
		
		while(!s.equals("Q"))
		{
			while (h1.hitPoints > 0 && m1.hitPoints > 0)
			{
				h1.attack(h1, m1);
				
				if (m1.hitPoints > 0)
				{
					Monster.heal((Monster) m1);

					if (Hero.block((Hero) h1) == true)
					{
						System.out.println(h1.name + " blocked the attack!\n");
					}
					else
					{
						m1.attack(m1, h1);
					}
				}
				
				if (h1.hitPoints > 0 && m1.hitPoints > 0)
				{
					System.out.print("Enter Q to quit, enter anything else to continue: ");
					input.nextLine().toUpperCase();
					System.out.print("\n");
				}
				
				if (m1.hitPoints == 0)
				{
					System.out.println(m1.name + " has died. " + h1.name + " is victorious!\n");
					s = "Q";
				}
					
				else if (h1.hitPoints == 0)
				{
					System.out.println(h1.name + " has died. " + m1.name + " is victorious!\n");
					s = "Q";
				}
			}
		}
	}
	
	public static String playAgain()
	{
		Scanner input = new Scanner(System.in);
		String s = null;
		
		System.out.print("Do you want to play again (Y/N)? ");
		s = input.nextLine().toUpperCase();
		System.out.print("\n");
		
		return s;
	}
	
	public static int heroChoice()
	{
		Scanner input = new Scanner(System.in);
		int choice = 0;
		
		while (choice != 1 && choice != 2 && choice != 3 && choice != 4)
		{
			System.out.print("-Choose a hero-\n1. Warrior\n2. Sorceress\n3. Theif\n4. Assassin\nYour choice is: ");
			choice = input.nextInt();
			System.out.print("\n");
			
			if (choice != 1 && choice != 2 && choice != 3 && choice != 4)
			{
				System.out.print("Your choice was invalid. Please choose again: ");
			}
		}
		
		return choice;
	}
	
	public static int turns(DungeonCharacter h1, DungeonCharacter m1)
	{
		int turns = h1.attackSpeed / m1.attackSpeed;
		return turns;
	}
}
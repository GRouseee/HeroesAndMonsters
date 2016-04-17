import java.util.Scanner;

public abstract class Hero extends DungeonCharacter
{
	protected double blockChance;
	protected int turns;
	protected int oppAttackSpeed;
	
	public Hero(String name, int hitPoints, int attackSpeed, int minDamage, int maxDamage, double hitChance, 
				double blockChance, int turns, int oppAttackSpeed)
	{
		super(name, hitPoints, attackSpeed, minDamage, maxDamage, hitChance);
		this.blockChance = blockChance;
		this.turns = turns;
		
		setName(enterName());
		setTurns(attackSpeed, oppAttackSpeed);
	}
	
	public void setBlockChance(double blockChance)
	{
		this.blockChance = blockChance;
	}
	
	public double getBlockChance()
	{
		return blockChance;
	}
	
	public void setTurns(int attackSpeed, int oppAttackSpeed)
	{
		this.turns = attackSpeed / oppAttackSpeed;
	}
	
	public String enterName()
	{
		Scanner input = new Scanner(System.in);
		String name = null;
				
		System.out.print("Enter character name: ");
		name = input.nextLine();
		System.out.print("\n");
		return name;
	}
		
	public static boolean block(Hero h1)
	{
		boolean b = false;
		
		if (DungeonCharacter.randomNum.nextDouble() < h1.blockChance)
		{				
			b = true;
		}
		
		else
		{
			b = false;
		}
		
		return b;
	}
}

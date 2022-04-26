package game;

import java.util.Scanner;

public class MyGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("============================");
		System.out.println("=========�������α׷�=========");
		System.out.println("============================");
		System.out.println("ĳ���͸� �����ϼ���. 1.�л� 2.������ 3.���");
		int a = sc.nextInt();
		Character character = null;
		switch(a)
		{
		case 1:
			character = new Student();
			break;
		case 2:
			character = new Worker();
			break;
		case 3:
			character = new Jobless();
			break;
		default:
			//System.out.println("ĳ���͸� �ùٸ���(1~3) �����ϼ���.");
			System.out.println("�߸��� �����Դϴ�.");
		
		}
		
		PlayGame pg;
		
		if (character == null)
		{
			System.out.println("������ �����մϴ�.");
			return;
		}
		else
		{
			pg = new PlayGame(character);	
		}
		
		while (true)
		{
			pg.printMenu(sc);
			pg.play();
			if (pg.isExit() == true)
			{
				break;
			}
		}
		System.out.println("���α׷��� ����˴ϴ�.");
	}

}

class PlayGame
{
	private Character character;
	private int menu;
	private boolean exit;
	
	public boolean isExit()
	{
		return exit;
	}
	
	PlayGame(Character character)
	{
		this.character = character;
	}
	void printMenu(Scanner sc)
	{
		System.out.println("1. ��Ա� 2.���ڱ� 3.��� 4.��(����)�ϱ� 5.����");
		menu = sc.nextInt();
	}
	void play()
	{
		switch(menu)
		{
		case 1:
			character.eat();
			break;
		case 2:
			character.sleep();
			break;
		case 3:
			exit = character.play();
			break;
		case 4:
			exit = character.train();
			break;
		case 5:
			exit = true;
			break;
		}
		character.printInfo();
	}
}

abstract class Character
{
	protected int money;
	protected int fatigue;
	protected int level;
	
	public abstract void eat();
	public abstract void sleep();
	public abstract boolean train();
	public abstract boolean play();
	public abstract void levelUP();
	
	public boolean checkcondition()
	{
		if (fatigue >= 100)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void printInfo()
	{
		System.out.println("���� ĳ������ ����");
		System.out.println("�� = " + money);
		System.out.println("�Ƿε� = " + fatigue);
		System.out.println("���� = " + level);
	}
}

class Student extends Character
{
	Student()
	{
		money = 20;
		fatigue = 20;
		System.out.println("�л� ������");
		printInfo();
	}
	public void eat()
	{
		fatigue = fatigue - 5;
	}
	public void sleep()
	{
		fatigue = fatigue - 10;
	}
	public boolean train()
	{
		fatigue = fatigue - 30;
		money = money + 20;
		levelUP();
		return checkcondition();
	}
	public boolean play()
	{
		fatigue = fatigue - 20;
		money = money - 10;
		levelUP();
		return checkcondition();
	}
	public void levelUP()
	{
		if( money >= 40 )
		{
			level++;
			money = money-40;
		}
	}
}

class Worker extends Character
{
	Worker()
	{
		money = 30;
		fatigue = 50;
		System.out.println("������ ������");
		printInfo();
	}
	public void eat()
	{
		fatigue = fatigue - 5;
	}
	public void sleep()
	{
		fatigue = fatigue - 10;
	}
	public boolean train()
	{
		fatigue = fatigue + 30;
		money = money + 30;
		levelUP();
		return checkcondition();
	}
	public boolean play()
	{
		fatigue = fatigue - 15;
		money = money - 20;
		levelUP();
		return checkcondition();
	}
	public void levelUP()
	{
		if( money >= 50 )
		{
			level++;
			money = money-50;
		}
	}
}

class Jobless extends Character
{
	Jobless()
	{
		money = 10;
		fatigue = 10;
		System.out.println("��� ������");
		printInfo();
	}
	public void eat()
	{
		fatigue = fatigue - 5;
	}
	public void sleep()
	{
		fatigue = fatigue - 10;
	}
	public boolean train()
	{
		fatigue = fatigue + 20;
		money = money + 10;
		levelUP();
		return checkcondition();
	}
	public boolean play()
	{
		fatigue = fatigue - 10;
		money = money - 5;
		levelUP();
		return checkcondition();
	}
	public void levelUP()
	{
		if( money >= 30 )
		{
			level++;
			money = money-30;
		}
	}
}
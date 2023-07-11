package atm_machine_simulation;

import java.util.Scanner;

class Atm
{
	private int balance=0;
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void deposit(int amount)
	{
		if(amount<=0)
		{
			System.out.println("The amount deposited should be greater than zero");
		}
		else
		{
			this.balance+=amount;
			System.out.println("Rs "+amount+" is successfully deposited in your account");
		}
	}
	public void withdraw(int amount) throws  InsufficinetFundsException,InvalidAmountException
	{
		if(amount<=0)
		{
			throw new InvalidAmountException("The amount entered is less than zero");
		}
		else if(amount>balance)
		{
			throw new InsufficinetFundsException("Entered amount is greater than the available balance");
		}
		else
		{
			this.balance-=amount;
		}
	}
	
	
}
public class Atm_machine_simulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Atm kumar=new Atm();
		System.out.println("Transaction started");
		while(true)
		{
			System.out.println("Enter 1 for deposit \nEnter 2 for withdraw \nEnter 3 to End the transaction");
			int input=sc.nextInt();
			switch(input)
			{	
			case 1:
			{
				System.out.println("Enter the amount to be deposited");
				int amount=sc.nextInt();
				kumar.deposit(amount);
				break;
			}
			case 2:
			{
				System.out.println("Enter the amount to be withdrawn");
				int amount=sc.nextInt();
				try
				{
				kumar.withdraw(amount);
				}
				catch(InsufficinetFundsException exception)
				{
					System.out.println(exception);
				}
				catch(InvalidAmountException exception)
				{
					System.out.println(exception);
				}
				break;
			}
			case 3:
			{

				break;
			}
			default:
			{
				System.out.println("Enter a valid input");
				System.out.println();
			}

			}
			System.out.println("Your bank balance is "+kumar.getBalance());
			if(input==3)
			{
				System.out.println("Transaction ended");
				break;
			}
		}
	}
}

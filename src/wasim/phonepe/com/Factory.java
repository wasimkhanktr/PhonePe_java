package wasim.phonepe.com;

import java.util.Scanner;

public class Factory 
{
	public void balance(Bank b)
	{
		b.balance();
	}
	public void transfer(Bank b)
	{
		Setting s=SingleTon.getIntance();
		s.mobileNumber();
		b.transfer();
		
	}
	public static void upi(Bank b)
	{
		b.upiPin();
	}
	
	
	public void access() throws InterruptedException
	{
		System.out.println("Welcome to PhonePe!");
		System.out.println("=======================================");
		System.out.println("Enter Your PhoneNumber");
		PhoneNumber.mobileNumber();//resigtation by mobile number
		System.out.println("=======================================");
		PhoneNumber.otp();//genrate otp
		exicute();// exicution 
		
	}
	
	public static Bank factory()
	{
		System.out.println("=======================================");
		Scanner scan=new Scanner(System.in);
		System.out.println("press 1 for SBI \npress 2 for HDFC \npress 3 for AXIS \npress 4 for Kotak \npress 5 for ICICI");
		String choise=scan.next();
		if(choise.equals("1"))
		{
			return new SBI();
		}
		else if(choise.equals("2"))
		{
			return new HDFC();
		}
		else if(choise.equals("3"))
		{
			return new AXIS();
		}
		else if(choise.equals("4"))
		{
			return new Kotak();
		}
		else if(choise.equals("5"))
		{
			return new ICICI();
		}
		else {
			return null;
		}
	}
	
	public static void exicute()
	{
		Bank b=Factory.factory();//create object class type and upcasting
		upi(b);//create upiid for each bank
		
		
		Scanner scan=new Scanner(System.in);
		Factory access=new Factory();
		
		
		boolean flag=true;
		while(flag)
		{
			System.out.println("=======================================");
			System.out.println("press 1 for checking balance\npress 2 for transfer money\npress 3 for generate the ministatement\npress 4 for for Main Manu\n\npress any key for logout");
			String choise=scan.next();
			if(choise.equals("1"))
			{
				access.balance(b);
				System.out.println();
				System.out.println("press 1 for countinue \npress any key for logout");
				String s=scan.next();
				if(s.equals("1"))
					flag=true;
				else
				{
					flag=false;
					System.out.println("Thank You! for using PhonePe...");
				}
			}
			else if(choise.equals("2"))
			{
				access.transfer(b);
				System.out.println();
				System.out.println("press 1 for countinue \npress any key for logout");
				String s=scan.next();
				if(s.equals("1"))
					flag=true;
				else
				{
					flag=false;
					System.out.println("Thank You! for using PhonePe...");
				}
			}
			else if(choise.equals("3"))
			{
				System.out.println("no detail avilable now after collection i will update");
				flag=true;
			}
			else if(choise.equals("4"))
			{
				exicute();
			}
			else
			{
				flag=false; 
				System.out.println("Thank You! for using PhonePe...");
			}	
			
		}
	}
	
	
}
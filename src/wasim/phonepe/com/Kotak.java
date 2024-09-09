package wasim.phonepe.com;

import java.util.InputMismatchException;
import java.util.Scanner;

class Kotak implements Bank
{
	static double balance=7000.00;
	private static String upiPin="null";
	static int lock=3;
	
	public static String getUpiPin() {
		return upiPin;
	}
	public static void setUpiPin(String upiPin) {
		Kotak.upiPin = upiPin;
	}
	
	public void upi() {
		Scanner scan=new Scanner(System.in);	
	}
	
	public void upiPin()
	{
			if(Kotak.getUpiPin().equals("null"))
			{
				Scanner scan=new Scanner(System.in);
				boolean flag=true;
		        while(flag)
		        {
		        	try
		        	{

			        	System.out.println("enter the 6-digit upiPin");
			            upiPin=scan.next();
			            int i=Integer.parseInt(upiPin);  
			            String temp=upiPin;
			            char ch[]=temp.toCharArray();
			            int count=0;
			            for(char c:ch)
			            {
			            	count++;
			            }
			            
			            if(count==6)
			            {
			                System.out.println("re-enter the 6-digit confirm upiPin");
			                String cpin=scan.next();
			                int j=Integer.parseInt(cpin);
			                if(upiPin.equals(cpin))
			                {
			                	System.out.println("upiPin successfully created");
			                	flag=false;
			                }
			                else
			                {
			                    System.err.println("upiPin is incorrect");
			                }
			            }
			            
			            else
			            {
			                System.err.println("please enter 6 digit upiPin only");
			            }
			        
		        	
		        	}
		        	catch(NumberFormatException e)
		        	{
		        		System.err.println("Please enter valid input\nInput in number format");
		        		continue;
		        	}
		        }
			}
	}
	

	@Override
	public void balance() 
	{
		int lock1=3;
    	if(lock!=0)
    	{
    		 lock=lock1;
    	}
		Scanner scan=new Scanner(System.in);
		boolean flag=true;
		while(flag)
		{
			try {

				System.out.println("enter the upiPin");
				
				String upiPin=scan.next();
				int i=Integer.parseInt(upiPin);  
				if(lock >0)
				{
					Setting s=SingleTon.getIntance();
					if(getUpiPin().equals(upiPin))
					{
						System.out.println("your Kotak bank Account balance is RS."+balance);
						flag=false;

					}
					else
					{
						System.err.println("upiPin is incorrect");
						lock--;
						if(lock>0)
						{
							System.err.println("only "+lock+" chance is left");
							System.out.println("Try Again!");
						}
					}
					if(lock==0)
					{
						System.err.println("Maximum chances attemp");
						System.err.println("Your Kotak UPI is locked for 24 hours");
						flag=false;
					}
				}
				else
				{
					System.err.println("Maximum chances attemp");
					System.err.println("Your Kotak UPI is locked for 24 hours");
					flag=false;
				}
				
			}
			catch(NumberFormatException e)
        	{
        		System.err.println("Please enter valid input\nInput in number format");
        		scan.nextLine();
        	}
		}
		
	}

	@Override
	public void transfer() 
	{
		int lock1=3;
    	if(lock!=0)
    	{
    		 lock=lock1;
    	}
		Scanner scan=new Scanner(System.in);
		Setting s=SingleTon.getIntance();
		boolean flag=true;
		while(flag)
		{
		try
		{
			System.out.println("enter the sending amount : ");
			double send=scan.nextDouble();
				try
				{
					if(lock>0)
					{
						System.out.println("enter the upiPin");
						String upiPin=scan.next();
						int i=Integer.parseInt(upiPin); 
						if(getUpiPin().equals(upiPin))
						{
							if(send<=balance  && send>0)
							{
								System.out.println(send+" sending successful on  : +91 "+s.mobileNumber);
								balance=balance-send;
								flag=false;
							}
							else if(send<0)
							{
								System.err.println("invilide ammount");
							}
							else
							{
								System.err.println("Insufficient balance");
							}

						}
						else
						{
							System.err.println("upiPin is incorrect");
							lock--;
							if(lock>0)
							{
								System.err.println("only "+lock+" chance is left");
								System.out.println("Try Again!");
							}
						}
						if(lock==0)
						{
							System.err.println("Maximum chances attemp");
							System.err.println("Your Kotak UPI is locked for 24 hours");
							flag=false;
						}
					}
					else
					{
						System.err.println("Maximum chances attemp");
						System.err.println("Your Kotak UPI is locked for 24 hours");
						flag=false;
					}
				}
				catch(NumberFormatException e)
	        	{
	        		System.err.println("Please enter valid input\nInput in number format");
	        		scan.nextLine();
	        	}
		}
		
		catch(InputMismatchException e)
    	{
    		System.err.println("Please enter valid input\nInput in number format");
    		scan.nextLine();
    	}
		
	}
	}


}

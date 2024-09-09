package wasim.phonepe.com;

import java.util.InputMismatchException;
import java.util.Scanner;

class AXIS implements Bank
{
	static double balance=15000.00;
	private static String upiPin="null";
	static int lock=3;
	
	public static String getUpiPin() {
		return upiPin;
	}
	public static void setUpiPin(String upiPin) {
		AXIS.upiPin = upiPin;
	}
	
	public void upi() {
		Scanner scan=new Scanner(System.in);	
	}
	
	public void upiPin()
	{
			if(AXIS.getUpiPin().equals("null"))
			{
				Scanner scan=new Scanner(System.in);
				boolean flag=true;
		        while(flag)
		        {
		        	try
		        	{

			        	System.out.println("ENTER THE 6-DIGIT UPIPIN");
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
			                System.out.println("RE-ENTER THE 6-DIGIT CONFIRM UPIPIN");
			                String cpin=scan.next();
			                int j=Integer.parseInt(cpin);
			                if(upiPin.equals(cpin))
			                {
			                	System.out.println("UPIPIN SUCCESSFULLY CREATED");
			                	flag=false;
			                }
			                else
			                {
			                    System.err.println("UPIPIN IS INCORRECT");
			                }
			            }
			            
			            else
			            {
			                System.err.println("PLEASE ENTER 6 DIGIT UPIPIN ONLY");
			            }
			        
		        	
		        	}
		        	catch(NumberFormatException e)
		        	{
		        		System.err.println("PLEASE ENTER VALID INPUT\nINPUT IN NUMBER FORMAT");
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
						System.out.println("your AXIS bank Account balance is RS."+balance);
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
						System.err.println("Your AXIS UPI is locked for 24 hours");
						flag=false;
					}
				}
				else
				{
					System.err.println("Maximum chances attemp");
					System.err.println("Your AXIS UPI is locked for 24 hours");
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
							System.err.println("Your AXIS UPI is locked for 24 hours");
							flag=false;
						}
					}
					else
					{
						System.err.println("Maximum chances attemp");
						System.err.println("Your AXIS UPI is locked for 24 hours");
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

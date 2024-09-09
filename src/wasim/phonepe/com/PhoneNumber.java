package wasim.phonepe.com;

import java.util.*;

public class PhoneNumber 
{
	public static long phn;
	public static void mobileNumber() 
	{
		Scanner scan=new Scanner(System.in);
		boolean flag=true;
        while(flag)
        {
        	try
        	{
        		System.out.println("enter the 10-digit mobileNumber");
        		System.out.print("+91 ");
            	phn=scan.nextLong();
                long temp=phn;
                int count=0;
                while(temp>0)
                {
                    count++;
                    temp=temp/10;   
                }
                if(count==10)
                {
                	if(phn>6000000000l)
                	{
                    		flag=false;
                	}
                	else
                		System.err.println("Please enter valid mobile number");
                }
                
                else
                {
                    System.err.println("please enter 10 digit mobileNumber only");
                }
        	}
        	catch(InputMismatchException e)
        	{
        		System.err.println("Please enter valid input\nInput in number format");
        		scan.nextLine();
        	}
        }
	}
	public static void otp() throws InterruptedException
	{
		Scanner scan=new Scanner(System.in);
		int otpLength = 4;
        String otp = genOtp(otpLength);
        System.out.print("please wait sending the otp");
        for(int i=0; i<=10; i++)
    	{
    		System.out.print('.');
    		Thread.sleep(500);
    	}
        System.out.println();
        System.out.println("sending otp to +91 "+phn+" is " + otp);
       
        boolean flag=true;
        while(flag)
        {
        	System.out.print("enter the otp : ");
    	    String cotp=scan.nextLine();
        	if(cotp.equals(otp))
            {
            	System.out.print("please wait Mobile Number is verifying");
            	for(int i=0; i<=10; i++)
            	{
            		System.out.print('.');
            		Thread.sleep(500);
            	}
            	System.out.println();
            	System.out.println("You are login successfull !");
            	System.out.println("=======================================");
            	System.out.println("Your Mobile number link with following bank :");
            	flag=false;
            }
            else
            {
            	System.err.println("please enter the valid otp ");
            	continue;
            }
        }
    }
    
    private static String genOtp(int length) 
    {
        String otp ="";
        Random random = new Random();
        
        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(10);
            otp=otp+digit;
        }
        
        return otp.toString();
        
    }
    
}


package wasim.phonepe.com;
import java.util.*;

class Setting 
{
	long mobileNumber;
	
	
	
	
	public void mobileNumber()
	{
		Scanner scan=new Scanner(System.in);
		boolean flag=true;
        while(flag)
        {
        	try
        	{
        		System.out.println("enter the 10-digit mobileNumber");
        		System.out.print("+91 ");
            	mobileNumber=scan.nextLong();
                long temp=mobileNumber;
                int count=0;
                while(temp>0)
                {
                    count++;
                    temp=temp/10;   
                }
                if(count==10)
                {
                	if(mobileNumber>6000000000l)
                		flag=false;
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
}

package wasim.phonepe.com;

import java.util.Random;

public class Demo {
	static String s="";
    public static void main(String[] args)
    {
    	
    	System.out.println(otp(4));
    }
    public static String otp(int l)
    {
    	Random random = new Random();
    	for(int i=0; i<l; i++)
    	{
    		int n=random.nextInt(10);
    		s=s+n;
    	}
    	return s;
    }
}

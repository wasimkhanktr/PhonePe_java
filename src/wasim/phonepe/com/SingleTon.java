package wasim.phonepe.com;

public class SingleTon extends Setting
{
	private static Setting intance= null;
	private void singleTon()
	{
		
	}
	public static Setting getIntance()
	{
		if(intance==null)
		{
			intance=new Setting();
		}
		return intance;
	}
}


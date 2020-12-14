package org.piangles.backbone.services.test;

public class ServiceTest extends Thread implements SessionAwareable
{
	private static String cipherAuthorizationId = "7a948dce-1ebb-4770-b077-f453e60243da";

	public static void main(String[] args) 
	{
		ServiceTest test = new ServiceTest();
		test.start();
		try
		{
			test.join();
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	public void run()
	{
		try
		{
			session();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public SessionDetails getSessionDetails()
	{
		return new SessionDetails("LoggingService", "TODOSessionId");
	}
}

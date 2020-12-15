package org.piangles.backbone.services.test;

import org.piangles.backbone.services.Locator;
import org.piangles.core.services.remoting.SessionAwareable;
import org.piangles.core.services.remoting.SessionDetails;
import org.piangles.core.stream.Stream;

public class FeaturesTestServiceClient extends Thread implements SessionAwareable
{
	private static String cipherAuthorizationId = "7a948dce-1ebb-4770-b077-f453e60243da";

	public static void main(String[] args) throws Exception
	{
		FeaturesTestServiceClient test = new FeaturesTestServiceClient();
		test.start();
	}

	public void run()
	{
		try
		{
			FeaturesTestService fts = Locator.getInstance().getFeaturesTestService();
			Stream<String> stream = fts.getStringSequences();
			
			System.out.println("Metadata :: " + stream.getMetadata());
			
			stream.processAsync((payload) -> {
				System.out.println("New message on stream : " + payload);
				return payload;
			});
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public SessionDetails getSessionDetails()
	{
		return new SessionDetails("FeaturesTestService", "TODOSessionId");
	}
}

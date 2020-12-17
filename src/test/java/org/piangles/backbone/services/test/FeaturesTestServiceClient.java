package org.piangles.backbone.services.test;

import org.piangles.backbone.services.Locator;
import org.piangles.core.stream.Stream;
import org.piangles.core.test.AbstractServiceTestClient;

public class FeaturesTestServiceClient extends AbstractServiceTestClient
{
	public static void main(String[] args) throws Exception
	{
		FeaturesTestServiceClient test = new FeaturesTestServiceClient();
		test.start();
	}

	public void runImpl() throws Exception
	{
		FeaturesTestService fts = Locator.getInstance().getFeaturesTestService();
		Stream<String> stream = fts.getStringSequences();
		
		System.out.println("Metadata :: " + stream.getMetadata());
		
		stream.processAsync((payload) -> {
			if (payload.isPresent())
			{
				System.out.println("New message on stream : " + payload.get());
			}
			else//End of Stream
			{
				System.out.println("This is the end of the stream");
			}
			return payload;
		});
	}
}

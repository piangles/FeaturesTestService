package org.piangles.backbone.services.test;

import org.piangles.core.services.remoting.ExecutionContext;
import org.piangles.core.stream.EndOfStream;
import org.piangles.core.stream.Stream;

public class FeaturesTestServiceImpl implements FeaturesTestService 
{

	@Override
	public Stream<String> getStringSequences() throws FeaturesTestException
	{
		Stream<String> stream = ExecutionContext.get().getStream();
		if (stream != null)
		{
			for (int i=0; i < 10; ++i)
			{
				System.out.println("Sending on stream :: " + i);
				stream.add("" + i);
				try
				{
					Thread.sleep(1000);
				}
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return new EndOfStream<>();
	}
}

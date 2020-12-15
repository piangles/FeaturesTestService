package org.piangles.backbone.services.test;

import org.piangles.core.email.EmailSupport;
import org.piangles.core.services.remoting.AbstractContainer;
import org.piangles.core.services.remoting.ContainerException;

public class FeaturesTestServiceContainer extends AbstractContainer
{
	public static void main(String[] args)
	{
		FeaturesTestServiceContainer container = new FeaturesTestServiceContainer();
		try
		{
			container.performSteps(args);
		}
		catch (ContainerException e)
		{
			EmailSupport.notify(e, e.getMessage());
			System.exit(-1);
		}
	}

	public FeaturesTestServiceContainer()
	{
		super(FeaturesTestService.NAME);
	}
	
	@Override
	protected Object createServiceImpl() throws ContainerException
	{
		Object service = null;
		try
		{
			service = new FeaturesTestServiceImpl();
		}
		catch (Exception e)
		{
			throw new ContainerException(e);
		}
		return service;
	}
}

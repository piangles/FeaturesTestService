/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.piangles.backbone.services.test;

import org.piangles.core.services.remoting.ExecutionContext;
import org.piangles.core.stream.StartOfStream;
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
		return new StartOfStream<>();
	}
}

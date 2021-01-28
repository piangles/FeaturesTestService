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

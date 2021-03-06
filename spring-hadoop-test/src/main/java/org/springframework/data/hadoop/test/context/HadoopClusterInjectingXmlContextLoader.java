/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.hadoop.test.context;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.MergedContextConfiguration;
import org.springframework.test.context.support.GenericXmlContextLoader;

/**
 * Extending generic xml based context loader able to
 * manage and inject Hadoop mini clusters. This loader is
 * used from {@link HadoopDelegatingSmartContextLoader}.
 *
 * @author Janne Valkealahti
 *
 */
public class HadoopClusterInjectingXmlContextLoader extends GenericXmlContextLoader {

	@Override
	protected void loadBeanDefinitions(GenericApplicationContext context,
			MergedContextConfiguration mergedConfig) {

		// let parent do its magic
		super.loadBeanDefinitions(context, mergedConfig);
		HadoopClusterInjectUtils.handleClusterInject(context, mergedConfig);
	}

}

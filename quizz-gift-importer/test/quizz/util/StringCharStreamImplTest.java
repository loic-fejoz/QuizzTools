/*******************************************************************************
 * Copyright (c) 11 janv. 2010 RealTime-at-Work.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    loic - initial API and implementation and/or initial documentation
 *******************************************************************************/
package quizz.util;

import org.junit.Before;

/**
 * @author loic
 * 
 */
public class StringCharStreamImplTest extends AbstractCharStreamImplTest {


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		fixtureString = "bla abcd";
		fixture = new StringCharStreamImpl(fixtureString);
	}
	
}

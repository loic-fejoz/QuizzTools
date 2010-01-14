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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author loic
 * 
 */
public abstract class AbstractCharStreamImplTest {

	protected CharStream fixture;
	protected String fixtureString;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		fixtureString = "bla abcd";
		fixture = new StringCharStreamImpl(fixtureString);
	}
	
	/**
	 * Test method for {@link quizz.util.StringCharStreamImpl#available()}.
	 */
	@Test
	public void testAvailable() {
		assertTrue(fixture.available());
		for(int i=0; i < fixtureString.length(); i++) {
			assertTrue(fixture.available());
			fixture.read();
		}
		assertFalse(fixture.available());
		assertFalse(fixture.available());
	}

	/**
	 * Test method for {@link quizz.util.StringCharStreamImpl#charAt(int)}.
	 */
	@Test
	public void testCharAt() {
		for(int i=0; i < fixtureString.length(); i++) {
			assertEquals(fixtureString.charAt(i), fixture.charAt(i));
		}
	}
	
	/**
	 * Test method for {@link quizz.util.StringCharStreamImpl#read()}.
	 */
	@Test
	public void testRead() {
		for(int i=0; i < fixtureString.length(); i++) {
			assertEquals(fixtureString.charAt(i), fixture.read());
		}
	}
	
	/**
	 * Test method for {@link quizz.util.StringCharStreamImpl#read(int)}.
	 */
	@Test
	public void testReadN() {
		final int n = 3;
		fixture.skip(n);
		for(int i=n; i < fixtureString.length(); i++) {
			assertEquals(fixtureString.charAt(i), fixture.read());
		}
	}

	/**
	 * Test method for {@link quizz.util.StringCharStreamImpl#getFromMark()}.
	 * Test method for {@link quizz.util.StringCharStreamImpl#setMark()}.
	 */
	@Test
	public void testMark() {
		fixture.setMark();
		fixture.read();
		fixture.read();
		fixture.read();
		assertEquals(fixtureString.substring(0, 3), fixture.getFromMark());
		fixture.skip(3);
		assertEquals(fixtureString.substring(0, 6), fixture.getFromMark());
	}

	/**
	 * Test method for
	 * {@link quizz.util.StringCharStreamImpl#startsWith(java.lang.String)}.
	 */
	@Test
	public void testStartsWith() {
		assertTrue(fixture.startsWith(fixtureString.substring(0, 3)));
		assertFalse(fixture.startsWith("-" + fixtureString.substring(1, 4)));
	}

}

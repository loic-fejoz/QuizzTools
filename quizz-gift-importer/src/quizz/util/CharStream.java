/*******************************************************************************
 * Copyright (c) 11 janv. 2010 RealTime-at-Work.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Loïc Fejoz - initial API and implementation and/or initial documentation
 *******************************************************************************/ 
package quizz.util;


/**
 * @author Loïc Fejoz
 *
 */
public interface CharStream /*extends Queue<char>*/ {

	/**
	 * Test if unread text starts as expected String.
	 * @param expected
	 * @return
	 */
	boolean startsWith(String expected);
	
	/**
	 * Return the character at the ahead position,
	 * ie at position current+ahead.
	 * @param ahead
	 * @return
	 */
	char charAt(int ahead);
	
	/**
	 * Return if there is any character available?
	 * @return
	 */
	boolean available();
	
	/**
	 * Read (eat?) the next character,
	 * ie return charAt(0).
	 * @return the next character
	 */
	char read();
	
	/**
	 * Same as skip(1);
	 */
	void skip();
	
	/**
	 * Skip, ie advance, the next n character.
	 */
	void skip(int n);
	
	/**
	 * Marck current position so as to retrieve String with getFromMark();
	 * @see getFromMark
	 */
	void setMark();
	
	/**
	 * Return text from last marked position and current position.
	 * @return
	 */
	String getFromMark();

}

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

/**
 * @author loic
 *
 */
public class StringCharStreamImpl implements CharStream {

	protected int index;
	protected final String value;
	protected int mark = 0;
	
	/**
	 * 
	 */
	public StringCharStreamImpl(final String value) {
		this.value = value;
		index = 0;
	}

	/* (non-Javadoc)
	 * @see quizz.importer.gift.CharStream#available()
	 */
	@Override
	public boolean available() {
		return index < value.length();
	}

	/* (non-Javadoc)
	 * @see quizz.importer.gift.CharStream#charAt(int)
	 */
	@Override
	public char charAt(int ahead) {
		return value.charAt(index + ahead);
	}

	/* (non-Javadoc)
	 * @see quizz.importer.gift.CharStream#getFromMark()
	 */
	@Override
	public String getFromMark() {
		return value.substring(mark, index);
	}

	/* (non-Javadoc)
	 * @see quizz.importer.gift.CharStream#setMark()
	 */
	@Override
	public void setMark() {
		mark = index;
	}

	/* (non-Javadoc)
	 * @see quizz.importer.gift.CharStream#startsWith(java.lang.String)
	 */
	@Override
	public boolean startsWith(String expected) {
		return value.substring(index).startsWith(expected);
	}

	@Override
	public char read() {
		char result = value.charAt(index);
		index++;
		return result;
	}

	@Override
	public void skip(int n) {
		index += n;
	}

	@Override
	public void skip() {
		skip(1);
	}

}

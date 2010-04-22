/*******************************************************************************
 * Copyright (c) 12 janv. 2010 RealTime-at-Work.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    loic - initial API and implementation and/or initial documentation
 *******************************************************************************/ 
package quizz.util;

import java.io.IOException;
import java.io.Reader;

/**
 * @author loic
 *
 */
public class ReaderCharStreamImpl implements CharStream {

	protected final Reader r;
	protected String read;
	protected String ahead;
	
	/**
	 * 
	 */
	public ReaderCharStreamImpl(final Reader r) {
		this.r = r;
		read = "";
		ahead = "";
	}
	
	protected void readAhead(int n) {
		assert n > 0;
		int c;
		while(ahead.length() <= n) {
			try {
				c = r.read();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			if (c == -1) {
				
				break;
			}
			ahead += (char)c;
		}
	}

	/* (non-Javadoc)
	 * @see quizz.util.CharStream#available()
	 */
	@Override
	public boolean available() {
		readAhead(1);
		return ahead.length() > 0;
	}

	/* (non-Javadoc)
	 * @see quizz.util.CharStream#charAt(int)
	 */
	@Override
	public char charAt(int nAhead) {
		readAhead(nAhead);
		return ahead.charAt(nAhead);
	}

	/* (non-Javadoc)
	 * @see quizz.util.CharStream#getFromMark()
	 */
	@Override
	public String getFromMark() {
		return read;
	}

	/* (non-Javadoc)
	 * @see quizz.util.CharStream#read()
	 */
	@Override
	public char read() {
		readAhead(1);
		final char r = ahead.charAt(0);
		ahead = ahead.substring(1);
		read += r;
		return r;
	}

	/* (non-Javadoc)
	 * @see quizz.util.CharStream#setMark()
	 */
	@Override
	public void setMark() {
		read = "";
	}

	/* (non-Javadoc)
	 * @see quizz.util.CharStream#skip()
	 */
	@Override
	public void skip() {
		skip(1);
	}

	/* (non-Javadoc)
	 * @see quizz.util.CharStream#skip(int)
	 */
	@Override
	public void skip(int n) {
		for(int i=0; i < n && available(); i++) {
			read();
		}
	}

	/* (non-Javadoc)
	 * @see quizz.util.CharStream#startsWith(java.lang.String)
	 */
	@Override
	public boolean startsWith(final String expected) {
		readAhead(expected.length());
		return ahead.startsWith(expected);
	}

}

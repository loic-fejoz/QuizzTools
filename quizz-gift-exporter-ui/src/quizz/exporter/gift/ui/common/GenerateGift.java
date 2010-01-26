/*******************************************************************************
 * Copyright (c) 26 janv. 2010 RealTime-at-Work.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    loic - initial API and implementation and/or initial documentation
 *******************************************************************************/ 
package quizz.exporter.gift.ui.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;

import quizz.Quizz;
import quizz.exporter.common.AbstractGenerate;

/**
 * @author loic
 *
 */
public class GenerateGift extends AbstractGenerate {

	/**
	 * 
	 * @param modelURI
	 * @param targetFolder
	 * @param outputName
	 */
	public GenerateGift(URI modelURI, File targetFolder,
			final String outputName) {
		super(modelURI, targetFolder, outputName);
	}

	@Override
	public void doGenerate(Quizz quizz, IProgressMonitor monitor)
			throws IOException {
		
		final File output = new File(targetFolder, outputName);
		final Writer writer = new OutputStreamWriter(new FileOutputStream(output));
		writer.append(quizz.toString());
		writer.flush();
		writer.close();
	}

}

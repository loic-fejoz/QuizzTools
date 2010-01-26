/*******************************************************************************
 * Copyright © 4 janv. 2010 RealTime-at-Work.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Loïc Fejoz - initial API and implementation and/or initial documentation
 *******************************************************************************/ 
package quizz.exporter.html.ui.common;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;

import quizz.Quizz;
import quizz.exporter.common.AbstractGenerate;
import quizz.exporter.html.ExportToJson;

/**
 * @author Loïc Fejoz
 *
 */
public class GenerateJson extends AbstractGenerate {

	/**
	 * @param modelURI
	 * @param targetFolder
	 * @param arguments
	 */
	public GenerateJson(URI modelURI, File targetFolder,
			final String outputName) {
		super(modelURI, targetFolder, outputName);
	}
	
	/**
	 * Launches the generation.
	 *
	 * @param monitor
	 *            This will be used to display progress information to the user.
	 * @throws IOException
	 *             Thrown when the output cannot be saved.
	 * @generated
	 */
	public void doGenerate(Quizz quizz, IProgressMonitor monitor) throws IOException {
		ExportToJson exporter = new ExportToJson();
		exporter.export(targetFolder, quizz, outputName);
	}

}

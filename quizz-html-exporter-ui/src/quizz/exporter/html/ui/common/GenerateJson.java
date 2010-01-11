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
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;

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
			List<? extends Object> arguments) {
		super(modelURI, targetFolder, arguments);
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
	public void doGenerate(IProgressMonitor monitor) throws IOException {
		if (!targetFolder.exists()) {
			targetFolder.mkdirs();
		}
		
		final URI template0 = getTemplateURI();
		quizz.exporter.html.files.ExportToJson gen0 = new quizz.exporter.html.files.ExportToJson(modelURI, targetFolder, arguments) {
			protected URI createTemplateURI(String entry) {
				return template0;
			}
		};
		gen0.doGenerate(BasicMonitor.toMonitor(monitor));
	}
	
	/* (non-Javadoc)
	 * @see quizz.exporter.html.ui.common.AbstractGenerate#getTemplateURI()
	 */
	@Override
	protected URI getTemplateURI() throws IOException {
		return getTemplateURI("quizz-html-exporter", new Path("/quizz/exporter/html/files/exportToJson.emtl"));
	}

}
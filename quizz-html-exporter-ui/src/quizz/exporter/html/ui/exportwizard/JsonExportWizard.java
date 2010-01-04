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
package quizz.exporter.html.ui.exportwizard;

import java.io.File;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.operation.IRunnableWithProgress;

import quizz.exporter.html.ui.common.GenerateJson;

/**
 * @author Loïc Fejoz
 *
 */
public class JsonExportWizard extends AbstractExportWizard {

	/**
	 * 
	 */
	public JsonExportWizard() {
		super();
	}

	/* (non-Javadoc)
	 * @see quizz.exporter.html.ui.exportwizard.AbstractExportWizard#getGenerator(org.eclipse.emf.common.util.URI, java.io.File, java.util.List)
	 */
	@Override
	protected IRunnableWithProgress getGenerator(URI uri, File file,
			List<? extends Object> arguments) {
		return new GenerateJson(uri, file, arguments);
	}

}

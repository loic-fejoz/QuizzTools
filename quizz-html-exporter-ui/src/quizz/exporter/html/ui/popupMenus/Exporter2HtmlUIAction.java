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
package quizz.exporter.html.ui.popupMenus;

import java.io.File;
import java.util.List;

import org.eclipse.emf.common.util.URI;

import quizz.exporter.html.ui.common.AbstractGenerate;
import quizz.exporter.html.ui.common.GenerateHtml;

/**
 * Quizz Html Exporter UI code generation.
 * 
 * @author Loïc Fejoz
 * 
 */
public class Exporter2HtmlUIAction extends AbstractExporterUIAction {

	@Override
	protected AbstractGenerate getGenerator(URI modelURI, File targetFolder,
			List<? extends Object> arguments) {
		return new GenerateHtml(modelURI, targetFolder, arguments);
	}


}
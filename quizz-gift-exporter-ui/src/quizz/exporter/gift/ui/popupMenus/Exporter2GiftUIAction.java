/*******************************************************************************
 * Copyright © 26 janv. 2010 RealTime-at-Work.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Loïc Fejoz - initial API and implementation and/or initial documentation
 *******************************************************************************/
package quizz.exporter.gift.ui.popupMenus;

import java.io.File;

import org.eclipse.emf.common.util.URI;

import quizz.exporter.common.AbstractGenerate;
import quizz.exporter.gift.ui.common.GenerateGift;
import quizz.exporter.popupMenus.AbstractExporterUIAction;

/**
 * Quizz Html Exporter UI code generation.
 * 
 * @author Loïc Fejoz
 * 
 */
public class Exporter2GiftUIAction extends AbstractExporterUIAction {

	@Override
	protected AbstractGenerate getGenerator(URI modelURI, File targetFolder,
			String outputName) {
		return new GenerateGift(modelURI, targetFolder, outputName);
	}

	@Override
	protected String getExtension() {
		return ".gift";
	}

}
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
package quizz.exporter.html.files;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.osgi.framework.Bundle;

import quizz.Quizz;

/**
 * @author Loïc Fejoz
 * 
 */
public class MyExportToHtml {

	/**
	 * The name of the module.
	 */
	public static final String MODULE_FILE_NAME = "exportToHtml";

	public MyExportToHtml(final URL templateURL) {
		setTemplateURL(templateURL);
	}

	public MyExportToHtml() throws IOException {
		if (EMFPlugin.IS_ECLIPSE_RUNNING) {
			setTemplateURL(FileLocator.toFileURL(MyExportToHtml.class
					.getResource(MODULE_FILE_NAME + ".emtl")));
		} else {
			setTemplateURL(MyExportToHtml.class.getResource(MODULE_FILE_NAME
					+ ".emtl"));
		}
	}

	public MyExportToHtml(Bundle bundle) {
		this(bundle.getEntry("/quizz/exporter/html/files/exportToHtml.emtl"));
	}

	public MyExportToHtml(String bundleID) {
		this(Platform.getBundle(bundleID));
	}

	public void setTemplateURL(final URL templateURL) {
		if (templateURL == null) {
			throw new IllegalArgumentException("templateURL must not be null");
		}
	}

	public String export(Quizz quizz) {
		return null;
	}

	public String export(URI quizzUri) {
		return null;
	}

	public void export(File folderTarget, Quizz quizz, String fileName) {
	}

	public void export(File folderTarget, URI quizzUri, String fileName) {
	}

}

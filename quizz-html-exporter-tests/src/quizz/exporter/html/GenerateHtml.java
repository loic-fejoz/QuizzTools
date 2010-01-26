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
package quizz.exporter.html;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import quizz.Quizz;
import quizz.QuizzPackage;
import quizz.importer.gift.GiftImporter;

/**
 * @author loic
 *
 */
public class GenerateHtml {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		final File inputFile = new File(args[0]);
		final Reader input = new FileReader(inputFile);
		final Quizz quizz;
		if (args[0].endsWith(".gift")) {
			final GiftImporter importer = new GiftImporter();
			quizz = importer.readQuizz(input);
		} else if (args[0].endsWith(".quizz")) {
			final QuizzPackage pkg = QuizzPackage.eINSTANCE;
			final ResourceSet resSet = new ResourceSetImpl();
			final URI uri = URI.createFileURI(inputFile.getAbsolutePath());
			assert uri != null;
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
					"quizz",
					new XMIResourceFactoryImpl()
					);
			final Resource res = resSet.getResource(uri, true);
			assert res != null;
			final Map<String, String> options = new HashMap<String, String>();
		    options.put(XMLResource.OPTION_ENCODING, "UTF-8");
			res.load(options);
		    quizz = (Quizz)res.getContents().get(0);
		} else {
			System.err.println("input file is of unknown format. Only gift and quizz are known.");
			System.exit(1);
			return;
		}
		final ExportToHtml exporter = new ExportToHtml();
		final File output = new File(args[1]);
		exporter.export(output, quizz);
		System.out.println(output.getAbsolutePath() + " was generated.");
	}

}

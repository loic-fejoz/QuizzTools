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
package quizz.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
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

/**
 * @author loic
 *
 */
public class GenerateGift {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		final File inputFile = new File(args[0]);
		final Quizz quizz;
		if (args[0].endsWith(".quizz")) {
			// register quizz schema and factory 
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
			System.err.println("input file is of unknown format. Only gift is known.");
			System.exit(1);
			return;
		}
		final File output = new File(args[1]);
		final Writer wrt = new OutputStreamWriter(new FileOutputStream(output));
		wrt.append(quizz.toString());
		wrt.flush();
		wrt.close();
		System.out.println(output.getAbsolutePath() + " was generated.");
	}

}

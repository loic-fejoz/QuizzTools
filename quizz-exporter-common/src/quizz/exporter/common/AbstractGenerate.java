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

package quizz.exporter.common;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.operation.IRunnableWithProgress;

import quizz.Quizz;
import quizz.QuizzPackage;


/**
 * Main entry point of the 'Quizz Html Exporter UI' generation module.
 * 
 */
abstract public class AbstractGenerate implements IRunnableWithProgress {

	/**
	 * The model URI, ie Quizz URI.
	 */
	protected URI modelURI;

	/**
	 * The output folder.
	 */
	protected File targetFolder;

	/**
	 * The name of the output file.
	 */
	protected String outputName;

	/**
	 * Constructor.
	 * 
	 * @param modelURI
	 *            is the URI of the model.
	 * @param targetFolder
	 *            is the output folder.
	 * @param output 
	 *            is the output file's name.
	 */
	public AbstractGenerate(final URI modelURI, final File targetFolder, final String outputName) {
		this.modelURI = modelURI;
		this.targetFolder = targetFolder;
		this.outputName = outputName;
	}

	protected Quizz loadQuizz() {
		assert modelURI != null;
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"quizz",
				new XMIResourceFactoryImpl()
				);
		// just to make sure the quizz schema and factory are registered 
		final QuizzPackage pkg = QuizzPackage.eINSTANCE;
		final ResourceSet resSet = new ResourceSetImpl();
		final Resource res = resSet.getResource(modelURI, true);
		assert res != null;
		final Map<String, String> options = new HashMap<String, String>();
	    options.put(XMLResource.OPTION_ENCODING, "UTF-8");
		try {
			res.load(options);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	    Quizz quizz = (Quizz)res.getContents().get(0);
	    assert quizz != null;
	    return quizz;
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
	public abstract void doGenerate(Quizz quizz, IProgressMonitor monitor) throws IOException;
	
	public void doGenerate(IProgressMonitor monitor) throws IOException {
		Quizz quizz = loadQuizz();
		doGenerate(quizz, monitor);
	}
	
	public void run(IProgressMonitor monitor) throws InvocationTargetException,
			InterruptedException {
		try {
			if (!targetFolder.exists()) {
				targetFolder.mkdirs();
			}
			doGenerate(monitor);
		} catch (IOException e) {
			throw new InvocationTargetException(e);
		}
	}

}

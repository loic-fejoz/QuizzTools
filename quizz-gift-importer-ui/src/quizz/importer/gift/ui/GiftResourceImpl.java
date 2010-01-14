/*******************************************************************************
 * Copyright © 13 janv. 2010 RealTime-at-Work.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Loïc Fejoz - initial API and implementation and/or initial documentation
 *******************************************************************************/ 
package quizz.importer.gift.ui;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Map;

import quizz.Quizz;
import quizz.importer.gift.GiftImporter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

/**
 * A Quizz whose content is encoded in Gift notation.
 * @author Loïc Fejoz
 *
 */
public class GiftResourceImpl extends ResourceImpl {

    /**
     * 
     */
    public GiftResourceImpl(URI uri) {
        super(uri);
    }
    
    /**
     * Called to load the resource.
     * @param inputStream the stream
     * @param options the load options.
     * @exception UnsupportedOperationException
     */
    @Override
    protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException
    {      
      GiftImporter importer = new GiftImporter();
      Reader r = new InputStreamReader(inputStream);
      Quizz quizz = importer.readQuizz(r);

      // Ok we got the content so keep it in memory.
      getContents().add(quizz);
    }    

    /**
     * Called to save the resource.
     * This implementation throws an exception;
     * clients must override it.
     * @param outputStream the stream
     * @param options the save options.
     * @exception UnsupportedOperationException
     */
    @Override
    protected void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException
    {
      throw new UnsupportedOperationException();
    }    
    
}

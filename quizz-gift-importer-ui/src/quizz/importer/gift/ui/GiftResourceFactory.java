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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * A factory for Quizz written in Gift format.
 * @author Loïc Fejoz
 *
 */
public class GiftResourceFactory implements Resource.Factory {

    @Override
    public Resource createResource(URI uri) {
        return new GiftResourceImpl(uri);
    }

}

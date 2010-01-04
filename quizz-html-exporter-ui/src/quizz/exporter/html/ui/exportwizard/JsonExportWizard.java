/**
 * quizz-html-exporter-ui
 * 2009 RealTime-at-Work
 * @author Loïc Fejoz
 */
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

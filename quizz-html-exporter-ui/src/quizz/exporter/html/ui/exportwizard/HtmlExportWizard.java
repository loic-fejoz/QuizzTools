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

import quizz.exporter.html.ui.common.GenerateHtml;

/**
 * @author Loïc Fejoz
 * 
 */
public class HtmlExportWizard extends AbstractExportWizard {

	/**
	 * 
	 */
	public HtmlExportWizard() {
		super();
	}

	@Override
	protected IRunnableWithProgress getGenerator(URI uri, File file,
			List<? extends Object> arguments) {
		return new GenerateHtml(uri, file, arguments);
	}

}

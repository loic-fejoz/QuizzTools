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
package quizz.exporter.html.ui.popupMenus;

import java.io.File;
import java.util.List;

import org.eclipse.emf.common.util.URI;

import quizz.exporter.html.ui.common.AbstractGenerate;
import quizz.exporter.html.ui.common.GenerateJson;

/**
 * Quizz Html Exporter UI code generation.
 * 
 * @author Loïc Fejoz
 * 
 */
public class Exporter2JsonUIAction extends AbstractExporterUIAction {

	@Override
	protected AbstractGenerate getGenerator(URI modelURI, File targetFolder,
			List<? extends Object> arguments) {
		return new GenerateJson(modelURI, targetFolder, arguments);
	}


}
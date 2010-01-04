/**
 * quizz-html-exporter-ui
 * 2009 RealTime-at-Work
 * @author Loïc Fejoz
 */
package quizz.exporter.html.ui.exportwizard;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;

/**
 * @author Loïc Fejoz
 * 
 */
abstract public class AbstractExportWizard extends Wizard implements
		IExportWizard {

	protected List<IFile> files;
	private IWorkbenchWindow window;

	/**
	 * 
	 */
	public AbstractExportWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	private ExportWizardPage page;

	/**
	 * Adding the page to the wizard.
	 */
	public void addPages() {
		page = new ExportWizardPage(files);
		addPage(page);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		MessageDialog.openInformation(window.getShell(), "Html export",
				"Will export " + files.size() + " files to "
						+ page.getTargetContainerName() + ".");

		List<? extends Object> arguments;
		URI uri;
		for (IFile file : files) {
			uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			arguments = Arrays.asList(file.getName());
			try {
				getContainer().run(
						false,
						true,
						getGenerator(uri, page.getTargetContainer()
								.getLocation().toFile(), arguments));
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		return true;
	}

	protected abstract IRunnableWithProgress getGenerator(URI uri, File file,
			List<? extends Object> arguments);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 * org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		window = workbench.getActiveWorkbenchWindow();
		if (selection instanceof IStructuredSelection) {
			files = ((IStructuredSelection) selection).toList();
		}
	}

}

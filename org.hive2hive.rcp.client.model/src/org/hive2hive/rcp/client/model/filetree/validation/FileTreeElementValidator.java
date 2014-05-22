/**
 *
 * $Id$
 */
package org.hive2hive.rcp.client.model.filetree.validation;

import java.nio.file.Path;
import org.eclipse.emf.common.util.EList;

import org.hive2hive.rcp.client.model.filetree.Container;
import org.hive2hive.rcp.client.model.filetree.FileTreeElement;

/**
 * A sample validator interface for {@link org.hive2hive.rcp.client.model.filetree.FileTreeElement}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface FileTreeElementValidator {
	boolean validate();

	boolean validateChildren(EList<FileTreeElement> value);
	boolean validateParent(FileTreeElement value);

	boolean validatePath(Path value);

	boolean validateName(String value);

	boolean validateParent(Container value);
}

package org.hive2hive.rcp.client.parts.filedetails.dialog;

import net.miginfocom.swt.MigLayout;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.hive2hive.rcp.client.model.filetree.TreeElement;

public class AddUserAccessRighsDialog extends TitleAreaDialog {

	// private static final Logger logger = LoggerFactory.getLogger(AddUserAccessRighsDialog.class);

	private Label lblFileName;
	private Label lblFilePath;
	private Text txtUserId;
	private Button btnReadAccess;
	private Button btnWriteAccess;

	private final TreeElement treeElement;

	private String userId;
	private boolean grantWriteAccess;

	public AddUserAccessRighsDialog(Shell parentShell, TreeElement treeElement) {
		super(parentShell);
		this.treeElement = treeElement;
	}

	@Override
	protected Control createDialogArea(Composite parent) {

		Composite area = (Composite) super.createDialogArea(parent);
		final Composite container = new Composite(area, SWT.NONE);

		MigLayout layout = new MigLayout("wrap", "[][grow]", "[]5[]5[]");
		container.setLayout(layout);

		setMessage("Add user access rights");

		Label label = new Label(container, SWT.NONE);
		label.setText("Filename:");
		lblFileName = new Label(container, SWT.NONE);
		lblFileName.setText(treeElement.getName());

		label = new Label(container, SWT.NONE);
		label.setText("Path:");
		lblFilePath = new Label(container, SWT.NONE);
		lblFilePath.setText(treeElement.getPath().toString());
		lblFilePath.setLayoutData("growx");

		label = new Label(container, SWT.NONE);
		label.setText("UserID:");
		txtUserId = new Text(container, SWT.SINGLE | SWT.BORDER | SWT.DOUBLE_BUFFERED);
		txtUserId.setLayoutData("width 180!");

		btnReadAccess = new Button(container, SWT.CHECK);
		btnReadAccess.setText("Grant read access");
		btnReadAccess.setSelection(true);
		btnReadAccess.setEnabled(false);

		btnWriteAccess = new Button(container, SWT.CHECK);
		btnWriteAccess.setText("Grant write access");
		return area;
	}

	@Override
	protected void okPressed() {
		persistsFields();
		super.okPressed();
	}

	protected void persistsFields() {
		userId = txtUserId.getText();
		grantWriteAccess = btnWriteAccess.getSelection();
	}

	public String getUserId() {
		return userId;
	}

	public boolean isGrantWriteAccess() {
		return grantWriteAccess;
	}
}

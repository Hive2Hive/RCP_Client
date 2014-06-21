package org.hive2hive.rcp.client.handler;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Shell;
import org.hive2hive.rcp.client.bundleresourceloader.IBundleResourceLoader;
import org.hive2hive.rcp.client.handler.dialog.UserLoginDialog;
import org.hive2hive.rcp.client.services.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginUserHandler {
	private static final Logger logger = LoggerFactory.getLogger(LoginUserHandler.class);

	@Execute
	public void loginUser(Shell shell, IBundleResourceLoader resourceLoader, IUserService userService) {
		UserLoginDialog dialog = new UserLoginDialog(shell, resourceLoader);
		if (IDialogConstants.OK_ID == dialog.open()) {
			logger.debug("Login user '{}'", dialog.getUserId());
			Path fileRootPath = Paths.get(dialog.getFileRoot());
			userService.registerAndLoginUser(dialog.getUserId(), dialog.getPassword(), dialog.getPin(), fileRootPath);
		} else {
			logger.debug("Cancel was pressed");
		}
	}
}

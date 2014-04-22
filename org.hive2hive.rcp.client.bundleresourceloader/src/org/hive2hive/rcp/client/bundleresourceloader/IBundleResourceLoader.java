package org.hive2hive.rcp.client.bundleresourceloader;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

public interface IBundleResourceLoader {

	public Image loadImage(Class<?> clazz, String path);

	public ImageData[] loadImageData(Class<?> clazz, String path);

}

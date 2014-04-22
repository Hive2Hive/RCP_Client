package org.hive2hive.rcp.client.bundleresourceloader.internal;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.hive2hive.rcp.client.bundleresourceloader.IBundleResourceLoader;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class BundleResourceLoaderImpl implements IBundleResourceLoader {

	/**
	 * Service does NOT recycle the provided image
	 * 
	 * Consumer of the image is responsible to call the dispose() method on the create Image.
	 * 
	 */

	@Override
	public Image loadImage(Class<?> clazz, String path) {
		Bundle bundle = FrameworkUtil.getBundle(clazz);
		URL url = FileLocator.find(bundle, new Path(path), null);
		ImageDescriptor imageDescr = ImageDescriptor.createFromURL(url);
		return imageDescr.createImage();
	}

	@Override
	public ImageData[] loadImageData(Class<?> clazz, String path) {
		Bundle bundle = FrameworkUtil.getBundle(clazz);
		URL url = FileLocator.find(bundle, new Path(path), null);

		ImageLoader loader = new ImageLoader();

		try {
			return loader.load(url.openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

}

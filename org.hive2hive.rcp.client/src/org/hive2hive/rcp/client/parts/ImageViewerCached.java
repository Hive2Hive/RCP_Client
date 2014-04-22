package org.hive2hive.rcp.client.parts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class ImageViewerCached extends Canvas {

	protected Point origin = new Point(0, 0);
	protected Image image;
	protected ImageData[] imageDatas;
	protected Image[] images;
	protected int current;
	private int repeatCount;
	private Runnable animationTimer;
	private Display display;

	public ImageViewerCached(Composite parent) {
		super(parent, SWT.NO_REDRAW_RESIZE | SWT.NO_BACKGROUND);
		display = getDisplay();
		addListeners();
	}

	public void setImage(ImageData imageData) {

		checkWidget();

		stopAnimationTimer();
		if (imageData != null) {
			this.image = new Image(display, imageData);
		}
		this.imageDatas = null;
		this.images = null;
		redraw();
	}

	/**
	 * @param repeatCount
	 *            0 forever
	 */
	public void setImages(ImageData[] imageDatas, int repeatCount) {
		checkWidget();

		this.image = null;
		this.imageDatas = imageDatas;
		this.repeatCount = repeatCount;
		convertImageDatasToImages();
		startAnimationTimer();
		redraw();
	}

	@Override
	public Point computeSize(int wHint, int hHint, boolean changed) {
		checkWidget();

		Image image = getCurrentImage();
		if (image != null) {
			Rectangle rect = image.getBounds();
			Rectangle trim = computeTrim(0, 0, rect.width, rect.height);
			return new Point(trim.width, trim.height);
		}

		return new Point(wHint, hHint);
	}

	@Override
	public void dispose() {
		if (image != null) {
			image.dispose();
		}

		if (images != null) {
			for (Image image2 : images) {
				image2.dispose();
			}
		}

		super.dispose();
	}

	protected void paint(Event e) {
		Image image = getCurrentImage();
		if (image == null) {
			return;
		}

		GC gc = e.gc;
		gc.drawImage(image, origin.x, origin.y);
		gc.setAntialias(SWT.ON);
	}

	void addListeners() {
		addListener(SWT.Paint, new Listener() {
			@Override
			public void handleEvent(Event e) {
				paint(e);
			}
		});
	}

	void convertImageDatasToImages() {
		images = new Image[imageDatas.length];

		for (int i = 0; i < imageDatas.length; i++) {
			ImageData id = imageDatas[i];
			images[i] = new Image(display, id);
		}
	}

	Image getCurrentImage() {
		if (image != null) {
			return image;
		}

		if (images == null) {
			return null;
		}

		return images[current];
	}

	void startAnimationTimer() {
		if (images == null || images.length < 2) {
			return;
		}

		final int delay = imageDatas[current].delayTime * 10;
		display.timerExec(delay, animationTimer = new Runnable() {
			@Override
			public void run() {
				if (isDisposed()) {
					return;
				}

				current = (current + 1) % images.length;
				redraw();

				if (current + 1 == images.length && repeatCount != 0 && --repeatCount <= 0) {
					return;
				}
				display.timerExec(delay, this);
			}
		});
	}

	void stopAnimationTimer() {
		if (animationTimer != null) {
			display.timerExec(-1, animationTimer);
		}
	}
}

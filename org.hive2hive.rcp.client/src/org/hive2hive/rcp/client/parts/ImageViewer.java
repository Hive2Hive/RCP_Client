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

public class ImageViewer extends Canvas {

	protected Point origin = new Point(0, 0);
	protected Image image;
	protected ImageData[] imageDatas;
	protected int current;
	private int repeatCount;
	private Runnable animationTimer;
	private Display display;

	public ImageViewer(Composite parent) {
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
		image.dispose();
	}

	void addListeners() {
		addListener(SWT.Paint, new Listener() {
			@Override
			public void handleEvent(Event e) {
				paint(e);
			}
		});
	}

	Image getCurrentImage() {
		if (image != null) {
			return image;
		}
		return new Image(display, imageDatas[current]);
	}

	void startAnimationTimer() {
		if (imageDatas == null || imageDatas.length < 2) {
			return;
		}

		final int delay = imageDatas[current].delayTime * 10;
		display.timerExec(delay, animationTimer = new Runnable() {
			@Override
			public void run() {
				if (isDisposed()) {
					return;
				}

				current = (current + 1) % imageDatas.length;
				redraw();

				if (current + 1 == imageDatas.length && repeatCount != 0 && --repeatCount <= 0) {
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

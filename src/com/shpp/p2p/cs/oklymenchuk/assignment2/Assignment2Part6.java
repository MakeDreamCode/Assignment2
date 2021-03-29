package com.shpp.p2p.cs.oklymenchuk.assignment2;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/**
 * Task 6. Caterpillar.
 */
public class Assignment2Part6 extends WindowProgram {

	/* Bugfix for Window (toolbar uses 23 pixels) */
	public static final int APPLICATION_HEIGHT = 200 + 23;
	public static final int APPLICATION_WIDTH = 400;

	/* Defines the number of links and the diameter of the link. */
	private static final int NUMBER_OF_LINKS = 6;
	private static final int LINK_DIAMETER = 100;

	/* Define y - position for a links */
	private static final int EVEN_Y = 40;
	private static final int ODD_Y = 70;

	/* Colors for a link of the caterpillar */
	private static final Color LINK_COLOR = Color.GREEN;
	private static final Color BORDER_COLOR = Color.RED;

	private static final int X_START_POSITION = 0;
	private static final int OFFSET_BETWEEN_LINK = 60;

	/**
	 * Main method
	 */
	public void run() {
		double offsetX = X_START_POSITION;

		for (int i = 1; i <= NUMBER_OF_LINKS; i++) {
			if (i % 2 != 0) {
				drawLink(offsetX, ODD_Y);
			} else {
				drawLink(offsetX, EVEN_Y);
			}
			/* set x - coordinate for  the next link */
			offsetX += OFFSET_BETWEEN_LINK;
		}
	}

	/**
	 * Draws a link of the caterpillar.
	 * @param x - start x-position of the link;
	 * @param y - start y-position of the link;
	 */
	private void drawLink(double x, double y) {
		GOval link = new GOval(x, y, LINK_DIAMETER, LINK_DIAMETER);
		link.setFilled(true);
		link.setFillColor(LINK_COLOR);
		link.setColor(BORDER_COLOR);
		add(link);
	}
}

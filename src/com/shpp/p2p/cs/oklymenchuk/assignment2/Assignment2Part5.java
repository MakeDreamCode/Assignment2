package com.shpp.p2p.cs.oklymenchuk.assignment2;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part5 extends WindowProgram {
	/* Bugfix for Window (toolbar uses 23 pixels) */
	public static final int APPLICATION_HEIGHT = 350 + 23;
	public static final int APPLICATION_WIDTH = 400;
	/* The number of rows and columns in the grid, respectively. */
	private static final int NUM_ROWS = 5;
	private static final int NUM_COLS = 6;
	/* The width and height of each box. */
	private static final double BOX_SIZE = 40;
	/* The horizontal and vertical spacing between the boxes. */
	private static final double BOX_SPACING = 10;
	/* Object for iterable */
	private static final double ITERABLE = BOX_SIZE + BOX_SPACING;
	/* FRAME */
	/* FRAME WIDTH & HEIGHT */
	private static final double FRAME_WIDTH = (NUM_COLS * ITERABLE) - BOX_SPACING;
	private static final double FRAME_HEIGHT = (NUM_ROWS * ITERABLE) - BOX_SPACING;
	/* x, y position for the FRAME*/
	private static final double FRAME_OFFSET_X = (APPLICATION_WIDTH - FRAME_WIDTH) / 2;
	private static final double FRAME_OFFSET_Y = (APPLICATION_HEIGHT - 23 - FRAME_HEIGHT) / 2;

	/**
	 * Main method.
	 */
	public void run() {
		/* Initialize firsts coordinates */
		double offsetX = FRAME_OFFSET_X;
		double offsetY = FRAME_OFFSET_Y;

		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_COLS; j++) {
				/* draw boxes at the row*/
				drawBox(offsetX, offsetY);
				offsetX = offsetX + ITERABLE;
			}
			/* drop the offsetX to the start position + iterate offsetY */
			offsetX = FRAME_OFFSET_X;
			offsetY = offsetY + ITERABLE;
		}
	}

	/**
	 * Draws a box.
	 * @param offsetX - the x-coordinate of the upper left point of the box;
	 * @param offsetY - the y-coordinate of the upper left point of the box;
	 */
	private void drawBox(double offsetX, double offsetY) {
		GRect box = new GRect(offsetX, offsetY, BOX_SIZE, BOX_SIZE);
		box.setColor(Color.BLACK);
		box.setFilled(true);
		add(box);
	}
}

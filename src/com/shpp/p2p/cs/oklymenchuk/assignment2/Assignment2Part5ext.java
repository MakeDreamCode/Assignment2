package com.shpp.p2p.cs.oklymenchuk.assignment2;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/**
 * Task 5. Next optical illusion with scaling.
 */
public class Assignment2Part5ext extends WindowProgram {
	/* Bugfix for Window (toolbar uses 23 pixels) */
	public static final int APPLICATION_HEIGHT = 750 + 23;
	public static final int APPLICATION_WIDTH = 800;
	/* The number of rows and columns in the grid, respectively. */
	private static final int NUM_ROWS = 10;
	private static final int NUM_COLS = 15;
	/* The width and height of each box. */
	private static final double BOX_SIZE = 40;
	/* The horizontal and vertical spacing between the boxes. */
	private static final double BOX_SPACING = 10;
	/* FRAME */
	private static final double FRAME_WIDTH = BOX_SPACING + (NUM_COLS * (BOX_SIZE + BOX_SPACING)) + BOX_SPACING;
	private static final double FRAME_HEIGHT = BOX_SPACING + (NUM_ROWS * (BOX_SIZE + BOX_SPACING)) + BOX_SPACING;


	/* SCALE`S OPERATION */
	private static final double SCALE = APPLICATION_WIDTH / FRAME_WIDTH;

	private static final double SCALED_BOX_SIZE = BOX_SIZE * SCALE;
	private static final double SCALED_BOX_SPACING = BOX_SPACING * SCALE;

	private static final double SCALED_FRAME_WIDTH = NUM_COLS * (SCALED_BOX_SIZE + SCALED_BOX_SPACING) - SCALED_BOX_SPACING;
	private static final double SCALED_FRAME_HEIGHT = NUM_ROWS * (SCALED_BOX_SIZE + SCALED_BOX_SPACING) - SCALED_BOX_SPACING;

	private static final double SCALED_FRAME_OFFSET_X = (APPLICATION_WIDTH - SCALED_FRAME_WIDTH) / 2;
	private static final double SCALED_FRAME_OFFSET_Y = (APPLICATION_HEIGHT - 23 - SCALED_FRAME_HEIGHT) / 2;

	/**
	 * Main method.
	 */
	public void run() {
		/* Initialize firsts coordinates */
		double offsetX = SCALED_FRAME_OFFSET_X;
		double offsetY = SCALED_FRAME_OFFSET_Y;

		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_COLS; j++) {
				/* draw boxes at the row */
				drawBox(offsetX, offsetY);
				offsetX = offsetX + SCALED_BOX_SIZE + SCALED_BOX_SPACING;
			}
			/* drop the offsetX to the start position + iterate offsetY */
			offsetX = SCALED_FRAME_OFFSET_X;
			offsetY = offsetY + SCALED_BOX_SIZE + SCALED_BOX_SPACING;
		}
	}

	/**
	 * Draws a box.
	 * @param offsetX - the x-coordinate of the upper left point of the box;
	 * @param offsetY - the y-coordinate of the upper left point of the box;
	 */
	private void drawBox(double offsetX, double offsetY) {
		GRect box = new GRect(offsetX, offsetY, SCALED_BOX_SIZE, SCALED_BOX_SIZE);
		box.setColor(Color.BLACK);
		box.setFilled(true);
		add(box);
	}
}

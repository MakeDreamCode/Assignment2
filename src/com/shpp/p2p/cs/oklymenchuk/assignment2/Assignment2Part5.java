package com.shpp.p2p.cs.oklymenchuk.assignment2;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part5 extends WindowProgram {
	/* The number of rows and columns in the grid, respectively. */
	private static final int NUM_ROWS = 5;
	private static final int NUM_COLS = 6;

	/* The width and height of each box. */
	private static final double BOX_SIZE = 40;

	/* The horizontal and vertical spacing between the boxes. */
	private static final double BOX_SPACING = 10;

	/* Bugfix for Window (toolbar uses 23 pixels) */
	public static final int APPLICATION_HEIGHT = 300 + 23;
	public static final int APPLICATION_WIDTH = 350;

	public static final int HEIGHT = 300;
	public static final int WIDTH = 350;

	/* FRAME*/
	private static final double FRAME_WIDTH = NUM_COLS * (BOX_SIZE + BOX_SPACING) - BOX_SPACING;
	private static final double FRAME_HEIGHT = NUM_ROWS * (BOX_SIZE + BOX_SPACING) - BOX_SPACING;

	/* Start position of Frame*/
	private static final double FRAME_OFFSET_X = (WIDTH - FRAME_WIDTH) / 2;
	private static final double FRAME_OFFSET_Y = (HEIGHT - FRAME_HEIGHT) / 2;

	public void run(){

		double offsetX = FRAME_OFFSET_X;
		double offsetY = FRAME_OFFSET_Y;

		for (int i = 0; i < NUM_ROWS ; i++) {
			for (int j = 0; j < NUM_COLS; j++) {
				drawBox(offsetX, offsetY);
				offsetX = offsetX + BOX_SIZE + BOX_SPACING;
			}
			offsetX = FRAME_OFFSET_X;
			offsetY = offsetY + BOX_SIZE + BOX_SPACING;
		}
	}

	private void drawBox(double offsetX, double offsetY){
		GRect box = new GRect(offsetX, offsetY, BOX_SIZE, BOX_SIZE);
		box.setColor(Color.BLACK);
		box.setFilled(true);
		add(box);
	}
}

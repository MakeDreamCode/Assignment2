package com.shpp.p2p.cs.oklymenchuk.assignment2;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/**
 * Task 3. Pawprint.
 */
public class Assignment2Part3 extends WindowProgram {

	/* The default width and height of the window. These constants will tell Java to
	 * create a window whose size is *approximately* given by these dimensions. You should
	 * not directly use these constants in your program; instead, use getWidth() and
	 * getHeight(), which return the *exact* width and height of the window.
	 */
	public static final int APPLICATION_WIDTH = 270;
	public static final int APPLICATION_HEIGHT = 220;
	/* Constants controlling the relative positions of the three toes to the upper-left corner of the pawprint(). */
	private static final double FIRST_TOE_OFFSET_X = 0;
	private static final double FIRST_TOE_OFFSET_Y = 20;
	private static final double SECOND_TOE_OFFSET_X = 30;
	private static final double SECOND_TOE_OFFSET_Y = 0;
	private static final double THIRD_TOE_OFFSET_X = 60;
	private static final double THIRD_TOE_OFFSET_Y = 20;
	/* The position of the heel relative to the upper-left corner of the pawprint(). */
	private static final double HEEL_OFFSET_X = 20;
	private static final double HEEL_OFFSET_Y = 40;
	/* Each toe is an oval with this width and height. */
	private static final double TOE_WIDTH = 20;
	private static final double TOE_HEIGHT = 30;
	/* The heel is an oval with this width and height. */
	private static final double HEEL_WIDTH = 40;
	private static final double HEEL_HEIGHT = 60;

	/**
	 * Main method.
	 */
	public void run() {
		drawPawprint(20, 20);
		drawPawprint(180, 70);
	}

	/**
	 * Draws a pawprint. The parameters should specify the upper-left corner of the
	 * bounding box containing that pawprint.
	 * @param x The x coordinate of the upper-left corner of the bounding box for the pawprint.
	 * @param y The y coordinate of the upper-left corner of the bounding box for the pawprint.
	 */
	private void drawPawprint(double x, double y) {
		/* print the heel */
		printHeel(x + HEEL_OFFSET_X, y + HEEL_OFFSET_Y);
		/* print three toes */
		printToe(x + FIRST_TOE_OFFSET_X, y + FIRST_TOE_OFFSET_Y);
		printToe(x + SECOND_TOE_OFFSET_X, y + SECOND_TOE_OFFSET_Y);
		printToe(x + THIRD_TOE_OFFSET_X, y + THIRD_TOE_OFFSET_Y);
	}

	/**
	 * Draws a heel of a paw.
	 * @param x - The x coordinate of the upper-left corner of the bounding box for the heel.
	 * @param y - The y coordinate of the upper-left corner of the bounding box for the heel.
	 */
	private void printHeel(double x, double y){
		GOval heel = new GOval(x, y, HEEL_WIDTH, HEEL_HEIGHT);
		heel.setFillColor(Color.BLACK);
		heel.setFilled(true);
		add(heel);
	}

	/**
	 * Draws a toe of paw.
	 * @param x - The x coordinate of the upper-left corner of the bounding box for the toe.
	 * @param y - The y coordinate of the upper-left corner of the bounding box for the toe.
	 */
	private void printToe(double x, double y){
		GOval firstToe = new GOval(x, y, TOE_WIDTH, TOE_HEIGHT);
		firstToe.setFillColor(Color.BLACK);
		firstToe.setFilled(true);
		add(firstToe);
	}
}

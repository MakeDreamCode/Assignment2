package com.shpp.p2p.cs.oklymenchuk.assignment2;

import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/**
 * Task 2. Illusory outlines.
 */
public class Assignment2Part2 extends WindowProgram {
	/* Define coordinates for the application */
	public static final int APPLICATION_HEIGHT = 350 + 23; 		//bugfix for win (23 pixels for the topbar)
	public static final int APPLICATION_WIDTH  = 400;
	/* for readable code only*/
	public static final int HEIGHT = APPLICATION_HEIGHT - 23;
	/* Define coordinates for circles */
	public static final int CIRCLE_DIAMETER = APPLICATION_WIDTH / 3;
	public static final int CIRCLE_X1 = 0;
	public static final int CIRCLE_Y1 = 0;
	public static final int CIRCLE_X2 = APPLICATION_WIDTH - CIRCLE_DIAMETER;
	public static final int CIRCLE_Y2 = 0;
	public static final int CIRCLE_X3 = 0;
	public static final int CIRCLE_Y3 = HEIGHT - CIRCLE_DIAMETER;
	public static final int CIRCLE_X4 = APPLICATION_WIDTH - CIRCLE_DIAMETER;
	public static final int CIRCLE_Y4 = HEIGHT - CIRCLE_DIAMETER;
	/* Define coordinates for a rectangle */
	public static final int RECTANGLE_X = CIRCLE_X1 + CIRCLE_DIAMETER / 2;
	public static final int RECTANGLE_Y = CIRCLE_Y1 + CIRCLE_DIAMETER / 2;
	public static final int RECTANGLE_WIDTH = CIRCLE_X4;
	public static final int RECTANGLE_HEIGHT = CIRCLE_Y4;

	/**
	 * Main method.
	 */
	public void run(){
		/* draw circles */
		drawCircle(CIRCLE_X1, CIRCLE_Y1, CIRCLE_DIAMETER);
		drawCircle(CIRCLE_X2, CIRCLE_Y2, CIRCLE_DIAMETER);
		drawCircle(CIRCLE_X3, CIRCLE_Y3, CIRCLE_DIAMETER);
		drawCircle(CIRCLE_X4, CIRCLE_Y4, CIRCLE_DIAMETER);
		/*  draw rectangle */
		GRect rectangle = new GRect(RECTANGLE_X, RECTANGLE_Y, RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
		rectangle.setColor(Color.WHITE);
		rectangle.setFilled(true);
		add(rectangle);
	}

	/**
	 * Method draws a circle. A circle is inscribed in a square.
	 * @param x - the x-coordinate of the upper left point of the square;
	 * @param y - the y-coordinate of the upper left point of the square;
	 * @param circle_diameter - diameter of the circle.
	 */
	private void drawCircle(int x, int y, int circle_diameter){
		GOval circle = new GOval(x, y, circle_diameter, circle_diameter);
		circle.setFillColor(Color.BLACK);
		circle.setFilled(true);
		add(circle);
	}
}

package com.shpp.p2p.cs.oklymenchuk.assignment2;

import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part2 extends WindowProgram {

	public static final int APPLICATION_HEIGHT = 600 + 23; //bugfix for win (23 pixels for the topbar)
    public static final int APPLICATION_WIDTH  = 600;

    public static final int HEIGHT = APPLICATION_HEIGHT - 23; //bugfix for win (23 pixels for the topbar)
	public static final int WIDTH = APPLICATION_WIDTH;

	public static final int CIRCLE_DIAMETER = WIDTH / 3;

	public static final int CIRCLE_X1 = 0;
	public static final int CIRCLE_Y1 = 0;

	public static final int CIRCLE_X2 = WIDTH - CIRCLE_DIAMETER;
	public static final int CIRCLE_Y2 = 0;

	public static final int CIRCLE_X3 = 0;
	public static final int CIRCLE_Y3 = HEIGHT - CIRCLE_DIAMETER;

	public static final int CIRCLE_X4 = WIDTH - CIRCLE_DIAMETER;
	public static final int CIRCLE_Y4 = HEIGHT - CIRCLE_DIAMETER;

	public static final int RECTANGLE_X = CIRCLE_X1 + CIRCLE_DIAMETER / 2;
	public static final int RECTANGLE_Y = CIRCLE_Y1 + CIRCLE_DIAMETER / 2;

	public static final int RECTANGLE_WIDTH = CIRCLE_X4;
	public static final int RECTANGLE_HEIGHT = CIRCLE_Y4;

	public void run(){

//		System.out.println("Координаты первого круга: " + CIRCLE_X1 + " " + CIRCLE_Y1);
        GOval circle1 = new GOval(CIRCLE_X1, CIRCLE_Y1, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
        circle1.setFillColor(Color.BLACK);
        circle1.setFilled(true);
        add(circle1);

//        GRect debug1 = new GRect(0, CIRCLE_DIAMETER, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
//        debug1.setFillColor(Color.RED);
//        debug1.setFilled(true);
//        add(debug1);

//		System.out.println("Координаты второго круга: " + CIRCLE_X2 + " " + CIRCLE_Y2);
        GOval circle2 = new GOval(CIRCLE_X2, CIRCLE_Y2, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
        circle2.setFillColor(Color.BLACK);
        circle2.setFilled(true);
        add(circle2);

//		GRect debug2 = new GRect(CIRCLE_DIAMETER, 0, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
//		debug2.setFillColor(Color.GREEN);
//		debug2.setFilled(true);
//		add(debug2);

//		System.out.println("Координаты третьего круга: " + CIRCLE_X3 + " " + CIRCLE_Y3);
        GOval circle3 = new GOval(CIRCLE_X3, CIRCLE_Y3, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
        circle3.setFillColor(Color.BLACK);
        circle3.setFilled(true);
        add(circle3);

//		System.out.println("Координаты четвертого круга: " + CIRCLE_X4 + " " + CIRCLE_Y4);
        GOval circle4 = new GOval(CIRCLE_X4, CIRCLE_Y4, CIRCLE_DIAMETER, CIRCLE_DIAMETER);
        circle4.setFillColor(Color.BLACK);
        circle4.setFilled(true);
        add(circle4);

        GRect rectangle = new GRect(RECTANGLE_X, RECTANGLE_Y, RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
        rectangle.setColor(Color.WHITE);
        rectangle.setFilled(true);
        add(rectangle);

//        System.out.println("Ширина поля: " + getWidth() + " Высота поля: " + getHeight());
//		System.out.println("Диаметр круга: " + CIRCLE_DIAMETER);
    }
}

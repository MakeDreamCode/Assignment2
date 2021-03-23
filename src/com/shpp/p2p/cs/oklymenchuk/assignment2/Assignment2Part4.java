package com.shpp.p2p.cs.oklymenchuk.assignment2;

import acm.graphics.GLabel;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment2Part4 extends WindowProgram {

	public static final int APPLICATION_HEIGHT = 300 + 23; //bugfix for win (23 pixels for the topbar)
	public static final int APPLICATION_WIDTH = 450;

	public static final int HEIGHT = 300;
	public static final int WIDTH = 450;

	private static final int VERTICAL_FLAG_OFFSET_X = WIDTH / 5;                                   	// x-offset from the left border for a vertical flag
	private static final int VERTICAL_FLAG_OFFSET_Y = HEIGHT / 10;                                  // y-offset from the top border for a vertical flag

	private static final int VERTICAL_FLAG_SEGMENT_WIDTH = WIDTH / 5;                               // width of one vertical flag`s segment
	private static final int VERTICAL_FLAG_SEGMENT_HEIGHT = HEIGHT - (2 * VERTICAL_FLAG_OFFSET_Y);  // height of one vertical flag`s segment

	private static final int HORIZONTAL_FLAG_OFFSET_X = WIDTH / 5;
	private static final int HORIZONTAL_FLAG_OFFSET_Y = HEIGHT / 5;

	private static final int HORIZONTAL_FLAG_SEGMENT_WIDTH = WIDTH * 3 / 5;
	private static final int HORIZONTAL_FLAG_SEGMENT_HEIGHT = HEIGHT / 5;

	private static final String MESSAGE_FLAG_OF = "Flag of ";

	public void run() {
		// для генерации случайных значений сделать мапу (ключ: номер, значение: объект?)
		CountryFlag flagBelgium = new CountryFlag("Belgium",
				new Color[]{Color.BLACK, Color.YELLOW, Color.RED},
				true);

		CountryFlag flagRussia = new CountryFlag("Russia Federation",
				new Color[]{Color.BLACK, Color.BLUE, Color.RED},
				false);

		drawFlag(flagBelgium);
//		drawFlag(flagRussia);

	}

	private void drawFlag(CountryFlag flag) {
		if (flag.isVertical) {

			int offsetX = VERTICAL_FLAG_OFFSET_X;

			for (int i = 0; i < flag.flagColors.length; i++) {
				drawVerticalSegment(offsetX, flag.flagColors[i]);
				offsetX = offsetX + VERTICAL_FLAG_SEGMENT_WIDTH;
			}
		} else {

			int offsetY = HORIZONTAL_FLAG_OFFSET_Y;

			for (int i = 0; i < flag.flagColors.length; i++) {
				drawHorizontalSegment(offsetY, flag.flagColors[i]);
				offsetY = offsetY + HORIZONTAL_FLAG_SEGMENT_HEIGHT;
			}
		}
		// draw label !!! NEED TO REWRITE
		GLabel country = new GLabel(MESSAGE_FLAG_OF + flag.countryName);
		double x = getWidth() * 0.6;	// bullshit! need to push off the right border
		double y = getHeight() * 0.97;	// and to push off the bottom border
		country.setFont("SansSerif-bold-18");
		add(country, x, y);
	}

	private void drawVerticalSegment(int offsetX, Color flagColor) {
		GRect verticalSegment = new GRect(offsetX, VERTICAL_FLAG_OFFSET_Y, VERTICAL_FLAG_SEGMENT_WIDTH, VERTICAL_FLAG_SEGMENT_HEIGHT);
		verticalSegment.setColor(flagColor);
		verticalSegment.setFilled(true);
		add(verticalSegment);
	}

	private void drawHorizontalSegment(int offsetY, Color flagColor) {
		GRect segmentOfFlag = new GRect(HORIZONTAL_FLAG_OFFSET_X, offsetY, HORIZONTAL_FLAG_SEGMENT_WIDTH, HORIZONTAL_FLAG_SEGMENT_HEIGHT);
		segmentOfFlag.setColor(flagColor);
		segmentOfFlag.setFilled(true);
		add(segmentOfFlag);
	}

	class CountryFlag {
		String countryName;
		Color[] flagColors;
		boolean isVertical;

		public CountryFlag(String countryName, Color[] flagColors, boolean isVertical) {
			this.countryName = countryName;
			this.flagColors = flagColors;
			this.isVertical = isVertical;
		}
	}
}

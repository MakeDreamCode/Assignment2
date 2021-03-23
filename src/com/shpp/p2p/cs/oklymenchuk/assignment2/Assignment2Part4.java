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

	private static final int WINDOW_SHOWS_FLAG_OFFSET_X = WIDTH / 6;    // X of the start WINDOW
	private static final int WINDOW_SHOWS_FLAG_OFFSET_Y = HEIGHT / (2 * 5);    // Y of the start WINDOW

	private static final int WINDOW_SHOWS_FLAG_WIDTH = WIDTH * 4 / 6;    // WINDOW WIDTH
	private static final int WINDOW_SHOWS_FLAG_HEIGHT = HEIGHT * 4 / 5; // WINDOW HEIGHT

	private static final String MESSAGE_FLAG_OF = "Flag of ";
	private static final String LABEL_FONT = "SansSerif-bold-16";
	private static final int LABEL_OFFSET_RIGHT_BORDER = 10;
	private static final int LABEL_OFFSET_BOTTOM_BORDER = 10;

	public void run() {
		// для генерации случайных значений сделать мапу (ключ: номер, значение: объект?)
		CountryFlag flagBelgium = new CountryFlag("Belgium",
				new Color[]{Color.BLACK, Color.YELLOW, Color.RED},
				true);

		CountryFlag flagBurkinaFaso = new CountryFlag("Burkina - Faso",
				new Color[]{Color.BLACK, Color.YELLOW, Color.RED, Color.CYAN},
				true);

		CountryFlag flagRussia = new CountryFlag("Russia Federation",
				new Color[]{Color.BLACK, Color.BLUE, Color.RED},
				false);

		CountryFlag flagSpectre = new CountryFlag("Spectral Republic",
				new Color[]{Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA},
				false);
		CountryFlag flagUkraine = new CountryFlag("Ukraine",
				new Color[]{Color.BLUE, Color.YELLOW},
				false);

//		drawFlag(flagBelgium);
//		drawFlag(flagRussia);
//		drawFlag(flagBurkinaFaso);
//		drawFlag(flagSpectre);
		drawFlag(flagUkraine);

	}

	private void drawFlag(CountryFlag flag) {
		if (flag.isVertical) {

			int offsetX = WINDOW_SHOWS_FLAG_OFFSET_X;
			int segmentLength = WINDOW_SHOWS_FLAG_WIDTH / flag.flagColors.length;

			for (int i = 0; i < flag.flagColors.length; i++) {
				drawVerticalSegment(offsetX, segmentLength, flag.flagColors[i]);
				offsetX = offsetX + segmentLength;
			}
		} else {

			int offsetY = WINDOW_SHOWS_FLAG_OFFSET_Y;
			int segmentLength = WINDOW_SHOWS_FLAG_HEIGHT / flag.flagColors.length;

			for (int i = 0; i < flag.flagColors.length; i++) {
				drawHorizontalSegment(offsetY, segmentLength, flag.flagColors[i]);
				offsetY = offsetY + segmentLength;
			}
		}

		drawSignature(flag.countryName);            // draw country name
	}

	private void drawVerticalSegment(int offsetX, int segmentLength, Color flagColor) {
		GRect verticalSegment = new GRect(offsetX, WINDOW_SHOWS_FLAG_OFFSET_Y,
				segmentLength, WINDOW_SHOWS_FLAG_HEIGHT);
		verticalSegment.setColor(flagColor);
		verticalSegment.setFilled(true);
		add(verticalSegment);
	}

	private void drawHorizontalSegment(int offsetY, int segmentLength, Color flagColor) {
		GRect segmentOfFlag = new GRect(WINDOW_SHOWS_FLAG_OFFSET_X, offsetY,
				WINDOW_SHOWS_FLAG_WIDTH, segmentLength);
		segmentOfFlag.setColor(flagColor);
		segmentOfFlag.setFilled(true);
		add(segmentOfFlag);
	}

	private void drawSignature(String nameCountry) {
		GLabel signature = new GLabel(MESSAGE_FLAG_OF + nameCountry);
		signature.setFont(LABEL_FONT);
		double x = (getWidth() - signature.getWidth()) - LABEL_OFFSET_RIGHT_BORDER;        // offset from the right border
		double y = signature.getDescent() > LABEL_OFFSET_BOTTOM_BORDER ? getHeight() - signature.getDescent() :
				getHeight() - LABEL_OFFSET_BOTTOM_BORDER;    // offset 10 pxs from the bottom border
		add(signature, x, y);
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

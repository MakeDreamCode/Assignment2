package com.shpp.p2p.cs.oklymenchuk.assignment2;

import acm.graphics.GLabel;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/**
 * Task 4. Tricolor flags.
 */
public class Assignment2Part4 extends WindowProgram {

	public static final int APPLICATION_HEIGHT = 300 + 23; //bugfix for win (23 pixels for the topbar)
	public static final int APPLICATION_WIDTH = 450;
	/* for readable code only*/
	public static final int HEIGHT = APPLICATION_HEIGHT - 23;

	/* FRAME */
	/* x, y position for the FRAME*/
	private static final int FRAME_OFFSET_X = APPLICATION_WIDTH / 6;
	private static final int FRAME_OFFSET_Y = HEIGHT / (2 * 5);
	/* FRAME WIDTH & HEIGHT */
	private static final int FRAME_WIDTH = APPLICATION_WIDTH * 4 / 6;
	private static final int FRAME_HEIGHT = HEIGHT * 4 / 5;
	/* Label properties */
	private static final String MESSAGE_FLAG_OF = "Flag of ";
	private static final String LABEL_FONT = "SansSerif-bold-16";
	private static final int LABEL_OFFSET_RIGHT_BORDER = 10;
	private static final int LABEL_OFFSET_BOTTOM_BORDER = 10;

	/**
	 * Main method.
	 */
	public void run() {
		/* Create object Flag of Belgium */
		CountryFlag flagBelgium = new CountryFlag("Belgium",
				new Color[]{Color.BLACK, Color.YELLOW, Color.RED});
		/* draw the flag*/
		drawFlag(flagBelgium);
	}

	/**
	 * Draws a flag.
	 * @param flag - class CountryFlag.
	 */
	private void drawFlag(CountryFlag flag) {
		/* calculates the X - start position + the segment`s length */
		int offsetX = FRAME_OFFSET_X;
		/* how many segments will be show (equals color number) */
		int segmentLength = FRAME_WIDTH / flag.flagColors.length;

		/* fills FRAME with vertical segments */
		for (int i = 0; i < flag.flagColors.length; i++) {
			drawVerticalSegment(offsetX, segmentLength, flag.flagColors[i]);
			/* calculates the next X (start position of the segment) */
			offsetX = offsetX + segmentLength;
		}
		/* Draw a country name signature */
		drawSignature(flag.countryName);
	}

	/**
	 * Draws a segment of the flag.
	 * @param offsetX       - start x-position of the vertical segment;
	 * @param segmentLength - length of the vertical segment;
	 * @param flagColor     - array of Color objects.
	 */
	private void drawVerticalSegment(int offsetX, int segmentLength, Color flagColor) {
		GRect verticalSegment = new GRect(offsetX, FRAME_OFFSET_Y,
				segmentLength, FRAME_HEIGHT);
		verticalSegment.setColor(flagColor);
		verticalSegment.setFilled(true);
		add(verticalSegment);
	}

	/**
	 * Draws a signature.
	 * @param nameCountry - string from CountryFlag class.
	 */
	private void drawSignature(String nameCountry) {
		GLabel signature = new GLabel(MESSAGE_FLAG_OF + nameCountry);
		signature.setFont(LABEL_FONT);
		/* calculates offset from the right border */
		double x = (getWidth() - signature.getWidth()) - LABEL_OFFSET_RIGHT_BORDER;
		/* calculates offset from the bottom border */
		double y = signature.getDescent() > LABEL_OFFSET_BOTTOM_BORDER ? getHeight() - signature.getDescent() :
				getHeight() - LABEL_OFFSET_BOTTOM_BORDER;
		add(signature, x, y);
	}

	/**
	 * Class CountryFlag.
	 */
	static class CountryFlag {
		String countryName;
		Color[] flagColors;

		public CountryFlag(String countryName, Color[] flagColors) {
			this.countryName = countryName;
			this.flagColors = flagColors;
		}
	}
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.*;

import java.awt.*;

/**
 * File:	GreenShades.java
 * Author:	Brady Coye
 * Description:	Creates custom shades of green representing integer values from a txt file.
 * Displays those colors as small panels each with a label of the shade value. 
 * Values are normalized to 100-250 range so colors are not too dark.
 * 3/30/2015
 */

public class GreenShades{
	public int [] fileInfo;
	public int [] colorInfo;
	int count = 0;
	private final int maxSize = 100;

	public GreenShades () {

		// opens file and sorts data into array
		Scanner fileIn = new Scanner(System.in);
		int [] tempInfo = new int [maxSize];
		System.out.print("Enter the file name: ");
		String file = fileIn.nextLine();
		try {
			fileIn = new Scanner(new File(file));
		} catch (FileNotFoundException e) {
			System.out.println("File: " + file + " is not found");
			System.exit(0);
		}
		while( fileIn.hasNextInt() )  {
			int info = fileIn.nextInt();
			tempInfo[count] = info;
			count++;
		}
		fileIn.close();

		//creates proper size array
		fileInfo = new int [count];
		for (int i=0; i < count; i++) {
			fileInfo[i] = tempInfo[i];
		}

		// finds max and min inside array
		int max = fileInfo[0];
		int min = fileInfo[0];
		for (int i=0; i < fileInfo.length; i++) {
			if (fileInfo[i] > max) {
				max = fileInfo[i];
			}
			if (fileInfo[i] < min) {
				min = fileInfo[i];
			}
		}

		//makes new array with normalized values (shades of green)
		colorInfo = new int [count];
		for (int i=0; i < fileInfo.length; i++) {
			colorInfo[i] = greenValue(fileInfo[i], max, min);
		}
		drawColors(colorInfo);
	}

	/*
	 * Calculates a normalized value for the shade of green with a range 0f 100-250
	 */
	public int greenValue (int val, int max, int min) {
		double range = max-min;
		double percent = val/range;
		double color = percent * 150 + 100;
		int value = (int)color;
		return value;
	}

	/*
	 * displays colors on screen in order from the given normalized color value array
	 */
	public void drawColors (int colorData []) {
		JFrame frame = new JFrame();
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		FlowLayout layout = new FlowLayout();
		JPanel colors = new JPanel();
		colors.setLayout(layout);
		layout.setAlignment(FlowLayout.LEADING);

		for (int i=0; i < colorData.length; i++) {
			int numValue = colorData[i];
			String strValue = numValue + "";
			JPanel shade = new JPanel();
			shade.add(new JLabel("ShadeValue: " + strValue));
			shade.setBackground(new Color(0, numValue, 0));
			shade.setVisible(true);
			colors.add(shade);
		}
		frame.add(colors);
		frame.setVisible(true);
		System.out.println("The adjusted shade values are: " + Arrays.toString(colorData));
	}
	
	/*
	 * main method only runs the program so that this class is expandable
	 */
	public static void main(String[] args) {
		GreenShades shades = new GreenShades();
	}
}

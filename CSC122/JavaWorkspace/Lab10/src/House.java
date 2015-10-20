import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * File:	House.java
 * Author:	Brady Coye
 * Description:	takes the houses.txt file as input and calculates several area 
 * measurements for the development
 * 3/17/15
 */

public class House {
	private int area;
	/*
	 * Constructor for House that takes the initial square footage
	 */
	public House (int sqFoot) {
		area = sqFoot;
	}
	public int getArea () {	
		return area;
	}
	/*
	 * Calculates the total square footage of the development 
	 */
	public static int totalArea (int [][] houseData) {
		int totalArea = 0;
		for(int i=0; i< 5; i++){
			for (int j=0; j < 10; j++) {
				totalArea += houseData[i][j];
			}
		}
		return totalArea;
	}
	/*
	 * Calculates the average area for a house in the development
	 */
	public static double averageArea (int [][] houseData) {
		int totalArea = 0;
		int totalHouses = 0;
		double averageArea = 0;
		for(int i=0; i< 5; i++){
			for (int j=0; j < 10; j++) {
				if (houseData[i][j] != 0){
					totalHouses++;
				}
				totalArea += houseData[i][j];
			}
		}
		averageArea = totalArea/totalHouses;
		return averageArea;
	}
	/*
	 * Calculates the area of houses with the given column/house number
	 */
	public static int specialArea (int [][] houseData, int column) {
		int specialArea = 0;
		for(int i=0; i< 5; i++){
			specialArea += houseData[i][column];
		}
		return specialArea;
	}


	/*
	 * Creates 2D array for the houses.txt data then uses each area method to calculate info.
	 * Gives the total area, average area of a house, the total area of houses 
	 * with the specified house number, and a grid of the development to the output.txt file
	 */
	public static void main() {
		// opens file and sorts data into 2D array
		int[][] houseInfo;
		Scanner fileIn = null;
		try {
			fileIn = new Scanner(new File("houses.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File: " + "houses.txt" + " is not found");
			System.exit(0);
		}		
		int sqFoot;
		int row;
		int column;
		String info = fileIn.nextLine();
		houseInfo = new int[5][10];
		while( fileIn.hasNext() )  {
			sqFoot = fileIn.nextInt();
			row = fileIn.nextInt();
			column = fileIn.nextInt();
			houseInfo[row][column] = sqFoot;
		}
		fileIn.close();
		// uses the 2D array to calculate area measurements
		int totalArea = totalArea(houseInfo);
		double averageArea = averageArea(houseInfo);
		int specialArea = specialArea(houseInfo, 3); 
		String grid = ""; 
		for(int i=0; i< 5; i++){
			for (int j=0; j < 10; j++) {
				if (houseInfo[i][j] == 0){
					grid += "-";
				}
				else {
					grid += "X";
				}
			}
			grid += "\n";
		}
		// outputs the area measurements to a text file (output.txt)
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("output.txt", "UTF-8");
		} catch (FileNotFoundException e) {
			System.out.println("File: " + "output.txt" + " is not found");
			System.exit(0);
		} catch (UnsupportedEncodingException e) {
			System.out.println("This encoding type is not supported.");
			System.exit(0);
		}
		writer.println("The total square footage of the development is: " + totalArea );
		writer.println("The average square footage of the development is: " + averageArea);
		writer.println("The square footage of the all the houses with house number 3 is: " + specialArea);
		writer.println("The grid layout for the development is: ");
		writer.println(grid);
		writer.close();

	}
}










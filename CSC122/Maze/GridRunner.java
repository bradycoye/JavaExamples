package myADT;

import java.io.*;
import java.util.Scanner;
/**
 * GridRunner is a utility class that maintains a grid of coordinates
 * Also maintains the choices of coordinates and
 * can be implemented using a Stack or a Queue of coordinates.
 * B.Catron Spring 2015
**/

public class GridRunner {
	private final int GRID_SIZE;
	private Coordinate currentLocation;
	private Coordinate startLocation;
	private Coordinate endLocation;

	private GridChar [][] grid;//private grid of walls,etc
	
	//Basic enumeration of directions
	public enum Direction { North, East, South, West };
	
	// More elaborate enumeration and initialization of values
	//more like a class definition
	public enum GridChar {
		START('S'), END('E'), WALL('X'), VISITED('V'), AVAILABLE('.');
		
		private char b;
		GridChar (char ch)
		{
			b = ch;
		}
		public char value ()
		{
			return b;
		}
	};
	
	
	/**
	 * Reads from string given and creates the 2D maze
	 * Characters: S,E,W,V or blank  stand for Start position, End position, Wall,Visited and available spot
	 * @throws FileNotFoundException 
	 * @throws Exception 
	 */
	public GridRunner (String f) 
	{
		//TODO: instantiate the data structure (stack or queue) here

		
		//read from file and initialize grid
		GRID_SIZE = 10;
		
		grid = new GridChar[GRID_SIZE][GRID_SIZE];

		//Create a scanner associated with the text file named in f
		Scanner s = new Scanner(new BufferedReader(new FileReader(f)));
		
		//process the text file one row at a time
		for (int row = 0; row < GRID_SIZE; row++)
		{
			//for each column of this row
			for (int col = 0; col < GRID_SIZE; col++)
			{
				char ch = s.next().charAt(0);
				
				//process each grid location
				if (ch == GridChar.START.value())
				{
					startLocation = new Coordinate(col,row);
					currentLocation = startLocation;     //Start here
					grid[col][row] = GridChar.START;	 
				} 
				else if (ch == GridChar.END.value())
				{
					endLocation = new Coordinate(col,row);
					grid[col][row] = GridChar.AVAILABLE; //can be moved onto!	
				} 
				else if (ch == GridChar.WALL.value())
				{
					grid[col][row] = GridChar.WALL;	
				}
				else
				{
					grid[col][row] = GridChar.AVAILABLE;	
				}
					
			}
				
		}
		s.close( );
		
		
		if (startLocation == null || endLocation == null)
			throw new Exception ("Bad grid");
	}

	/**
	 * In the grid, mark the coordinate position "Visited"
	 * @param c
	 */
	public void markAsVisited (Coordinate c)
	{
		//TODO: Implement this
	}
	
	/**
	 * In the grid, evaluates the ability to move to a coordinate
	 * @param c - the coordinate to consider
	 * @return true if it is available to be moved to
	 */
	public boolean canMoveTo (Coordinate c)
	{
		//TODO: Implement this
	}
	
	/**
	 * Make the current location this coordinate
	 * @param c
	 */
	public void moveTo (Coordinate c)
	{
		//TODO: Implement this
	}
	
	/**
	 * getCurrent position in maze
	 * @return current coordinate
	 */
	public Coordinate getCurrent( )
	{
		return currentLocation;
	}
	
	/**
	 * getStart position of maze
	 * @return Starting coordinate
	 */
	public Coordinate getStart( )
	{
		//TODO: Implement this
	}
	/**
	 * getEnd position of maze
	 * @return ending coordinate
	 */
	public Coordinate getEnd( )
	{
		//TODO: Implement this
	}
	
	/**
	 * Are there more saved choices to consider
	 * Using stack or queue - although users don't need to know which
	 * @return true if there are
	 */
	public boolean hasMoreChoices()
	{
		//TODO: Implement this
	}
	
	/**
	 * Save this coordinate for future consideration
	 * Using stack or queue - although users don't need to know which
	 * @param c - the coordinate to remember
	 */
	public void addChoice (Coordinate c) 
	{
		//TODO: Implement this
	}
	
	/**
	 * get next saved choice to consider
	 * Using stack or queue - although users don't need to know which
	 * @return
	 */
	public Coordinate getChoice () 
	{
		//TODO: Implement this
	}
	
	/**
	 * General description of grid
	 */
	public String toString ()
	{
		String s = "Grid:\n";
		for (int row=0; row<GRID_SIZE; row++)
		{
			for (int col=0; col<GRID_SIZE; col++) {
				s = s + grid[col][row].value()+ grid[col][row].value();
			}
			s += "\n";
		}
		return s;
	}

}

package myADT;
/**
 * Maze running algorithm.  Relies on GridRunner class to organize the search
 * options and maintain the current location of the "player"
 * Exceptions have not been added
 * B.Catron  Spring 2015
**/

import java.io.FileNotFoundException;

public class AMaze {
	static GridRunner gr;	//grid utility class
	
	//check all four directions from c and add to future choice list
	private static void addOptionsFrom (Coordinate c) 
	{
		//for each direction, add if it is a legal choice
		for (GridRunner.Direction d: GridRunner.Direction.values())
		{
			switch (d){
			case North: 
				Coordinate north = new Coordinate(c.x,c.y-1);
				if (gr.canMoveTo(north))
					gr.addChoice(north);
				break;
			case South: 
				Coordinate south = new Coordinate(c.x,c.y+1);
				if (gr.canMoveTo(south))
					gr.addChoice(south);
				break;
			case East: 
				Coordinate east = new Coordinate(c.x+1,c.y);
				if (gr.canMoveTo(east))
					gr.addChoice(east);
				break;
			case West: 
				Coordinate west = new Coordinate(c.x-1,c.y);
				if (gr.canMoveTo(west))
					gr.addChoice(west);
				break;		
			}
		}
	}

	/**
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) {
		//read initial graph from text file
		gr = new GridRunner("noPathGrid.txt");

		System.out.println (gr);		

		Coordinate donePos = gr.getEnd(); //save target grid location
		addOptionsFrom (gr.getStart());   //load initial choices


		//while choices exist and not at end
		while (gr.hasMoreChoices() && !(gr.getCurrent().equals(donePos)))
		{
			//get next choice & evaluate moves from there
			Coordinate next = gr.getChoice();
			gr.moveTo(next);
			gr.markAsVisited(next);	//been there...
			addOptionsFrom (next);  //where to move from here
		}

		//Alert user with results
		if (gr.hasMoreChoices()){
			System.out.println("Solved the maze");
		}
		else {
			System.out.println ("No solution to the maze");
		}

	}

}

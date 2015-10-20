import java.util.Scanner;

/**
 * File:	AMaze.java
 * Author:	Brady Coye, Bryan Catron
 * Description:	Displays graphical components of the grid. Relies on GridRunner class to organize 
 * the search options and maintain the current location of the "player"
 * 3/20/15
 */
public class GMaze {
	//static GridRunner gr;	//grid utility class
	static GraphicalGridRunner gr;

	//check all four directions from c and add to future choice list
	private static void addOptionsFrom (Coordinate c) 
	{
		//for each direction, add if it is a legal choice
		for (GridRunner.Direction d: GridRunner.Direction.values())
		{
			switch (d) {
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

	public static void main(String[] args) throws Exception {
		//read initial graph from text file
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the file name: ");
		String file = in.nextLine();
		gr = new GraphicalGridRunner(file);
	

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
			Thread.sleep(250);
		}

		//Alert user with results
		if (gr.hasMoreChoices()){
			System.out.println("Solved the maze");
			gr.showFinished(true);
		}
		else {
			System.out.println ("No solution to the maze");
			gr.showFinished(false);
		}

	}

}

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * File:	GraphicalGridRunner.java
 * Author:	Brady Coye
 * Description: creates a graphical representation of GridRunner
 * 3/20/15
 */

public class GraphicalGridRunner extends GridRunner  {
	private JPanel[ ][ ] ggrid;
	private JFrame window = new JFrame("Graphical Grid Runner");
	private final Color Wall = Color.BLACK;
	private final Color Normal = Color.WHITE;
	private final Color Start = Color.GREEN;
	private final Color End = Color.RED;
	private final Color Visited = Color.YELLOW;
	private final Color Current = Color.BLUE;

	private final int SIZE = 20;
	private final Dimension cellSize = new Dimension(SIZE, SIZE);
	private final Dimension fullsize = new Dimension(13*SIZE, 14*SIZE);

	public GraphicalGridRunner (String fname) throws Exception {
		super(fname);

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setPreferredSize(fullsize);
		window.setResizable(false);
		JPanel primary = new JPanel();
		ggrid = new JPanel[10][10];


		//build JPanel graphical duplicate
		for(int i=0; i < 10; i++){
			for (int j=0; j < 10; j++) {
				ggrid[i][j] = new JPanel();
				ggrid[i][j].setPreferredSize(cellSize);
				ggrid[i][j].setVisible(true);
				Coordinate c = new Coordinate (i,j);
				colorBlock(c);
				primary.add(ggrid[i][j]);
			}
		}
		colorBlock(startLocation);
		window.getContentPane().add(primary);
		window.pack();
		window.setVisible(true);

	}

	public void moveTo (Coordinate c) throws Exception {
		Coordinate old = currentLocation;
		super.moveTo(c);
		colorBlock(old);
		colorBlock(c);
	}

	private void colorBlock (Coordinate c) {
		switch (grid[c.x][c.y]) {

		case WALL:  ggrid[c.x][c.y].setBackground(Wall);
		break;

		case AVAILABLE: ggrid[c.x][c.y].setBackground(Normal);
		break;

		case START: ggrid[c.x][c.y].setBackground(Start);
		break;

		case END: ggrid[c.x][c.y].setBackground(End);
		break;

		case VISITED: ggrid[c.x][c.y].setBackground(Visited);
		break;
		}

		if (c == currentLocation){
			ggrid[c.x][c.y].setBackground(Current);
		}
	}

	/*
	 * Displays 4 green dots if maze was solved and 4 red dots if it was not
	 */
	public void showFinished (Boolean f) {
		if (f == true) {
			ggrid[4][5].setBackground(Color.GREEN);
			ggrid[4][6].setBackground(Color.GREEN);
			ggrid[5][5].setBackground(Color.GREEN);
			ggrid[5][6].setBackground(Color.GREEN);

		}
		else {
			ggrid[4][5].setBackground(Color.RED);
			ggrid[4][6].setBackground(Color.RED);
			ggrid[5][5].setBackground(Color.RED);
			ggrid[5][6].setBackground(Color.RED);
		}
	}
}

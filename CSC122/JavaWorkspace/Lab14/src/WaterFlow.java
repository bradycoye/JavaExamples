import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * File: WaterFlow.java Author: Brady Coye Description: Takes an elevation grid
 * from a text file and normalizes each value to a shade of green. User enters a
 * start position for the water represented by blue, then program shows
 * animation for where water can flow. 4/14/2015
 */

public class WaterFlow implements MouseListener{
	private double [][] elevation;
	private int [][] colorInfo;
	private boolean [][] visited;
	private int row, column;
	private Queue<Coordinate> queue;
	private Coordinate currentPos;
	private JPanel[][] elePanel;
	private JFrame wholeFrame;
	private static final int COLOR_RANGE = 150;
	private static final int COLOR_MIN = 100;
	private static final int PANEL_SIZE = 1000;

	/*
	 * opens file, sorts data into array, and creates separate array for color
	 * values
	 */
	public WaterFlow(File data) {
		Scanner fileIn = null;
		try {
			fileIn = new Scanner(data);
		} catch (FileNotFoundException e) {
			System.out.println("File: " + " is not found");
			System.exit(0);
		}
		row = fileIn.nextInt();
		column = fileIn.nextInt();
		elevation = new double[row][column];
		visited = new boolean[row][column];
		while (fileIn.hasNext()) {
			double eValue = fileIn.nextDouble();
			int yPos = fileIn.nextInt();
			int xPos = fileIn.nextInt();
			elevation[yPos][xPos] = eValue;	
		}
		fileIn.close();
		this.addDetail();


		// finds the max and min value in the elevation array so values can be
		// normalized into shades of green
		double max = elevation[0][0];
		double min = elevation[0][0];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (elevation[i][j] > max) {
					max = elevation[i][j];
				}
				if (elevation[i][j] < min) {
					min = elevation[i][j];
				}
			}
		}

		// makes new array with normalized values (shades of green) and sets visited to false
		colorInfo = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				visited[i][j] = false;
				colorInfo[i][j] = greenValue(elevation[i][j], max, min);
			}
		}
		this.drawGrid();

	}

	/*
	 * takes the value to be adjusted, the max, and the min as parameters then
	 * returns the normalized value within the range 100-250
	 */
	public int greenValue(double val, double max, double min) {
		if (max - min == 0) {
			return COLOR_MIN;
		}
		double elevationRange = max - min;
		double adjusted = (val - min) / elevationRange;
		double color = adjusted * COLOR_RANGE + COLOR_MIN;
		int value = (int) color; // changes double to int so java.Color will
		// accept
		return value;
	}

	/*
	 * checks each coordinate one away on all sides, adds to queue if the move
	 * is possible
	 */
	private void addOptionsFrom(Coordinate c) {
		Coordinate n = new Coordinate(c.x, c.y - 1);
		Coordinate s = new Coordinate(c.x, c.y + 1);
		Coordinate e = new Coordinate(c.x + 1, c.y);
		Coordinate w = new Coordinate(c.x - 1, c.y);

		if (canMoveTo(n)) {
			queue.enqueue(n);
			visited[n.y][n.x] = true;
		}
		if (canMoveTo(s)) {
			queue.enqueue(s);
			visited[s.y][s.x] = true;
		}
		if (canMoveTo(e)) {
			queue.enqueue(e);
			visited[e.y][e.x] = true;
		}
		if (canMoveTo(w)) {
			queue.enqueue(w);
			visited[w.y][w.x] = true;
		}
	}


	/*
	 * returns if the water at the given coordinate can travel to the edge by a
	 * lower elevation path
	 */
	public void canFlowOffMap() {
		queue.enqueue(currentPos);
		visited[currentPos.y][currentPos.x] = true;

		if (onEdge(currentPos)) {
			System.out.println("Yeah! The water flows off the map!");
		}

		while (hasMoreChoices() && !(onEdge(currentPos))) {
			currentPos = queue.dequeue();
			//System.out.println(queue.count());
		
			updateColor(currentPos);
			/*
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			 */
			addOptionsFrom(currentPos);
		}

		if (onEdge(currentPos)) {
			System.out.println("Yeah! The water flows off the map!");
		} else {
			System.out.println("Bummer... The water could not flow off the map.");
		}
	}

	/*
	 * checks if the given coordinate is on the edge
	 */
	public boolean onEdge(Coordinate c) {
		if (c.x == 0 || c.y == 0 || (c.x == row - 1) || (c.y == column - 1)) {
			return true;
		}
		return false;
	}

	/*
	 * checks if there are more choices/more direction choices from the queue
	 */
	public boolean hasMoreChoices() {
		return (queue.count() > 0);
	}

	/*
	 * checks if the water can move to the given coordinate by elevation
	 */
	public boolean canMoveTo(Coordinate c) {
		if (c.x < 0 || c.y < 0) {
			return false;
		}
		if (c.x > column - 1 || c.y > row - 1) {
			return false;
		}
		if (visited[c.y][c.x]) {
			return false;
		}
		if (elevation[currentPos.y][currentPos.x] > elevation[c.y][c.x]) {
			return true;
		} 
		return false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Component c = e.getComponent();
		int rowPlace = c.getAccessibleContext().getAccessibleIndexInParent()/row;
		int columnPlace = c.getAccessibleContext().getAccessibleIndexInParent()%column;
		System.out.println(rowPlace);
		System.out.println(columnPlace);
		visited[rowPlace][columnPlace] = true;
		currentPos = new Coordinate(columnPlace, rowPlace);
		queue = new Queue<Coordinate>();
		canFlowOffMap();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Component c = e.getComponent();
		int rowPlace = c.getAccessibleContext().getAccessibleIndexInParent()/row;
		int columnPlace = c.getAccessibleContext().getAccessibleIndexInParent()%column;
		double currentEle = elevation[rowPlace][columnPlace]; 
		System.out.println(currentEle);
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	public boolean canAverage(Coordinate c) {
		if (c.x < 0 || c.y < 0) {
			return false;
		}
		if (c.x > column - 1 || c.y > row - 1) {
			return false;
		}
		if (elevation[c.y][c.x] == 0){
			return false;
		}
		else {
			return true;
		}
	}

	public void addDetail () {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++)
				if (elevation[i][j] == 0 ) {
					int count = 0;
					double total = 0;
					Coordinate north = new Coordinate (j,i-1);
					Coordinate south = new Coordinate (j,i+1);
					Coordinate east = new Coordinate (j+1,i);
					Coordinate west = new Coordinate (j-1,i);

					if (canAverage(north)) {
						total += elevation[north.y][north.x];
						count++;
					}
					if (canAverage(south)) {
						total += elevation[south.y][south.x];
						count++;
					}
					if (canAverage(east)) {
						total += elevation[east.y][east.x];
						count++;
					}
					if (canAverage(west)) {
						total += elevation[west.y][west.x];
						count++;
					}
					if (total != 0) {
						double average = total/count;
						elevation[i][j] = average;
					}
				}
		}
	}

	/*
	 * makes visual representation of grid and water animation
	 */
	public void drawGrid() {
		wholeFrame = new JFrame();
		wholeFrame.setSize(PANEL_SIZE, PANEL_SIZE);
		wholeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout layout = new GridLayout(row, column);
		JPanel colors = new JPanel();
		colors.setLayout(layout);
		colors.setSize(PANEL_SIZE, PANEL_SIZE);

		elePanel = new JPanel[row][column];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				int colorValue = colorInfo[i][j];
				elePanel[i][j] = new JPanel();
				//int eleValue = (int) elevation[i][j];
				//String value = eleValue + ""; // uncomment for elevation
				//JLabel eleLabel = new JLabel(value);
				//elePanel[i][j].add(eleLabel);
				//eleLabel.setVisible(false);
				elePanel[i][j].addMouseListener(this);
				elePanel[i][j].setBackground(new Color(0, colorValue, 0));
				elePanel[i][j].setSize(PANEL_SIZE / row, PANEL_SIZE / column);
				elePanel[i][j].setVisible(true);
				colors.add(elePanel[i][j]);
			}
		}
		wholeFrame.add(colors);
		wholeFrame.setVisible(true);
	}

	/*
	 * sets a given position blue to represent water
	 */
	public void updateColor(Coordinate c) {
		elePanel[c.y][c.x].setBackground(Color.BLUE);
	}

	/*
	 * main method only runs the program so that this class is expandable
	 */
	public static void main(String[] args)  {
		System.out.println("Enter the file name: ");
		Scanner startInput = new Scanner(System.in);
		String fname = startInput.nextLine();
		//String fname = "elevations.txt";
		File data = new File(fname);
		WaterFlow n = new WaterFlow(data);
		System.out.println("Click the starting position of the water");


	}

}

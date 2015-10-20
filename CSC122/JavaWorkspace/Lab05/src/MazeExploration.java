import javax.swing.JApplet;

/**
 * File:	MazeExploration.java
 * Author:	Brady Coye
 * Description:	Java class that solves maze using API
 * Last Modified:	2/9/15
 */

public class MazeExploration {
	private int startPos, endPos, currentPos;
	
	public MazeExploration (String input) {
		GridRunner gridRunner = new GridRunner(input);
		startPos = gridRunner.getStart();
		endPos = gridRunner.getEnd();
		currentPos = gridRunner.getCurrent();
		while (currentPos != endPos) {
			
			if (gridRunner.canMoveto(gridRunner.Direction North) {
				gridRunner.addChoice(gridRunner.Direction North);	
			}
			if (gridRunner.canMoveto(gridRunner.Direction South) {
				gridRunner.addChoice(gridRunner.Direction South);
			}
			if (gridRunner.canMoveto(gridRunner.Direction East) {
				gridRunner.addChoice(gridRunner.Direction East);
			}
			if (gridRunner.canMoveto(gridRunner.Direction West) {
				gridRunner.addChoice(gridRunner.Direction West);
			}
	
			if (gridRunner.hasMoreChoices == true) {
				gridRunner.moveTo(gridRunner.getChoice());
				gridRunner.markAsVisited(gridRunner.getCurrent());
			}
			if (gridRunner.getCurrent() == endPos) {
				System.out.print("Solved.");
			}
			startPos = gridRunner.getStart();
			endPos = gridRunner.getEnd();
			currentPos = gridRunner.getCurrent();
			
		}
	}
}
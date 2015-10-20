import java.awt.*;
import javax.swing.*;

/**
 * File:	GraphicPlay.java
 * Author:	Brady Coye
 * Description:	graphic play
 * Last Modified:	2/4/15
 */

public class GraphicPlay {
	private JFrame window = new JFrame("Your name here");
	private static final int WINDOW_WIDTH = 300;
	private static final int WINDOW_HEIGHT = 150;
	
	
	public GraphicPlay () 
	{
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mPanel = new JPanel();
		mPanel.setBackground (Color.yellow);
		
		JLabel label1 = new JLabel("Question Authority!");
		JLabel label2 = new JLabel("or not");
		
		mPanel.add(label1);
		mPanel.add(label2);
		
		window.getContentPane().add(mPanel);
		window.setVisible(true);
		
		for (int i=0; i<50; i++)
		{
			JPanel t = new JPanel();
			JLabel label = new JLabel("L"+i);
			t.add(label);
			mPanel.add(t);
		}
	}
	
	public static void main(String[] args) {
		GraphicPlay g = new GraphicPlay();
	}
	
	
}
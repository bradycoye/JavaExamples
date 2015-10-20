import java.awt.*;

import javax.swing.*;

/**
 * File:	RandomCircle.java
 * Author:	Brady Coye
 * Description:	graphic play
 * Last Modified:	2/4/15
 */

public class RandomCircle extends JApplet {
	public int radius, circleX, circleY;
	public double area;
	
	public RandomCircle () 
	{
		radius = (int)(Math.random() * 45) +5;
		area = radius * radius * Math.PI;
		System.out.print(radius);
	}
	
	public void paint (Graphics page) 
	{
		super.paint(page);
		int sizeX = getSize().height/2;
		int sizeY = getSize().width/2;
		
		circleX = (sizeX - radius);
		circleY = (sizeY - radius);
		
		page.drawString("The area of the circle is: " + area, circleX - 130, circleY + 70);
		page.setColor(Color.blue);
		page.drawOval(circleX, circleY, radius*2, radius*2);
	}
	
}
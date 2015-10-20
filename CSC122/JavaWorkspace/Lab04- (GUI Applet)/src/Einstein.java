import javax.swing.*;
import java.awt.*;

/**
 * File:	Einstein.java
 * Author:	Brady Coye
 * Description:	Java Applet that paints several shapes
 * Last Modified:	2/4/15
 */

@SuppressWarnings("serial")
public class Einstein extends JApplet {
	/** 
	 * paint a variety of shapes
	 */
	public void paint (Graphics page)
	{
		page.setColor(Color.cyan);
		page.drawOval(250, 250, 300, 300);
		
		page.setColor(Color.yellow);
		page.drawRect(300, 370, 40, 40); 
		
		page.setColor(Color.green);
		page.drawOval(350, 365, 100, 60);
		
	
		page.drawLine(350, 435, 440, 435);
		
		page.drawString("Out of Clutter, find simplicity", 310, 300);
		page.drawString("Brady Coye", 360, 400);
		
		
		
		
		
	}
}


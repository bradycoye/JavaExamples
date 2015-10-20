import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class StringDemo{
	public static void main(String[] args) {
		int count = 64;
		final int max = 200000;
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("timing.csv");
		} catch (FileNotFoundException e) {
			System.out.println("File: " + "output.txt" + " is not found");
			System.exit(0);
		}
		while (count < max)   //perform timing for many string sizes
		{
			long startTime = System.nanoTime();
			String s = "";
			for (int i=0; i < count; i++)
			{
				s = s + "-";
			}

			writer.print(count +","+(System.nanoTime( )-startTime));

			//(2)  add code here as directed
			startTime = System.nanoTime();
			StringBuilder sb = new StringBuilder();
			
			for (int i=0; i < count; i++)
			{
				sb.append("-");
			}
			writer.print (", " + (System.nanoTime( )-startTime));
			count = count * 2;        //repeat with larger loop count
			writer.println ( );   //end line with newline char

		}
		writer.close();
	}
}

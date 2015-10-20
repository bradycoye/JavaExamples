
import java.io.FileReader;
import java.util.Scanner;

/**
 * File:	WordList.java
 * Author:	Brady Coye
 * Description:	finds all the words of the given length 
 * in the dictionary text file 
 * 3/4/15
 */
public class WordList {
	private final int defaultSize = 50;    
	private String[] origArray;
	private int count = 0;

	public WordList () {
		origArray = new String[defaultSize];
	}

	public int count(){
		return count;
	}

	/*
	 * adds a new word to the list
	 */
	public void add (String s){
		if (count == origArray.length) {
			String[] result = new String[origArray.length + 50];
			for (int i = 0; i < origArray.length; i++) {
				result[i] = origArray[i];
			}
			origArray = result;
		}
		origArray[count] = s;
		count++;
	}

	/*
	 * returns the word at the position specified
	 */
	public String getWordAtPosition (int i) throws Exception {
		if (count < i || i < 0){
			throw new IllegalArgumentException();
		}
		return origArray[i];
	}

	/*
	 * returns the place of the word in the list that matches the given word
	 */
	public int indexOf (String s) {
		for(int i=0; i < count; i++){
			if(s.equals(origArray[i])) {
				return i;
			}
		}
		return -1;

	}

	/*
	 * prints the list of words that have the number of letters specified
	 */
	public String toString () {
		String output = new String();
		int total=0;
		for(int i=0; i < 5; i++) {
			if (total < count){
				for(int j=0; j < 10; j++){
					if (i*10 + j < count){
						output += origArray[j] + " ";
						total++;
					}
					else {
						System.out.print(output);
						return output;
					}
				}
				output += "\n";
			}
		}
		System.out.print(output);
		return output;
	}
	/*
	 * prints the number of words from the dictionary.txt file that have the specified number of letters
	 */
	public void main(int wordLength) throws Exception {
		Scanner s = new Scanner(new FileReader("dictionary.txt"));
		while ( s.hasNext() )
		{
			if(s.next().length() == wordLength) {
				add(s.next());
			}
		}
		s.close();
		System.out.print(count());
	}
}
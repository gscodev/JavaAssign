package lab8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


//This is a simple function to count the words in a file.
public class wordCount {
	public String countWord(String filename) throws IOException {

	int count =0;
    File file = new File(filename);
    try (FileInputStream fis = new FileInputStream(filename)) {
    	
    	//get the file length in int and save in byte
		byte[] bytesArray = new byte[(int)file.length()];
		fis.read(bytesArray);
		//split at all the spaces and then counts each of the words
		String s = new String(bytesArray);
		String [] data = s.split(" ");
		for (int i=0; i<data.length; i++) {
		   count++;
		}
    }
    //returns String because i pass in a String.
    String str1 = Integer.toString(count);
    return str1;
	}
}


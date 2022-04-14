package lab8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class wordCount {
	public String countWord(String filename) throws IOException {

	int count =0;
    File file = new File(filename);
    try (FileInputStream fis = new FileInputStream(filename)) {
		byte[] bytesArray = new byte[(int)file.length()];
		fis.read(bytesArray);
		String s = new String(bytesArray);
		String [] data = s.split(" ");
		for (int i=0; i<data.length; i++) {
		   count++;
		}
    }
    String str1 = Integer.toString(count);
    return str1;
	}
}

//Geon Suresh C20390771 Search Engine Java

package lab8;

//Packages that are going to be used	
import java.util.*;
import java.io.*;

//Class File to get the files that are going to be used in this project..
//We check if the files can be opened or return a false
public class Files {
	
	//This is the number that will help the JVM to identify the state of an object when it reads the state of the object from a file.
	public static final long serialVersionUID = 1L;
	
	//Get all the File and put them into variables to sent through Scanner.
	public File FileNum1 = new File("C:\\Users\\boluc\\eclipse-workspace\\lab9\\src\\lab8\\Files\\file1.txt");
	public File FileNum2 = new File("C:\\Users\\boluc\\eclipse-workspace\\lab9\\src\\lab8\\Files\\file2.txt");
	public File FileNum3 = new File("C:\\Users\\boluc\\eclipse-workspace\\lab9\\src\\lab8\\Files\\file3.txt");
	public File FileNum4 = new File("C:\\Users\\boluc\\eclipse-workspace\\lab9\\src\\lab8\\Files\\file4.txt");
	
	
	public Scanner Scanner1, Scanner2, Scanner3 ,Scanner4;
	public String line1, line2, line3, line4;
	
	//Check if the file is being opened else return return error to be fixed.
	public void FileCheck() {
		try
		{	
			//creates a new Scanner instance which points to the input stream passed as argument.
			//The useDelimiter() is a Java Scanner class method which is used to set the delimiting pattern of the Scanner which is in using.
			Scanner1 = new Scanner(FileNum1);
			Scanner1.useDelimiter(",");
			
			Scanner2 = new Scanner(FileNum2);
			Scanner2.useDelimiter(",");
			
			Scanner3 = new Scanner(FileNum3);
			Scanner3.useDelimiter(",");
			
			Scanner4 = new Scanner(FileNum4);
			Scanner4.useDelimiter(",");

		}
		catch(FileNotFoundException event)
		{
			System.out.println("File can't be found in the directory presented. Please provide a valid entry");
		}
	
	}
		
	public Files() {
		
		FileCheck();
	
		
		}

}

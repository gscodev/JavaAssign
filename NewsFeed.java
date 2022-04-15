package lab8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.stream.Stream;

//It reads the file that is passed in and then splits at the comma
public class NewsFeed {
	 public String title(String File) throws IOException {
		String title = null;
		FileReader file = new FileReader(File);
		BufferedReader buffer = new BufferedReader(file);
	    String line = buffer.readLine();
	    String[] res = line.split("[,]");
	    
	    System.out.println((1));
	    
	    //The loop then gets the first value of the line and returns it which will be the info of the news
	    for(String myStr: res) {
	           title = myStr;
	           return title;
	        }
		return title;

	       
	       
	    
	      //display the 1st line
	
	 }
	 //This is the same as the class above but gets the news link of the topic and returns it to open up website.
	 public String url(String File) throws IOException {
		String title = null;
		FileReader file = new FileReader(File);
		BufferedReader buffer = new BufferedReader(file);
	    String line = buffer.readLine();
	    String[] res = line.split("[,]");
	    int i = 0;
	    
	    
	    //It will go through first line first word but it wont return that due to the fact i==0 so when it runs the second time
	    //It will get the link and pass it through
	    for(String myStr: res) {
	    	if(i==0) {
	           title = myStr;
	           i++;
	    	}
	    	else {
	    		title = myStr;
	    		return title;
	    		
	    	}
	        }
		return title;

	       
	       
	    
	      //display the 1st line
	
	 }
}

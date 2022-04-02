package search_engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class SearchEngine {

    Scanner input;

    // Creating hashmap to store the words from file
    HashMap<String, Integer> oneFileWords;

    // Creating arrayList of hash maps, each hash map has words from one file
    ArrayList<HashMap<String, Integer>> allFileWords = new ArrayList<>();

    //Creating a File object for directory
    File directoryPath = new File("files/");
    //List of all files and directories
    File[] filesList = directoryPath.listFiles();

    // Function to read all the files
    public void readFile() throws FileNotFoundException {
        int wordKey = 0;

        // Read content file by file
        for (File file : filesList) {
            // Scanner to read file
            input = new Scanner(file);
            // create new hash map for each file
            oneFileWords = new HashMap<>();
            // while the file has words, continue to read
            while (input.hasNext()) {
                // read word by word from file, convert it into lower case and then save in the hash map
                oneFileWords.put(input.next().toLowerCase(Locale.ROOT), ++wordKey);
            }
            // at the end, add hash map to the arraylist
            allFileWords.add(oneFileWords);
        }
    }

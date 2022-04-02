package search_engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;

public class SearchEngineGUI implements ActionListener {

    // creating instance of search engine class to use it's functions
    SearchEngine searchEngine = new SearchEngine();

    // Font which will be used in most components
    Font textFont = new Font("Adelle Sans Devanagari", Font.PLAIN, 16);

    private JFrame mainFrame = new JFrame("Search Engine");

    private JTextField inputSearch = new JTextField();

    private JButton searchButton = new JButton("Search");

    private JTextArea searchResult = new JTextArea();

    // Default Constructor
    SearchEngineGUI() throws FileNotFoundException {
        mainFrame.setSize(500, 400);
        mainFrame.setVisible(true);
        mainFrame.setLayout(null);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setBackground(Color.WHITE);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        inputSearch.setBounds(85, 50, 200, 30);
        inputSearch.setFont(textFont);
        inputSearch.setVisible(true);

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


        searchButton.setBounds(315, 50, 100, 30);
        searchButton.setFont(textFont);
        searchButton.setBackground(new Color(173, 37, 51));
        searchButton.setForeground(Color.white);
        searchButton.setOpaque(true);
        searchButton.setBorderPainted(false);
        searchButton.setVisible(true);

        searchButton.addActionListener(this);

        searchResult.setBounds(85, 150, 330, 200);
        searchResult.setFont(new Font("Adelle Sans Devanagari", Font.PLAIN, 14));
        searchResult.setForeground(new Color(173, 37, 51));
        searchResult.setVisible(true);

        mainFrame.add(inputSearch);
        mainFrame.add(searchButton);
        mainFrame.add(searchResult);

        searchEngine.readFile();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new SearchEngineGUI();
    }

    // Action performed when button is pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            String inputKeyword = inputSearch.getText().toLowerCase(Locale.ROOT);
            searchResult.setText("");
            try {
                int i = 0;
                String writeToTextArea = "Keyword is present in following files:-\n";
                ArrayList<String> foundSearchKeywords = searchEngine.searchKeyword(inputKeyword);
                for (String foundSearchKeyword : foundSearchKeywords) {
                    writeToTextArea += (++i) + ".\t" + foundSearchKeyword + "\n";
                }
                searchResult.setText(writeToTextArea);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

        }
    }
}


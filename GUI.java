package lab8;

//All the imports that are used in the GUI file
 import javax.swing.*;
 
 import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 
 import java.io.IOException;
 
 import java.text.DecimalFormat;
 import java.text.SimpleDateFormat;
 
 import java.util.*;
 import java.util.List;
 
 import java.awt.desktop.*;
 
 import java.net.URI;
 import java.net.URISyntaxException;



//Main class GUI
 @SuppressWarnings("unused")
public class GUI extends JFrame implements ActionListener{

	 /*It is a universal version identifier for the Serializable class. The number is used to ensure that a loaded class corresponds
	 exactly to a serialized object*/
     public static final long serialVersionUID = 1L;

     //Store the location of all the files into the String names that are associated with.
     String file1 = "C:\\Users\\boluc\\eclipse-workspace\\lab9\\src\\lab8\\Files\\file1.txt";
     String file2 = "C:\\Users\\boluc\\eclipse-workspace\\lab9\\src\\lab8\\Files\\file2.txt";
     String file3 = "C:\\Users\\boluc\\eclipse-workspace\\lab9\\src\\lab8\\Files\\file3.txt";
     String file4 = "C:\\Users\\boluc\\eclipse-workspace\\lab9\\src\\lab8\\Files\\file4.txt";

     //These are the files that are used for spell checker and one to get links for stories
     String dictionaryWords = "C:\\Users\\boluc\\eclipse-workspace\\lab9\\src\\lab8\\Files\\dictionaryWords.txt";
     String links = "C:\\Users\\boluc\\eclipse-workspace\\lab9\\src\\lab8\\Files\\links.txt";
     
     //Create objects of classes that will be used in the GUI 
     wordCount count = new wordCount();
     SpellChecker check = new SpellChecker();
     Files thefile = new Files();
     NewsFeed feed = new NewsFeed();
     
     //Used to launch associated applications registered on the native desktop to handle a URI or a file.
     Desktop d = Desktop.getDesktop();

     //All variables that are used in the layout and GUI
     public JFrame Frame;
     public Files f1 = new Files();
     public JPanel panel1;
     public JButton b1, b2, clr1,n1buton,n2buton,n3buton,n4buton;
     public JLabel label, opalabel,timeLabel;
     public JTextField t1, t2;
     public String StringGuess,time;
     public JCheckBox box1, box2, box3, box4;
     public int counter = 0;
     public int i;
     public JTextArea jt;
     @SuppressWarnings("rawtypes")
	public JComboBox comboBox;
     public ImageIcon bkgIcon;
     
     //List,Array and Hashmap for Spell Checker and Word Count
     ArrayList < Integer > countwordlist = new ArrayList < Integer > ();
     HashMap<String, String> rank = new HashMap<>();
     List<Double> list = new ArrayList<>(Arrays.asList());
     List<String> file = new ArrayList<>(Arrays.asList());


     @SuppressWarnings({ "unchecked", "rawtypes" })
	public void gui() throws IOException {

    	 //Frame for GUI 
         Frame = new JFrame("CodeDev");
         
         //Set Font for Frame and Color Set
         Font myFont = new Font("DialogInput", Font.BOLD, 12);
         Color myColor = new Color(51 - 204 - 255);

         //Image for the Frame Icon 
         Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\boluc\\OneDrive\\Pictures\\Screenshots\\DevGS.png");
         Frame.setIconImage(icon);
         
         //Get size of Screen and make the height and length to maximise the screen
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
         Frame.setSize(screenSize.width, screenSize.height);
         Frame.setVisible(true);

         Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


         //TextFeild to type in searched word
         t1 = new JTextField();
         t1.setBounds(200, 90, 700, 30);
         
         //Panel for the Frame and Color set to White and no layout
         panel1 = new JPanel();
         panel1.setBackground(Color.WHITE);
         panel1.setLayout(null);
         add(panel1);
         
         //Used for Combox for the options they can choose from
         String[] color = {
             "DEFAULT",
             "RED",
             "BLUE",
             "GREEN"
         };
         
         //Call the combobox and put it at the location and size
         comboBox = new JComboBox(color);
         comboBox.setBounds(50, 30, 100, 30);
         
         //Call the Checkbox for files,It cant be focusable and when you hover over it, it will show the tipText.
         //The variable is called before for font and background and used for all the boxes.
         box1 = new JCheckBox("File 1");
         box1.setFocusable(false);
         box1.setToolTipText("File selected will be included in the search");
         box1.setFont(myFont);
         box1.setBackground(myColor);
         box1.setBounds(50, 90, 100, 40);

         //Call the Checkbox for files,It cant be focusable and when you hover over it, it will show the tipText.
         //The variable is called before for font and background and used for all the boxes.
         box2 = new JCheckBox("File 2");
         box2.setFocusable(false);
         box2.setToolTipText("File selected will be included in the search");
         box2.setFont(myFont);
         box2.setBackground(myColor);
         box2.setBounds(50, 120, 100, 40);

         //Call the Checkbox for files,It cant be focusable and when you hover over it, it will show the tipText.
         //The variable is called before for font and background and used for all the boxes.
         box3 = new JCheckBox("File 3");
         box3.setFocusable(false);
         box3.setToolTipText("File selected will be included in the search");
         box3.setFont(myFont);
         box3.setBackground(myColor);
         box3.setBounds(50, 150, 100, 40);

         //Call the Checkbox for files,It cant be focusable and when you hover over it, it will show the tipText.
         //The variable is called before for font and background and used for all the boxes.
         box4 = new JCheckBox("File 4");
         box4.setFocusable(false);
         box4.setToolTipText("File selected will be included in the search");
         box4.setFont(myFont);
         box4.setBackground(myColor);
         box4.setBounds(50, 180, 100, 40);

         //Reminder to check the files..Color in black and position put
         label = new JLabel("Type a word in to check if its in the files...Dont forget to choose the files :)");
         label.setForeground(Color.black);
         label.setBounds(200, 50, 700, 30);
         
         //Add the buttons,label,combobox to the panel or screen
         panel1.add(box1);
         panel1.add(box2);
         panel1.add(box3);
         panel1.add(box4);
         panel1.add(comboBox);
         panel1.add(label);
         panel1.add(t1);

         //Search button with set size and location
         b1 = new JButton("Search");
         b1.setSize(100, 50);
         b1.setBounds(900, 90, 80, 30);
         
         //Button when clicked brings you to the website of the infro provided.Size is set and location is set to the side.
         n1buton = new JButton(feed.title(links));
         n1buton.setSize(100, 50);
         n1buton.setBounds(1000, 130, 250,100);
         panel1.add(n1buton);
         
         //Button when clicked brings you to the website of the infro provided.Size is set and location is set to the side.
         n2buton = new JButton(feed.title(links));
         n2buton.setSize(100, 50);
         n2buton.setBounds(1000, 240, 250,100);
         panel1.add(n2buton);
         
         //Button when clicked brings you to the website of the infro provided.Size is set and location is set to the side.
         n3buton = new JButton(feed.title(links));
         n3buton.setSize(100, 50);
         n3buton.setBounds(1000, 350, 250,100);
         panel1.add(n3buton);
         
         //Button when clicked brings you to the website of the infro provided.Size is set and location is set to the side.
         n4buton = new JButton(feed.title(links));
         n4buton.setSize(100, 50);
         n4buton.setBounds(1000, 460, 250,100);
         panel1.add(n4buton);
         
         //Add the buttons which can be used for Action Listener
         b1.addActionListener(this);
         box1.addActionListener(this);
         box2.addActionListener(this);
         box3.addActionListener(this);
         box4.addActionListener(this);
         comboBox.addActionListener(this);
         n1buton.addActionListener(this);
         n2buton.addActionListener(this);
         n3buton.addActionListener(this);
         n4buton.addActionListener(this);

         
         //Add the panel to the Frame
         Frame.add(panel1);
         panel1.add(b1);

         //Text area to show the results of the search.It is set to invisible until search is pressed.
         jt = new JTextArea(25, 30);
         panel1.add(jt);
         jt.setBounds(200, 200, 700, 400);

         jt.setVisible(false);


     }
     //Action Listener used to get the buttons pressed and Label in frame.
     public void actionPerformed(ActionEvent e) {
    	 
    	 //Get the button sourse and get Index
         if (e.getSource() == comboBox) {
             System.out.println(comboBox.getSelectedIndex());
             
             //The index is used to put the color of the background such as 0 return which is white in the combobox
             if (comboBox.getSelectedIndex() == 0) {
                 panel1.setBackground(Color.WHITE);

             }
             //Index of 1 is red so checks what is returned and sets the background. Same goes for the rest
             if (comboBox.getSelectedIndex() == 1) {
                panel1.setBackground(Color.RED);

             }
             if (comboBox.getSelectedIndex() == 2) {
                 panel1.setBackground(Color.BLUE);

             }
             if (comboBox.getSelectedIndex() == 3) {
                 panel1.setBackground(Color.GREEN);

             }

         }
         
         //When the button is clicked it will be redirected to the website depending on the label provided
    	 if(e.getSource()==n1buton) {
				try {
					d.browse(new URI(feed.url(links)));
				} catch (IOException | URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    		 
    	 }
    	 
    	 //When the button is clicked it will be redirected to the website depending on the label provided
    	 if(e.getSource()==n2buton) {
				try {
					d.browse(new URI(feed.url(links)));
				} catch (IOException | URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    		 
    	 }
    	 
    	 //When the button is clicked it will be redirected to the website depending on the label provided
    	 if(e.getSource()==n3buton) {
				try {
					d.browse(new URI(feed.url(links)));
				} catch (IOException | URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    		 
    	 }
    	 
    	 //When the button is clicked it will be redirected to the website depending on the label provided
    	 if(e.getSource()==n4buton) {
				try {
					d.browse(new URI(feed.url(links)));
				} catch (IOException | URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    		 
    	 }
    	 
    	 //Clear the textfield and wordlist
         jt.setText("");
         countwordlist.clear();
         
         //Button for search..it will get the text inside the field and make it lowercase.
         if (e.getSource() == b1) {
             //Tried reloading the files again a
             thefile.FileCheck();
             StringGuess = t1.getText().toLowerCase();
             
             //Check the word is valid using SpellChecker
             try {
                 String result = check.stringCompare(StringGuess, dictionaryWords);
                 
                 //If its not valid it will show messageDialog
                 if (result == "False") {
                     JOptionPane.showMessageDialog(null, "The word you entered is not valid");;

                 } 
                 
                 //Else it will say the word is valid and continues with the search.
                 else {
                     jt.append("\n" + "THE WORD IS VALID");
                 }
             } catch (IOException e2) {
                 // TODO Auto-generated catch block
                 e2.printStackTrace();
             }


             //If box is selected the words will be set to lowercase and check if it contians the word put into search.
             if (box1.isSelected()) {
                 while (f1.Scanner1.hasNext()) {
                     String line1 = f1.Scanner1.nextLine().toLowerCase();
                     
                     //Moved the counter if the word is found 
                     if (line1.contains(StringGuess)) {
                         counter++;
                     }

                 }
                 //Tell you if the word is not found in the file.
                 if (counter == 0) {
                     jt.append("\n" + StringGuess + " is not in file 1");

                     
                 } else {
                	 
                	 /*Gives percentage match by finding how many times the words have showed up over the words in the file. It will
                	  then format the number and then gives the percentage in 2 decimal place.*/
                     try {
                         String totalCount = count.countWord(file1);
                         double intTotalCount = Integer.parseInt(totalCount);
                         double percentage = (counter * 100) / intTotalCount;
                         DecimalFormat df = new DecimalFormat("###.##");
                         //System.out.println(df.format(percentage));
                         jt.append("\n" + df.format(percentage) + "% percentage match");
                       
                         //Make the double into a String and put it into dictionary value
                         String str = String.valueOf(percentage);
                         rank.put("File 1",str);
                         list.add(percentage);
                         
                         


                     } catch (IOException e1) {
                         // TODO Auto-generated catch block
                         e1.printStackTrace();
                     }
                     
                     //Add to jt to show in the end in textField.
                     jt.append("\n" + "The word" + "( " + StringGuess + " )" + " is in File1 " + counter + " time(s)");

                 }
                 //counter is add to countwordlist to store and show in textfield.
                 countwordlist.add(counter);


                 counter = 0;
             }


             if (box2.isSelected()) {
                 while (f1.Scanner2.hasNext()) {
                     String line2 = f1.Scanner2.nextLine().toLowerCase();

                     if (line2.contains(StringGuess)) {
                         counter++;
                     }

                 }

                 if (counter == 0) {
                     jt.append("\n" + StringGuess + " is not in file 2");

                 } else {
                     try {
                         String totalCount = count.countWord(file2);
                         double intTotalCount = Integer.parseInt(totalCount);
                         double percentage = (counter * 100) / intTotalCount;
                         DecimalFormat df = new DecimalFormat("###.##");
                         //System.out.println(df.format(percentage));
                         jt.append("\n" + df.format(percentage) + "% percentage match");
                         
                         String str = String.valueOf(percentage);
                         rank.put("File 2",str);
                         list.add(percentage);


                     } catch (IOException e1) {
                         // TODO Auto-generated catch block
                         e1.printStackTrace();
                     }
                     jt.append("\n" + "The word" + "( " + StringGuess + " )" + " is in File2 " + counter + " time(s)");
                 }
                 countwordlist.add(counter);

                 counter = 0;
             }


             if (box3.isSelected()) {
                 while (f1.Scanner3.hasNext()) {
                     String line3 = f1.Scanner3.nextLine().toLowerCase();

                     if (line3.contains(StringGuess)) {
                         counter++;
                     }

                 }

                 if (counter == 0) {
                     jt.append("\n" + StringGuess + " is not in file 3");

                 } else {
                     try {
                         String totalCount = count.countWord(file3);
                         double intTotalCount = Integer.parseInt(totalCount);
                         double percentage = (counter * 100) / intTotalCount;
                         DecimalFormat df = new DecimalFormat("###.##");
                         //System.out.println(df.format(percentage));
                         jt.append("\n" + df.format(percentage) + "% percentage match");
                         
                         String str = String.valueOf(percentage);
                         rank.put("File 3",str);
                         list.add(percentage);
               


                     } catch (IOException e1) {
                         // TODO Auto-generated catch block
                         e1.printStackTrace();
                     }
                     jt.append("\n" + "The word" + "( " + StringGuess + " )" + " is in File3 " + counter + " time(s)");



                 }
                 countwordlist.add(counter);

                 counter = 0;
             }

             if (box4.isSelected()) {
                 while (f1.Scanner4.hasNext()) {
                     String line4 = f1.Scanner4.nextLine().toLowerCase();

                     if (line4.contains(StringGuess)) {
                         counter++;
                     }

                 }

                 if (counter == 0) {
                     jt.append("\n" + StringGuess + " is not in file 4");

                 } else {
                     try {
                         String totalCount = count.countWord(file4);
                         double intTotalCount = Integer.parseInt(totalCount);
                         double percentage = (counter * 100) / intTotalCount;
                         DecimalFormat df = new DecimalFormat("###.##");
                         //System.out.println(df.format(percentage));
                         jt.append("\n" + df.format(percentage) + "% percentage match");
                   
                         String str = String.valueOf(percentage);
                         rank.put("File 4",str);
                         list.add(percentage);


                     } catch (IOException e1) {
                         // TODO Auto-generated catch block
                         e1.printStackTrace();
                     }
                     jt.append("\n" + "The word" + "( " + StringGuess + " )" + " is in File4 " + counter + " time(s)");

                 }

                 countwordlist.add(counter);

                 counter = 0;

             }
             /*This took me a while to do because it was hard to get my head around it.
              But basically it is 2 for loops which gets the key and makes it into double.
              Then it cross reference the number in the key and the percentage list and if it equals 
              It will get the File name and add it
              Because the list is sorted..when the file is add it will also be sorted.*/
             Collections.sort(list);
             for(int i=0;i<list.size();i++){
                 for (String key: rank.keySet()){
                	 double str1 = Double.parseDouble(rank.get(key));
                	 if (list.get(i)== (str1)){
                		 System.out.println(key +" = "+ str1);
                		 file.add(key);
                		 
                	 }
                	 else {
                		 continue;
                	 }
                 }
            	}
             
             //After getting the files add i just print it out by using another for lopp and add to jt
             jt.append("\n"+"Ranking Lowest to Highest:");
             for(int i=0;i<file.size();i++){
            	 jt.append("\n"+file.get(i));
             }
	     file.clear();
             list.clear();
             rank.clear();
             
             //After all of that is done it is set to true to show on the frame
             jt.setVisible(true);
             Collections.sort(countwordlist, Collections.reverseOrder());
             
             //Check to tell you no files were selected
             if (countwordlist.isEmpty()) {
                 JOptionPane.showMessageDialog(null, "No file Selected");;

             } else {
            	 
            	 //This is another ranking system showing the most common words.
                 jt.append("\n" + countwordlist.toString() + " displays strongest to weakest matches");
             }



         }
     }




     public GUI() throws IOException {
         gui();
     }


}

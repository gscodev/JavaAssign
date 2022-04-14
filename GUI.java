 package lab8;


 import javax.swing.*;
 import javax.swing.border.Border;
 import javax.swing.filechooser.FileSystemView;

 import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.io.File;
 import java.io.FileNotFoundException;
 import java.io.IOException;
 import java.text.DecimalFormat;
 import java.util.*;

 import java.util.List;




 public class GUI extends JFrame implements ActionListener {

     public static final long serialVersionUID = 1L;

     String file1 = "C:\\Users\\boluc\\eclipse-workspace\\lab9\\src\\lab8\\Files\\file1.txt";
     String file2 = "C:\\Users\\boluc\\eclipse-workspace\\lab9\\src\\lab8\\Files\\file2.txt";
     String file3 = "C:\\Users\\boluc\\eclipse-workspace\\lab9\\src\\lab8\\Files\\file3.txt";
     String file4 = "C:\\Users\\boluc\\eclipse-workspace\\lab9\\src\\lab8\\Files\\file4.txt";

     String dictionaryWords = "C:\\Users\\boluc\\eclipse-workspace\\lab9\\src\\lab8\\Files\\dictionaryWords.txt";

     wordCount count = new wordCount();
     SpellChecker check = new SpellChecker();
     Files thefile = new Files();

     public JFrame Frame;
     public Files f1 = new Files();
     public JPanel panel1;
     public JButton b1, b2, clr1, bkg;
     public JLabel label, background;
     public JTextField t1, t2;
     public String StringGuess;
     public JCheckBox box1, box2, box3, box4;
     public int counter = 0;
     public int i;
     public JTextArea jt;
     public JComboBox comboBox;
     public ImageIcon bkgIcon;


     ArrayList < Integer > countwordlist = new ArrayList < Integer > ();
     HashMap<String, String> rank = new HashMap<>();
     List<Double> list = new ArrayList<>(Arrays.asList());
     List<String> file = new ArrayList<>(Arrays.asList());


     

     public void gui() {


         Frame = new JFrame("CodeDev");


         Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\boluc\\OneDrive\\Pictures\\Screenshots\\DevGS.png");
         Frame.setIconImage(icon);

         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
         Frame.setSize(screenSize.width, screenSize.height);
         Frame.setVisible(true);

         Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


         //TextFeild
         t1 = new JTextField();
         t1.setBounds(200, 90, 700, 30);

         panel1 = new JPanel();
         panel1.setBackground(Color.WHITE);
         panel1.setLayout(null);
         add(panel1);

         String[] color = {
             "DEFAULT",
             "RED",
             "BLUE",
             "GREEN"
         };
         comboBox = new JComboBox(color);
         comboBox.setBounds(50, 30, 100, 30);

         bkg = new JButton("Choose Background");
         bkg.setBounds(500, 500, 500, 30);


         Font myFont = new Font("DialogInput", Font.BOLD, 12);
         Color myColor = new Color(51 - 204 - 255);


         box1 = new JCheckBox("File 1");
         box1.setFocusable(false);
         box1.setToolTipText("File selected will be included in the search");
         box1.setFont(myFont);
         box1.setBackground(myColor);
         box1.setBounds(50, 90, 100, 40);



         box2 = new JCheckBox("File 2");
         box2.setFocusable(false);
         box2.setToolTipText("File selected will be included in the search");
         box2.setFont(myFont);
         box2.setBackground(myColor);
         box2.setBounds(50, 120, 100, 40);


         box3 = new JCheckBox("File 3");
         box3.setFocusable(false);
         box3.setToolTipText("File selected will be included in the search");
         box3.setFont(myFont);
         box3.setBackground(myColor);
         box3.setBounds(50, 150, 100, 40);


         box4 = new JCheckBox("File 4");
         box4.setFocusable(false);
         box4.setToolTipText("File selected will be included in the search");
         box4.setFont(myFont);
         box4.setBackground(myColor);
         box4.setBounds(50, 180, 100, 40);

         label = new JLabel("Type a word in to check if its in the files...Dont forget to choose the files :)");
         label.setForeground(Color.black);
         label.setBounds(200, 50, 700, 30);

         panel1.add(box1);
         panel1.add(box2);
         panel1.add(box3);
         panel1.add(box4);

         panel1.add(comboBox);
         panel1.add(bkg);


         panel1.add(label);
         panel1.add(t1);

         b1 = new JButton("Search");
         b1.setSize(100, 50);
         b1.setBounds(900, 90, 80, 30);

         b1.addActionListener(this);
         box1.addActionListener(this);
         box2.addActionListener(this);
         box3.addActionListener(this);
         box4.addActionListener(this);
         comboBox.addActionListener(this);
         bkg.addActionListener(this);

         Frame.add(panel1);
         panel1.add(b1);


         jt = new JTextArea(25, 30);
         panel1.add(jt);
         jt.setBounds(200, 200, 700, 400);

         jt.setVisible(false);


     }

     public void actionPerformed(ActionEvent e) {
         if (e.getSource() == comboBox) {
             System.out.println(comboBox.getSelectedIndex());
             if (comboBox.getSelectedIndex() == 0) {
                 panel1.setBackground(Color.WHITE);

             }
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

         jt.setText("");
         countwordlist.clear();
         if (e.getSource() == b1) {
             //Tried reloading the files again a
             thefile.FileCheck();
             StringGuess = t1.getText().toLowerCase();
             try {
                 String result = check.stringCompare(StringGuess, dictionaryWords);
                 if (result == "False") {
                     JOptionPane.showMessageDialog(null, "The word you entered is not valid");;

                 } else {
                     jt.append("\n" + "THE WORD IS VALID");
                 }
             } catch (IOException e2) {
                 // TODO Auto-generated catch block
                 e2.printStackTrace();
             }



             if (box1.isSelected()) {
                 while (f1.Scanner1.hasNext()) {
                     String line1 = f1.Scanner1.nextLine().toLowerCase();

                     if (line1.contains(StringGuess)) {
                         counter++;
                     }

                 }
                 if (counter == 0) {
                     jt.append("\n" + StringGuess + " is not in file 1");

                 } else {
                     try {
                         String totalCount = count.countWord(file1);
                         double intTotalCount = Integer.parseInt(totalCount);
                         double percentage = (counter * 100) / intTotalCount;
                         DecimalFormat df = new DecimalFormat("###.##");
                         //System.out.println(df.format(percentage));
                         jt.append("\n" + df.format(percentage) + "% percentage match");
                       
                         String str = String.valueOf(percentage);
                         rank.put("File 1",str);
                         list.add(percentage);
                         
                         


                     } catch (IOException e1) {
                         // TODO Auto-generated catch block
                         e1.printStackTrace();
                     }
                     jt.append("\n" + "The word" + "( " + StringGuess + " )" + " is in File1 " + counter + " time(s)");

                 }
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
             
             jt.append("\n"+"Ranking Lowest to Highest:");
             for(int i=0;i<file.size();i++){
            	 jt.append("\n"+file.get(i));
             }
             
             
             jt.setVisible(true);
             Collections.sort(countwordlist, Collections.reverseOrder());
             if (countwordlist.isEmpty()) {
                 JOptionPane.showMessageDialog(null, "No file Selected");;

             } else {
                 jt.append("\n" + countwordlist.toString() + " displays strongest to weakest matches");
             }



         }
     }




     public GUI() {
         gui();
     }


 }

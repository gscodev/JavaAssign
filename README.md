# JavaAssignment Search Engine

Search Engine done with the Java Language

Core Functionality:

  Select the Files to Check
  Calculate a match level for each and give a ranking
  Search multiple words.
  Spelling Checking
  
Additional Functionality:

  Background colour change
  News feed on the side that redirects to webpage
  Tooltips to prompt the user
  
If i had more time i would have:

  Made sure the news feed is better
  Save search like a cookie
  Maybe add a small game to it like the dinosaur game for Google
  
  
wordCount class{
  The filename is passed through the class. It then makes a ByteArray with the contents of the file after getting the length.
  After it gets that it will split at space and count each of the word and increment the count to find the total length

}
SpellChecker class{
  The spell checker class goes through the file of dictionary which has the 32k words in the English dictionary. It compares each
  of the words for each of the words in the dictionary and returns a false or true.
  If a true is shown it will mark it off as word got and says the word is valid.
}
NewsFeed{
  The Newsfeed is a simple reading of a file where the first value is the title of the news and the second is the url.
  I split both of these and use the title for the button and take the url and navigate to the website.

}
GUI{
  The GUI includes alot of stuff such as the Files that are used and GUI buttons and Text. I did small tweaking to the GUI such as having an Icon and making it full     screen depending on the user screen. Other stuff including the checkbox to pick the file and the Combobox for changing the background.The GUI also includes the full feed system and the ranking system for each of the files that are selected by the user.
}
Files{
  Pass in the files and check if it can be used and is valid. If it is not valid it will tell the user the directory is not correct.
}
Control{
  Control has the 2 lines for getting the Files and the GUi
}

Link for the video:

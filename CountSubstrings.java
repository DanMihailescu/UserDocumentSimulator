//package textfiles;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class CountSubstrings{
  private String path;
  
  public CountSubstrings(String filePath){
    path = filePath;
  }
  
  public String[] openFile(int nol) throws IOException{     //Makes a arraylist from the file
    FileReader fr = new FileReader(this.path);
    BufferedReader text = new BufferedReader(fr);
    
    String[] textData = new String[nol];
    for(int i = 0; i < nol; i++){
      textData[i] = text.readLine();
    }
    text.close();
    return textData;
  }
  
  public TestListReferenceBased openFile() throws IOException{     //Makes a linkedlist from the file
    FileReader fr = new FileReader(this.path);
    BufferedReader text = new BufferedReader(fr);
    
    TestListReferenceBased textData = new TestListReferenceBased();
    for(int i = 0; i < 32544; i++){
      textData.add(text.readLine());
    }
    text.close();
    return textData;
  }
  
  public static void main(String args[]) throws IOException{
    long time = 0;
    
    System.out.println("Please enter the path for the input file: ");          //Tests the arraylist method
    Scanner in = new Scanner(System.in);
    String file = in.nextLine();
    CountSubstrings s = new CountSubstrings(file);
    String[] lines = s.openFile(32544);
    
    System.out.println("Enter the pattern to look for: ");
    String search = in.nextLine();
    int arrayCounter=0;
    time = System.currentTimeMillis();
    for (int i = 0; i <= 32544; i++){
      if (lines[i] == search) arrayCounter++;
    }
    time += System.currentTimeMillis();
    System.out.println("Using ArrayLists: " + arrayCounter + " matches, derived in " + time + " milliseconds");
      
    System.out.println("Please enter the path for the input file: ");          //Tests the linkedlist method
    file = in.nextLine();
    CountSubstrings st = new CountSubstrings(file);
    TestListReferenceBased lines2 = st.openFile();
    
    System.out.println("Enter the pattern to look for: ");
    search = in.nextLine();
    int linkedCounter=0;
    time = System.currentTimeMillis();
    for (int i = 0; i <= 32544; i++){
      if (lines2.get(i).value == search) linkedCounter++;
    }
    time += System.currentTimeMillis();
    System.out.println("Using LinkedList: " + linkedCounter + " matches, derived in " + time + " milliseconds");
  }
}
    
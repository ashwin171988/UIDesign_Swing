/* Author : Ashwin Rameshan
** Net ID : 2021163997
** Starting Date : Sep 14 2014
** Purpose : Assignment 1
** Class Number : CS6301.022
** Purpose : Assignment 1 - Contact Manager
*/



package contactManager;
/*
** Module : ContactManagerController.java 
** Description : All file operations are performed in this class. The class
** works in tandem with the Main class. Performs basic Create / Update / Delete operations
** in the file.
*/
import static contactManager.ContactManagerFrame.*;
import static contactManager.ContactManagerFrame.rdoFemale;
import static contactManager.ContactManagerFrame.rdoMale;
import static contactManager.ContactManagerFrame.txtPhoneNumber;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class ContactManagerController {
    
    String firstNametxt = null , lastNametxt = null , middleNametxt = null , addressLine1txt = null, addressLine2txt = null;
    String cityNametxt = null , stateNametxt = null;
    String zipCodetext = null , phoneNumbertxt = null;
    File file = new File("../Contact.txt");
    
/*
    Method checks for Duplicate records inside the file . This method
    is used when trying to add a new record into the file. Once a record
    is found it notifies the parent method if such a record exists or not.
    */    
     public static boolean checkForDuplicates(String fname , String lname) throws IOException
    {
    String contactFirstName = fname;
    String contactLastName = lname; int indexFound =0;
    BufferedReader bf = new BufferedReader (new FileReader("../Contact.txt"));
    int count = 0; String line;
    while (( line = bf.readLine()) != null) 
    {
       if( (line.contains(contactFirstName)) && (line.contains(contactLastName)) )
       {
           indexFound ++;
           break;
       }
    }
    bf.close();
        if (indexFound > 0) 
        {
        return true;
        }
    else
    return false;
    }
//default constructor
    ContactManagerController() {}
     
/*
    ** Method adds the string received into the file.
    */ 
     public String AddToFile(String addString) throws IOException
     { 
            BufferedWriter bfw = null;
            bfw = new BufferedWriter(new FileWriter(file,true));
            bfw.write(addString);
            bfw.newLine();bfw.flush();
            bfw.close();
            return addString;
     }
     /*
     Method deletes record from the file based on input from Main program.
     */
     
      boolean deleteRecordInFile(List<String> rowContent) throws FileNotFoundException, IOException
    {
        StringBuilder strbuf = new StringBuilder();
        boolean successfull = false;
        File inputFile = new File("../Contact.txt");
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));        
        File tempFile = new File("../tempfile.txt");
      //  BufferedReader reader = new BufferedReader(new FileReader(inputFil0e));
       PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
        
        for(String content : rowContent)
        {
        strbuf = strbuf.append(content).append("\t");  
        }
        String currentLine;
        while((currentLine = reader.readLine()) != null)
        {
        if(!(currentLine.contains(strbuf)))
        {
          pw.println(currentLine);
        }
        }
        reader.close();
        pw.close(); 
        
        Path fp = inputFile.toPath();
        
        Files.delete(fp);
        if(!(inputFile.exists()))
        {
          successfull = true;
        }
    if(successfull)   
    {
    successfull = tempFile.renameTo(inputFile);
        return successfull;
    }
   
    return false;
    }   
 /*
      Method updates the record in the file based on input from Main class.
      ** modified data is then  updated back in the table.
      */    
      
 public boolean UpdateRecordInFile(String inputRecord , String firstName , String lastName) throws FileNotFoundException, IOException
 {
     boolean deleteSuccess = false;
     String fname = firstName;
     String lname = lastName;
     File inputFile = new File("../Contact.txt");
     BufferedReader br = new BufferedReader(new FileReader(inputFile));

     File tempFile = new File("../tempfile.txt");
     PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

     String checkLine = null;
     String replaceLine = null;
   
        while((checkLine = br.readLine())!=null)
        {
            if((checkLine.contains(fname)) || (checkLine.contains(lname)))
                    {
                        checkLine = inputRecord;
                        pw.println(checkLine);  
                    }
            else
                pw.println(checkLine);
        }
        br.close();
        pw.close();                
        Path fp = inputFile.toPath();
        Files.delete(fp);        
        if(!(inputFile.exists()))
        {
          deleteSuccess = true;
        }
        if(deleteSuccess)
        {
            deleteSuccess = tempFile.renameTo(inputFile);
            return deleteSuccess;    
        }
        return false;
      
 }
      
/*
 ** Method checks for incomplete fields int he table. If any field or components
 is left blank , this methods checks for teh same and reports it back to user.
 */      
      
      
public boolean checkComponents(String fname, String lname, String middleName, String city, String state, String address1, String address2, String zipCode, String phoneNumber)
     {
         String stringRegex = "[a-zA-Z0-9+]";
         boolean regexStatus = false;
         String[] compStore = new String[7];
         String[] intStore = new String[2];
         this.firstNametxt = fname;
         compStore[0] = firstNametxt;
         this.lastNametxt = lname;
         compStore[1] = lastNametxt;
         this.middleNametxt = middleName;
         compStore[2] = middleNametxt;
         this.cityNametxt = city;
         compStore[3] = cityNametxt;
         this.stateNametxt = state;
         compStore[4] = stateNametxt;
         this.addressLine1txt = address1;
         compStore[5] = addressLine1txt;
         this.addressLine2txt = address2;
         compStore[6] = addressLine2txt;
         this.zipCodetext = zipCode;
         intStore[0] = zipCodetext;
         this.phoneNumbertxt = phoneNumber;
         intStore[1] = phoneNumbertxt;
       //  int nameLength = 20 , addressLength = 35 , cityLength = 25 , stateLength =2 , zipCodeLength = 9 , phoneNumberLength = 21;

         if (firstNametxt.equals("") || lastNametxt.equals("") || addressLine1txt.equals("") || cityNametxt.equals("")
                 || stateNametxt.equals("") || zipCodetext.equals("") || phoneNumbertxt.equals("")) {
             //JOptionPane.showMessageDialog(null, "Please enter all the details");
             lblStatusDisplay.setText("Please enter all the details");
             return false;
         }
         if ((!(rdoMale.isSelected())) && (!(rdoFemale.isSelected())) )
      {
           lblStatusDisplay.setText("Please enter Gender details");
         return false;
      }
       return true;
    }
}
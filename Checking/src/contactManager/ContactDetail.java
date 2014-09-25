/* Author : Ashwin Rameshan
** Net ID : 2021163997
** Starting Date : Sep 14 2014
** Purpose : Assignment 1
** Class Number : CS6301.022
** Purpose : Assignment 1 - Contact Manager
*/

/*
** Module : ContactDetail.java 
** Description : This class is used to store Contact Details object. 
** The state and attributes are placed int his class.
*/


package contactManager;
import java.util.HashMap;


public class ContactDetail
{
    // create a contact class to store each and every contact value
    //inititalze all the variables for the contact
    String firstName = null;
    String lastName = null; String middleName = null;
    String genderValue = null;
    String AddressLine1 = null , AddressLine2 = null;
    String city = null , stateValue = null ; String zipCode = null;
    String phoneNumber = null;
    // constructor that sets the value of variables at initialization.
     ContactDetail(String fname , String lname , String mname , String genderVale , String pno , String add1 , String add2 , String cvalue , String stval ,String zcode  ) 
    {
        this.firstName = fname;
        this.lastName = lname;
        this.middleName = mname;
        this.genderValue = genderVale;
        this.phoneNumber = pno;
        this.AddressLine1 = add1;
        this.AddressLine2 = add2;
        this.city = cvalue;
        this.stateValue = stval;
        this.zipCode = zcode;
    }
     //create a hashmap to store the list of values;
    HashMap<String,String> contactMap = new HashMap<String,String>();
   /*
    ** gETTERS AND SETTERS
    */
    

//initialize setters
    public void setFirstName(String fname)
    {
        this.firstName = fname;
    }
     public void setLastName(String lname)
    {
        this.lastName = lname;
    }
      public void setMiddleName(String mname)
    {
        this.middleName = mname;
    }
       public void setPhoneNumber(String pnumber)
    {
        this.phoneNumber = pnumber;
    }
       public void setGenderValue(String gender)
    {
        this.genderValue = gender;
    }
       public void setAddressLine1(String addNo1)
    {
        this.AddressLine1 = addNo1;
    }
       public void setAddressLine2(String addNo2)
    {
        this.AddressLine2 = addNo2;
    }
       public void setCity(String city)
    {
        this.city = city;
    }
        public void setState(String state)
    {
        this.stateValue = state;
    }
     public void setZipCode(String zcode)
    {
        this.zipCode = zcode;
    }
    //initialize getters
     
    
     public String getFirstName()
    {
        return this.firstName;
    }
      public String getLastName()
    {
        return this.lastName;
    }
      public String getMiddleName()
    {
        return this.middleName;
    }
       public String getPhoneNumber()
    {
        return this.phoneNumber;
    }
      public String getGender()
    {
        return this.genderValue;
    }
       public String getAddressLine1()
    {
        return this.AddressLine1;
    }
       public String getAddressLine2()
    {
        return this.AddressLine2;
    }
       public String getCity()
    {
        return this.city;
    }
       public String getState()
    {
        return this.stateValue;
    }
       public String zipCode()
    {
        return this.zipCode;
    }
       /*
       mETHOD THAT IS USED TO RETURN THE COMPLETE sTRING OF ALL THE VARAIBLES 
       defined in this class.
       */
       public String buildString()
       {
        StringBuilder contactString = new StringBuilder();
        contactString = contactString.append(firstName).append("\t").append(middleName).append("\t");
        contactString = contactString.append(lastName).append("\t").append(phoneNumber).append("\t");
        contactString = contactString.append(genderValue).append("\t").append(AddressLine1).append("\t");
        contactString = contactString.append(AddressLine2).append("\t").append(city).append("\t");
        contactString = contactString.append(stateValue).append("\t").append(zipCode);
        
        return contactString.toString();
       }
}


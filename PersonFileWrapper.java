import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;


/** Class used to execute load, search, delete and view menu actions on a
 *   Person[].
 */
public class PersonFileWrapper {
	
   public static final String FILENAME = "person.dat";
   public static final int MAXRECORDS = 5;

   private Person[] data;
   private int numEntries = 0;
/*
by huguette
*/
   
   ObjectInputStream inputStream = null;
   ObjectOutputStream outputStream = null;
   Scanner scan = new Scanner(System.in);
   Scanner key = new Scanner(System.in);
  
   

   /** Constructor that creates the data array that will eventually contain
    *   the Person records.  This constructor immediately tries to load
    *   from the local directory file, FILENAME.  If it cannot find that
    *   file, the data[] is initialized as an empty array of size 15.
    */
   public PersonFileWrapper()	{
	   
	   System.out.print("Enter the current date: ");
	   Date currentDate = new Date();
	   currentDate.readInput(null);  
	   data = new Person [MAXRECORDS];


      // Load file from disk if it exists, otherwise initialize to blank
      File fileObject = new File(FILENAME);
      if (fileObject.exists()) {
         loadData();
      }
   }

   /** Method to write all Person objects contained within data[] to a
    *   file specified by FILENAME.
    */
   public void saveData() {
      // ITP 220 - implement this method
      // when finished, print the number of records written
   }

   /** Method to read all Person objects from the file specified by FILENAME.
    *  This method overwrites any existing entries in data[].
    */
   public void loadData() {
      // ITP 220 - implement this method
      //  Load should overwrite existing data[] entries and update numEntries
   }

   /** Method that uses Scanner to prompt the user for Person data to use to 
    *   create Person objects added to data[].  This method should attempt
    *   to fill the first empty data[] index and should notify the user
    *   when invalid data is entered.
 * @throws IOException 
 * @throws FileNotFoundException 
    */
   public void addPerson()  {
       
    try{
        
        
    try {
        
        
    
       /*add by huguette*/
      try {
       outputStream = new ObjectOutputStream(new FileOutputStream("temp-person.dat"));
       inputStream = new ObjectInputStream(new FileInputStream("person.dat"));
          
       while(true)
       {
            Person current =(Person) inputStream.readObject();
            outputStream.writeObject(current);
      
      
      
       }
     
      }
       catch (IOException e){
           
           System.out.println("error reading or writing into the temp file");
       }
       
       try {
           
           outputStream = new ObjectOutputStream(new FileOutputStream("person.dat"));
           inputStream = new ObjectInputStream(new FileInputStream("temp-person.dat"));
           
           while(true)
            {
                 Person current =(Person) inputStream.readObject();
                 outputStream.writeObject(current);
           
           
           
            }
       }
       
       catch (IOException e){
           
           System.out.println("error reading or writing into the temp file");
       }
  
      // ITP 220 - implement this method
      // prompt for all Person data and validate entries
      // fill the first available index position

       
       System.out.print("Enter the person name : ");
       String name = scan.nextLine();
       System.out.print("Please enter the person date of birth (mm/dd/yyyy)");
       
       
       Date dateBirth =new Date();
       Date dateDeath = null;
       Person boo = new Person("huguette", dateBirth,dateDeath);
       
       
       try{
    	   dateBirth  = df.parse(uDate);
    	} catch (ParseException e){ System.out.println("invalid format");}
    	 
    	if (!df.format(dateBirth).equals(uDate))
    	    System.out.println("invalid date!!");

       
       System.out.print("Is the person still alive?(y/n) : ");
       String answer = scan.nextLine();
       if(answer.equals("y"))
           dateDeath = null;
       else 
                {
		    	   System.out.print("Please enter the death date  (mm/dd/yyyy)");
		    	   String uDate1 = scan.nextLine();
		    	   try{
		        	   dateDeath  = df.parse(uDate1);
		        	} catch (ParseException e){ System.out.println("invalid format");}
		        	 
		        	if (!df.format(dateDeath).equals(uDate1))
		        	    System.out.println("invalid date!!");
                }
       
       outputStream.writeObject(new Person(name ,dateBirth,dateDeath)); 
       System.out.println("Person add succesfully"); 
       
    
    }
    
   
       
      catch (IOException e) {
          
         System.out.println("ERROR"); 
          
      }
    
    }    
       catch (ClassNotFoundException e) {
          
         System.out.println("error creating a person"); 
          
      }
       
       
       
       
       
       
       
       
       
       
       
       
       

  }
   /** Method to print and retrieve the index of a retrieved Person object.
    *  If no Person was not found with the matching search String in ANY of
    *  its variables, this method prints a message and returns -1.
    *  @return int[] - Indices within data[] of matching Person objects 
    */ 
   public int[] retrievePerson() {
      Scanner keyboard = new Scanner(System.in);
      System.out.println(
         "Please enter a search String (followed by the Enter key):\n");
      String search = keyboard.nextLine();
      while(search == null || search.trim().length() == 0) {
         System.out.println("Invalid entry, please enter a search String of one or more characters.");
         search = keyboard.nextLine();         
      }
      System.out.println("Trying to retrieve person " + search);

      // initialize returned int[] to a maximum of numEntries indices
      int[] indices = new int[numEntries];
      
      // ITP 220 - complete the retrieval part of this method updating the
      //  int[] with matching indices and printing information on all Person 
      //  Objects found
      
      return indices;
   }

   /** Method to prompt the user for information on which Person to delete.
    *  This method should make use of retrievePerson and should allow the
    *  user to remove one or more Person objects.
    */
   public void deletePerson() {
      // ITP 220 - complete this method
      //  Prompt the user before removing one or more Persons based on
      //  their search criteria
   }

   /** Method to print information for all Person objects within data[].
    */
   public void viewAll() {
		  ObjectInputStream boo1 = null;
		  try {
			boo1 = new ObjectInputStream (new FileInputStream (FILENAME));
			
			boo1.read();
			System.out.println(boo1);
		  
		  }
		  
		  catch (FileNotFoundException e) {
		  
		      // ITP 220 - implement this method
		      // prompt for all Person data and validate entries
		      // fill the first available index position
		   }
		  catch (IOException e) {
			  
		      // ITP 220 - implement this method
		      // prompt for all Person data and validate entries
		      // fill the first available index position
		   }
		  try {
		  boo1.close();
		   }
		  catch (IOException e) {
		  }
   }

   /** Accessor method for the number of Person objects within data[].
    *  This number should never include NULL Person entries.
    */
   public int getNumEntries() {
      return numEntries;
   }
}



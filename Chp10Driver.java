import java.util.Date;
import java.util.Scanner;

/** Driver to present a main menu for testing all methods within
 *   PersonFileWrapper.
 */
public class Chp10Driver  {
    
 /*
 add by huguette start
 
 */  
   
    
 /* add by huguette end*/
    
   public static void main(String[] args) throws Exception {
       Date dateBirth =new Date();
       dateBirth.readInput();  
	   
	   
	   
      PersonFileWrapper pfw = new PersonFileWrapper();
      int menuChoice = -1;
      do {
         menuChoice = retrieveMenuSelection(pfw.getNumEntries());
         switch(menuChoice) {
         case 1:
            pfw.addPerson();
            break;
         case 2:
            pfw.retrievePerson();
            break;
         case 3:
            pfw.deletePerson();
            break;
         case 4:
            pfw.viewAll();
            break;
         case 5:
            pfw.saveData();
            break;
         case 6:
            pfw.loadData();
            break;
         case 0: 
            System.out.println("Thank you for playing!");
            System.exit(0);
            break;
         default:
            // do nothing
            System.out.println("Invalid entry, please enter a valid menu selection.\n");
         }   
      } while (0 != menuChoice);
   }

   /** Method to create a String that will be displayed for the user to
    *   make their menu selections.
    *  @param numPersons 
    *  @return Menu String
    */
   protected static String getMenu(int numPersons) {
      return "Person Manipulation Menu (" + numPersons +
        " entries of " + PersonFileWrapper.MAXRECORDS + " max):\n" +
        "1 = Add person  \n" +
        "2 = Retrieve person  \n" +
        "3 = Delete person  \n" +
        "4 = View all person(s)  \n" +
        "5 = Save data to file, " + PersonFileWrapper.FILENAME + "\n" +
        "6 = Load data from disk  \n" +
        "0 = Quit  \n" +
        "Please enter your menu selection now.\n";
   }
   
   /** Method to retrieve user menu selection.
    * @param numPersons
    * @return Integer menu selection, -1 if the user made no selection or
    *  an invalid one.
    */
   protected static int retrieveMenuSelection(int numPersons) {
      // initialize the return value as MAXVALUE
      int retVal = -1;
      
      System.out.println(getMenu(numPersons));
      Scanner keyboard = new Scanner(System.in);
      String line = null;
      do {
         try {
            line = keyboard.nextLine();
            retVal = Integer.parseInt(line);
         } catch(Exception e) {
            System.out.println("Invalid entry, please enter a valid menu selection.\n");
            retVal = -1;
         }
      } while(retVal < 0);
      
      return retVal;
   }
}
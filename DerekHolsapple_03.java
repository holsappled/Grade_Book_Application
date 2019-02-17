/**
* DerekHolsapple_and_RoscoeWelch_03 

* 
* The program will utilize three .txt files to that contain student
   and grade item data.
* The program will import the .txt files, convert each line into an object, 
   and eith add or delete names from a list.
* After sorting there will be a output report.  The output report will show a student's 
    information along with a report of that student's grades 

* @author Derek Holsapple and Roscoe Welch
* @version 01, CS 2050
* Mac_OS, Intel Core m3, Visual Studio Code

* Abstruse: adj., difficult to comprehend
*  
* "Expect problems and eat them for breakfast" 
* ALFRED MONTAPERT (July 15, 1906 - September 19, 1997)
*/

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;


class List {

    // File that contains a list of valid data 
    static final String INPUT_FILE = "hw3input01.txt";

    // String that separates tests with "*"
    static final String separator = ( "\n**************************" 
        + "*****************************************\n" );


    static String[] indexLineArray;      // Array to store import data from a file 

    static Student studentAddObject;     // Student object to be added to list 
    static Student studentDelObject;     // Student object to be deleted from list
    static GradeItem gradeItemAddObject; // Grade item object to be added to list
    static GradeItem gradeItemDelObject; // Grade item object to be deleted from list

// ********************************************************************************    
  /** Main method to run test 1, test 2, and test 3.
  
    * Step 1: Import the hw3input01.txt data and sort it between student and grade item
              Import the data using an array with a while loop.  
              Validate the data to be a student object or a grade item object
              Sort the array by the second element into the category 'ADD' or 'DEL'
              After validation and sorting, create the object of 
              either student or grade item to be added or deleted from the list
               
    * Step 2: ROSCOE STEP 
                            
    * Step 3: OUTPUT REPORT INFO (Will discuss next class period, with Roscoe)  
    
    * @throws, FileNotFoundException  -The file does not exist
    * @throws, System.err.            -'STUDENT' is not the first data entry 

    * @param,  indexLineArray       -Array to store incoming data from the file
    * @param,  INPUT_FILE           -String, to store file path
    * @param,  input                -String, local variable used to read file
    * @param,  indexLine            -String, local variable to store the next line from incoming data
    * @param,  separator            -String, separates tests with "*"
    * @param,  studentAddObject;    -Student object to be added to list 
    * @param,  studentDelObject;    -Student object to be deleted from list
    * @param,  gradeItemAddObject;  -Grade item object to be added to list
    * @param,  gradeItemDelObject;  -Grade item object to be deleted from list
    */ 
    public static void main( String[] args ) {

        // Create a scanner to read the text file
        try {
            Scanner input = new Scanner( new File( INPUT_FILE ) );
            
            // While loop to read the file and store each line into an array
            // There will be a series of if statements sorting the incoming data 
            // The end result of the loop will be 
                 // 1) 'ADD' student object (add to list)
                 // 2) 'DEL' student object (delete from list)
                 // 3) 'ADD' grade item object (add to list)
                 // 4) 'DEL' grade item objct (delete from list)
            while ( input.hasNextLine() ) {
                // Print a separator for organization formatting (possibly delete later)
                System.out.print( separator );

                // Read the index line
                String indexLine = input.nextLine();

                // Split the line to form an array from 'INPUT_FILE'
                indexLineArray = indexLine.split( "," );
                
                // If the first element of the array is equal to 'STUDENT'
                if ( indexLineArray[0].equals("STUDENT") ) {
                    // If the array passes the validation test (true = pass)
                    if ( processStudentData( indexLineArray ) ) {
                        // If the second element of the array contains the string 'ADD'
                        if ( indexLineArray[1].equals("ADD")){

                            // Instantiate 'ADD' student constructor
                            studentAddObject = new Student( 
                                indexLineArray[2],indexLineArray[3], 
                                indexLineArray[4], indexLineArray[5]);

                            // Print the ADD student object (This will be deleted later)
                            System.out.print( studentAddObject.toString() );  

// ******************************************************************************** 
                                //ROSCOE METHOD ADD Student to list "INSERT HERE"
// ********************************************************************************  

                            } // End if
                        // If the second element of the array contains the string 'DEL'   
                        else if ( indexLineArray[1].equals("DEL") ) {

                            // Instantiate 'ADD' student constructor
                            studentDelObject = new Student( 
                                indexLineArray[2],indexLineArray[3], 
                                indexLineArray[4], indexLineArray[5]);

                            // Print the DEL student object (This will be deleted later)   
                            System.out.print( studentDelObject.toString() ); 

// ********************************************************************************                                    
                            //ROSCOE METHOD DEL Student to list "INSERT HERE" 
// ********************************************************************************   

                            } // end else if

                        // If 'ADD' or 'DEL' were not he second element of the array print error    
                        else {
                            System.err.println("'ADD' or 'DEL' is not the first data entry.\n" + 
                            "The following line will be disregarded\n" + 
                            java.util.Arrays.toString(indexLineArray));
                            } // End else
                        } // End if

                    // If the array did not pass the student validation test 
                     else {  
                        System.err.println("Student data is not valid.\n" + 
                        "The following line will be disregarded\n" + 
                        java.util.Arrays.toString(indexLineArray)); 
                        } // End else
                    } // End if
                
                // If the first element of the array is equal to 'GRADE ITEM'
                else if ( indexLineArray[0].equals("GRADE ITEM") ) {
                    // If the array passes the validation test (true = pass)
                    if ( processGradeItemData( indexLineArray ) ) {
                        // If the second element of the array contains the string 'ADD'
                        if ( indexLineArray[1].equals("ADD")){

                            // Instantiate 'ADD' grade item constructor
                            gradeItemAddObject = new GradeItem( 
                                indexLineArray[2], Integer.parseInt( indexLineArray[3] ), 
                                indexLineArray[4], indexLineArray[5],
                                indexLineArray[6], Integer.parseInt( indexLineArray[7] ),
                                Integer.parseInt( indexLineArray[8] ) );

                                // Print the ADD grade item object (This will be deleted later)
                                System.out.print( gradeItemAddObject.toString() ); 

// ********************************************************************************                                       
                                //ROSCOE METHOD ADD Grade Item to list "INSERT HERE"
// ********************************************************************************  

                            } // End if
                          
                        // If the second element of the array contains the string 'DEL'    
                        else if ( indexLineArray[1].equals("DEL") ) {

                            // Instantiate 'DEL' grade item constructor
                            gradeItemDelObject = new GradeItem( 
                                indexLineArray[2], Integer.parseInt( indexLineArray[3] ), 
                                indexLineArray[4], indexLineArray[5],
                                indexLineArray[6], Integer.parseInt( indexLineArray[7] ),
                                Integer.parseInt( indexLineArray[8] ) );

                            // Print the DEL grade item object (This will be deleted later)
                            System.out.print( gradeItemDelObject.toString() );  

// ********************************************************************************                                   
                            //ROSCOE METHOD DEL Grade Item to list "INSERT HERE" 
// ******************************************************************************** 

                            } // end else if

                        // If 'ADD' or 'DEL' were not he second element of the array print error   
                        else {
                            System.err.println("'ADD' or 'DEL' is not the first data entry.\n" + 
                            "The following line will be disregarded\n" + 
                            java.util.Arrays.toString(indexLineArray));
                            } // End else
                        } // End if
           
                    // If the array did not pass the grade item validation test 
                    else {  
                        System.err.println("Grade item data is not valid.\n" + 
                        "The following line will be disregarded\n" + 
                        java.util.Arrays.toString(indexLineArray));  
                        } // End else
                    } // End if

                // If 'STUDENT' or 'GRADE ITEM' were not the first element of the array print error
                else{
                    System.err.println("'STUDENT' or 'GRADE ITEM' is not the first data entry.\n" + 
                    "The following line will be disregarded\n" + 
                    java.util.Arrays.toString(indexLineArray));
                } // End else
            } // End while

            // Close the scanner
            input.close();

        } //End try
        // Catch block to throw exception if the file is not found
        catch ( FileNotFoundException e ) {
            System.err.println( "The file " + e.getMessage() );
            } // End catch
    } // End main class

// ********************************************************************************    
	/** Helper method to check validity of student data from an array
   
    * @throws, IllegalArgumentException -if any of the student constructor's 
                                         parameter are not met
    * @throws, System.err.println       -if 'ADD' is not the second element 
                                         of the array
    * @param,  studentArray             -Array argument passed                        
	* @param,  studentValidate          -local instance of student object created 
                                         to validate argument array
	* @return, true                     -if student data is valid                                        
	*/                
  private static boolean processStudentData( String[] studentArray )  
                                            throws IllegalArgumentException {
        
        // Check to see if 'ADD' is in the first element of the studentArray
        if ( ! studentArray[1].equals( "ADD" ) && ! studentArray[1].equals( "DEL" ) ) {
            System.err.println( "'ADD' is not the second data entry of the line" );
            return false; 
            } // End if

        else  {
            try {     
                    Student studentValidate = new Student( 
                         studentArray[2], studentArray[3], 
                         studentArray[4], studentArray[5]);
                } // End try

            catch ( IllegalArgumentException i ) {   
                    System.err.println( i );
                    return false;
                } // End catch

            return true;
         } // End else 
   } // End processStudentData
    
// ********************************************************************************    
  /** Helper method to check validity of grade item data from an array
   
    * @throws, IllegalArgumentException -if any of the grade item constructor's 
                                         parameter are not met
    * @throws, System.err.println       -if 'ADD' is not the second element 
                                         of the array
    * @param,  gradeItemArray           -Array argument passed 
	* @param,  gradeItemValidate        -local instance of grade item object 
                                         to validate argument array
	* @return, true                     -if student data is valid                                        
	 */                
  private static boolean processGradeItemData( String[] gradeItemArray ) 
                                                throws IllegalArgumentException{
        
        // Check to see if 'ADD' is in the first element of the gradeItemArray
        if ( ! gradeItemArray[1].equals( "ADD" ) && ! gradeItemArray[1].equals( "DEL" ) ) {
            System.err.println( "'ADD' is not the second data entry of the line" );
            return false; 
            } // End if

        else {
            try {     
                GradeItem gradeItemValidate = new GradeItem( 
                    gradeItemArray[2], Integer.parseInt( gradeItemArray[3] ), 
                    gradeItemArray[4], gradeItemArray[5],
                    gradeItemArray[6], Integer.parseInt( gradeItemArray[7] ),
                    Integer.parseInt( gradeItemArray[8] ) );
                } // End try

            catch ( IllegalArgumentException i ) {
                System.err.println( i );
                return false;
                } // End catch
            return true;  
            } // End else
    } // End processGradeItemData







    






} // End class List
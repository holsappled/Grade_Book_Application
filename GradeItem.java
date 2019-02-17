/**
*DerekHolsapple_01 
*This program uses a class to hold
*student's Id, grade item, course Id, item type, date, 
		maximum score, and actual score.
*Item type must be HW, Quiz, Class Work, Test, or Final

*@author Derek Holsapple
*@version 01, CS 2050
*Mac_OS, Intel Core m3, jGRASP

*Superannuated: adj., obsolete through age or new technological or intellectual
						developments.
*  
*"The best author will be the one who is ashamed to become a writer." 
*FRIEDRICH NIETZCHE
*/

import java.util.Arrays;

public class GradeItem {

    private String studentId; // Student's Id
    private int gradeItem;    // Student's grade item number
    private String courseId;  // School course Id number
    private String itemType;  // Grade item type, this will be stored as an array
    private String date;      // Date grade was recorded
    private int maxScore;     // Maximum score allowable on a test, must be > 0
    private int actualScore;  // Actual score of grade, must be < maximum score

    // Array to store the item types
    private String[] itemTypeArray = { "HW" , "Quiz" , "Class Work" , 
										"Test" , "Final" } ; 

// ********************************************************************************

   /** Constructor initializes an object of GradeItem class. All
          fields are initialized using value passed through parameter.
     * 
     * @param studentId,	  string   -Student identification number
     * @param gradeItem, 	  int      -Grade item number of assignment
     * @param courseId, 	  string   -Course identification number 
     * @param itemType, 	  string   -Item types are: HW, Quiz, Class Work,
                                          Test, or Final
     * @param date, 		     string   -Date that grade was given
     * @param maxScore,		  int      -Maximum score on assignment. 
                                          The maximum score must be greater than 0.
     * @param actualScore,   int      -Actual score on the assignment
                                          The actual score must be less than the
                                          maximum score.  The actual score must be
                                          greater than 0.
     * @param itemTypeArray, array    -Array that stores the itemTypes as elements 
     * @throws IllegalArgumentException for any missing data
     */
    public GradeItem(String studentId, int gradeItem, 
                     String courseId, String itemType, 
                     String date, int maxScore, 
                     int actualScore) {
    	
    	// Verify there is no missing data
        if ( studentId.equals( "" ) ) {
            throw new IllegalArgumentException( "Error: You need to enter "
                             + "a student Id." );
        } // End if 
        else if ( courseId.equals( "" ) ) {
        	throw new IllegalArgumentException( "Error: You need to enter " 
                             + "a course Id." );
        } // End else if 
        else if ( itemType.equals( "" ) ) {
        	throw new IllegalArgumentException("Error: You need to enter "
                             + "a item type.\nPlease enter one of the" 
                             + "following HW, Quiz, Class Work, Test, or Final" );
        } // End else if 
        else if ( date.equals( "" ) ) {
        	throw new IllegalArgumentException( "Error: You need to enter "
                             + "a date when the assignment was given." );
        } // End else if 

       
        // Verify the "item" entered is inside the itemType array 
        else if( ! Arrays.asList(itemTypeArray).contains(itemType) ) {  
            throw new IllegalArgumentException( "Error: Your item type was "
						      + "not an acceptable input."
                        + " \nPlease enter one of the following: "
                        + "HW, Quiz, Class Work, Test, or Final" ) ;
        } // End else if 

        // Verify the maxScore entered is below 0
        else if ( maxScore < 0 ) {
            throw new IllegalArgumentException( "Error: Your maximum score must be"
						      + " greather than 0" );
        } // End else if 

        // Verify the user's actualScore is not below 0 or above the maxScore
        else if ( actualScore < 0 || actualScore > maxScore ) {
            throw new IllegalArgumentException( "Error: Your actual score must be "
						      + "between 0 and the maximum score") ;
        } // End else if 
        else {
            this.studentId = studentId ;
            this.gradeItem = gradeItem ;
            this.courseId = courseId ;
            this.itemType = itemType ;
            this.date = date ;
            this.maxScore = maxScore ;
            this.actualScore = actualScore ;
        } // End else   
    } // End gradeItem constructor
    
// ********************************************************************************
	/** Get method for studentId 
	  * @return, student Id
	  */  
    public String getStudentId() {
    	
        return studentId ;
    } // End getStudentId

// ********************************************************************************
   	/** Get method for grade item number 
   	  * @return, grade item
   	  */  
    public int getGradeItem() {
    	
        return gradeItem ;
    } // End getGradeItem
    
// ********************************************************************************
   	/** Get method for grade course Id
   	  * @return, course Id
   	  */ 
    public String getCourseId() {
    	
        return courseId ;
    } // End getCourseId
    
// ********************************************************************************
   	/** Get method for grade item type 
   	  * @return, item type
   	  */ 
    public String getItemType() {
    	
        return itemType ;
    } // End getItemType
    
// ********************************************************************************
   	/** Get method for date 
   	  * @return, date
   	  */ 
    public String getDate() {
    	
        return date ;
    } // End getDate
    
// ********************************************************************************
   	/** Get method for grade maximum score 
   	  * @return, maximum score
   	  */ 
    public int getMaxScore() {
    	
        return maxScore ;
    } // End getMaxScore
    
// ********************************************************************************
   	/** Get method for actual score 
   	  * @return, actual score
   	  */ 
    public int getActualScore() {
    	
        return actualScore ;
    } // End getActualScore
    
// ********************************************************************************
   	/** Get method for grade item type array
   	  * @return, item type array, memory location
   	  */  
    public String[] getItemTypeArray() {
    	
        return itemTypeArray ;
    } // End getItemTypeArray
    
// ********************************************************************************
   /** Comparing two grade items to verify same data 
  	  * @param ,  object    -local object variable to compare against another object
  	  * @return,  true      -if two grade item's data are equal
  	  */ 
    public boolean equals(GradeItem other) {
  		
        // Use equals() to evaluate the strings  
        // Check every argument of each object and compare 
        if (studentId.equals( other.getStudentId() ) 
            && gradeItem == other.getGradeItem()  
        		&& courseId.equals( other.getCourseId() )
        		&& itemType.equals( other.getItemType() )
        		&& date.equals( other.getDate() ) 
        		&& maxScore == other.getMaxScore()
        		&& actualScore == other.getActualScore() ) { 
            return true ; 
        } // End equals()
        else {
        return false ;
        }// End else
    } // End equals

// ********************************************************************************
  	/** Converting a student's grade item data to a string
  	 * @return, string  -converting student's grade item data to a string
  	 */
    public String toString() {
        return "Student ID: " + studentId +       // Student's Id
               "\nGrade Item: " + gradeItem +     // Grade item number
               "\nCourse ID: " + courseId +       // Course Id number
               "\nItem Type: " + itemType +       // Grade item type
               "\nDate: " + date +                // Grade date
               "\nMaximum Score: " + maxScore +   // Maximum score allowable
               "\nActual Score: " + actualScore ; // Student's actual score
    } // End toString
} // End class


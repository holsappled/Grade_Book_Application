/**
*DerekHolsapple_01 
*This program uses a class to hold 
*student's ID, first name, last name, and email

*@author Derek Holsapple
*@version 01, CS 2050
*Mac_OS, Intel Core m3, jGRASP

*Coalesce: verb, Come together and form one mass or whole
* 
*"A person who never made a mistake never tried anything new."
*ALBERT EINSTEIN
*/
public class Student {
	
   private String studentId;           // Student's Id
   private String firstName;           // Student's first name
   private String lastName;            // Student's last name
   private String email;				   // Student's email
// ********************************************************************************
 /** Constructor to store and validate data.  
    @param studentId,  string    -Student's Identification Number
    @param firstName,  string    -First name of student
    @param lastName,   string    -Last name of student
    @param email,      string    -Email of student 
    @throws IllegalArgumentException if any missing data
 */
   public Student( String studentId, String firstName, 
   				String lastName, String email ) {
    	
    	// Verify there is no missing data
      if ( studentId.equals("") )  {
         throw new IllegalArgumentException( "Error: You need to enter a " +
                                             "student Id." );            
      } // End if 
      else if ( firstName.equals("") ) {
         throw new IllegalArgumentException( "Error: You need to enter a " +
                                             "first name." );
      } // End else if 
      else if ( lastName.equals("") ) {
         throw new IllegalArgumentException( "Error: You need to enter a " +
                                               "last name." );
      } // End else if 
      else if ( email.equals("") ) {
         throw new IllegalArgumentException( "Error: You need to enter " +
                                             "a email." );
      } // End else if 
      else if( ! email.contains("@") ) {
         throw new IllegalArgumentException( "Error: Your email does " +
                                             "not contain '@'." );      
      } // End if else Student()    
      else {
         this.studentId = studentId;
         this.firstName = firstName; 
         this.lastName = lastName;
         this.email = email;
      } // End else
   } // End student constructor  
   
// ********************************************************************************
	/** Get method for studentId 
	  * @return, student Id
	  */
   public String getStudentId() {
    	
      return studentId;
   } // End getStudentId
   
// ********************************************************************************
	/** Get method for first name
	 * @return, first name
	 */
   public String getFirstName() {
    	
      return firstName;
   } // End getfirstName

// ********************************************************************************
	/** Get method for last Name
	 * @return, last name
	 */
   public String getLastName() { 
    	
      return lastName;
   } // End getLastName

// ********************************************************************************
	/** Getter for email 
	 * @return, email address 
	 */
   public String getEmail() { 
    	
      return email;
   } // End getEmail

// ********************************************************************************
	/** Comparing two students to verify same data
	 * @param,   object    -local object variable to compare against another object
	 * @return,  true      -if two student's data are equal
	 */
   public boolean equals(Student other) {
      // use equals() to evaluate the strings 
      // check every argument of each object's constructor to compare strings
      if (this.studentId.equals( other.getStudentId() )
        		&& this.firstName.equals( other.getFirstName() )
        		&& this.lastName.equals( other.getLastName() )
        		&& this.email.equals( other.getEmail() )) {
         return true; 
      } // End if
      else {    
         return false; 
      } // End else
   }// End equals
   
// ********************************************************************************
	/** Converting a student's data to a string
	 * @return, string  -converting student's data to a string
	 */
   public String toString() {
      return "Student Id: "+ studentId +    // Student's Id
            "\nFirst Name: " + firstName +  // Student's first name 
            "\nLast Name: " + lastName +    // Student's last name
            "\nEmail: " + email;            // Student's email
   } // End toString
} // End class

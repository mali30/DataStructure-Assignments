/**
 * Created by Mohamed Ali
 * October 15, 2017
 * Assignment 4
 * Mr.Bhola
 * Data Structure
 
 Purpose of the Program:
 To gain experience with input/output in Java along with Linked List.


/**Solution of Program
 This program stores three things/strings: first name, last name, and phone number
 Will prompt user to enter a command. When the user hits the command,
 it will either do the command it is set to or it will say the command is invalid and let the user
 pick another command. The program has three linked list: first name, last name, and phone number.
  I'm going to explain each command...



 Description of Program:
 
 a: Show all records
If the user hits "a", it will make a myrecordsmoedir list (based on the linked list I created),
and make a myrecords node and takes the elements in the linked list and create them into
 myrecords nodes and where it inserted into a link list in alphabetical order based on last name
 

 d: Delete the current record
 If the user hits "d", it will remove the latest/selected linked list element created or the very end of it

 f: Change the first name in currentmoedir
 If the user hits "f", the console will ask what the user wants the first name changed to
 the latest/selected element in the first name linked list

 l: Change last name in currentmoedir
 If the user hits "l", the console will ask what the user wants the last name changed to
 the latest/selected element in the last name linked list

 n: add a new record
 The user will be asked for a first name, last name, and phone number. It it will put the information
 that is entered into their proper linked lists and set it as the current selected one

 p: Change phone number
 If the user hits "p", the console will ask what the user wants the phone number changed to
 the latest/selected element in the myrecords linked list


 s: Select a record from the list to become current record
 The user enters a first name and last name for the linked list to search in the first name
 and last name linked lists then it will set the the linked list as the current, and also shift
 the index to the bottom so it can be the current one
 
  q: quit
 The program will terminate and the data the user has entered will be gone


 The Data Structure that I use in this Program is: LinkList

 */
package bholaWork;


import java.util.*;
import java.util.Scanner;


class phonedir{
	public static void MainMenu(){
    	System.out.println("Show all records");
        System.out.println( "Delete the current record");
        System.out.println("Change first name in the current record");
        System.out.println( "Change last name in the current record");
        System.out.println( "Add a new record");
        System.out.println( "Change the phone number in the current record");
        System.out.println( "Quit");
        System.out.println( "Select a record from the record list to become the current record");
        System.out.println();
        System.out.println("Enter a Command from the list above: ");
        
   }
public static void main(String[] args) {
	Scanner scan= new Scanner(System.in);
	LinkedList<moesrecord>moedir = new LinkedList<moesrecord>();
	
	String fname;
	String lname;
	String number;
	
	moesrecord myfind= new moesrecord();
	moesrecord myempty= new moesrecord();
	moesrecord myp= new moesrecord();
	
	
	moesrecord current = new moesrecord();

	String myswitch = "";		
	while(!myswitch.equals("q"))
	{
		System.out.println("Current record is: "+current);	
 MainMenu();
 myswitch = scan.nextLine();
 
 
 switch(myswitch){
 case "a" : 
	 
	 System.out.println("First Name" + "\t" + "   Last Name"+"\t"+ "     Phone Number" );
     System.out.println();
     System.out.println();
     System.out.println("----------" + "  \t  "+ "  ----------"+"  \t  "+"     -----------");

	 
	 MoesPrint(moedir);
	 System.out.println("\n\n\n");
	 break;
	 
 case "d" :
	 System.out.println("Deleted: "+current);
	moedir.remove(current);
	 current=myempty;
	 break;
	 
 case "f" :
	 System.out.println("Pleas specify the new first name?");
	 fname = scan.nextLine();
	 current.setFirstName(fname);
	 moesrecord Temp= current;
	moedir.remove(current);
	 MoesAddCust(Temp,moedir);
	 current=Temp;
	 break;
	 
 case "q" : 
	 break;
	 
 case "l" : 
 System.out.println("Please scpecify the new last name?");
 lname = scan.nextLine();
 current.setLastName(lname);
 Temp= current;
moedir.remove(current);
 MoesAddCust(Temp,moedir);
 current=Temp;
 break;
 
 case "n" : 
	 System.out.println("What is the first name?");
	  fname = scan.nextLine();
	 System.out.println("What is the last name?");
	  lname= scan.nextLine();
	 System.out.println("What is the number?");
	  number = scan.nextLine();	  
	  myp= new moesrecord(fname,lname,number);
	  current=myp;
	  MoesAddCust(myp,moedir);
	  System.out.println();
	  System.out.println();
	  System.out.println();
	 break;
	 
 case "p" : 
 System.out.println("What is the new phone number?");
 number = scan.nextLine();
 current.setNumber(number);
 Temp= current;
moedir.remove(current);
 MoesAddCust(Temp,moedir);
 current=Temp;
	 break;
	 
	 
 case "s" :
	 System.out.println("Please specify who the current record should be?");
	 System.out.println("What is the first name?");
	  fname = scan.nextLine();
	 System.out.println("What is the last name?");
	  lname= scan.nextLine();
	 System.out.println("What is the phone number?");
	  number = scan.nextLine();
	 myfind= new moesrecord(fname,lname,number);
	 if(MoesFindRecord(myfind,moedir)>=0){
		 current=moedir.get(MoesFindRecord(myfind,moedir));
	 } else {System.out.println("Sorry. There are no matching records found!");}
	 break;
	 
	default :
		System.out.println("Sorry.That was not a command!") ;	
	 
	 
 }
}
	}

/**Purpose: The method will print the records in the Addressbook
* Pre: This method will accept an 
* Post: The method uses a foor loop to iterate through the LinkList and print out each record that
* is in it
*/
    public static void MoesPrint(LinkedList<moesrecord> mydata){
    	for(int i = 0; i<mydata.size();i++){
    		System.out.println(mydata.get(i));
    	}
    }
    /**Purpose: The method will add a new record into the AddressBook
    * Pre: This method requires an object of moesrecord and of LinkList
    * Post: The method will compare and add the new record into the Addressbook*/
    
    public static void MoesAddCust(moesrecord x, LinkedList<moesrecord> al){
 
    	if(al.size()==0){al.add(x);}
    	for(int i=0;i<al.size();i++){
    		if(x.compareTo(al.get(i))<0){
    			al.add(i, x);    	
    			break;
    			
    			} 
    		} if(x.compareTo(al.get(al.size()-1))>0){al.add(x);}
    			
    	
    			
    			} 
    /**Purpose: The method will find a record in the AddressBook
    * Pre: The method takes an object of moesrecord and of LinkList
    * Post: The method will iterate through the records and locate the specified name
    */
    public static int MoesFindRecord(moesrecord ch,LinkedList<moesrecord> ma){
    	for(int i=0;i<ma.size();i++){
    		if(ch.compareTo(ma.get(i))==0)
    		{return i;} 
    	} 
    	return -1;
    		
    	}

    }
	

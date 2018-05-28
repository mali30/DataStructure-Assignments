
 
/**Solution of Program
 This program will will prompt user to enter either yes or no. When the user hits Y or y, it will run the program.
MY PROGRAM RUNS IN THE BACKGROUND AND WILL PRINT THE FINAL RESULTS WHEN 2 MINUTES PASS BY!
THIS MEANS WHEN YOU RUN THE PROGRAM YOU WILL NOT SEE ANYTHING UNTIL 2 MINUTES GO BY. YOU WILL
THEN SEE THE OUTPUT.
if the user hits no, it will exit the program. If he/she enters anything other than Y or y, it will exit.
 
 
Purpose of Program:

    -To gain experience with with Queues.
    -To gain experience with library functions that generates random numbers and provide time.
    -To use arrays. 
 
 *  Description of Program:

You are to write a program name bank.java that simulates a bank. The program will prompt the user asking if they want to run the program again. If yes, then start the program over. If no, then terminate the program. Note: use the array to store the 5 tellers.

The execution phase run for 2 minutes (must invoke a clock in your program) during which time customers will arrive randomly between 2 - 6 seconds and be placed into a queue. Each customer will have a property relating to the amount of time he/she wants to spend with a teller, which is to be randomly generated to be between 2 and 5 seconds.

There would be a maximum of 5 tellers to attend to the customers. When you start the simulation, each teller is occupied.You will need to generate a random time for each of the first 5 customers occupying the tellers at the begining of the 2 minutes simulation.

As they finish attending a customer (based upon the amount of time associated with each customer), that teller becomes available for the next customer in the queue. As a customer is removed from the queue and sent to an "available" teller, then their availability is set to "False". Customers are allocated to any one of the 5 tellers that becomes available, and so on... until the time of 2 minutes for the simulation is finished.

If after 2 minutes, there are still customers in the queue, we would discard them, but still count them in the total count of customers that visited the bank. Also add into the total count of customer the first five customers that the tellers started out with as well as to the individual teller's total.

Finally display on the screen (at the end of each execution):

    1. The total amount of customers that visited the bank for that 2 minutes.
    2. The total amount of customers that each teller helped.
    3. The total amount of time that each teller was occupied.
    4. The total amount of customers that did not get to see a teller. 
    
    DataStructures used in the Program: LinkList, Queue, Array
    
    
 */

import java.util.*;



	public class bank{ 
		
		   private int moecustomers;                                             
		    private mytellerclass[] moetellers;                                           
		    private Queue<Integer> moecustomer;                                  
		     
		    public bank() {
		        moecustomers = 0;                                                 
		        moetellers = new mytellerclass[5];                                        
		        moecustomer = new LinkedList<Integer>();                        
		    }
		    
		    
		    
		    public static void main(String[] args) {
		        Scanner scan = new Scanner(System.in);
		        bank mybigbank;
		        String userinput = "";
		         
		        do {
		        		 
		           mybigbank = new bank();
		             mybigbank.myrun();
		            System.out.println();
		            System.out.print("Do you want to run the program again? (y for yes, n to quit) ");
		            userinput = scan.next();
		        } while(userinput.equals("Y") || userinput.equals("y"));
		    }
	
		     
		    public void myrun() {
		        
		         
		        Random moerandom = new Random();
		        long current = System.currentTimeMillis();                      
		        long stop = current + (120*1000);                               
		        int ctime;                                                      
		        long newcust = current + ((moerandom.nextInt(5) + 2) * 1000);       
		        int myends;                                                      
		         
		         
		        for (int i = 0; i < 5; i++) {                                    
		            moetellers[i] = new mytellerclass();                                  
		            ctime = moerandom.nextInt(4) + 2;                                
		            moetellers[i].setFinish(current + (ctime*1000));                 
		            moetellers[i].setTel(ctime);                                 
		            moetellers[i].setCust(1);                                     
		        }
		             
		        while (System.currentTimeMillis() < stop) {                      
		            for (int i = 0; i < 5; i++) {
		                current = System.currentTimeMillis();                   
		                 
		                if (current > newcust) {                             
		                 // added sysout here 
		                	moecustomer.add(1);                                    
		                    newcust = current + ((moerandom.nextInt(5) + 2) * 1000); 
		                }
		                 
		                if (current > moetellers[i].getFinish())                      
		                    moetellers[i].isBankFree(true);                           
		                 
		                if (moetellers[i].isbankfree()) {                              
		                    if (moecustomer.peek() != null) {                      
		                        myends = moecustomer.poll();                        
		                        ctime = moerandom.nextInt(4) + 2;                    
		                        moetellers[i].setFinish(current + (ctime*1000));     
		                        moetellers[i].setTel(moetellers[i].getTel() + ctime);     
		                        moetellers[i].setCust(moetellers[i].getCust() + 1);         
		                    }
		                }
		            }
		        }
		         
		        for (int i = 0; i < 5; i++) {                                    
		            moecustomers += moetellers[i].getCust();                        
		            System.out.println("Teller " + (i+1) + ": " + moetellers[i]);
		        }
		         
		        int count = 0;      
		        while (moecustomer.peek() != null)
		            count += moecustomer.poll();                 
		         
		        System.out.println("Customers that did not get to see a teller: " + count);
		        System.out.println("Customers that visited the bank: " + (moecustomers + count));
		    }
		             
	
	}

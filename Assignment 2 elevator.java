/**
 * Created by MohamedAli on 9/13/17.
 * Data Structures
 * Teacher: Mr.Bhola
 * Assignment 2
 * Elevators.java
 */

/**
 * Conditions to Meet:
 * Create a new Arraylist for up
 * Create a new ArrayList for down
 * Populate the up arraylist with 8 random floors
 * Display up unsortted array
 * Sort the up array
 * Display the sorted up array
 * Specify the last element of the up array and use it as the first element of the down array
 * Generate the remaining 4 elements required...and make sure that they're less than the element you
 *  just entered. So if max floor on up was 7, your maximum should be 7.
 * Sort the down arraylist in descending order
 * Loop through the up array, and check to see if the next floor is exactly 1 floor away
 * Repeat the same for going down
 *
 *
 * For all of the methods that you create, write:
 * Precondition: conditions neccsary for you to run that method
 * describing form of paramater, what values they take, if you will use any class variable
 * or if the method makes assumption
 * Postcondition: What happens to your variable if the class variable changes
 * What does the method produce.
 *
 *
 * Purpose of Program: write a program name elevator.java that simulates one elevator services in a
 * 12-floor building. NOTE: There is only one elevator working this building.
 *
 *
 */

// make array generate 8 floors instead of 12
import java.sql.Array;
import java.util.Collection;
import java.util.Comparator;
import java.util.*;
import java.lang.*;
import java.util.Random;
import java.util.ArrayList;
public class myelevator {

    public static int currentfloor = 1;

    /**
     * PreCondition:In order for this method to function properly, it will either take a boolean of true or false
     * I am using an ArrayList as one of my Data Structures
     * I am also using Math.Random to generate the random integers
     *
     * PostCondition:If true is passed as the argument, it will set a maxIdx of 9 and will randomly generate integers
     * for the bound of 13.(Array starts from 0 but I want it to start from 1 which is why the bound is 13)
     *It will then check for duplicates by checking if morefloors is not contained in the results, which is the name of the array
     * If there isnt a duplicate, then it will add that randomly generated number into the array,result
     * If the argument passed is false, it will take take a maxIdx of 6 and do the same as the step above
     * It will also check for duplicates.
     * It will then return results
     *
     */
    public static ArrayList<Integer> getFloors(boolean bUp) {
        Random myrandom = new Random();
        ArrayList<Integer> result = new ArrayList<Integer>();
        int maxIdx;
        if (bUp) {
            maxIdx = 9;
            for (int i = 1; i < maxIdx; i++) {
                int morefloors;
                morefloors = myrandom.nextInt(11) + 2;
                // up.add(currentfloor);


                if (!result.contains(morefloors)) {
                    result.add(morefloors);
                    //result.add();


                } else {
                    i--;
                }
            }

            return result;

        } else {
            maxIdx = 6;
            for (int i = 1; i < maxIdx; i++) {
                int myfloors;
                myfloors = 1 + myrandom.nextInt(12);

                if (!result.contains(myfloors)) {
                    result.add(myfloors);
                    //result.add();


                } else {
                    i--;
                }
            }

            return result;

        }
    }


    /**
     * Purpose: What's the point of the method?
     * Precondition: What you are using and how
     * Postcondition: What your method does
     * Invariant: condition that does not change
     *
     * Precondition: In order for this method to function, it will take an ArrayList of choice and a boolean value of true or false
     * I am using an ArrayList as my Data Structure.
     * PostCondition: When the ArrayList of type Integer is passed with a boolean value of true or false,
     * the method will either do one of two things. If the boolean value is true, it will sort the ArrayList that you passed
     * In ascedning order by using Collections.sort
     * If the it is false, the method will sort the ArrayList you pass in descending order by using Collections.reverserder()
     *
     *
     */
    public static ArrayList<Integer> mysorted(ArrayList<Integer> sortannother, boolean bUp) {
        if (bUp) {
            Collections.sort(sortannother);
        } else {
            Collections.sort(sortannother, Collections.reverseOrder());
        }
        return sortannother;

    }


    public static void main(String[] args)
            throws InterruptedException {

        boolean repeat = true;
        while (repeat) {
            ArrayList<Integer> ascension = getFloors(true);


            int nextfloor;
            int nextstop;
            int i = 1;
            int goingup = 9;
            int j = 1;
            //int basefloor =1;

            System.out.println("Your unsorted array ascending array is " + ascension);
            System.out.println("Your sorted ascending array is " + mysorted(ascension, true));
            System.out.println("Starting at Floor 1");


            //Invariant currentfloor<=12

            while (!ascension.isEmpty() && currentfloor <= ascension.get(ascension.size() - 1)) {
                //currentfloor = currentfloor +1;
                System.out.println();
                //System.out.println("Going up: now at floor" + Integer.toString(currentfloor ));


                if (currentfloor == ascension.get(0)) {
                    ascension.remove(0);
                    System.out.println("Stopping at floor " + currentfloor + " for 3 seconds");
                    int currentsecond = 0;
                    while (currentsecond < 3) {
                        Thread.sleep(1000);
                        currentsecond++;
                        System.out.print(" " + Integer.toString(currentsecond));
                        System.out.print("");
                    }
                    //ascension.remove(currentfloor);
                    System.out.println();
                }
                currentfloor++;
                //todo: validate floor number
                if (currentfloor < 13) {
                    System.out.println("Going up: now at floor" + Integer.toString(currentfloor));
                }
            }
            //System.out.println("Going up: now at floor" + Integer.toString(currentfloor ));


            ArrayList<Integer> descension = getFloors(false);


            System.out.println("Your unsorted array descending is " + descension);
            System.out.println(" Your sorted array descending is " + (mysorted(descension, false)));

            //System.out.println(currentfloor);

            currentfloor--;
            while (!descension.isEmpty() && currentfloor > 0) {
                System.out.println("Starting at floor " + Integer.toString(currentfloor));
                //nextfloor = currentfloor +1;

                //Invariant k<=goingup

                if (currentfloor == descension.get(0)) {
                    descension.remove(0);
                    System.out.println("Stopping at floor " + currentfloor + " for 3 seconds");
                    int currentsecond = 0;
                    while (currentsecond < 3) {
                        Thread.sleep(1000);
                        currentsecond++;
                        System.out.print(" " + Integer.toString(currentsecond));
                        System.out.print("");
                    }
                    //ascension.remove(currentfloor);
                    System.out.println();
                }
                currentfloor--;
            }


	    System.out.println("Would you like run my program again?");
            System.out.println("Click y or yes  to continue.");
            System.out.println("Click n or no  to stop.");
             Scanner scan = new Scanner(System.in);
            String myuserinput =scan.nextLine();

            if (myuserinput.equals("y") || myuserinput.equals("yes") ) {
                repeat = true;



            } else{
                System.out.print("Thanks for playing!");
                repeat=false;
            }



        }

    }
}

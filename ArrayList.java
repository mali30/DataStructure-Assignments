/**
 * Created by Mohamed Ali on 9/28/17.
 * Data Structures
 * Teacher: Mr.Bhola
 * Assignment 3
 * ArrayList.java
 */

/**
Conditions to Meet:
 1.One default constructor that will create an ArrayList object with a default size (capacity) of 10 ------ public ArrayList();
 2.Another constructor that accepts a parameter of type int and sets the size to this parameter ---- public ArrayList(int n);
 3.A method that allows you to place a value at the end of the ArrayList ---- public void add(Object x);
 4.A method that allows you to place a value at a given location ---- public void add(int index, Object x);
 5.A method that allows you to retrieve a value from a given location ---- public Object get(int index);
 6.A method that allows you the number of elements in the the ArrayList ---- public int size();
 7.A method would test to see if the ArrayList is empty ---- public boolean isEmpty();
 8.A method that see if a particular object exist in the ArrayList --- public boolean isIn(Object ob);
 9.A method that will return the location of first occurrence of an Object starting from location 0 ----- public int find (Object n);
 10.A method that will remove the first occurrence of an Object starting from location 0 ----- public void remove (Object n);

 For all of the methods that you create, write:
 Precondition: conditions neccsary for you to run that method
 describing form of paramater, what values they take, if you will use any class variable
 or if the method makes assumption
 Postcondition: What happens to your variable if the class variable changes
 What does the method produce.

 Purpose of the Program:
 You are to write a program name ArrayList.java that create/build the ArrayList
 data Structure that exist in the java library. The class must be written to
 accept any type of Objects. The following must be implemented i.e. YOU must
 write the code (do not import them from the Java Library)

 */


public class ArrayList {

    private static final int mydeclaredsize = 10;

    private Object mydata[];

    private int initialindex;

    private int myogsize;

   /** PreCondition: constructor that sets a default size of 10
    * PostCondition: This will see the new declared Object equal to the initial size
    * of 10. It will then set the private int variable myogsize equal to 10.
    **/
    public ArrayList() {
        this.mydata = new Object[mydeclaredsize];
        this.myogsize = mydeclaredsize;
    }

    /** PreCondition: In order for this method to function properly, it will accept an int variable
     * PostCondition: It will then set the mydata object equal to the int paramter you pass.
     * It will then set the myogsize variable equal to the int that you pass in as the paramater
     **/

    // constructor that accepts int variable and sets size to paramater
    public ArrayList(int n) {
        this.mydata = new Object[n];
        this.myogsize = n;
    }

    /** PreCondition: In order for this method to function properly, you must pass an Object variable
     * PostCondition: It will then check if the variable initialindex is equal to the variable myogsize-1
     * If it is, it will increase the size of the array. It will then set the initialindex which is passed into
     * the mydata object equal to x. Then it will increment the initialindex.
     **/
    // allows you to place a value at the end of arrayList
    public void add(Object x) {
        if (this.initialindex == this.myogsize - 1) {
            //we need to increase the size of data[]
            increaseSizeandMoveIt();
        }
        mydata[this.initialindex] = x;
        this.initialindex++;
    }
    /** PreCondition: In order for this method to function, you will pass two parameters. The first
     * first paramater will be the index and the second will be a variable of type Object
     * PostCondition: It will then check if the initialindex is equal to myogsize -1. If it is
     * it will call the increaseSizeandMoveIt() method. Then a for loop to check
     **/

    // place value at a given location
    public void addgivenLocation(int index, Object x) {
        if (this.initialindex == this.myogsize - 1) {
            //we need to increase the size of data[]
            increaseSizeandMoveIt();
        }
        for (int i = this.initialindex; i >= index; i--) {
            mydata[i] = mydata[i - 1];
        }
        mydata[index] = x;
        this.initialindex++;
    }
    /** PreCondition: In order to function, the method accepts no paramaters
     * PostCondition: It will then set ogsize equal to itself plus mydeclaredsizez(which is equal to 10)
     * It will then make an array called newData and set it equal to the variable myogsize.
     * It will then loop through the mydata and set the new array elements equal to the mydata
     array which is of type Object**/


    private void increaseSizeandMoveIt() {
        this.myogsize = this.myogsize + mydeclaredsize;
        Object newData[] = new Object[this.myogsize];
        for (int i = 0; i < mydata.length; i++) {
            newData[i] = mydata[i];
        }
        this.mydata = newData;
    }
    /** PreCondition: In order to function, method accepts a int value
     * PostCondition: It will then check if the value passed is greather than initialindex-1.
     * If it is it will print the following. If it is less than 0, it will print the following.
     * If neither, will retrieve the value from the given location
     **/


    public Object get(int index){
        if (index > this.initialindex - 1) {
            System.out.println("ArrayIndexOutOfBound");
        }
        if (index < 0) {
            System.out.println("Negative Value");
        }
        return this.mydata[index];

    }
    /** PreCondition: In order to function, will accept an int variable
     * PostCondition: will then check if the int thats passed is greater than initialindex-1
     * If it is then will print out the following line. If it is less than 0, it wil print the following
     * line. If it is neither, it will then remove that number and decrement the length of
     * the array
     **/
    // remove first occurence of an object in the array
    public void remove(int i)  {
        if (i > this.initialindex - 1) {
            System.out.println("ArrayIndexOutOfBound");
        }
        if (i < 0) {
            System.out.println("Negative Value");
        }
        System.out.println("Object getting removed:" + this.mydata[i]);
        for (int x = i; x < this.mydata.length - 1; x++) {
            mydata[x] = mydata[x + 1];
        }
        this.initialindex--;
    }
    /** PreCondition: In order to function, will take an empty paramater
     * PostCondition: The method will return the size of the variable initialindex
     **/
        // gets the number of elements in the array
    public int size() {

        return this.initialindex;
    }
    /** PreCondition: In order to function, takes an empty paramater
     * PostCondition: The method will return the variable initialindex if it is greater
     * than 0
     **/

    // checks if the array is empty
    public boolean isEmpty() {

        return !(this.initialindex > 0);
    }
    /** PreCondition: In order to function, the method takes a boolean value.
     * PostCondition: will check if boolean value is not equal to -1 and return true if it is not
     * but false if it is
     **/
    // checks to see if a particular object is in the array
    public boolean isIn(Object ob) {
        if (find(ob) != -1)
            return true;
        else
            return false;
    }
    /** PreCondition: in order for this method to function, it must take a variable of type Object
     * PostCondition: Then a for loop that goes through our array and if the paramater you
     * pass is equal to an element in the array. it will return it. Else it will print out
     * Sorry not there
     **/

    public  int find(Object n) {

        for (int i = 0; i < initialindex; i++) {
            if (n.equals(mydata[i]))

                return i;
        }
        return -1;
    }



    public String toString(){

        if(size()==0)
            return "[]";

        StringBuilder mystring =new StringBuilder( "[" +get(0));
        for(int i=1;i<size();i++){
            mystring.append(","+ get(i));

        }
        mystring.append("]");
        return mystring.toString();

    }

}


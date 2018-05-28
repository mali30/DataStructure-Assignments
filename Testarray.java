import java.util.Scanner;
public class TestArray {

    public static void Test(ArrayList mynums)
    {
        System.out.println("Original array we begin with");
        System.out.println(mynums);


        mynums.add(5);
        System.out.println("Method that will add at the end of arrayList");
        System.out.println(mynums);

        mynums.addgivenLocation(1,100);
        System.out.println("Method that adds at a given location");
        System.out.println(mynums);

        System.out.println("Method that gets the number at the specified index");
        System.out.println(mynums.get(7));
        System.out.println("Method that prints the size of the arrayList");
        System.out.println(mynums.size());
        //System.out.println(mynums);
        System.out.println("Method that checks if arrayList is empty or not");
        System.out.println(mynums.isEmpty());
        System.out.println("Method that returns the location of the first Occurence");
        System.out.println(mynums.find(5));


    }

    public static void main(String[] args) {

        ArrayList mynums = new ArrayList();
        Scanner myscan = new Scanner(System.in);
        for (int i = 1; i <= 15; i++) {
            mynums.add(((int) (Math.random() * (25 - 1))) + 1);
        }
        //System.out.println(mynums);
        Test(mynums);


        int n;
        
        System.out.println("Please enter the initial size of the array");
        n = myscan.nextInt();


        ArrayList mynums2 = new ArrayList(15);
        Scanner myscan2 = new Scanner(System.in);


        for (int i = 1; i <= 15; i++)
            mynums2.add(((int) (Math.random() * (25 - 1))) + 1);
        Test(mynums2);
 


    }

}

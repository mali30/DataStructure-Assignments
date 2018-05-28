
/**
 *
 * Solution to Program:
 * /
 //Will promt thisuser to enter the infix equation or hit q to quit. When the thisuser enters the infix, it
 will convert it into a postfix expression. If the following examples below are passed, then the
 program will execute the following:

 Enter infix expression: 1 2 +
 Error in expression!! No operator between operands. Also last token must be an operand.

 Enter infix expression: 10.4
 Error in expression!! Cannot accept floating point numbers.

 Enter infix expression: 1 (  + 2)
 Error in expression!! No operator between operand and left parentheses.

 Enter infix expression: 5 – (x – 2))
 Error in expression!! No matching left parentheses for a right parentheses.

 Enter infix expression: 1 ** 2
 Error in expression!! The * operator cannot be preceded by a * operator.


 Purpose of the Program:
 To gain experience with the Stack Data Structure and the library


 // Description of Program:

 You are to write a program name calc.java that evaluates an infix expression entered by the thisuser. The expression may contain the following tokens:
 (1)   Integer constants (a series of decimal digits).
 (2)   x (representing a value to be supplied later).
 (3)   Binary operators (+, -, *, / and %).
 (4)   Parentheses


 The Data Structure that I use in this Program is:
    Stack Data Structure

 */
import java.util.*;
public class calculator {



        private Stack <Character> mystack;


        public static void main(String[] args) {

                calculator moe = new calculator();
                moe.execute();



        }






    /**
     * PreCondition:In order for this method to function properly, it will not take any paramaters
     *
     * PostCondition: When executed it will prompt the thisuser to enter the infix expression. The thisuser will
     * then enter and then it will ask for the value of X. It will then call the method evaluatePostfix and
     * will pass what the thisuser has enter for an infix and also for x
     */

        public void execute()
        {


            boolean a = false;
            while(!a) {

                System.out.println("Enter infix equation: \n");
                System.out.println("Click q to exit the program.");
                Scanner newscan = new Scanner(System.in);
                String temp = newscan.nextLine();

                if (temp.substring(0, 1).equalsIgnoreCase("q")) {
                    System.out.println("Thanks for playing!");
                    System.exit(0);
                } else {
                    String k = toPostfix(temp);
                    System.out.println("Enter a value for X: ");
                    int x = enteruser();
                    evaluatePostfix(k, x);
                }

            }




        }

    /**
     * PreCondition:In order for this method to function properly, it will not take any paramaters
     *
     * PostCondition: When executed it will take the value passed into str and return it
     */

        public String thisuser()
        {
            Scanner input = new Scanner(System.in);
            String str = input.nextLine();
            return str;
        }
    /**
     * PreCondition:In order for this method to function properly, it will not take any paramaters
     *
     * PostCondition: When executed it will take what the thisuser passes as the next int value
     */


        public int enteruser()
        {
            Scanner input = new Scanner(System.in);
            int in = input.nextInt();
            return in;
        }


    /**
     * PreCondition:In order for this method to function properly, it will take a String and int values
     *
     * PostCondition: When executed it will create a new stack of type Int. It will covert the int to string and
     * replace x with thisuser values
     */

        public void evaluatePostfix(String str, int x)
        {
            Stack<Integer> stack = new Stack <Integer>();
            String number1 = "";
            String number2 = "";
            int op, op2, op3;
            int mycount = 0;
            //changed all three below
            String mystring = "";
            int myresult = 0;
            char myprevious = str.charAt(0);

            String var = Integer.toString(x);
            str = str.replaceAll("x",var);


            for (int j =0;j<str.length(); j++)
            {
                char mychar = str.charAt(j);
                if(mychar==' ' && isOperator(myprevious))
                {
                    continue;
                }

                if(isOperator(mychar) && myprevious==' ')
                {
                    mystring = mystring.substring(0,mystring.length()-1) + mychar;
                }
                else mystring += mychar;
                myprevious = mychar;
            }

            myprevious = mystring.charAt(0);

            for(int i = 0; i<mystring.length(); i++)
            {
                char my2char = mystring.charAt(i);

                if(isthisOp(my2char))
                {
                    if(mycount%2==0)
                    {
                        number1 += my2char;
                    }
                    else
                    {
                        number2 += my2char;
                    }
                }

                else if(my2char==' ' && mycount%2==0 || !isOperator(myprevious) && isOperator(my2char) && mycount%2==0)
                {
                    mycount++;
                    op3 = Integer.parseInt(number1);
                    stack.push(op3);
                    number1 = "";
                }

                else if(my2char==' ' && mycount%2!=0 || !isOperator(myprevious) && isOperator(my2char) && mycount%2!=0)
                {
                    mycount++;
                    op3 = Integer.parseInt(number2);
                    stack.push(op3);
                    number2 = "";
                }

                if(isOperator(my2char))
                {
                    op2 = stack.peek();
                    stack.pop();

                    op = stack.peek();
                    stack.pop();

                    switch (my2char)
                    {
                        case '/': myresult = op / op2; break;
                        case '*': myresult = op * op2; break;
                        case '^': myresult = (int) Math.pow(op, op2); break;
                        case '+': myresult = op + op2; break;
                        case '-': myresult = op - op2; break;
                        case '%': myresult = op % op2; break;
                        default:
                            break;
                    }
                    stack.push(myresult);
                }

                myprevious = my2char;
            }

            myresult = stack.peek();
            stack.pop();

            System.out.println("The myresult is: "+myresult+"\n");
        }
    /**
     * PreCondition:In order for this method to function properly, it will take a paramater of type char
     *
     * PostCondition: When executed it will check to see if the character is an operand or not
     *
     */


        public boolean isthisOp(char c)
        {
            if(c >= '0' && c <= '9') return true;
            if(c >= 'a' && c <= 'z') return true;
            if(c >= 'z' && c <= 'Z') return true;
            else return false;
        }

    /**
     * PreCondition:In order for this method to function properly, it will take a paramater of type char
     *
     * PostCondition: When executed it will check to see if the operator that is passed is one of the
     * operators specified by our instructor.
     * */


        public boolean isOperator(char option)
        {
            switch(option)
            {
                case '+': return true;
                case '-': return true;
                case '/': return true;
                case '*': return true;
                case '%': return true;
                default: return false;
            }
        }

    /**
     * PreCondition:In order for this method to function properly, it will take a String value
     *
     * PostCondition: When executed it will convert what the thisuser passes into a postfix expression. It will
     * removes all white space from the String passed and make them all lowercase. It will Check the last character of the infix
     * expression. If it is an operator, it will inform the thisuser and terminates program. It will  check for periods within the string.
     * If a period is found, it will inform the thisuser and terminates program. It will check for missing operator between parentheses. If missing, informs the thisuser
     * and will terminate.  checks  if an operator is succeeded by another operator. If true, terminates program.
     * Lastly, it will check for missing parentheses. If missing, informs the thisuser and terminates program.
     */

    public String toPostfix(String str)
    {
        String postfix = "";
        String pfix = "";
        mystack = new Stack<Character>();
        int myrigh = 0;
        int myleft = 0;
        char myprev = str.charAt(0);

        str = str.replaceAll("\\s","");
        str = str.toLowerCase();

        for(int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);

            char last = str.charAt(str.length() - 1);


            if (isOperator(last))
            {
                System.out.print("\nError in expression!! Last token must be an operand.");
                System.exit(1);
            }


            if(str.indexOf('.') != -1)
            {
                System.out.print("\nError in expression!! Cannot accept floating point numbers.");
                System.exit(1);
            }

            if (isOperator(c))
            {
                if(myprev!=')'|| myprev!='(')
                {
                    pfix += " ";
                }


                if(myprev == '(')
                {
                    System.out.print("\nError in expression!! No operator between operand and myleft parentheses.");
                    System.exit(1);
                }


                if(isOperator(myprev))
                {
                    System.out.print("\nError in expression!! An operator cannot be preceded by another operator.");
                    System.exit(1);
                }

                while(!mystack.isEmpty() && mystack.peek()!='(' && moreimportant(mystack.peek(),c))
                {
                    postfix += mystack.peek();
                    pfix += mystack.peek();
                    mystack.pop();
                }
                mystack.push(c);
            }

            else if(isthisOp(c))
            {
                postfix += c;
                pfix += c;
            }

            else if( c =='(' )
            {
                myleft++;
                mystack.push(c);
            }

            else if( c ==')' )
            {
                myrigh++;


                if(myrigh>myleft)
                {
                    System.out.print("\nError in expression!! No matching myleft parentheses for a myrigh parentheses.");
                    System.exit(1);
                }

                while(!mystack.isEmpty() && mystack.peek() != '(')
                {
                    postfix += mystack.peek();
                    pfix += mystack.peek();
                    mystack.pop();
                }
                mystack.pop();
            }
            myprev = c;
        }

        while(!mystack.isEmpty())
        {
            postfix += mystack.peek();
            pfix += mystack.peek();
            mystack.pop();
        }


        if( isCorrect(myrigh,myleft) > 0)
        {
            System.out.println("\nError in expression!! No matching myleft parentheses for a myrigh parentheses.");
            System.exit(1);
        }

        if( isCorrect(myrigh,myleft) < 0)
        {
            System.out.println("\nError in expression!! No matching myrigh parentheses for a myleft parentheses.");
            System.exit(1);
        }

        System.out.print("Converted Expression: "+postfix+"\n");
        return pfix;
    }



    /**
     * PreCondition:In order for this method to function properly, it will take two paramaters of type int
     *
     * PostCondition: When executed it will verify if the equation is correct. It will check if it is equal
     * less than, or greater than and will return appropriate value
     */


    public int isCorrect(int r, int l)
    {
        if (r == l) return 0;
        if (r > l) return 1;
        else return -1;
    }

    /**
     * PreCondition:In order for this method to function properly, it will take two paramaters of type char
     *
     * PostCondition: When executed it will call the lessimportant method and run that against
     * the values that the thisuser passes. It will then compare the two and will either return true
     * or false based on the input
     */

        public boolean moreimportant(char option1, char option2)
        {
            int op1Weight = lessimportant(option1);
            int op2Weight = lessimportant(option2);

            if(op1Weight < op2Weight)
                return false;
            else
                return true;
        }

    /**
     * PreCondition:In order for this method to function properly, it will take a paramater of type char
     *
     * PostCondition: When executed it will check the priority of the operators
     */



        public int lessimportant(char option)
        {
            int pl;
            switch(option)
            {
                case '+': case'-': pl =1; break;
                case '*': case'/': case'%': pl=2; break;
                default: pl = -1;
            }
            return pl;
        }

    }


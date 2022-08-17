//////////////////////////////
//	*************************
//	* Auth:twitter.com/l79l *
//	*************************
//////////////////////////////

import java.util.Scanner;
 
public class GCD {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Give me 2 numbers for GCD question: ");
        int x = input.nextInt();
        int y = input.nextInt();
        int z = recursive_euclidgcd(x,y);
        System.out.println("GCD of "  + x + " and " + y + " are " + z);
    }
 
    public static int recursive_euclidgcd(int a, int b) {
    if(b == a) {
       return a;
    }
    else if(a < b) {    
         // base case
        if(b%a == 0) { 
            return a;
        } 
        else { 
            return recursive_euclidgcd(a, b%a);
        }   
    }
    else {
        // base case
       if(a%b == 0) { 
            return b;
            } 
        else { 
            return recursive_euclidgcd(b, a%b);
            }
        }
    }
}

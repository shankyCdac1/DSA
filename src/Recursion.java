import java.util.Scanner;

public class Recursion {

    //backtracking using recursion
    static void print(int i, int n) {
        if (i<1)
            return;
        print(i-1,n);
        System.out.println(i);
    }

    //backtracking using recursion
    static void print1(int i, int n) {
        if (i>n)
            return;
        print1(i+1,n);
        System.out.println(i);
    }

    //Parametrized function call
    static void sumOfNnumbers(int n, int sum) {
        if (n==0) {
            System.out.println(sum);
            return;
        }
        sumOfNnumbers(n-1,sum+n);
    }

    static int sumOfNnumbersUsingFunction(int n) {
        if (n==0)
            return 0;
        return n + sumOfNnumbersUsingFunction(n-1);
    }

    static int factorial(int n) {
        if (n==1)
            return 1;
       return n * factorial(n-1);
    }

    static void reverseArray(int a[],int i,int j) {
        int temp;
        if (i>=j)
            return;
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        reverseArray(a,i+1,j-1);
    }

    static boolean stringPalindrome(String s,int i,int j) {
        if (i>=j)
            return true;
        if (s.charAt(i) != s.charAt(j))
            return false;
        return stringPalindrome(s,i+1,j-1);
    }

    static int fibonacci(int n) {
        if (n<=1)
            return n;
        int last = fibonacci(n-1);
        int slast = fibonacci(n-2);
        return last + slast;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //print(3,n);

        //print1(1,n);

        //sumOfNnumbers(n,0);

        //int x = sumOfNnumbersUsingFunction(n);
        // System.out.println(x);

        //int x = factorial(n);
        //System.out.println(x);

        /*int a[] = {2,6,1,4,5};
        int i=0,j=a.length-1;
        reverseArray(a,i,j);
        for(int k=0;k<a.length;k++) {
            System.out.print(a[k]+" ");
        }*/

        /*String s = sc.nextLine();
        int i=0,j=s.length()-1;
        boolean x = stringPalindrome(s,i,j);
            if (x==true)
                System.out.println("palindrome");
            else
                System.out.println("not palindrome");*/

        int x = fibonacci(n);
        System.out.println(x);
    }
}

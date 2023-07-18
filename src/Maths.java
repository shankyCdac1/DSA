import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Maths {

    static void printAllDivisors(int n) {
        ArrayList<Integer> list = new ArrayList<>();
            for (int i=1;i*i<=n;i++) {
                if (n%i==0) {
                  list.add(i);
                }
                if (n/i != i)
                    list.add(n/i);
            }
        Collections.sort(list);
            for (Integer a : list) {
                System.out.println(a);
            }
    }

    static void printPrime(int n) {
        int count=0;
        int i,j;
        for (i=2;i<=n;i++) {
                count=0;
                for (j=1;j<=i;j++) {
                    if (i%j==0) {
                         count++;
                    }
                }
                if (count ==2)
                    System.out.println(i);
            }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //printAllDivisors(n);
        printPrime(n);

    }
}

import java.util.Scanner;

public class Patterns {

    static void print1(int n) {
        for (int i=1;i<=n;i++) {
            for (int j=1;j<i+1;j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static void print6(int n) {
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n-i+1;j++) {
                System.out.print(j + "");
            }
            System.out.println();
        }
    }

    static void print7(int n) {
        for (int i=0;i<n;i++) {
            //space
            for (int j=0;j<n-i-1;j++) {
                System.out.print(" ");
            }
            //star
            for (int j=0;j<2*i+1;j++) {
                System.out.print("*");
            }
            //space
            for (int j=0;j<n-i-1;j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void print8(int n) {
        for (int i=0;i<n;i++) {
            //space
            for (int j=0;j<i;j++) {
                System.out.print(" ");
            }
            //star
            for (int j=0;j<2*n-(2*i+1);j++) {
                System.out.print("*");
            }
            //space
            for (int j=0;j<i;j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void print9(int n) {
        for (int i=0;i<n;i++) {
            for (int j=0;j<=i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i=1;i<n;i++) {
            for (int j=0;j<n-i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void print10(int n) {
        // for even rows print start as 1 and for odd rows print as 0, and flip after every print of start
        int start = 1;
        for (int i=0;i<n;i++) {
            if (i % 2 == 0)
                start = 1;
            else
                start = 0;
            for (int j=0;j<=i;j++) {
                System.out.print(start + " ");
                start = 1 - start;
            }
            System.out.println();
        }
    }

    static void print5(int n) {
        for (int i=0;i<n;i++) {
            for (int j=0;j<=n-i-1;j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void print20(int n) {
        int spaces = 2*n-2;
            for (int i=1;i<=2*n-1;i++) {
                int stars = i;
                    if (i>n)
                        stars = 2*n-i;
                    //star
                    for (int j=1;j<=stars;j++) {
                        System.out.print("*");
                    }
                    //space
                    for (int j=1;j<=spaces;j++) {
                        System.out.print(" ");
                    }
                    //star
                    for (int j=1;j<=stars;j++) {
                        System.out.print("*");
                    }
                System.out.println();
                    if (i<n)
                        spaces = spaces - 2;
                    else
                        spaces = spaces + 2;
            }

    }

    static void print21(int n) {
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (i==0 || j==0 || i==n-1 || j==n-1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        print21(n);
    }
}

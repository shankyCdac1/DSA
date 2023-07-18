import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sorting {

    static void selecttion_Sort(int a[], int n) {
        for (int i=0;i<=n-2;i++) {
            int min = i;
            for (int j=i;j<=n-1;j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        //printing array
        for (int i=0;i<n;i++) {
            System.out.print(a[i] + " ");
        }
    }

    static void bubble_Sort(int a[], int n) {
        for (int i=n-1;i>0;i--) {
            int didSwap = 0;
            for (int j=0;j<=i-1;j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                    didSwap = 1;
                }
            }
            if (didSwap == 0)
                break;
        }
        System.out.println("Bubble Sort");
        //printing array
        for (int i=0;i<n;i++) {
            System.out.print(a[i] + " ");
        }
    }

    static void insertion_Sort(int a[], int n) {
            for (int i=0;i<=n-1;i++) {
                int j = i;
                    while (j>0 && a[j-1] > a[j]) {
                        int temp = a[j-1];
                        a[j-1] = a[j];
                        a[j] = temp;
                        j--;
                    }
            }
        //System.out.println("Insertion Sort");
            //printing array
            for (int i=0;i<n;i++) {
                System.out.print(a[i] + " ");
            }
    }

    static void merge_Sort(int a[], int low, int high) {
        if (low >= high)
            return;
        int mid = (low+high)/2;
        merge_Sort(a,low,mid);
        merge_Sort(a,mid+1,high);
        merge(a,low,mid,high);
    }


    static void merge(int a[], int low, int mid, int high) {
        //add all sorted element into temporary list
        List<Integer> list = new ArrayList<>();
        //first array =  low...mid
        //second array =     mid+1...right
        int left = low;
        int right = mid+1;
            while (left<=mid && right<=high) {
                if (a[left] < a[right]) {
                    list.add(a[left]);
                    left++;
                }
                else {
                    list.add(a[right]);
                    right++;
                }
            }
            //when while loop will fail, then to add left off elemets from either left or right array to list
        while (left<=mid) {
            list.add(a[left]);
            left++;
        }
        while(right<=high) {
            list.add(a[right]);
            right++;
        }
        //convert list into array
        int arr[] = new int[list.size()];
        for (int i=0;i<list.size();i++) {
            arr[i] = list.get(i);
        }

        //Now after this all unsorted elements are sorted, merged and added into list, so from list add them back to original array
        for (int i=low;i<=high;i++) {
            a[i] = arr[i-low];
        }

    }

    static void recursiveBubbleSort(int a[], int n) {
        if (n<1)
            return;
        int didSwap = 0;
        for (int j=0;j<=n-2;j++) {
            if (a[j] > a[j+1]) {
                int temp = a[j+1];
                a[j+1] = a[j];
                a[j] = temp;
                didSwap = 1;
            }
        }
        if (didSwap==0) {
            System.out.print("Array is sorted...");
            return;
        }
       recursiveBubbleSort(a,n-1);
    }

    static void recursiveInsertionSort(int a[], int n, int i) {
        if (i>=n)
            return;
        int j=i;
            while (j>0 && a[j-1]>a[j]) {
                int temp = a[j-1];
                a[j-1] = a[j];
                a[j] = temp;
                j--;
            }
            recursiveInsertionSort(a,n,i+1);
    }

    static void quicksort(int a[], int low, int high) {
        if (low<high) {
            int partitionIndex = getIndex(a,low,high);
            quicksort(a,low,partitionIndex-1);
            quicksort(a,partitionIndex+1,high);
        }
    }

    static int getIndex(int a[], int low, int high) {
        int pivot = a[low];
        int i = low, j = high;
            while (i<j) {
                while (a[i] <= pivot && i<=high-1) {
                    i++;
                }
                    while (a[j] > pivot && j>=low+1) {
                        j--;
                    }
                    if (i<j) {
                        int temp = a[j];
                        a[j] = a[i];
                        a[i] = temp;
                    }
                }
            //when i crosses j, then while loop terminates and then swap pivot with j, to move pivot to it's correct place and complete step 1
            int temp = a[j];
            a[j] = a[low];
            a[low] = temp;

        return j;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] =  new int[n];
            for (int i=0;i<a.length;i++) {
                a[i] = sc.nextInt();
            }
            //selecttion_Sort(a,n);
            //bubble_Sort(a,n);
            //insertion_Sort(a,n);

        /*int low = 0, high = n-1;
            merge_Sort(a,low,high);
        //print final sorted array
        System.out.println("Merge Sort");
        for (int i=0;i<a.length;i++) {
            System.out.print(a[i] + " ");
        }*/

        /*recursiveBubbleSort(a,n);
        //printing final sorted array
        for (int i=0;i<n;i++) {
            System.out.print(a[i] + " ");
        }*/

        /*int i=0;
        recursiveInsertionSort(a,n,i);
        //printing final sorted array
        for (int k=0;k<n;k++) {
            System.out.print(a[k] + " ");
        }*/

       /* int low=0,high=n-1;
        quicksort(a,low,high);
        System.out.println("Quick sort");
        for (int i=0;i<n;i++) {
            System.out.print(a[i] + " ");
        }*/
    }
}

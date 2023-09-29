import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    static int findIndexUsingBS(int a[], int n) {
        //Iterative Method
        int target = 6;
        /*int low = 0, high = n-1;
            while (low <= high) {
                int mid = (low + high) / 2;
                    if (target == a[mid])
                        return mid;
                    else if (target > a[mid])
                        low = mid + 1;
                    else
                        high = mid - 1;
            }
        return -1;*/
        //Recursive Method
        return BS(a,0,n-1,target);
    }

    static int BS (int a[], int low, int high, int target) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
            if(target == a[mid])
                return mid;
            else if (target > a[mid]) {
                low = mid + 1;
                return BS (a, low, high, target);
            }
            else {
                high = mid - 1;
                return BS (a, low, high, target);
            }
    }

    static int findLowerBound(int a[], int n)   {
        //Brute Force Approach : Linear Search
        int x = 9;
        /*    for (int i = 0; i<n; i++) {
                    if (a[i] >= x)
                        return i;
            }
        return n;*/

        //Optimal Approach : Using BS
        int low = 0, high = n-1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] >= x) {
                ans = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return ans;
    }

    static int findUpperBound(int a[], int n) {
        int x = 9, ans = n;
        //Brute Force Approach : Linear Search
            /*for (int i = 0; i<n; i++) {
                    if (a[i] > x) {
                        ans = i;
                        return ans;
                    }
            }
        return ans;*/

        //Optimal Approach : Using BS
        int low = 0, high = n-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] > x) {
                ans = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return ans;
    }

    static int searchInsertPos(int a[], int n) {
        int x = 2;
        int low = 0, high = n-1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] >= x) {
                ans = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return ans;
    }

    static int[] findFloorAndCeil(int a[], int n) {
        int x = 8;
        int floor = findFloor(n,x,a);
        int ceil  = findCeil(n,x,a);
        return new int[]{floor,ceil};
    }

    static int findFloor(int n, int x, int a[]) {
        int low = 0, high = n-1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] <= x) {
                ans = a[mid];
                low = mid + 1;
            }
            else
                high = mid - 1;
        }
        return ans;
    }

    static int findCeil(int n, int x, int a[]) {
        int low = 0, high = n-1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] >= x) {
                ans = a[mid];
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return ans;
    }

    static int[] findLastOccurrence(int a[], int n) {
        //Brute Force Approach
        /*int x = 13;
        int first = -1, last = -1;
            for (int i = 0; i<n; i++) {
                if (a[i] == x) {
                    if (first == -1)
                        first = i;
                    last = i;
                }
            }
        return new int[]{first,last};*/

        //Optimal Approach : Using BS for finding Lower bound and Upper bound
        /*int target = 11;
        int first = firstOccurenceWithLB(a,n,target);
        if (first == n || a[first] != target)
            return new int[]{-1,-1};

        return new int[]{first, lastOccurenceWithUB(a,n,target)-1};*/

        //Optimal Approach : Using BS without LB and UB

        int target = 13;
        return new int[]{firstOccurenceWithoutLB(a,n,target), lastOccurenceWithoutUB(a,n,target)};
    }

    static int firstOccurenceWithLB(int nums[], int n, int target) {
        int low = 0, high = n-1;
        int first = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                first = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return first;
    }

    static int lastOccurenceWithUB(int nums[], int n, int target) {
        int low = 0, high = n-1;
        int last = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                last = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return last;
    }

    static int firstOccurenceWithoutLB(int a[], int n, int target) {
        int low = 0, high = n-1;
        int first = -1;
            while (low <= high) {
                int mid = (low + high) / 2;
                    if (a[mid] == target) {
                        first = mid;
                        high = mid - 1;
                    }
                    else if (a[mid] > target) {
                        high = mid - 1;
                    }
                    else
                        low = mid + 1;
            }
        return first;
    }

    static int lastOccurenceWithoutUB(int a[], int n, int target) {
        int low = 0, high = n-1;
        int last = -1;
            while (low <= high) {
                int mid = (low + high) / 2;
                    if (a[mid] == target) {
                        last = mid;
                        low = mid + 1;
                    }
                    else if (a[mid] > target)
                        high = mid - 1;
                    else
                        low = mid + 1;
            }
        return last;
    }

    static int countOccurrence(int a[], int n) {
        /*int count = 0, x = 2;
            //Brute Force Approach
                for (int i = 0; i<n; i++) {
                        if (a[i] == x)
                            count++;
                }
        return count;*/

        //Optimal Approach : Using BS -- Can solve using LB and UB also without LB and UB
        int count = 0, x = 3;
        int first = firstOccurenceWithLB(a, n, x);
            if (first == n || a[first] != x)
                return 0;
        int last = lastOccurenceWithUB(a,n,x);
        last = last - 1;
        count = last - first + 1;
        return count;
    }

    static int bookAllocationProblem(int a[], int n) {
        //Brute Force Approach
        int m = 2;
        int max = Integer.MIN_VALUE, sum = 0;
            for (int i = 0; i<n; i++) {
                max = Math.max(max, a[i]);
                sum = sum + a[i];
            }
            for (int i = max; i<=sum; i++) {
                if (findMin(a, i) == m)
                    return i;
            }
       return -1;
    }

    static int findMin(int a[], int pages) {
        int n = a.length;
        int student = 1, pagesStudent = 0;
            for (int i = 0; i<n; i++) {
                if (a[i] + pagesStudent <= pages)
                    pagesStudent += a[i];
                else {
                    student++;
                    pagesStudent = a[i];
                }
            }
        return student;
    }

    static int splitArrayLargestSum(int a[], int n) {
        //Brute Force Approach
        int k = 3;
        int max = Arrays.stream(a).max().orElse(0);
        int sum = Arrays.stream(a).sum();
            for (int i = max; i<=sum; i++) {
                if (findSubArray(a, i) == k)
                    return i;
            }
        return -1;
    }

    static int findSubArray(int a[], int elements) {
        int n = a.length;
        int subArray = 1, subArrayElements = 0;
            for (int i = 0; i<n; i++) {
                if (a[i] + subArrayElements <= elements)
                    subArrayElements += a[i];
                else {
                    subArray++;
                    subArrayElements = a[i];
                }
            }
        return subArray;
    }

    static double gasStations(int a[], int n) {
        int k = 5;
        int howMany[] = new int[n-1];
        for (int gasStation = 1; gasStation<=k; gasStation++) {
            double maxSection = -1;
            int maxIndex = -1;
                for (int i = 0; i<n-1; i++) {
                    double diff = a[i + 1] - a[i];
                    double sectionLength = diff / (double) (howMany[i] + 1);
                        if (sectionLength > maxSection) {
                            maxSection = sectionLength;
                            maxIndex = i;
                        }
                }
           howMany[maxIndex]++;
        }

        //double maxAns = Arrays.stream(howMany).max().orElse(0);
        //return maxAns;

        double maxAns = -1;
            for (int i = 0; i<n-1; i++) {
                double diff = a[i + 1] - a[i];
                double sectionLength = diff / (double) (howMany[i] + 1);
                maxAns = Math.max(maxAns, sectionLength);
            }
        return maxAns;
    }

    static double medianOfSortedArrays(int a1[], int n1) {
        //Brute Force Approach
        /*int a2[] = {1,3,5};
        int n2 = a2.length;
        int a3[] = new int[n1 + n2];
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (a1[i] < a2[j]) {
                a3[k] = a1[i];
                k++;
                i++;
            }
            else {
                a3[k] = a2[j];
                k++;
                j++;
            }
        }
        while (i < n1) {
            a3[k] = a1[i];
            k++;
            i++;
        }
        while (j < n2) {
            a3[k] = a2[j];
            k++;
            j++;
        }

    int n = a3.length;
        if (n % 2 == 1)
            return a3[n/2];
    return ((double) a3[n/2] + (double) a3[(n/2) -1]) / 2.0;*/

        // Better Approach
        int a2[] = {1,3,5};
        int n2 = a2.length;

        int n = n1 + n2;
        int index2 = n / 2;
        int index1 = index2 - 1;
        int index1Ele = -1, index2Ele = -1;
        int i = 0, j = 0;
        int count = 0;
            while (i < n1 && j < n2) {
                if (a1[i] < a2[j]) {
                    if (count == index1) index1Ele = a1[i];
                    if (count == index2) index2Ele = a1[i];
                    count++;
                    i++;
                }
                else {
                    if (count == index1) index1Ele = a2[j];
                    if (count == index2) index2Ele = a2[j];
                    count++;
                    j++;
                }
             }
            while (i < n1) {
                if (count == index1) index1Ele = a1[i];
                if (count == index2) index2Ele = a1[i];
                count++;
                i++;

            }
            while (j < n2) {
                if (count == index1) index1Ele = a2[j];
                if (count == index2) index2Ele = a2[j];
                count++;
                j++;
            }
        if (n % 2 == 1)
            return (double) index2Ele;

        return (double)((double)(index1Ele + index2Ele)) / 2.0;//((double) index1Ele + (double) index2Ele) / 2.0;
    }

    static int findKElement(int a1[], int a2[], int n1, int n2, int k) {
        //Brute Force Approach
        int p1 = 0, p2 = 0, c = 0, ans = -1;
        while (p1 < n1 && p2 < n2) {
            if (c == k)
                break;
            else if (a1[p1] < a2[p2]) {
                ans = a1[p1];
                p1++;
            }
            else {
                ans = a2[p2];
                p2++;
            }
            c++;
        }
        if (c != k) {
            if (p1 != n1 - 1)
                ans = a1[k - c];
            else
                ans = a2[k - c];
        }
        return ans;
        /*if (n1 > n2)
            return findKElement(a2, a1, n2, n1, k);
        int low = 0, high = n1;
        //int low = Math.max(k - n2, 0), high = Math.min(k, n1);
        int left = k;

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            int l1 = (mid1 - 1 <= 0) ? Integer.MIN_VALUE : a1[mid1 - 1];
            int l2 = (mid2 - 1 <= 0) ? Integer.MIN_VALUE : a2[mid2 - 1];
            int r1 = (mid1 < n1) ?  a1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ?  a2[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }
            else if (l1 > r2)
                high = mid1 - 1;
            else
                low = mid1 + 1;
        }*/
        //return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
            for (int i = 0; i<n; i++) {
                a[i] = sc.nextInt();
            }

        //************************ BS on 1D Arrays *********************//

        //find Index Using Target
            //int x = findIndexUsingBS(a,n);
                //System.out.println(x);

        //find Lower Bound
            //int x = findLowerBound(a,n);
                //System.out.println(x);

        //find Upper Bound
            //int x = findUpperBound(a, n);
                //System.out.println(x);

        //Search Insert Position
            //int x = searchInsertPos(a,n);
                //System.out.println(x);

        //find Floor and Ceil in Array
            //int x[] = findFloorAndCeil(a,n);
                      //System.out.println(x[0] + " " + x[1]);

        //find last occurrence in Sorted Array
            //int x[] = findLastOccurrence(a,n);
                    //System.out.println(x[0] + " " + x[1]);

        //count occurrence of number in sorted array
            //int x = countOccurrence(a,n);
                //System.out.println(x);

        //search element is Rotated sorted array

        // ************************** BS on Answers ************************ //

        //Book allocation problem
        //int val = bookAllocationProblem(a, n);
        //System.out.println(val);

        //split Array largest sum
        //int val = splitArrayLargestSum(a, n);
        //System.out.println(val);

        //minimise max distance between gas stations
        //double max = gasStations(a, n);
        //System.out.println(max);

        //median of two sorted arrays
        //double val = medianOfSortedArrays(a, n);
        //System.out.println(val);

        //Kth element in two sorted array
        int a2[] = {1,4,8,10};
        int n2 = a2.length;
        int k = 2;
        int val = findKElement(a, a2, n, n2, k);
        System.out.println(val);
    }
}

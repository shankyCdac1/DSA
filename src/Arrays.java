import sun.awt.image.ImageWatched;

import javax.lang.model.type.UnionType;
import java.net.Inet4Address;
import java.util.*;

public class Arrays {
    static void findLargestElementInArray(int a[], int n) {
        //sorting array in ascending order
        for (int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++) {
                if (a[i]>a[j]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
        //sorted array
        for (int i=0;i<n;i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        //largest element in ascending sorted array will be at n-1
        System.out.println("Largest element in array is: " + a[a.length-1]);

        //or other then above approach use Arrays.sort(a); and then print a[a.length-1];
    }
    static void findLargestElementInArrayUsingRecursion(int a[],int n, int i) {
        if (i>n)
            return;
        for (int j=i+1;j<n;j++) {
            if (a[i] > a[j]) {
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        findLargestElementInArrayUsingRecursion(a,n,i+1);
    }
    static void findsecondSmallestAndLargest(int a[], int n) {
        // Brute Force Approach
        /*java.util.Arrays.sort(a);
        System.out.println("Second Largest element: " + a[a.length-2]);
        System.out.println("Second Smallest element: " + a[1]);*/

        //Better Approach
        //first find smallest and largest element in the array
      /*  int max = a[0], min = a[0], second_small = Integer.MAX_VALUE, second_large = Integer.MIN_VALUE;
        for (int i=0;i<n;i++) {
                if (a[i] >= max)
                    max = a[i];
            }
        for (int i=0;i<n;i++) {
            if (a[i] <= min)
                min = a[i];
        }
        // compare with largest and smallest integer values with each element in array
        for (int i=0;i<n;i++) {
            if (a[i] < second_small && a[i] != min)
                second_small = a[i];
            if (a[i] > second_large && a[i] != max)
                second_large = a[i];
        }
        System.out.println(second_small + " " + second_large);*/

        //Optimal Approach
        // Traverse only once for finding second large and small element
        // In this approach we dont have to traverse twice to find max and then smax and min and then smin
        int max = a[0], smax = Integer.MIN_VALUE, min = a[0], smin = Integer.MAX_VALUE;
        // finding smax
        for (int i=0;i<n;i++) {
                if (a[i] > max) {
                    smax = max;
                    max  = a[i];
                }
                else if (a[i] < max && a[i] > smax) {
                    smax = a[i];
                }
            }
        //finding smin
        for (int i=0;i<n;i++) {
            if (a[i] < min) {
                smin = min;
                min  = a[i];
            }
            else if (a[i] > min && a[i] < smin) {
                smin = a[i];
            }
        }
        System.out.println(smax + " " + smin);
    }
    static void isArraySorted(int a[], int n) {
        //Brute Force Approach , Time Complexity is O(N^2) as each element is compared with all elements
        /*int isSorted = 0;
        for (int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++) {
                if (a[i] > a[j]) {
                    isSorted = 1;
                }
            }
        }
        if (isSorted == 0)
            System.out.println("Array is sorted");*/

        //Optimal Approach
        //compare previous element with current element, if previous is smaller then or equal to current then it means array is sorted
        //Time complexity is O(N), as each element is visited only once
        int previousEle = 0, isSorted=0;
        for (int i=1;i<n;i++) {
                if (a[previousEle] > a[i]) {
                    isSorted = 1;
                    break;
                }
                previousEle = previousEle + 1;
            }
        if (isSorted==1)
            System.out.println("Array is not sorted");
        else
            System.out.println("Array is sorted");

    }
    static void removeDuplicatesFromArray(int a[], int n) {
        //Brute Force Approach for removing duplicates from array
        /*for (int i=0;i<n;i++) {
            int j=i+1;
            while (j<n) {
                if (a[i]==a[j]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    n--;
                }
                j++;
            }
        }
        //printing array
        for (int k=0;k<n;k++) {
            System.out.print(a[k] + " ");
        }
        */

        //Brute Force Approach for placing first k unique elements, and return the value of k
        // Store in some data structure that holds unique elements i.e, Hash Set
        /*HashSet<Integer> h = new HashSet<>();
            for (int i=0;i<n;i++) {
                h.add(a[i]);
            }
            //print hash set
            for (Integer ele : h) {
                System.out.print(ele + " ");
            }*/

        //Optimal Approach
        //Traverse only once and use 2 pointer approach
        //check if element are not equal, then move pointer and change the place of element
        int i = 0;
            for (int j=1;j<n;j++) {
                if (a[j] != a[i]) {
                   i = i + 1;
                   a[i] = a[j];
                }
            }
            // i will be at the last unique index element so to print the total size of unique elements print i+1
        System.out.println(i+1);
    }
    static void leftRotateArrayBy1(int a[], int n){
        //Brute Force approach is to take another array of same size and store in that another array, which will take
        // space complexity of O(n).

        //Optimal Approach
        int temp = a[0],i=0,j=i+1;
            while (i<n-1) {
                a[i] = a[j];
                i++;
                j++;
            }
            //after condition is terminated, place first element in the end.
            a[a.length-1] = temp;
            //printing array
        for (int k=0;k<n;k++) {
            System.out.print(a[k]);
        }
    }

    static void leftRotateArrayByKElements(int a[], int n) {
        //rotating right by k elements
        /*int k=2,m=0,j=m+k;
        int temp[] = new int[n];
        k = k%n;
        //put last k elements in temp array
            for (int i=n-k;i<n;i++) {
                temp[i-n+k] = a[i];
            }
        //now move rest elements from main array to temp array
            while (j<n) {
                temp[j] = a[m];
                m++;
                j = m+k;
            }
            //now copy temp array to main array again
        for (int i=0;i<n;i++) {
            a[i] = temp[i];
        }
        //printing main array
        for (int i=0;i<n;i++) {
            System.out.print(a[i] + " ");
        }
*/
        //rotating left by k elements
        /*int k=2,i=k,j=0;
        k = K % n;
        int temp[] = new int[n];

        //move first k elements in temp array
            for (int l=0;l<k;l++) {
                temp[n-k+l] = a[l];
            }
        //now move other elements to temp array
            while (i<n) {
                temp[j] = a[i];
                i++;
                j++;
            }
        //copy temp array to original array
            for (int m=0;m<n;m++) {
                a[m] = temp[m];
            }
        //printing original array
            for (int o=0;o<n;o++) {
                System.out.print(a[o] + " ");
            }*/

        //Optimal Approach
        //Reverse array method to solve this question for left rotate
        /*int k=2;
        //reverse first k elements
            reverse(a,0,k-1);
        //reverse rest elements
            reverse(a,k,n-1);
        //full array reverse
            reverse(a,0,n-1);*/

        //Reverse array method to solve this question for right rotate
        int k=2;
        //reverse last k elements
            reverse(a,n-k,n-1);
        //reverse rest elements
            reverse(a,0,n-k-1);
        //reverse full array
            reverse(a,0,n-1);
    }

    static void reverse(int a[], int i, int j) {
        while (i<=j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }

    static void moveZerosToEnd(int a[],int n) {
        /*int temp[] = new int[n];
        int q=0;
        //adding non zero elements to temp array, Note : when all non zero elements are added in array, for rest of index 0 will be added automatically.
            for (int i=0;i<n;i++) {
                if (a[i]!=0) {
                    temp[q] = a[i];
                    q++;
                }

            }
            //adding temp array to original array
            for (int i=0;i<n;i++) {
                a[i] = temp[i];
            }
        //printing array
        for (int i =0;i<n;i++) {
            System.out.print(temp[i] + " ");
        }*/

        //Optimal Approach
        //find first zero in array
        int j = -1;
        for (int i=0;i<n;i++) {
            if (a[i] == 0) {
                j = i;
                break;
            }
        }
        //start loop with this j variable as before that other will be non zero elements, and j will always point to zero
        for (int i=j+1;i<n;i++) {
            if (a[i] != 0) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
                j++;
            }
        }
        //printing array
            for (int k=0;k<n;k++) {
                System.out.print(a[k] + " ");
            }
    }

    static void linearSearch(int a[], int n) {
        int num = 5;
        // search using loop to find the given num in array and show index
        int index = -1;
        for (int i=0;i<n;i++) {
                if (a[i] == num) {
                    index = i;
                    break;
                }
            }
        //print the index
        System.out.println(index);
    }

    static void findUnion() {
        // unique array means addition of both arrays with unique elements
        int a1[] = {1,2,3,4,5,6,7,8,9,10};
        int a2[] = {2,3,4,4,5,11,12};

        //use set as union array means unique elements
        /*HashSet<Integer> set = new HashSet<>();
        //inserting array1 elements
            for (int i=0;i<a1.length;i++) {
                set.add(a1[i]);
            }
        //inserting array2 elements
            for (int i=0;i<a2.length;i++) {
                set.add(a2[i]);
            }
        //printing hash set with unique elements from both array
            for (Integer a : set) {
                System.out.print(a + " ");
            }*/

        //Optimal Approach
        //we will use 2 pointer approach
        int n1 = a1.length, n2 = a2.length;
        List<Integer> unionList = new ArrayList<>();
        int i = 0, j = 0;
            while (i<n1 && j<n2) {
                if (a1[i] <= a2[j]) {
                    if (unionList.size()==0 || unionList.get(unionList.size()-1) != a1[i]) {
                        unionList.add(a1[i]);
                    }
                    i++;
                }else {
                    if (unionList.size()==0 || unionList.get(unionList.size()-1) != a2[j]) {
                            unionList.add(a2[j]);
                    }
                    j++;
                }
            }
            //for adding rest of the elements of i, if j array is completed
            while (i<n1) {
                if (unionList.size()==0 || unionList.get(unionList.size()-1) != a1[i])
                    unionList.add(a1[i]);
                i++;
            }
            //for adding rest of the elements of j, if i array is completed
            while (j<n2) {
                if (unionList.size()==0 || unionList.get(unionList.size()-1) != a2[j])
                    unionList.add(a2[j]);
                j++;
            }
            //printing list
            for (Integer a : unionList) {
                System.out.print(a + " ");
            }

    }

    static void intersectionOfTwoSortedArrays() {
        int a1[] = {1,2,2,3,3,4,5,6};
        int a2[] = {2,3,3,5,6,6,7};
        /*List<Integer> list = new ArrayList<>();
        //always create visited array for smaller given array
        //create a visited array for array2 and initialize with 0, and if the array1 element is present in array2 then mark visited array as 1
        int visited[] = new int[a2.length];
        //now check if array1 element is present in array2 and mark visited array by 1
            for (int i=0;i<a1.length;i++) {
                for (int j=0;j<a2.length;j++) {
                    if (a1[i] == a2[j] && visited[j] == 0) {
                        list.add(a1[i]);
                        visited[j] = 1;
                        break;
                    }
                    if (a2[j] > a1[i]) //use of this if condition, i don't get it
                        break;
                }
            }
            //printing list
                for (Integer x : list) {
                    System.out.print(x + " ");
                }*/

        //Optimal Approach

    }

    static void findMissingNoInArray(int n) {
        //Brute Force Approach 1
        //this logic will work only for sorted array
        /*int a[] = {0,1};
        int temp[] = new int[n];
        int count = 0;
        //enter 1 to N numbers in temp array
            for (int i=0;i<n;i++) {
                temp[i] = count++;
            }
        //check if any of these numbers are not present in orginal array
        int number = -1;
            for (int i=0;i<n;i++) {
                if (temp[i] != a[i]) {
                    number = temp[i];
                    break;
                }
            }
        //print the missing number in original array
        System.out.print(number);*/

        //Brute Force Approach 2
        /*int a[] = {1,4,5,2};
        int number = -1;
        for (int i=1;i<n;i++) {
            int flag = 0;
            for (int j=0;j<n-1;j++) {
                if (a[j] == i) {
                    flag=1;
                    break;
                }
            }
            if (flag == 0) {
                number = i;
            }
        }
        System.out.println(number);
*/
        //Better Approach
        //we use array hashing concept
       /*int a[] = {1,3,5,4};
        //create a hash array of n+1, as we need to store n frequency also
        int hash[] = new int[n+1];
        //now add array element frequency into hash array,the element which is not present in the original array, it's value in hash array will be 0
                for (int i=0;i<a.length;i++) {
                    hash[a[i]] += 1;
                }
        //after this, create a loop to fetch the number whose frequency is 0.
                int number = -1;
                for (int i=1;i<n;i++) {
                    if (hash[i]==0) {
                        number = i;
                        break;
                    }
                }
        System.out.println(number);*/

        //Optimal Approach 1
        //use sum of n natural number formula and then minus with sum of array elements, that result will be the missing number
        int a[] = {5,2,4,1};
        int sum = 0, arraySum = 0;
        sum = n * (n + 1) / 2;
        //now find sum of array elements
            for (int i=0;i<n-1;i++) {
                arraySum = arraySum + a[i];
            }
        //now do sum - arraySum
        int number = sum - arraySum;
        System.out.print(number);

        //Optimal Approach 2, use XOR, check video and understand again
    }

    static void countMaxConsectiveOneinArray(int a[], int n) {
        //Only Approach
        int max = 0, current = 0;
            for (int i = 0;i<n;i++) {
                if (a[i] == 1) {
                    current++;
                    max = Math.max(current,max);
                } else {
                    current = 0;
                }
            }
        System.out.print(max);
    }

    static void findNonRepeativeNo(int a[], int n) {
        //Brute Force Approach
        /*for (int i = 0;i<n;i++) {
                int num = a[i];
                int count = 0;
                    for (int j = 0;j<n;j++) {
                        if (a[j] == num) {
                            count++;
                        }
                    }
                    if (count == 1)
                        System.out.print(num);
            }*/

        //Better Approach 1
        //using array hashing, also we can use Linked Hash Map
        //find max element in array, as hash array has to be created with this max element +1. do dry run to understand better
        /*int max = a[0];
            for (int i = 0;i<n;i++) {
                if (a[i] > max)
                    max = a[i];
            }
        int hash[] = new int[max+1];
        //add array elements in hash array
            for (int i=0;i<a.length;i++) {
                hash[a[i]] += 1;
            }
        //now check whose frequency is 1
        int number = -1;
            for (int i=0;i<hash.length;i++) {
                if (hash[i] == 1) {
                    number = i;
                    break;
                }
            }
        System.out.println(number);*/

        //Better Approach2
        //use map data structure to minimise time complexity
        /*Map<Integer,Integer> map = new LinkedHashMap<>();
            for (int i=0;i<n;i++) {
                if (map.containsKey(a[i]) == false) {
                    map.put(a[i],1);
                } else {
                    int oldValue = map.get(a[i]);
                    int newValue = oldValue + 1;
                    map.put(a[i], newValue);
                }
            }
            //loop map and check for element with 1 frequency
                for (Map.Entry<Integer, Integer> m : map.entrySet()) {
                    if (m.getValue() == 1)
                        System.out.print(m.getKey());
                }*/

        //Optimal Approach
        int xor = 0;
            for (int i = 0;i<n;i++) {
                xor = xor^a[i];
            }
        System.out.println(xor);
    }

    static void findLengthOfLongestSubArray(int a[], int n) {
        //Brute Force Approach1
        /*int sum = 10, len = 0;
            for (int i = 0;i<n;i++) {
                for (int j = i;j<n;j++) {
                    int s = 0;
                        for (int k = i;k<=j;k++) {
                                s = s + a[k];
                        }
                        if (s == sum)
                            len = Math.max(len,j-i+1);
                }
            }
        System.out.println(len);*/

        //Brute Force Approach2
        /*int sum = 10, len = 0;
            for (int i = 0;i<n;i++) {
                int s = 0;
                //find sub array
                for (int j = i;j<n;j++) {
                    s = s + a[j];
                        if (s == sum)
                            len = Math.max(len, j-i+1);
                }
            }
        System.out.println(len);*/

        //Better Approach
        //This approach is optimal for positive, negative and zero array elements
        //Note : it is better approach for only positive and zero elements
        /*int nums[] = {-1, 1, 1};
        int prefixSum = 0, maxLen = 0, k = 1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            prefixSum = prefixSum + nums[i];
            if (prefixSum == k) {
                maxLen = Math.max(maxLen,i+1);
            }
            int rem = prefixSum - k;
            if (map.containsKey(rem)) {
                int len = i - map.get(rem);
                maxLen = Math.max(maxLen,len);
            }
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        System.out.println(maxLen);*/

        //Optimal Approach
        int a1[] = {2,3,5,1,9};
        int left = 0, right = 0, maxLen = 0, k = 10;
        long sum = a[0];
        while (right < a1.length) {
            while (left <= right && sum > k) {
                sum = sum - a[left];
                left++;
            }
            if (sum == k)
                maxLen = Math.max(maxLen,right-left+1);
            right++;
            if (right < a1.length)
                sum = sum + a[right];
        }
        System.out.println(maxLen);
    }

    static String findTwoSuminArray(int a[], int n) {
        //Brute Force Approach
        /*int target = 15, sum = 0;
            for (int i = 0;i<n;i++) {
                    sum = a[i];
                for (int j = i+1;j<n;j++) {
                    int result = sum + a[j];
                        if (result == target)
                            return "YES " + i + " " + j;
                }
            }
            return "NO " + "{-1,-1}";*/

        //Better Approach



        return "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
            for (int i=0;i<n;i++) {
                a[i] = sc.nextInt();
            }
            //find largest element in the array
                //findLargestElementInArray(a,n);

            //find largest element in the array using recursion
                //int i=0;
                //findLargestElementInArrayUsingRecursion(a,n,i);
                //System.out.println("Largest element in array is: " + a[a.length-1]);

            //find second smallest and second largest element in array
                //findsecondSmallestAndLargest(a,n);

            //check if array is sorted
                //isArraySorted(a,n);

            //remove duplicates from array
                //removeDuplicatesFromArray(a,n);

            //left rotate array by 1
                //leftRotateArrayBy1(a,n);

            //left rotate array by k elements
                //leftRotateArrayByKElements(a,n);
                    /*for (int i=0;i<n;i++) {
                        System.out.print(a[i] + " ");
                    }*/

            //move zeros to end
                //moveZerosToEnd(a,n);

            //linear search
                //linearSearch(a,n);

            //find Union
                //findUnion(); //pass hard coded array as i don't want to take 2 user defined array

            //intersection of two sorted arrays
                //intersectionOfTwoSortedArrays(); //pass hard coded array as i don't want to take 2 user defined array

            //find missing number in array
                //findMissingNoInArray(n);

            //count maximum consecutive 1 in the array
                //countMaxConsectiveOneinArray(a,n);

            //find non repeative element in array
                //findNonRepeativeNo(a,n);

            //find the length of longest sub array
                //findLengthOfLongestSubArray(a,n);

            //-------------------------------Array Medium Problems------------------------------------------------//

            //Two Sum : Check if a pair with given sum exists in Array
                String x = findTwoSuminArray(a,n);
                    System.out.println(x);
    }
}

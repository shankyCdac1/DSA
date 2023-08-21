import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import sun.awt.image.ImageWatched;

import javax.lang.model.type.UnionType;
import javax.print.attribute.HashDocAttributeSet;
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
        /*Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<nums.length;i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};*/

        //Optimal Approach
        // NOTE : FOR variant 2, use better approach as Optimal Approach
            int left = 0, right = n-1, sum = 0, target = 14;
            java.util.Arrays.sort(a);
                while (left < right) {
                    sum = a[left] + a[right];
                        if (sum < target)
                            left++;
                        else if (sum > target)
                            right--;
                        else if (sum == target)
                            return "YES";
                }
        return "NO";
    }

    static void sortArrayOfZeroOneAndTwo(int a[], int n) {
        //Brute Force Approach
        /*for (int i = 0;i<n;i++) {
            for (int j = i+1;j<n;j++) {
                if (a[i] >= a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int i = 0;i<n;i++) {
            System.out.print(a[i]);
        }*/

        //Better Approach
        //count no of zero, one and two
        /*int count_0 = 0, count_1 = 0, count_2 = 0;
            for (int i = 0;i<n;i++) {
                if (count_0 == 0)
                    count_0++;
                else if (count_1 == 1)
                    count_1++;
                else
                    count_2++;
            }
        //now place these zero, one and two in array
        //zero
        for (int i = 0;i<count_0;i++) {
                a[i] = 0;
            }
        //one
        for (int i = count_0;i<count_0 + count_1;i++) {
            a[i] = 1;
        }
        //two
        for (int i = count_0 + count_1;i<n;i++) {
            a[i] = 2;
        }
        //printing array
        for (int i = 0;i<n;i++) {
            System.out.print(a[i] + " ");
        }*/

        //Optimal Approach
        int low = 0, mid = 0, high = n-1;
            while (mid <= high) {
                if (a[mid] == 0) {
                    int temp = a[mid];
                    a[mid] = a[low];
                    a[low] = temp;
                    mid++;
                    low++;
                }
                else if (a[mid] == 2) {
                    int temp = a[mid];
                    a[mid] = a[high];
                    a[high] = temp;
                    high--;
                }
                else
                    mid++;
            }
            //printing array
            for (int i = 0;i<n;i++) {
                System.out.print(a[i] + " ");
            }
    }

    static int findMajorityElement(int a[], int n) {
        //Brute Force Approach
        //traverse all element and find if it's count is greater then N/2
        /*int halfOfArraySize = n/2;
            for (int i = 0;i<n;i++) {
                int count = 1;
                    for (int j = i+1;j<n;j++) {
                        if (a[i] == a[j])
                            count++;
                    }
                    if (count > halfOfArraySize)
                        return a[i];
            }
            return -1;*/

        //Better Approach
        //Create a hash Array and count frequency of each element
        /*int halfArraySize = n/2;
        int hash[] = new int[n+1];
        //add all array element in hash array
            for (int i = 0;i<a.length;i++) {
                hash[a[i]] += 1;
            }
        //now check which element frequency is greater then N/2
            for (int i = 0;i<hash.length;i++) {
                if (hash[i] > halfArraySize)
                    return i;
            }
        return -1;*/

        //Optimal Approach
        //For Optimal Approach use Moore's Voting Algorithm
        //Now Apply Voting Algorithm
        int ele = -1, count = 0, halfArraySize = n/2;
            for (int i = 0;i<n;i++) {
                if (count == 0) {
                    count = 1;
                    ele = a[i];
                }
                else if (a[i] == ele)
                    count++;
                else
                    count--;
            }
        //Now check if the elemenet that you got from the Voting Algorithm is in majority
        int count1 = 0;
            for (int i = 0;i<n;i++) {
                if (a[i] == ele)
                    count1++;
            }
            if (count1 > halfArraySize)
                return ele;

        return -1;
    }

    static int findMaxSubArraySum(int a[], int n) {
        //Brute Force Approach
        /*int maxi = -1;
            for (int i = 0;i<n;i++) {
                for (int j = i;j<n;j++) {
                        int sum = 0;
                    for (int k = i;k<=j;k++) {
                        sum = sum + a[k];
                    }
                    maxi = Math.max(sum, maxi);
                }
            }
    return maxi;*/

        //Better Approach
        /*int maxi = -1;
        for (int i = 0;i<n;i++) {
            int sum = 0;
            for (int j = i;j<n;j++) {
                sum = sum + a[j];
            }
            maxi = Math.max(sum, maxi);
        }
        return maxi;*/

        //Optimal Approach
        //Kadan's Algorithm
        int max = Integer.MIN_VALUE, sum = 0, start = -1, ansStart = -1, ansEnd = -1;
            for (int i = 0;i<n;i++) {
                if (sum == 0)
                    start = i;
                sum = sum + a[i];
                    if (sum > max) {
                        max = sum;
                        ansStart = start;
                        ansEnd = i;
                    }
                        if (sum < 0)
                            sum = 0;
                }

            //Print subArray with max sum
            for (int i = ansStart;i<=ansEnd;i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            //condition to check for empty subArray
        if (max < 0)
            max = 0;
        return max;
    }

    static int buyAndSellStocks(int a[], int n) {
        /*
        // Not correct for all test cases, need to verify for array [2,4,1]
        //find minimum value
        int min = a[0], index = 0;
        for (int i = 0;i<n;i++) {
            if (a[i] < min) {
                min = a[i];
                index = i;
            }
        }
        //find maximum value
        int max = a[index];
            for (int i = index+1;i<n;i++) {
                if (a[i] > max)
                    max = a[i];
            }
            int profit = max - min;
        if (profit > 0)
            return profit;

        return 0;*/

        /*int max = 0;
            for (int i = 0;i<n;i++) {
                for (int j = i+1;j<n;j++) {
                //check this condition as we need to find max profit, so check if the next element is greater than the current element
                // in th entire array, if found the store in max variable and move ahead compare other elements.
                    if (a[j] > a[i]) {
                        max = Math.max(a[j] - a[i], max);
                    }
                }
            }
        return max;*/

        //Optimal Approach, use Two Pointer
        // left : to buy, right : to sell, sell - buy = profit
            int left = 0, right = 1, maxProfit = 0;
                while (right < n) {
                    if (a[left] < a[right])
                        maxProfit = Math.max(maxProfit,a[right] - a[left]);
                    else
                        left = right;
                    right++;
                }

            return maxProfit;
    }

    static int[] rearrangeArrayElement(int a[], int n) {
        //Brute Force Approach
        /*int half = n/2;
          int positive[] = new int[half];
          int negative[] = new int[half];
          int pIndex = 0, nIndex = 0, k = 0, b = 0, c = 0;
            for (int i = 0;i<n;i++) {
                    if (a[i] > 0) {
                        positive[pIndex] = a[i];
                        pIndex++;
                    } else {
                        negative[nIndex] = a[i];
                        nIndex++;
                    }
            }
            //this while loop is also correct, but will run n times
            *//*while (k < n) {
                if (b < positive.length) {
                    a[k] = positive[b];
                    k++;
                    b++;
                }
                if (c < negative.length) {
                    a[k] = negative[c];
                    k++;
                    c++;
                }
            }*//*
        //this for loop will save sometime and run n/2 times
            for (int i = 0;i<half;i++) {
                //reason for doing this calculation is, we have positive numbers at positive index in final array and negative numbers at negative index
                a[2*i] = positive[i];
                a[2*i+1] = negative[i];
            }
        return a;*/

        //Optimal Approach
        /*int resultArray[] = new int[n];
        int posIndex = 0, negIndex = 1;
        //traverse till n and find pos and neg numbers and store in resultArray
            for (int i = 0;i<n;i++) {
                if (a[i] > 0) {
                    resultArray[posIndex] = a[i];
                    posIndex = posIndex + 2;
                } else {
                    resultArray[negIndex] = a[i];
                    negIndex = negIndex + 2;
                }
            }
        return resultArray;*/

        //Variety 2 : where elements are not equal
        /*List<Integer> posList = new ArrayList<>();
        List<Integer> negList = new ArrayList<>();
            for (int i = 0;i<n;i++) {
                    if (a[i] > 0)
                        posList.add(a[i]);
                    else
                        negList.add(a[i]);
            }
           int posIndex = 0, negIndex = 0, arrayIndex = 0;
                while (posIndex < posList.size() && negIndex < negList.size()) {
                    a[arrayIndex] = posList.get(posIndex);
                            posIndex++;
                            arrayIndex++;
                    a[arrayIndex] = negList.get(negIndex);
                            negIndex++;
                            arrayIndex++;
                }
                while (posIndex < posList.size()) {
                    a[arrayIndex] = posList.get(posIndex);
                    posIndex++;
                    arrayIndex++;
                }
                while (negIndex < negList.size()) {
                    a[arrayIndex] = negList.get(negIndex);
                    negIndex++;
                    arrayIndex++;
                }
        return a;*/

        //Striver Approach for Variety 2
        List<Integer> posList = new ArrayList<>();
        List<Integer> negList = new ArrayList<>();
        for (int i = 0;i<n;i++) {
            if (a[i] > 0)
                posList.add(a[i]);
            else
                negList.add(a[i]);
        }
        //now if pos > neg enter till neg list, and then vice versa
            if (posList.size() > negList.size()) {
                for (int i = 0;i<negList.size();i++) {
                        a[2*i] = posList.get(i); // for entering pos elements
                        a[2*i+1] = negList.get(i); // for entering neg elements
                }
                //now enter rest of the elements from positive list
                int index = negList.size() * 2;
                for (int i = negList.size();i<posList.size();i++) {
                        a[index] = posList.get(i);
                        index++;
                }
            } else {
                for (int i = 0;i<posList.size();i++) {
                        a[2*i] = posList.get(i); // for entering pos elements
                        a[2*i+1] = negList.get(i); // for entering neg elements
                }
                //now enter rest of the elements from negative list
                int index = posList.size() * 2;
                    for (int i = posList.size();i<negList.size();i++) {
                            a[index] = negList.get(i);
                            index++;
                    }
            }
        return a;
    }

    static List findLeadersInArray(int a[], int n) {
        //Brute Force Approach
        /*List<Integer> leaders = new ArrayList<>();
            for (int i = 0;i<n;i++) {
                boolean leader = true;
                for (int j = i+1;j<n;j++) {
                        if (a[j] > a[i]) {
                            leader = false;
                            break;
                        }
                }
                if (leader)
                    leaders.add(a[i]);
            }
        return leaders;*/

        //Optimal Approach
        //Idea is find max from back of array, and then check if current element is greater then max, because if current element is greater
        //then max, it means that current element is greater then all elements in the right of the array.
        List<Integer> leaders = new ArrayList<>();
        int maxE = Integer.MIN_VALUE;
        int index = a.length-1;
            for (int i = index;i>=0;i--) {
                    if (a[i] > maxE)
                            leaders.add(a[i]);
                maxE = Math.max(maxE,a[i]);
            }
        return leaders;
    }

    static int findMaxConsequitiveLength(int a[], int n) {
        java.util.Arrays.sort(a);
        int maxLen = 0;

        
        return maxLen;
    }

    static int[][] rotateMatrixBy90(int [][] matrix, int n, int m) {
        //Brute Force Approach
        /*int len = matrix.length;
        int rotated[][] = new int[len][len];
            for (int i = 0;i<n;i++) {
                for (int j = 0;j<m;j++) {
                       rotated[j][n-i-1] = matrix[i][j];
                }
            }
        return rotated;*/

        //Optimal Approach
        //First Transpose matrix than reverse it
            for (int i = 0;i<n;i++) {
                for (int j = i+1;j<m;j++) {
                        int temp = matrix[i][j];
                        matrix[i][j] = matrix[j][i];
                        matrix[j][i] = temp;
                }
            }
         //Now reverse the matrix
            for (int i = 0;i<n;i++) {
                for (int j = 0;j<n/2;j++) {
                        int temp = matrix[i][j];
                        matrix[i][j] = matrix[i][n-1-j];
                        matrix[i][n-1-j] = temp;
                }
            }
        return matrix;
    }

    static int[][] setMatrixZeros(int[][] matrix, int n, int m) {
        //Brute Force Approach
        //Mark all 1 to -1, who are coming in range of 0 in columns and rows
            /*for (int i = 0;i<n;i++) {
                for (int j = 0;j<m;j++) {
                        if (matrix[i][j] == 0) {
                            markRows(i,n, matrix);
                            markColm(j,m, matrix);
                        }
                }
            }
            //Now traverse the matrix and change all -1 to 0
            for (int i = 0;i<n;i++) {
                for (int j = 0;j<m;j++) {
                        if (matrix[i][j] == -1)
                            matrix[i][j] = 0;
                }
            }
        return matrix;*/

        //Better Approach
        /*int col[] = new int[m];
        int row[] = new int[n];
        //Now traverse and mark in arrays above
            for (int i = 0;i<n;i++) {
                for (int j = 0;j<m;j++) {
                    if (matrix[i][j] == 0) {
                        row[i] = 1;
                        col[j] = 1;
                    }
                }
            }
            //Now traverse the matrix and check where in row and col array it is marked as 1, than make the 1 as zero in matrix
                for (int i = 0;i<n;i++) {
                    for (int j = 0;j<m;j++) {
                            if (row[i] == 1 || col[j] == 1) {
                                matrix[i][j] = 0;
                            }
                    }
                }
        return matrix;*/

        //Optimal Approach
        //Time Complexity will be same as Better, just in optimal, we will reduce space complexity to O(1)
            //int col[] = new int[m];   matrix[0][...]
            //int row[] = new int[n];   matrix[...][0]
        int col0 = 1;
                for (int i = 0;i<n;i++) {
                    for (int j = 0;j<m;j++) {
                            if (matrix[i][j] == 0) {
                                //mark ith row
                                    matrix[i][0] = 0;
                                //mark jth col
                                        if (j != 0)
                                            matrix[0][j] = 0;
                                        else
                                            col0 = 0;
                            }
                    }
                }
                //Now move from matrix[1][1] to convert 1 to 0, that are marked above
                for (int i = 1;i<n;i++) {
                    for (int j = 1;j<m;j++) {
                            if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                                matrix[i][j] = 0;
                            }
                    }
                }
                //Finally mark the 1st col & then 1st row:
                if (matrix[0][0] == 0) {
                    //mark col
                    for (int j = 0;j<m;j++) {
                            matrix[0][j] = 0;
                    }
                }
                //now mark 1st row
                if (col0 == 0) {
                    for (int i = 0;i<n;i++) {
                        matrix[i][0] = 0;
                    }
                }
        return matrix;
    }
    //Mark Rows with -1
    static void markRows(int i, int n, int[][] matrix) {
        for (int j = 0;j<n;j++) {
                if (matrix[i][j] != 0)
                    matrix[i][j] = -1;
        }
    }
    //Mark Columns with -1
    static void markColm(int j, int m, int[][] matrix) {
        for (int i = 0;i<m;i++) {
            if (matrix[i][j] != 0)
                matrix[i][j] = -1;
        }
    }

    static List spiralMatrix(int[][] matrix, int n, int m) {
        int top = 0, left = 0, right = m-1, bottom = n-1;
        List<Integer> list = new ArrayList<>();
        while (top<=bottom && left<=right) {
            //left -> right
                for (int i = left;i<=right;i++) {
                    list.add(matrix[top][i]);
                }
                top++;
            //top -> bottom
                for (int i = top;i<=bottom;i++) {
                    list.add(matrix[i][right]);
                }
                right--;
            //right -> left
            if (top<=bottom) {
                for (int i = right;i>=left;i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            //bottom -> top
            if (left<=right) {
                for (int i = bottom;i>=top;i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }

    static int countSubArraySumEqualK(int a[], int n) {
        //Brute Force Approach 1 -- Time Complexity O(N3)
        int count = 0, target = 3;
            /*for (int i = 0;i<n;i++) {
                for (int j = i;j<n;j++) {
                    int sum = 0;
                        for (int k = i;k<=j;k++) {
                                sum = sum + a[k];
                        }
                        if (sum == target) {
                            count++;
                        }
                }
            }*/

        //Brute Force Approach 2 -- Time Complexity O(N2)
            /*for (int i = 0;i<n;i++) {
                int sum = 0;
                for (int j = i;j<n;j++) {
                    sum = sum + a[j];
                        if (sum == target) {
                            count++;
                        }
                }
            }*/

        //Optimal Approach
        //Use Hashing technique, use hash map and store prefixSum and count in map
        int prefixSum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
            for (int i = 0;i<n;i++) {
                prefixSum = prefixSum + a[i];
                int rem = prefixSum - target;
                    if (map.containsKey(rem)) {
                        count = count + map.get(rem);
                    }
                map.put(prefixSum,map.getOrDefault(prefixSum,0) + 1);
            }
      return count;
    }

    static List<Integer> findMajorityN3Elements(int nums[], int n) {
        //Brute Force Approach
        /*int half3 = n/3;
        List<Integer> list = new ArrayList<>();
            for (int i = 0;i<n;i++) {
                int count = 1, flag = 0;
                for (int j = i+1;j<n;j++) {
                        if (a[i] == a[j]) {
                            count++;
                            flag = 1;
                        }
                }
                if (flag == 1 && count > half3 ) {
                    if (list.size() == 0 || list.get(list.size()-1) != a[i])
                            list.add(a[i]);
                }
            }
        return list;*/

        //Better Approach
        /*List<Integer> list = new ArrayList<>();
        int half3 = n/3;
        int hashArray[] = new int[34];
            for (int i = 0;i<a.length;i++) {
                hashArray[a[i]] += 1;
            }

            for (int i = 0;i<hashArray.length;i++) {
                if (hashArray[i] > half3)
                    list.add(i);
            }
        return list;*/

        //Better Approach 2 : Using HashMap
        /*int half3 = n/3;
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new LinkedHashMap<>();
            for (int i = 0;i<n;i++) {
                    if (map.containsKey(a[i]) == false)
                            map.put(a[i],1);
                    else {
                        int oldValue = map.get(a[i]);
                        int newValue = oldValue + 1;
                        map.put(a[i],newValue);
                    }
            }
        for (Map.Entry<Integer,Integer> m : map.entrySet()) {
                if (m.getValue() > half3)
                    list.add(m.getKey());
        }
        return list;*/

        //Optimal Approach
        List<Integer> list = new ArrayList<>();
        int count1 = 0, count2 = 0, ele1 = -1, ele2 = -1;
        int mini = n/3;
        for (int i = 0;i<n;i++) {
            if (count1 == 0 && ele2 != nums[i]) {
                count1 = 1;
                ele1 = nums[i];
            }
            else if (count2 == 0 && ele1 != nums[i]) {
                count2 = 1;
                ele2 = nums[i];
            }
            else if (nums[i] == ele1)
                count1++;
            else if (nums[i] == ele2)
                count2++;
            else {
                count1--;
                count2--;
            }

        }
        int count3 = 0, count4 = 0;
        for (int i = 0;i<n;i++) {
            if (nums[i] == ele1)
                count3++;
            if (nums[i] == ele2)
                count4++;
        }

        if (count3 > mini && ele1 != ele2)
            list.add(ele1);
        if (count4 > mini)
            list.add(ele2);

        return list;
    }

    static List<List<Integer>> find3Sum(int a[], int n) {
        //Brute Force Approach
        /*Set<List<Integer>> set = new HashSet<>();
            for (int i = 0;i<n;i++) {
                for (int j = i+1;j<n;j++) {
                    for (int k = j+1;k<n;k++) {
                            if (a[i] + a[j] + a[k] == 0) {
                                List<Integer> temp = java.util.Arrays.asList(a[i],a[j],a[k]);
                                Collections.sort(temp);
                                set.add(temp);
                        }
                    }
                }
            }
        List<List<Integer>> list = new ArrayList<>(set);
    return list;*/

        //Better Approach
         /*Set<List<Integer>> set = new HashSet<>();
            for (int i = 0; i<n; i++) {
                Set<Integer> checkThird = new HashSet<>();
                for (int j = i+1; j<n; j++) {
                        int third = - (a[i] + a[j]);
                            if (checkThird.contains(third)) {
                                List<Integer> temp = java.util.Arrays.asList(a[i], a[j], third);
                                Collections.sort(temp);
                                set.add(temp);
                            }
                            checkThird.add(a[j]);
                }
            }
            System.out.println("k");
            List<List<Integer>> list = new ArrayList<>(set);
            return list;*/

        //Optimal Approach
        //Use Two Pointer
        List<List<Integer>> list = new ArrayList<>();
        java.util.Arrays.sort(a);
        for (int i = 0; i<a.length; i++) {
            if (i > 0 && a[i] == a[i-1])
                continue;
            int j = i + 1, k = a.length-1;
            while (j < k) {
                int sum = a[i] + a[j] + a[k];
                if (sum < 0) {
                    j++;
                }
                else if (sum > 0) {
                    k--;
                }
                else {
                    List<Integer> temp = java.util.Arrays.asList(a[i],a[j],a[k]);
                    list.add(temp);
                    j++;
                    k--;
                    while (j < k && a[j] == a[j-1]) j++;
                    while (j < k && a[k] == a[k+1]) k--;
                }
            }
        }
        return list;
}

    static List<List<Integer>> find4Sum(int a[], int n) {
        //Brute Force Approach
        /*Set<List<Integer>> set = new HashSet<>();
        int target = 9;
            for (int i = 0; i < n ; i++) {
                for (int j = i+1; j<n; j++) {
                    for (int k = j + 1; k<n; k++) {
                        for (int l = k + 1; l<n; l++) {
                            if (a[i] + a[j] + a[k] + a[l] == 9) {
                                List<Integer> temp = java.util.Arrays.asList(a[i],a[j],a[k],a[l]);
                                Collections.sort(temp);
                                set.add(temp);
                            }
                        }
                    }
                }
            }
        List<List<Integer>> list = new ArrayList<>(set);
        return list;*/

        //Better Approach
        /*int target = 0;
        Set<List<Integer>> set = new HashSet<>();
            for (int i = 0; i<n; i++) {
                for (int j = i+1; j<n; j++) {
                    Set<Long> checkFourth =  new HashSet<>();
                    for (int k = j+1; k<n; k++) {
                        //Take long type so that integer limit is not crossed
                            long sum = a[i] + a[j];
                            sum = sum + a[k];
                            long fourth = target - sum;
                        if (checkFourth.contains(fourth)) {
                            List<Integer> temp = java.util.Arrays.asList(a[i],a[j],a[k],(int)fourth);
                            Collections.sort(temp);
                            set.add(temp);
                        }
                        checkFourth.add((long)a[k]);
                    }
                }
            }
        List<List<Integer>> list = new ArrayList<>(set);
            return list;*/

        //Optimal Approach
        int target = 0;
        java.util.Arrays.sort(a);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            if (i > 0 && a[i] == a[i-1])
                continue;
            for (int j = i + 1; j<n; j++) {
                if (j > i+1 && a[j] == a[j-1])
                    continue;
                int k = j+1;
                int l = n-1;
                while (k < l) {
                    long sum = a[i] + a[j];
                    sum = sum + a[k];
                    sum = sum + a[l];
                    if (sum < target)
                        k++;
                    else if (sum > target)
                        l--;
                    else {
                        List<Integer> temp = java.util.Arrays.asList(a[i], a[j], a[k], a[l]);
                        list.add(temp);
                        k++;
                        l--;
                        while (k < l && a[k] == a[k-1]) k++;
                        while (k < l && a[l] == a[l+1]) l--;
                    }
                }
            }
        }
        System.out.println("m");
        return list;
    }

    static int findLengthOfLongestSubArrayWithSumZero(int a[], int n) {
        //Brute Force Approach
       /* int maxLen = 0;
            for (int i = 0; i<n; i++) {
                for (int j = i; j<n; j++) {
                        int sum = 0;
                    for (int k = i; k<=j; k++) {
                            sum = sum + a[k];
                    }
                    if (sum == 0)
                        maxLen = Math.max(maxLen, j-i+1);
                }
            }
        return maxLen;*/

        //Better Approach
        /*int maxLen = 0;
            for (int i = 0; i<n; i++) {
                    int sum = 0;
                for (int j = i; j<n; j++) {
                      sum = sum + a[j];
                        if (sum == 0)
                            maxLen = Math.max(maxLen, j-i+1);
                }
            }
        return maxLen;*/

        //Optimal Approach
        int maxLen = 0, sum = 0, prefixSum = 0;
        Map<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i<n; i++) {
                prefixSum = prefixSum + a[i];
                    if (prefixSum == 0) {
                        maxLen = i + 1;
                    }
                    if (map.containsKey(prefixSum)) {
                        int index = map.get(prefixSum);
                        maxLen = Math.max(maxLen, i-index);
                    } else {
                        map.put(prefixSum,i);
                    }

            }
        return maxLen;
    }

    static List<Integer> mergeOverlappingIntervals(int a[], int n) {
        List<Integer> list = new ArrayList<>();

        return list;
    }

    static void mergeTwoSortedArrays(int a1[], int n) {
        int a2[] = {2,3,9};
        int m = 3;
        //Brute Force Approach with extra space
            /*int a3[] = new int[n+m];
            int left = 0, right = 0, index = 0;
                while (left < n && right < m) {
                    if (a1[left] <= a2[right]) {
                        a3[index] = a1[left];
                        left++; index++;
                    } else {
                        a3[index] = a2[right];
                        right++; index++;
                    }
                }
                while (left < n) {
                    a3[index] = a1[left];
                    index++; left++;
                }
                while (right < m) {
                    a3[index] = a2[right];
                    index++; right++;
                }
            //Now place elements in a1 and a2
                for (int i = 0; i<n+m; i++) {
                    if (i<n)
                        a1[i] = a3[i];
                    else
                        a2[i-n] = a3[i];
                }
            //printing array 1 and array 2
                for (int i = 0; i<n; i++) {
                    System.out.print(a1[i] + " ");
                }
                System.out.println();
                for (int i = 0; i<m; i++) {
                    System.out.print(a2[i] + " ");
                }*/

        //Optimal Approach
        int left = n-1, right = 0;
        while (left >=0 && right < m) {
            if (a1[left] > a2[right]) {
                int temp = a1[left];
                a1[left] = a2[right];
                a2[right] = temp;
                left--;
                right++;
            }
            else
                break;
        }
        //now sort the arrays
        java.util.Arrays.sort(a1);
        java.util.Arrays.sort(a2);
    }
    static List<Integer> findMissingAndRepeatingNo(int a[], int n) {
        int repeat = -1, missing = -1;
        //Brute Force Approach
        /*
           for (int i = 1; i<=n; i++) {
                int count = 0;
               for (int j = 0; j<n; j++) {
                        if (a[j] == i)
                            count++;
               }
               if (count == 2)
                   repeat = i;
               else if (count == 0)
                   missing = i;

               if (repeat != -1 && missing != -1)
                   break;
           }
        List<Integer> list = new ArrayList<>();
           list.add(repeat);
           list.add(missing);*/

        //Better Approach : Use Hashing
        /*
        int hash[] = new int[n+1];
            for (int i = 0; i<n; i++) {
                    hash[a[i]]++;
            }
            for (int i = 0; i<hash.length; i++) {
                    if (hash[i] == 2)
                        repeat = i;
                    else if (hash[i] == 0)
                        missing = i;
            }*/

        //Optimal Approach : Use Simple Math to find x and y values using sum of n and sum of n square natural numbers
        int sN  = (n * (n+1)) / 2;
        int s2N = (n * (n+1)*(2*n+1)) / 6;
        int arraySum = 0, squareSum = 0;
            for (int i = 0; i<n; i++) {
                arraySum = arraySum + a[i];
                squareSum  = squareSum + (a[i] * a[i]);
            }
            //x-y
        int val1 = arraySum - sN;
            //x2-y2 = (x+y)(x-y) = val2
        int val2 = squareSum - s2N;
            val2 = val2 / val1;
        int x = (val1 + val2) / 2;  // x is repeating no
        int y = x - val1;          //  y is missing no

            List<Integer> list = new ArrayList<>();
            list.add(x);
            list.add(y);
        return list;
    }

    static int countInversions(int a[], int n) {
        //Brute Force Approach
        int count = 0;
            /*for (int i = 0; i<n; i++) {
                for (int j = i+1; j<n; j++) {
                        if (a[i] > a[j])
                            count++;
                }
            }
        return count;*/

        //Optimal Approach
        /*static int mergeSort(int a[], int low, int high) {
            int count = 0;
            if (low >= high)
                return count;
            int mid = (low + high) / 2;
            count = count + mergeSort(a,low,mid);
            count = count + mergeSort(a,mid+1,high);
            count = count + merge(a,low,mid,high);
            return count;
        }

        static int merge(int a[], int low, int mid, int high) {
            int count = 0;
            List<Integer> list = new ArrayList<>();
            int left = low;
            int right = mid+1;
            while (left <= mid && right <= high) {
                if (a[left] <= a[right]) {
                    list.add(a[left]);
                    left++;
                }
                else {
                    list.add(a[right]);
                    count = count + (mid-left+1);
                    right++;
                }
            }
            while (left <= mid) {
                list.add(a[left]);
                left++;
            }
            while (right <= high) {
                list.add(a[right]);
                right++;
            }

            for (int i=low;i<=high;i++) {
                a[i] = list.get(i-low);
            }*/
            return count;
    }

    static int reversePairs(int a[], int n) {
        //Brute Force Approach
        int count = 0;
            for (int i = 0; i<n; i++) {
                for (int j = i+1; j<n; j++) {
                        if (a[i] > 2*a[j]) {
                            count++;
                        }
                }
            }
        return count;

        //Optimal Approach : check coding ninja, link
    }

    static int findMaxProductArray(int a[], int n) {
        int max = -1;
        //Brute Force Approach
            /*for (int i = 0; i<n; i++) {
                for (int j = i; j<n; j++) {
                    int prod = 1;
                    for (int k = i; k<=j; k++) {
                        prod = prod * a[k];
                        max = Math.max(max,prod);
                    }
                }
            }*/

        //Better Approach
            /*for (int i = 0; i<n; i++) {
                int prod = 1;
                for (int j = i; j<n; j++) {
                    prod = prod * a[j];
                    max = Math.max(max,prod);
                }
            }*/

        //Oprimal Approach 1
        int prefix = 1, suffix = 1;
            for (int i = 0; i<n; i++) {
                    if (prefix == 0)
                        prefix = 1;
                    if (suffix == 0)
                        suffix = 1;
                prefix = prefix * a[i];
                suffix = suffix * a[n-i-1];
                max = Math.max(max,Math.max(prefix,suffix));
            }
    return max;
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
                //String x = findTwoSuminArray(a,n);
                    //System.out.println(x);

            //Sort an array of 0s, 1s and 2s
                //sortArrayOfZeroOneAndTwo(a,n);

            //find majority element that occurs N/2 time
                //int x =findMajorityElement(a,n);
                    //System.out.println(x);

            //find Maximum SubArray Sum
                //int x = findMaxSubArraySum(a,n);
                        //System.out.println(x);

            //buy and sell stocks
                //int x = buyAndSellStocks(a,n);
                        //System.out.println(x);

            //Rearrange Array Elements by Sign
               //int resultArray[] =  rearrangeArrayElement(a,n);
                    /*for (int i = 0;i<n;i++) {
                        System.out.print(resultArray[i] + " ");
                    }*/

            //leaders in Array
                //List leaders = findLeadersInArray(a,n);
                    /*for (int i = 0;i<leaders.size();i++) {
                        System.out.print(leaders.get(i) + " ");
                    }*/

            //max length of consequitive sequence
                //int x = findMaxConsequitiveLength(a,n);
                    //System.out.println(x);

            //rotate matrix by 90
            //int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
            //int n = 3, m = 3;
                //int rotated[][] = rotateMatrixBy90(matrix,n,m);
                    /*for (int i = 0;i<n;i++) {
                        for (int j = 0;j<m;j++) {
                            System.out.printf(rotated[i][j] + " ");
                        }
                        System.out.println();
                    }*/

            //set matrix zeros
            /*int matrix[][] = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
            int n = 3, m = 4;
                setMatrixZeros(matrix,n,m);
                    for (int i = 0;i<n;i++) {
                        for (int j = 0;j<m;j++) {
                            System.out.printf(matrix[i][j] + " ");
                        }
                        System.out.println();
                    }*/

             //spiral matrix
            /*int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
            int n = 4, m = 4;
            List list = spiralMatrix(matrix,n,m);
                for (int i = 0;i<list.size();i++) {
                    System.out.print(list.get(i) + " ");
                }*/

            //count subArray sum equals K
                //int x = countSubArraySumEqualK(a,n);
                        //System.out.println(x);

            //----------------------------Array Hard------------------------------------//

            //find majority N/3 elements
                /*List<Integer> list = findMajorityN3Elements(a,n);
                    for (Integer x : list) {
                        System.out.println(x);
                    }*/

            //3 Sum Problem to find unique triplets
                /* List<List<Integer>> list = find3Sum(a,n);
                    for (List<Integer> x : list) {
                        System.out.print(x);
                    }*/

            //4 Sum Problem to find Quads
        /*List<List<Integer>> list = find4Sum(a,n);
                    for (List<Integer> x : list) {
                        System.out.println(x);
                    }*/

            //find length of Longest SubArray whose sum is equal to zero
                /*int x = findLengthOfLongestSubArrayWithSumZero(a,n);
                    System.out.println(x);*/

            //Merge Overlapping intervals
                /*List<Integer> list = mergeOverlappingIntervals(a,n);
                    for (Integer x : list) {
                        System.out.println(x);
                    }*/

            //Merge Two sorted Arrays without extra space
                //mergeTwoSortedArrays(a,n);

            //find missing and repeating number
               /*List<Integer> list = findMissingAndRepeatingNo(a,n);
                    for (Integer x : list) {
                        System.out.print(x + " ");
                    }*/

            //count Inversions
                //int x = countInversions(a,n);
                    //System.out.println(x);

            //reverse pairs
                //int x = reversePairs(a,n);
                    //System.out.println(x);

            //maximum product subArray
                int x = findMaxProductArray(a,n);
                    System.out.println(x);
        }
}

import java.util.*;

public class Hashing {

    static void integerHashing() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i=0;i<n;i++) {
            a[i] = sc.nextInt();
        }
        //pre compute
        int hash[] = new int[13];
        for (int i=0;i<13;i++) {
            hash[i] = 0;
        }
        //storeArrayValuesinHashArray
        for (int i=0;i<n;i++) {
            hash[a[i]] += 1;
        }
        int q = sc.nextInt();
        for (int i=q;i>=1;i--) {
            int queryNumbers = sc.nextInt();
            System.out.println(hash[queryNumbers]);
        }
    }

    static void characterHashing() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = "abcadbe";
            //pre store
        int hash[] = new int[26];
            for (int i=0;i<26;i++) {
                hash[i] = 0;
            }
            //storing characters in hash array
            for (int i=0;i<n;i++) {
                hash[s.charAt(i)-'a']++;
            }
            //fetch
        int q = sc.nextInt();
            while (q>0) {
                String queries = sc.next();
                System.out.println(hash[queries.charAt(0)-'a']);
                q--;
            }
    }

    static void integerHashingUsingMap() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
            for (int i=0;i<n;i++) {
                arr[i] = sc.nextInt();
            }
        // storing array values in map and calculating frequency
                // pre storing
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<n;i++) {
               if (!map.containsKey(arr[i]))
                   map.put(arr[i],1);
               else {
                   int oldValue = map.get(arr[i]);
                   int newValue = oldValue + 1;
                   map.put(arr[i],newValue);
               }
        }
            /*for (Map.Entry<Integer,Integer> m : map.entrySet()) {
                System.out.println(m.getKey() + " " + m.getValue());
            }*/
                // fetching
        int q = sc.nextInt();
            while(q>0) {
                int queries = sc.nextInt();
                    if (map.containsKey(queries))
                        System.out.println(map.get(queries));
                    else
                        System.out.println("0");
                q--;
            }
    }

    static void findHighestAndLowestFrequenyUsingMap() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
            for (int i=0;i<n;i++) {
                arr[i] = sc.nextInt();
            }
                // storing array values in map and calculating frequency
        Map<Integer,Integer> map = new HashMap<>();
            for (int i=0;i<n;i++) {
                if (!map.containsKey(arr[i]))
                    map.put(arr[i],1);
                else {
                    int oldValue = map.get(arr[i]);
                    int newValue = oldValue + 1;
                    map.put(arr[i], newValue);
                }
            }
        // calculating highest and lowest frequency of value in the map
        int maxFreq = 0, minFreq = n, maxEle = 0, minEle = 0;
            for (Map.Entry<Integer,Integer> m : map.entrySet()) {
                int value = m.getValue();
                int key = m.getKey();
                    if (value > maxFreq) {
                        maxFreq = value;
                        maxEle  = key;
                    }
                    if (value < minFreq) {
                        minFreq = value;
                        minEle  = key;
                    }
            }
        System.out.println("Max fre and maxEle:" + maxFreq + " " + maxEle);
        System.out.println("Min fre and minEle:" + minFreq + " " + minEle);
    }

    public static void main(String[] args) {
        //integerHashing();
        //characterHashing();
        //integerHashingUsingMap();
        findHighestAndLowestFrequenyUsingMap();
    }
}